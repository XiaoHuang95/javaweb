/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : onlineshop

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-01-09 16:07:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `pid` int DEFAULT NULL,
  `pnum` int DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('28', '1', '6', '1', '《活着》', '30.00');
INSERT INTO `cart` VALUES ('29', '1', '4', '1', '《疯犬少年的天空》', '35.50');

-- ----------------------------
-- Table structure for `myorder`
-- ----------------------------
DROP TABLE IF EXISTS `myorder`;
CREATE TABLE `myorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total` double(20,2) DEFAULT NULL,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `ordertime` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_order` (`user_id`),
  CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myorder
-- ----------------------------
INSERT INTO `myorder` VALUES ('6', '35.50', '湖南省长沙市', 'jack', '13786451409', '2020年/12月/24日 12时:21分:26秒', '1', '已支付');
INSERT INTO `myorder` VALUES ('8', '30.00', '湖南省长沙市', 'jack', '13475669254', '2020年/12月/24日 13时:07分:34秒', '1', '已支付');
INSERT INTO `myorder` VALUES ('9', '35.50', '湖南省长沙市', 'Jerry', '318641994719', '2020年/12月/24日 13时:49分:28秒', '1', '未支付');
INSERT INTO `myorder` VALUES ('11', '242.00', '湖南省长沙市', 'jack', '13786451409', '2020年/12月/24日 15时:32分:05秒', '1', '未支付');

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
INSERT INTO `product` VALUES ('1', '《万万没想到》', '26.50', '少儿,漫画', '19', '../img/万万没想到.jpg', '11');
INSERT INTO `product` VALUES ('2', '《岛》', '30.00', '少儿,漫画', '20', '../img/岛.png', '8');
INSERT INTO `product` VALUES ('3', '《戴高乐将军》', '30.00', '社科,人物传记', '20', '../img/戴高乐将军.jpg', '30');
INSERT INTO `product` VALUES ('4', '《疯犬少年的天空》', '35.50', '文学,小说', '4', '../img/疯犬少年的天空.jpg', '26');
INSERT INTO `product` VALUES ('5', '《紫金陈刑侦推理三部曲》', '59.00', '文学,小说', '18', '../img/紫金陈刑侦推理三部曲.jpg', '12');
INSERT INTO `product` VALUES ('6', '《活着》', '30.00', '文学,小说', '38', '../img/活着.jpg', '52');
INSERT INTO `product` VALUES ('7', '《撒哈拉的故事》', '26.05', '文学,散文', '40', '../img/撒哈拉的故事.jpg', '32');
INSERT INTO `product` VALUES ('8', '《考研政治》', '15.00', '教育,考试', '7', '../img/考研政治.jpg', '46');
INSERT INTO `product` VALUES ('9', '《你的孤独虽败犹荣》', '35.00', '文学,散文', '48', '../img/你的孤独虽败犹荣.jpg', '40');
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
INSERT INTO `user` VALUES ('1', 'jack123', '123456789', 'male', 'jack@qq.com', '4300182');
INSERT INTO `user` VALUES ('2', 'Jerry3309', '12345678', 'male', 'Jerry3309@163.com', '13786457890');
