package org.model;

/**
 * Type entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typename;

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** full constructor */
	public Type(String typename) {
		this.typename = typename;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}