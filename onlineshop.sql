/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : onlineshop

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-12-22 12:00:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `n_time` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total` double(20,0) DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `orderstate` varchar(20) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_order` (`user_id`),
  CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double(20,2) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `pnum` int DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `salenum` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '《万万没想到》', '26.50', '少儿,漫画', '20', '../img/万万没想到.jpg', '10');
INSERT INTO `product` VALUES ('2', '《岛》', '30.00', '少儿,漫画', '20', '../img/岛.png', '8');
INSERT INTO `product` VALUES ('3', '《戴高乐将军》', '30.00', '社科,人物传记', '20', '../img/戴高乐将军.jpg', '30');
INSERT INTO `product` VALUES ('4', '《疯犬少年的天空》', '35.50', '文学,小说', '15', '../img/疯犬少年的天空.jpg', '15');
INSERT INTO `product` VALUES ('5', '《紫金陈刑侦推理三部曲》', '59.00', '文学,小说', '20', '../img/紫金陈刑侦推理三部曲.jpg', '10');
INSERT INTO `product` VALUES ('6', '《活着》', '30.00', '文学,小说', '40', '../img/活着.jpg', '50');
INSERT INTO `product` VALUES ('7', '《撒哈拉的故事》', '26.05', '文学,散文', '40', '../img/撒哈拉的故事.jpg', '32');
INSERT INTO `product` VALUES ('8', '《考研政治》', '15.00', '教育,考试', '10', '../img/考研政治.jpg', '43');
INSERT INTO `product` VALUES ('9', '《你的孤独虽败犹荣》', '35.00', '文学,散文', '50', '../img/你的孤独虽败犹荣.jpg', '38');
INSERT INTO `product` VALUES ('10', '《速成围棋》', '21.00', '教育,体育', '20', '../img/速成围棋.jpg', '16');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jack123', '12345678', 'male', 'jack@qq.com', '4300182');
INSERT INTO `user` VALUES ('2', 'Jerry3309', '12345678', 'male', 'Jerry3309@163.com', '13786457890');
