package com.work.controller;

import com.work.pojo.Customer;
import com.work.service.impl.CusServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CusController {

    @Resource
    private CusServiceImpl service;

    @GetMapping("/admin/customer")
    public String customer(){
        return "redirect:/admin/customer/all";
    }

    @GetMapping("/admin/customer/index")
    public String toIndex(){
        return "/admin/customer/index";
    }

    @ResponseBody
    @GetMapping("/admin/customer/all")
    public ModelAndView selectAll(){
        return new ModelAndView(toIndex(), "customers", service.selectAll());
    }

    @PostMapping(value = "/admin/customer/add")
    public ModelAndView add(String userName, String telNum, String birthday){
        // userName 我先改成0了，不如添加不了，其他的到时候回来看看
        service.add(new Customer( 0, userName, telNum, 0, birthday));
        return selectAll();
    }

    @PostMapping(value = "/admin/customer/update")
    public ModelAndView update(int userId, String userName, String telNum,int integral, String birthday){
        service.edit(new Customer(userId, userName, telNum, integral, birthday));
        return selectAll();
    }

    @PostMapping(value = "/admin/customer/del")
    public ModelAndView del(int userId){
        System.out.println("获取到的用户id：" + userId);
        service.delete(userId);
        return selectAll();
    }
}
