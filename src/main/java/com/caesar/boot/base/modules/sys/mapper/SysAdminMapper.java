package com.caesar.boot.base.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caesar.boot.base.modules.sys.model.SysAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author caesar
 * @since 2021-11-21
 */
@Repository
public interface SysAdminMapper extends BaseMapper<SysAdmin> {

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

}
