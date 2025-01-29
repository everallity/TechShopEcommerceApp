drop database if exists techshop;

create database techshop;

use techshop;

create table Account(
Account_ID int auto_increment,
Username varchar(50) not null,
Email varchar(50) not null,
Password varchar(50) not null,
Type int not null,
constraint PK_Account_ID primary key (Account_ID)
);

create table Client(
Client_ID int auto_increment,
Name nvarchar(50),
Address nvarchar(50),
Phone varchar(50),
Gender nvarchar(50),
Dob varchar(50),
Account_ID int not null,
constraint PK_Client_ID primary key (Client_ID),
constraint FK_Client_Account foreign key (Account_ID) references Account(Account_ID)
);

create table Staff(
Staff_ID int auto_increment,
Name nvarchar(50),
Address nvarchar(50),
Dob varchar(50),
Position nvarchar(50),
Phone varchar(50),
Gender nvarchar(50),
Salary float,
Account_ID int not null,
constraint PK_Staff_ID primary key (Staff_ID),
constraint FK_Staff_Account foreign key (Account_ID) references Account(Account_ID) 
);


insert into Account(Username,Password,Email,Type) values ('duc','123abc','duc@gmail.com',1);
insert into Account(Username,Password,Email,Type) values ('son','123abc','son@gmail.com',1);
insert into Staff(Name,Address,Dob,Position,Phone,Gender,Salary,Account_ID) values ('Đức','Hà Nội','12/12/2000','Admin','0989897953','Nam',2000000,1);
insert into Staff(Name,Address,Dob,Position,Phone,Gender,Salary,Account_ID) values ('Sơn','Thành phố Hồ Chí Minh','15/12/2000','Emnployee','0923232423','Nữ',2000000,2);

insert into Account(Username,Password,Email,Type) values ('trang','123abc','trang@gmail.com',2);
insert into Account(Username,Password,Email,Type) values ('tram','123abc','tram@gmail.com',2);
insert into Client(Name,Address,Phone,Gender,Dob,Account_ID) values ('Trang','Hà Nội','034242424','Nữ','23/04/1999',3);
insert into Client(Name,Address,Phone,Gender,Dob,Account_ID) values ('Trâm','Hà Nội','05464642424','Nữ','23/05/1992',4);
create table Product(
Product_ID int auto_increment,
Name varchar(50) not null,
Brand varchar(50) not null,
Category varchar(50) not null,
Image text,
Price float not null,
Stock int not null,
Description text,
constraint PK_Product_ID primary key (Product_ID)
);

insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('PS4','Sony','Console','http://localhost:8080/images/Ps4.png',599.99,123,'CPU:asdf\nGPU:asdfasd');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('PS5','Sony','Console','http://localhost:8080/images/Ps5.png',599.99,123,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('PS3','Sony','Console','http://localhost:8080/images/png-transparent-playstation-2-playstation-3-buzz-the-ultimate-music-quiz-lego-marvel-super-heroes-room-with-a-view-howards-end-maurice-electronics-electronic-device-playstation.png',599.99,123,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('PS2','Sony','Console','http://localhost:8080/images/png-transparent-playstation-2-playstation-3-super-nintendo-entertainment-system-video-game-consoles-playstation-2-game-electronics-gadget-thumbnail.png',599.99,123,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('Iphone 15 Pro Max','Apple','Phone','http://localhost:8080/images/15pmxanh.png',999.99,99,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('Nintendo Switch','Nintendo','Console','http://localhost:8080/images/png-transparent-nintendo-switch-pro-controller-classic-controller-splatoon-2-joy-con-nintendo-electronics-nintendo-video-game-thumbnail.png',399.0,123,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('Xbox Series X','Microsoft','Console','http://localhost:8080/images/fbd2cb56-5c25-414d-9f46-e6a164cdf5be.png',399.0,123,'');
insert into Product(Name,Brand,Category,Image,Price,Stock,Description) values ('Xbon Series S','Microsoft','Console','http://localhost:8080/images/6297450e-4d5d-4b0b-a16c-7221c3a113df.png',299.0,123,'');

create table Cart(
Cart_ID int auto_increment,
Final_Amount float not null default 0,
Client_ID int not null,
constraint PK_Cart_ID primary key (Cart_ID),
constraint FK_Cart_Client foreign key (Client_ID) references Client(Client_ID)
);
create table CartItem(
CartItem_ID int auto_increment,
Quantity int not null,
Total_Amount float not null,
Product_ID int not null,
Cart_ID int not null,
constraint PK_CartItem_ID primary key (CartItem_ID),
constraint FK_CartItem_Product foreign key (Product_ID) references Product(Product_ID),
constraint FK_CartItem_Cart foreign key (Cart_ID) references Cart(Cart_ID)
);

insert into Cart(Client_ID) values (1);
insert into Cart(Client_ID) values (2);

create table Orders(
Order_ID int auto_increment,
Shipping_Address nvarchar(50) not null,
Shipping_Fee float not null,
Order_Status nvarchar(50) not null,
Total_Amount float not null,
Create_At varchar(50) not null,
Client_ID int not null,
constraint PK_Order_ID primary key (Order_ID),
constraint FK_Order_Client foreign key (Client_ID) references Client(Client_ID) 
);
create table OrderItem(
OrderItem_ID int auto_increment,
Quantity int not null,
Total_Amount float not null,
Product_ID int not null,
Order_ID int not null,
constraint PK_OrderItem_ID primary key(OrderItem_ID),
constraint FK_OrderItem_Product foreign key (Product_ID) references Product(Product_ID) on delete cascade,
constraint FK_OrderItem_Order foreign key (Order_ID) references Orders(Order_ID) on delete cascade
);
