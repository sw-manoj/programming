package com.sapient.ecommerce.dbaccess.dbschema;

import java.util.List;

public class OrderDetails {

	String customerId;
	
	List<String> products;
	
	Address shippingDetail;
	
	long totalPrice;
}
