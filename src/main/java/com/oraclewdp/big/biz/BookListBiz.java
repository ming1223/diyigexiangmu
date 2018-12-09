package com.oraclewdp.big.biz;

import java.util.List;

import com.oraclewdp.big.model.Book;

public interface BookListBiz {

	List<Book> save(int currentPage, String name, int xid);

	int totalRow(String name, int xid);

	Book Edit(int id);

}
