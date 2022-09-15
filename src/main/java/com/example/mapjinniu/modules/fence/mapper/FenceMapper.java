package com.example.mapjinniu.modules.fence.mapper;

import com.example.mapjinniu.modules.fence.model.Fence;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@Mapper
public interface FenceMapper extends BaseMapper<Fence> {
     int insertFence(Fence fence);
     int deleteByPrimaryKey(int id);
}
