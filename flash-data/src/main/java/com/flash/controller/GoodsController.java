package com.flash.controller;


import com.flash.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * SPU表 前端控制器
 * </p>
 *
 * @author weiqiang
 * @since 2020-12-19
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @GetMapping
    public ModelAndView getGoods() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index.html");
        return view;
    }

}
