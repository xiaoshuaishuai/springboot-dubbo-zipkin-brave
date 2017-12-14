package com.github.xiao.spring.boot.zipkin.dubbo.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PersonEntity  implements Serializable {

	/**  
	*/  
	private static final long serialVersionUID = 4743352061666791309L;
	private Integer id;
	private String namep;
	private String decp;
	private BigDecimal acount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamep() {
		return namep;
	}

	public void setNamep(String namep) {
		this.namep = namep;
	}

	public String getDecp() {
		return decp;
	}

	public void setDecp(String decp) {
		this.decp = decp;
	}

	public BigDecimal getAcount() {
		return acount;
	}

	public void setAcount(BigDecimal acount) {
		this.acount = acount;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", namep=" + namep + ", decp=" + decp + ", acount=" + acount + "]";
	}

}
