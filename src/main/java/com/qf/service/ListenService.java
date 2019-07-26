package com.qf.service;

import com.qf.domain.Listen;
import com.qf.response.QueryResponseResult;

public interface ListenService {
    QueryResponseResult findS21(String classification);
    QueryResponseResult findSujectsByName(String subject);
    QueryResponseResult loadAll();//加载所有听书
    QueryResponseResult selsctByListenType(String listenType);
    QueryResponseResult selsctByListenAuthor(Listen listen);
    public QueryResponseResult findByNameOrAuthor(String subject);//模糊查询
}
