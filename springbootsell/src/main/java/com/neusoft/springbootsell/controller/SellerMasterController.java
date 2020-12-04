package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.OrderDetail;
import com.neusoft.springbootsell.dataobject.OrderMaster;
import com.neusoft.springbootsell.services.DetailService;
import com.neusoft.springbootsell.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/master")
public class SellerMasterController {
    @Autowired
    MasterService masterService;
    @Autowired
    DetailService detailService;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<OrderMaster> list = masterService.findAll();
        map.put("masterList",list);
        return new ModelAndView("/master/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId",required = false)String orderId,
                               ModelAndView view){
        masterService.cancel(orderId);
        view.setViewName("redirect:/seller/master/list");
        return view;
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam(value = "orderId",required = false)String orderId,
                                @RequestParam(value = "detailId",required = false)String detailId,
                                Map<String,Object> map){
        OrderMaster master = masterService.findById(orderId);
        OrderDetail detail = detailService.findByOrderId(detailId);
        map.put("master",master);
        map.put("detail",detail);
        return new ModelAndView("/master/details",map);
    }
}
