--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `books`;
DROP TABLE IF EXISTS `authors`;

CREATE TABLE `authors` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
);

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` VALUES 
	(1,'John Doe'),(2,'Harry Graham Thornton'),
	(3,'Max Giovanna'),(4,'Christy Lawson'),
	(5,'Milli Manning'),(6,'Isla-Rose Page'),
	(7,'Arisha Parks'),(8,'Cora Cano'),
	(9,'Reegan Hull'),(10,'Lesley Lozano'),
	(11,'Siyana Cantu'),(12,'Adnaan Delgado'),
	(13,'Ceri Martin'),(14,'Elleanor Plant'),
	(15,'Libbi Broughton'),(16,'Brooke Salas');

--
-- Table structure for table `books`or 
--

CREATE TABLE `books` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(500) NOT NULL,
  `AUTHOR` int(11) NOT NULL,
  `PRICE` int(11) NOT NULL,
  `YEAR` varchar(4) DEFAULT NULL,
  `RATING` float DEFAULT NULL,
  `URL` varchar(500) NOT NULL,
  `DESCRIPTION` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`AUTHOR`) REFERENCES `authors` (`ID`)
);

--
-- Dumping data for table `books`
--

INSERT INTO `books` VALUES 
	(2,'TIME MANAGEMENT',1,100,'2015',3.2,'http://author.com','Pellentesque a tellus bibendum, ullamcorper turpis vitae, luctus mauris. Vivamus interdum accumsan velit eget finibus. Nulla lacinia elit sed posuere iaculis. Nam pretium neque in facilisis auctor. Ut fringilla felis erat, nec malesuada libero convallis ac. Pellentesque a odio sit amet eros dignissim suscipit in ut neque. Quisque euismod, odio aliquam fringilla eleifend, lacus tortor tempor erat, sit amet consequat odio sapien et nisl. Nunc sed molestie tellus. Praesent facilisis elementum nunc, sed sollicitudin nisi.'),
	(3,'The Big, White Bear',2,312,'2018',4.1,'http://author.com','Nunc quis tortor dictum, tristique nisi eu, interdum est. Nam imperdiet tempor eros, in sagittis mauris vehicula id. Morbi ut congue justo, sed ultricies sem. Duis nec lectus id enim imperdiet accumsan nec sit amet orci. Suspendisse ut scelerisque magna. Aenean id felis non augue condimentum mattis nec eget diam. Phasellus interdum at libero sed varius. Nam at semper lectus. Etiam fringilla sollicitudin consequat. Ut tempus, nisi vitae aliquet venenatis, lectus urna aliquet est, vel maximus mauris sem id magna. Mauris sagittis justo dolor, in faucibus elit rutrum ac.'),
	(4,'The Amazing Adventures of Anonymous',3,430,'1993',4,'http://author.com','Praesent sollicitudin et felis at sagittis. Fusce nulla sapien, consequat eget quam ac, convallis hendrerit magna. Aliquam malesuada cursus ante nec tincidunt. Nullam elit lacus, congue in condimentum nec, volutpat vitae erat. Etiam ut lorem vitae ex rhoncus ultricies nec id sem. Vivamus laoreet ligula non malesuada auctor. Duis neque lorem, dapibus ut imperdiet eu, viverra ut nisi. Donec gravida massa vitae nisl tempor, vitae viverra arcu tempor. Nulla iaculis elementum risus quis porttitor. Mauris ac dui nec sapien elementum tempus sed sit amet orci. Donec eget quam ligula. Praesent varius fringilla enim, id vestibulum eros efficitur id. Curabitur dapibus at tortor consectetur bibendum.'),
	(5,'Fact versus Fiction',4,120,'2003',2.8,'http://author.com','Sed dui odio, auctor eu feugiat quis, feugiat a sapien. Mauris porttitor gravida dui. Proin commodo nibh at dapibus interdum. Nam non ante leo. Curabitur lorem dui, gravida et interdum eu, vehicula sit amet magna. Praesent vel turpis bibendum turpis tempus vestibulum. Praesent dapibus tortor non scelerisque tincidunt.'),
	(6,'An exploration of Memes',7,120,'2003',2.8,'http://author.com','Vivamus vitae egestas ante. Morbi vel metus quis velit consequat molestie vel nec lorem. Nullam sit amet molestie ex. Mauris rhoncus libero accumsan lorem laoreet, et condimentum leo maximus. Quisque finibus arcu congue laoreet aliquam. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam sed mi non diam ullamcorper vestibulum id id libero. Pellentesque auctor eget mi vel egestas. Donec at urna eros. Proin iaculis condimentum libero, nec mattis est. Quisque vestibulum sed nibh at posuere.'),
	(7,'Like Pluto on Earth',6,120,'2003',2.8,'http://author.com','Vivamus gravida viverra convallis. Mauris non velit ipsum. Sed mauris lorem, pellentesque a interdum et, mollis ut sem. Maecenas purus risus, pellentesque vel vestibulum ac, aliquet vel diam. Mauris efficitur nec turpis vel euismod. Vivamus in nisl eu nisl blandit eleifend. Nam eu nibh dignissim, fermentum orci in, tincidunt urna.'),
	(8,'Down With the Forks',12,120,'2003',2.8,'http://author.com','Sed vulputate nec erat fermentum pulvinar. Sed nec feugiat nunc. Suspendisse ornare magna quis risus varius egestas. Proin et odio eget nunc scelerisque placerat et quis odio. Vivamus leo mauris, consectetur in faucibus sit amet, ultrices in dui. Maecenas fermentum, tortor nec porttitor pharetra, turpis metus dictum ipsum, et efficitur purus enim sit amet ipsum. Donec tempor eros ac leo aliquam, sed pulvinar libero tristique. Nunc aliquam vitae neque ullamcorper ornare. Quisque semper ante quis tellus convallis, vitae dignissim diam euismod. Etiam orci velit, posuere quis risus quis, molestie bibendum nisi. Vivamus dictum nec odio non fermentum. Maecenas vestibulum, urna eget venenatis sagittis, sapien lectus condimentum orci, a sodales arcu lacus quis dolor.'),
	(9,'Captain Zombie and the Forks',10,120,'2003',2.8,'http://author.com','Curabitur vitae blandit eros. Fusce egestas mollis iaculis. Fusce eu purus aliquam, commodo nunc ac, tempor tortor. Mauris vitae convallis quam. Nulla quis tristique tortor, in dignissim ex. Sed ut ornare enim, in blandit lacus. Donec egestas tellus et urna placerat mollis ut at libero. Vestibulum malesuada gravida gravida. Quisque metus sem, imperdiet id urna in, semper pulvinar nunc. Sed pellentesque mauris id elit maximus, eu volutpat enim tempus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin eu tortor vitae tellus fermentum vehicula. Proin fringilla tempus eros, eget auctor risus ultricies at. Etiam cursus sollicitudin risus, sed rutrum urna. Sed tincidunt rhoncus mi, sit amet interdum ante. Aliquam elementum nisl vitae libero rhoncus ullamcorper.'),
	(10,'The German Culture',3,120,'2003',2.8,'http://author.com','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sit amet ex ipsum. Nulla nunc metus, cursus a tincidunt a, interdum sed felis. Praesent condimentum neque purus, ac ultricies turpis dapibus nec. Vestibulum imperdiet ultrices urna at imperdiet. Donec dolor leo, scelerisque in erat ac, vestibulum convallis massa. Ut molestie nisi ultricies suscipit commodo. Cras ornare malesuada libero at accumsan. Curabitur massa diam, efficitur eget erat sit amet, vestibulum dictum elit. Cras molestie vitae nulla sit amet consectetur. In sit amet eros id elit convallis dignissim eu eu eros. Fusce venenatis posuere dignissim.'),
	(11,'The Mystery Behind History',8,120,'2003',2.8,'http://author.com','Vivamus placerat neque non sem iaculis pulvinar. Cras faucibus, nulla et rutrum eleifend, massa ipsum tincidunt sem, ac sagittis diam metus vitae ex. In porttitor ex molestie turpis euismod, sed lacinia tellus tempor. Duis in volutpat eros. Aenean a nulla ut erat gravida ultrices. Cras nec bibendum est. Aliquam convallis est et mattis ullamcorper. Fusce egestas tincidunt porta. Suspendisse mattis orci non leo dignissim, faucibus fermentum est consectetur. Vivamus quis nulla nec felis feugiat dictum sit amet non dolor. In aliquet enim id mattis dapibus. Suspendisse lacus est, efficitur nec libero at, vestibulum egestas mi.'),
	(12,'Who Am I And Why Should You Follow Me',14,120,'2003',2.8,'http://author.com','Donec vitae sem eu est porttitor suscipit. Cras imperdiet, ligula quis ultrices vestibulum, mi enim eleifend sapien, eget volutpat neque ante et sem. Maecenas dignissim ligula ut tincidunt dignissim. Nulla facilisi. Proin placerat metus libero. Sed auctor in leo rutrum ultricies. Etiam felis leo, vehicula non orci in, ultricies lacinia ex. Interdum et malesuada fames ac ante ipsum primis in faucibus. Praesent id elementum nunc. Aenean eu nunc et ex vulputate scelerisque sit amet et lorem. Ut pulvinar elementum ante. Aenean semper nec turpis nec bibendum. Morbi vestibulum pharetra euismod.'),
	(13,'The Intelligent Ghost',11,120,'2003',2.8,'http://author.com','Nulla mattis orci vel lacus venenatis feugiat. Donec condimentum ligula vel vulputate vestibulum. Vivamus massa nisl, tincidunt at varius non, laoreet eget sem. Aenean in felis non urna finibus pulvinar. Etiam sit amet urna mollis, aliquam ante eget, mattis arcu. Proin sed odio lectus. Nunc purus nunc, volutpat a cursus nec, bibendum quis metus. Etiam suscipit turpis libero, in vehicula ex consectetur ullamcorper. Proin tempus, massa a lacinia convallis, sapien lacus egestas justo, at dapibus nulla est eu diam. Aliquam vestibulum eros tortor, nec accumsan lacus tincidunt ut');
