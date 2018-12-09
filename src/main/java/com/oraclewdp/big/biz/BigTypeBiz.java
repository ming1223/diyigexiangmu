package com.oraclewdp.big.biz;

import java.util.List;

import com.oraclewdp.big.model.BigType;

public interface BigTypeBiz {

	boolean save(String name);

	List<BigType> findAllBigTye();


}
