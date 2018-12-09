package com.oraclewdp.big.biz;

import java.util.List;

import com.oraclewdp.big.model.SmallType;

public interface SmallTypeBiz {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

	int findEdit(int xid);



}
