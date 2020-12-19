package com.flash.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.flash.dto.GoodsDescriptionDTO;
import com.flash.entity.Goods;
import com.flash.mapper.GoodsMapper;
import com.flash.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * SPU表 服务实现类
 * </p>
 *
 * @author weiqiang
 * @since 2020-12-19
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    private static List<String> spuNo = new ArrayList<>();

    private static final String DESCRIPTION_KEY = "Description";

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void saveGoodsDescription(List<GoodsDescriptionDTO> list) {
        Goods entity = new Goods();
        entity.setStoreId(1234579081L);
        Wrapper<Goods> goodsWrapper = new QueryWrapper<>(entity);
        List<Goods> goods = goodsMapper.selectList(goodsWrapper);
        List<Goods> updateList = new ArrayList<>();
        for (int i = 0; i < goods.size(); i++) {
            String description = findGoodsDescriptionByGoodsNo(goods.get(i).getGoodsNo(), list);
            if (StringUtils.isNotBlank(description)) {
                String goodsDetails = buildGoodsDetails(goods.get(i).getGoodsDetail(), description);
                goods.get(i).setGoodsDetail(goodsDetails);
                updateList.add(goods.get(i));
            }
        }
        for (int i = 0; i < updateList.size(); i++) {
            System.err.println(updateList.get(i).getGoodsDetail());
        }
        System.err.println(updateList.size());
    }

    private String buildGoodsDetails(String goodsDetail, String description) {
        JSONObject detailObj = null;
        if (StringUtils.isBlank(goodsDetail)) {
            detailObj = new JSONObject();
        }
        detailObj = JSONObject.parseObject(goodsDetail);
        detailObj.put(DESCRIPTION_KEY, description);
        return JSON.toJSONString(detailObj);
    }

    private String findGoodsDescriptionByGoodsNo(String goodsNo, List<GoodsDescriptionDTO> descriptionDTOList) {
        List<GoodsDescriptionDTO> list = descriptionDTOList.stream().filter(item -> goodsNo.equals(item.getSpu().replace(" ", "")))
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list) || list.size() > 1) {
            spuNo.add(goodsNo);
            return null;
        }
        String description = list.get(0).getDescription();
        String detail = "<p>" + description + "</p>";
        String subDescription = "<p>" + list.get(0).getSubDescription() + "</p>";
        return detail + subDescription;
    }

    public static void main(String[] args) {
        System.err.println(StringUtils.isBlank(""));
    }
}
