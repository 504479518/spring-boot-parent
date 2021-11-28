package com.caesar.boot.base.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caesar.boot.base.common.api.CommonPage;
import com.caesar.boot.base.common.api.CommonResult;
import com.caesar.boot.base.modules.sys.model.SysMenu;
import com.caesar.boot.base.modules.sys.model.SysResource;
import com.caesar.boot.base.modules.sys.model.SysRole;
import com.caesar.boot.base.modules.sys.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台用户角色管理
 *
 * @author caesar
 * @date 2021/11/30
 */
@RestController
@Api(tags = "SysRoleController", value = "后台用户角色管理")
@RequestMapping("/role")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;

    @ApiOperation("添加角色")
    @PostMapping(value = "/create")
    public CommonResult<Boolean> create(@RequestBody SysRole role) {
        boolean success = roleService.create(role);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改角色")
    @PostMapping(value = "/update/{id}")
    public CommonResult<Boolean> update(@PathVariable Long id, @RequestBody SysRole role) {
        role.setId(id);
        boolean success = roleService.updateById(role);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除角色")
    @PostMapping(value = "/delete")
    public CommonResult<Boolean> delete(@RequestParam("ids") List<Long> ids) {
        boolean success = roleService.delete(ids);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }


    @ApiOperation("获取所有角色")
    @GetMapping(value = "/listAll")
    public CommonResult<List<SysRole>> listAll() {
        List<SysRole> roleList = roleService.list();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SysRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SysRole> roleList = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(roleList));
    }

    @ApiOperation("修改角色状态")
    @PostMapping(value = "/updateStatus/{id}")
    public CommonResult<Boolean> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setStatus(status);
        boolean success = roleService.updateById(sysRole);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取角色相关菜单")
    @GetMapping(value = "/listMenu/{roleId}")
    public CommonResult<List<SysMenu>> listMenu(@PathVariable Long roleId) {
        List<SysMenu> roleList = roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("获取角色相关资源")
    @GetMapping(value = "/listResource/{roleId}")
    public CommonResult<List<SysResource>> listResource(@PathVariable Long roleId) {
        List<SysResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给角色分配菜单")
    @PostMapping(value = "/allocMenu")
    public CommonResult<Integer> allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("给角色分配资源")
    @PostMapping(value = "/allocResource")
    public CommonResult<Integer> allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }

}
