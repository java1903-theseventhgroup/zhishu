package com.qf.service;

import com.qf.domain.Book;
import com.qf.domain.BookHistory;
import com.qf.response.QueryResponseResult;

import java.util.List;

public interface BookService {
    QueryResponseResult findAll();
    QueryResponseResult findType(String bookType);
    QueryResponseResult findS2(String classification);
    QueryResponseResult findSujectsByName(String subject);
    public QueryResponseResult findByNameOrAuthor(String subject);
    public QueryResponseResult getBookHistory();
    public void addBookHistory(BookHistory bookHistory);
    public void deleteHistory(String bookSubtile);
    public int deleteAll();
}
