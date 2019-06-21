Система Ресторан. 
Клиент осуществляет заказ из Меню.
Администратор подтверждает Заказ и отправляет его на кухню для исполнения.
Администратор выставляет Счет. 
Клиент производит его оплату. 

To configure the connection to the database, copy the context.xml file to the Tomcat/conf directory
your server. You also need to create a database and add the administrator to the table users (3rd normal form) on the MySQL server with the help of
Scripts - file restaurant.sql. Compile the project into war and deploy it into your Tomcat server.
