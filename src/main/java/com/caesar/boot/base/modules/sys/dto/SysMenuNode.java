package com.caesar.boot.base.modules.sys.dto;

import com.caesar.boot.base.modules.sys.model.SysMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 *
 * @author caesar
 * @date 2021/11/4
 */
@Getter
@Setter
public class SysMenuNode extends SysMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<SysMenuNode> children;
}
