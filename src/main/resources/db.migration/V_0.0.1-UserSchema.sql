select * from users;

CREATE TABLE `user_roles` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `user_id` int NOT NULL,
                              `user_role` varchar(45) COLLATE utf8mb4_bin NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `ur_unique` (`user_role`,`user_id`) /*!80000 INVISIBLE */,
                              KEY `FK_user_id_idx` (`user_id`),
                              CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
