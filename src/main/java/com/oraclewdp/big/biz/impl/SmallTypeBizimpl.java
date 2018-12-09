package com.oraclewdp.big.biz.impl;

import java.util.List;

import com.oraclewdp.big.biz.SmallTypeBiz;
import com.oraclewdp.big.dao.SmallTypeDao;
import com.oraclewdp.big.dao.impl.SmallTypeDaoJdbcImpl;
import com.oraclewdp.big.model.SmallType;

public class SmallTypeBizimpl implements SmallTypeBiz {

	@Override
	public boolean save(SmallType smallType) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.save(smallType);
	}

	@Override
	public List<SmallType> findAllByBid(int bid) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.findAllByBig(bid);
	}

	@Override
	public int findEdit(int xid) {
		SmallTypeDao smallTypeDao = new SmallTypeDaoJdbcImpl();
		return smallTypeDao.findEdit(xid);
	}

}
