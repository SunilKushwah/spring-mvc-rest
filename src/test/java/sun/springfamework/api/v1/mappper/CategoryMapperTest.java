package sun.springfamework.api.v1.mappper;

import org.junit.jupiter.api.Test;
import sun.springfamework.api.v1.model.CategoryDTO;
import sun.springfamework.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    public static final String NAME = "sunil";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void test(){
        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //When
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDto(category);

        assertEquals(Long.valueOf(ID),categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());

    }


}