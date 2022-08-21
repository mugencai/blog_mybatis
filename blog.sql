/*
 Navicat Premium Data Transfer

 Source Server         : myblog
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 21/08/2022 23:00:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (115);

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint NOT NULL,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `views` int NULL DEFAULT NULL,
  `type_id` bigint NULL DEFAULT NULL,
  `user_id` bigint NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `tag_id` bigint NULL DEFAULT NULL,
  `tag_ids` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id` ASC) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id` ASC) USING BTREE,
  INDEX `FK7d9g13uphd94mhoxhw2eva2n3`(`tag_id` ASC) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK7d9g13uphd94mhoxhw2eva2n3` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (0, b'0', b'0', '# 私について\r\n----\r\njava開発エンジニアになりたい。\r\n\r\n## ✨スキル\r\n- バックエンド\r\n	- java: ssm框架，spring boot框架\r\n	- mysql\r\n\r\n- その他\r\n	- html，css，javascript\r\n	- bootstrap，segmentic ui\r\n	- tools\r\n		- maven， git\r\n		- markdown\r\n\r\n## 資格\r\n| 取得年月 | 資格          |\r\n| -------- | -------------- |\r\n| 2021.5   | 基本情報技術者　合格 |\r\n| 2021.9   | ITパスポート　合格    |\r\n| 2018.12  | 日本語能力試験1級 139点取得  |\r\n| 2018.7   | Toeic 740点取得   |\r\n\r\n\r\n## 言語\r\n- 中国語：ネイティブレベル\r\n- 日本語：日常会話レベル\r\n- 英語：ドキュメント読めるレベル\r\n\r\n## 学歴\r\n- 文系大学院卒業見込み（2023.3）', '2022-08-10 15:00:00.000000', 'https://picsum.photos/id/22/800/430', NULL, b'0', b'0', b'0', '私について', '2022-08-18 15:00:00.000000', 96, 2, 1, '自己紹介', NULL, '');
INSERT INTO `t_blog` VALUES (6, b'0', b'0', '個人用ブログを作ってみた', '2022-08-10 15:00:00.000000', 'https://picsum.photos/id/23/800/450', NULL, b'1', b'1', b'0', '個人用ブログを作ってみた', '2022-08-10 15:00:00.000000', 3, 48, 1, '個人用ブログを作ってみた', NULL, '1,0');
INSERT INTO `t_blog` VALUES (13, b'0', b'0', 'Atcoderで茶色になった振り返り', '2022-08-09 15:00:00.000000', 'https://picsum.photos/id/66/800/450', NULL, b'1', b'1', b'0', 'Atcoderで茶色になった振り返り', '2022-08-13 15:00:00.000000', 9, 2, 1, 'Atcoderで茶色になった振り返り', NULL, '2,3');
INSERT INTO `t_blog` VALUES (100, b'0', b'0', 'おすすめのウェブサイトについて', '2022-08-12 15:00:00.000000', 'https://picsum.photos/id/30/800/450', NULL, b'1', b'1', b'0', 'おすすめのウェブサイトについて', '2022-08-17 15:00:00.000000', 36, 48, 1, 'おすすめのウェブサイトについて', NULL, '4');
INSERT INTO `t_blog` VALUES (102, b'0', b'0', '## 常见操作\r\n\r\n```sql\r\n# 全选\r\nselect * from table1;\r\n# 选择列(保留重复行)\r\nselect t1, t2, t3 from table1;\r\n# 选择列（去除重复行）\r\nselect distinct t1, t2, t3 from table1;\r\n# 选择前两行\r\nselect * from table1 limit 2;\r\n# 分页，从startIndex开始，每页pagesize个数据\r\nselect * from table limit startIndex,pageSize;\r\n# 创建新字段\r\n\r\n# as 重命名\r\nselect column1 as column1_new, column2 as column2_new from table1;\r\n#修改列名\r\nalter table table1 change column1_old column1_new datatype_new;\r\n# , 是将字段分隔开的标志\r\n\r\n#where条件语句\r\nselect column1, column2 from table1 where column1 = \"傻冒\";\r\n#where模糊查询\r\nselect * from table where column1 like \"傻%\"; # 傻后面有其他字符\r\nselect * from table where column1 like \"%傻\"; # 傻前面有其他字符\r\nselect * from table where column1 like \"%傻%\"; # 傻前后面都有其他字符\r\nselect * from table where column1 not like \"%傻%\"; # 不包含\"傻\"字符\r\n\r\n#order by排序\r\nselect * from table1 order by column1, column2;\r\n# where 在前,order by 在后, 理由是where是筛选数据库，而order by是对筛选完的数据排序\r\n\r\n#functions聚合函数\r\nselect count(column1) from table1;\r\nselect sum(column1) from table1;\r\nselect avg(column1) from table1;\r\n\r\n#group by分组计算\r\nselect column1, sum(column1) from table1 group by column1;\r\n#having 分组筛选, group by后面不接where, 接having，原因是having用于聚合之后的筛选，where用于聚合之前的筛选。想在group by前面用where还是可以的\r\nselect column1, sum(column1) from table1 group by column1 having sum(column1) > 2\r\n\r\n#子查询\r\n#适用场景有两种，具体去牛客相关专题看\r\n\r\n#表连接\r\n#一种方法是where table1.id = table2.id的方式\r\n#另一种方法是用select ... from table1 inner/left/right join table2 on table1 = table2的方式\r\n#inner join, left join, right join\r\n#如果使用select ... from using 合并后去除重复的列\r\nselect * from table1 inner join table2 using (\"二傻\")\r\n#多表联结的写法有两种，更推荐第二种写法\r\n#写法1：https://www.nowcoder.com/practice/c7aa73afc41f4dfc925baebdd175c345?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DSQL%25E7%25AF%2587%26topicId%3D298、\r\n#写法2：\r\n https://www.nowcoder.com/practice/b5766f970ae64ac7944f37f5b47107aa?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DSQL%25E7%25AF%2587%26topicId%3D298\r\n\r\n\r\n#组合查询\r\n	#union联合查询\r\n    select column1, column2 from table1 where column1 = \"傻冒\" and column2 = \"在职\";\r\n    union \r\n    select column1, column2 from table1 where column1 = \"二傻\" and column2 = \"退休\";\r\n	#...where...or...\r\n\r\n```\r\n\r\n\r\n## 行的增删改操作\r\n\r\n```sql\r\n#行的增删改操作\r\n#补充：字符串用单引号\r\n\r\n# 增\r\n#insert\r\ninsert into table1 (字段1，字段2，字段3) values (值1， 值2， 值3)\r\n#replace(若和表中某UNI重合，那么先删去原有的行，再添加新行)\r\nreplace into table1 (字段1，字段2，字段3) values (值1， 值2， 值3)\r\n\r\n#改\r\n# 判断非空不是用=null,而是用is null\r\n#update\r\nupdate table1 set 字段1 = value1, 字段2 = value2 where ...\r\n\r\n#删\r\n#补充：datediff()不太好使，最好用timestampdiff(minute, starttime, endtime)\r\ndelete from table1 where ...\r\n#删除所有数据，并重置自增主键\r\ntruncate table table1;\r\n```\r\n\r\n## 表与索引操作\r\n\r\n```sql\r\n#表的创建\r\n#表的修改\r\n\r\n#表的删除\r\ndrop table table1;\r\n```\r\n\r\n## 常见函数\r\n\r\n```sql\r\n#条件函数\r\n#case条件语句\r\ncase when 条件1 then 分歧1 when 条件2 then 分歧2 when 条件3 then 分歧3 end\r\n#if条件语句\r\nif (条件，条件成立的分歧，条件不成立的分歧)\r\n\r\n#日期函数\r\n#提取日期的年份，月份，天\r\nyear(date), month(date), day(date)\r\n\r\n#字符串函数\r\n#按索引截取字符串，索引从1开始  substring(str, 开始索引，结束索引)\r\n#按关键字截取字符串 substring(str, 关键字， )\r\n#截取第1次出现\'_\'之前的字符串 substring_index(\'blog_url\', \'_\'，1)\r\n#截取倒数1次出现\'_\'之后的字符串 substring_index(\'blog_url\', \'_\', -1)\r\n#截取中间的字符串 substring_index(substring_index(profile, \',\', -2), \',\', 1)\r\n#字符串长度 length(str1)\r\n#字符串拼接\r\nconcat(str1, str2)\r\n```\r\n\r\n参考：\r\n\r\n[一篇文章入门MySQL](https://segmentfault.com/a/1190000018007929)\r\n', '2022-07-31 15:00:00.000000', 'https://picsum.photos/id/34/800/450', NULL, b'1', b'1', b'0', 'MySQL基本操作の振り返り', '2022-08-01 15:00:00.000000', 19, 48, 1, '趁着使用Mybatis开发博客的机会，重新回顾了一遍MySql的入门级指令。', NULL, '0,4');

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blog_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  INDEX `FK5feau0gb4lq47fdb03uboswm8`(`tag_id` ASC) USING BTREE,
  INDEX `FKh4pacwjwofrugxa9hpwaxg6mr`(`blog_id` ASC) USING BTREE,
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (13, 2);
INSERT INTO `t_blog_tags` VALUES (13, 3);
INSERT INTO `t_blog_tags` VALUES (13, 2);
INSERT INTO `t_blog_tags` VALUES (13, 3);
INSERT INTO `t_blog_tags` VALUES (102, 0);
INSERT INTO `t_blog_tags` VALUES (102, 4);
INSERT INTO `t_blog_tags` VALUES (100, 4);
INSERT INTO `t_blog_tags` VALUES (6, 1);
INSERT INTO `t_blog_tags` VALUES (6, 0);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_id` bigint NULL DEFAULT NULL,
  `parent_comment_id` int NULL DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKke3uogd04j4jx316m1p51e05u`(`blog_id` ASC) USING BTREE,
  INDEX `FK4jj284r3pb7japogvo6h72q95`(`parent_comment_id` ASC) USING BTREE,
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (0, 'SQL');
INSERT INTO `t_tag` VALUES (1, 'Java');
INSERT INTO `t_tag` VALUES (2, 'Python');
INSERT INTO `t_tag` VALUES (3, 'Atcoder');
INSERT INTO `t_tag` VALUES (4, '学習記録');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (2, 'アルゴリズム');
INSERT INTO `t_type` VALUES (48, 'ウェブ開発');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint NOT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '2022-07-03 18:07:24.000000', 'dotakufza@gmail.com', 'mugencai', '111111', 1, '2022-07-03 18:08:32.000000', 'mugencai', 'https://s3.bmp.ovh/imgs/2022/08/17/4f9a6253fe6fd4fa.jpg');

SET FOREIGN_KEY_CHECKS = 1;
