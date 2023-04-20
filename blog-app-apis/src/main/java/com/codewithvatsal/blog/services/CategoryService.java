package com.codewithvatsal.blog.services;

import java.util.List;

import com.codewithvatsal.blog.payloads.CategoryDto;

public interface CategoryService {
	
	// create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// delete
	public void deleteCategory(Integer categoryId);
	
	// get one
	public CategoryDto getCategory(Integer categoryId);
	
	// get all
	public List<CategoryDto> getCategories();
}
