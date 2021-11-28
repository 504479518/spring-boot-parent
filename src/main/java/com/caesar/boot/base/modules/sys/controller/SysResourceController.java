package com.caesar.boot.base.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caesar.boot.base.common.api.CommonPage;
import com.caesar.boot.base.common.api.CommonResult;
import com.caesar.boot.base.modules.sys.model.SysResource;
import com.caesar.boot.base.modules.sys.service.SysResourceService;
import com.caesar.boot.base.security.component.DynamicSecurityMetadataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源管理Controller
 * Created by caesar on 2021/11/4.
 */
@RestController
@Api(tags = "SysResourceController", value = "后台资源管理")
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private SysResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("添加后台资源")
    @PostMapping(value = "/create")
    public CommonResult<Boolean> create(@RequestBody SysResource sysResource) {
        boolean success = resourceService.create(sysResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源")
    @PostMapping(value = "/update/{id}")
    public CommonResult<Boolean> update(@PathVariable Long id,
                                        @RequestBody SysResource sysResource) {
        boolean success = resourceService.update(id, sysResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取资源详情")
    @GetMapping(value = "/{id}")
    public CommonResult<SysResource> getItem(@PathVariable Long id) {
        SysResource sysResource = resourceService.getById(id);
        return CommonResult.success(sysResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @DeleteMapping(value = "/delete/{id}")
    public CommonResult<Boolean> delete(@PathVariable Long id) {
        boolean success = resourceService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页模糊查询后台资源")
    @GetMapping(value = "/list")
    public CommonResult<CommonPage<SysResource>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<SysResource> resourceList = resourceService.list(categoryId, nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @GetMapping(value = "/listAll")
    public CommonResult<List<SysResource>> listAll() {
        List<SysResource> resourceList = resourceService.list();
        return CommonResult.success(resourceList);
    }
}
