package com.caesar.boot.base.modules.sys.controller;

import com.caesar.boot.base.common.api.CommonResult;
import com.caesar.boot.base.modules.sys.model.SysResourceCategory;
import com.caesar.boot.base.modules.sys.service.SysResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 *
 * @author caesar
 * @date 2021/11/5
 */
@RestController
@Api(tags = "SysResourceCategoryController", value = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class SysResourceCategoryController {
    @Autowired
    private SysResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @GetMapping(value = "/listAll")
    public CommonResult<List<SysResourceCategory>> listAll() {
        List<SysResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("添加后台资源分类")
    @PostMapping(value = "/create")
    public CommonResult<Boolean> create(@RequestBody SysResourceCategory sysResourceCategory) {
        boolean success = resourceCategoryService.create(sysResourceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改后台资源分类")
    @PostMapping(value = "/update/{id}")
    public CommonResult<Boolean> update(@PathVariable Long id,
                                        @RequestBody SysResourceCategory sysResourceCategory) {
        sysResourceCategory.setId(id);
        boolean success = resourceCategoryService.updateById(sysResourceCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID删除后台资源")
    @DeleteMapping(value = "/delete/{id}")
    public CommonResult<Boolean> delete(@PathVariable Long id) {
        boolean success = resourceCategoryService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}
