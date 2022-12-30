/*
 Navicat Premium Data Transfer

 Source Server         : myServer
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : 110.42.252.167:3306
 Source Schema         : user_table

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 30/12/2022 10:51:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment_test
-- ----------------------------
DROP TABLE IF EXISTS `comment_test`;
CREATE TABLE `comment_test`  (
  `id` int NOT NULL,
  `comment_time` datetime(6) NULL DEFAULT NULL,
  `comment_userid` int NULL DEFAULT NULL,
  `post_id` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `star_num` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_test
-- ----------------------------
INSERT INTO `comment_test` VALUES (2, '2022-12-29 15:23:39.538000', 3, 1, '沙发的沙发', 0);
INSERT INTO `comment_test` VALUES (3, '2022-12-29 17:03:02.827000', 11, 2, '恭喜阿根廷', 0);
INSERT INTO `comment_test` VALUES (4, '2022-12-29 17:12:48.796000', 8, 5, '原神怎么你了，差不多得了 屁大点事都要拐上原神', 0);
INSERT INTO `comment_test` VALUES (5, '2022-12-29 17:31:36.556000', 2, 5, '？', 0);
INSERT INTO `comment_test` VALUES (6, '2022-12-29 17:32:16.676000', 2, 3, '吃这个吃口腔溃疡了，大家别信他', 0);
INSERT INTO `comment_test` VALUES (7, '2022-12-29 17:32:25.107000', 2, 2, '恭喜阿根廷', 0);
INSERT INTO `comment_test` VALUES (8, '2022-12-29 17:32:35.139000', 2, 1, '沙发的沙发的沙发', 0);

-- ----------------------------
-- Table structure for forum_post_comments_id
-- ----------------------------
DROP TABLE IF EXISTS `forum_post_comments_id`;
CREATE TABLE `forum_post_comments_id`  (
  `forum_post_id` int NOT NULL,
  `comments_id` int NULL DEFAULT NULL,
  INDEX `FK2y24w86rgw959d5q6tehxomgt`(`forum_post_id` ASC) USING BTREE,
  CONSTRAINT `FK2y24w86rgw959d5q6tehxomgt` FOREIGN KEY (`forum_post_id`) REFERENCES `forumpost` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum_post_comments_id
-- ----------------------------
INSERT INTO `forum_post_comments_id` VALUES (5, 4);
INSERT INTO `forum_post_comments_id` VALUES (5, 5);
INSERT INTO `forum_post_comments_id` VALUES (3, 6);
INSERT INTO `forum_post_comments_id` VALUES (2, 3);
INSERT INTO `forum_post_comments_id` VALUES (2, 7);
INSERT INTO `forum_post_comments_id` VALUES (1, 2);
INSERT INTO `forum_post_comments_id` VALUES (1, 8);

-- ----------------------------
-- Table structure for forum_post_img_url
-- ----------------------------
DROP TABLE IF EXISTS `forum_post_img_url`;
CREATE TABLE `forum_post_img_url`  (
  `forum_post_id` int NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  INDEX `FKfy126bfwnmyno0c4jeo4xvsha`(`forum_post_id` ASC) USING BTREE,
  CONSTRAINT `FKfy126bfwnmyno0c4jeo4xvsha` FOREIGN KEY (`forum_post_id`) REFERENCES `forumpost` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum_post_img_url
-- ----------------------------
INSERT INTO `forum_post_img_url` VALUES (2, '/uploadimg/2022-12-29/b2507948-667e-4c96-a223-21ef3a5cb6c1.png');
INSERT INTO `forum_post_img_url` VALUES (3, '/uploadimg/2022-12-29/c6841420-db6b-4153-b1d5-b365050d4749.png');
INSERT INTO `forum_post_img_url` VALUES (4, '/uploadimg/2022-12-29/1407eca5-dc60-424c-82e4-91c2a6408007.jpg');
INSERT INTO `forum_post_img_url` VALUES (6, '/uploadimg/2022-12-29/1724f205-a653-4d0a-8b04-bc44ebf4f9ea.jpg');

-- ----------------------------
-- Table structure for forumpost
-- ----------------------------
DROP TABLE IF EXISTS `forumpost`;
CREATE TABLE `forumpost`  (
  `id` int NOT NULL,
  `post_time` datetime(6) NULL DEFAULT NULL,
  `post_userid` int NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `star_num` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forumpost
-- ----------------------------
INSERT INTO `forumpost` VALUES (1, '2022-12-29 15:23:28.190000', 3, '沙发沙发', 3);
INSERT INTO `forumpost` VALUES (2, '2022-12-29 15:24:11.630000', 3, 'Argentina is the Champion!! Messi is the 🐐!!!', 5);
INSERT INTO `forumpost` VALUES (3, '2022-12-29 17:02:43.612000', 11, '香喷喷的曲奇，好吃不上火！', 4);
INSERT INTO `forumpost` VALUES (4, '2022-12-29 17:06:53.643000', 11, '试过了，是真的不错！敏感肌也能用！', 4);
INSERT INTO `forumpost` VALUES (5, '2022-12-29 17:11:47.478000', 8, '感觉不如。。。原神', 3);
INSERT INTO `forumpost` VALUES (6, '2022-12-29 17:31:16.610000', 2, '最后的决战还是结束了，明年，重新出发！', 1);

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `id` int NOT NULL,
  `click` int NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `userid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, 5, '/uploadimg/2022-12-29/c6eb579f-a2e2-4cf2-aaa7-fb5bc7d1d4f7.png', '产自法国的精品薰衣草！！！', '薰衣草', 66, '食品', 3);
INSERT INTO `good` VALUES (2, 2, '/uploadimg/2022-12-29/713eb2a7-77a3-47d8-b91c-54ccb1f78c8e.png', '原产地巴西', '大力牛杯', 999, '美妆', 3);
INSERT INTO `good` VALUES (3, 1, '/uploadimg/2022-12-29/682ac9d0-f048-42d7-be88-1c999d8dfabe.jpg', '来块82年的牛排~', ' 迷迭香', 25, '食品', 3);
INSERT INTO `good` VALUES (4, 3, '/uploadimg/2022-12-29/f334d780-4f23-4f78-8229-a04bbc1b3702.jpg', '原产地鼠尾(*^_^*)', '鼠尾草', 30, '家居', 3);
INSERT INTO `good` VALUES (5, 1, '/uploadimg/2022-12-29/aed5f1ab-1464-431b-a17b-9e26c2fdbc11.jpg', '欧芹当然是欧洲的嘛', '欧芹', 66, '食品', 3);
INSERT INTO `good` VALUES (6, 2, '/uploadimg/2022-12-29/152dc3ab-34fa-4b67-b032-2ad1c7cbd98c.jpg', '🤩哇库瓦库🤩', '阿尼亚', 999, '家居', 3);
INSERT INTO `good` VALUES (7, 2, '/uploadimg/2022-12-29/490a53a6-6ec7-4ff4-9e23-d6b2e0e63e7c.jpg', 'v我50', 'TTHA', 50, '食品', 2);
INSERT INTO `good` VALUES (8, 1, '/uploadimg/2022-12-29/49bead13-262a-4f6c-9bde-92ece5096f07.png', '原产地：维多利亚 种族：阿斯兰 职业分支：尖兵（但是三技能不回费）', 'Saber', 198, '家居', 1);
INSERT INTO `good` VALUES (9, 5, '/uploadimg/2022-12-29/40d94347-d3ef-4d1a-86b4-a4df7b42501d.png', '原产于南京大学软件学院', '骁神', 65472, '食品', 2);
INSERT INTO `good` VALUES (10, 3, '/uploadimg/2022-12-29/c152f32f-19c9-417e-a9a4-7ee593715193.JPG', '好圆的雷蛇圈', 'wota艺照片', 10, '数码', 2);
INSERT INTO `good` VALUES (11, 1, '/uploadimg/2022-12-29/0cde64b2-bef5-40d5-919c-d28a98ff7d95.png', '热带风味一打+lucy河一箱', '考试周套餐', 30, '食品', 2);
INSERT INTO `good` VALUES (12, 0, '/uploadimg/2022-12-29/753e7e54-6678-4a5f-8284-5454ddbf94ff.jpg', '欧莱雅男士洁面乳', '欧莱雅男士洁面乳', 49, '美妆', 2);
INSERT INTO `good` VALUES (13, 0, '/uploadimg/2022-12-29/01212a75-be51-4d2e-945d-6dcb1327530c.png', '必出SSR的卡券！', 'SSR抽卡券', 64.8, '数码', 2);
INSERT INTO `good` VALUES (14, 5, '/uploadimg/2022-12-29/b11604d7-5548-4804-b4d4-679a1cc96b09.jpg', '原产地：炎 种族：未公开 职业分支：铁御 扩散术师 召唤师', '吉祥三宝', 998, '家居', 1);
INSERT INTO `good` VALUES (15, 0, '/uploadimg/2022-12-29/d997acf8-2da2-4297-8062-e811a6de5fc0.png', '自选期间限定卡', '期间限定自选卡券', 648, '数码', 2);
INSERT INTO `good` VALUES (16, 0, '/uploadimg/2022-12-29/4b7c5e84-b067-4271-be5c-ea24d4801708.jpg', '南大学子热销中', 'jyy真人表情包', 10, '美妆', 2);
INSERT INTO `good` VALUES (17, 2, '/uploadimg/2022-12-29/de7c05d3-6dbf-4d5d-994f-401b46fe7f8e.jpg', '互联网小天使请安！†升天†', '超天酱', 198, '美妆', 2);
INSERT INTO `good` VALUES (18, 2, '/uploadimg/2022-12-29/47fbb7ae-db1e-4fa5-9bb7-ca234b668a65.png', '10块包肝一个课程', '慕课代肝', 10, '数码', 2);
INSERT INTO `good` VALUES (19, 1, '/uploadimg/2022-12-29/ae05b1a0-ea15-4ece-8159-e2602e2ab2b0.png', '南大软院代代相传，软院学子必备资料', '寄网学习资料', 7, '数码', 2);
INSERT INTO `good` VALUES (20, 1, '/uploadimg/2022-12-29/20099b40-6a32-4b60-beb9-c0f4884528d2.png', '女生自用99新', 'RTX3070', 988, '数码', 1);
INSERT INTO `good` VALUES (21, 0, '/uploadimg/2022-12-29/9f27f21b-6116-49c8-b955-0bd90b29e1c7.png', '赛马娘日服初始号带新春北黑黛雅+6w水+常用满破支援卡', '新春北黑黛雅', 300, '数码', 11);
INSERT INTO `good` VALUES (22, 1, '/uploadimg/2022-12-29/58e07381-166c-46d7-b6da-86eee920be73.jpg', '白毛，帅！', '露西亚·深红囚影', 168, '服装', 11);
INSERT INTO `good` VALUES (23, 0, '/uploadimg/2022-12-29/ba2b9ff3-1d86-4c5b-8660-acfe1ae79736.png', '传说中的贤人留下来的福袋，使用后可获得一个高级礼物', '贤人福袋', 50, '箱包', 11);
INSERT INTO `good` VALUES (24, 0, '/uploadimg/2022-12-29/a9d01f75-64bb-41ba-99ee-16c59f8e4a0f.png', '显赫的贵人赠与的福袋，使用后可获得一个中级礼物', '贵人福袋', 30, '箱包', 11);
INSERT INTO `good` VALUES (25, 0, '/uploadimg/2022-12-29/c69255dc-c95e-4d68-985e-fca39fc31a81.png', '好吃捏', '香喷喷曲奇', 22, '食品', 11);
INSERT INTO `good` VALUES (26, 1, '/uploadimg/2022-12-29/4e4672f6-22b6-48c9-abdb-099eb410d88f.png', 'rurudo珍藏绝版切片，一起来看可爱的rurudo吧', 'rurudo切片', 3, '数码', 11);
INSERT INTO `good` VALUES (27, 0, '/uploadimg/2022-12-29/edaa075f-5d8e-4db6-a56a-0df812d9dab0.png', '南大软院C++网课全套', 'C++网课', 20, '数码', 11);
INSERT INTO `good` VALUES (28, 1, '/uploadimg/2022-12-29/56f353a4-b2ca-47fe-b6a7-28927c1ed53b.jpg', 'rurudoC101新刊', 'SUGAR HIGH', 300, '美妆', 11);
INSERT INTO `good` VALUES (29, 0, '/uploadimg/2022-12-29/eab65408-e0c5-418a-838d-237a23e0b1e6.png', '尊死！', '爱丽数码', 168, '数码', 11);
INSERT INTO `good` VALUES (30, 0, '/uploadimg/2022-12-29/f92ea078-64e4-44dc-9154-ba88e37e8528.png', '高山纱代子生日live通券，可以看syk生日live', '高山纱代子生日live通券', 188, '家居', 11);
INSERT INTO `good` VALUES (31, 1, '/uploadimg/2022-12-29/848d35b9-2cb7-4416-92ac-c750ea857595.jpg', '看我表演', '铭哥', 0, '食品', 8);
INSERT INTO `good` VALUES (32, 2, '/uploadimg/2022-12-29/f5afaea4-9207-4f49-a072-e928dbf15c20.png', '我们这个压缩毛巾体积小方便携带，拆开一包，放水里就变大，怎么扯都扯不坏，用来擦脚，擦脸，擦嘴都是很好用的，你看打开以后像圆饼一样大小，放在水里遇水变大变高，吸水性很强的。打开以后，是一条加大加厚的毛巾，你看他怎么挣都挣不坏，好不掉毛不掉絮，使用七八次都没问题，出差旅行带上它非常方便，用它擦擦脚，再擦擦嘴，擦擦脸，干净卫生。什么?在哪里买?下方小黄车，买五包送五包，还包邮。', '压缩毛巾', 15, '美妆', 8);
INSERT INTO `good` VALUES (33, 2, '/uploadimg/2022-12-29/b4cc128c-de3f-4ae0-ba94-c02062046a01.png', 'If you want it, then you have to take it.', '阎魔刀', 9963, '家居', 1);

-- ----------------------------
-- Table structure for good_picture
-- ----------------------------
DROP TABLE IF EXISTS `good_picture`;
CREATE TABLE `good_picture`  (
  `good_id` int NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  INDEX `FKin56tono1y8navhvpkaadyud7`(`good_id` ASC) USING BTREE,
  CONSTRAINT `FKin56tono1y8navhvpkaadyud7` FOREIGN KEY (`good_id`) REFERENCES `good` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_picture
-- ----------------------------
INSERT INTO `good_picture` VALUES (1, '/uploadimg/2022-12-29/dc06dae2-30ba-4276-9655-f1be8ce019e2.png');
INSERT INTO `good_picture` VALUES (2, '/uploadimg/2022-12-29/13189cba-1a86-4737-9907-aa72db531df2.png');
INSERT INTO `good_picture` VALUES (2, '/uploadimg/2022-12-29/6463d462-f2df-46f3-b32e-4f161231f540.png');
INSERT INTO `good_picture` VALUES (3, '/uploadimg/2022-12-29/7b3f931b-e237-4d23-9dd2-0da4173c0e4f.jpg');
INSERT INTO `good_picture` VALUES (4, '/uploadimg/2022-12-29/51f7eca9-3848-4a94-ad33-fd94ff207be0.jpg');
INSERT INTO `good_picture` VALUES (5, '/uploadimg/2022-12-29/03d6f648-ecbd-41dd-9043-656a4e74afa7.jpg');
INSERT INTO `good_picture` VALUES (6, '/uploadimg/2022-12-29/6d02c6a5-2899-46e1-bdbc-3d21e06a88cd.jpg');
INSERT INTO `good_picture` VALUES (7, '/uploadimg/2022-12-29/901d480c-6a75-4194-becd-ef7fa3272f82.jpg');
INSERT INTO `good_picture` VALUES (8, '/uploadimg/2022-12-29/4e86e5f8-0380-4559-bdbc-a70bea411cb8.png');
INSERT INTO `good_picture` VALUES (8, '/uploadimg/2022-12-29/b45f633c-ed33-48ac-8354-d6c348fbe23e.png');
INSERT INTO `good_picture` VALUES (8, '/uploadimg/2022-12-29/6edd4c9f-2346-4f9a-84ff-72e72404b653.png');
INSERT INTO `good_picture` VALUES (8, '/uploadimg/2022-12-29/06ebeacf-f4b3-4151-9041-628392c944c4.png');
INSERT INTO `good_picture` VALUES (9, '/uploadimg/2022-12-29/9227473a-4e1a-4f25-bcf4-44ef174d6a0e.png');
INSERT INTO `good_picture` VALUES (10, '/uploadimg/2022-12-29/db88cba8-045c-4801-aaf6-2ffce0b26a04.JPG');
INSERT INTO `good_picture` VALUES (11, '/uploadimg/2022-12-29/72aa8152-be39-45dc-808a-1df75e205d66.jpg');
INSERT INTO `good_picture` VALUES (11, '/uploadimg/2022-12-29/e075b704-5dcb-4a70-9ed4-f471c09f6946.jpg');
INSERT INTO `good_picture` VALUES (12, '/uploadimg/2022-12-29/a6950420-ffa3-496d-8af9-7f80982c5234.jpg');
INSERT INTO `good_picture` VALUES (13, '/uploadimg/2022-12-29/0581da82-89f6-4c34-a9e0-c14fee95947f.png');
INSERT INTO `good_picture` VALUES (14, '/uploadimg/2022-12-29/ee4b8922-315a-4571-a498-e50f687ef364.png');
INSERT INTO `good_picture` VALUES (14, '/uploadimg/2022-12-29/d3e4f5e3-f3dc-41cf-987c-1e650dfc71a9.png');
INSERT INTO `good_picture` VALUES (14, '/uploadimg/2022-12-29/c1ca05fc-e04c-4744-8bb8-cbc1818a2852.png');
INSERT INTO `good_picture` VALUES (15, '/uploadimg/2022-12-29/92c6a1ca-b693-4f7c-8967-e5d61a08a2fa.png');
INSERT INTO `good_picture` VALUES (16, '/uploadimg/2022-12-29/a19c4a82-8bda-4ad4-b2ef-d232cb3d3402.jpg');
INSERT INTO `good_picture` VALUES (16, '/uploadimg/2022-12-29/38ec5a21-25e9-49a6-8a7b-d0505b905707.jpg');
INSERT INTO `good_picture` VALUES (17, '/uploadimg/2022-12-29/934cfa79-32f4-4c6d-9aec-5a7e66a25137.jpg');
INSERT INTO `good_picture` VALUES (17, '/uploadimg/2022-12-29/2e2f2c50-755e-4e9f-9971-21278a92df8e.jpg');
INSERT INTO `good_picture` VALUES (18, '/uploadimg/2022-12-29/88f72195-b501-4237-8931-e6dce01bc362.png');
INSERT INTO `good_picture` VALUES (19, '/uploadimg/2022-12-29/21ee9e17-8ea4-478a-9aae-dd9c6ec7944d.png');
INSERT INTO `good_picture` VALUES (20, '/uploadimg/2022-12-29/1e0c21c2-6097-43a6-bfcb-9598cbb22a76.png');
INSERT INTO `good_picture` VALUES (21, '/uploadimg/2022-12-29/23e86b35-990b-4452-8ac2-ad905eeb8400.png');
INSERT INTO `good_picture` VALUES (21, '/uploadimg/2022-12-29/597b4bad-9648-4566-a2c5-e0c05471e582.png');
INSERT INTO `good_picture` VALUES (22, '/uploadimg/2022-12-29/824efdcb-aa1a-4f53-8764-5882c0d0dc75.jpg');
INSERT INTO `good_picture` VALUES (22, '/uploadimg/2022-12-29/3c279073-6455-4502-9905-4c77e6d5c20a.jpg');
INSERT INTO `good_picture` VALUES (23, '/uploadimg/2022-12-29/3dda8972-740c-45cf-8087-f90b9125ec79.png');
INSERT INTO `good_picture` VALUES (24, '/uploadimg/2022-12-29/af27377f-e1cd-4c61-a765-5e4ccd796980.png');
INSERT INTO `good_picture` VALUES (25, '/uploadimg/2022-12-29/36906a00-8ccc-4505-98ad-04707aa05f7d.png');
INSERT INTO `good_picture` VALUES (26, '/uploadimg/2022-12-29/fb67a9a0-fffa-4dc4-8e98-cb1f4ab20daa.png');
INSERT INTO `good_picture` VALUES (27, '/uploadimg/2022-12-29/49870219-39cd-4ce3-a1d7-d99c9dae4d12.png');
INSERT INTO `good_picture` VALUES (27, '/uploadimg/2022-12-29/e3a008eb-a1c6-44a0-8b37-0663bb11db83.png');
INSERT INTO `good_picture` VALUES (27, '/uploadimg/2022-12-29/d3005914-49cf-40d0-b33c-2237f78fa544.png');
INSERT INTO `good_picture` VALUES (28, '/uploadimg/2022-12-29/0ad64593-b53e-4977-ae73-df39baec71b9.jpg');
INSERT INTO `good_picture` VALUES (29, '/uploadimg/2022-12-29/f252e829-2530-460b-8f01-ece070aadf53.png');
INSERT INTO `good_picture` VALUES (29, '/uploadimg/2022-12-29/250ca551-7ef5-4651-8d48-b13fddc5ee8a.png');
INSERT INTO `good_picture` VALUES (30, '/uploadimg/2022-12-29/89dfec32-98a9-42ac-8ac3-319b91cf2006.png');
INSERT INTO `good_picture` VALUES (30, '/uploadimg/2022-12-29/0f624a82-78ea-43d6-86a1-cc174d4de4d3.png');
INSERT INTO `good_picture` VALUES (31, '/uploadimg/2022-12-29/7ec92333-7431-4ae8-8e6f-177791503458.jpg');
INSERT INTO `good_picture` VALUES (32, '/uploadimg/2022-12-29/99a4001f-6069-48f9-803a-011071c5f449.png');
INSERT INTO `good_picture` VALUES (33, '/uploadimg/2022-12-29/3fadfb44-328d-4d65-a7b0-ebf5972637c9.png');
INSERT INTO `good_picture` VALUES (33, '/uploadimg/2022-12-29/d933e24d-326b-49e8-aa17-c3c851fc482c.png');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (117);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `avator_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Logician', '123456', '/uploadimg/2022-12-29/ee0268f5-b3ca-4e8e-9ba6-8625b26c8171.png', '2b o not 2b');
INSERT INTO `user` VALUES (2, 'TTHA', '123456', '/uploadimg/2022-12-29/3ca71ece-5230-448e-aae3-026f44f3596c.png', 'V我50');
INSERT INTO `user` VALUES (3, 'KYCoraxxx', 'lalaziyuejiang6', '/uploadimg/2022-12-29/eaab87bb-37aa-43f5-b944-5033d9ef474d.jpg', '这个人很申必，什么都没有写');
INSERT INTO `user` VALUES (4, 'Yeahhooo', '123456', 'null', NULL);
INSERT INTO `user` VALUES (5, '後顧', 'qwe200459', 'null', NULL);
INSERT INTO `user` VALUES (6, 'LGC', '123456', 'null', NULL);
INSERT INTO `user` VALUES (7, 'Begonia', '123456', 'null', 'begobegonya~');
INSERT INTO `user` VALUES (8, 'yaoge123', 'zhangmingming', '/uploadimg/2022-12-29/39b2d361-1a2c-4e41-b731-dc65c759e7b7.png', '看我表演');
INSERT INTO `user` VALUES (9, '张萌萌', 'zmm123456', 'null', NULL);
INSERT INTO `user` VALUES (10, 'liser', '1959690785.00', 'null', NULL);
INSERT INTO `user` VALUES (11, 'BK', '123456', '/uploadimg/2022-12-29/18505161-2f5e-488c-8298-3ae06b6f786b.png', '任何邪恶，终将绳之以法！');
INSERT INTO `user` VALUES (12, 'enenen', '654321', 'null', NULL);

SET FOREIGN_KEY_CHECKS = 1;
