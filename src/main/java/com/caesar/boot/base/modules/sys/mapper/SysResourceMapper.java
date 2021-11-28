package com.caesar.boot.base.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caesar.boot.base.modules.sys.model.SysResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台资源表 Mapper 接口
 * </p>
 *
 * @author caesar
 * @since 2021-11-21
 */
@Repository
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 获取用户所有可访问资源
     */
    List<SysResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取资源
     */
    List<SysResource> getResourceListByRoleId(@Param("roleId") Long roleId);

}
