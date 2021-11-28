package com.caesar.boot.base.modules.sys.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 后台用户和角色关系表
 * </p>
 *
 * @author caesar
 * @since 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_admin_role_relation")
@ApiModel(value = "SysAdminRoleRelation对象", description = "后台用户和角色关系表")
public class SysAdminRoleRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long adminId;

    private Long roleId;


}
