package com.qf.controller;

import com.qf.domain.Listen;
import com.qf.response.QueryResponseResult;

import com.qf.service.ListenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("listen")
public class ListenController {
    @Autowired
    private ListenService listenService;

    /**
     *
     * @return
     */
    @RequestMapping(value="laodAll" ,method = RequestMethod.GET)
    @ApiOperation(value = "查询听书全部（baizhenjia）" ,notes ="返回听书的所有数据" )
    public QueryResponseResult loadAll(){
        return listenService.loadAll();
    }

    /**
     *
     * @param （精选书单（0）/新书上架(1)/猜你喜欢(2) 任意一个
     * @return
     */
    @RequestMapping(value="selsctByListenType" ,method = RequestMethod.GET)
    @ApiOperation(value = "根据听书类型（精选书单（0）/新书上架(1)/猜你喜欢(2) 返回听书" ,notes ="baizhenjia）" )
    public QueryResponseResult selsctByListenType(@RequestParam("listentype") String listenType ){
        return listenService.selsctByListenType(listenType);
    }

    /**
     *
     * @param listenAuthor
     * @return
     */

    @RequestMapping(value="selsctByListenAuthor" ,method = RequestMethod.POST)
    @ApiOperation(value = "根据听书作者" ,notes ="baizhenjia）" )
    public QueryResponseResult selsctByListenAuthor(@RequestParam("author") String listenAuthor ){
        Listen listen=new Listen();
        listen.setListenAuthor(listenAuthor);
        return listenService.selsctByListenAuthor(listen);
    }


}
