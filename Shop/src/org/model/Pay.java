package org.model;

import java.util.Date;

/**
 * Pay entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Pay implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userid;
	private Integer goodid;
	private Date date;

	// Constructors

	/** default constructor */
	public Pay() {
	}

	/** full constructor */
	public Pay(String userid, Integer goodid, Date date) {
		this.userid = userid;
		this.goodid = goodid;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getGoodid() {
		return this.goodid;
	}

	public void setGoodid(Integer goodid) {
		this.goodid = goodid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}