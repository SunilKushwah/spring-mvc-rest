package sun.springfamework.services.impl;

import org.springframework.stereotype.Service;
import sun.springfamework.api.v1.mappper.CategoryMapper;
import sun.springfamework.api.v1.model.CategoryDTO;
import sun.springfamework.repositories.CategoryRepository;
import sun.springfamework.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.findByName(name));
    }
}
