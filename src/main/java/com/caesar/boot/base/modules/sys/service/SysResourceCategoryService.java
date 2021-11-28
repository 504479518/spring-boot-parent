package com.caesar.boot.base.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.caesar.boot.base.modules.sys.model.SysResourceCategory;

import java.util.List;

/**
 * 后台资源分类管理Service
 *
 * @author caesar
 * @date 2021/11/5
 */
public interface SysResourceCategoryService extends IService<SysResourceCategory> {

    /**
     * 获取所有资源分类
     */
    List<SysResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    boolean create(SysResourceCategory sysResourceCategory);
}
