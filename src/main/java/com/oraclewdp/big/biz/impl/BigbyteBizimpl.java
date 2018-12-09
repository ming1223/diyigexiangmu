package com.oraclewdp.big.biz.impl;

import java.util.List;

import com.oraclewdp.big.biz.BigTypeBiz;
import com.oraclewdp.big.dao.BigByteDao;
import com.oraclewdp.big.dao.impl.BigTypeDaoImpl;
import com.oraclewdp.big.model.BigType;

public class BigbyteBizimpl implements BigTypeBiz {

	@Override
	public boolean save(String name) {
		BigByteDao bigbytedao = new BigTypeDaoImpl();
		return bigbytedao.save(name);
	}

	@Override
	public List<BigType> findAllBigTye() {
		BigByteDao bigByteDao = new BigTypeDaoImpl();
		return bigByteDao.findAll();
	}

}
