DROP TABLE IF EXISTS STATIC_SH300;

/*==============================================================*/
/* Table: STATIC_SH300                                          */
/*==============================================================*/
CREATE TABLE STATIC_SH300
(
   ID                   BIGINT(9) NOT NULL AUTO_INCREMENT,
   TRADING_DATE         DATE,
   OPEN_PRICE           DECIMAL(9,2),
   CLOSE_PRICE          DECIMAL(9,2),
   MAX_PRICE            DECIMAL(9,2),
   MIN_PRICE            DECIMAL(9,2),
   TURNOVER_VOLUME      DECIMAL(18,2),
   DAILY_GROWTH_RATE    DECIMAL(9,2),
   CREATE_DATE          DATETIME NOT NULL,
   PRIMARY KEY (ID)
) DEFAULT CHARSET=utf8;

ALTER TABLE STATIC_SH300 COMMENT '深沪300数据，一年数据量预估12*20=240';

ALTER TABLE STATIC_SH300 AUTO_INCREMENT=1001;

