CREATE DATABASE jsudemo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
create user 'jsudemo'@'127.0.0.1' identified by '123456';
grant all privileges on jsudemo.* to 'jsudemo'@'127.0.0.1' ;
use jsudemo;

-- 用户demo表
DROP TABLE IF EXISTS user_demo;
CREATE TABLE user_demo(
  id  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID' ,
  user_name VARCHAR(200) NOT NULL COMMENT '用户名唯一' ,

  created_dt  timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  modified_dt  timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
  CONSTRAINT pk_id PRIMARY KEY  (id),
  -- 用户名唯一
  CONSTRAINT uk_user_name UNIQUE (user_name)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='用户demo表';
