
package com.zy.web.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.database.starter.base.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_user_mail")
public class UserMailDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;
}
