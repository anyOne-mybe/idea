/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/8/25 15:24:11                           */
/*==============================================================*/


DROP TABLE IF EXISTS IDAE_TPL_ROLE;

DROP TABLE IF EXISTS IDEA_TPL_RESOURCES;

DROP TABLE IF EXISTS IDEA_TPL_USER;

DROP TABLE IF EXISTS IDEA_USER_ROLE;

/*==============================================================*/
/* Table: IDAE_TPL_ROLE                                         */
/*==============================================================*/
CREATE TABLE IDAE_TPL_ROLE
(
   ID                   INT(10) NOT NULL,
   NAME                 VARCHAR(50),
   ROLE_DESC            VARCHAR(150),
   AVAILABLE            CHAR,
   CREATE_TIME          DATETIME,
   CREATE_BY            INT(10),
   UPDATE_TIME          DATETIME,
   UPDATE_BY            INT(10),
   APP_NAME             VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE IDAE_TPL_ROLE COMMENT '角色表';

/*==============================================================*/
/* Table: IDEA_TPL_RESOURCES                                    */
/*==============================================================*/
CREATE TABLE IDEA_TPL_RESOURCES
(
   ID                   INT(10) NOT NULL,
   RESOURCE_CODE        VARCHAR(100),
   RESOURCE_NAME        VARCHAR(100),
   TYPE                 VARCHAR(50),
   OPERATE_CODE         VARCHAR(100),
   OPERATE_NAME         VARCHAR(100),
   CREATE_DATE          DATETIME,
   CREATE_BY            INT(10),
   UPDATE_DATE          DATETIME,
   UPDATE_BY            INT(10),
   AVAILABLE            CHAR,
   APP_NAME             VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE IDEA_TPL_RESOURCES COMMENT '资源定义表';

/*==============================================================*/
/* Table: IDEA_TPL_USER                                         */
/*==============================================================*/
CREATE TABLE IDEA_TPL_USER
(
   ID                   INT(10) NOT NULL,
   NAME                 VARCHAR(100),
   ACCOUNT              VARCHAR(100),
   PASSWORD             VARCHAR(50),
   EMAIL                VARCHAR(100),
   SEX                  CHAR,
   AGE                  INT,
   WEB_CHAT             VARCHAR(50) COMMENT '微信',
   QQ                   VARCHAR(20),
   IDENTITY_CARD        VARCHAR(20),
   BIRTHDAY             DATE,
   ADDRESS_ID           INT(10),
   AVAILABLE            CHAR,
   CREATE_DATE          DATETIME,
   CREATE_BY            INT(10),
   UPDATE_DATE          DATETIME,
   UPDATE_BY            INT(10),
   PRIMARY KEY (ID)
);

ALTER TABLE IDEA_TPL_USER COMMENT '用户表';

/*==============================================================*/
/* Table: IDEA_USER_ROLE                                        */
/*==============================================================*/
CREATE TABLE IDEA_USER_ROLE
(
   ID                   INT(10) NOT NULL,
   USER_ID              INT(10),
   ROLE_ID              INT(10),
   CREATE_TIME          DATETIME,
   CREATE_BY            INT(10),
   UPDATE_TIME          DATETIME,
   UPDATE_BY            INT(10),
   APP_NAME             VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE IDEA_USER_ROLE COMMENT '用户角色映射表';

