use test;

CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `image_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1883618 DEFAULT CHARSET=utf8;


CREATE TABLE `lender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `whereabouts` varchar(45) DEFAULT NULL,
  `country_code` varchar(45) DEFAULT NULL,
  `uid` varchar(45) DEFAULT NULL,
  `create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(45) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lender_image_id_index` (`image_id`),
  CONSTRAINT `lender_image_id_fk` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;


CREATE TABLE `loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description_id` int(11) DEFAULT NULL,
  `founded_amount` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `activity` varchar(45) DEFAULT NULL,
  `sector` varchar(45) DEFAULT NULL,
  `use` varchar(255) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `partner_id` int(11) DEFAULT NULL,
  `posted_date` varchar(45) DEFAULT NULL,
  `loan_amount` int(11) DEFAULT NULL,
  `bonus_credit_eligibility` tinyint(4) DEFAULT NULL,
  `term_id` int(45) DEFAULT NULL,
  `journal_id` int(11) DEFAULT NULL,
  `remaing_term` int(11) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `term_id_idx` (`term_id`),
  CONSTRAINT `term_id` FOREIGN KEY (`term_id`) REFERENCES `term` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=300001 DEFAULT CHARSET=utf8;


CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payer_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disbursal_date` datetime DEFAULT NULL,
  `disbursal_currency` varchar(45) DEFAULT NULL,
  `disbursal_amount` int(11) DEFAULT NULL,
  `repayment_interval` varchar(45) DEFAULT NULL,
  `repayment_term` int(11) DEFAULT NULL,
  `repayment_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;


CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_id` int(11) NOT NULL,
  `lender_id` int(11) NOT NULL,
  `payment` int(11) NOT NULL,
  `scheduled` datetime NOT NULL,
  `sent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lender_id_idx` (`lender_id`),
  KEY `loan_id_idx` (`loan_id`),
  CONSTRAINT `lender_id` FOREIGN KEY (`lender_id`) REFERENCES `lender` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `loan_id` FOREIGN KEY (`loan_id`) REFERENCES `loan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
