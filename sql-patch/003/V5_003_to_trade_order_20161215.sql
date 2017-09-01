/** 2016年12月15日15:44:10 */
/** 为了配合移动端调试，已经在DEV,SIT,UAT执行过这个SQL了 */
ALTER TABLE `to_trade_order` CHANGE COLUMN `to_trade_type` `to_trade_type` VARCHAR(100) NOT NULL ;
