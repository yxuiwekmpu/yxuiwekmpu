package org.coderfun.common;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.CompareToBuilder;

/**
 * Entity - 排序基类
 * 
 * @author YISHOP Team
 * @version 4.0
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class OrderEntity<ID extends Serializable> extends BaseEntity<ID> implements Comparable<OrderEntity<ID>> {

	private static final long serialVersionUID = 2985598734943661667L;

	/** "排序"属性名称 */
	public static final String ORDER_PROPERTY_NAME = "order";

	/** 排序 */
	@Min(0)
	@Column(name = "orders")
	private Integer order;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 实现compareTo方法
	 * 
	 * @param orderEntity
	 *            排序对象
	 * @return 比较结果
	 */
	public int compareTo(OrderEntity<ID> orderEntity) {
		if (orderEntity == null) {
			return 1;
		}
		return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).append(getId(), orderEntity.getId()).toComparison();
	}

}
