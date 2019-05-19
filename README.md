# DBengers

### Installation manual for Melon Database - DBengers

------

1. set up eclipse and JDK environment in your local

   > eclipse : <https://www.eclipse.org/downloads/>

   > jdk : <https://www.oracle.com/technetwork/java/javase/downloads/index.html>

2. download JAVA code in your workspace

   - ```git clone https://github.com/forcallinghenney/DBengers.git```

3. download MySQL

   - go to www.mysql.com - downloads - community
   - if Window, download on Windows
   - if Mac, go to MySQL community server, download **dmg file** and install MySQL

4. download MySQL connector

   - go to Connector/J
   - select platform independent
   - download **ZIP archive**
   - install

5. Connect MySQL to Eclipse

   - Java Project - Build path - configure build path
   - Libraries - add external jars - mysql-connector-java-***.jar
   - apply and close

6. Connect MySQL to terminal

   - open terminal
   - ```Brew install mysql```
   - ```mysql.server start```
   - ```mysql_secure_installation``` // set password for root
   - ```mysql -u root -p``` // start mysql
   - create database
     - ```CREATE DATABASE DBengers;```
   - create table
     - ```USE DBengers;```
     - ```CREATE TABLE ...```

7. connect MySQL server with your collaborators for cooperation (for host server owner)

   - set up database access of MySQL

     - login to using database
     - ```create user username@'%' identified by 'password';```
     - ```grant all privileges on database.tablename username@'%' identified by 'password';```
     - ```flush privileges;```

   - set up external access

     - open port

       - 

     - external access by multiple collaborators

       - ```mysql -h 172.17.***.** -u userid -p```
       - ```enter password```

       

