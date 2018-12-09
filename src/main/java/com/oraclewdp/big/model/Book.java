package com.oraclewdp.big.model;

import java.io.Serializable;
import java.util.Date;

public class Book  implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int xid;
	public int getXid() {
		return xid;
	}
	public void setXid(int xid) {
		this.xid = xid;
	}
	private String shuming;
	private double jiage;
	private String zuozhe;
	private String zishu;
	private String tupian;
	private String chuban;
	private Date riqi;
	private String jianjie;
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShuming() {
		return shuming;
	}
	public void setShuming(String shuming) {
		this.shuming = shuming;
	}
	public double getJiage() {
		return jiage;
	}
	public void setJiage(double jiage) {
		this.jiage = jiage;
	}
	public String getZuozhe() {
		return zuozhe;
	}
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	public String getZishu() {
		return zishu;
	}
	public void setZishu(String zishu) {
		this.zishu = zishu;
	}
	public String getTupian() {
		return tupian;
	}
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	public String getChuban() {
		return chuban;
	}
	public void setChuban(String chuban) {
		this.chuban = chuban;
	}
	public Date getRiqi() {
		return riqi;
	}
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
