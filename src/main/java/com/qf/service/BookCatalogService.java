package com.qf.service;

import com.qf.response.QueryResponseResult;

public interface BookCatalogService {
    QueryResponseResult findBookCatalogByName(String book_subtitle);
}
