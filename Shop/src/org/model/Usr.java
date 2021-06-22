package org.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usr entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Usr implements java.io.Serializable {

	// Fields

	private String userid;
	private String username;
	private Byte sex;
	private Date date;
	private String addr;
	private byte[] photo;
	private Set goods = new HashSet();

	// Constructors

	/** default constructor */
	public Usr() {
	}

	/** minimal constructor */
	public Usr(String userid) {
		this.userid = userid;
	}

	/** full constructor */
	public Usr(String userid, String username, Byte sex, Date date, byte[] photo) {
		this.userid = userid;
		this.username = username;
		this.sex = sex;
		this.date = date;
		this.photo = photo;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Byte getSex() {
		return this.sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Set getGoods() {
		return goods;
	}

	public void setGoods(Set goods) {
		this.goods = goods;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}