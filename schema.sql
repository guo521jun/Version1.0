create database `ec` default charset = utf8;

use `ec`;
#用户表
create table if not exists `users`(
	`id` int(11) auto_increment comment '用户id',
	`name` varchar(60) not null comment '用户名',
	`password` varchar(80) not null comment '密码',
	`age` int(3) not null comment '年龄',
	primary key(`id`)
)engine=innodb default character set utf8;

#插入记录
INSERT INTO `users` (`name`, `password`, `age`) VALUES ('科比', '818181', 36);
INSERT INTO `users` (`name`, `password`, `age`) VALUES ('詹姆斯', '666666', 32);
INSERT INTO `users` (`name`, `password`, `age`) VALUES ('库里', '88888888', 28);
INSERT INTO `users` (`name`, `password`, `age`) VALUES ('保罗', '123456', 39);
INSERT INTO `users` (`name`, `password`, `age`) VALUES ('杜兰特', '123456', 35);


#商品表
create table if not exists `products`(
	`id` int(11) auto_increment comment '商品id',
	`name` varchar(32) not null comment '商品名',
	`price` decimal(10,2) not null comment '商品价格',
	`stock` bigint not null comment '库存',
	`description` varchar(80) not null comment '商品描述',
	primary key(`id`)
)engine=innodb default character set utf8;

#插入数据
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('华为荣耀i5', 3669.9, 100, '你值得拥有!');
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('魅族', 2666.8, 200, 'flyme畅玩!');
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('苹果手机', 6999.9, 20, '安全性极高的一款手机!');
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('小米手机', 3266.8, 60, '一款可以使你发烧的手机!');
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('三星手机', 5266.9, 160, '尽享奢华!');
INSERT INTO `products` (`name`, `price`, `stock`, `description`) VALUES ('华为p6', 6666.9, 10, '你值的拥有!');