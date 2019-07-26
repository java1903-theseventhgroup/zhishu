package com.qf.controller;

import com.qf.domain.Course;
import com.qf.service.ShoppingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    //根据传回的课程id查询当前的对象
    @ApiOperation("根据传回的课程id查询当前的对象")
    @RequestMapping(value = "/findShopById",method = RequestMethod.POST)
    public String findShopById(int courseId,HttpSession session,int id){
        Course course = shoppingService.findShopById(courseId);
        course.setId(id);
        System.out.println(course);
        session.setAttribute("course",course);
        return "redirect:/addCourse";
    }

}
