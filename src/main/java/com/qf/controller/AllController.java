package com.qf.controller;

import com.qf.response.QueryResponseResult;
import com.qf.service.BookService;
import com.qf.service.CourseService;
import com.qf.service.ListenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/22 0022.
 */
@ResponseBody
@Controller
public class AllController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ListenService listenService;

    @RequestMapping(value = "/findByNameOrAuthor",method = RequestMethod.POST)
    @ApiOperation(value = "模糊查询")
    public List<QueryResponseResult> findSujectsByName(@RequestParam("mh") String subject) {
        QueryResponseResult byNameOrAuthor = bookService.findByNameOrAuthor(subject);
        QueryResponseResult sujectsByName1 = courseService.findByNameOrAuthor(subject);
        QueryResponseResult sujectsByName2 = listenService.findByNameOrAuthor(subject);
        List<QueryResponseResult> list=new ArrayList<>();
        list.add(byNameOrAuthor);
        list.add(sujectsByName1);
        list.add(sujectsByName2);
        return list;
    }

    }

