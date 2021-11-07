package com.sapient.ecommerce.dbaccess.dbschema;

import java.util.List;

public class Product {

	String productId;
	
	String productName;
	
	Brand brand;
	
	Size size;
	
	String color;
	
	double price;
	
	long sku;
	
	List<Seller> sellers;
}
