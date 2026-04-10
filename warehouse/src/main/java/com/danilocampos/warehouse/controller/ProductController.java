package com.danilocampos.warehouse.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danilocampos.warehouse.controller.request.ProductSaveRequest;
import com.danilocampos.warehouse.controller.response.ProductDetailResponse;
import com.danilocampos.warehouse.controller.response.ProductSavedResponse;
import com.danilocampos.warehouse.mapper.IProductMapper;
import com.danilocampos.warehouse.services.IProductQueryService;
import com.danilocampos.warehouse.services.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

	private final IProductService service;
	private final IProductQueryService queryService;
	private final IProductMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	ProductSavedResponse create(@RequestBody final ProductSaveRequest request) {
		var entity = mapper.toEntity(request);
		entity = service.save(entity);
		return mapper.toSavedResponse(entity);
	}

	@PostMapping("{id}/purchase")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void purchase(@PathVariable UUID id) {
		service.purchase(id);
	}

	@GetMapping("{id}")
	ProductDetailResponse findById(@PathVariable final UUID id) {
		var dto = queryService.findById(id);
		return mapper.toDetailResponse(dto);
	}
	
}
