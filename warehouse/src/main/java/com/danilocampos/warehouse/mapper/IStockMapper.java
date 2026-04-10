package com.danilocampos.warehouse.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.danilocampos.warehouse.controller.request.StockSaveRequest;
import com.danilocampos.warehouse.controller.response.StockSavedResponse;
import com.danilocampos.warehouse.entity.StockEntity;

@Mapper(componentModel =  ComponentModel.SPRING)
public interface IStockMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "product.id", source = "productId")
	@Mapping(target = "status", expression = "java(com.danilocampos.warehouse.entity.StockStatus.IN_CONFERENCE)")
	StockEntity toEntity(final StockSaveRequest request);

	@Mapping(target = "productId", source = "product.id")
	@Mapping(target = "productName", source = "product.name")
	StockSavedResponse toResponse(final StockEntity entity);
	
}
