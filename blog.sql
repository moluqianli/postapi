
USE `blog_api`;

CREATE TABLE `comments` (
  `comment_uuid` varchar(36) NOT NULL,
  `post_uuid` varchar(36) DEFAULT NULL,
  `author` text,
  `content` text,
  `approved` tinyint(1) DEFAULT NULL,
  `submission_date` date DEFAULT NULL,
  PRIMARY KEY (`comment_uuid`),
  KEY `comments_post_uuid_fkey` (`post_uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `posts` (
  `post_uuid` varchar(36) NOT NULL,
  `title` text NOT NULL,
  `content` text,
  `publishing_date` date DEFAULT NULL,
  PRIMARY KEY (`post_uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `posts_categories` (
  `post_uuid` varchar(36) DEFAULT NULL,
  `category` text,
  KEY `posts_categories_post_uuid_fkey` (`post_uuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
