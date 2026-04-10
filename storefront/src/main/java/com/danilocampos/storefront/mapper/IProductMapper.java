package com.danilocampos.storefront.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.danilocampos.storefront.controller.request.ProductSaveRequest;
import com.danilocampos.storefront.controller.response.ProductAvailableResponse;
import com.danilocampos.storefront.controller.response.ProductDetailResponse;
import com.danilocampos.storefront.controller.response.ProductSavedResponse;
import com.danilocampos.storefront.dto.ProductInfoDTO;
import com.danilocampos.storefront.entity.ProductEntity;

@Mapper(componentModel = ComponentModel.SPRING)
public interface IProductMapper {

  ProductInfoDTO toDTO(final ProductEntity entity, final BigDecimal price);

  @Mapping(target = "active", constant = "false")
  ProductEntity toEntity(final ProductSaveRequest request);

  ProductSavedResponse toResponse(final ProductEntity entity);

  List<ProductAvailableResponse> toResponse(final List<ProductEntity> entities);

  ProductDetailResponse toResponse(final ProductInfoDTO dto);
}
