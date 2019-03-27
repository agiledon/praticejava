CREATE DATABASE IF NOT EXISTS insight;

USE insight;

CREATE TABLE IF NOT EXISTS blogs
(
  id varchar(36) not null primary key,
  title varchar(50) not null,
  author varchar(50) not null,
  post text not null,
  createdDate datetime,
  updatedDate datetime
);

DELETE FROM `blogs`;

INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7601', '老人与海', '海明威', '', '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7602', '红楼梦', '曹雪芹', '', '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7603', '水浒传', '施耐庵', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7604', '百年孤独', '马尔克斯', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7605', '三国演义', '罗贯中', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7606', '追忆逝水年华', '普罗斯特', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7607', '哥伦比亚的倒影', '木心', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7608', '设计模式', 'Eric Gamma', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7609', '软件设计精要与模式', '张逸', '' , '2015-08-05 11:10:08');
INSERT INTO `blogs`(id, title, author, post, createdDate) VALUES ('d6da80bf-4100-45c5-86c7-6ca57e0f7610', '三生三世桃花香', '潇香婉晴', '' , '2015-08-05 11:10:08');
