CREATE TABLE `cloudpad`.`userDto` (
 `user_name` VARCHAR(25) NOT NULL ,
 `first_name` VARCHAR(32) NOT NULL ,
  `last_name` VARCHAR(32) NOT NULL ,
  `role` VARCHAR(8) NOT NULL ,
  `password` VARCHAR(32) NOT NULL ,
  `male` TINYINT(1) NOT NULL ,
  `location` VARCHAR(32) NOT NULL ,
  `last_login_time` DATETIME   NOT NULL DEFAULT ON UPDATE CURRENT_TIMESTAMP ,
 `is_blocked` TINYINT(1) NOT NULL DEFAULT 0 ,
   `last_blocked_time` DATETIME   NOT NULL DEFAULT ON UPDATE CURRENT_TIMESTAMP ,
 `attempts` TINYINT(3) NOT NULL DEFAULT 0 ,

 PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


