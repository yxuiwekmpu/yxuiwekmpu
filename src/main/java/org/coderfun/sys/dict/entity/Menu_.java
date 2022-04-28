package org.coderfun.sys.dict.entity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.coderfun.common.OrderEntity_;

@Generated(value="Dali", date="2018-06-02T23:11:54.251+0800")
@StaticMetamodel(Menu.class)
public class Menu_ extends OrderEntity_ {
	public static volatile SingularAttribute<Menu, String> iconCls;
	public static volatile SingularAttribute<Menu, String> perms;
	public static volatile SingularAttribute<Menu, Integer> type;
	public static volatile SingularAttribute<Menu, String> url;
	public static volatile SingularAttribute<Menu, String> name;
	public static volatile SingularAttribute<Menu, BigInteger> parentId;
}
