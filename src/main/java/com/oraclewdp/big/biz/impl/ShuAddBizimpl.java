package com.oraclewdp.big.biz.impl;

import com.oraclewdp.big.biz.ShuAddBiz;
import com.oraclewdp.big.dao.ShuAddDao;
import com.oraclewdp.big.dao.impl.BookDaoImpl;
import com.oraclewdp.big.model.Book;

public class ShuAddBizimpl implements ShuAddBiz {

	@Override
	public boolean shu(Book shuadd) {
		ShuAddDao shuAddDao = new BookDaoImpl();
		return shuAddDao.shuadd(shuadd);
	}

	@Override
	public int del(int id) {
		ShuAddDao shuAddDao = new BookDaoImpl();
		return shuAddDao.Del(id);
	}

	@Override
	public boolean updata(Book shuadd) {
		ShuAddDao shuAddDao = new BookDaoImpl();
		return shuAddDao.xiugai(shuadd);
	}

}
