Introduction <br/><br/>
    • The Ecommerce Application is a web-based platform built using Angular, Spring Boot, and MySQL. It allows users to register, login, browse products, add them to the cart, place orders, and utilize the Super Cart feature to track product prices and receive notifications when the desired price is reached. This document serves as a comprehensive guide to understanding and utilizing the application.<br/>
<br/><br/>Registration and Login <br/><br/>
  => Registration <br/>
    • New users can register by providing their personal information such as name, email address, and password. <br/>
    • Upon successful registration, users are granted a unique account in the system. <br/>
 <br/> => Login <br/>
    • Registered users can log in using their email address and password. <br/>
    • After successful login, users gain access to their personalized account. <br/><br/>
Product Catalog <br/><br/>
    • Users can browse the product catalog to view available products.<br/>
    • Product listings include details such as name, description, price, and an option to add the product to the cart.<br/>
    • Filters and search functionality can be used to narrow down product options.
<br/><br/>Cart Management<br/><br/>
    • Users can add products to their cart while browsing the catalog.<br/>
    • The cart displays the selected products, along with their quantities and prices.<br/>
    • Users can update the quantity of products or remove them from the cart.<br/>
    • The cart also provides a checkout option to place an order.<br/><br/>
Order Placement<br/><br/>
    • Users can proceed to place an order from the cart.<br/>
    • They need to provide their shipping information, including address and contact details.<br/>
    • Once the order is confirmed, the application generates an order ID for tracking purposes.<br/><br/>
Super Cart and Price Tracking<br/><br/>
    • Users can choose to add a product to the Super Cart.<br/>
    • In the Super Cart, users can specify their desired price for the product.<br/>
    • The application continuously monitors the product's price.<br/>
    • If the product's price falls below the desired price, the user is notified via email.<br/><br/>
Automatic Order Placement<br/><br/>
    • If the user does not purchase the product after being notified, the application automatically places an order on their behalf.<br/>
    • A specific time limit is set after the notification for the user to take action.<br/>
    • If the user fails to make a purchase within the specified time, the order is generated automatically.<br/><br/>
Technology Stack<br/><br/>
    • Front-end: Angular<br/>
    • Back-end: Spring Boot<br/>
    • Database: MySQL<br/><br/><br/>

