INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Mar 13 ','Holi','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Aug 09 ','Raksha Bandhan','NATIONAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Oct 20 ','Diwali','FESTIVAL',CURDATE(),'DBA');


INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Jan 26 ','Republic Day','NATIONAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Aug 15 ','Independence Day','NATIONAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
VALUES (' Oct 02 ','Gandhi Jayanti','NATIONAL',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('STUDENT',CURDATE(),'DBA');

DELETE FROM person WHERE email='admin@eazyschool.com';

INSERT INTO `person` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`,`created_by`)
VALUES ('Admin', 'admin@eazyschool.com','1008200400','$2a$12$y5rvYdP4ASbElTJDZ9Yap.nEDhFwlEeEbYUcdgm/mFCqOiAtTID9K',1,CURDATE(),'DBA');

