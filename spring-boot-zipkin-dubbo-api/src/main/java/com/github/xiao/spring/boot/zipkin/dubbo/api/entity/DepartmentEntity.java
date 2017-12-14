package com.github.xiao.spring.boot.zipkin.dubbo.api.entity;

import java.io.Serializable;
/**  
 * 测试mybatis多包扫描
*/  
public class DepartmentEntity implements Serializable{
	
	private static final long serialVersionUID = -8659493238153971209L;
	private Integer id;
	private String namep;
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
	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", namep=" + namep + "]";
	}
	
}
