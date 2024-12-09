

package com.zy.web.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.database.base.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_reuse")
public final class UserReuseDO extends BaseDO {

    /**
     * 用户名
     */
    private String username;
}
