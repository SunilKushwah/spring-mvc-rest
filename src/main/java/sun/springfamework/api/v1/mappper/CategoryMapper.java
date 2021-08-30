package sun.springfamework.api.v1.mappper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sun.springfamework.api.v1.model.CategoryDTO;
import sun.springfamework.domain.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDto(Category category);
}
