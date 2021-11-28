package com.caesar.boot.base.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caesar.boot.base.modules.sys.mapper.SysRoleMenuRelationMapper;
import com.caesar.boot.base.modules.sys.model.SysRoleMenuRelation;
import com.caesar.boot.base.modules.sys.service.SysRoleMenuRelationService;
import org.springframework.stereotype.Service;

/**
 * 角色菜单关系管理Service实现类
 *
 * @author caesar
 * @date 2021/11/21
 */
@Service
public class SysRoleMenuRelationServiceImpl extends ServiceImpl<SysRoleMenuRelationMapper, SysRoleMenuRelation> implements SysRoleMenuRelationService {
}
