-- ----------------------------
-- Create table for table app_version_info;
-- ----------------------------
CREATE TABLE av_app_version (
	av_id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	av_app_identifier char(64) DEFAULT NULL COMMENT 'App 标识',
	av_app_name char(64) DEFAULT NULL COMMENT 'App 名称',
	av_version char(64) DEFAULT NULL COMMENT 'App 版本',
	av_platform char(32) DEFAULT NULL COMMENT 'App 平台',
	av_release_notes text DEFAULT NULL COMMENT '发布概况',
	av_need_forece_update boolean DEFAULT NULL COMMENT '是否必须升级',
	av_download_path char(64) DEFAULT NULL COMMENT 'App 下载路径',
	av_create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    av_last_updated_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'
) DEFAULT CHARSET=utf8;


INSERT INTO av_app_version (av_app_identifier, av_app_name, av_version, av_platform, av_release_notes, av_need_forece_update, av_download_path)
 VALUES ('com.codiwealth', '科地基金', '1.0.0', 'Android', 'Android平台第一个版本，支持Android 4.0及以上版本。', FALSE, 'https://cd121.com/download/CodiFund-1.0.0.apk');

INSERT INTO av_app_version (av_app_identifier, av_app_name, av_version, av_platform, av_release_notes, av_need_forece_update)
 VALUES ('com.cd121.CodiFund', '科地基金', '1.0.0', 'IOS', 'IOS平台第一个版本，支持IOS 8.0及以上版本。', FALSE);
 
INSERT INTO av_app_version (av_app_identifier, av_app_name, av_version, av_platform, av_release_notes, av_need_forece_update)
 VALUES ('com.cd121.CodiFund', '科地基金', '1.0.1', 'IOS', '一些小的Bug修正及性能增强。', FALSE);
