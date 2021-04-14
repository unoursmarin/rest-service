For this project, a local database was created for tests, using docker. We prepare the image for the client connection,
->    LocalIP:3306

docker run -p 3306:3306 --name=mysql57 -e  MYSQL_ROOT_PASSWORD=my-secret-pw  -d mysql/mysql-server:5.7

docker exec -it mysql57 mysql -uroot -p

update mysql.user set host = '%' where user='root';

docker restart mysql57


***  Now enter your ip in mysql workbench connection
CREATE SCHEMA `afdb` ;
SQL table -> 
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `country` varchar(255) NOT NULL,
  `town` varchar(255) DEFAULT NULL,
  `code_postal` varchar(5) DEFAULT NULL,
  `nombre_achat` int(11) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `subscriber` tinyint(4) NOT NULL,
 `isvalid` tinyint(4) NOT NULL,


  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

finally, you can add an user in order to test the api
INSERT INTO `afdb`.`user` (`id`, `firstname`, `lastname`, `email`, `birthday`, `country`, `town`, `code_postal`, `nombre_achat`, `description`, `subscriber`, `valid`) VALUES ('6', 'Raphaël', 'Chouchane', 'raphaelchouchane@mail.com', '1993-09-13', 'france', 'st raphaël', '83700', '0', 'Dev très sympa', '1', '1');





Api Usage: 


users in url: 

127.0.0.1/users
127.0.0.1/users/[id] to get user by id
POST: /users
Delete: /users/[id]