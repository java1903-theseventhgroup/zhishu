package com.qf.service.serviceImpl;

import com.qf.dao.ListenDao;
import com.qf.domain.Book;
import com.qf.domain.Listen;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.ListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenServiceImpl implements ListenService {
    @Autowired
    private ListenDao listenDao;


    @Override
    public QueryResponseResult findS21(String classification) {
        List<Listen> s21 = listenDao.findS21(classification);
        QueryResult<Listen> queryResult=new QueryResult<>();
            queryResult.setList(s21);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);

    }

    @Override
    public QueryResponseResult findSujectsByName(String subject) {
        List<Listen> sujectsByName = listenDao.findSujectsByName(subject);
        QueryResult<Listen> queryResult=new QueryResult<>();
        queryResult.setList(sujectsByName);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult loadAll() {
        List<Listen> all=listenDao.loadAll();
        QueryResult<Listen> listenQueryResult = new QueryResult<>();
        listenQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,listenQueryResult);
    }

    @Override
    public QueryResponseResult selsctByListenType(String listenType) {
        List<Listen> all=listenDao.selsctByListenType(listenType);
        QueryResult<Listen> listenQueryResult = new QueryResult<>();
        listenQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,listenQueryResult);
    }

    @Override
    public QueryResponseResult selsctByListenAuthor(Listen listen) {
        List<Listen> all=listenDao.selsctByListenAuthor(listen);
        QueryResult<Listen> listenQueryResult = new QueryResult<>();
        listenQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,listenQueryResult);
    }

    @Override
    public QueryResponseResult findByNameOrAuthor(String subject) {
        List<Listen> all = listenDao.findByNameOrAuthor(subject);
        QueryResult<Listen> userQueryResult = new QueryResult<>();
        userQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);
    }
}
