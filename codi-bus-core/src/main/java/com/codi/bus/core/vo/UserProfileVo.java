package com.codi.bus.core.vo;

import com.codi.base.domain.BaseDomain;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户扩展资料
 *
 * @author shi.pengyan
 * @date 2017-06-20 9:29
 */
@Data
@Accessors(chain = true)
public class UserProfileVo extends BaseDomain {

    @NotBlank
    @Length(max = 100)
    private String addressCode; //省市区编码
    @NotBlank
    @Length(max = 300)
    private String userAddress;

    @NotBlank
    @Length(max = 20)
    private String occupationCode;// 职业编码
    @NotBlank
    @Length(max = 100)
    private String userOccupation;

    private Boolean selfSustain = true;// 是否是本人持有

    @NotBlank
    @Length(min = 1, max = 25)
    private String beneficiary;// 受益人

    @NotBlank
    @Length(min = 1, max = 25)
    private String owner;// 控制人
}
