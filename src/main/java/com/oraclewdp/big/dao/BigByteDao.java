package com.oraclewdp.big.dao;

import java.util.List;

import com.oraclewdp.big.model.BigType;

public interface BigByteDao {

	boolean save(String name);

	List<BigType> findAll();


}
