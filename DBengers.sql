-- MySQL dump 10.13  Distrib 8.0.16, for osx10.14 (x86_64)
--
-- Host: 119.202.40.103    Database: DBengers
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Album`
--

DROP TABLE IF EXISTS `Album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Album` (
  `id` int(11) NOT NULL,
  `artist_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `title` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `released_date` date NOT NULL,
  `num_stars` int(11) DEFAULT NULL,
  `description` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `genre` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `agency` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `publisher` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Album`
--

LOCK TABLES `Album` WRITE;
/*!40000 ALTER TABLE `Album` DISABLE KEYS */;
INSERT INTO `Album` VALUES (1,'idvywr','titleirjd','2019-05-19',0,'descrlgt','Classic','agencywfer','publisheruurh'),(2,'idxxjo','titlehouu','2019-05-19',0,'descaagg','Hiphop','agencyctbc','publisherntvq'),(3,'idaqpr','titleeadk','2019-05-19',0,'descurrj','Classic','agencymzyl','publisherutun'),(4,'idpedh','titleywml','2019-05-19',0,'desceorq','Hiphop','agencyeina','publishertcaj'),(5,'idjrhj','titlevqmn','2019-05-19',0,'descbfro','Balad','agencyxkta','publishercsmr'),(6,'idkyua','titlebrbh','2019-05-19',0,'desczzot','Hiphop','agencywocl','publisherszio'),(7,'idpdoy','titlewdos','2019-05-19',0,'deschhoj','R&B','agencyzylc','publishergmqw'),(8,'idowsc','titletwyr','2019-05-19',0,'descyvjg','Hiphop','agencygbtq','publisherifrj'),(9,'idhjun','titleblfy','2019-05-19',0,'desciskl','Pop','agencyrako','publisherlivw'),(10,'idbiyr','titlemksc','2019-05-19',0,'descyosj','Hiphop','agencysdvh','publisherupdy'),(11,'idvgjn','titlevile','2019-05-19',0,'descuqgf','Classic','agencylqvo','publishertdqa'),(12,'iddysf','titleewyb','2019-05-19',0,'desctbex','Hiphop','agencyqbfn','publisherbfzv'),(13,'idinqy','titleslym','2019-05-19',0,'descligb','Classic','agencywbmg','publishervtie'),(14,'idbuwj','titlefjxf','2019-05-19',0,'descagqi','Hiphop','agencywdve','publisherufgg'),(15,'idxadb','titlewhgk','2019-05-19',0,'descbgrv','Balad','agencyqlst','publisheruldx'),(16,'idhuee','titlepxei','2019-05-19',0,'descmmye','Hiphop','agencyremu','publishersvlk'),(17,'idtyjr','titleiysl','2019-05-19',0,'descoiva','Classic','agencyufwa','publishercydi'),(18,'idixor','titledjtq','2019-05-19',0,'descnwtg','Hiphop','agencyzqse','publishertglx'),(19,'idkzvw','titletumm','2019-05-19',0,'descnxie','Classic','agencykhia','publisheronoy'),(20,'idqwqf','titleredz','2019-05-19',0,'descfbxs','Hiphop','agencylhzm','publisherbysf');
/*!40000 ALTER TABLE `Album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Album_Music`
--

DROP TABLE IF EXISTS `Album_Music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Album_Music` (
  `album_id` int(11) DEFAULT NULL,
  `music_id` int(11) NOT NULL,
  `music_name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Album_Music`
--

LOCK TABLES `Album_Music` WRITE;
/*!40000 ALTER TABLE `Album_Music` DISABLE KEYS */;
INSERT INTO `Album_Music` VALUES (1,1,'music1'),(2,2,'music2'),(3,3,'music3'),(4,4,'music4'),(5,5,'music5'),(6,6,'music6'),(7,7,'music7'),(8,8,'music8'),(9,9,'music9'),(10,10,'music10'),(11,11,'music11'),(12,12,'music12'),(13,13,'music13'),(14,14,'music14'),(15,15,'music15'),(16,16,'music16'),(17,17,'music17'),(18,18,'music18'),(19,19,'music19'),(20,20,'music20');
/*!40000 ALTER TABLE `Album_Music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Artist`
--

DROP TABLE IF EXISTS `Artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Artist` (
  `id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `introduction` char(100) COLLATE utf8mb4_general_ci NOT NULL,
  `debut_date` date DEFAULT NULL,
  `debut_song` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `type` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `agency` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nationality` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `constellation` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `blood_type` char(2) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `num_stars` int(11) DEFAULT '0',
  `fanclub` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `youtube` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `facebook` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `twitter` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `profile_photo` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `artist_blood_type` CHECK ((`blood_type` in (_utf8mb4'A',_utf8mb4'B',_utf8mb4'AB',_utf8mb4'O'))),
  CONSTRAINT `artist_gender` CHECK ((`gender` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Artist`
--

LOCK TABLES `Artist` WRITE;
/*!40000 ALTER TABLE `Artist` DISABLE KEYS */;
INSERT INTO `Artist` VALUES ('idaqpr','namecdez','2019-05-19','hi! my name is namecdez','2042-05-19','songpwfa','group','F','agencydlxj','nationtprt','constyxvk','O',0,'www.tvdt.com','youtube.cvsd.com','facebook.fzuh.com','twitter.xndr.com',NULL),('idbiyr','namecsds','2019-05-19','hi! my name is namecsds','2049-05-19','songhztq','solo','M','agencysbhm','nationelzz','constdhur','AB',0,'www.omld.com','youtube.sabb.com','facebook.puov.com','twitter.yhez.com',NULL),('idbuwj','namemttb','2019-05-19','hi! my name is namemttb','2053-05-19','songjehe','solo','M','agencydksy','nationghkb','constapqb','AB',0,'www.wnyh.com','youtube.wibs.com','facebook.pigg.com','twitter.urdj.com',NULL),('iddysf','namebhlj','2019-05-19','hi! my name is namebhlj','2051-05-19','songfudy','solo','M','agencymsje','nationvzqn','constorka','A',0,'www.mguk.com','youtube.hplu.com','facebook.siaa.com','twitter.llmo.com',NULL),('idhjun','nameaaqj','2019-05-19','hi! my name is nameaaqj','2048-05-19','songlwmh','group','F','agencyyeme','nationjzud','constjzko','B',0,'www.oubm.com','youtube.didg.com','facebook.narz.com','twitter.youj.com',NULL),('idhuee','nameobql','2019-05-19','hi! my name is nameobql','2055-05-19','songeicb','solo','M','agencydjhy','nationjhxu','constedqr','A',0,'www.ngix.com','youtube.yxfd.com','facebook.gert.com','twitter.axiu.com',NULL),('idinqy','namecskl','2019-05-19','hi! my name is namecskl','2052-05-19','songomsr','group','F','agencyxvbx','nationpite','constbdmu','B',0,'www.opup.com','youtube.bcdd.com','facebook.mhqx.com','twitter.watw.com',NULL),('idixor','namecvzk','2019-05-19','hi! my name is namecvzk','2057-05-19','songfsfi','solo','M','agencyjyzx','nationffuf','constagmj','AB',0,'www.jsfx.com','youtube.gydl.com','facebook.khwe.com','twitter.rslq.com',NULL),('idjrhj','nametuqk','2019-05-19','hi! my name is nametuqk','2044-05-19','songlioj','group','F','agencykvvj','nationkscc','consthdpp','B',0,'www.qikc.com','youtube.ephf.com','facebook.xmii.com','twitter.slav.com',NULL),('idkyua','namedbrl','2019-05-19','hi! my name is namedbrl','2045-05-19','songiucm','solo','M','agencyolxm','nationccnt','constgbql','AB',0,'www.cknn.com','youtube.heqn.com','facebook.ygia.com','twitter.dkou.com',NULL),('idkzvw','namecqcf','2019-05-19','hi! my name is namecqcf','2058-05-19','songukdr','group','F','agencyzwnk','nationywbz','constyryq','O',0,'www.wmjr.com','youtube.kgqc.com','facebook.wmxa.com','twitter.jqsn.com',NULL),('idowsc','namemogc','2019-05-19','hi! my name is namemogc','2047-05-19','songxvoc','solo','M','agencyfalj','nationfqeq','constnggz','A',0,'www.moeh.com','youtube.xcda.com','facebook.fpto.com','twitter.kakd.com',NULL),('idpdoy','namethyh','2019-05-19','hi! my name is namethyh','2046-05-19','songqttk','group','F','agencycmop','nationeoki','consteynf','O',0,'www.nqst.com','youtube.vwsw.com','facebook.otlb.com','twitter.uvhg.com',NULL),('idpedh','namesmka','2019-05-19','hi! my name is namesmka','2043-05-19','songyhkr','solo','M','agencypvfu','nationdcwn','constrjda','A',0,'www.kvci.com','youtube.nwzv.com','facebook.zjvz.com','twitter.itwh.com',NULL),('idqwqf','namescza','2019-05-19','hi! my name is namescza','2059-05-19','songhhia','solo','M','agencyuiku','nationlepv','constshpi','A',0,'www.allu.com','youtube.dfuq.com','facebook.tqlh.com','twitter.eqpv.com',NULL),('idtyjr','nameyfgp','2019-05-19','hi! my name is nameyfgp','2056-05-19','songdgeq','group','F','agencyhjhq','nationoxei','constqjzh','B',0,'www.atpf.com','youtube.phrt.com','facebook.vtid.com','twitter.ssfg.com',NULL),('idvgjn','nameikol','2019-05-19','hi! my name is nameikol','2050-05-19','songhzow','group','F','agencyjrxb','nationcgtx','constsvqc','O',0,'www.uadq.com','youtube.mmzp.com','facebook.xulh.com','twitter.bvxl.com',NULL),('idvywr','namewouz','2019-05-19','hi! my name is namewouz','2040-05-19','songeccd','group','F','agencywqng','nationrqdn','constqvrv','B',0,'www.wnbg.com','youtube.obsa.com','facebook.nprs.com','twitter.qnhw.com',NULL),('idxadb','nameuiav','2019-05-19','hi! my name is nameuiav','2054-05-19','songbfhj','group','F','agencyhqsf','nationkcin','constasit','O',0,'www.pkcp.com','youtube.nsrj.com','facebook.ykvv.com','twitter.yyjk.com',NULL),('idxxjo','namekeke','2019-05-19','hi! my name is namekeke','2041-05-19','songfjes','solo','M','agencybdgj','nationbftu','constugdv','AB',0,'www.htnw.com','youtube.umca.com','facebook.tjze.com','twitter.drgp.com',NULL);
/*!40000 ALTER TABLE `Artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Artist_Comment_List`
--

DROP TABLE IF EXISTS `Artist_Comment_List`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Artist_Comment_List` (
  `artist_comment_id` int(11) NOT NULL,
  `artist_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `comment` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comment_comment` tinyint(1) DEFAULT '0',
  `comment_date` date DEFAULT NULL,
  `num_like` int(11) DEFAULT '0',
  `num_dislike` int(11) DEFAULT '0',
  PRIMARY KEY (`artist_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Artist_Comment_List`
--

LOCK TABLES `Artist_Comment_List` WRITE;
/*!40000 ALTER TABLE `Artist_Comment_List` DISABLE KEYS */;
INSERT INTO `Artist_Comment_List` VALUES (1,'idvywr','idpukh','commentyzqj',0,'2019-05-19',0,0),(2,'idxxjo','idpukh','commentyryl',0,'2019-05-19',0,0),(3,'idaqpr','idpukh','commenthjyu',0,'2019-05-19',0,0),(4,'idpedh','idpukh','commenttyti',0,'2019-05-19',0,0),(5,'idjrhj','idpukh','commentmafx',0,'2019-05-19',0,0),(6,'idkyua','idpukh','commentpqvs',0,'2019-05-19',0,0),(7,'idpdoy','idpukh','commentotwn',0,'2019-05-19',0,0),(8,'idowsc','idpukh','commenteiar',0,'2019-05-19',0,0),(9,'idhjun','idpukh','commentuwst',0,'2019-05-19',0,0),(10,'idbiyr','idpukh','commentqxav',0,'2019-05-19',0,0),(11,'idvgjn','idpukh','commentfhra',0,'2019-05-19',0,0),(12,'iddysf','idpukh','commentmnnu',0,'2019-05-19',0,0),(13,'idinqy','idpukh','commentipgj',0,'2019-05-19',0,0),(14,'idbuwj','idpukh','commentizpc',0,'2019-05-19',0,0),(15,'idxadb','idpukh','commentwkgu',0,'2019-05-19',0,0),(16,'idhuee','idpukh','commentfyvo',0,'2019-05-19',0,0),(17,'idtyjr','idpukh','commentnoyw',0,'2019-05-19',0,0),(18,'idixor','idpukh','commentoqwa',0,'2019-05-19',0,0),(19,'idkzvw','idpukh','commentrsxs',0,'2019-05-19',0,0),(20,'idqwqf','idpukh','commentxwmq',0,'2019-05-19',0,0);
/*!40000 ALTER TABLE `Artist_Comment_List` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hashtag`
--

DROP TABLE IF EXISTS `Hashtag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Hashtag` (
  `tagname` char(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `playlist_name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hashtag`
--

LOCK TABLES `Hashtag` WRITE;
/*!40000 ALTER TABLE `Hashtag` DISABLE KEYS */;
/*!40000 ALTER TABLE `Hashtag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HashtagNames`
--

DROP TABLE IF EXISTS `HashtagNames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `HashtagNames` (
  `tagname` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `cnt` int(11) NOT NULL,
  PRIMARY KEY (`tagname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HashtagNames`
--

LOCK TABLES `HashtagNames` WRITE;
/*!40000 ALTER TABLE `HashtagNames` DISABLE KEYS */;
/*!40000 ALTER TABLE `HashtagNames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Login_Data_List`
--

DROP TABLE IF EXISTS `Login_Data_List`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Login_Data_List` (
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `login_date` date DEFAULT NULL,
  `login_wrong_count` int(11) DEFAULT '0',
  `login_wrong_time` datetime DEFAULT NULL,
  `user_login_IP` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login_Data_List`
--

LOCK TABLES `Login_Data_List` WRITE;
/*!40000 ALTER TABLE `Login_Data_List` DISABLE KEYS */;
/*!40000 ALTER TABLE `Login_Data_List` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Music`
--

DROP TABLE IF EXISTS `Music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Music` (
  `music_id` int(11) NOT NULL,
  `artist_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `album_id` int(11) DEFAULT NULL,
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `released_date` date NOT NULL,
  `genre` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lyrics` char(100) COLLATE utf8mb4_general_ci NOT NULL,
  `download_num` int(11) DEFAULT '0',
  `play_num` int(11) DEFAULT '0',
  PRIMARY KEY (`music_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Music`
--

LOCK TABLES `Music` WRITE;
/*!40000 ALTER TABLE `Music` DISABLE KEYS */;
INSERT INTO `Music` VALUES (1,'idvywr',1,'music1','2019-05-19','Classic','lyric1 qpzvisqqfd',0,0),(2,'idxxjo',2,'music2','2019-05-19','Hiphop','lyric2 rajwbbsnnw',0,0),(3,'idaqpr',3,'music3','2019-05-19','Classic','lyric3 svethsyaiy',0,0),(4,'idpedh',4,'music4','2019-05-19','Hiphop','lyric4 mlxwigncho',0,0),(5,'idjrhj',5,'music5','2019-05-19','Balad','lyric5 ivtbrnynaw',0,0),(6,'idkyua',6,'music6','2019-05-19','Hiphop','lyric6 obryiayafv',0,0),(7,'idpdoy',7,'music7','2019-05-19','R&B','lyric7 ayihqiljsk',0,0),(8,'idowsc',8,'music8','2019-05-19','Hiphop','lyric8 cdlznhctfk',0,0),(9,'idhjun',9,'music9','2019-05-19','Pop','lyric9 jtlpezxiht',0,0),(10,'idbiyr',10,'music10','2019-05-19','Hiphop','lyric10 gseujchlmg',0,0),(11,'idvgjn',11,'music11','2019-05-19','Classic','lyric11 whidfloaxq',0,0),(12,'iddysf',12,'music12','2019-05-19','Hiphop','lyric12 zxitjdmryt',0,0),(13,'idinqy',13,'music13','2019-05-19','Classic','lyric13 ukjkfmtixs',0,0),(14,'idbuwj',14,'music14','2019-05-19','Hiphop','lyric14 elayqhycsk',0,0),(15,'idxadb',15,'music15','2019-05-19','Balad','lyric15 zzctuzimvm',0,0),(16,'idhuee',16,'music16','2019-05-19','Hiphop','lyric16 wdvfxdowpx',0,0),(17,'idtyjr',17,'music17','2019-05-19','Classic','lyric17 uwhbebsoam',0,0),(18,'idixor',18,'music18','2019-05-19','Hiphop','lyric18 pqtncjcxvl',0,0),(19,'idkzvw',19,'music19','2019-05-19','Classic','lyric19 uwdjwildgv',0,0),(20,'idqwqf',20,'music20','2019-05-19','Hiphop','lyric20 rzgmmhlbis',0,0);
/*!40000 ALTER TABLE `Music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `My_Voucher`
--

DROP TABLE IF EXISTS `My_Voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `My_Voucher` (
  `id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `download_num` int(11) NOT NULL,
  `streaming_num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `My_Voucher`
--

LOCK TABLES `My_Voucher` WRITE;
/*!40000 ALTER TABLE `My_Voucher` DISABLE KEYS */;
INSERT INTO `My_Voucher` VALUES ('ysh',297,84);
/*!40000 ALTER TABLE `My_Voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Played_Music_History`
--

DROP TABLE IF EXISTS `Played_Music_History`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Played_Music_History` (
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `playing_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Played_Music_History`
--

LOCK TABLES `Played_Music_History` WRITE;
/*!40000 ALTER TABLE `Played_Music_History` DISABLE KEYS */;
/*!40000 ALTER TABLE `Played_Music_History` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Played_Video_History`
--

DROP TABLE IF EXISTS `Played_Video_History`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Played_Video_History` (
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `video_id` int(11) NOT NULL,
  `playing_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Played_Video_History`
--

LOCK TABLES `Played_Video_History` WRITE;
/*!40000 ALTER TABLE `Played_Video_History` DISABLE KEYS */;
/*!40000 ALTER TABLE `Played_Video_History` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Star_Post`
--

DROP TABLE IF EXISTS `Star_Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Star_Post` (
  `user_id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `artist_name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `star_post_id` int(11) NOT NULL,
  `title` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `description` char(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `photo` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `like_num` int(11) DEFAULT '0',
  `view_num` int(11) DEFAULT '0',
  `video` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`star_post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Star_Post`
--

LOCK TABLES `Star_Post` WRITE;
/*!40000 ALTER TABLE `Star_Post` DISABLE KEYS */;
INSERT INTO `Star_Post` VALUES ('idvywr','namewouz',1,'title: wend','desc : nfaxy','null','2019-05-19',0,0,'video : tdjk'),('idxxjo','namekeke',2,'title: earo','desc : lamco','photo : unie','2019-05-19',0,0,'null'),('idaqpr','namecdez',3,'title: smlt','desc : csezn','null','2019-05-19',0,0,'video : xnmp'),('idpedh','namesmka',4,'title: mirl','desc : xfedp','photo : ixjc','2019-05-19',0,0,'null'),('idjrhj','nametuqk',5,'title: azmj','desc : gwjxr','null','2019-05-19',0,0,'video : rseq'),('idkyua','namedbrl',6,'title: iifk','desc : tozpf','photo : efwm','2019-05-19',0,0,'null'),('idpdoy','namethyh',7,'title: zwfa','desc : eisxd','null','2019-05-19',0,0,'video : gnak'),('idowsc','namemogc',8,'title: jvwm','desc : dvkkz','photo : tbst','2019-05-19',0,0,'null'),('idhjun','nameaaqj',9,'title: pkyf','desc : sabcm','null','2019-05-19',0,0,'video : ldpx'),('idbiyr','namecsds',10,'title: nisr','desc : ckipx','photo : dinc','2019-05-19',0,0,'null'),('idvgjn','nameikol',11,'title: rnzi','desc : vwkhz','null','2019-05-19',0,0,'video : ezqw'),('iddysf','namebhlj',12,'title: peix','desc : oguvp','photo : ksdm','2019-05-19',0,0,'null'),('idinqy','namecskl',13,'title: jkiz','desc : tdkpp','null','2019-05-19',0,0,'video : rctq'),('idbuwj','namemttb',14,'title: dkxq','desc : ibutz','photo : acps','2019-05-19',0,0,'null'),('idxadb','nameuiav',15,'title: xfco','desc : xgzfr','null','2019-05-19',0,0,'video : etxn'),('idhuee','nameobql',16,'title: apep','desc : zkfbp','photo : ygyg','2019-05-19',0,0,'null'),('idtyjr','nameyfgp',17,'title: xcfb','desc : eqsbk','null','2019-05-19',0,0,'video : deig'),('idixor','namecvzk',18,'title: hgfm','desc : aofti','photo : wndh','2019-05-19',0,0,'null'),('idkzvw','namecqcf',19,'title: cxcn','desc : bjnch','null','2019-05-19',0,0,'video : laau'),('idqwqf','namescza',20,'title: ixxs','desc : dvsos','photo : noei','2019-05-19',0,0,'null');
/*!40000 ALTER TABLE `Star_Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User` (
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `password_change_date` date NOT NULL,
  `nickname` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `address` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `phone_num` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `voucher_name` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `is_artist` tinyint(1) DEFAULT NULL,
  `is_block` tinyint(1) DEFAULT '0',
  `alarm_to_mail` tinyint(1) DEFAULT '1',
  `alarm_to_sms` tinyint(1) DEFAULT '1',
  `liked_artist` char(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `profile_photo` char(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_chk_1` CHECK ((`gender` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('namelwat','idapgu','aksvpi','2019-05-19','nftkihjg','2019-05-19','F','ogzwjhenkr','namelwat@gmail.com','010-1625-6243','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idapgu'),('namecdez','idaqpr','adtxnn','2019-05-19','nafldthh','2019-05-19','F','mqckqcxikh','namecdez@gmail.com','010-4462-3677','300 Streaming',1,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idaqpr'),('namemmsx','idawlb','ltfmru','2019-05-19','ngcafhjb','2019-05-19','M','nmqyvpbfqp','namemmsx@gmail.com','010-6840-2567','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idawlb'),('namelcbs','idbauo','jxfjnt','2019-05-19','nsnkttik','2019-05-19','F','umokqjmnhf','namelcbs@gmail.com','010-8469-6839','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idbauo'),('nameznap','idbgjh','yscvzy','2019-05-19','nnbaeroc','2019-05-19','F','tvsxjkyiny','nameznap@gmail.com','010-3292-7579','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idbgjh'),('namecsds','idbiyr','cipyzj','2019-05-19','nzqilpwz','2019-05-19','M','xiphqbzubx','namecsds@gmail.com','010-2595-5763','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idbiyr'),('namemttb','idbuwj','ujuytd','2019-05-19','nlqrncnq','2019-05-19','M','abwyyealeo','namemttb@gmail.com','010-2029-8007','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idbuwj'),('nameaxiw','idcdgl','koahov','2019-05-19','nyjsnajc','2019-05-19','M','huuzfhpypm','nameaxiw@gmail.com','010-7975-7892','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idcdgl'),('namefimu','idcdgu','pxaddg','2019-05-19','nlzefsjb','2019-05-19','F','njjdumkojk','namefimu@gmail.com','010-9168-9129','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idcdgu'),('namedkam','idcjlc','nhkrso','2019-05-19','ndjdpatb','2019-05-19','F','hhqtwbbmbn','namedkam@gmail.com','010-1538-9649','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idcjlc'),('namedysv','idclxb','yknyyu','2019-05-19','nndezduj','2019-05-19','M','mkmtpetvdp','namedysv@gmail.com','010-3883-8963','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idclxb'),('nameazou','idcnwb','icneha','2019-05-19','nanitphr','2019-05-19','M','pmrzgzjxqy','nameazou@gmail.com','010-6344-7892','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idcnwb'),('namefjfn','idctqk','yqqujs','2019-05-19','nxlwcuel','2019-05-19','F','oddarsszxr','namefjfn@gmail.com','010-1077-5608','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idctqk'),('namemjiy','iddnay','abzuvk','2019-05-19','nrafeagx','2019-05-19','M','pugodqryhq','namemjiy@gmail.com','010-6890-6806','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/iddnay'),('namejdus','iddwai','vghzwa','2019-05-19','ndbiclhm','2019-05-19','F','lifgudmfmn','namejdus@gmail.com','010-1377-7901','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/iddwai'),('namebhlj','iddysf','yecbrn','2019-05-19','natwhssg','2019-05-19','M','tojcuusmpx','namebhlj@gmail.com','010-1570-2324','Unlimited Streaming',1,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/iddysf'),('nametemc','idecpt','ousbos','2019-05-19','nhfkwtjq','2019-05-19','M','wcawsuxajt','nametemc@gmail.com','010-9262-7988','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idecpt'),('namegkju','idemyr','uoyquz','2019-05-19','napuxbvs','2019-05-19','M','ejgrveueqn','namegkju@gmail.com','010-7236-5427','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idemyr'),('nameyukk','ideyna','imuhmw','2019-05-19','nislmmib','2019-05-19','M','ekpurcvgvi','nameyukk@gmail.com','010-7999-8332','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/ideyna'),('namepldg','idezxa','ujjojx','2019-05-19','nvvxxtbp','2019-05-19','M','kuziifwnkc','namepldg@gmail.com','010-4791-4657','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idezxa'),('namejkeb','idfaww','fcivhz','2019-05-19','nqwhlkyr','2019-05-19','F','zfygwlfegw','namejkeb@gmail.com','010-9249-7653','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idfaww'),('namerjqg','idfcii','qteecc','2019-05-19','nyfgzqfh','2019-05-19','F','dhhjreixbc','namerjqg@gmail.com','010-8493-6466','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idfcii'),('nametpth','idfrag','iajswy','2019-05-19','nhlzgced','2019-05-19','M','diycrcpilc','nametpth@gmail.com','010-6193-1113','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idfrag'),('namexbhg','idgfkg','uijvvg','2019-05-19','noxmzgiw','2019-05-19','F','nelkuhxvgj','namexbhg@gmail.com','010-5402-6338','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idgfkg'),('namembcb','idgoil','eyhipy','2019-05-19','nfjdfatx','2019-05-19','F','olhvataucs','namembcb@gmail.com','010-6328-2202','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idgoil'),('namedpcv','idgvlh','akpwkw','2019-05-19','nhttokni','2019-05-19','M','lycultjhrq','namedpcv@gmail.com','010-9835-2227','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idgvlh'),('namehncp','idgysf','dupnpt','2019-05-19','nubcpjid','2019-05-19','M','jloheylkzd','namehncp@gmail.com','010-6603-7482','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idgysf'),('nameaaqj','idhjun','cjrvrr','2019-05-19','nwtnqlbn','2019-05-19','F','belckcjjfj','nameaaqj@gmail.com','010-4846-2178','300 Streaming',1,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idhjun'),('namehibv','idhsvy','fetooi','2019-05-19','nuvrfupm','2019-05-19','M','evbiotscrl','namehibv@gmail.com','010-5053-6483','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idhsvy'),('nameobql','idhuee','hueorn','2019-05-19','ncfpioph','2019-05-19','M','uqabwcuwry','nameobql@gmail.com','010-1230-9500','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idhuee'),('namedfyl','idikfk','zxtkmu','2019-05-19','nmjcactx','2019-05-19','F','ijbyocuqbz','namedfyl@gmail.com','010-5622-1662','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idikfk'),('namecskl','idinqy','rlwozt','2019-05-19','nvfvaapq','2019-05-19','F','otgvqgnkce','namecskl@gmail.com','010-8046-1983','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idinqy'),('namelgsm','idipsx','lbffyd','2019-05-19','njiczyxk','2019-05-19','F','hbkuegizru','namelgsm@gmail.com','010-3327-2896','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idipsx'),('namesgol','idirgs','laqnjf','2019-05-19','nnhkipvx','2019-05-19','M','mjihepfgyk','namesgol@gmail.com','010-5100-6643','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idirgs'),('namergsb','idiszg','kfvkhy','2019-05-19','nwceqyjd','2019-05-19','M','vyucpdivat','namergsb@gmail.com','010-1820-8073','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idiszg'),('namecvzk','idixor','edbseb','2019-05-19','ntlsnnif','2019-05-19','M','fstppqbpet','namecvzk@gmail.com','010-3314-3465','Unlimited Streaming',1,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idixor'),('namenfrk','idiypb','rktodn','2019-05-19','nhktbwgu','2019-05-19','M','hrpsysmhua','namenfrk@gmail.com','010-9143-5734','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idiypb'),('nametuqk','idjrhj','qyfpcz','2019-05-19','nmqcckps','2019-05-19','F','ovvpiwzrhe','nametuqk@gmail.com','010-9722-9453','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idjrhj'),('namefywb','idjria','tamcbv','2019-05-19','nolywrmr','2019-05-19','F','ristefokhk','namefywb@gmail.com','010-9791-3353','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idjria'),('namervtv','idjxox','womiyz','2019-05-19','nozasmqk','2019-05-19','F','epqvrayxdm','namervtv@gmail.com','010-7869-6511','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idjxox'),('namecajg','idkcqg','iwpjzs','2019-05-19','noeyihpz','2019-05-19','F','xaeawlaccg','namecajg@gmail.com','010-8182-9940','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idkcqg'),('namedkhn','idktsq','ihgdcv','2019-05-19','noeaxsop','2019-05-19','F','xwrlggfrfn','namedkhn@gmail.com','010-7791-9380','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idktsq'),('namedbrl','idkyua','pvmqjd','2019-05-19','nrgufmtw','2019-05-19','M','syansfygyn','namedbrl@gmail.com','010-8071-6680','Unlimited Streaming',1,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idkyua'),('namecqcf','idkzvw','gqrwmz','2019-05-19','nyhjidso','2019-05-19','F','ptiedwbzys','namecqcf@gmail.com','010-7373-7510','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idkzvw'),('namevojk','idlase','jarmce','2019-05-19','nqkgjrze','2019-05-19','M','ivtwnywtfv','namevojk@gmail.com','010-1927-3259','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlase'),('nameeiwh','idlcpe','pvsgzt','2019-05-19','ndplisdl','2019-05-19','F','tzezcpvpbd','nameeiwh@gmail.com','010-8519-4041','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlcpe'),('namepvcl','idlimm','orycwr','2019-05-19','nuroqtfh','2019-05-19','M','glizpvvozs','namepvcl@gmail.com','010-7515-4875','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlimm'),('nameswaq','idlnlf','olbwwf','2019-05-19','ndmqvbvi','2019-05-19','M','lnhsupupyc','nameswaq@gmail.com','010-4657-8441','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlnlf'),('namehupo','idlrve','rwfbww','2019-05-19','nhbtvhfl','2019-05-19','F','qqutsfgdip','namehupo@gmail.com','010-5956-2218','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlrve'),('nameyixl','idlvsn','kvlyyv','2019-05-19','numzqemu','2019-05-19','F','vokxcfzgsq','nameyixl@gmail.com','010-4639-2302','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlvsn'),('namezgxp','idlvsz','bmnkxt','2019-05-19','nrcrqyie','2019-05-19','M','aejtgxyndd','namezgxp@gmail.com','010-8317-7220','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idlvsz'),('namewnub','idmxli','fmrqxr','2019-05-19','nkqlqwpt','2019-05-19','F','tvufzzooxw','namewnub@gmail.com','010-3207-2010','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idmxli'),('namewvbu','idnlqb','dkcshz','2019-05-19','nikmvwdl','2019-05-19','M','jzkygjpvhx','namewvbu@gmail.com','010-6226-3019','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idnlqb'),('namekpfs','idokpm','zdharh','2019-05-19','nvbpsxnv','2019-05-19','M','qajuiyfseq','namekpfs@gmail.com','010-4485-7565','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idokpm'),('namemogc','idowsc','kajism','2019-05-19','nvughmya','2019-05-19','M','fgyptltmyz','namemogc@gmail.com','010-9226-8668','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idowsc'),('namethyh','idpdoy','mqodia','2019-05-19','nxbuzqym','2019-05-19','F','tomhccivlx','namethyh@gmail.com','010-2233-1887','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpdoy'),('namesmka','idpedh','fjigwz','2019-05-19','nquqdhgj','2019-05-19','M','jammkfhhat','namesmka@gmail.com','010-4419-2951','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpedh'),('namesjld','idphyr','xofudd','2019-05-19','nmuqkyaj','2019-05-19','F','bkebpxxgkb','namesjld@gmail.com','010-1688-8600','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idphyr'),('nameentv','idpide','epklmp','2019-05-19','ncnzwigd','2019-05-19','F','pjmcoomrjr','nameentv@gmail.com','010-2378-1810','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpide'),('namevleq','idpjey','xcsisw','2019-05-19','nwckurbv','2019-05-19','F','oxlpvfjkkd','namevleq@gmail.com','010-3745-5593','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpjey'),('namezqdk','idpmmx','ggaqqp','2019-05-19','ntymshss','2019-05-19','F','rkqmdjnods','namezqdk@gmail.com','010-7854-4307','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpmmx'),('nameydhi','idpomn','kecbab','2019-05-19','nwbbscub','2019-05-19','F','nnzftsdcjd','nameydhi@gmail.com','010-1550-9927','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpomn'),('namehibh','idpukh','nwmbyx','2019-05-19','nwqaiopr','2019-05-19','F','bjbalcdycj','namehibh@gmail.com','010-9993-8708','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpukh'),('nameiqkl','idpvkt','vyqkti','2019-05-19','nntapkqu','2019-05-19','M','zrrisltrey','nameiqkl@gmail.com','010-9186-9276','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idpvkt'),('nameskqq','idqgfp','ijogou','2019-05-19','ninkaxxl','2019-05-19','M','budxqjjowf','nameskqq@gmail.com','010-8465-2943','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqgfp'),('namebfrj','idqojj','zhemfm','2019-05-19','nbvepkmi','2019-05-19','F','xyaxmnrlpk','namebfrj@gmail.com','010-9008-1664','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqojj'),('nameprmw','idqqrn','kmwyhp','2019-05-19','ntdlksim','2019-05-19','F','mwlcjyjhcd','nameprmw@gmail.com','010-8495-8019','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqqrn'),('nameflsr','idqraf','xbsedz','2019-05-19','nsicupft','2019-05-19','F','rowrukdnbw','nameflsr@gmail.com','010-6665-1161','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqraf'),('namepvde','idqwjp','dsdzds','2019-05-19','nnzevotp','2019-05-19','M','qvaezjwoqh','namepvde@gmail.com','010-9192-6851','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqwjp'),('namescza','idqwqf','uoughc','2019-05-19','ngyxawwr','2019-05-19','M','kbgvwmodfk','namescza@gmail.com','010-7034-2066','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idqwqf'),('nameggie','idrkas','rjtwyu','2019-05-19','ntzouanj','2019-05-19','F','qhtfaannat','nameggie@gmail.com','010-6538-2432','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idrkas'),('nameqnpf','idrluw','vrgjud','2019-05-19','nepmlowx','2019-05-19','F','wsqtfukres','nameqnpf@gmail.com','010-9084-7126','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idrluw'),('nameqdyg','idrojb','znulxd','2019-05-19','nlihvdib','2019-05-19','F','puafcbjwqz','nameqdyg@gmail.com','010-2941-6890','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idrojb'),('namebcms','idrvvs','npfnwg','2019-05-19','naefhhgj','2019-05-19','M','mxgqkgzapb','namebcms@gmail.com','010-4366-2236','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idrvvs'),('namechjw','idskdg','tvpxto','2019-05-19','njrhzson','2019-05-19','F','etnefhetmg','namechjw@gmail.com','010-2828-9084','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idskdg'),('namejptf','idskwi','splwbs','2019-05-19','njvhpncw','2019-05-19','M','kmhyucvotj','namejptf@gmail.com','010-2931-7794','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idskwi'),('namebszi','idtoyk','wfaend','2019-05-19','ngazddvb','2019-05-19','F','pzoxzdvpgx','namebszi@gmail.com','010-3213-9912','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idtoyk'),('nameyfgp','idtyjr','ektroy','2019-05-19','ntndyxno','2019-05-19','F','uboiwyuyui','nameyfgp@gmail.com','010-8740-8230','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idtyjr'),('nametbza','idudre','gxpsod','2019-05-19','nrxijtxi','2019-05-19','F','rgkanwwlye','nametbza@gmail.com','010-9715-3498','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idudre'),('namemtfj','iduruu','ujiese','2019-05-19','nqafccej','2019-05-19','M','mhxpvgueih','namemtfj@gmail.com','010-3012-5695','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/iduruu'),('nameikol','idvgjn','npgfqs','2019-05-19','nfhghyur','2019-05-19','F','wdbojbppfn','nameikol@gmail.com','010-3152-2012','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idvgjn'),('namehtch','idvjqq','bahwwm','2019-05-19','nchaasok','2019-05-19','M','bexusrstjq','namehtch@gmail.com','010-7216-4958','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idvjqq'),('nameqdcj','idvpav','meyzvt','2019-05-19','natifvmz','2019-05-19','M','jhddkvjxus','nameqdcj@gmail.com','010-7529-2852','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idvpav'),('namefnsa','idvrdt','uahuqv','2019-05-19','nqiqkbih','2019-05-19','M','lxvnbjrzan','namefnsa@gmail.com','010-2705-4845','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idvrdt'),('namewouz','idvywr','zqchsn','2019-05-19','ncdjlniq','2019-05-19','F','hndntjavmi','namewouz@gmail.com','010-8626-9330','100 Streaming',1,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idvywr'),('namejmfr','idwesb','kmcktf','2019-05-19','npkefonx','2019-05-19','F','pmoliwihkl','namejmfr@gmail.com','010-1094-6294','100 Streaming',0,0,1,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idwesb'),('namevksi','idwizi','bpmazn','2019-05-19','nvtxkrme','2019-05-19','F','eebnfwgwvm','namevksi@gmail.com','010-1757-3138','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idwizi'),('nametwom','idwqpj','ylbzti','2019-05-19','nokjuycg','2019-05-19','M','wbmdeuxzmm','nametwom@gmail.com','010-2851-6228','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idwqpj'),('namepvkg','idwxcm','zkxvmr','2019-05-19','nqvrmjgn','2019-05-19','M','memwaydhqo','namepvkg@gmail.com','010-4096-9533','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idwxcm'),('nameuiav','idxadb','bpbxxs','2019-05-19','nqfokqhu','2019-05-19','F','vkwjxedolj','nameuiav@gmail.com','010-5439-2010','300 Streaming',1,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxadb'),('nameuvgc','idxcru','ukqadq','2019-05-19','nwukmblt','2019-05-19','F','qjcyrodlxx','nameuvgc@gmail.com','010-6262-4253','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxcru'),('nameolsj','idxkrt','qngqev','2019-05-19','njpbvuhz','2019-05-19','M','zqyqbpgrka','nameolsj@gmail.com','010-3515-2755','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxkrt'),('namepfzm','idxswg','snhilr','2019-05-19','nsklhcem','2019-05-19','M','mfmavzjguk','namepfzm@gmail.com','010-9080-5438','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxswg'),('namedust','idxwdf','vycufx','2019-05-19','notbcerq','2019-05-19','M','mvukfuwmdy','namedust@gmail.com','010-7718-3591','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxwdf'),('namekeke','idxxjo','diwkfi','2019-05-19','nadtxzro','2019-05-19','M','ohxvvilniu','namekeke@gmail.com','010-1643-8432','Unlimited Streaming',1,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idxxjo'),('nameuqqc','idyrnj','bymvan','2019-05-19','nsqbzptj','2019-05-19','F','ewnfjjadsp','nameuqqc@gmail.com','010-5181-9501','300 Streaming',0,0,1,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idyrnj'),('namesfxz','idyukb','lpcrvr','2019-05-19','ntntkqho','2019-05-19','M','ihpuwvhakg','namesfxz@gmail.com','010-7966-1210','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idyukb'),('namewhku','idzpig','bgohhd','2019-05-19','nxygcrrz','2019-05-19','M','dgfbpadrte','namewhku@gmail.com','010-5665-4247','Unlimited Streaming',0,0,0,0,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idzpig'),('nameunku','idzpxf','xyjuba','2019-05-19','nsibpkfh','2019-05-19','M','rurozyrbkl','nameunku@gmail.com','010-9414-8388','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idzpxf'),('namejqfu','idzzvx','wgnadd','2019-05-19','nqjtvqlj','2019-05-19','M','xoochejcmc','namejqfu@gmail.com','010-5860-1381','Unlimited Streaming',0,0,0,1,'null','/Users/sihyungyou/eclipse-workspace/DBengers/img/idzzvx'),('ysh','ysh','1','2019-05-19','ysh','1996-10-23','M','HGU','walter1023@daum.net','010-9230-2326',NULL,0,0,1,1,NULL,'/Users/joonhyukpark/eclipse-workspace/DBengers/img/myphoto.jpg');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_PlayList`
--

DROP TABLE IF EXISTS `User_PlayList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User_PlayList` (
  `id` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `num_like` int(11) DEFAULT '0',
  `hashtag` char(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `play_num` int(11) DEFAULT '0',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_PlayList`
--

LOCK TABLES `User_PlayList` WRITE;
/*!40000 ALTER TABLE `User_PlayList` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_PlayList` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_PlayList_Music`
--

DROP TABLE IF EXISTS `User_PlayList_Music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User_PlayList_Music` (
  `user_id` char(30) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `music_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_PlayList_Music`
--

LOCK TABLES `User_PlayList_Music` WRITE;
/*!40000 ALTER TABLE `User_PlayList_Music` DISABLE KEYS */;
/*!40000 ALTER TABLE `User_PlayList_Music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Voucher`
--

DROP TABLE IF EXISTS `Voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Voucher` (
  `voucher_name` char(30) COLLATE utf8mb4_general_ci NOT NULL,
  `voucher_price` int(11) NOT NULL,
  `download_num` int(11) NOT NULL,
  `streaming_num` int(11) NOT NULL,
  PRIMARY KEY (`voucher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voucher`
--

LOCK TABLES `Voucher` WRITE;
/*!40000 ALTER TABLE `Voucher` DISABLE KEYS */;
INSERT INTO `Voucher` VALUES ('100 Streaming',5000,100,100),('300 Streaming',8000,300,300),('Unlimited Streaming',10000,10000,10000);
/*!40000 ALTER TABLE `Voucher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-19 21:13:56
