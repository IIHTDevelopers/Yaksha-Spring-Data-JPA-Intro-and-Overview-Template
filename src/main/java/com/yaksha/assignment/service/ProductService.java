package com.yaksha.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yaksha.assignment.entity.Product;

@Service
public class ProductService {

	private List<Product> productList = new ArrayList<>();

	// Create or update a product
	public Product saveProduct(Product product) {
		if (product.getId() == null) {
			// Simulate auto-generated ID by taking the next available number
			product.setId((long) (productList.size() + 1));
			productList.add(product); // Create new product
		} else {
			// Simulate update (replace product with the same ID)
			productList.removeIf(p -> p.getId().equals(product.getId()));
			productList.add(product); // Update existing product
		}
		return product;
	}

	// Get all products
	public List<Product> getAllProducts() {
		return productList;
	}

	// Get a product by ID
	public Product getProductById(Long id) {
		Optional<Product> product = productList.stream().filter(p -> p.getId().equals(id)).findFirst();
		return product.orElse(null); // Return null if not found
	}

	// Delete a product
	public void deleteProduct(Long id) {
		productList.removeIf(p -> p.getId().equals(id)); // Remove product by ID
	}
}
