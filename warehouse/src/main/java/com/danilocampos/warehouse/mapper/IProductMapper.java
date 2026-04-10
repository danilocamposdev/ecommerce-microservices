package com.danilocampos.warehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.danilocampos.warehouse.controller.request.ProductSaveRequest;
import com.danilocampos.warehouse.controller.response.ProductDetailResponse;
import com.danilocampos.warehouse.controller.response.ProductSavedResponse;
import com.danilocampos.warehouse.dto.ProductStorefrontSaveDTO;
import com.danilocampos.warehouse.entity.ProductEntity;

@Mapper(componentModel = ComponentModel.SPRING)
public interface IProductMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "stocks", ignore = true)
  @Mapping(target = "price", ignore = true)
  ProductEntity toEntity(final ProductSaveRequest request);

  ProductSavedResponse toSavedResponse(final ProductEntity entity);

  ProductDetailResponse toDetailResponse(final ProductEntity entity);

  ProductStorefrontSaveDTO toDTO(final ProductEntity entity);
}
