------------------------------------
-- 用户表
------------------------------------
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(200) DEFAULT NULL COMMENT '登录密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT 'regist' COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '最后一次修改人',
  `status` char(1) DEFAULT '0' COMMENT '0-正常1-禁用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';