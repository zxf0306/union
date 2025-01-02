
package com.zy.web.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.database.starter.base.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_deletion")
public class UserDeletionDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号
     */
    private String idCard;
}
