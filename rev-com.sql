/*
 Navicat Premium Data Transfer

 Source Server         : JavaMySQL
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : rev-com

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 11/05/2022 22:31:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `foreignName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外文名',
  `alias` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '其他名称',
  `constellation` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '星座',
  `birth` timestamp NULL DEFAULT NULL COMMENT '生日',
  `birthPlace` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出生地',
  `family` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '家庭成员',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of actor
-- ----------------------------
INSERT INTO `actor` VALUES ('1652014592779', '小罗伯特·唐尼', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-08 20:56:32', '2022-05-08 20:56:32', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152711455', '克里斯埃韦是', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:31', '2022-05-10 11:18:31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152720292', '詹兆隆', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:40', '2022-05-10 11:18:40', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152736343', '拉伦寺', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:56', '2022-05-10 11:18:56', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152742713', '妹妹', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:19:02', '2022-05-10 11:19:02', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152758674', '阿尔弗雷德·希区柯克', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:19:18', '2022-05-10 11:19:18', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152775219', '艾玛·雷维尔 ', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:19:35', '2022-05-10 11:19:35', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652152809362', '山姆·洛克威尔 ', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:20:09', '2022-05-10 11:20:09', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for director
-- ----------------------------
DROP TABLE IF EXISTS `director`;
CREATE TABLE `director`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `alias` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthPlace` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of director
-- ----------------------------
INSERT INTO `director` VALUES ('1652097604414', '安东尼·罗素', 'http://localhost:8888/director/avatar/1652097604414', 'Anthony Russo', '0', '美国', 'Joe Russo的兄弟', '2022-05-09 20:00:04', '2022-05-10 20:29:12', 'p1555672594.77.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185752769.jpg', 77244);
INSERT INTO `director` VALUES ('1652097707616', '张艺谋', 'http://localhost:8888/director/avatar/1652097707616', 'Yimou Zhang', '0', '中国,陕西,西安', '张艺谋，电影导演，北京奥运会开幕式总导演，他以执导充满浓浓中国乡土情味的电影著称，艺术特点是细节的逼真和主题的浪漫互相映照，是中国大陆“第五代导演” 的代表人物之一 。2010年5月24日获颁美国耶鲁大学荣誉博士学位。', '2022-05-09 20:01:47', '2022-05-10 20:29:49', 'c18c0962e339ca8b6f1d9e8be73cc8d1.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185789394.jpg', 41883);
INSERT INTO `director` VALUES ('1652105870601', '李安', 'http://localhost:8888/director/avatar/1652105870601', 'Ang Lee', '0', '中国,陕西,西安', '　李安生于台湾屏东县潮州镇，高中原就读台南二中，后转学考进了台南第一志愿——台南一中（注：其父先后曾任两校校长）。对于读书，李安一点兴趣都没有，心里只想着当导演。大学考试落榜两次，后来准备专科考试，进了国立台湾艺专（今国立台湾艺术大学）影剧科，从此改变了李安的一生。', '2022-05-09 22:17:50', '2022-05-10 20:30:31', 'p595.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185831463.jpg', 27363);
INSERT INTO `director` VALUES ('1652105949804', '史蒂文·斯皮尔伯格', 'http://localhost:8888/director/avatar/1652105949804', 'Steven Spielberg', '0', '美国,俄亥俄州,辛辛那提', '史蒂文·艾伦·斯皮尔伯格，（Steven Allan Spielberg，1946年12月18日－），生于美国辛辛那提市，犹太人，美国著名电影导演、编剧、电影制作人、慈善家，主要导演作品包括《头号玩家》、《侏罗纪公园》、《辛德勒的名单》和《拯救大兵瑞恩》等多部影史经典。', '2022-05-09 22:19:09', '2022-05-10 20:26:04', 'p617.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185564477.jpg', 27124);
INSERT INTO `director` VALUES ('1652109629705', '昆汀·塔伦蒂诺', 'http://localhost:8888/director/avatar/1652109629705', 'Quentin Tarantino', '0', '美国,田纳西州,诺克斯维尔', '毫无疑问，昆汀是个鬼才。而所谓“鬼才”，就是“鬼才知道他在想什么”。\n　　美国导演，演员及奥斯卡获奖编剧。生于美国田纳西州的挪克斯维尔。昆汀这个名字来源于影片《枪之烟火》中的角色。他在20世纪九十年代作为风格独特的导演迅速成名，他擅长非线性讲述故事，难忘的对白及血腥场面，将美国本土B级片的黑色暴力风格发扬光大。昆汀是20世纪90年代美国独立电影革命中重要的年轻导演，以独特的个性和对商业电影和艺术电影均有深刻理解著称。', '2022-05-09 23:20:29', '2022-05-10 20:31:57', 'p10798.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185917817.jpg', 35033);
INSERT INTO `director` VALUES ('1652109714661', '周星驰', 'http://localhost:8888/director/avatar/1652109714661', 'Stephen Chow', '0', '中国,香港', '著名演员、导演、编剧、电影监制以及电影制作人。曾主演《九品芝麻官》、《长江七号》等多部喜剧影片。捧红过张柏芝、张雨绮等影星。曾获1998年国际杰人会港澳杰人之星奖。其与成龙和周润发并称“双周一成”，意为香港电影票房的保证。', '2022-05-09 23:21:54', '2022-05-10 20:32:26', 'p1362491610.81.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185946883.jpg', 32464);
INSERT INTO `director` VALUES ('1652109786913', '李力持', 'http://localhost:8888/director/avatar/1652109786913', 'Lik-Chi Lee', '0', '中国,香港', '香港金牌导演、著名喜剧导演，曾是周星驰的御用导演，开创香港无厘头式电影模式，执导过多部脍炙人口的喜剧电影，大多数叫好又叫座的经典影片，如《喜剧之王》、《食神》、《少林足球》、《唐伯虎点秋香》、《国产凌凌漆》等。近几年一直致力于演艺教育培训方面的工作，包括演艺素质培训、电影拍摄技巧、提供器材学习等。', '2022-05-09 23:23:06', '2022-05-10 20:32:56', 'p51748.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652185976968.jpg', 63124);
INSERT INTO `director` VALUES ('1652147682816', '詹姆斯·卡梅隆', 'http://localhost:8888/director/avatar/1652147682816', 'James Cameron', '0', '加拿大,安大略,卡普斯卡辛', '　詹姆斯·卡梅隆，加拿大电影导演，擅长拍摄动作片以及科幻电影。詹姆斯·卡梅隆曾在加州的两年制社区学院学习物理学，但没多久又改主修英文，但在开学前自己休学。他到南加州大学的图书馆找资料自修学习电影特效技术，并用开卡车赚钱的空档写剧本。', '2022-05-10 09:54:42', '2022-05-10 20:33:30', 'p33715.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652186010626.jpg', 94279);
INSERT INTO `director` VALUES ('1652147804701', '温子仁', 'http://localhost:8888/director/avatar/1652147804701', ' James Wan', '0', '马来西亚,古晋', '出生于马来西亚、成长于澳洲的华裔导演。早年在墨尔本上大学时主修的专业是中国民族划分。对于东方异域文化的了解对詹姆斯·温的导演风格也有着很大的影响，而造就他对于《电锯惊魂》和《死寂》(dead silence)之类血浆片独特口味的更重要的因素是他14岁时父亲过世的打击。', '2022-05-10 09:56:44', '2022-05-10 20:34:03', 'b55653316617fb515b3e0b9f15887af9.jpg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/director/avatar/', '1652186043086.jpg', 31515);
INSERT INTO `director` VALUES ('1652148133473', '雷·沃纳尔', NULL, 'Leigh Whannell', '0', '澳大利亚,维多利亚,墨尔本', '雷·沃纳尔是澳洲的一位编剧、导演和演员。他经常为他的朋友温子仁的电影担任编剧。他曾经导演过两部电影，分别是2015年的《潜伏3》和2018年的《人类升级》。', '2022-05-10 10:02:13', '2022-05-10 10:02:13', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `director` VALUES ('1652148383742', '徐克', NULL, 'Hark Tsui', '0', '越南,西贡', '1950年2月15日生于越南西贡市，祖籍广东省海丰县，出身自华侨的大家庭，共有16名兄弟姐妹。在他十岁那年，他已经对电影发生兴趣，他曾与朋友租了摄录机来拍摄魔术表演，并在校内播放。他也喜爱漫画。这对他的电影风格有很大影响。', '2022-05-10 10:06:23', '2022-05-10 10:06:23', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `director` VALUES ('1652148516616', '阿尔弗雷德·希区柯克 ', NULL, 'Alfred Hitchcock', '0', '英国,伦敦,莱顿斯通', '阿尔弗雷德·希区柯克，（Sir Alfred Hitchcock，1899年8月13日－1980年4月29日）原籍英国，是一位闻名世界的电影导演，尤其擅长于拍摄惊悚悬疑片。希区柯克在英国拍摄了大批默片和有声片，之后，他前往好莱坞谋求发展，并与1956年加入美国国籍，并保留了英国国籍。在长达六十年的艺术生涯中，希区柯克共拍摄了超过五十部电影，他成为历史上著名的电影艺术大师。', '2022-05-10 10:08:36', '2022-05-10 10:08:36', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `coverUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `form` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `language` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '语言',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `releaseTime` timestamp NULL DEFAULT NULL COMMENT '上映日期',
  `duration` int NULL DEFAULT NULL,
  `alias` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1652237815469', '大话西游', NULL, '1652189378407', '华语', '45', '2022-10-12 00:00:00', 16522378, '花花', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `movie` VALUES ('1652238044529', '复仇者联盟', NULL, '1652189384380', '华语', '45', '2022-10-12 00:00:00', 150000, '花花', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for movie_actor
-- ----------------------------
DROP TABLE IF EXISTS `movie_actor`;
CREATE TABLE `movie_actor`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_actor_ibfk_2` FOREIGN KEY (`aId`) REFERENCES `actor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_actor
-- ----------------------------
INSERT INTO `movie_actor` VALUES ('1652237815469', '1652014592779', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_actor` VALUES ('1652237815469', '1652152758674', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_actor` VALUES ('1652238044529', '1652014592779', '2022-05-11 11:00:44', '2022-05-11 11:00:44');
INSERT INTO `movie_actor` VALUES ('1652238044529', '1652152711455', '2022-05-11 11:00:44', '2022-05-11 11:00:44');

-- ----------------------------
-- Table structure for movie_area
-- ----------------------------
DROP TABLE IF EXISTS `movie_area`;
CREATE TABLE `movie_area`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_area
-- ----------------------------
INSERT INTO `movie_area` VALUES ('1652189726243', '中国', '2022-05-10 21:35:26', '2022-05-10 21:35:26');
INSERT INTO `movie_area` VALUES ('1652189733153', '欧美', '2022-05-10 21:35:33', '2022-05-10 21:35:33');
INSERT INTO `movie_area` VALUES ('1652189738937', '美国', '2022-05-10 21:35:38', '2022-05-10 21:35:38');
INSERT INTO `movie_area` VALUES ('1652189745734', '香港', '2022-05-10 21:35:45', '2022-05-10 21:35:45');
INSERT INTO `movie_area` VALUES ('1652189762304', '日本', '2022-05-10 21:36:02', '2022-05-10 21:36:02');
INSERT INTO `movie_area` VALUES ('1652189767862', '韩国', '2022-05-10 21:36:07', '2022-05-10 21:36:07');
INSERT INTO `movie_area` VALUES ('1652189774756', '英国', '2022-05-10 21:36:14', '2022-05-10 21:36:14');
INSERT INTO `movie_area` VALUES ('1652189781103', '法国', '2022-05-10 21:36:21', '2022-05-10 21:36:21');
INSERT INTO `movie_area` VALUES ('1652189789100', '意大利', '2022-05-10 21:36:29', '2022-05-10 21:36:29');
INSERT INTO `movie_area` VALUES ('1652189809189', '西班牙', '2022-05-10 21:36:49', '2022-05-10 21:36:49');
INSERT INTO `movie_area` VALUES ('1652189815366', '印度', '2022-05-10 21:36:55', '2022-05-10 21:36:55');
INSERT INTO `movie_area` VALUES ('1652189823271', '泰国', '2022-05-10 21:37:03', '2022-05-10 21:37:03');
INSERT INTO `movie_area` VALUES ('1652189831871', '德国', '2022-05-10 21:37:11', '2022-05-10 21:37:11');

-- ----------------------------
-- Table structure for movie_area_relate
-- ----------------------------
DROP TABLE IF EXISTS `movie_area_relate`;
CREATE TABLE `movie_area_relate`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `aId`(`aId`) USING BTREE,
  CONSTRAINT `movie_area_relate_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_area_relate_ibfk_2` FOREIGN KEY (`aId`) REFERENCES `movie_area` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_area_relate
-- ----------------------------
INSERT INTO `movie_area_relate` VALUES ('1652237815469', '1652189767862', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_area_relate` VALUES ('1652237815469', '1652189745734', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_area_relate` VALUES ('1652238044529', '1652189733153', '2022-05-11 11:00:44', '2022-05-11 11:00:44');
INSERT INTO `movie_area_relate` VALUES ('1652238044529', '1652189745734', '2022-05-11 11:00:44', '2022-05-11 11:00:44');

-- ----------------------------
-- Table structure for movie_cate
-- ----------------------------
DROP TABLE IF EXISTS `movie_cate`;
CREATE TABLE `movie_cate`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_cate
-- ----------------------------
INSERT INTO `movie_cate` VALUES ('1652190028186', '剧情', '2022-05-10 21:40:28', '2022-05-10 21:40:28');
INSERT INTO `movie_cate` VALUES ('1652190048721', '喜剧', '2022-05-10 21:40:48', '2022-05-10 21:40:48');
INSERT INTO `movie_cate` VALUES ('1652190054769', '动作', '2022-05-10 21:40:54', '2022-05-10 21:40:54');
INSERT INTO `movie_cate` VALUES ('1652190060642', '爱情', '2022-05-10 21:41:00', '2022-05-10 21:41:00');
INSERT INTO `movie_cate` VALUES ('1652190067124', '科幻', '2022-05-10 21:41:07', '2022-05-10 21:41:07');
INSERT INTO `movie_cate` VALUES ('1652190072644', '动画', '2022-05-10 21:41:12', '2022-05-10 21:41:12');
INSERT INTO `movie_cate` VALUES ('1652190079476', '悬疑', '2022-05-10 21:41:19', '2022-05-10 21:41:19');
INSERT INTO `movie_cate` VALUES ('1652190087259', '惊悚', '2022-05-10 21:41:27', '2022-05-10 21:41:27');
INSERT INTO `movie_cate` VALUES ('1652190093028', '恐怖', '2022-05-10 21:41:33', '2022-05-10 21:41:33');
INSERT INTO `movie_cate` VALUES ('1652190099651', '犯罪', '2022-05-10 21:41:39', '2022-05-10 21:41:39');
INSERT INTO `movie_cate` VALUES ('1652190106859', '音乐', '2022-05-10 21:41:46', '2022-05-10 21:41:46');
INSERT INTO `movie_cate` VALUES ('1652190113629', '歌舞', '2022-05-10 21:41:53', '2022-05-10 21:41:53');
INSERT INTO `movie_cate` VALUES ('1652190125156', '传记', '2022-05-10 21:42:05', '2022-05-10 21:42:05');
INSERT INTO `movie_cate` VALUES ('1652190130069', '历史', '2022-05-10 21:42:10', '2022-05-10 21:42:10');
INSERT INTO `movie_cate` VALUES ('1652190135212', '西部', '2022-05-10 21:42:15', '2022-05-10 21:42:15');
INSERT INTO `movie_cate` VALUES ('1652190141232', '奇幻', '2022-05-10 21:42:21', '2022-05-10 21:42:21');
INSERT INTO `movie_cate` VALUES ('1652190148322', '冒险', '2022-05-10 21:42:28', '2022-05-10 21:42:28');
INSERT INTO `movie_cate` VALUES ('1652190158982', '灾难', '2022-05-10 21:42:38', '2022-05-10 21:42:38');
INSERT INTO `movie_cate` VALUES ('1652190164468', '武侠', '2022-05-10 21:42:44', '2022-05-10 21:42:44');

-- ----------------------------
-- Table structure for movie_cate_relate
-- ----------------------------
DROP TABLE IF EXISTS `movie_cate_relate`;
CREATE TABLE `movie_cate_relate`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `cId`(`cId`) USING BTREE,
  CONSTRAINT `movie_cate_relate_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_cate_relate_ibfk_2` FOREIGN KEY (`cId`) REFERENCES `movie_cate` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_cate_relate
-- ----------------------------
INSERT INTO `movie_cate_relate` VALUES ('1652237815469', '1652190067124', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_cate_relate` VALUES ('1652237815469', '1652190054769', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_cate_relate` VALUES ('1652238044529', '1652190067124', '2022-05-11 11:00:44', '2022-05-11 11:00:44');
INSERT INTO `movie_cate_relate` VALUES ('1652238044529', '1652190054769', '2022-05-11 11:00:44', '2022-05-11 11:00:44');

-- ----------------------------
-- Table structure for movie_director
-- ----------------------------
DROP TABLE IF EXISTS `movie_director`;
CREATE TABLE `movie_director`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `dId`(`dId`) USING BTREE,
  CONSTRAINT `movie_director_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_director_ibfk_2` FOREIGN KEY (`dId`) REFERENCES `director` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_director
-- ----------------------------
INSERT INTO `movie_director` VALUES ('1652237815469', '1652105870601', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_director` VALUES ('1652237815469', '1652105949804', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_director` VALUES ('1652238044529', '1652097604414', '2022-05-11 11:00:44', '2022-05-11 11:00:44');
INSERT INTO `movie_director` VALUES ('1652238044529', '1652105949804', '2022-05-11 11:00:44', '2022-05-11 11:00:44');

-- ----------------------------
-- Table structure for movie_form
-- ----------------------------
DROP TABLE IF EXISTS `movie_form`;
CREATE TABLE `movie_form`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_form
-- ----------------------------
INSERT INTO `movie_form` VALUES ('1652189363945', '电影', '2022-05-10 21:29:23', '2022-05-10 21:29:23');
INSERT INTO `movie_form` VALUES ('1652189371834', '电视剧', '2022-05-10 21:29:31', '2022-05-10 21:29:31');
INSERT INTO `movie_form` VALUES ('1652189378407', '综艺', '2022-05-10 21:29:38', '2022-05-10 21:29:38');
INSERT INTO `movie_form` VALUES ('1652189384380', '动漫', '2022-05-10 21:29:44', '2022-05-10 21:29:44');
INSERT INTO `movie_form` VALUES ('1652189395431', '纪录片', '2022-05-10 21:29:55', '2022-05-10 21:29:55');
INSERT INTO `movie_form` VALUES ('1652189403822', '短片', '2022-05-10 21:30:03', '2022-05-10 21:30:03');

-- ----------------------------
-- Table structure for movie_screenwriter_relate
-- ----------------------------
DROP TABLE IF EXISTS `movie_screenwriter_relate`;
CREATE TABLE `movie_screenwriter_relate`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `sId`(`sId`) USING BTREE,
  CONSTRAINT `movie_screenwriter_relate_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_screenwriter_relate_ibfk_2` FOREIGN KEY (`sId`) REFERENCES `screenwriter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_screenwriter_relate
-- ----------------------------
INSERT INTO `movie_screenwriter_relate` VALUES ('1652237815469', '1652195889420', '2022-05-11 10:56:55', '2022-05-11 10:56:55');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652238044529', '1652195889420', '2022-05-11 11:00:44', '2022-05-11 11:00:44');

-- ----------------------------
-- Table structure for movie_tag
-- ----------------------------
DROP TABLE IF EXISTS `movie_tag`;
CREATE TABLE `movie_tag`  (
  `id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_tag
-- ----------------------------
INSERT INTO `movie_tag` VALUES ('1652191640964', '经典', '2022-05-10 22:07:20', '2022-05-10 22:07:20');
INSERT INTO `movie_tag` VALUES ('1652191647202', '青春', '2022-05-10 22:07:27', '2022-05-10 22:07:27');
INSERT INTO `movie_tag` VALUES ('1652191653781', '文艺', '2022-05-10 22:07:33', '2022-05-10 22:07:33');
INSERT INTO `movie_tag` VALUES ('1652191659258', '搞笑', '2022-05-10 22:07:39', '2022-05-10 22:07:39');
INSERT INTO `movie_tag` VALUES ('1652191667526', '励志', '2022-05-10 22:07:47', '2022-05-10 22:07:47');
INSERT INTO `movie_tag` VALUES ('1652191672412', '魔幻', '2022-05-10 22:07:52', '2022-05-10 22:07:52');
INSERT INTO `movie_tag` VALUES ('1652191678679', '感人', '2022-05-10 22:07:58', '2022-05-10 22:07:58');
INSERT INTO `movie_tag` VALUES ('1652191685032', '血腥', '2022-05-10 22:08:05', '2022-05-10 22:08:05');

-- ----------------------------
-- Table structure for movie_tag_relate
-- ----------------------------
DROP TABLE IF EXISTS `movie_tag_relate`;
CREATE TABLE `movie_tag_relate`  (
  `mId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX `mId`(`mId`) USING BTREE,
  INDEX `tId`(`tId`) USING BTREE,
  CONSTRAINT `movie_tag_relate_ibfk_1` FOREIGN KEY (`mId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `movie_tag_relate_ibfk_2` FOREIGN KEY (`tId`) REFERENCES `movie_tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_tag_relate
-- ----------------------------

-- ----------------------------
-- Table structure for occupation
-- ----------------------------
DROP TABLE IF EXISTS `occupation`;
CREATE TABLE `occupation`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of occupation
-- ----------------------------
INSERT INTO `occupation` VALUES ('1652100137884', '导演', '2022-05-09 20:42:17', '2022-05-09 20:42:17');
INSERT INTO `occupation` VALUES ('1652100299387', '演员', '2022-05-09 20:44:59', '2022-05-09 20:44:59');
INSERT INTO `occupation` VALUES ('1652100306026', '编剧', '2022-05-09 20:45:06', '2022-05-09 20:45:06');
INSERT INTO `occupation` VALUES ('1652100321467', '制片人', '2022-05-09 20:45:21', '2022-05-09 20:45:21');
INSERT INTO `occupation` VALUES ('1652100330901', '摄影', '2022-05-09 20:45:30', '2022-05-09 20:45:30');
INSERT INTO `occupation` VALUES ('1652100361394', '美术', '2022-05-09 20:46:01', '2022-05-09 20:46:01');
INSERT INTO `occupation` VALUES ('1652100375330', '配音', '2022-05-09 20:46:15', '2022-05-09 20:46:15');
INSERT INTO `occupation` VALUES ('1652100464525', '剪辑', '2022-05-09 20:47:44', '2022-05-09 20:47:44');

-- ----------------------------
-- Table structure for occupation_relate
-- ----------------------------
DROP TABLE IF EXISTS `occupation_relate`;
CREATE TABLE `occupation_relate`  (
  `aId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `oId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  INDEX `aId`(`aId`) USING BTREE,
  INDEX `dId`(`dId`) USING BTREE,
  INDEX `sId`(`sId`) USING BTREE,
  INDEX `oId`(`oId`) USING BTREE,
  CONSTRAINT `occupation_relate_ibfk_1` FOREIGN KEY (`aId`) REFERENCES `actor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `occupation_relate_ibfk_2` FOREIGN KEY (`dId`) REFERENCES `director` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `occupation_relate_ibfk_3` FOREIGN KEY (`sId`) REFERENCES `screenwriter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `occupation_relate_ibfk_4` FOREIGN KEY (`oId`) REFERENCES `occupation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of occupation_relate
-- ----------------------------
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148383742', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148383742', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148383742', NULL, '1652100137884');

-- ----------------------------
-- Table structure for screenwriter
-- ----------------------------
DROP TABLE IF EXISTS `screenwriter`;
CREATE TABLE `screenwriter`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `alias` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthPlace` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth` timestamp NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `family` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of screenwriter
-- ----------------------------
INSERT INTO `screenwriter` VALUES ('1652195889420', '兰晓龙', NULL, 'Xiaolong Lan', '0', '中国，湖南邵阳', '2022-04-04 00:00:00', '　兰晓龙，湖南邵阳人，1973年5月26日出生。1997年毕业于中央戏剧学院，后进入北京军区战友话剧团成为一名职业编剧。曾创作了话剧《红星照耀中国》，电视剧《石磊大夫》、《步兵团长》、《士兵突击》、《我的团长我的团》、《生死线》。', '兰图', '2022-05-10 23:18:09', '2022-05-10 23:18:09', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userName` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `auth` int NULL DEFAULT 0,
  `expireTime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `manage` int NULL DEFAULT 0,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1651935333133', 'gb', '456', 'http://localhost:8888/user/avatar/1651935333133', '2022-05-07 22:55:33', '2022-05-07 22:55:33', 0, '0000-00-00 00:00:00', 0, 'avatar.jpeg', 'image/jpeg', 'F:\\Rev-Com\\rev-com-server/upload/avatar/', '1651974057794.jpeg', 39383);
INSERT INTO `user` VALUES ('1651968644534', 'gb1', '456', NULL, '2022-05-08 08:10:44', '2022-05-08 08:10:44', 0, '0000-00-00 00:00:00', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1651968719179', 'g0b', '456', NULL, '2022-05-08 08:11:59', '2022-05-08 08:11:59', 0, '0000-00-00 00:00:00', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1651974343667', 'g0b', '456', NULL, '2022-05-08 09:45:43', '2022-05-08 09:45:43', 0, '0000-00-00 00:00:00', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1651974351804', 'g0brrr', '456', NULL, '2022-05-08 09:45:51', '2022-05-08 09:45:51', 0, '0000-00-00 00:00:00', 0, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
