package org.coderfun.sys.dict.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.coderfun.common.OrderEntity;

import java.math.BigInteger;

/**
 * The persistent class for the sys_menu database table.
 * 
 */
@Entity
@Table(name = "sys_menu")
@Access(AccessType.FIELD)
public class Menu extends OrderEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iconCls;
 
	private String name;

	@Column(name = "parent_id")
	private BigInteger parentId;

	private String perms;

	private int type;

	private String url;

	public Menu() {
	}

	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public String getPerms() {
		return this.perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}