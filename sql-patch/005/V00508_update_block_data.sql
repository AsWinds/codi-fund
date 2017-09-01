-- 更新首条推荐基金
UPDATE oc_operation_content
SET `oc_title` = '消费驱动',
 `oc_sub_title` = '深度挖掘消费行业',
 `oc_description` = '交银施罗德消费新驱动股票',
 `oc_tag` = '指数',
 `oc_style` = '#3890fa',
 `oc_block_name` = '当前热点',
 `oc_priority` = 10,
 `oc_indicant` = '6',
 `oc_indicant_description` = '近半年收益',
 `oc_url` = '',
 `oc_status` = '0',
 `oc_extra_map` = '{\'fundCode\':\'519714\'}',
 `oc_last_updated_time` = NOW(),
 oc_indicant_type = '6M',
 oc_version = '1'
WHERE
	oc_id = 1;