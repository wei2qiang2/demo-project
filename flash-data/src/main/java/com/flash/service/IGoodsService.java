package com.flash.service;

import com.flash.dto.GoodsDescriptionDTO;
import com.flash.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * SPU表 服务类
 * </p>
 *
 * @author weiqiang
 * @since 2020-12-19
 */
public interface IGoodsService extends IService<Goods> {

    void saveGoodsDescription(List<GoodsDescriptionDTO> list);
}
