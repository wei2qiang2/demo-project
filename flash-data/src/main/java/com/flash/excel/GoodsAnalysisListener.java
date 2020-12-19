package com.flash.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.flash.dto.GoodsDescriptionDTO;
import com.flash.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/19 13:25
 * @Version V1.0
 **/
@Slf4j
public class GoodsAnalysisListener extends AnalysisEventListener<GoodsDescriptionDTO> {

    private static final int BATCH_COUNT = 1000;

    List<GoodsDescriptionDTO> list = new ArrayList<GoodsDescriptionDTO>();

    private IGoodsService goodsService;

    public GoodsAnalysisListener(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public void invoke(GoodsDescriptionDTO goodsDescriptionDTO, AnalysisContext analysisContext) {
        list.add(goodsDescriptionDTO);
        if (list.size() >= BATCH_COUNT) {
            goodsService.saveGoodsDescription(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.debug("最后一次保存的数据：" + list.size());
        goodsService.saveGoodsDescription(list);
    }
}
