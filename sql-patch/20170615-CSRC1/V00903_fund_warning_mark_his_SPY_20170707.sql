-- shi.pengyan  2017-6-23 15:40:11
-- 警示内容留痕

DROP TABLE IF EXISTS fund_warning_mark_his;

/*==============================================================*/
/* table: fund_warning_mark_his                                 */
/*==============================================================*/
CREATE TABLE fund_warning_mark_his
(
    id                    INT(20) NOT NULL AUTO_INCREMENT,
    status                INT(1)           DEFAULT 1
    COMMENT '1:初始状态；2：已同步（后期支持）',
    create_date           DATETIME,
    last_update_date      DATETIME,
    user_id               INT(20),
    trade_acco            VARCHAR(20),
    warning_no            VARCHAR(20),
    allot_no              VARCHAR(100),
    client_id             VARCHAR(100),
    client_name           VARCHAR(100),
    id_kind_gb            VARCHAR(10),
    id_no                 VARCHAR(30),
    ip                    VARCHAR(30),
    brower_type           VARCHAR(30),
    mac                   VARCHAR(30),
    open_id               VARCHAR(100),
    device_id             VARCHAR(300),
    invest_risk_tolerance VARCHAR(1),
    ofund_risklevel       VARCHAR(1),
    fund_code             VARCHAR(10),
    fund_busin_code       VARCHAR(3),
    mark_content          VARCHAR(2000),
    place_holder          VARCHAR(200),
    mark_page             VARCHAR(200),
    mark_position         VARCHAR(200),
    app_version           VARCHAR(100),
    fund_name             VARCHAR(200),
    order_id              VARCHAR(200),
    PRIMARY KEY (id)
)
    AUTO_INCREMENT = 10000
    DEFAULT CHARSET = utf8;

ALTER TABLE fund_warning_mark_his
    COMMENT '警示内容留痕';
