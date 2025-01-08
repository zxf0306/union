

package com.zy.web.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.database.starter.base.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@TableName("t_passenger")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 优惠类型
     */
    private Integer discountType;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 添加日期
     */
    private Date createDate;

    /**
     * 审核状态
     */
    private Integer verifyStatus;
}
