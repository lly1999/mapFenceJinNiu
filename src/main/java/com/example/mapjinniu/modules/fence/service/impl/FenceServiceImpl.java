package com.example.mapjinniu.modules.fence.service.impl;

import com.example.mapjinniu.modules.fence.model.Fence;
import com.example.mapjinniu.modules.fence.mapper.FenceMapper;
import com.example.mapjinniu.modules.fence.service.FenceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@Service
public class FenceServiceImpl extends ServiceImpl<FenceMapper, Fence> implements FenceService {

    FenceMapper fenceMapper;




    @Override
    public int deleteFence(int id) {
        return 0;
    }


}
