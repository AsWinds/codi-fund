package com.codi.fcloud.ufx.constant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 职业类型
 *
 * @author shi.pengyan
 * @date 2017-06-19 13:56
 */
@ToString
public enum JobType {
    GOVERMENT("1", "政府部门"), Educational("2", "教科文"), Finance("3", "金融");
    //4商贸
    //5房地产
    //6制造业
    //7自由职业
    //8其它
    //09事业单位
    //10国有企业
    //11公务员
    //12专业技术人员
    //13办事人员
    //14军人
    //15商业和服务类人员
    //16生产、运输设备操作人员
    //18农、林、牧、渔、水利业生产人员
    //98其他（恒天明泽单用）

    // 成员变量
    @Setter
    @Getter
    private String index;
    @Setter
    @Getter
    private String label;

    // 构造方法
    JobType(String index, String label) {
        this.index = index;
        this.label = label;
    }

    /**
     * 通过值获取名称
     *
     * @param index
     * @return
     */
    public static String getLabelByIndex(String index) {
        for (JobType jobType : JobType.values()) {
            if (jobType.getIndex().equalsIgnoreCase(index)) {
                return jobType.label;
            }
        }
        return null;
    }

    /**
     * 通过label获取值
     *
     * @param label
     * @return
     */
    public static String getIndexByLabel(String label) {
        for (JobType jobType : JobType.values()) {
            if (jobType.getLabel().equalsIgnoreCase(label)) {
                return jobType.index;
            }
        }
        return null;
    }

}
