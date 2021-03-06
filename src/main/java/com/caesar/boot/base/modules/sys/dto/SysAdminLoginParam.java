package com.caesar.boot.base.modules.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 *
 * @author caesar
 * @date 2021/11/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysAdminLoginParam {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
