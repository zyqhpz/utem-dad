package week5.sale.server.controller;

import java.util.ArrayList;
import java.util.List;

import week5.sale.model.Product;

/**
 * This class manage product data
 * 
 * @author emalianakasmuri
 *
 */
public class ProductDataManager {
	
	
	private List<Product> products;
	
	/**
	 * Constructor
	 */
	public ProductDataManager() {
		
		// Load products
		this.products = new ArrayList<Product>();
		this.loadProducts();
		
	}
	
	public List<Product> getProducts() {
		
		return products;
	}
	
	/**
	 * This method finds a product from a list based on the product id
	 * and return a product
	 * @param id
	 * @return a product
	 */
	public Product getProduct(int id) {
		
		// Find a product
		for (Product product:products) {
			
			if (product.getProductId() == id)
				return product;
		}
		
		// Return product not found
		Product unFoundProduct = new Product();
		unFoundProduct.setName("Product not found");
		
		return unFoundProduct;
		
	}
	
	
	/**
	 * This method loads a list of product into a list
	 */
	private void loadProducts() {
		
		// Sample data
		int ids[] = {1001, 1002, 1003};
		String names[] = {"McChicken", "Big Mac", "Fillet o Fish"};
		double prices[] = {7.65, 9.60, 6.90};
		
		// Load data into list
		for (int index=0; index < ids.length; index++) {
			
			// Create product
			Product product = new Product();
			product.setProductId(ids[index]);
			product.setPrice(prices[index]);
			product.setName(names[index]);
			
			// Add to list
			products.add(product);
			
		}
		
		
		
		
	}
	
	
	

}
