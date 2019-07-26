package com.qf.controller;

import com.qf.domain.BookHistory;
import com.qf.response.QueryResponseResult;
import com.qf.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/7/22 0022.
 */
@Controller
@ResponseBody
public class BookHistoryController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/getHistory",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value ="查询历史",notes = "test: 仅1和2有正确返回")
    public QueryResponseResult findHistory(){
        QueryResponseResult bookHistory = bookService.getBookHistory();
        return bookHistory;
    }
    @RequestMapping(value = "/addHistory",method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST",value ="增加历史",notes = "test: 仅1和2有正确返回")
    public String addHistory(@RequestParam("add") String bookAuthor,@RequestParam("add2")String bookSubtile){
        BookHistory bookHistory=new BookHistory();
        bookHistory.setBookAuthor(bookAuthor);
        bookHistory.setBookSubtile(bookSubtile);
        bookService.addBookHistory(bookHistory);
        return "添加成功";
    }

    @RequestMapping(value = "/deleteHistory",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation( value="根据书名删除历史",notes = "test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "name", value = "书名", required = true, dataType = "string")
    public String deleteHistory(@RequestParam("name") String bookSubtile){
        bookService.deleteHistory(bookSubtile);
        return "删除成功";
    }
    @RequestMapping(value = "/deleteAll",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation( value="删除所有历史",notes = "test: 仅1和2有正确返回")
    public String deleteAll(){
        int i = bookService.deleteAll();
        return "删除全部成功";
    }
}
