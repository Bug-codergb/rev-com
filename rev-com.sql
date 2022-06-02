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

 Date: 02/06/2022 07:43:53
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
INSERT INTO `actor` VALUES ('1652014592779', '小罗伯特·唐尼', 'http://localhost:8888/actor/avatar/1652014592779', 'Robert Downey Jr.', 'Bob', '双子座', '1997-04-07 16:00:00', '纽约', '克里斯埃文斯', 'ffffff', '2022-05-08 20:56:32', '2022-05-22 21:15:42', '周慧明.jpeg', 'image/jpeg', './upload/actor/avatar/', '1653102966353.jpeg', 27637);
INSERT INTO `actor` VALUES ('1652152711455', '克里斯埃韦是', 'http://localhost:8888/actor/avatar/1652152711455', 'Robert Downey Jr.', 'Bob', '双子座', '2010-07-19 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:31', '2022-05-21 11:08:14', 'p4213.jpg', 'image/jpeg', './upload/actor/avatar/', '1653102494559.jpg', 20576);
INSERT INTO `actor` VALUES ('1652152720292', '詹兆隆', 'http://localhost:8888/actor/avatar/1652152720292', 'Robert Downey Jr.', 'Bob', '处女座', '2000-04-21 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:40', '2022-05-29 20:37:55', 'p4213.jpg', 'image/jpeg', './upload/actor/avatar/', '1653102097067.jpg', 20576);
INSERT INTO `actor` VALUES ('1652152736343', '拉伦寺', 'http://localhost:8888/actor/avatar/1652152736343', 'Robert Downey Jr.', 'Bob', '水瓶座', '1990-04-12 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:18:56', '2022-05-21 11:02:28', 'f68d10b9925b1209bb3e0a4307028062.jpg', 'image/jpeg', './upload/actor/avatar/', '1653102148655.jpg', 326404);
INSERT INTO `actor` VALUES ('1652152758674', '阿尔弗雷德·希区柯克', 'http://localhost:8888/actor/avatar/1652152758674', 'Robert Downey Jr.', 'Bob', '狮子座', '2002-03-31 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:19:18', '2022-05-21 10:59:56', 'OIP-C.jpg', 'image/jpeg', './upload/actor/avatar/', '1653101996595.jpg', 5780);
INSERT INTO `actor` VALUES ('1652152775219', '艾玛·雷维尔 ', 'http://localhost:8888/actor/avatar/1652152775219', 'Robert Downey Jr.', 'Bob', '白羊座', '2007-08-22 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:19:35', '2022-05-22 20:40:10', 'p4213.jpg', 'image/jpeg', './upload/actor/avatar/', '1653223210639.jpg', 20576);
INSERT INTO `actor` VALUES ('1652152809362', '山姆·洛克威尔 ', 'http://localhost:8888/actor/avatar/1652152809362', 'Robert Downey Jr.', 'Bob', '白羊座', '2001-10-24 16:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-10 11:20:09', '2022-05-21 21:41:10', 'OIP-C.jpg', 'image/jpeg', './upload/actor/avatar/', '1653140470555.jpg', 5780);
INSERT INTO `actor` VALUES ('1652444349475', '西泽尔', 'http://localhost:8888/actor/avatar/1652444349475', 'Robert Downey Jr.34', 'elmpt', '狮子座', '2010-04-04 00:00:00', '美国华盛顿', '莎拉·杰西(女)', 'ffffff', '2022-05-13 20:19:09', '2022-05-22 10:31:29', 'p4213.jpg', 'image/jpeg', './upload/actor/avatar/', '1653186689607.jpg', 20576);
INSERT INTO `actor` VALUES ('1652491465151', '吴京', 'http://localhost:8888/actor/avatar/1652491465151', '吴京', 'Jing Wu', '白羊座', '2016-01-14 16:00:00', '中国,北京', '谢楠(妻)', '吴京，被誉为“功夫小子”，从1995年就开始接拍电视剧和电影，其引路人便是《少林寺》以及《少林武王》的导演张鑫炎，而吴京的武术教练也就是李连杰的教练吴彬。当年还在武术队里奋斗的吴京被张鑫炎看中，于是和师兄李连杰一样，顺利地加入了娱乐圈。两人的经历惊人地相似。2005年后吴京搬迁至香港，正式在香港发展，并取得了不俗的成绩。', '2022-05-14 09:24:25', '2022-05-22 10:58:42', 'p4213.jpg', 'image/jpeg', './upload/actor/avatar/', '1653188322223.jpg', 20576);
INSERT INTO `actor` VALUES ('1652494639677', '小罗伯特·唐尼', NULL, 'Robert Downey Jr.', 'Bob', '白羊座', '1990-04-04 00:00:00', '纽约', '莎拉·杰西卡', 'ffffff', '2022-05-14 10:17:19', '2022-05-14 10:17:19', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1652494690386', '吴孟达', NULL, 'da wu', 'da wu', '射手座', '2022-05-10 16:00:00', '香港', '暂无', '香港黄金配角', '2022-05-14 10:18:10', '2022-05-14 10:25:15', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1653099331792', 'tgtgtg', NULL, 'tgtg', 'tgtg', '巨蟹座', '2022-05-19 16:00:00', 'tgt', 'gtg', 'gtgt', '2022-05-21 10:15:31', '2022-05-21 10:15:31', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1653099398251', 'er', NULL, 're', 're', '狮子座', '2022-05-19 16:00:00', 'er', 'er', 'rer', '2022-05-21 10:16:38', '2022-05-21 10:16:38', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `actor` VALUES ('1653789676790', '三毛', 'http://localhost:8888/actor/avatar/1653789676790', 'のの3のののののの4谔谔呃额阿(⊙﹏⊙)', 'three mao', '处女座', '2022-05-12 16:00:00', '每股派', 'ee3のの二次', '你就是个垃圾你就是个拦击', '2022-05-29 10:01:16', '2022-05-29 10:01:53', 'OIP-C.jpg', 'image/jpeg', './upload/actor/avatar/', '1653789713040.jpg', 5780);
INSERT INTO `actor` VALUES ('1653831630847', '茂芹', 'http://localhost:8888/actor/avatar/1653831630847', '如4人', '茂芹', '白羊座', '2022-05-25 16:00:00', '时产生的污染', '3如4 55555', '人34人3', '2022-05-29 21:40:30', '2022-05-29 21:40:44', '周慧明.jpeg', 'image/jpeg', './upload/actor/avatar/', '1653831630925.jpeg', 27637);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `userId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `score` float NULL DEFAULT NULL,
  `movieId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isShort` int NULL DEFAULT 0,
  `replyId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `replyId`(`replyId`) USING BTREE,
  INDEX `comment_ibfk_2`(`movieId`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`replyId`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1654050173621', NULL, '第一部虽然简单，但还算忠于原著，特技效果更是完美。遗憾的是童年简单的动画变成了现在逼真的金属，反而辨析起来难度加大了，还好有夕阳下梅根福克斯的小蛮腰舒缓下情绪。', '1651935333133', 3, '1652323356167', 0, NULL, '2022-06-01 10:22:53', '2022-06-01 10:22:53');
INSERT INTO `comment` VALUES ('1654050183309', NULL, '几近完美的动作特效片，节奏缓急有序，笑料频频。故事极其简单，为了引出动作而为，不作深究', '1651935333133', 4, '1652323356167', 0, NULL, '2022-06-01 10:23:03', '2022-06-01 10:23:03');
INSERT INTO `comment` VALUES ('1654050199077', NULL, '超级爱看科幻片，国外电影的特效真的好棒，这一系列的都很喜欢，外国的科幻片看着很爽', '1651935333133', 1, '1652323356167', 0, NULL, '2022-06-01 10:23:19', '2022-06-01 10:23:19');
INSERT INTO `comment` VALUES ('1654050213142', '变心的《变形金刚》', '<p style=\"text-indent: 2em;\"><span style=\"color: rgb(17, 17, 17); background-color: rgb(255, 255, 255); font-size: 14px;\">电影《变形金刚》并没有“剧透”的危险，因为它的重点不在剧情。尽管剧情还算得上比较麻烦，三条主线平行推进，一条暗线跟随，并且最后把三根主线联系起来。道家说过：一气化三清。证明我国先哲早有预测，2007年会上映《变形金刚》。而且预言了如果你是电影院里看的话：第一个广告是一汽解放的。我不知道别人看《</span><span style=\"color: rgb(54, 88, 226); font-size: 14px;\"><s>变形金刚</s></span><span style=\"color: rgb(17, 17, 17); background-color: rgb(255, 255, 255); font-size: 14px;\">》是为了什么？我是为了NB闪闪地怀旧。比如说看周星驰电影长大的这帮人，其中某几个成功打入央视6套内部，于是每个暑假大家都有《大话西游》看。当我看到的时候，就可以骄傲地宣布：看！那是自己人干的！又比如说，一次地震或者洪水把当今的所有电视导演都干掉了，只能临时从小字辈里选人。于是，电视上就再没有劣质武侠和大辫子戏，可能换上一水的《隋唐演艺》、《说岳》。当我看到的时候，就可以骄傲地联想，有几个当年和我一样听收音机说评书的家伙终于掌镜了。《变形金刚》是一个道理，我初看的时候还在小学和初中。当时我很喜欢，但是人又很穷，买不起一个孩之宝的玩具机器人。所以，我在作业本和书页空白处画擎天柱的头像。老师肯定不喜欢这么做，所以要没收玩具，要批评在书上画“大头人”（老师语）的行为。我当时觉得很绝望，因为你不可能跟一个把变形金刚说成是“大头人”的人讲清楚里面的道理。所以，你只能发誓：等我长大了，买一房间的变形金刚。为了这一天，我等了二十多年。忍受他们在屏幕上放了二十多年的样板戏、《五朵金花》、知青戏、清宫戏。现在，《变形金刚》成为电影，我终于可以爆一声：那他妈的不是大头人！懂吗？等我这一代人成为社会主流的时候，哪怕我童年玩的洋片、帖纸、烟盒都将成为社会主流文化。《变形金刚》就是具体体现，我们当年喜欢，现在我们有钱进电影院买DVD了，那你就拍给我们看。明天我们又怀念霹雳舞了，那么一线明星就全上去跳给我们看，春晚不允许有别的节目。这就是怀旧，这就是NB闪闪。（以下内容不是影评，这不是演习）</span></p>', '1651935333133', 4, '1652323356167', 1, NULL, '2022-06-01 10:24:21', '2022-06-01 10:24:21');
INSERT INTO `comment` VALUES ('1654069770817', NULL, '我实在分不清这些变形金刚', '1651935333133', 3, '1652323356167', 0, NULL, '2022-06-01 15:49:30', '2022-06-01 15:49:30');
INSERT INTO `comment` VALUES ('1654069778202', NULL, '梅根福克斯太妖娆了', '1651935333133', 4, '1652323356167', 0, NULL, '2022-06-01 15:49:38', '2022-06-01 15:49:38');
INSERT INTO `comment` VALUES ('1654070617003', NULL, '童年的回忆，五星！！！我们在影院里看到的那些栩栩如生的变形金刚以及不仅仅是各动画角色，可以说这几个金刚的建模几乎已经达到了工程级的水平，所差的就是用真正的金属来造一个真正的变形金刚。影片中的擎天柱全身有一万多个零件，你看得到么？', '1651935333133', 5, '1652323356167', 0, NULL, '2022-06-01 16:03:37', '2022-06-01 16:03:37');
INSERT INTO `comment` VALUES ('1654072467495', '我爱死你了迪沃夫', '<p>纷纷如风进而哦</p><p>费发票乳房</p><p><img src=\"http://localhost:8888/comment/picture/1654072485670\" alt=\"\" data-href=\"\" style=\"width: 146.00px;height: 213.05px;\"/></p><p>富婆放几日发分威风</p>', '1651935333133', 1, '1652323356167', 1, NULL, '2022-06-01 16:34:57', '2022-06-01 20:46:14');
INSERT INTO `comment` VALUES ('1654075057117', NULL, '放热峰更改狗肉馆稳如狗潜望3欺负穷人法国共同维护问题逃往国外4高污染给我个各器官歌舞国企工人五个  更为广泛', '1651935333133', 4, '1652237815469', 0, NULL, '2022-06-01 17:17:37', '2022-06-01 17:17:37');
INSERT INTO `comment` VALUES ('1654075129397', NULL, '郡，洪都新府。星分翼轸，地接衡庐。襟三江而带五湖，控蛮荆而引瓯越。物华天宝，龙光射牛斗之墟；人杰地灵，徐孺下陈蕃之榻。雄州雾列，俊采星驰。台隍枕夷夏之交，宾主尽东南之美。都督阎公之雅望，棨戟遥临；宇文新州之懿范，襜帷暂驻。十旬休假，胜友如云；千里逢迎，高朋满座。腾蛟', '1651935333133', 2, '1652237815469', 0, NULL, '2022-06-01 17:18:49', '2022-06-01 17:18:49');
INSERT INTO `comment` VALUES ('1654087490704', NULL, '4温故痛过通规划 与6用5 用5要6 ', '1651935333133', 3, '1652322979306', 0, NULL, '2022-06-01 20:44:50', '2022-06-01 20:44:50');
INSERT INTO `comment` VALUES ('1654087494032', '个人提供他个人', '<p>个人提供突然</p><p>过图给他</p><p>过问题</p><p><strong>gt我</strong></p><p><br></p>', '1651935333133', 0, '1652322979306', 1, NULL, '2022-06-01 20:45:11', '2022-06-01 20:45:11');
INSERT INTO `comment` VALUES ('1654087653198', NULL, '，序属三秋。潦水尽而寒潭清，烟光凝而暮山紫。俨骖騑于上路，访风景于崇阿。临帝子之长洲，得天人之旧馆', '1651935333133', 3, '1652323356167', 0, NULL, '2022-06-01 20:47:33', '2022-06-01 20:47:33');
INSERT INTO `comment` VALUES ('1675464984912', 'hellO', 'hahaha', '1651935333133', 3, '1652323356167', 0, '1654050213142', '2022-06-01 10:47:08', '2022-06-01 10:47:08');
INSERT INTO `comment` VALUES ('1678156156511', '发freer', '你好你好', '1651935333133', 2, '1652323356167', 0, '1675464984912', '2022-06-01 11:16:31', '2022-06-01 11:16:31');

-- ----------------------------
-- Table structure for comment_img
-- ----------------------------
DROP TABLE IF EXISTS `comment_img`;
CREATE TABLE `comment_img`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cId` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cId`(`cId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_img
-- ----------------------------
INSERT INTO `comment_img` VALUES ('1654072485670', '1654072467495', 'http://localhost:8888/comment/picture/1654072485670', 'p2185073849.webp', 'image/webp', './upload/comment/picture/', '1654072485671.webp', 28686);

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
INSERT INTO `director` VALUES ('1652097604414', '安东尼·罗素', 'http://localhost:8888/director/avatar/1652097604414', 'Anthony Russo', '0', '美国', 'Joe Russo的兄弟', '2022-05-09 20:00:04', '2022-05-22 21:12:24', 'OIP-C.jpg', 'image/jpeg', './upload/director/avatar/', '1653123559927.jpg', 5780);
INSERT INTO `director` VALUES ('1652097707616', '张艺谋', 'http://localhost:8888/director/avatar/1652097707616', 'YImou Z', '1', '纽约', '牛逼牛逼牛逼你比u', '2022-05-09 20:01:47', '2022-05-22 21:41:04', 'c18c0962e339ca8b6f1d9e8be73cc8d1.jpg', 'image/jpeg', './upload/director/avatar/', '1652185789394.jpg', 41883);
INSERT INTO `director` VALUES ('1652105870601', '李安', 'http://localhost:8888/director/avatar/1652105870601', 'Ang Lee', '0', '中国,陕西,西安', '李安生于台湾屏东县潮州镇，高中原就读台南二中，后转学考进了台南第一志愿——台南一中（注：其父先后曾任两校校长）。对于读书，李安一点兴趣都没有，心里只想着当导演。大学考试落榜两次，后来准备专科考试，进了国立台湾艺专（今国立台湾艺术大学）影剧科，从此改变了李安的一生。', '2022-05-09 22:17:50', '2022-05-22 21:41:11', 'p595.jpg', 'image/jpeg', './upload/director/avatar/', '1652185831463.jpg', 27363);
INSERT INTO `director` VALUES ('1652105949804', '史蒂文·斯皮尔伯格', 'http://localhost:8888/director/avatar/1652105949804', 'Steven Spielberg', '0', '美国,俄亥俄州,辛辛那提', '史蒂文·艾伦·斯皮尔伯格，（Steven Allan Spielberg，1946年12月18日－），生于美国辛辛那提市，犹太人，美国著名电影导演、编剧、电影制作人、慈善家，主要导演作品包括《头号玩家》、《侏罗纪公园》、《辛德勒的名单》和《拯救大兵瑞恩》等多部影史经典。', '2022-05-09 22:19:09', '2022-05-21 09:51:05', 'photo.jpg', 'image/jpeg', './upload/director/avatar/', '1653097865390.jpg', 299753);
INSERT INTO `director` VALUES ('1652109629705', '昆汀·塔伦蒂诺', 'http://localhost:8888/director/avatar/1652109629705', 'Quentin Tarantino', '0', '美国,田纳西州,诺克斯维尔', '毫无疑问，昆汀是个鬼才。而所谓“鬼才”，就是“鬼才知道他在想什么”。\n　　美国导演，演员及奥斯卡获奖编剧。生于美国田纳西州的挪克斯维尔。昆汀这个名字来源于影片《枪之烟火》中的角色。他在20世纪九十年代作为风格独特的导演迅速成名，他擅长非线性讲述故事，难忘的对白及血腥场面，将美国本土B级片的黑色暴力风格发扬光大。昆汀是20世纪90年代美国独立电影革命中重要的年轻导演，以独特的个性和对商业电影和艺术电影均有深刻理解著称。', '2022-05-09 23:20:29', '2022-05-21 09:39:27', 'p10798.jpg', 'image/jpeg', './upload/director/avatar/', '1652185917817.jpg', 35033);
INSERT INTO `director` VALUES ('1652109714661', '周星驰', 'http://localhost:8888/director/avatar/1652109714661', 'Stephen Chow', '0', '中国,香港', '著名演员、导演、编剧、电影监制以及电影制作人。曾主演《九品芝麻官》、《长江七号》等多部喜剧影片。捧红过张柏芝、张雨绮等影星。曾获1998年国际杰人会港澳杰人之星奖。其与成龙和周润发并称“双周一成”，意为香港电影票房的保证。', '2022-05-09 23:21:54', '2022-05-21 09:39:31', 'p1362491610.81.jpg', 'image/jpeg', './upload/director/avatar/', '1652185946883.jpg', 32464);
INSERT INTO `director` VALUES ('1652109786913', '李力持', 'http://localhost:8888/director/avatar/1652109786913', 'Lik-Chi Lee', '0', '中国,香港', '香港金牌导演、著名喜剧导演，曾是周星驰的御用导演，开创香港无厘头式电影模式，执导过多部脍炙人口的喜剧电影，大多数叫好又叫座的经典影片，如《喜剧之王》、《食神》、《少林足球》、《唐伯虎点秋香》、《国产凌凌漆》等。近几年一直致力于演艺教育培训方面的工作，包括演艺素质培训、电影拍摄技巧、提供器材学习等。', '2022-05-09 23:23:06', '2022-05-21 09:39:34', 'p51748.jpg', 'image/jpeg', './upload/director/avatar/', '1652185976968.jpg', 63124);
INSERT INTO `director` VALUES ('1652147682816', '詹姆斯·卡梅隆', 'http://localhost:8888/director/avatar/1652147682816', 'James Cameron', '0', '加拿大,安大略,卡普斯卡辛', '　詹姆斯·卡梅隆，加拿大电影导演，擅长拍摄动作片以及科幻电影。詹姆斯·卡梅隆曾在加州的两年制社区学院学习物理学，但没多久又改主修英文，但在开学前自己休学。他到南加州大学的图书馆找资料自修学习电影特效技术，并用开卡车赚钱的空档写剧本。', '2022-05-10 09:54:42', '2022-05-21 09:39:37', 'p33715.jpg', 'image/jpeg', './upload/director/avatar/', '1652186010626.jpg', 94279);
INSERT INTO `director` VALUES ('1652147804701', '温子仁', 'http://localhost:8888/director/avatar/1652147804701', ' James Wan', '0', '马来西亚,古晋', '出生于马来西亚、成长于澳洲的华裔导演。早年在墨尔本上大学时主修的专业是中国民族划分。对于东方异域文化的了解对詹姆斯·温的导演风格也有着很大的影响，而造就他对于《电锯惊魂》和《死寂》(dead silence)之类血浆片独特口味的更重要的因素是他14岁时父亲过世的打击。', '2022-05-10 09:56:44', '2022-05-21 11:25:41', 'OIP-C.jpg', 'image/jpeg', './upload/director/avatar/', '1653103541661.jpg', 5780);
INSERT INTO `director` VALUES ('1652148133473', '雷·沃纳尔', 'http://localhost:8888/director/avatar/1652148133473', 'Leigh Whannell', '0', '澳大利亚,维多利亚,墨尔本', '雷·沃纳尔是澳洲的一位编剧、导演和演员。他经常为他的朋友温子仁的电影担任编剧。他曾经导演过两部电影，分别是2015年的《潜伏3》和2018年的《人类升级》。', '2022-05-10 10:02:13', '2022-05-21 11:26:45', '周慧明.jpeg', 'image/jpeg', './upload/director/avatar/', '1653103605409.jpeg', 27637);
INSERT INTO `director` VALUES ('1652148383742', '徐克', 'http://localhost:8888/director/avatar/1652148383742', 'Hark Tsui', '0', '越南,西贡', '1950年2月15日生于越南西贡市，祖籍广东省海丰县，出身自华侨的大家庭，共有16名兄弟姐妹。在他十岁那年，他已经对电影发生兴趣，他曾与朋友租了摄录机来拍摄魔术表演，并在校内播放。他也喜爱漫画。这对他的电影风格有很大影响。', '2022-05-10 10:06:23', '2022-05-21 09:52:09', 'f68d10b9925b1209bb3e0a4307028062.jpg', 'image/jpeg', './upload/director/avatar/', '1653097929669.jpg', 326404);
INSERT INTO `director` VALUES ('1652148516616', '阿尔弗雷德·希区柯克 ', 'http://localhost:8888/director/avatar/1652148516616', 'Alfred Hitchcock', '0', '英国,伦敦,莱顿斯通', '阿尔弗雷德·希区柯克，（Sir Alfred Hitchcock，1899年8月13日－1980年4月29日）原籍英国，是一位闻名世界的电影导演，尤其擅长于拍摄惊悚悬疑片。希区柯克在英国拍摄了大批默片和有声片，之后，他前往好莱坞谋求发展，并与1956年加入美国国籍，并保留了英国国籍。在长达六十年的艺术生涯中，希区柯克共拍摄了超过五十部电影，他成为历史上著名的电影艺术大师。', '2022-05-10 10:08:36', '2022-05-21 11:24:12', 'OIP-C.jpg', 'image/jpeg', './upload/director/avatar/', '1653103452024.jpg', 5780);
INSERT INTO `director` VALUES ('1652368056784', '亚历山大·阿嘉', 'http://localhost:8888/director/avatar/1652368056784', 'Alexandre Aja', '0', '法国,巴黎', '亚历山大·阿嘉，法国著名导演。阿嘉在1999年和2003年拍过《Furia》和《血色月亮》两部法国片之后,接下来的《隔山有眼》《鬼镜》和《食人鱼3D》皆为翻拍版影片(依次翻拍自1977年同名片;2003年韩国片《照出冤灵》;1978年《食人鱼》)。', '2022-05-12 23:07:36', '2022-05-21 11:22:31', 'f68d10b9925b1209bb3e0a4307028062.jpg', 'image/jpeg', './upload/director/avatar/', '1653103351965.jpg', 326404);
INSERT INTO `director` VALUES ('1652368225016', '马特·里夫斯', 'http://localhost:8888/director/avatar/1652368225016', 'Matt Reeves', '0', '美国,纽约,罗克维尔中心', '马特·里夫斯（Matt Reeves），全名马修·乔治·里夫斯（Matthew George Reeves），1966年4月27日出生于美国纽约罗克维尔中心，美国导演、编剧、制片人，毕业于南加利福尼亚大学。', '2022-05-12 23:10:25', '2022-05-21 09:50:16', '周慧明.jpeg', 'image/jpeg', './upload/director/avatar/', '1653097816111.jpeg', 27637);
INSERT INTO `director` VALUES ('1653918593878', '皮埃尔', 'http://localhost:8888/director/avatar/1653918593878', 'piaier', '1', 'rthr ', 'fsdsasdfgh', '2022-05-30 21:49:53', '2022-05-30 21:49:53', 'photo.jpg', 'image/jpeg', './upload/director/avatar/', '1653918593926.jpg', 299753);

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
  `score` float(4, 2) NULL DEFAULT 0.00,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1652237815469', '大话西游记', 'http://localhost:8888/movie/cover/1652237815469', '1652189363945', '英语/德语/俄语', '45', '2022-10-17 16:00:00', 1500, '花花4566', 'OIP-C.jpg', 'image/jpeg', './upload/movie/cover/', '1653113962684.jpg', 5780, 6.00);
INSERT INTO `movie` VALUES ('1652238044529', '复仇者联盟', 'http://localhost:8888/movie/cover/1652238044529', '1652189384380', '华语', '45222', '2022-11-12 00:00:00', 1500, '花花', '周慧明.jpeg', 'image/jpeg', './upload/movie/cover/', '1653113986967.jpeg', 27637, 0.00);
INSERT INTO `movie` VALUES ('1652322636610', '美国队长2', 'http://localhost:8888/movie/cover/1652322636610', '1652189363945', '法语/俄语/韩语', '渐渐习惯了现代生活的美国队长史蒂夫·罗杰斯（克里斯·埃文斯 Chris Evans 饰），在一次行动后隐隐嗅到神盾局内部所弥漫出来的凶险气味。', '2014-04-03 16:00:00', 1500, 'Captain America: The Winter Soldier ', '周慧明.jpeg', 'image/jpeg', './upload/movie/cover/', '1653113997365.jpeg', 27637, 0.00);
INSERT INTO `movie` VALUES ('1652322979306', 'X战警：逆转未来', 'http://localhost:8888/movie/cover/1652322979306', '1652189363945', '法语/德语/中文', '故事的设定发生在当下，变种人族群遭到了前所未有的毁灭性打击，而这一切的根源是“魔形女”瑞文（詹妮弗·劳伦斯 Jennifer Lawrence 饰）在1973年刺杀了玻利瓦尔·特拉斯克（彼特·丁拉基 ', '2022-05-16 16:00:00', 1500, 'X-Men: Days of Future Past', '1.jpeg', 'image/jpeg', './upload/movie/cover/', '1653487866261.jpeg', 129517, 3.00);
INSERT INTO `movie` VALUES ('1652323065481', '明日边缘 ', 'http://localhost:8888/movie/cover/1652323065481', '1652189363945', '英语', '未来世界陷入外星人入侵的恐慌中，军事演说家凯奇少校（汤姆·克鲁斯 Tom Cruise 饰）畏惧上战场，他从没想过将军（布莱丹·格里森 Brendan Gleeson 饰）会让他去指挥即将开始的“诺曼', '2014-05-20 16:00:00', 1500, 'Edge of Tomorrow', 'p2185073849.webp', 'image/webp', './upload/movie/cover/', '1653914872626.webp', 28686, 0.00);
INSERT INTO `movie` VALUES ('1652323129328', '源代码 ', 'http://localhost:8888/movie/cover/1652323129328', '1652189363945', '英语', '在阿富汗执行任务的美国空军飞行员科特史蒂文斯上尉（杰克·吉伦哈尔 Jake Gyllenhaal 饰）突然惊醒，发现自己在一辆高速行驶的列车上，而他的身边坐着一个素不相识的女子克里斯蒂安（米歇尔·莫娜', '2009-05-11 16:00:00', 1500, 'Source Code', 'photo.jpg', 'image/jpeg', './upload/movie/cover/', '1653915103094.jpg', 299753, 0.00);
INSERT INTO `movie` VALUES ('1652323197911', '终结者2', 'http://localhost:8888/movie/cover/1652323197911', '1652189363945', '英语 / 西班牙语', '上一部中，超级电脑“天网”阻止人类抵抗领袖约翰·康纳诞生的行动失败，时隔13年后，在“审判日”到来之前，“天网”派出了更加先进的生化机器人T-1000（罗伯特·帕特里克 饰）从公元2029年回到洛杉矶', '2002-05-08 16:00:00', 1500, 'Terminator 2: Judgment Day', '希区柯克.jpg', 'image/jpeg', './upload/movie/cover/', '1653915111078.jpg', 20576, 0.00);
INSERT INTO `movie` VALUES ('1652323265333', '阿凡达', 'http://localhost:8888/movie/cover/1652323265333', '1652189395431', '英语', '战斗中负伤而下身瘫痪的前海军战士杰克·萨利（萨姆·沃辛顿 Sam Worthington 饰）决定替死去的同胞哥哥来到潘多拉星操纵格蕾丝博士（西格妮·韦弗 Sigourney Weaver 饰）用人类', '2016-04-24 16:00:00', 1500, 'Avatar ', '希区柯克.jpg', 'image/jpeg', './upload/movie/cover/', '1653917189675.jpg', 20576, 0.00);
INSERT INTO `movie` VALUES ('1652323356167', '变形金刚 ', 'http://localhost:8888/movie/cover/1652323356167', '1652189371834', '英语 / 西班牙语', '　“霸天虎”的先遣部队旋风和毒蝎袭击了美军位于卡塔尔的军事基地，与此同时，路障帮助他的搭档迷乱潜入了美国总统的座机空中一号，通过电脑获悉，要想找到威震天就必须找到维特维奇家族的那副眼镜，上面有威震天关', '2012-05-23 16:00:00', 1500, 'Transformers', 'p2185073849.webp', 'image/webp', './upload/movie/cover/', '1653917599922.webp', 28686, 6.22);
INSERT INTO `movie` VALUES ('1652323435978', '蜘蛛侠', 'http://localhost:8888/movie/cover/1652323435978', '1652189403822', '英语', '彼得 帕克（托比•马奎尔 Tobey Maguire 饰）只是美国一个平凡的高中生，当一次他被蜘蛛博物馆偷跑出来的变种蜘蛛咬了一口之后，彼得的生活彻底改变了。他变得和蜘蛛一样，拥有各种蜘蛛特有的超能力', '2008-05-21 16:00:00', 1500, 'Spider-Man', '周慧明.jpeg', 'image/jpeg', './upload/movie/cover/', '1653915123653.jpeg', 27637, 0.00);
INSERT INTO `movie` VALUES ('1652323545139', '金刚狼', 'http://localhost:8888/movie/cover/1652323545139', '1652189371834', '英语', '　　1845年，尚年幼的维克多与詹姆斯兄弟俩在长辈之间一场突如其来争执中唤醒了自身的潜能，詹姆斯情急之下将陌生的生父杀死，自此兄弟两人流落战场', '2008-04-22 16:00:00', 1500, 'Wolverine', '希区柯克.jpg', 'image/jpeg', './upload/movie/cover/', '1653917619397.jpg', 20576, 0.00);
INSERT INTO `movie` VALUES ('1653092993980', '致命ID', 'http://localhost:8888/movie/cover/1653092993980', '1652189378407', '英语', 'fefer', '2022-05-14 16:00:00', 1500, '恐吓', 'OIP-C.jpg', 'image/jpeg', './upload/movie/cover/', '1653114124086.jpg', 5780, 0.00);
INSERT INTO `movie` VALUES ('1653093101630', 'rfrfr', NULL, '1652189395431', '爱尔兰语/爱沙尼亚语/阿塞拜疆语', 'w2w2', '2022-05-07 16:00:00', 1500, 'w2w2', NULL, NULL, NULL, NULL, NULL, 0.00);
INSERT INTO `movie` VALUES ('1653093159957', 'rrrr', NULL, '1652189384380', '芬兰语/菲律宾语', 'r3r', '2022-05-07 16:00:00', 1500, 'rrr', NULL, NULL, NULL, NULL, NULL, 0.00);
INSERT INTO `movie` VALUES ('1653093195764', 'r43r43', NULL, '1652189384380', '奥利亚语/爱沙尼亚语', 'r43r4', '2022-05-09 16:00:00', 1500, 'r34r34r', NULL, NULL, NULL, NULL, NULL, 0.00);
INSERT INTO `movie` VALUES ('1653093614667', '34r43r4', 'http://localhost:8888/movie/cover/1653093614667', '1652189371834', '英语/韩语/日语', '4r34r34r', '2022-05-03 16:00:00', 1500, '3r443r', 'p2185073849.webp', 'image/webp', './upload/movie/cover/', '1653917218831.webp', 28686, 0.00);
INSERT INTO `movie` VALUES ('1653093675274', '34r34r', NULL, '1652189384380', '意大利语/西班牙语', '4r43r43r', '2022-05-01 16:00:00', 1500, 'r334r', NULL, NULL, NULL, NULL, NULL, 0.00);
INSERT INTO `movie` VALUES ('1653228335073', 'w\'s\'w\'s', 'http://localhost:8888/movie/cover/1653228335073', '1652189371834', '中文/英语', '得得', '2022-05-10 16:00:00', 15000, '得得', 'f68d10b9925b1209bb3e0a4307028062.jpg', 'image/jpeg', './upload/movie/cover/', '1653228335209.jpg', 326404, 0.00);
INSERT INTO `movie` VALUES ('1653489563065', '假如爱有天意', 'http://localhost:8888/movie/cover/1653489563065', '1652189363945', '韩语/泰语', '饰）留下的情书，在阅读中她重温着母亲的初恋回忆。1968年的珠喜，是一个清纯可爱的少女，与穷学生俊河（曹承佑饰）一见钟情，由于珠喜显赫的家世，令两人的恋爱陷入俗套的门不当户不对的痛苦纠结中。2003年', '2015-05-03 16:00:00', 15000, '佳佳', '周慧明.jpeg', 'image/jpeg', './upload/movie/cover/', '1653489563149.jpeg', 27637, 0.00);
INSERT INTO `movie` VALUES ('1653918216406', '猪头', 'http://localhost:8888/movie/cover/1653918216406', '1652189384380', '德语/韩语', '45太5他太其他七条', '2022-05-17 16:00:00', 15000, '太沟通无果', 'OIP-C.jpg', 'image/jpeg', './upload/movie/cover/', '1653918216515.jpg', 5780, 0.00);
INSERT INTO `movie` VALUES ('1653918255848', '太提高给', 'http://localhost:8888/movie/cover/1653918255848', '1652189371834', '德语/法语', '过他沟通无果', '2021-12-06 16:00:00', 15000, '太他他', '周慧明.jpeg', 'image/jpeg', './upload/movie/cover/', '1653918255921.jpeg', 27637, 0.00);
INSERT INTO `movie` VALUES ('1653918306384', '而非热风热风', 'http://localhost:8888/movie/cover/1653918306384', '1652189384380', '英语/俄语', '废人高清版有 ', '2015-05-13 16:00:00', 15000, '风热风热', '希区柯克.jpg', 'image/jpeg', './upload/movie/cover/', '1653918306466.jpg', 20576, 0.00);
INSERT INTO `movie` VALUES ('1653918353049', '给他人外国人沟通', 'http://localhost:8888/movie/cover/1653918353049', '1652189371834', '班巴拉语/白俄罗斯语/巴斯克语', '过歌', '2022-05-09 16:00:00', 15000, '过而且给', 'p2185073849.webp', 'image/webp', './upload/movie/cover/', '1653918353128.webp', 28686, 0.00);
INSERT INTO `movie` VALUES ('1653918415127', '罗三炮', 'http://localhost:8888/movie/cover/1653918415127', '1652189371834', '波斯尼亚语/波斯语', '局域居然', '2022-05-23 16:00:00', 1500, '看i看', 'OIP-C.jpg', 'image/jpeg', './upload/movie/cover/', '1653918415213.jpg', 5780, 0.00);

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
INSERT INTO `movie_actor` VALUES ('1652238044529', '1652014592779', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_actor` VALUES ('1652238044529', '1652494690386', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_actor` VALUES ('1653092993980', '1652494690386', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_actor` VALUES ('1653092993980', '1652494639677', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_actor` VALUES ('1653228335073', '1652152775219', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_actor` VALUES ('1653228335073', '1652152736343', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_actor` VALUES ('1652322979306', '1652152809362', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_actor` VALUES ('1652322979306', '1652152720292', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_actor` VALUES ('1652322979306', '1652152736343', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_actor` VALUES ('1652237815469', '1652152809362', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_actor` VALUES ('1652237815469', '1652152736343', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_actor` VALUES ('1652322636610', '1652152711455', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_actor` VALUES ('1652322636610', '1652014592779', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_actor` VALUES ('1652322636610', '1652152775219', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_actor` VALUES ('1653093675274', '1652152758674', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_actor` VALUES ('1653093675274', '1652152720292', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_actor` VALUES ('1653093195764', '1652152809362', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_actor` VALUES ('1653093101630', '1652152809362', '2022-05-25 22:28:48', '2022-05-25 22:28:48');
INSERT INTO `movie_actor` VALUES ('1653093159957', '1652152711455', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_actor` VALUES ('1653489563065', '1653099331792', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_actor` VALUES ('1653489563065', '1652494690386', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_actor` VALUES ('1653489563065', '1652491465151', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_actor` VALUES ('1653489563065', '1652444349475', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_actor` VALUES ('1652323065481', '1652152775219', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_actor` VALUES ('1652323065481', '1652152736343', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_actor` VALUES ('1652323065481', '1652152711455', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_actor` VALUES ('1652323129328', '1652152775219', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_actor` VALUES ('1652323129328', '1652152736343', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_actor` VALUES ('1652323129328', '1652152720292', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_actor` VALUES ('1652323129328', '1652152711455', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_actor` VALUES ('1652323435978', '1652152711455', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_actor` VALUES ('1652323435978', '1652152775219', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_actor` VALUES ('1652323265333', '1652152809362', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_actor` VALUES ('1652323265333', '1652152720292', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_actor` VALUES ('1653093614667', '1652152775219', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_actor` VALUES ('1652323356167', '1652152809362', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_actor` VALUES ('1652323356167', '1652152736343', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_actor` VALUES ('1653918216406', '1652152775219', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_actor` VALUES ('1653918216406', '1652152736343', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_actor` VALUES ('1653918255848', '1652152775219', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_actor` VALUES ('1653918255848', '1652152736343', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_actor` VALUES ('1653918255848', '1652152758674', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_actor` VALUES ('1653918306384', '1652152809362', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_actor` VALUES ('1653918306384', '1652152775219', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_actor` VALUES ('1653918306384', '1652152736343', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_actor` VALUES ('1653918306384', '1652152711455', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_actor` VALUES ('1653918353049', '1653099398251', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_actor` VALUES ('1653918353049', '1653099331792', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_actor` VALUES ('1653918353049', '1652494690386', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_actor` VALUES ('1653918415127', '1652152775219', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_actor` VALUES ('1653918415127', '1652152736343', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_actor` VALUES ('1653918415127', '1653789676790', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_actor` VALUES ('1652323197911', '1652152736343', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_actor` VALUES ('1652323545139', '1652152775219', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_actor` VALUES ('1652323545139', '1652152736343', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_actor` VALUES ('1652323545139', '1652152711455', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_actor` VALUES ('1652323545139', '1652014592779', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_actor` VALUES ('1652323545139', '1652152720292', '2022-05-31 10:34:09', '2022-05-31 10:34:09');

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
INSERT INTO `movie_area_relate` VALUES ('1652238044529', '1652189733153', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_area_relate` VALUES ('1652238044529', '1652189745734', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_area_relate` VALUES ('1652238044529', '1652189767862', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_area_relate` VALUES ('1653092993980', '1652189733153', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_area_relate` VALUES ('1653092993980', '1652189738937', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_area_relate` VALUES ('1653228335073', '1652189738937', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_area_relate` VALUES ('1653228335073', '1652189726243', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_area_relate` VALUES ('1652322979306', '1652189738937', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_area_relate` VALUES ('1652322979306', '1652189774756', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_area_relate` VALUES ('1652237815469', '1652189767862', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_area_relate` VALUES ('1652322636610', '1652189738937', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_area_relate` VALUES ('1653093675274', '1652189781103', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_area_relate` VALUES ('1653093675274', '1652189767862', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_area_relate` VALUES ('1653093195764', '1652189774756', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_area_relate` VALUES ('1653093101630', '1652189774756', '2022-05-25 22:28:48', '2022-05-25 22:28:48');
INSERT INTO `movie_area_relate` VALUES ('1653093159957', '1652189774756', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_area_relate` VALUES ('1653093159957', '1652189767862', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_area_relate` VALUES ('1653489563065', '1652189767862', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_area_relate` VALUES ('1652323065481', '1652189738937', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_area_relate` VALUES ('1652323065481', '1652189789100', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_area_relate` VALUES ('1652323129328', '1652189733153', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_area_relate` VALUES ('1652323129328', '1652189738937', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_area_relate` VALUES ('1652323129328', '1652189745734', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_area_relate` VALUES ('1652323129328', '1652189762304', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_area_relate` VALUES ('1652323435978', '1652189781103', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_area_relate` VALUES ('1652323435978', '1652189815366', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_area_relate` VALUES ('1652323265333', '1652189767862', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_area_relate` VALUES ('1652323265333', '1652189774756', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_area_relate` VALUES ('1653093614667', '1652189774756', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_area_relate` VALUES ('1652323356167', '1652189815366', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_area_relate` VALUES ('1653918216406', '1652189726243', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_area_relate` VALUES ('1653918255848', '1652189733153', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_area_relate` VALUES ('1653918306384', '1652189738937', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_area_relate` VALUES ('1653918306384', '1652189762304', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_area_relate` VALUES ('1653918353049', '1652189745734', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_area_relate` VALUES ('1653918353049', '1652189738937', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_area_relate` VALUES ('1653918415127', '1652189745734', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_area_relate` VALUES ('1653918415127', '1652189767862', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_area_relate` VALUES ('1653918415127', '1652189774756', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_area_relate` VALUES ('1652323197911', '1652189733153', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_area_relate` VALUES ('1652323545139', '1652189733153', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_area_relate` VALUES ('1652323545139', '1652189738937', '2022-05-31 10:34:09', '2022-05-31 10:34:09');

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
INSERT INTO `movie_cate_relate` VALUES ('1652238044529', '1652190067124', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_cate_relate` VALUES ('1652238044529', '1652190106859', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_cate_relate` VALUES ('1653092993980', '1652190087259', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_cate_relate` VALUES ('1653092993980', '1652190079476', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_cate_relate` VALUES ('1653228335073', '1652190067124', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_cate_relate` VALUES ('1653228335073', '1652190048721', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_cate_relate` VALUES ('1652322979306', '1652190148322', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_cate_relate` VALUES ('1652322979306', '1652190067124', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_cate_relate` VALUES ('1652322979306', '1652190054769', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_cate_relate` VALUES ('1652237815469', '1652190067124', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_cate_relate` VALUES ('1652322636610', '1652190054769', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_cate_relate` VALUES ('1652322636610', '1652190067124', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_cate_relate` VALUES ('1653093675274', '1652190072644', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_cate_relate` VALUES ('1653093675274', '1652190054769', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_cate_relate` VALUES ('1653093195764', '1652190072644', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_cate_relate` VALUES ('1653093101630', '1652190060642', '2022-05-25 22:28:48', '2022-05-25 22:28:48');
INSERT INTO `movie_cate_relate` VALUES ('1653093159957', '1652190067124', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_cate_relate` VALUES ('1653489563065', '1652190060642', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_cate_relate` VALUES ('1653489563065', '1652190028186', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_cate_relate` VALUES ('1652323065481', '1652190067124', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_cate_relate` VALUES ('1652323065481', '1652190054769', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_cate_relate` VALUES ('1652323129328', '1652190079476', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_cate_relate` VALUES ('1652323129328', '1652190087259', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_cate_relate` VALUES ('1652323435978', '1652190135212', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_cate_relate` VALUES ('1652323435978', '1652190141232', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_cate_relate` VALUES ('1652323435978', '1652190164468', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_cate_relate` VALUES ('1652323265333', '1652190087259', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_cate_relate` VALUES ('1652323265333', '1652190072644', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_cate_relate` VALUES ('1652323265333', '1652190067124', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_cate_relate` VALUES ('1653093614667', '1652190072644', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_cate_relate` VALUES ('1652323356167', '1652190141232', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_cate_relate` VALUES ('1652323356167', '1652190135212', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_cate_relate` VALUES ('1652323356167', '1652190130069', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_cate_relate` VALUES ('1653918216406', '1652190079476', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_cate_relate` VALUES ('1653918216406', '1652190060642', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_cate_relate` VALUES ('1653918255848', '1652190158982', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_cate_relate` VALUES ('1653918306384', '1652190067124', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_cate_relate` VALUES ('1653918306384', '1652190054769', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_cate_relate` VALUES ('1653918306384', '1652190048721', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_cate_relate` VALUES ('1653918306384', '1652190028186', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_cate_relate` VALUES ('1653918353049', '1652190072644', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_cate_relate` VALUES ('1653918353049', '1652190067124', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_cate_relate` VALUES ('1653918415127', '1652190054769', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_cate_relate` VALUES ('1653918415127', '1652190067124', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_cate_relate` VALUES ('1653918415127', '1652190087259', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_cate_relate` VALUES ('1652323197911', '1652190079476', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_cate_relate` VALUES ('1652323197911', '1652190067124', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_cate_relate` VALUES ('1652323197911', '1652190054769', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_cate_relate` VALUES ('1652323197911', '1652190093028', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_cate_relate` VALUES ('1652323545139', '1652190087259', '2022-05-31 10:34:09', '2022-05-31 10:34:09');

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
INSERT INTO `movie_director` VALUES ('1652238044529', '1652109786913', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_director` VALUES ('1652238044529', '1652105949804', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_director` VALUES ('1653092993980', '1652368056784', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_director` VALUES ('1653092993980', '1652105949804', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_director` VALUES ('1653228335073', '1652109629705', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_director` VALUES ('1653228335073', '1652105949804', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_director` VALUES ('1653228335073', '1652109714661', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_director` VALUES ('1652322979306', '1652109714661', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_director` VALUES ('1652322979306', '1652147682816', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_director` VALUES ('1652322979306', '1652105949804', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_director` VALUES ('1652237815469', '1652105949804', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_director` VALUES ('1652322636610', '1652097604414', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_director` VALUES ('1652322636610', '1652105949804', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_director` VALUES ('1653093675274', '1652109714661', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_director` VALUES ('1653093675274', '1652105870601', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_director` VALUES ('1653093675274', '1652105949804', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_director` VALUES ('1653093195764', '1652109786913', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_director` VALUES ('1653093195764', '1652368056784', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_director` VALUES ('1653093101630', '1652105949804', '2022-05-25 22:28:48', '2022-05-25 22:28:48');
INSERT INTO `movie_director` VALUES ('1653093159957', '1652105949804', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_director` VALUES ('1653489563065', '1652148133473', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_director` VALUES ('1653489563065', '1652109629705', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_director` VALUES ('1652323065481', '1652148383742', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_director` VALUES ('1652323065481', '1652148133473', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_director` VALUES ('1652323065481', '1652147804701', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_director` VALUES ('1652323065481', '1652105949804', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_director` VALUES ('1652323129328', '1652109714661', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_director` VALUES ('1652323129328', '1652105870601', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_director` VALUES ('1652323129328', '1652097707616', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_director` VALUES ('1652323435978', '1652148133473', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_director` VALUES ('1652323435978', '1652109629705', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_director` VALUES ('1652323265333', '1652109714661', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_director` VALUES ('1652323265333', '1652105949804', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_director` VALUES ('1652323265333', '1652097604414', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_director` VALUES ('1653093614667', '1652109714661', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_director` VALUES ('1653093614667', '1652097604414', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_director` VALUES ('1652323356167', '1652147682816', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_director` VALUES ('1652323356167', '1652109714661', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_director` VALUES ('1652323356167', '1652105949804', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_director` VALUES ('1653918216406', '1652109629705', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_director` VALUES ('1653918216406', '1652097707616', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_director` VALUES ('1653918255848', '1652109714661', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_director` VALUES ('1653918255848', '1652105870601', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_director` VALUES ('1653918306384', '1652109786913', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_director` VALUES ('1653918306384', '1652105949804', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_director` VALUES ('1653918306384', '1652105870601', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_director` VALUES ('1653918306384', '1652097707616', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_director` VALUES ('1653918353049', '1652148383742', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_director` VALUES ('1653918353049', '1652147804701', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_director` VALUES ('1653918415127', '1652109629705', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_director` VALUES ('1653918415127', '1652105949804', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_director` VALUES ('1653918415127', '1652097707616', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_director` VALUES ('1652323197911', '1652148383742', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_director` VALUES ('1652323197911', '1652148516616', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_director` VALUES ('1652323197911', '1652097604414', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_director` VALUES ('1652323545139', '1652109786913', '2022-05-31 10:34:09', '2022-05-31 10:34:09');
INSERT INTO `movie_director` VALUES ('1652323545139', '1652105949804', '2022-05-31 10:34:09', '2022-05-31 10:34:09');

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
INSERT INTO `movie_screenwriter_relate` VALUES ('1652238044529', '1652195889420', '2022-05-21 14:19:46', '2022-05-21 14:19:46');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653092993980', '1652195889420', '2022-05-21 18:17:33', '2022-05-21 18:17:33');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653228335073', '1652195889420', '2022-05-22 22:05:35', '2022-05-22 22:05:35');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652322979306', '1652195889420', '2022-05-25 22:11:06', '2022-05-25 22:11:06');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652237815469', '1652195889420', '2022-05-25 22:27:38', '2022-05-25 22:27:38');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652322636610', '1652195889420', '2022-05-25 22:28:03', '2022-05-25 22:28:03');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653093675274', '1652195889420', '2022-05-25 22:28:23', '2022-05-25 22:28:23');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653093195764', '1652195889420', '2022-05-25 22:28:36', '2022-05-25 22:28:36');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653093101630', '1652195889420', '2022-05-25 22:28:48', '2022-05-25 22:28:48');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653093159957', '1652195889420', '2022-05-25 22:29:00', '2022-05-25 22:29:00');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653489563065', '1652195889420', '2022-05-25 22:39:23', '2022-05-25 22:39:23');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323065481', '1652195889420', '2022-05-30 20:47:52', '2022-05-30 20:47:52');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323129328', '1652195889420', '2022-05-30 20:51:43', '2022-05-30 20:51:43');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323435978', '1652195889420', '2022-05-30 20:52:03', '2022-05-30 20:52:03');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323265333', '1652195889420', '2022-05-30 21:26:29', '2022-05-30 21:26:29');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653093614667', '1652195889420', '2022-05-30 21:26:58', '2022-05-30 21:26:58');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323356167', '1652195889420', '2022-05-30 21:33:19', '2022-05-30 21:33:19');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918216406', '1653806571714', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918216406', '1653808946753', '2022-05-30 21:43:36', '2022-05-30 21:43:36');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918255848', '1653808925155', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918255848', '1653806523028', '2022-05-30 21:44:15', '2022-05-30 21:44:15');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918306384', '1653808925155', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918306384', '1653806434280', '2022-05-30 21:45:06', '2022-05-30 21:45:06');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918353049', '1653813429748', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918353049', '1653808958369', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918353049', '1653808946753', '2022-05-30 21:45:53', '2022-05-30 21:45:53');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918415127', '1653806523028', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918415127', '1653806571714', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_screenwriter_relate` VALUES ('1653918415127', '1653806434280', '2022-05-30 21:47:32', '2022-05-30 21:47:32');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323197911', '1652195889420', '2022-05-30 21:48:15', '2022-05-30 21:48:15');
INSERT INTO `movie_screenwriter_relate` VALUES ('1652323545139', '1652195889420', '2022-05-31 10:34:09', '2022-05-31 10:34:09');

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
INSERT INTO `occupation_relate` VALUES (NULL, '1652109629705', NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES (NULL, '1652109629705', NULL, '1652100330901');
INSERT INTO `occupation_relate` VALUES (NULL, '1652109714661', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652109714661', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652109786913', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652109786913', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652147682816', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652147682816', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES ('1652494639677', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652494639677', NULL, NULL, '1652100330901');
INSERT INTO `occupation_relate` VALUES ('1652494690386', NULL, NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES ('1652494690386', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652368225016', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652368225016', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105949804', NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105949804', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105949804', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105949804', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148383742', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148383742', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES ('1653099331792', NULL, NULL, '1652100375330');
INSERT INTO `occupation_relate` VALUES ('1653099331792', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1653099398251', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1653099398251', NULL, NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES ('1652152758674', NULL, NULL, '1652100375330');
INSERT INTO `occupation_relate` VALUES ('1652152758674', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652152736343', NULL, NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES ('1652152736343', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1652152711455', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1652152711455', NULL, NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652368056784', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652368056784', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652368056784', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148516616', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148516616', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148516616', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652147804701', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652147804701', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652148133473', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES ('1652152809362', NULL, NULL, '1652100330901');
INSERT INTO `occupation_relate` VALUES ('1652152809362', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1652444349475', NULL, NULL, '1652100330901');
INSERT INTO `occupation_relate` VALUES ('1652444349475', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652444349475', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1652491465151', NULL, NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES ('1652491465151', NULL, NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES ('1652491465151', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1652152775219', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652152775219', NULL, NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097604414', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES ('1652014592779', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652014592779', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097707616', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652097707616', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105870601', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105870601', NULL, '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, '1652105870601', NULL, '1652100321467');
INSERT INTO `occupation_relate` VALUES ('1653789676790', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES ('1653789676790', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653813429748', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653813429748', '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652152720292', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1652152720292', NULL, NULL, '1652100330901');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1652195889420', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1652195889420', '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806434280', '1652100375330');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806434280', '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806434280', '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806523028', '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806523028', '1652100330901');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806523028', '1652100464525');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806571714', '1652100137884');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806571714', '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806571714', '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653806571714', '1652100321467');
INSERT INTO `occupation_relate` VALUES ('1653831630847', NULL, NULL, '1652100361394');
INSERT INTO `occupation_relate` VALUES ('1653831630847', NULL, NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808925155', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808925155', '1652100361394');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808946753', '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808946753', '1652100330901');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808958369', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653808958369', '1652100361394');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653813215148', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653813215148', '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653831790650', '1652100321467');
INSERT INTO `occupation_relate` VALUES (NULL, NULL, '1653831790650', '1652100330901');
INSERT INTO `occupation_relate` VALUES (NULL, '1653918593878', NULL, '1652100306026');
INSERT INTO `occupation_relate` VALUES (NULL, '1653918593878', NULL, '1652100299387');
INSERT INTO `occupation_relate` VALUES (NULL, '1653918593878', NULL, '1652100137884');

-- ----------------------------
-- Table structure for publish
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `foreignName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `logoUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `representative` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '法定代表人',
  `industry` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属行业',
  `establish` timestamp NULL DEFAULT NULL COMMENT '成立时间',
  `online` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '官方网站',
  `organizer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主办单位',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型',
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetytpe` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  UNIQUE INDEX `foreignName`(`foreignName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publish
-- ----------------------------
INSERT INTO `publish` VALUES ('1653032869237', '人民邮电出版社', 'renmin', NULL, '郭斌', '教育读物', '1999-08-15 00:00:00', 'https:www.baidu.com', '大洗浴', '欢饮来袭', '教育', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653035770353', '1', '2', NULL, '3', '4', '2022-05-07 16:00:00', '5', '7', '8', '6', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038245076', 'cec', 'cevef', NULL, 'ferf', 'vfevefv', '2022-04-29 16:00:00', 'verfre', 'fref', 'frefec', 'ferfre', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038331081', 'cevev', 'yhythyt', NULL, 'vrhyh', 'yhtyhyth', '2022-05-08 16:00:00', 'htyhth', 'ythtyhyt', 'rfvtg', 'hythtyh', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038442270', 'frf4r4', '5t5t', NULL, '545', '5445', '2022-05-02 16:00:00', 'gtgt', 'r4g4', '45f4rf', 'ff4rf', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038457068', '发v如果', 'g\'r\'t\'g\'r\'tv', NULL, '放热峰', 'grtgrtvr\'t', '2022-05-02 16:00:00', 'rt非人非', '分飞', '非人非', '分 ', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038473735', '非人非', '肥肉', NULL, ' 个人个', ' 非人非', '2022-05-02 16:00:00', 'hh用户', '和5和', '个人', '给给', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038486389', '肥肉', '4过 ', NULL, '过', '过 ', '2022-04-26 16:00:00', '过给', '过 ', ' 过 过 ', '给', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038502126', '过过5通过', '团体4跳过过', NULL, '过 4gg给该', ' 该4他4 ', '2022-05-03 16:00:00', '他痛过5g\'t', 'gt 过给4', '过 4  4g', '给4 过 ', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038521517', '过过5 ', 'g4给', NULL, '4 4', '4 过5g', '2022-05-04 16:00:00', '给4过 ', '过5 ', '给4 g', 'g 过g', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038537530', '过过 ', ' 过4过g', NULL, '过给', 'g过给', '2022-04-27 16:00:00', '过给g', '过给', '给4给 过', '过 ', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038556652', '过给过5给g', '过5 过', NULL, '给4给4', '过给', '2022-05-16 16:00:00', '过 ', '过 4', ' 过 过54该4 ', ' 过给4', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `publish` VALUES ('1653038672396', '违法燃放', '访问', NULL, '服务服务费', '分威风', '2022-05-02 16:00:00', '分威风', '发无法', ' f\'w\'f\'w', 'fwfw f\'w\'f', NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `screenwriter` VALUES ('1652195889420', '兰晓龙', 'http://localhost:8888/screenwriter/avatar/1652195889420', 'Xiaolong Lan', '0', '中国，湖南邵阳', '2022-04-04 00:00:00', '　兰晓龙，湖南邵阳人，1973年5月26日出生。1997年毕业于中央戏剧学院，后进入北京军区战友话剧团成为一名职业编剧。曾创作了话剧《红星照耀中国》，电视剧《石磊大夫》、《步兵团长》、《士兵突击》、《我的团长我的团》、《生死线》。', '兰图', '2022-05-10 23:18:09', '2022-05-29 20:57:51', '希区柯克.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653829071171.jpg', 20576);
INSERT INTO `screenwriter` VALUES ('1653806434280', '伦琴', 'http://localhost:8888/screenwriter/avatar/1653806434280', 'lunqin', '0', '中国，烧心', '2022-04-04 00:00:00', '伦琴射线', '兰图222', '2022-05-29 14:40:34', '2022-05-29 20:58:13', '周慧明.jpeg', 'image/jpeg', './upload/screenwriter/avatar/', '1653829093162.jpeg', 27637);
INSERT INTO `screenwriter` VALUES ('1653806523028', '放放 ', 'http://localhost:8888/screenwriter/avatar/1653806523028', '放我', '0', '放无法', '2022-05-02 16:00:00', '分为4发', '放发', '2022-05-29 14:42:03', '2022-05-29 20:58:46', 'OIP-C.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653829126025.jpg', 5780);
INSERT INTO `screenwriter` VALUES ('1653806571714', '服务服务', 'http://localhost:8888/screenwriter/avatar/1653806571714', '分威风', '0', '服务服务', '2022-04-25 16:00:00', '分威风无法', '分威风', '2022-05-29 14:42:51', '2022-05-29 20:58:56', '希区柯克.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653829136853.jpg', 20576);
INSERT INTO `screenwriter` VALUES ('1653808925155', '猜测出', 'http://localhost:8888/screenwriter/avatar/1653808925155', '人佛如', '0', '放入', '2022-04-25 16:00:00', '放入', '飞人废人', '2022-05-29 15:22:05', '2022-05-29 21:42:14', 'OIP-C.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653831734433.jpg', 5780);
INSERT INTO `screenwriter` VALUES ('1653808946753', '飞人废人', 'http://localhost:8888/screenwriter/avatar/1653808946753', '放入', '0', '如哥哥特', '2022-05-01 16:00:00', '给4过2给', '非人非任飞', '2022-05-29 15:22:26', '2022-05-29 21:42:21', '周慧明.jpeg', 'image/jpeg', './upload/screenwriter/avatar/', '1653831741130.jpeg', 27637);
INSERT INTO `screenwriter` VALUES ('1653808958369', '图拓风2t', 'http://localhost:8888/screenwriter/avatar/1653808958369', 't太他', '0', '图 ', '2022-05-09 16:00:00', '太他', '太5他', '2022-05-29 15:22:38', '2022-05-29 21:42:28', '希区柯克.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653831748621.jpg', 20576);
INSERT INTO `screenwriter` VALUES ('1653813215148', 'rfrfefef', 'http://localhost:8888/screenwriter/avatar/1653813215148', '大卫佛', '0', '服务服务', '2022-05-05 16:00:00', '分为氛围', '分威风', '2022-05-29 16:33:35', '2022-05-29 21:42:39', '周慧明.jpeg', 'image/jpeg', './upload/screenwriter/avatar/', '1653831759332.jpeg', 27637);
INSERT INTO `screenwriter` VALUES ('1653813429748', '么米欸额', 'http://localhost:8888/screenwriter/avatar/1653813429748', '斌', '1', '得得得', '2017-05-16 16:00:00', '得得', '得得', '2022-05-29 16:37:09', '2022-05-29 16:37:09', 'OIP-C.jpg', 'image/jpeg', './upload/screenwriter/avatar/', '1653813429818.jpg', 5780);
INSERT INTO `screenwriter` VALUES ('1653831790650', '人人', 'http://localhost:8888/screenwriter/avatar/1653831790650', '出对策微软', '1', '如4人', '2022-05-01 16:00:00', '如4 ', '如人', '2022-05-29 21:43:10', '2022-05-29 21:43:10', '周慧明.jpeg', 'image/jpeg', './upload/screenwriter/avatar/', '1653831790690.jpeg', 27637);

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

-- ----------------------------
-- Table structure for writer
-- ----------------------------
DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer`  (
  `id` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birth` timestamp NULL DEFAULT NULL,
  `deadTime` timestamp NULL DEFAULT NULL,
  `birthPlace` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `foreignName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `alias` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `avatarUrl` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `originalname` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mimetype` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `dest` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `filename` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `size` int NULL DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of writer
-- ----------------------------
INSERT INTO `writer` VALUES ('1652943859095', '毛姆', '0', '2000-04-15 00:00:00', NULL, '英国', '英国', '嘎嘎嘎', 'W. Somerset Maugham', '索默斯特·毛姆，英国著名小说家，剧作家，散文家。毛姆原是医学系学生，后转而致力写作。生于巴黎，中学毕业后在德国海德堡大学肄业。1892年至1897年在伦敦学医，并取得外科医师资格。他的第一部长篇小说《兰贝斯的丽莎》（1897）即根据他作为贝可医生在贫民区为产妇接生时的见闻用自由主义写法写成。1903-1933年，他创作了近30部剧本，深受观众欢迎。1908年，伦敦有4家剧院同时演出他的4部剧作，在英国形成空前盛况。他的喜剧受五尔德的影响较深，一般以家庭、婚姻', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-19 15:04:19', '2022-05-19 15:04:19');
INSERT INTO `writer` VALUES ('1652955888915', '刘心武', '0', '2022-05-10 16:00:00', NULL, '中国,四川,成都', '中国', 'Xinwu Liu', 'Xinwu Liu', '刘心武，1942年6月4日出生，中国当代著名作家、红学研究家。笔名刘浏、赵壮汉等。曾任中学教师、出版社编辑、《人民文学》主编、中国作协理事、全国青联委员等，并加入国际笔会中国中心。其作品以关注现实为特征，以《班主任》而闻名文坛，其长篇小说《钟鼓楼》曾获得茅盾文学奖。20世纪90年代后，成为《红楼梦》的积极研究者，曾在中央电视台《百家讲坛》栏目进行系列讲座，对红学在民间的普及与发展起到促进作用。2014年推出最新长篇小说《飘窗》。', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-19 18:24:48', '2022-05-19 18:24:48');
INSERT INTO `writer` VALUES ('1652956107444', '阿加莎·克里斯蒂', '1', '2022-05-02 16:00:00', NULL, '英国,英格兰,德文郡,托基', '英国', 'Agatha Christie', 'Agatha Mary Clarissa Miller (本名) / The Queen of Crime (昵称)', '英国著名女侦探小说家、剧作家，三大推理文学宗师之一。代表作品有《东方快车谋杀案》和《尼罗河谋杀案》等，作品曾被多次搬上银幕。 　　阿加莎·克里斯蒂被誉为举世公认的推理小说女王。她的著作英文版销量逾10亿册，而写还被译成百余种文字，销量亦逾10亿册。她一生创作了80部侦探小说和短篇故事集，19部剧本，', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-19 18:28:27', '2022-05-20 14:44:24');
INSERT INTO `writer` VALUES ('1652956205916', 'E·B·怀特', '0', '2022-05-01 16:00:00', NULL, '美国', '美国', 'E. B. White', ' Elwyn Brooks \"E. B.\" White', 'E·B·怀特(1899-1985)生于美国纽约蒙特弗农，毕业于康奈尔大学。多年来他为《纽约人》杂志担任专职撰稿人。怀特是一位颇有造诣的散文家、幽默作家、诗人和讽刺作家。对于几代美国儿童来说，他之所以出名是因为写第一流的儿童读物《小斯图亚特》(1945) 和《夏洛特的网》(1952)', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-19 18:30:05', '2022-05-19 18:30:05');
INSERT INTO `writer` VALUES ('1653029158640', '史蒂芬·霍金', '0', '2014-05-19 16:00:00', NULL, ' 英国,牛津', ' 英国', 'Stephen Hawking', '史蒂芬·威廉·霍金', '斯蒂芬·霍金（1942—2018 ）作为剑桥大学卢卡斯数学教授，他担任的是牛顿的教席。他是世界上最杰出的天才之一，被推崇为继爱因斯坦之后最伟大的理论物理学家，宇宙模型因他的工作得以改观，宇宙万物的内容也因此而重新界定。著有《时间简史》、《果壳中的宇宙》等畅销全球的科普巨作。', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:45:58', '2022-05-20 14:45:58');
INSERT INTO `writer` VALUES ('1653029377407', '司马迁', '0', '2015-05-03 16:00:00', NULL, '中国,夏阳', '中国', 'Ma Sze', '司马子长 / 史迁 / 太史公 / 司马', '司马迁（前145年-不可考），字子长，夏阳(今陕西韩城南)人。西汉史学家、散文家。司马谈之子，任太史令，因替李陵败降之事辩解而受宫刑，后任中书令。发奋继续完成所著史籍，被后世尊称为史迁、太史公、历史之父。 司马迁早年受学于孔安国、董仲舒，漫游各地，了解风俗，采集传闻。初任郎中，奉使西南。元封三年（前108）任太史令，继承父业，著述历史', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:49:37', '2022-05-20 14:49:37');
INSERT INTO `writer` VALUES ('1653029434203', '三毛', '1', '2022-05-08 16:00:00', NULL, '中国,重庆', '中国', 'Echo', '陈懋平 / 陈平', '三毛，祖籍浙江省定海，出生于重庆，是台湾70至80年代的著名作家，70年代以其在撒哈拉沙漠的生活及见闻为背景，发表充满异国风情的散文作品成名，其读者遍布全世界华人社群。白先勇认为&quot;三毛创造了一个充满传奇色彩瑰丽的浪漫世界；里面有大起大落生死相许的爱情故事，引人入胜不可思议的异国情调，非洲沙漠的驰骋，拉丁美洲原始森林的探幽——这些常人所不能及的人生经验三毛是写给年轻人看的，难怪三毛变成了海峡两岸的青春偶像。', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:50:34', '2022-05-20 14:50:34');
INSERT INTO `writer` VALUES ('1653029492771', '李银河', '1', '2000-05-08 16:00:00', NULL, '中国,北京', '中国', 'Yinhe Li', '李银河', '1952年2月4日，李银河出生于北京，籍贯衡阳市衡山县。 1974年至1977年就读于山西大学。毕业后担任《光明日报》编辑，分配于史学组。同年与王小波相识。 1978年，经友人介绍，前往国务院研究室。 1979年，就职于中国社会科学院，进行科学研究。 ', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:51:32', '2022-05-20 14:51:32');
INSERT INTO `writer` VALUES ('1653029567250', '王小波', '0', '1996-08-21 16:00:00', NULL, '中国,北京', '中国', 'Xiaobo Wang', '王小波 ', '王小波（1952-1997），男。汉族。当代著名学者、作家。他的代表作品有《黄金时代》、《白银时代》、《黑铁时代》等。被誉为中国的乔伊斯兼卡夫卡。他的唯一一部电影剧本《东宫西宫》获阿根廷国际电影节最佳编剧奖，并且入围1997年的戛纳国际电影节。', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:52:47', '2022-05-20 14:52:47');
INSERT INTO `writer` VALUES ('1653029633484', '北岛', '0', '1998-03-09 16:00:00', NULL, '中国,北京', '中国', 'Dao Bei', '赵振开(原名)', '北岛，原名赵振开，1949年生于北京。做过建筑工人、编辑、自由撰稿人。1978年在北京创办文学杂志《今天》，担任主编至今。自1987年起在欧洲和北美居住并任教。获得多种国际文学奖项及荣誉。作品被译成三十多种文字。现与家人定居香港', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:53:53', '2022-05-20 14:53:53');
INSERT INTO `writer` VALUES ('1653029685000', '萧红', '0', '1992-04-06 16:00:00', NULL, '中国', '中国', 'Hong Xiao', '张廼莹(本名)', '萧红（1911-1942），中国近现代女作家，民国四大才女之一，被誉为20世纪30年代的文学洛神。乳名荣华，学名张秀环，后由外祖父改名为张廼莹。笔名萧红、悄吟、玲玲、田娣等。1911年，出生于黑龙江省哈尔滨市呼兰区一个封建地主家庭，幼年丧母。', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:54:45', '2022-05-20 14:54:45');
INSERT INTO `writer` VALUES ('1653029738888', '鲁迅', '0', '1999-05-03 16:00:00', NULL, '中国,浙江,绍兴', '中国', 'Xun Lu', '周树人 / 周樟寿 / 周豫山 / 周豫才', '周树人（1881年9月25日－1936年10月19日），字豫才，原名樟寿，字豫山、豫亭，以笔名鲁迅闻名于世，浙江绍兴人，为20世纪中国的作家，新文化运动的领导人、文化运动的支持者，中国现代文学的奠基人和开山巨匠，在西方世界享有盛誉的中国现代文学家、思想家。鲁迅的主要成就包括杂文、短中篇小说、文学、思想和社会评论、学术著作、自然科学著作、古代典籍校勘与研究、散文、现代散文诗、旧体诗、外国文学与学术翻译作品和木刻版画的研究，对于五四运动以后的中国社会思想文化发展产', NULL, NULL, NULL, NULL, NULL, NULL, '2022-05-20 14:55:38', '2022-05-20 14:55:38');

-- ----------------------------
-- Triggers structure for table comment
-- ----------------------------
DROP TRIGGER IF EXISTS `del`;
delimiter ;;
CREATE TRIGGER `del` AFTER DELETE ON `comment` FOR EACH ROW begin
  delete from comment_img where comment_img.cId=old.id;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
