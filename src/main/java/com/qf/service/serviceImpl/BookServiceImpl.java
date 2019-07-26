package com.qf.service.serviceImpl;

import com.qf.dao.BookDao;
import com.qf.dao.ListenDao;
import com.qf.domain.Book;
import com.qf.domain.BookHistory;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;



    @Override
    public QueryResponseResult findAll() {
        List<Book> all = bookDao.findAll();
        QueryResult<Book> bookQueryResult=new QueryResult<>();
        bookQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,bookQueryResult);
    }

    @Override
    public QueryResponseResult findType(String bookType) {
        List<Book> type0 = bookDao.findType(bookType);
        QueryResult<Book> bookQueryResult=new QueryResult<>();
        bookQueryResult.setList(type0);
        return new QueryResponseResult<>(CommonCode.SUCCESS,bookQueryResult);
    }


    @Override
    public QueryResponseResult findS2(String classification) {
        List<Book> s2 = bookDao.findS2(classification);
        QueryResult<Book> queryResult=new QueryResult<>();
            queryResult.setList(s2);
            return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult findSujectsByName(String subject) {
        List<Book> sujectsByName = bookDao.findSujectsByName(subject);
        QueryResult<Book> queryResult=new QueryResult<>();
        queryResult.setList(sujectsByName);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }


    @Override
    public QueryResponseResult findByNameOrAuthor(String subject) {
        List<Book> all = bookDao.findByNameOrAuthor(subject);


        QueryResult<Book> userQueryResult = new QueryResult<>();
        userQueryResult.setList(all);
        return new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);
    }

    @Override
    public QueryResponseResult getBookHistory() {
        List<BookHistory> bookHistory = bookDao.getBookHistory();
        QueryResult<BookHistory> userQueryResult = new QueryResult<>();
        userQueryResult.setList(bookHistory);
        return  new QueryResponseResult<>(CommonCode.SUCCESS,userQueryResult);
    }

    @Override
    public void addBookHistory(BookHistory bookHistory) {
        bookDao.addHistory(bookHistory);
    }

    @Override
    public void deleteHistory(String bookSubtile) {
        bookDao.deleteHistory(bookSubtile);
    }

    @Override
    public int deleteAll() {
        int i = bookDao.deleteAll();
        return i;
    }
}
