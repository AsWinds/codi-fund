INSERT INTO `SYS_PRIV` (PRIV_ID, PARENT_PRIV_ID, PRIV_CODE, PRIV_NAME, TYPE, DESCRIPTION, URL, PATH)
VALUES (470, 1006, 'MENU_FUNDINFO', '基金信息', 1, 'fundInfo Management', 'fundInfo/fundInfo', '/fundInfo/index');
INSERT INTO `SYS_ROLE_PRIV` (`ROLE_ID`, `PRIV_ID`)
VALUES (1, 470);