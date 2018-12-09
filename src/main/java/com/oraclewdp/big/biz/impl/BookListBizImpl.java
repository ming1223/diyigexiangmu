package com.oraclewdp.big.biz.impl;

import java.util.List;

import com.oraclewdp.big.biz.BookListBiz;
import com.oraclewdp.big.dao.BookListDao;
import com.oraclewdp.big.dao.impl.BookListDaoImpl;
import com.oraclewdp.big.model.Book;

public class BookListBizImpl implements BookListBiz {

	@Override
	public List<Book> save(int currentPage ,String name, int xid) {
		BookListDao bookListDao = new BookListDaoImpl();
		return bookListDao.find(currentPage,name,xid);
	}

	@Override
	public int totalRow(String name,int xid) {
		BookListDao bookListDao = new BookListDaoImpl();
		return bookListDao.total(name,xid);
	}

	@Override
	public Book Edit(int id) {
		BookListDao bookListDao = new BookListDaoImpl();
		return bookListDao.edit(id);
	}

}
