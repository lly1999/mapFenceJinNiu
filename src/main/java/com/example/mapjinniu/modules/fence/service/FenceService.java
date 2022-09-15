package com.example.mapjinniu.modules.fence.service;

import com.example.mapjinniu.modules.fence.model.Fence;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@Service
public interface FenceService extends IService<Fence> {

    int deleteFence(int id);
}
