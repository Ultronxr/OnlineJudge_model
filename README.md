# 小学在线随机出题与生成答案自测系统

## [仓库链接](https://github.com/Ultronxr/OnlineJudge_model)

## [演示网址](http://120.79.37.194/onlinejudge/)

## 以下是本系统使用的sql语句：

```sql

CREATE DATABASE `oj_db` DEFAULT CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'


CREATE TABLE `admin`(
    `id` int(10) PRIMARY KEY NOT NULL, #设置自增
    `username` varchar(100) NOT NULL,
    `password` varchar(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `user`(
    `id` int(10) PRIMARY KEY NOT NULL, #设置自增
    `school_id` varchar(100) NOT NULL,
    `password` varchar(100) NOT NULL,
    
    `name` varchar(50) NULL,
    `sex` varchar(50) NULL,
    `grade` varchar(50) NULL,
    `classs` int(10) NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8


INSERT INTO `admin` (username, password) VALUES('admin1','e10adc3949ba59abbe56e057f20f883e')

INSERT INTO `user` (school_id, password, name, sex, grade, classs) VALUES('000001','e10adc3949ba59abbe56e057f20f883e','学生1','男','三年级',2)

UPDATE `user` SET name='测试员',sex='女',grade='六年级',classs='3' WHERE school_id='123'



CREATE TABLE `poetry`(
	`id` int(10) PRIMARY KEY NOT NULL, #设置自增
	`title` varchar(255) NULL,
	`dynasty` varchar(255) NULL,
	`author` varchar(255) NULL,
	`content` varchar(500) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO `poetry` (title,dynasty,author,content) 
VALUES('山村咏怀', '宋', '邵雍', '一去二三里，烟村四五家。亭台六七座，八九十枝花。')

SELECT * FROM `poetry`


```

