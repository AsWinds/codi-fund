-- ----------------------------
-- 增加唯一约束;
-- ----------------------------
ALTER TABLE av_app_version ADD UNIQUE KEY platorm_identifier_version (av_platform, av_app_identifier, av_version);

-- ----------------------------
-- 增加非空约束;
-- ----------------------------
ALTER TABLE av_app_version MODIFY av_app_identifier char(64) NOT NULL COMMENT 'App 标识';
ALTER TABLE av_app_version MODIFY av_app_name char(64) NOT NULL COMMENT 'App 名称';
ALTER TABLE av_app_version MODIFY av_version char(64) NOT NULL COMMENT 'App 版本';
ALTER TABLE av_app_version MODIFY av_platform char(32) NOT NULL COMMENT 'App 平台';
ALTER TABLE av_app_version MODIFY av_release_notes text NOT NULL COMMENT '发布概况';
ALTER TABLE av_app_version MODIFY av_need_forece_update boolean NOT NULL COMMENT '是否必须升级';


-- ----------------------------
-- Android 1.1.0;
-- ----------------------------
INSERT INTO av_app_version (av_app_identifier, av_app_name, av_version, av_platform, av_release_notes, av_need_forece_update, av_download_path)
 VALUES ('com.codiwealth', '科地基金', '1.1.0', 'Android', '主页大排版, 优化性能和使用体验。', FALSE, 'https://cd121.com/download/CodiFund-1.1.0.apk');
