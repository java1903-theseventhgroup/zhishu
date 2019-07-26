package com.qf.controller;

import com.qf.response.QueryResponseResult;
import com.qf.service.BookCatalogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookCatalogController {
    @Autowired
    private BookCatalogService bookCatalogService;

    @RequestMapping(value = "findBookCatalogByName",method = RequestMethod.POST)
    @ApiOperation(value = "通过书名查询目录")
    public QueryResponseResult findBookCatalogByName(@RequestParam("bookname")String bookSubtitle){
        QueryResponseResult bookCatalogByName = bookCatalogService.findBookCatalogByName(bookSubtitle);
        return bookCatalogByName;
    }

}
