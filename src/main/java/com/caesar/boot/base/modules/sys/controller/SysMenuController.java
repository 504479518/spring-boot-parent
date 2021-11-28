package com.caesar.boot.base.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caesar.boot.base.common.api.CommonPage;
import com.caesar.boot.base.common.api.CommonResult;
import com.caesar.boot.base.modules.sys.dto.SysMenuNode;
import com.caesar.boot.base.modules.sys.model.SysMenu;
import com.caesar.boot.base.modules.sys.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台菜单管理Controller
 *
 * @author caesar
 * @date 2021/11/4
 */
@RestController
@Api(tags = "SysMenuController", value = "后台菜单管理")
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @ApiOperation("添加后台菜单")
    @PostMapping(value = "/create")
    public CommonResult<Boolean> create(@RequestBody SysMenu sysMenu) {
        boolean success = menuService.create(sysMenu);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台菜单")
    @PostMapping(value = "/update/{id}")
    public CommonResult<Boolean> update(@PathVariable Long id,
                                        @RequestBody SysMenu sysMenu) {
        boolean success = menuService.update(id, sysMenu);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取菜单详情")
    @GetMapping(value = "/{id}")
    public CommonResult<SysMenu> getItem(@PathVariable Long id) {
        SysMenu sysMenu = menuService.getById(id);
        return CommonResult.success(sysMenu);
    }

    @ApiOperation("根据ID删除后台菜单")
    @DeleteMapping(value = "/delete/{id}")
    public CommonResult<Boolean> delete(@PathVariable Long id) {
        boolean success = menuService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询后台菜单")
    @GetMapping(value = "/list/{parentId}")
    public CommonResult<CommonPage<SysMenu>> list(@PathVariable Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SysMenu> menuList = menuService.list(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(menuList));
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @GetMapping(value = "/treeList")
    public CommonResult<List<SysMenuNode>> treeList() {
        List<SysMenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }

    @ApiOperation("修改菜单显示状态")
    @PostMapping(value = "/updateHidden/{id}")
    public CommonResult<Boolean> updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        boolean success = menuService.updateHidden(id, hidden);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
