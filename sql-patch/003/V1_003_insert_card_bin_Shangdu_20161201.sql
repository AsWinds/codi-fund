#先清空表
truncate table rule_cb_card_bin;
#修改列长度
alter table rule_cb_card_bin modify column rule_cb_card_name varchar(100);

delete from rule_cb_card_bin where rule_cb_bin='622150' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622150','PSBC','邮储银行','邮储银行(01000000)-绿卡银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622151' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622151','PSBC','邮储银行','邮储银行(01000000)-绿卡银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622181' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622181','PSBC','邮储银行','邮储银行(01000000)-绿卡专用卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622188' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622188','PSBC','邮储银行','邮储银行(01000000)-绿卡银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='955100' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('955100','PSBC','邮储银行','邮储银行(01000000)-绿卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621095' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621095','PSBC','邮储银行','邮储银行(01000000)-绿卡VIP卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620062' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620062','PSBC','邮储银行','邮储银行(01000000)-银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621285' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621285','PSBC','邮储银行','邮储银行(01000000)-中职学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621798' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621798','PSBC','邮储银行','邮政储蓄银行(01000000)-IC绿卡通VIP卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621799' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621799','PSBC','邮储银行','邮政储蓄银行(01000000)-IC绿卡通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621797' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621797','PSBC','邮储银行','邮政储蓄银行(01000000)-IC联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622199' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622199','PSBC','邮储银行','邮储银行(01000000)-绿卡银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621096' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621096','PSBC','邮储银行','邮储银行(01000000)-绿卡通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62215049' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62215049','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62215050' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62215050','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62215051' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62215051','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62218849' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62218849','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62218850' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62218850','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='62218851' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62218851','PSBC','邮储银行','邮储银行河南分行(01004900)-绿卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621622' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621622','PSBC','邮储银行','邮政储蓄银行(01009999)-武警军人保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623219' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623219','PSBC','邮储银行','邮政储蓄银行(01009999)-中国旅游卡（金卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621674' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621674','PSBC','邮储银行','邮政储蓄银行(01009999)-普通高中学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623218' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623218','PSBC','邮储银行','邮政储蓄银行(01009999)-中国旅游卡（普卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621599' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621599','PSBC','邮储银行','邮政储蓄银行(01009999)-福农卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623698' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623698','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通IC卡-白金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623699' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623699','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通IC卡-钻石卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623686' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623686','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通IC联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621098' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621098','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620529' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620529','PSBC','邮储银行','邮政储蓄银行(01009999)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622180' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622180','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通IC卡全国联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622182' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622182','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡芯片卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622187' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622187','PSBC','邮储银行','邮政储蓄银行(01009999)-绿卡通区域性主题卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622189' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622189','PSBC','邮储银行','邮政储蓄银行(01009999)-教育卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621582' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621582','PSBC','邮储银行','邮政储蓄银行(01009999)-福农卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='370246' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('370246','ICBC','工商银行','工商银行(01020000)-牡丹运通卡金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='370248' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('370248','ICBC','工商银行','工商银行(01020000)-牡丹运通卡金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='370249' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('370249','ICBC','工商银行','工商银行(01020000)-牡丹运通卡金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='427010' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427010','ICBC','工商银行','工商银行(01020000)-牡丹VISA卡(单位卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427018' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427018','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427019' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427019','ICBC','工商银行','工商银行(01020000)-牡丹VISA卡(单位卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427020' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427020','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427029' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427029','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427030' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427030','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427039' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427039','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='370247' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('370247','ICBC','工商银行','工商银行(01020000)-牡丹运通卡普通卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='438125' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438125','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='438126' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438126','ICBC','工商银行','工商银行(01020000)-牡丹VISA白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='451804' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('451804','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='451810' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('451810','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='451811' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('451811','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='45806' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('45806','ICBC','工商银行','工商银行(01020000)-牡丹信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='458071' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('458071','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='489734' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('489734','ICBC','工商银行','工商银行(01020000)-牡丹欧元卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='489735' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('489735','ICBC','工商银行','工商银行(01020000)-牡丹欧元卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='489736' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('489736','ICBC','工商银行','工商银行(01020000)-牡丹欧元卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427062' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427062','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427064' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427064','ICBC','工商银行','工商银行(01020000)-牡丹VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='530970' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('530970','ICBC','工商银行','工商银行(01020000)-牡丹万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53098' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53098','ICBC','工商银行','工商银行(01020000)-牡丹信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='530990' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('530990','ICBC','工商银行','工商银行(01020000)-牡丹万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='558360' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558360','ICBC','工商银行','工商银行(01020000)-牡丹万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620200' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620200','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620302' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620302','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620402' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620402','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620403' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620403','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620404' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620404','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='524047' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524047','ICBC','工商银行','工商银行(01020000)-牡丹万事达白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620406' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620406','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620407' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620407','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='525498' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('525498','ICBC','工商银行','工商银行(01020000)-海航信用卡个人普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620409' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620409','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620410' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620410','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620411' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620411','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620412' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620412','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620502' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620502','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620503' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620503','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620405' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620405','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620408' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620408','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620512' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620512','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620602' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620602','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620604' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620604','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620607' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620607','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620611' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620611','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620612' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620612','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620704' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620704','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620706' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620706','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620707' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620707','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620708' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620708','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620709' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620709','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620710' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620710','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620609' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620609','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620712' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620712','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620713' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620713','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620714' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620714','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620802' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620802','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620711' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620711','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620904' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620904','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620905' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620905','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621001' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621001','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620902' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620902','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621103' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621103','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621105' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621105','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621106' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621106','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621107' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621107','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621102' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621102','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621203' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621203','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621204' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621204','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621205' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621205','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621206' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621206','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621207' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621207','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621208' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621208','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621209' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621209','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621210' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621210','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621302' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621302','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621303' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621303','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621202' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621202','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621305' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621305','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621306' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621306','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621307' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621307','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621309' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621309','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621311' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621311','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621313' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621313','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621211' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621211','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621315' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621315','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621304' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621304','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621402' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621402','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621404' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621404','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621405' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621405','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621406' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621406','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621407' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621407','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621408' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621408','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621409' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621409','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621410' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621410','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621502' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621502','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621317' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621317','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621511' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621511','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621602' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621602','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621603' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621603','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621604' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621604','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621605' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621605','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621608' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621608','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621609' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621609','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621610' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621610','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621611' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621611','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621612' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621612','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621613' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621613','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621614' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621614','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621615' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621615','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621616' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621616','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621617' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621617','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621607' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621607','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621606' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621606','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621804' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621804','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621807' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621807','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621813' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621813','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621814' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621814','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621817' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621817','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621901' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621901','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621904' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621904','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621905' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621905','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621906' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621906','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621907' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621907','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621908' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621908','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621909' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621909','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621910' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621910','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621911' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621911','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621912' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621912','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621913' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621913','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621915' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621915','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622002' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622002','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621903' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621903','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622004' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622004','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622005' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622005','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622006' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622006','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622007' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622007','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622008' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622008','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622010' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622010','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622011' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622011','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622012' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622012','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621914' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621914','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622015' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622015','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622016' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622016','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622003' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622003','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622018' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622018','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622019' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622019','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622020' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622020','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622102' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622102','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622103' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622103','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622104' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622104','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622105' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622105','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622013' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622013','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622111' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622111','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622114' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622114','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622017' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622017','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622210' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622210','ICBC','工商银行','工商银行(01020000)-准贷记卡(个普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622211' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622211','ICBC','工商银行','工商银行(01020000)-准贷记卡(个普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622212' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622212','ICBC','工商银行','工商银行(01020000)-准贷记卡(个普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622213' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622213','ICBC','工商银行','工商银行(01020000)-准贷记卡(个普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622214' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622214','ICBC','工商银行','工商银行(01020000)-准贷记卡(个普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622110' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622110','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622220' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622220','ICBC','工商银行','工商银行(01020000)-准贷记卡(商普)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622223' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622223','ICBC','工商银行','工商银行(01020000)-牡丹卡(商务卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622225' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622225','ICBC','工商银行','工商银行(01020000)-准贷记卡(商金)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622229' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622229','ICBC','工商银行','工商银行(01020000)-牡丹卡(商务卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622230' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622230','ICBC','工商银行','工商银行(01020000)-贷记卡(个普)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622231' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622231','ICBC','工商银行','工商银行(01020000)-牡丹卡(个人卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622232' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622232','ICBC','工商银行','工商银行(01020000)-牡丹卡(个人卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622233' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622233','ICBC','工商银行','工商银行(01020000)-牡丹卡(个人卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622234' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622234','ICBC','工商银行','工商银行(01020000)-牡丹卡(个人卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622235' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622235','ICBC','工商银行','工商银行(01020000)-贷记卡(个金)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622237' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622237','ICBC','工商银行','工商银行(01020000)-牡丹交通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622215' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622215','ICBC','工商银行','工商银行(01020000)-准贷记卡(个金)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622239' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622239','ICBC','工商银行','工商银行(01020000)-牡丹交通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622240' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622240','ICBC','工商银行','工商银行(01020000)-贷记卡(商普)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622245' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622245','ICBC','工商银行','工商银行(01020000)-贷记卡(商金)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622224' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622224','ICBC','工商银行','工商银行(01020000)-牡丹卡(商务卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622303' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622303','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622304' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622304','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622305' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622305','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622306' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622306','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622307' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622307','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622308' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622308','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622309' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622309','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622238' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622238','ICBC','工商银行','工商银行(01020000)-牡丹交通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622314' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622314','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622315' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622315','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622317' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622317','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622302' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622302','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622402' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622402','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622403' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622403','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622404' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622404','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622313' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622313','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622504' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622504','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622505' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622505','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622509' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622509','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622513' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622513','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622517' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622517','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622502' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622502','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622604' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622604','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622605' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622605','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622606' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622606','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622510' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622510','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622703' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622703','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622715' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622715','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622806' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622806','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622902' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622902','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622903' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622903','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622706' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622706','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623002' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623002','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623006' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623006','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623008' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623008','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623011' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623011','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623012' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623012','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622904' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622904','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623015' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623015','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623100' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623100','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623202' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623202','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623301' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623301','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623400' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623400','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623500' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623500','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623602' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623602','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623803' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623803','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623901' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623901','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623014' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623014','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='624100' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624100','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='624200' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624200','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='624301' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624301','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='624402' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624402','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='62451804' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62451804','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62451810' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62451810','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62451811' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62451811','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6245806' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6245806','ICBC','工商银行','工商银行(01020000)-牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62458071' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62458071','ICBC','工商银行','工商银行(01020000)-牡丹贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6253098' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6253098','ICBC','工商银行','工商银行(01020000)-牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623700' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623700','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='628288' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628288','ICBC','工商银行','工商银行(01020000)-中央预算单位公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='624000' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624000','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='9558' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('9558','ICBC','工商银行','工商银行(01020000)-牡丹灵通卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='628286' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628286','ICBC','工商银行','工商银行(01020000)-财政预算单位公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622206' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622206','ICBC','工商银行','工商银行(01020000)-牡丹卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='526836' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('526836','ICBC','工商银行','工商银行(01020000)-国航知音牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='513685' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('513685','ICBC','工商银行','工商银行(01020000)-国航知音牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='543098' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('543098','ICBC','工商银行','工商银行(01020000)-国航知音牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='458441' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('458441','ICBC','工商银行','工商银行(01020000)-国航知音牡丹信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622246' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622246','ICBC','工商银行','工商银行(01020000)-专用信用消费卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='900000' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('900000','ICBC','工商银行','工商银行(01020000)-牡丹社会保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='544210' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('544210','ICBC','工商银行','中国工商银行(01020000)-牡丹东航联名卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548943' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548943','ICBC','工商银行','中国工商银行(01020000)-牡丹东航联名卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='370267' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('370267','ICBC','工商银行','中国工商银行(01020000)-牡丹运通白金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='621558' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621558','ICBC','工商银行','中国工商银行(01020000)-福农灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621559' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621559','ICBC','工商银行','中国工商银行(01020000)-福农灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621722' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621722','ICBC','工商银行','工商银行(01020000)-灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621723' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621723','ICBC','工商银行','工商银行(01020000)-灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621226' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621226','ICBC','工商银行','工商银行(01020000)-牡丹卡普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='402791' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('402791','ICBC','工商银行','工商银行(01020000)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427028' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427028','ICBC','工商银行','工商银行(01020000)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427038' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427038','ICBC','工商银行','工商银行(01020000)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548259' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548259','ICBC','工商银行','工商银行(01020000)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356879' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356879','ICBC','工商银行','中国工商银行(01020000)-牡丹JCB信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356880' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356880','ICBC','工商银行','中国工商银行(01020000)-牡丹JCB信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356881' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356881','ICBC','工商银行','中国工商银行(01020000)-牡丹JCB信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356882' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356882','ICBC','工商银行','中国工商银行(01020000)-牡丹JCB信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528856' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528856','ICBC','工商银行','中国工商银行(01020000)-牡丹多币种卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620516' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620516','ICBC','工商银行','工商银行(01020000)-预付芯片卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621721' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621721','ICBC','工商银行','工商银行(01020000)-灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='900010' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('900010','ICBC','工商银行','工商银行(01020000)-牡丹宁波市民卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625330' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625330','ICBC','工商银行','中国工商银行(01020000)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625331' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625331','ICBC','工商银行','中国工商银行(01020000)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625332' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625332','ICBC','工商银行','中国工商银行(01020000)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622236' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622236','ICBC','工商银行','中国工商银行(01020000)-借贷合一卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524374' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524374','ICBC','工商银行','中国工商银行(01020000)-牡丹多币种卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='550213' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('550213','ICBC','工商银行','中国工商银行(01020000)-牡丹多币种卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621288' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621288','ICBC','工商银行','工商银行(01020000)-工银财富卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625708' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625708','ICBC','工商银行','中国工商银行(01020000)-中小商户采购卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625709' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625709','ICBC','工商银行','中国工商银行(01020000)-中小商户采购卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622597' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622597','ICBC','工商银行','中国工商银行(01020000)-环球旅行金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622599' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622599','ICBC','工商银行','中国工商银行(01020000)-环球旅行白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='360883' and rule_cb_card_size=14;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('360883','ICBC','工商银行','中国工商银行(01020000)-牡丹工银大来卡','CC',now(),'Shangdu','14');

delete from rule_cb_card_bin where rule_cb_bin='360884' and rule_cb_card_size=14;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('360884','ICBC','工商银行','中国工商银行(01020000)-牡丹工银大莱卡','CC',now(),'Shangdu','14');

delete from rule_cb_card_bin where rule_cb_bin='625865' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625865','ICBC','工商银行','中国工商银行(01020000)-IC金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625866' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625866','ICBC','工商银行','中国工商银行(01020000)-IC白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625899' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625899','ICBC','工商银行','中国工商银行(01020000)-工行IC卡（红卡）','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='374738' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('374738','ICBC','工商银行','中国工商银行(01020000)-牡丹百夫长信用卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='374739' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('374739','ICBC','工商银行','中国工商银行(01020000)-牡丹百夫长信用卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='510529' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('510529','ICBC','工商银行','工商银行(01020000)-牡丹万事达国际借记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524091' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524091','ICBC','工商银行','工商银行(01020000)-海航信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625650' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625650','ICBC','工商银行','中国工商银行(01020000)-YL企业公司卡信用IC金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622910' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622910','ICBC','工商银行','中国工商银行(01020000)-工银环球旅行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622911' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622911','ICBC','工商银行','中国工商银行(01020000)-银联金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622912' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622912','ICBC','工商银行','中国工商银行(01020000)-银联白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622913' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622913','ICBC','工商银行','中国工商银行(01020000)-银联普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625858' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625858','ICBC','工商银行','中国工商银行(01020000)-工银I运动信用卡银联白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625859' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625859','ICBC','工商银行','中国工商银行(01020000)-工银I运动信用卡银联金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625860' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625860','ICBC','工商银行','中国工商银行(01020000)-工银I运动信用卡银联普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625160' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625160','ICBC','工商银行','中国工商银行(01020000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625161' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625161','ICBC','工商银行','中国工商银行(01020000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625162' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625162','ICBC','工商银行','中国工商银行(01020000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620086' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620086','ICBC','工商银行','中国工商银行(01020000)-中国旅行卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621670' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621670','ICBC','工商银行','中国工商银行(01020000)-普通高中学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623260' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623260','ICBC','工商银行','中国工商银行(01020000)-财智账户卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620058' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620058','ICBC','工商银行','工商银行(01020000)-银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621225' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621225','ICBC','工商银行','工商银行(01020000)-牡丹卡普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621227' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621227','ICBC','工商银行','工商银行(01020000)-理财金账户金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621281' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621281','ICBC','工商银行','工商银行(01020000)-中职学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621618' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621618','ICBC','工商银行','中国工商银行(01020000)-武警军人保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622200' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622200','ICBC','工商银行','工商银行(01020000)-灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622202' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622202','ICBC','工商银行','工商银行(01020000)-E时代卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622203' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622203','ICBC','工商银行','工商银行(01020000)-E时代卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622208' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622208','ICBC','工商银行','工商银行(01020000)-理财金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623062' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623062','ICBC','工商银行','中国工商银行(01020000)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623271' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623271','ICBC','工商银行','中国工商银行(01020000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623272' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623272','ICBC','工商银行','中国工商银行(01020000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621218' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621218','ICBC','工商银行','中国工商银行(01020000)-借记白金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621475' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621475','ICBC','工商银行','中国工商银行(01020000)-借记卡灵通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621476' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621476','ICBC','工商银行','中国工商银行(01020000)-借记卡金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623229' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623229','ICBC','工商银行','中国工商银行(01020000)-中国旅游卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625651' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625651','ICBC','工商银行','中国工商银行(01020000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62844801' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62844801','ICBC','工商银行','中国工商银行(01020000)-银联单位公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625929' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625929','ICBC','工商银行','工行布鲁塞尔(01020056)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621376' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621376','ICBC','工商银行','中国工商银行布鲁塞尔分行(01020056)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620054' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620054','ICBC','工商银行','中国工商银行布鲁塞尔分行(01020056)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620142' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620142','ICBC','工商银行','中国工商银行布鲁塞尔分行(01020056)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621423' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621423','ICBC','工商银行','中国工商银行（巴西）(01020076)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625927' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625927','ICBC','工商银行','中国工商银行（巴西）(01020076)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621428' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621428','ICBC','工商银行','中国工商银行金边分行(01020116)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625939' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625939','ICBC','工商银行','中国工商银行金边分行(01020116)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621434' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621434','ICBC','工商银行','中国工商银行金边分行(01020116)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625987' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625987','ICBC','工商银行','中国工商银行金边分行(01020116)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621761' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621761','ICBC','工商银行','中国工商银行加拿大分行(01020124)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621749' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621749','ICBC','工商银行','中国工商银行加拿大分行(01020124)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620184' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620184','ICBC','工商银行','中国工商银行加拿大分行(01020124)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625930' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625930','ICBC','工商银行','工行加拿大(01020124)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623321' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623321','ICBC','工商银行','中国工商银行加拿大分行(01020124)-预付卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621300' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621300','ICBC','工商银行','中国工商银行巴黎分行(01020250)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621378' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621378','ICBC','工商银行','中国工商银行巴黎分行(01020250)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625114' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625114','ICBC','工商银行','中国工商银行巴黎分行(01020250)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622159' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622159','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621720' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621720','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625021' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625021','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625022' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625022','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625932' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625932','ICBC','工商银行','工银法兰克福(01020276)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621379' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621379','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620114' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620114','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620146' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620146','ICBC','工商银行','中国工商银行法兰克福分行(01020276)-预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622889' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622889','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-ICBC(Asia) Credit','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625900' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625900','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-ICBC Credit Card','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622949' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622949','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-EliteClubATMCard','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625915' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625915','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-港币信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625916' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625916','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-港币信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620030' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620030','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-工银亚洲预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620050' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620050','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622944' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622944','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-CNYEasylinkCard','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625115' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625115','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-工银银联公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620101' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620101','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623335' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623335','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625941' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625941','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625801' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625801','ICBC','工商银行','中国工商银行(亚洲)有限公司(01020344)-工银亚洲贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622171' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622171','ICBC','工商银行','中国工商银行(印尼)(01020360)-印尼盾复合卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621240' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621240','ICBC','工商银行','中国工商银行(印尼)(01020360)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621724' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621724','ICBC','工商银行','中国工商银行印尼分行(01020360)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625931' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625931','ICBC','工商银行','工银印尼(01020360)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621762' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621762','ICBC','工商银行','中国工商银行（印度尼西亚）(01020360)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625918' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625918','ICBC','工商银行','中国工商银行印尼分行(01020360)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625113' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625113','ICBC','工商银行','工行米兰(01020380)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621371' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621371','ICBC','工商银行','中国工商银行米兰分行(01020380)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620143' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620143','ICBC','工商银行','中国工商银行米兰分行(01020380)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620149' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620149','ICBC','工商银行','中国工商银行米兰分行(01020380)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62137310' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62137310','ICBC','工商银行','中国工商银行米兰分行(01020380)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62137320' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62137320','ICBC','工商银行','中国工商银行米兰分行(01020380)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62592310' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62592310','ICBC','工商银行','中国工商银行米兰分行(01020380)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62592320' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62592320','ICBC','工商银行','中国工商银行米兰分行(01020380)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62592340' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62592340','ICBC','工商银行','中国工商银行米兰分行(01020380)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62013101' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62013101','ICBC','工商银行','中国工商银行米兰分行(01020380)-','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62013102' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62013102','ICBC','工商银行','中国工商银行米兰分行(01020380)-','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621730' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621730','ICBC','工商银行','工行东京分行(01020392)-工行东京借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625928' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625928','ICBC','工商银行','工行阿拉木图(01020398)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621414' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621414','ICBC','工商银行','中国工商银行阿拉木图子行(01020398)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625914' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625914','ICBC','工商银行','中国工商银行阿拉木图子行(01020398)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621375' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621375','ICBC','工商银行','中国工商银行阿拉木图子行(01020398)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620187' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620187','ICBC','工商银行','中国工商银行阿拉木图子行(01020398)-预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621734' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621734','ICBC','工商银行','工行首尔(01020410)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621433' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621433','ICBC','工商银行','中国工商银行万象分行(01020418)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625986' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625986','ICBC','工商银行','中国工商银行万象分行(01020418)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621370' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621370','ICBC','工商银行','中国工商银行卢森堡分行(01020442)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625925' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625925','ICBC','工商银行','中国工商银行卢森堡分行(01020442)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622926' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622926','ICBC','工商银行','中国工商银行澳门分行(01020446)-E时代卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622927' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622927','ICBC','工商银行','中国工商银行澳门分行(01020446)-E时代卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622928' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622928','ICBC','工商银行','中国工商银行澳门分行(01020446)-E时代卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622929' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622929','ICBC','工商银行','中国工商银行澳门分行(01020446)-理财金账户','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622930' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622930','ICBC','工商银行','中国工商银行澳门分行(01020446)-理财金账户','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622931' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622931','ICBC','工商银行','中国工商银行澳门分行(01020446)-理财金账户','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621733' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621733','ICBC','工商银行','中国工商银行（澳门）(01020446)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621732' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621732','ICBC','工商银行','中国工商银行（澳门）(01020446)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620124' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620124','ICBC','工商银行','中国工商银行澳门分行(01020446)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620183' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620183','ICBC','工商银行','中国工商银行澳门分行(01020446)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620561' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620561','ICBC','工商银行','中国工商银行澳门分行(01020446)-工银闪付预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625116' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625116','ICBC','工商银行','中国工商银行澳门分行(01020446)-工银银联公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622227' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622227','ICBC','工商银行','中国工商银行澳门分行(01020446)-Diamond','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625921' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625921','ICBC','工商银行','工行马来西亚(01020458)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621764' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621764','ICBC','工商银行','工银马来西亚(01020458)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625926' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625926','ICBC','工商银行','工行阿姆斯特丹(01020528)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621372' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621372','ICBC','工商银行','中国工商银行阿姆斯特丹(01020528)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623034' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623034','ICBC','工商银行','工银新西兰(01020554)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625110' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625110','ICBC','工商银行','工银新西兰(01020554)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621464' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621464','ICBC','工商银行','中国工商银行卡拉奇分行(01020586)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625942' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625942','ICBC','工商银行','中国工商银行卡拉奇分行(01020586)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62594250' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62594250','ICBC','工商银行','中国工商银行卡拉奇分行(01020586)-银联公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62594260' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62594260','ICBC','工商银行','中国工商银行卡拉奇分行(01020586)-银联公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62594270' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62594270','ICBC','工商银行','中国工商银行卡拉奇分行(01020586)-银联公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622158' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622158','ICBC','工商银行','中国工商银行新加坡分行(01020702)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625917' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625917','ICBC','工商银行','中国工商银行新加坡分行(01020702)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621765' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621765','ICBC','工商银行','中国工商银行新加坡分行(01020702)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620094' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620094','ICBC','工商银行','中国工商银行新加坡分行(01020702)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620186' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620186','ICBC','工商银行','中国工商银行新加坡分行(01020702)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621719' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621719','ICBC','工商银行','中国工商银行新加坡分行(01020702)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621719' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621719','ICBC','工商银行','中国工商银行新加坡分行(01020702)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625922' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625922','ICBC','工商银行','工行河内(01020704)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621369' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621369','ICBC','工商银行','工银河内(01020704)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621763' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621763','ICBC','工商银行','工银河内(01020704)-工银越南盾借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625934' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625934','ICBC','工商银行','工银河内(01020704)-工银越南盾信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620046' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620046','ICBC','工商银行','工银河内(01020704)-预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621750' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621750','ICBC','工商银行','中国工商银行马德里分行(01020724)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625933' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625933','ICBC','工商银行','工行马德里(01020724)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621377' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621377','ICBC','工商银行','中国工商银行马德里分行(01020724)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620148' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620148','ICBC','工商银行','中国工商银行马德里分行(01020724)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620185' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620185','ICBC','工商银行','中国工商银行马德里分行(01020724)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625920' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625920','ICBC','工商银行','工银泰国(01020764)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621367' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621367','ICBC','工商银行','工银泰国(01020764)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625924' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625924','ICBC','工商银行','工行伦敦(01020826)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621374' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621374','ICBC','工商银行','中国工商银行伦敦子行(01020826)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621731' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621731','ICBC','工商银行','中国工商银行伦敦子行(01020826)-工银伦敦借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621781' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621781','ICBC','工商银行','中国工商银行伦敦子行(01020826)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6243190' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6243190','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6243191' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6243191','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6243192' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6243192','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6243193' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6243193','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62431940' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62431940','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6244220' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6244220','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6244221' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6244221','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6244222' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6244222','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6244223' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6244223','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62442240' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62442240','ICBC','工商银行','ICBC(USA)NA(01020840)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='103' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('103','ABC','农业银行','农业银行(01030000)-金穗借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='552599' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552599','ABC','农业银行','农业银行(01030000)-金穗贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6349102' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6349102','ABC','农业银行','农业银行(01030000)-金穗信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6353591' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6353591','ABC','农业银行','农业银行(01030000)-金穗信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623206' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623206','ABC','农业银行','农业银行(01030000)-中国旅游卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621671' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621671','ABC','农业银行','农业银行(01030000)-普通高中学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620059' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620059','ABC','农业银行','农业银行(01030000)-银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='403361' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('403361','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404117' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404117','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404118' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404118','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404119' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404119','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404120' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404120','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404121' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404121','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='463758' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('463758','ABC','农业银行','农业银行(01030000)-VISA白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='49102' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('49102','ABC','农业银行','农业银行(01030000)-金穗信用卡(银联卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='514027' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('514027','ABC','农业银行','农业银行(01030000)-万事达白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='519412' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('519412','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='519413' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('519413','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520082' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520082','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520083' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520083','ABC','农业银行','农业银行(01030000)-金穗贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53591' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53591','ABC','农业银行','农业银行(01030000)-金穗信用卡(银联卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='558730' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558730','ABC','农业银行','农业银行(01030000)-金穗贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621282' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621282','ABC','农业银行','农业银行(01030000)-中职学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621336' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621336','ABC','农业银行','农业银行(01030000)-专用惠农卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621619' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621619','ABC','农业银行','农业银行(01030000)-武警军人保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622821' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622821','ABC','农业银行','农业银行(01030000)-金穗校园卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622822' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622822','ABC','农业银行','农业银行(01030000)-金穗星座卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622823' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622823','ABC','农业银行','农业银行(01030000)-金穗社保卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622824' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622824','ABC','农业银行','农业银行(01030000)-金穗旅游卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622825' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622825','ABC','农业银行','农业银行(01030000)-金穗青年卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622826' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622826','ABC','农业银行','农业银行(01030000)-复合介质金穗通宝卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622827' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622827','ABC','农业银行','农业银行(01030000)-金穗海通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622828' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622828','ABC','农业银行','农业银行(01030000)-退役金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622836' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622836','ABC','农业银行','农业银行(01030000)-金穗贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622837' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622837','ABC','农业银行','农业银行(01030000)-金穗贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622840' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622840','ABC','农业银行','农业银行(01030000)-金穗通宝卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622841' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622841','ABC','农业银行','农业银行(01030000)-金穗惠农卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622843' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622843','ABC','农业银行','农业银行(01030000)-金穗通宝银卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622844' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622844','ABC','农业银行','农业银行(01030000)-金穗通宝卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622845' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622845','ABC','农业银行','农业银行(01030000)-金穗通宝卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622846' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622846','ABC','农业银行','农业银行(01030000)-金穗通宝卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622847' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622847','ABC','农业银行','农业银行(01030000)-金穗通宝卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622848' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622848','ABC','农业银行','农业银行(01030000)-金穗通宝卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622849' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622849','ABC','农业银行','农业银行(01030000)-金穗通宝钻石卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623018' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623018','ABC','农业银行','农业银行(01030000)-掌尚钱包','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625996' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625996','ABC','农业银行','农业银行(01030000)-银联IC卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625997' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625997','ABC','农业银行','农业银行(01030000)-银联预算单位公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625998' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625998','ABC','农业银行','农业银行(01030000)-银联IC卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628268' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628268','ABC','农业银行','农业银行(01030000)-金穗公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='95595' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95595','ABC','农业银行','农业银行(01030000)-借记卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='95596' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95596','ABC','农业银行','农业银行(01030000)-借记卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='95597' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95597','ABC','农业银行','农业银行(01030000)-借记卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='95598' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95598','ABC','农业银行','农业银行(01030000)-借记卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='95599' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95599','ABC','农业银行','农业银行(01030000)-借记卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622839' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622839','ABC','农业银行','农业银行(01030000)-农行钻石信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623052' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623052','ABC','农业银行','农业银行(01030000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623056' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623056','ABC','农业银行','农业银行(01030000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623050' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623050','ABC','农业银行','农业银行(01030000)-电子账户','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623053' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623053','ABC','农业银行','农业银行(01030000)-电子账户','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625826' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625826','ABC','农业银行','中国农业银行贷记卡(01030001)-IC普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548478' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548478','ABC','农业银行','中国农业银行贷记卡(01030001)-澳元卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='544243' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('544243','ABC','农业银行','中国农业银行贷记卡(01030001)-欧元卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622820' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622820','ABC','农业银行','中国农业银行贷记卡(01030001)-金穗通商卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622830' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622830','ABC','农业银行','中国农业银行贷记卡(01030001)-金穗通商卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622838' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622838','ABC','农业银行','中国农业银行贷记卡(01030001)-银联白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625336' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625336','ABC','农业银行','中国农业银行贷记卡(01030001)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628269' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628269','ABC','农业银行','中国农业银行贷记卡(01030001)-银联IC公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625653' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625653','ABC','农业银行','中国农业银行贷记卡(01030001)-农行商务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628346' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628346','ABC','农业银行','中国农业银行贷记卡(01030001)-农行标准公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625171' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625171','ABC','农业银行','中国农业银行贷记卡(01030001)-农行标准金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625170' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625170','ABC','农业银行','中国农业银行贷记卡(01030001)-农行标准金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625827' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625827','ABC','农业银行','中国农业银行贷记卡(01030001)-IC金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620501' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620501','ABC','农业银行','宁波市农业银行(01033320)-市民卡B卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621660' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621660','BOC','中国银行','中国银行(01040000)-联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621661' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621661','BOC','中国银行','中国银行(01040000)-个人普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621663' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621663','BOC','中国银行','中国银行(01040000)-员工普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621667' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621667','BOC','中国银行','中国银行(01040000)-理财普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621668' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621668','BOC','中国银行','中国银行(01040000)-理财金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621666' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621666','BOC','中国银行','中国银行(01040000)-理财白金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='356833' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356833','BOC','中国银行','中国银行(01040000)-中银JCB卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356835' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356835','BOC','中国银行','中国银行(01040000)-中银JCB卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409665' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409665','BOC','中国银行','中国银行(01040000)-员工普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409666' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409666','BOC','中国银行','中国银行(01040000)-个人普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409668' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409668','BOC','中国银行','中国银行(01040000)-中银威士信用卡员','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409669' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409669','BOC','中国银行','中国银行(01040000)-中银威士信用卡员','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409670' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409670','BOC','中国银行','中国银行(01040000)-个人白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409671' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409671','BOC','中国银行','中国银行(01040000)-中银威士信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409672' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409672','BOC','中国银行','中国银行(01040000)-长城公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='456351' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('456351','BOC','中国银行','中国银行(01040000)-长城电子借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='512315' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512315','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='512316' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512316','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='512411' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512411','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='512412' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512412','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='514957' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('514957','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='409667' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('409667','BOC','中国银行','中国银行(01040000)-中银威士信用卡员','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518378' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518378','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518379' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518379','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518474' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518474','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518475' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518475','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518476' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518476','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='438088' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438088','BOC','中国银行','中国银行(01040000)-中银奥运信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524865' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524865','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='525745' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('525745','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='525746' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('525746','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='547766' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('547766','BOC','中国银行','中国银行(01040000)-长城万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552742' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552742','BOC','中国银行','中国银行(01040000)-长城公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='553131' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('553131','BOC','中国银行','中国银行(01040000)-长城公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='558868' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558868','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='514958' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('514958','BOC','中国银行','中国银行(01040000)-中银万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622752' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622752','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622753' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622753','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622755' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622755','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524864' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524864','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622757' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622757','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622758' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622758','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622759' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622759','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622760' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622760','BOC','中国银行','中国银行(01040000)-银联单币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622761' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622761','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622762' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622762','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622763' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622763','BOC','中国银行','中国银行(01040000)-长城信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='601382' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('601382','BOC','中国银行','中国银行(01040000)-长城电子借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622756' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622756','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628388' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628388','BOC','中国银行','中国银行(01040000)-银联标准公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621256' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621256','BOC','中国银行','中国银行(01040000)-一卡双账户普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621212' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621212','BOC','中国银行','中国银行(01040000)-财互通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620514' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620514','BOC','中国银行','中国银行(01040000)-电子现金卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622754' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622754','BOC','中国银行','中国银行(01040000)-长城人民币信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518377' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518377','BOC','中国银行','中国银行(01040000)-中银女性主题信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622788' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622788','BOC','中国银行','中国银行(01040000)-白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621283' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621283','BOC','中国银行','中国银行(01040000)-中职学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620061' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620061','BOC','中国银行','中国银行(01040000)-银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621725' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621725','BOC','中国银行','中国银行(01040000)-金融IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620040' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620040','BOC','中国银行','中国银行(01040000)-长城社会保障卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='558869' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558869','BOC','中国银行','中国银行(01040000)-世界卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621330' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621330','BOC','中国银行','中国银行(01040000)-社保联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621331' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621331','BOC','中国银行','中国银行(01040000)-社保联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621332' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621332','BOC','中国银行','中国银行(01040000)-医保联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621333' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621333','BOC','中国银行','中国银行(01040000)-医保联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621297' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621297','BOC','中国银行','中国银行(01040000)-公司借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='377677' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('377677','BOC','中国银行','中国银行(01040000)-银联美运顶级卡','SCC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='621568' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621568','BOC','中国银行','中国银行(01040000)-长城福农借记卡金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621569' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621569','BOC','中国银行','中国银行(01040000)-长城福农借记卡普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625905' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625905','BOC','中国银行','中国银行(01040000)-中行金融IC卡普卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625906' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625906','BOC','中国银行','中国银行(01040000)-中行金融IC卡金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625907' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625907','BOC','中国银行','中国银行(01040000)-中行金融IC卡白金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628313' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628313','BOC','中国银行','中国银行(01040000)-长城银联公务IC卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625333' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625333','BOC','中国银行','中国银行(01040000)-中银旅游信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628312' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628312','BOC','中国银行','中国银行(01040000)-长城银联公务IC卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623208' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623208','BOC','中国银行','中国银行(01040000)-中国旅游卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621620' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621620','BOC','中国银行','中国银行(01040000)-武警军人保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621756' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621756','BOC','中国银行','中国银行(01040000)-社保联名借记IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621757' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621757','BOC','中国银行','中国银行(01040000)-社保联名借记IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621758' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621758','BOC','中国银行','中国银行(01040000)-医保联名借记IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621759' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621759','BOC','中国银行','中国银行(01040000)-医保联名借记IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621785' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621785','BOC','中国银行','中国银行(01040000)-借记IC个人普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621786' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621786','BOC','中国银行','中国银行(01040000)-借记IC个人金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621787' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621787','BOC','中国银行','中国银行(01040000)-借记IC个人普卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621788' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621788','BOC','中国银行','中国银行(01040000)-借记IC白金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621789' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621789','BOC','中国银行','中国银行(01040000)-借记IC钻石卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621790' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621790','BOC','中国银行','中国银行(01040000)-借记IC联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621672' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621672','BOC','中国银行','中国银行(01040000)-普通高中学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625337' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625337','BOC','中国银行','中国银行(01040000)-长城环球通港澳台旅游金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625338' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625338','BOC','中国银行','中国银行(01040000)-长城环球通港澳台旅游白金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625568' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625568','BOC','中国银行','中国银行(01040000)-中银福农信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621669' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621669','BOC','中国银行','中国银行(01040000)-理财银卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621662' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621662','BOC','中国银行','中国银行(01040000)-个人金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623571' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623571','BOC','中国银行','中国银行(01040000)-长城代发薪借记IC卡（钻石卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623572' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623572','BOC','中国银行','中国银行(01040000)-长城代发薪借记IC卡（白金卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623575' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623575','BOC','中国银行','中国银行(01040000)-长城代发薪借记IC卡（普卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623263' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623263','BOC','中国银行','中国银行(01040000)-中银单位结算卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623184' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623184','BOC','中国银行','中国银行(01040000)-银联保障类借记IC卡（金卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623569' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623569','BOC','中国银行','中国银行(01040000)-银联保障类借记IC卡（白金卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623586' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623586','BOC','中国银行','中国银行(01040000)-银联多币借记IC卡（钻石卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625834' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625834','BOC','中国银行','中国银行(01040000)-银联HCE移动支付信用卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623573' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623573','BOC','中国银行','中国银行(01040000)-长城代发薪借记IC卡（金卡）','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621665' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621665','BOC','中国银行','中国银行(01040000)-员工金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='627025' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627025','BOC','中国银行','中国银行(01040000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='627026' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627026','BOC','中国银行','中国银行(01040000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='627027' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627027','BOC','中国银行','中国银行(01040000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='627028' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627028','BOC','中国银行','中国银行(01040000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622764' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622764','BOC','中国银行','中国银行(01040000)-长城单位信用卡普卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622765' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622765','BOC','中国银行','中国银行(01040000)-长城单位信用卡金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625908' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625908','BOC','中国银行','中国银行(01040000)-中行金融IC卡白金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625909' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625909','BOC','中国银行','中国银行(01040000)-中行金融IC卡金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625910' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625910','BOC','中国银行','中国银行(01040000)-中行金融IC卡普卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620025' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620025','BOC','中国银行','中国银行（澳大利亚）(01040036)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620026' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620026','BOC','中国银行','中国银行（澳大利亚）(01040036)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621293' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621293','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621294' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621294','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621342' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621342','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621343' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621343','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621364' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621364','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621394' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621394','BOC','中国银行','中国银行（澳大利亚）(01040036)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621648' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621648','BOC','中国银行','中国银行金边分行(01040116)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621248' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621248','BOC','中国银行','中国银行雅加达分行(01040360)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621215' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621215','BOC','中国银行','中银东京分行(01040392)-借记卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621249' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621249','BOC','中国银行','中国银行首尔分行(01040410)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622771' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622771','BOC','中国银行','中国银行澳门分行(01040446)-中银卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622772' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622772','BOC','中国银行','中国银行澳门分行(01040446)-中银卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622770' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622770','BOC','中国银行','中国银行澳门分行(01040446)-中银卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620531' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620531','BOC','中国银行','中国银行澳门分行(01040446)-预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620210' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620210','BOC','中国银行','中国银行澳门分行(01040446)-澳门中国银行银联预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620211' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620211','BOC','中国银行','中国银行澳门分行(01040446)-澳门中国银行银联预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622479' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622479','BOC','中国银行','中国银行澳门分行(01040446)-熊猫卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622480' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622480','BOC','中国银行','中国银行澳门分行(01040446)-财富卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622273' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622273','BOC','中国银行','中国银行澳门分行(01040446)-银联港币卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622274' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622274','BOC','中国银行','中国银行澳门分行(01040446)-银联澳门币卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622380' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622380','BOC','中国银行','中国银行澳门分行(01040446)-中银全币种银联尊贵卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='626200' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('626200','BOC','中国银行','中国银行澳门分行(01040446)-','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620019' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620019','BOC','中国银行','中国银行(马来西亚)(01040458)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620035' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620035','BOC','中国银行','中国银行(马来西亚)(01040458)-预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621231' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621231','BOC','中国银行','中国银行马尼拉分行(01040608)-双币种借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622789' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622789','BOC','中国银行','中行新加坡分行(01040702)-BOCCUPPLATINUMCARD','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621638' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621638','BOC','中国银行','中国银行胡志明分行(01040704)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621334' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621334','BOC','中国银行','中国银行曼谷分行(01040764)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625140' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625140','BOC','中国银行','中国银行曼谷分行(01040764)-长城信用卡环球通','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621395' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621395','BOC','中国银行','中国银行曼谷分行(01040764)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620513' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620513','BOC','中国银行','中行宁波分行(01043320)-长城宁波市民卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='5453242' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('5453242','CCB','建设银行','建设银行(01050000)-龙卡信用卡','CC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='5491031' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('5491031','CCB','建设银行','建设银行(01050000)-龙卡信用卡','CC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='5544033' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('5544033','CCB','建设银行','建设银行(01050000)-龙卡信用卡','CC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622725' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622725','CCB','建设银行','建设银行(01050000)-龙卡准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622728' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622728','CCB','建设银行','建设银行(01050000)-龙卡准贷记卡金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621284' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621284','CCB','建设银行','建设银行(01050000)-中职学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='421349' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421349','CCB','建设银行','建设银行(01050000)-乐当家银卡VISA','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='434061' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('434061','CCB','建设银行','建设银行(01050000)-乐当家金卡VISA','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='434062' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('434062','CCB','建设银行','建设银行(01050000)-乐当家白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436728' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436728','CCB','建设银行','建设银行(01050000)-龙卡普通卡VISA','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436742' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436742','CCB','建设银行','建设银行(01050000)-龙卡储蓄卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='453242' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('453242','CCB','建设银行','建设银行(01050000)-VISA准贷记卡(银联卡)','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491031' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491031','CCB','建设银行','建设银行(01050000)-VISA准贷记金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524094' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524094','CCB','建设银行','建设银行(01050000)-乐当家','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='526410' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('526410','CCB','建设银行','建设银行(01050000)-乐当家','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53242' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53242','CCB','建设银行','建设银行(01050000)-MASTER准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53243' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53243','CCB','建设银行','建设银行(01050000)-乐当家','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='544033' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('544033','CCB','建设银行','建设银行(01050000)-准贷记金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552245' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552245','CCB','建设银行','建设银行(01050000)-乐当家白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='589970' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('589970','CCB','建设银行','建设银行(01050000)-金融复合IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620060' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620060','CCB','建设银行','建设银行(01050000)-银联标准卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621080' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621080','CCB','建设银行','建设银行(01050000)-银联理财钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621081' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621081','CCB','建设银行','建设银行(01050000)-金融IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621466' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621466','CCB','建设银行','建设银行(01050000)-理财白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621467' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621467','CCB','建设银行','建设银行(01050000)-社保IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621488' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621488','CCB','建设银行','建设银行(01050000)-财富卡私人银行卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621499' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621499','CCB','建设银行','建设银行(01050000)-理财金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621598' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621598','CCB','建设银行','建设银行(01050000)-福农卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621621' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621621','CCB','建设银行','建设银行(01050000)-武警军人保障卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621700' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621700','CCB','建设银行','建设银行(01050000)-龙卡通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622280' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622280','CCB','建设银行','建设银行(01050000)-银联储蓄卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622700' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622700','CCB','建设银行','建设银行(01050000)-龙卡储蓄卡(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622707' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622707','CCB','建设银行','建设银行(01050000)-准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622966' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622966','CCB','建设银行','建设银行(01050000)-理财白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622988' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622988','CCB','建设银行','建设银行(01050000)-理财金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625955' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625955','CCB','建设银行','建设银行(01050000)-准贷记卡普卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625956' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625956','CCB','建设银行','建设银行(01050000)-准贷记卡金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='553242' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('553242','CCB','建设银行','建设银行(01050000)-龙卡信用卡','CC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621082' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621082','CCB','建设银行','建设银行(01050000)-建行陆港通龙卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623251' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623251','CCB','建设银行','建设银行(01050000)-单位结算卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621673' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621673','CCB','建设银行','中国建设银行(01050001)-普通高中学生资助卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623211' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623211','CCB','建设银行','中国建设银行(01050001)-中国旅游卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623668' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623668','CCB','建设银行','中国建设银行(01050001)-结算通借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623094' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623094','CCB','建设银行','中国建设银行(01050001)-代发工资借记IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623669' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623669','CCB','建设银行','中国建设银行(01050001)-全国联名卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='436742193' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436742193','CCB','建设银行','建行厦门分行(01053930)-龙卡储蓄卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622280193' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622280193','CCB','建设银行','建行厦门分行(01053930)-银联储蓄卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='356896' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356896','CCB','建设银行','中国建设银行(01059999)-龙卡JCB金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356899' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356899','CCB','建设银行','中国建设银行(01059999)-龙卡JCB白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356895' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356895','CCB','建设银行','中国建设银行(01059999)-龙卡JCB普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436718' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436718','CCB','建设银行','中国建设银行(01059999)-龙卡贷记卡公司卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436738' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436738','CCB','建设银行','中国建设银行(01059999)-龙卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436745' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436745','CCB','建设银行','中国建设银行(01059999)-龙卡国际普通卡VISA','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436748' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436748','CCB','建设银行','中国建设银行(01059999)-龙卡国际金卡VISA','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='489592' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('489592','CCB','建设银行','中国建设银行(01059999)-VISA白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='531693' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('531693','CCB','建设银行','中国建设银行(01059999)-龙卡国际白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='532450' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('532450','CCB','建设银行','中国建设银行(01059999)-龙卡国际普通卡MASTER','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='532458' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('532458','CCB','建设银行','中国建设银行(01059999)-龙卡国际金卡MASTER','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='544887' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('544887','CCB','建设银行','中国建设银行(01059999)-龙卡万事达金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552801' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552801','CCB','建设银行','中国建设银行(01059999)-龙卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='557080' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('557080','CCB','建设银行','中国建设银行(01059999)-龙卡万事达白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='558895' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558895','CCB','建设银行','中国建设银行(01059999)-龙卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='559051' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('559051','CCB','建设银行','中国建设银行(01059999)-龙卡万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622166' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622166','CCB','建设银行','中国建设银行(01059999)-龙卡人民币信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622168' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622168','CCB','建设银行','中国建设银行(01059999)-龙卡人民币信用金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622708' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622708','CCB','建设银行','中国建设银行(01059999)-龙卡人民币白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625964' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625964','CCB','建设银行','中国建设银行(01059999)-龙卡IC信用卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625965' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625965','CCB','建设银行','中国建设银行(01059999)-龙卡IC信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625966' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625966','CCB','建设银行','中国建设银行(01059999)-龙卡IC信用卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628266' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628266','CCB','建设银行','中国建设银行(01059999)-龙卡银联公务卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628366' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628366','CCB','建设银行','中国建设银行(01059999)-龙卡银联公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625362' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625362','CCB','建设银行','中国建设银行(01059999)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625363' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625363','CCB','建设银行','中国建设银行(01059999)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628316' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628316','CCB','建设银行','中国建设银行(01059999)-龙卡IC公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628317' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628317','CCB','建设银行','中国建设银行(01059999)-龙卡IC公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620021' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620021','COMM','交通银行','交通银行(03010000)-交行预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620521' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620521','COMM','交通银行','交通银行(03010000)-世博预付IC卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='405512' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('405512','COMM','交通银行','交通银行(03010000)-太平洋互连卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='49104' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('49104','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53783' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53783','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='601428' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('601428','COMM','交通银行','交通银行(03010000)-太平洋万事顺卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='405512' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('405512','COMM','交通银行','交通银行(03010000)-太平洋互连卡(银联卡)','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='434910' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('434910','COMM','交通银行','交通银行(03010000)-太平洋白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='458123' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('458123','COMM','交通银行','交通银行(03010000)-太平洋双币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='458124' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('458124','COMM','交通银行','交通银行(03010000)-太平洋双币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='49104' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('49104','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520169' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520169','COMM','交通银行','交通银行(03010000)-太平洋双币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='522964' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('522964','COMM','交通银行','交通银行(03010000)-太平洋白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='53783' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('53783','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='601428' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('601428','COMM','交通银行','交通银行(03010000)-太平洋万事顺卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='622250' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622250','COMM','交通银行','交通银行(03010000)-太平洋人民币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622251' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622251','COMM','交通银行','交通银行(03010000)-太平洋人民币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='521899' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('521899','COMM','交通银行','交通银行(03010000)-太平洋双币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622254' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622254','COMM','交通银行','交通银行(03010000)-太平洋准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622255' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622255','COMM','交通银行','交通银行(03010000)-太平洋准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622256' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622256','COMM','交通银行','交通银行(03010000)-太平洋准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622257' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622257','COMM','交通银行','交通银行(03010000)-太平洋准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622258' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622258','COMM','交通银行','交通银行(03010000)-太平洋借记卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='622259' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622259','COMM','交通银行','交通银行(03010000)-太平洋借记卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='622253' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622253','COMM','交通银行','交通银行(03010000)-太平洋人民币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622261' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622261','COMM','交通银行','交通银行(03010000)-太平洋借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622284' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622284','COMM','交通银行','交通银行(03010000)-太平洋MORE卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622656' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622656','COMM','交通银行','交通银行(03010000)-白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628216' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628216','COMM','交通银行','交通银行(03010000)-交通银行公务卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622252' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622252','COMM','交通银行','交通银行(03010000)-太平洋人民币贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='66405512' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('66405512','COMM','交通银行','交通银行(03010000)-太平洋互连卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='6649104' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6649104','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622260' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622260','COMM','交通银行','交通银行(03010000)-太平洋借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='66601428' and rule_cb_card_size=17;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('66601428','COMM','交通银行','交通银行(03010000)-太平洋万事顺卡','DC',now(),'Shangdu','17');

delete from rule_cb_card_bin where rule_cb_bin='955590' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('955590','COMM','交通银行','交通银行(03010000)-太平洋贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='955591' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('955591','COMM','交通银行','交通银行(03010000)-太平洋贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='955592' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('955592','COMM','交通银行','交通银行(03010000)-太平洋贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='955593' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('955593','COMM','交通银行','交通银行(03010000)-太平洋贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6653783' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6653783','COMM','交通银行','交通银行(03010000)-太平洋信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628218' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628218','COMM','交通银行','交通银行(03010000)-交通银行公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622262' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622262','COMM','交通银行','交通银行(03010000)-交银IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623261' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623261','COMM','交通银行','交通银行(03010000)-交通银行单位结算卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622285' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622285','COMM','交通银行','交通银行(03010000)-more银联金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621069' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621069','COMM','交通银行','交通银行香港分行(03010344)-交通银行港币借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='620013' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620013','COMM','交通银行','交通银行香港分行(03010344)-港币礼物卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625028' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625028','COMM','交通银行','交通银行香港分行(03010344)-双币种信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625029' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625029','COMM','交通银行','交通银行香港分行(03010344)-双币种信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621436' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621436','COMM','交通银行','交通银行香港分行(03010344)-双币卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621002' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621002','COMM','交通银行','交通银行香港分行(03010344)-银联人民币卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621335' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621335','COMM','交通银行','交通银行澳门分行(03010446)-银联借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='433670' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('433670','CITIC','中信银行','中信银行(03020000)-中信借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='433680' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('433680','CITIC','中信银行','中信银行(03020000)-中信借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='442729' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('442729','CITIC','中信银行','中信银行(03020000)-中信国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='442730' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('442730','CITIC','中信银行','中信银行(03020000)-中信国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620082' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620082','CITIC','中信银行','中信银行(03020000)-中国旅行卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622690' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622690','CITIC','中信银行','中信银行(03020000)-中信借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622691' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622691','CITIC','中信银行','中信银行(03020000)-中信借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622692' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622692','CITIC','中信银行','中信银行(03020000)-中信贵宾卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622696' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622696','CITIC','中信银行','中信银行(03020000)-中信理财宝金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622698' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622698','CITIC','中信银行','中信银行(03020000)-中信理财宝白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622998' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622998','CITIC','中信银行','中信银行(03020000)-中信钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622999' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622999','CITIC','中信银行','中信银行(03020000)-中信钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='433671' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('433671','CITIC','中信银行','中信银行(03020000)-中信借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='968807' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('968807','CITIC','中信银行','中信银行(03020000)-中信理财宝(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='968808' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('968808','CITIC','中信银行','中信银行(03020000)-中信理财宝(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='968809' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('968809','CITIC','中信银行','中信银行(03020000)-中信理财宝(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621771' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621771','CITIC','中信银行','中信银行(03020000)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621767' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621767','CITIC','中信银行','中信银行(03020000)-理财宝IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621768' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621768','CITIC','中信银行','中信银行(03020000)-理财宝IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621770' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621770','CITIC','中信银行','中信银行(03020000)-理财宝IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621772' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621772','CITIC','中信银行','中信银行(03020000)-理财宝IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621773' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621773','CITIC','中信银行','中信银行(03020000)-理财宝IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620527' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620527','CITIC','中信银行','中信银行(03020000)-主账户复合电子现金卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621769' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621769','CITIC','中信银行','中信银行(03020000)-中信银行钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623280' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623280','CITIC','中信银行','中信银行(03020000)-浙江高院案款管理系统专用卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='303' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('303','CEB','光大银行','光大银行(03030000)-阳光卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356837' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356837','CEB','光大银行','光大银行(03030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356838' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356838','CEB','光大银行','光大银行(03030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='486497' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('486497','CEB','光大银行','光大银行(03030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622660' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622660','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622662' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622662','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622663' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622663','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622664' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622664','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622665' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622665','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622666' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622666','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622667' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622667','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622669' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622669','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622670' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622670','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622671' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622671','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622672' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622672','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622668' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622668','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622661' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622661','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622674' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622674','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='90030' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('90030','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622673' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622673','CEB','光大银行','光大银行(03030000)-阳光卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620518' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620518','CEB','光大银行','光大银行(03030000)-借记卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621489' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621489','CEB','光大银行','光大银行(03030000)-社会保障IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621492' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621492','CEB','光大银行','光大银行(03030000)-IC借记卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620535' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620535','CEB','光大银行','光大银行(03030000)-手机支付卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623156' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623156','CEB','光大银行','光大银行(03030000)-联名IC卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621490' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621490','CEB','光大银行','光大银行(03030000)-借记IC卡白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621491' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621491','CEB','光大银行','光大银行(03030000)-借记IC卡金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620085' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620085','CEB','光大银行','光大银行(03030000)-阳光旅行卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623155' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623155','CEB','光大银行','光大银行(03030000)-借记IC卡钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623157' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623157','CEB','光大银行','光大银行(03030000)-联名IC卡金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623158' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623158','CEB','光大银行','光大银行(03030000)-联名IC卡白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623159' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623159','CEB','光大银行','光大银行(03030000)-联名IC卡钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623253' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623253','CEB','光大银行','光大银行(03030000)---','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='999999' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('999999','HXBANK','华夏银行','华夏银行(03040000)-华夏卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621222' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621222','HXBANK','华夏银行','华夏银行(03040000)-华夏白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623020' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623020','HXBANK','华夏银行','华夏银行(03040000)-华夏普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623021' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623021','HXBANK','华夏银行','华夏银行(03040000)-华夏金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623022' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623022','HXBANK','华夏银行','华夏银行(03040000)-华夏白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623023' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623023','HXBANK','华夏银行','华夏银行(03040000)-华夏钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622630' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622630','HXBANK','华夏银行','华夏银行(03040000)-华夏卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622631' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622631','HXBANK','华夏银行','华夏银行(03040000)-华夏至尊金卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622632' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622632','HXBANK','华夏银行','华夏银行(03040000)-华夏丽人卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622633' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622633','HXBANK','华夏银行','华夏银行(03040000)-华夏万通卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620552' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620552','HXBANK','华夏银行','华夏银行(03040000)---','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622615' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622615','CMBC','民生银行','民生银行(03050000)-民生借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622616' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622616','CMBC','民生银行','民生银行(03050000)-民生银联借记卡－金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622618' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622618','CMBC','民生银行','民生银行(03050000)-钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622622' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622622','CMBC','民生银行','民生银行(03050000)-民生借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622617' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622617','CMBC','民生银行','民生银行(03050000)-民生借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622619' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622619','CMBC','民生银行','民生银行(03050000)-民生借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='415599' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('415599','CMBC','民生银行','民生银行(03050000)-民生借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421393' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421393','CMBC','民生银行','民生银行(03050000)-民生国际卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421865' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421865','CMBC','民生银行','民生银行(03050000)-民生国际卡(银卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427570' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427570','CMBC','民生银行','民生银行(03050000)-民生国际卡(欧元卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='427571' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('427571','CMBC','民生银行','民生银行(03050000)-民生国际卡(澳元卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='472067' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('472067','CMBC','民生银行','民生银行(03050000)-民生国际卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='472068' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('472068','CMBC','民生银行','民生银行(03050000)-民生国际卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622620' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622620','CMBC','民生银行','民生银行(03050000)-薪资理财卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621691' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621691','CMBC','民生银行','民生银行(03050000)-借记卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623255' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623255','CMBC','民生银行','民生银行(03050000)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='900003' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('900003','CMBC','民生银行','民生银行(03050000)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623258' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623258','CMBC','民生银行','民生银行(03050000)---','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623683' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623683','CMBC','民生银行','民生银行(03050000)-民生银行银联借记卡银卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545392' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545392','CMBC','民生银行','民生银行(03050001)-民生MasterCard','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545393' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545393','CMBC','民生银行','民生银行(03050001)-民生MasterCard','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545431' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545431','CMBC','民生银行','民生银行(03050001)-民生MasterCard','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545447' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545447','CMBC','民生银行','民生银行(03050001)-民生MasterCard','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356859' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356859','CMBC','民生银行','民生银行(03050001)-民生JCB信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356857' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356857','CMBC','民生银行','民生银行(03050001)-民生JCB金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='407405' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('407405','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421869' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421869','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421870' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421870','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421871' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421871','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='512466' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512466','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356856' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356856','CMBC','民生银行','民生银行(03050001)-民生JCB普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528948' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528948','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552288' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552288','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622600' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622600','CMBC','民生银行','民生银行(03050001)-民生信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622601' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622601','CMBC','民生银行','民生银行(03050001)-民生信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622602' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622602','CMBC','民生银行','民生银行(03050001)-民生银联白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='517636' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('517636','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622621' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622621','CMBC','民生银行','民生银行(03050001)-民生银联个人白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628258' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628258','CMBC','民生银行','民生银行(03050001)-公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='556610' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('556610','CMBC','民生银行','民生银行(03050001)-民生贷记卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622603' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622603','CMBC','民生银行','民生银行(03050001)-民生银联商务信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='464580' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('464580','CMBC','民生银行','民生银行(03050001)-民VISA无限卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='464581' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('464581','CMBC','民生银行','民生银行(03050001)-民生VISA商务白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='523952' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('523952','CMBC','民生银行','民生银行(03050001)-民生万事达钛金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545217' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545217','CMBC','民生银行','民生银行(03050001)-民生万事达世界卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='553161' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('553161','CMBC','民生银行','民生银行(03050001)-民生万事达白金公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356858' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356858','CMBC','民生银行','民生银行(03050001)-民生JCB白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622623' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622623','CMBC','民生银行','民生银行(03050001)-银联标准金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625911' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625911','CMBC','民生银行','民生银行(03050001)-银联芯片普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='377152' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('377152','CMBC','民生银行','民生银行(03050001)-民生运通双币信用卡普卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='377153' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('377153','CMBC','民生银行','民生银行(03050001)-民生运通双币信用卡金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='377158' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('377158','CMBC','民生银行','民生银行(03050001)-民生运通双币信用卡钻石卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='377155' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('377155','CMBC','民生银行','民生银行(03050001)-民生运通双币标准信用卡白金卡','CC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='625912' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625912','CMBC','民生银行','民生银行(03050001)-银联芯片金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625913' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625913','CMBC','民生银行','民生银行(03050001)-银联芯片白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625188' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625188','CMBC','民生银行','民生银行(03050001)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='406365' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('406365','GDB','广发银行','广发银行股份有限公司(03060000)-广发VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='406366' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('406366','GDB','广发银行','广发银行股份有限公司(03060000)-广发VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='428911' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('428911','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436768' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436768','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='436769' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('436769','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='487013' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('487013','GDB','广发银行','广发银行股份有限公司(03060000)-广发VISA信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491032' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491032','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491034' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491034','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491035' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491035','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491036' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491036','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491037' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491037','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='491038' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('491038','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518364' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518364','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520152' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520152','GDB','广发银行','广发银行股份有限公司(03060000)-广发万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520382' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520382','GDB','广发银行','广发银行股份有限公司(03060000)-广发万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548844' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548844','GDB','广发银行','广发银行股份有限公司(03060000)-广发信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552794' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552794','GDB','广发银行','广发银行股份有限公司(03060000)-广发万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622555' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622555','GDB','广发银行','广发银行股份有限公司(03060000)-广发银联标准金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622556' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622556','GDB','广发银行','广发银行股份有限公司(03060000)-广发银联标准普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622557' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622557','GDB','广发银行','广发银行股份有限公司(03060000)-广发银联标准真情金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622558' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622558','GDB','广发银行','广发银行股份有限公司(03060000)-广发银联标准白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622559' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622559','GDB','广发银行','广发银行股份有限公司(03060000)-广发银联标准真情普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622560' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622560','GDB','广发银行','广发银行股份有限公司(03060000)-广发真情白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528931' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528931','GDB','广发银行','广发银行股份有限公司(03060000)-广发万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='9111' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('9111','GDB','广发银行','广发银行股份有限公司(03060000)-广发理财通(银联卡)','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='558894' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('558894','GDB','广发银行','广发银行股份有限公司(03060000)-广发万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625072' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625072','GDB','广发银行','广发银行股份有限公司(03060000)-银联标准金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625071' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625071','GDB','广发银行','广发银行股份有限公司(03060000)-银联标准普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628260' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628260','GDB','广发银行','广发银行股份有限公司(03060000)-银联公务金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628259' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628259','GDB','广发银行','广发银行股份有限公司(03060000)-银联公务普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621462' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621462','GDB','广发银行','广发银行股份有限公司(03060000)-理财通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625805' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625805','GDB','广发银行','广发银行股份有限公司(03060000)-银联真情普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625806' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625806','GDB','广发银行','广发银行股份有限公司(03060000)-银联真情金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625807' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625807','GDB','广发银行','广发银行股份有限公司(03060000)-银联真情白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625808' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625808','GDB','广发银行','广发银行股份有限公司(03060000)-银联标准普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625809' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625809','GDB','广发银行','广发银行股份有限公司(03060000)-银联标准金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625810' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625810','GDB','广发银行','广发银行股份有限公司(03060000)-银联标准白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620037' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620037','GDB','广发银行','广发银行股份有限公司(03060000)-广发青年银行预付卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='6858000' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6858000','GDB','广发银行','广发银行股份有限公司(03060000)-广发理财通','CC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='6858001' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6858001','GDB','广发银行','广发银行股份有限公司(03060000)-广发理财通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='6858009' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6858009','GDB','广发银行','广发银行股份有限公司(03060000)-广发理财通','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623506' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623506','GDB','广发银行','广发银行股份有限公司(03060000)-广发财富管理多币IC卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623259' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623259','GDB','广发银行','广发银行股份有限公司(03060000)-借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622568' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622568','GDB','广发银行','广发银行股份有限公司(03060000)-广发理财通卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='412963' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('412963','SPABANK','平安银行','平安银行（借记卡）(03070010)-发展借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='415752' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('415752','SPABANK','平安银行','平安银行（借记卡）(03070010)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='415753' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('415753','SPABANK','平安银行','平安银行（借记卡）(03070010)-国际借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622538' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622538','SPABANK','平安银行','平安银行（借记卡）(03070010)-发展卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='998800' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('998800','SPABANK','平安银行','平安银行（借记卡）(03070010)-发展借记卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='412962' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('412962','SPABANK','平安银行','平安银行（借记卡）(03070010)-发展借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620010' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620010','SPABANK','平安银行','平安银行（借记卡）(03070010)-公益预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622535' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622535','SPABANK','平安银行','平安银行（借记卡）(03070010)-聚财卡金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622536' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622536','SPABANK','平安银行','平安银行（借记卡）(03070010)-聚财卡VIP金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622539' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622539','SPABANK','平安银行','平安银行（借记卡）(03070010)-聚财卡白金卡和钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622983' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622983','SPABANK','平安银行','平安银行（借记卡）(03070010)-聚财卡钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356885' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356885','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356886' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356886','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356887' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356887','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356888' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356888','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356890' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356890','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='439188' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('439188','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='439227' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('439227','CMB','招商银行','招商银行(03080000)-VISA商务信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='479229' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('479229','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='521302' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('521302','CMB','招商银行','招商银行(03080000)-世纪金花联名信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356889' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356889','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552534' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552534','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622575' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622575','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622576' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622576','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622581' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622581','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='690755' and rule_cb_card_size=15;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('690755','CMB','招商银行','招商银行(03080000)-招行一卡通','DC',now(),'Shangdu','15');

delete from rule_cb_card_bin where rule_cb_bin='95555' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('95555','CMB','招商银行','招商银行(03080000)-一卡通(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628290' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628290','CMB','招商银行','招商银行(03080000)-IC公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622578' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622578','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='402658' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('402658','CMB','招商银行','招商银行(03080000)-两地一卡通','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='410062' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('410062','CMB','招商银行','招商银行(03080000)-招行国际卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='468203' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('468203','CMB','招商银行','招商银行(03080000)-招行国际卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='479228' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('479228','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='512425' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('512425','CMB','招商银行','招商银行(03080000)-招行国际卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524011' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524011','CMB','招商银行','招商银行(03080000)-招行国际卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545619' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545619','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545620' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545620','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545621' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545621','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545623' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545623','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545947' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545947','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='545948' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('545948','CMB','招商银行','招商银行(03080000)-万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552587' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552587','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620520' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620520','CMB','招商银行','招商银行(03080000)-电子现金卡','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621286' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621286','CMB','招商银行','招商银行(03080000)-金葵花卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621483' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621483','CMB','招商银行','招商银行(03080000)-银联IC普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621485' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621485','CMB','招商银行','招商银行(03080000)-银联IC金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621486' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621486','CMB','招商银行','招商银行(03080000)-银联金葵花IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622577' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622577','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622579' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622579','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622580' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622580','CMB','招商银行','招商银行(03080000)-一卡通(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622582' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622582','CMB','招商银行','招商银行(03080000)-招商银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622588' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622588','CMB','招商银行','招商银行(03080000)-一卡通(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622598' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622598','CMB','招商银行','招商银行(03080000)-公司卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622609' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622609','CMB','招商银行','招商银行(03080000)-金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='690755' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('690755','CMB','招商银行','招商银行(03080000)-招行一卡通','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623126' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623126','CMB','招商银行','招商银行(03080000)-招商银行钻石IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623136' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623136','CMB','招商银行','招商银行(03080000)-招商银行私人银行IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623262' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623262','CMB','招商银行','招商银行(03080000)-招商银行“公司一卡通”IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621299' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621299','CMB','招商银行','招商银行香港分行(03080344)-香港一卡通','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='90592' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('90592','CIB','兴业银行','兴业银行(03090000)-兴业卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='966666' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('966666','CIB','兴业银行','兴业银行(03090000)-兴业卡(银联卡)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622909' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622909','CIB','兴业银行','兴业银行(03090000)-兴业卡(银联标准卡)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622908' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622908','CIB','兴业银行','兴业银行(03090000)-兴业自然人生理财卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='438588' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438588','CIB','兴业银行','兴业银行(03090000)-兴业智能卡(银联卡)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='438589' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438589','CIB','兴业银行','兴业银行(03090000)-兴业智能卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='461982' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('461982','CIB','兴业银行','兴业银行(03090010)-visa标准双币个人普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='486493' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('486493','CIB','兴业银行','兴业银行(03090010)-VISA商务普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='486494' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('486494','CIB','兴业银行','兴业银行(03090010)-VISA商务金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='486861' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('486861','CIB','兴业银行','兴业银行(03090010)-VISA运动白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='523036' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('523036','CIB','兴业银行','兴业银行(03090010)-万事达信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='451289' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('451289','CIB','兴业银行','兴业银行(03090010)-VISA信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='527414' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('527414','CIB','兴业银行','兴业银行(03090010)-加菲猫信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528057' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528057','CIB','兴业银行','兴业银行(03090010)-个人白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622901' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622901','CIB','兴业银行','兴业银行(03090010)-银联信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622902' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622902','CIB','兴业银行','兴业银行(03090010)-银联信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622922' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622922','CIB','兴业银行','兴业银行(03090010)-银联白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628212' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628212','CIB','兴业银行','兴业银行(03090010)-银联标准公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='451290' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('451290','CIB','兴业银行','兴业银行(03090010)-VISA信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524070' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524070','CIB','兴业银行','兴业银行(03090010)-万事达信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625084' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625084','CIB','兴业银行','兴业银行(03090010)-银联标准贷记普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625085' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625085','CIB','兴业银行','兴业银行(03090010)-银联标准贷记金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625086' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625086','CIB','兴业银行','兴业银行(03090010)-银联标准贷记金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625087' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625087','CIB','兴业银行','兴业银行(03090010)-银联标准贷记金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548738' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548738','CIB','兴业银行','兴业银行(03090010)-兴业信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='549633' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('549633','CIB','兴业银行','兴业银行(03090010)-兴业信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='552398' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('552398','CIB','兴业银行','兴业银行(03090010)-兴业信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625082' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625082','CIB','兴业银行','兴业银行(03090010)-银联标准贷记普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625083' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625083','CIB','兴业银行','兴业银行(03090010)-银联标准贷记普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625960' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625960','CIB','兴业银行','兴业银行(03090010)-兴业芯片普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625961' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625961','CIB','兴业银行','兴业银行(03090010)-兴业芯片金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625962' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625962','CIB','兴业银行','兴业银行(03090010)-兴业芯片白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625963' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625963','CIB','兴业银行','兴业银行(03090010)-兴业芯片钻石卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625353' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625353','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625356' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625356','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622571' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622571','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622572' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622572','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622573' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622573','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622591' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622591','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622592' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622592','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622593' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622593','CIB','兴业银行','兴业银行(03090010)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356851' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356851','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发JCB金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356852' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356852','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发JCB白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404738' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404738','SPDB','浦东发展银行','浦东发展银行(03100000)-信用卡VISA普通','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='404739' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('404739','SPDB','浦东发展银行','浦东发展银行(03100000)-信用卡VISA金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='456418' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('456418','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发银行VISA年青卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='498451' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('498451','SPDB','浦东发展银行','浦东发展银行(03100000)-VISA白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='515672' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('515672','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发万事达白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356850' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356850','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发JCB普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='517650' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('517650','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发万事达金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='525998' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('525998','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发万事达普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622177' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622177','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发单币卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622277' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622277','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发银联单币麦兜普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622516' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622516','SPDB','浦东发展银行','浦东发展银行(03100000)-东方轻松理财卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622517' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622517','SPDB','浦东发展银行','浦东发展银行(03100000)-东方-轻松理财卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622518' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622518','SPDB','浦东发展银行','浦东发展银行(03100000)-东方轻松理财卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622520' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622520','SPDB','浦东发展银行','浦东发展银行(03100000)-东方轻松理财智业金卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622521' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622521','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622522' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622522','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622523' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622523','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628222' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628222','SPDB','浦东发展银行','浦东发展银行(03100000)-公务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84301' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84301','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84336' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84336','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84373' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84373','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628221' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628221','SPDB','浦东发展银行','浦东发展银行(03100000)-公务卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84390' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84390','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='87000' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('87000','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='87010' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('87010','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='87030' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('87030','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='87040' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('87040','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84380' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84380','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='984301' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('984301','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='984303' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('984303','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84361' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84361','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='87050' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('87050','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622176' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622176','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发单币卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622276' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622276','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发联名信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622228' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622228','SPDB','浦东发展银行','浦东发展银行(03100000)-浦发银联白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621351' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621351','SPDB','浦东发展银行','浦东发展银行(03100000)-移动联名卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621390' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621390','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财消贷易卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621792' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621792','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财普卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625957' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625957','SPDB','浦东发展银行','浦东发展银行(03100000)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625958' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625958','SPDB','浦东发展银行','浦东发展银行(03100000)-贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621791' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621791','SPDB','浦东发展银行','浦东发展银行(03100000)-东方借记卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84342' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84342','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620530' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620530','SPDB','浦东发展银行','浦东发展银行(03100000)-电子现金卡（IC卡）','PC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='625993' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625993','SPDB','浦东发展银行','浦东发展银行(03100000)-移动浦发联名卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622519' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622519','SPDB','浦东发展银行','浦东发展银行(03100000)-东方-标准准贷记卡','SCC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621793' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621793','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财金卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621795' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621795','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财白金卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621796' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621796','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财钻石卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622500' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622500','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623250' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623250','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财米卡（复合卡）','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621352' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621352','SPDB','浦东发展银行','浦东发展银行(03100000)-轻松理财普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='84385' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('84385','SPDB','浦东发展银行','浦东发展银行(03100000)-东方卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623269' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623269','SPABANK','平安银行','平安银行(03180000)---','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623183' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623183','SHBANK','上海银行','上海银行(04010000)-慧通钻石卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='623185' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623185','SHBANK','上海银行','上海银行(04010000)-慧通金卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621005' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621005','SHBANK','上海银行','上海银行(04010000)-私人银行卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622172' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622172','SHBANK','上海银行','上海银行(04012900)-综合保险卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622985' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622985','SHBANK','上海银行','上海银行(04012900)-申卡社保副卡(有折)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622987' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622987','SHBANK','上海银行','上海银行(04012900)-申卡社保副卡(无折)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622267' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622267','SHBANK','上海银行','上海银行(04012900)-白金IC借记卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622278' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622278','SHBANK','上海银行','上海银行(04012900)-慧通白金卡(配折)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622279' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622279','SHBANK','上海银行','上海银行(04012900)-慧通白金卡(不配折)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622468' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622468','SHBANK','上海银行','上海银行(04012900)-申卡(银联卡)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='622892' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622892','SHBANK','上海银行','上海银行(04012900)-申卡借记卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='940021' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('940021','SHBANK','上海银行','上海银行(04012900)-银联申卡(银联卡)','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621050' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621050','SHBANK','上海银行','上海银行(04012900)-单位借记卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='620522' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620522','SHBANK','上海银行','上海银行(04012900)-首发纪念版IC卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='621243' and rule_cb_card_size=18;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621243','SHBANK','上海银行','上海银行(04012900)-单位卡','DC',now(),'Shangdu','18');

delete from rule_cb_card_bin where rule_cb_bin='356827' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356827','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356828' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356828','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356830' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356830','SHBANK','上海银行','上海银行(04012902)-J分期付款信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='402673' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('402673','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='402674' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('402674','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='438600' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('438600','SHBANK','上海银行','上海银行(04012902)-上海申卡IC','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='486466' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('486466','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='519498' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('519498','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡普通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='520131' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('520131','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524031' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524031','SHBANK','上海银行','上海银行(04012902)-万事达白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='548838' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('548838','SHBANK','上海银行','上海银行(04012902)-万事达星运卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622148' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622148','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622149' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622149','SHBANK','上海银行','上海银行(04012902)-申卡贷记卡普通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622268' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622268','SHBANK','上海银行','上海银行(04012902)-安融卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356829' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356829','SHBANK','上海银行','上海银行(04012902)-分期付款信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622300' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622300','SHBANK','上海银行','上海银行(04012902)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628230' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628230','SHBANK','上海银行','上海银行(04012902)-个人公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622269' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622269','SHBANK','上海银行','上海银行(04012902)-安融卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625099' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625099','SHBANK','上海银行','上海银行(04012902)-上海银行银联白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625953' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625953','SHBANK','上海银行','上海银行(04012902)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625350' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625350','SHBANK','上海银行','上海银行(04012902)-中国旅游卡（IC普卡）','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625351' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625351','SHBANK','上海银行','上海银行(04012902)-中国旅游卡（IC金卡）','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625352' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625352','SHBANK','上海银行','上海银行(04012902)-中国旅游卡（IC白金卡）','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='519961' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('519961','SHBANK','上海银行','上海银行(04012902)-万事达钻石卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625839' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625839','SHBANK','上海银行','上海银行(04012902)-淘宝IC普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625180' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625180','SHBANK','上海银行','上海银行(04012902)-钻石卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='421317' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('421317','BJBANK','北京银行','北京银行(04031000)-京卡借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='602969' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('602969','BJBANK','北京银行','北京银行(04031000)-京卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621030' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621030','BJBANK','北京银行','北京银行(04031000)-京卡借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621420' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621420','BJBANK','北京银行','北京银行(04031000)-京卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621468' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621468','BJBANK','北京银行','北京银行(04031000)-京卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623111' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623111','BJBANK','北京银行','北京银行(04031000)-借记IC卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='422160' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('422160','BJBANK','北京银行','北京银行(04031000)-京卡贵宾金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='422161' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('422161','BJBANK','北京银行','北京银行(04031000)-京卡贵宾白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623561' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623561','BJBANK','北京银行','北京银行(04031000)-北京银行借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623562' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623562','BJBANK','北京银行','北京银行(04031000)-北京银行借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621626' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621626','SPABANK','平安银行','平安银行(04100000)-新磁条借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623058' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623058','SPABANK','平安银行','平安银行(04100000)-平安银行IC借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='602907' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('602907','SPABANK','平安银行','平安银行(04105840)-万事顺卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622986' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622986','SPABANK','平安银行','平安银行(04105840)-平安银行借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622989' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622989','SPABANK','平安银行','平安银行(04105840)-平安银行借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622298' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622298','SPABANK','平安银行','平安银行(04105840)-万事顺借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='531659' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('531659','SPABANK','平安银行','平安银行股份有限公司(05105840)-白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622157' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622157','SPABANK','平安银行','平安银行股份有限公司(05105840)-白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='435744' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('435744','SPABANK','平安银行','平安银行股份有限公司(05105840)-沃尔玛百分卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='435745' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('435745','SPABANK','平安银行','平安银行股份有限公司(05105840)-沃尔玛百分卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='483536' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('483536','SPABANK','平安银行','平安银行股份有限公司(05105840)-VISA白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622525' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622525','SPABANK','平安银行','平安银行股份有限公司(05105840)-人民币信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622526' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622526','SPABANK','平安银行','平安银行股份有限公司(05105840)-人民币信用卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='998801' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('998801','SPABANK','平安银行','平安银行股份有限公司(05105840)-发展信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='998802' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('998802','SPABANK','平安银行','平安银行股份有限公司(05105840)-发展信用卡(银联卡)','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528020' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528020','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622155' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622155','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622156' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622156','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='526855' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('526855','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安银行信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356869' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356869','SPABANK','平安银行','平安银行股份有限公司(05105840)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356868' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356868','SPABANK','平安银行','平安银行股份有限公司(05105840)-信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625360' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625360','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安中国旅游信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625361' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625361','SPABANK','平安银行','平安银行股份有限公司(05105840)-平安中国旅游白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628296' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628296','SPABANK','平安银行','平安银行股份有限公司(05105840)-公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625825' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625825','SPABANK','平安银行','平安银行股份有限公司(05105840)-白金IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625823' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625823','SPABANK','平安银行','平安银行股份有限公司(05105840)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='627069' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627069','SPABANK','平安银行','平安银行股份有限公司(06105840)-一账通借贷合一钻石卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='627066' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627066','SPABANK','平安银行','平安银行股份有限公司(06105840)-一账通借贷合一卡普卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='627067' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627067','SPABANK','平安银行','平安银行股份有限公司(06105840)-一账通借贷合一卡金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='627068' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('627068','SPABANK','平安银行','平安银行股份有限公司(06105840)-一账通借贷合一白金卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622381' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622381','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-人民币信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622675' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622675','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-银联卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622676' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622676','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-银联卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622677' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622677','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-银联卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622382' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622382','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-人民币卡(银联卡)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621487' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621487','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621083' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621083','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-建行陆港通龙卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='624329' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624329','CCB','建设银行','中国建设银行亚洲股份有限公司(25070344)-CCBA Diamond Dual','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621741' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621741','BOC','中国银行','中国银行（香港）(25190344)-接触式晶片借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623040' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623040','BOC','中国银行','中国银行（香港）(25190344)-接触式银联双币预制晶片借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620202' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620202','BOC','中国银行','中国银行（香港）(25190344)-中国银行银联预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620203' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620203','BOC','中国银行','中国银行（香港）(25190344)-中国银行银联预付卡','PC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621782' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621782','BOC','中国银行','中国银行（香港）(25190344)-中银纯电子现金双币卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='623309' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623309','BOC','中国银行','中国银行（香港）(25190344)-中国银行银联公司借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='621084' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621084','CCB','建设银行','中国建设银行澳门分行(25270446)-扣款卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='623350' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('623350','CCB','建设银行','中国建设银行澳门分行(25270446)-借记卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='624412' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624412','CCB','建设银行','中国建设银行澳门分行(25270446)-CCB Macau Platinum Credit Card','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='620107' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('620107','CCB','建设银行','中国建设银行（亚洲）(25330344)-预付卡','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625017' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625017','ICBC','工商银行','中国工商银行（澳门）(26470446)-普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625018' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625018','ICBC','工商银行','中国工商银行（澳门）(26470446)-金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625019' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625019','ICBC','工商银行','中国工商银行（澳门）(26470446)-白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622346' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622346','BOC','中国银行','中国银行香港有限公司(47980344)-人民币信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622347' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622347','BOC','中国银行','中国银行香港有限公司(47980344)-信用卡普通卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622348' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622348','BOC','中国银行','中国银行香港有限公司(47980344)-中银卡(人民币)','DC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='621041' and rule_cb_card_size=19;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('621041','BOC','中国银行','中国银行(香港)(47980344)-银联港币借记卡','DC',now(),'Shangdu','19');

delete from rule_cb_card_bin where rule_cb_bin='622812' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622812','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-银联标准白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622810' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622810','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-银联标准贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622811' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622811','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-银联标准贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628310' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628310','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-银联标准公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625919' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625919','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-上海购物信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625368' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625368','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625367' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625367','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-中国旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='518905' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('518905','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-全币种信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622835' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622835','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-大白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625603' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625603','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-商务卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625605' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625605','PSBC','邮储银行','中国邮政储蓄银行信用卡中心(61000000)-商务卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622657' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622657','CEB','光大银行','光大银行(63030000)-存贷合一白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622685' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622685','CEB','光大银行','光大银行(63030000)-存贷合一卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622659' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622659','CEB','光大银行','光大银行(63030000)-理财信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622687' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622687','CEB','光大银行','中国光大银行(63030000)-存贷合一钻石卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625981' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625981','CEB','光大银行','中国光大银行(63030000)-存贷合一IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625979' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625979','CEB','光大银行','中国光大银行(63030000)-存贷合一IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356839' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356839','CEB','光大银行','中国光大银行(63030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='356840' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('356840','CEB','光大银行','中国光大银行(63030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='406252' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('406252','CEB','光大银行','中国光大银行(63030000)-阳光信用卡(银联','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='406254' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('406254','CEB','光大银行','中国光大银行(63030000)-阳光信用卡(银联','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='425862' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('425862','CEB','光大银行','中国光大银行(63030000)-阳光商旅信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='481699' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('481699','CEB','光大银行','中国光大银行(63030000)-阳光白金信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='524090' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('524090','CEB','光大银行','中国光大银行(63030000)-安邦俱乐部信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='543159' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('543159','CEB','光大银行','中国光大银行(63030000)-足球锦标赛纪念卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622161' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622161','CEB','光大银行','中国光大银行(63030000)-光大银行联名公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622570' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622570','CEB','光大银行','中国光大银行(63030000)-积分卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622650' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622650','CEB','光大银行','中国光大银行(63030000)-炎黄卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622655' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622655','CEB','光大银行','中国光大银行(63030000)-炎黄卡白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622658' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622658','CEB','光大银行','中国光大银行(63030000)-炎黄卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625975' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625975','CEB','光大银行','中国光大银行(63030000)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625977' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625977','CEB','光大银行','中国光大银行(63030000)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628201' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628201','CEB','光大银行','中国光大银行(63030000)-银联公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628202' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628202','CEB','光大银行','中国光大银行(63030000)-银联公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625976' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625976','CEB','光大银行','中国光大银行(63030000)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625339' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625339','CEB','光大银行','中国光大银行(63030000)-银联贷记IC旅游卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622801' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622801','CEB','光大银行','中国光大银行(63030000)-贷记IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625978' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625978','CEB','光大银行','中国光大银行(63030000)-存贷合一IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625980' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625980','CEB','光大银行','中国光大银行(63030000)-存贷合一IC卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625974' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625974','CEB','光大银行','中国光大银行(63030000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='523959' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('523959','HXBANK','华夏银行','华夏银行(63040000)-华夏万事达信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528709' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528709','HXBANK','华夏银行','华夏银行(63040000)-万事达信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='539867' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('539867','HXBANK','华夏银行','华夏银行(63040000)-万事达普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='539868' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('539868','HXBANK','华夏银行','华夏银行(63040000)-万事达普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622637' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622637','HXBANK','华夏银行','华夏银行(63040000)-华夏信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622638' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622638','HXBANK','华夏银行','华夏银行(63040000)-华夏白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628318' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628318','HXBANK','华夏银行','华夏银行(63040000)-华夏公务信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='528708' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('528708','HXBANK','华夏银行','华夏银行(63040000)-万事达信用卡金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622636' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622636','HXBANK','华夏银行','华夏银行(63040000)-华夏信用卡普卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625967' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625967','HXBANK','华夏银行','华夏银行(63040000)-华夏标准金融IC信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625968' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625968','HXBANK','华夏银行','华夏银行(63040000)-华夏标准金融IC信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625969' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625969','HXBANK','华夏银行','华夏银行(63040000)-华夏标准金融IC信用卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='522001' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('522001','BJBANK','北京银行','北京银行(64031000)-万事达双币金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622163' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622163','BJBANK','北京银行','北京银行(64031000)-银联标准贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622853' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622853','BJBANK','北京银行','北京银行(64031000)-银联标准贷记卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='628203' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('628203','BJBANK','北京银行','北京银行(64031000)-银联标准公务卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622851' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622851','BJBANK','北京银行','北京银行(64031000)-北京银行中荷人寿联名卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622852' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622852','BJBANK','北京银行','北京银行(64031000)-尊尚白金卡','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='625816' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('625816','BJBANK','北京银行','北京银行(64031000)---','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='622790' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('622790','BOC','中国银行','中行新加坡分行(99900702)-Great Wall Platinum','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227890' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227890','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227891' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227891','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227892' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227892','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227893' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227893','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227894' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227894','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227895' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227895','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227896' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227896','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227897' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227897','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227899' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227899','BOC','中国银行','中行新加坡分行(99900702)-DUAL CURRENCY TRAVEL CARD','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='624405' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('624405','BOC','中国银行','中行新加坡分行(99900702)-Dual Currency Debit Card','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='6227898' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('6227898','BOC','中国银行','中行新加坡分行(99900702)-GREAT WALL PLATINUM','CC',now(),'Shangdu','16');

delete from rule_cb_card_bin where rule_cb_bin='62844802' and rule_cb_card_size=16;
insert into rule_cb_card_bin(rule_cb_bin,rule_cb_bank_code,rule_cb_bank_name,rule_cb_card_name,rule_cb_card_type,rule_cb_create_date,rule_cb_create_user_id, rule_cb_card_size) values('62844802','BOC','中国银行','中国银行(01040000)-财政公务公司清偿IC卡','CC',now(),'Shangdu','16');

