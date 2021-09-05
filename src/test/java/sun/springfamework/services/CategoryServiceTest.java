package sun.springfamework.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sun.springfamework.api.v1.mappper.CategoryMapper;
import sun.springfamework.api.v1.model.CategoryDTO;
import sun.springfamework.domain.Category;
import sun.springfamework.repositories.CategoryRepository;
import sun.springfamework.services.impl.CategoryServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    private static  long ID = 2L;
    private static  String NAME = "sunil";

    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    void getAllCategoriesTest(){
        List<Category>  categories = Arrays.asList(new Category(),new Category(),new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        assertEquals(3,categoryService.getAllCategories().size());

    }

    @Test
    void getCategoryByNameTest(){
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findByName(anyString())).thenReturn(category);

        CategoryDTO categoryByName = categoryService.getCategoryByName(NAME);

        assertEquals(ID, categoryByName.getId());
        assertEquals(NAME, categoryByName.getName());

    }
}