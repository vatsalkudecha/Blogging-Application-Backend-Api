package com.codewithvatsal.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithvatsal.blog.entities.Category;
import com.codewithvatsal.blog.exceptions.ResourceNotFoundException;
import com.codewithvatsal.blog.payloads.CategoryDto;
import com.codewithvatsal.blog.repositories.CategoryRepo;
import com.codewithvatsal.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

//	private Category map;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).
							orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
				
		this.categoryRepo.delete(cat);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category> categories = this.categoryRepo.findAll();
		
		List<CategoryDto> catDtos = categories.stream().map((cat)->this.modelMapper.
										map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);		
	}

}
