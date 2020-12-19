package com.flash;

import com.alibaba.excel.EasyExcel;
import com.flash.dto.GoodsDescriptionDTO;
import com.flash.entity.Goods;
import com.flash.excel.GoodsAnalysisListener;
import com.flash.mapper.GoodsMapper;
import com.flash.service.IGoodsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FlashDataApplication.class)
class FlashDataApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private IGoodsService goodsService;

    @Test
    void contextLoads() {
        List<Goods> goods = goodsMapper.selectList(null);
        if (!CollectionUtils.isEmpty(goods)) {
            goods.parallelStream().forEach(good -> {
                String goodsDetails = good.getGoodsDetail();
                System.err.println(goodsDetails);
            });
        }
    }

    @Test
    public void readExcel() {
        String file = "C://description.xlsx";
        File file1 = new File(file);
        EasyExcel.read(new File(file), GoodsDescriptionDTO.class, new GoodsAnalysisListener(goodsService))
        .sheet().doRead();
    }

}
