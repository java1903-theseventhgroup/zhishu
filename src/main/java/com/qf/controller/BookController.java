package com.qf.controller;

import com.qf.domain.Book;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.BookService;
import com.qf.service.CourseService;
import com.qf.service.ListenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ListenService listenService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的电子书")
    public QueryResponseResult findAll(){
        QueryResponseResult all = bookService.findAll();
        return all;
    }

    @RequestMapping(value = "findType",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有精选书单/限时特价/专家推荐/新书上架")
    public QueryResponseResult findType(@RequestParam("books") String bookType){
        QueryResponseResult type0 = bookService.findType(bookType);
        return type0;
    }

    @RequestMapping(value = "findS2",method = RequestMethod.POST)
    @ApiOperation(value = "查询二级目录下的所有三级相关信息")
    public List<QueryResponseResult> findS2(@RequestParam("classification") String classification){

        QueryResponseResult s2 = bookService.findS2(classification);
        QueryResponseResult s21 = listenService.findS21(classification);
        QueryResponseResult s22 = courseService.findS22(classification);
        List<QueryResponseResult> list=new ArrayList<>();
            list.add(s2);
            list.add(s21);
            list.add(s22);
            return list;

    }

    @RequestMapping(value = "findSujectsByName",method = RequestMethod.POST)
    @ApiOperation(value = "查询一级目录下的所有")
    public List<QueryResponseResult> findSujectsByName(@RequestParam("subject") String subject) {
        QueryResponseResult sujectsByName = bookService.findSujectsByName(subject);
        QueryResponseResult sujectsByName1 = courseService.findSujectsByName(subject);
        QueryResponseResult sujectsByName2 = listenService.findSujectsByName(subject);
        List<QueryResponseResult> list=new ArrayList<>();
        list.add(sujectsByName);
        list.add(sujectsByName1);
        list.add(sujectsByName2);
        return list;
        }
    }
