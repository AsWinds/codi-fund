INSERT INTO `SYS_PRIV` (PRIV_ID, PARENT_PRIV_ID, PRIV_CODE, PRIV_NAME, TYPE, DESCRIPTION, URL, PATH)
VALUES (480, 1006, 'MENU_OPERATION_CONTENT', '基金推荐', 1, 'operationContent Management', 'operationContent/operationContent', '/operationContent/index');
INSERT INTO `SYS_ROLE_PRIV` (`ROLE_ID`, `PRIV_ID`)
VALUES (1, 480);
