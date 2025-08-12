CREATE TABLE IF NOT EXISTS `contact_msg`(
    `contact_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `mobile_num` varchar(10) NOT NULL,
    `email` varchar(100) NOT NULL,
    `message` varchar(500) NOT NULL,
    `status` varchar(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP NOT NULL,
    `updated_by` varchar(50) DEFAULT NOT NULL
);
