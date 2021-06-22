package org.model;

/**
 * Buy entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Buy implements java.io.Serializable {

	// Fields

	private BuyId id;
	private Integer state;

	// Constructors

	/** default constructor */
	public Buy() {
	}

	/** minimal constructor */
	public Buy(BuyId id) {
		this.id = id;
	}

	/** full constructor */
	public Buy(BuyId id, Integer state) {
		this.id = id;
		this.state = state;
	}

	// Property accessors

	public BuyId getId() {
		return this.id;
	}

	public void setId(BuyId id) {
		this.id = id;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}