package com.qf.service.serviceImpl;

import com.qf.dao.BookCatalogDao;
import com.qf.domain.BookCatalog;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.BookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookCatalogServiceImpl implements BookCatalogService {
    @Autowired
    private BookCatalogDao bookCatalogDao;
    @Override
    public QueryResponseResult findBookCatalogByName(String book_subtitle) {
        List<BookCatalog> bookCatalogByName = bookCatalogDao.findBookCatalogByName(book_subtitle);
        QueryResult<BookCatalog> queryResult=new QueryResult<>();
        queryResult.setList(bookCatalogByName);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }
}
