package com.danilocampos.storefront.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danilocampos.storefront.controller.request.ProductSaveRequest;
import com.danilocampos.storefront.controller.response.ProductAvailableResponse;
import com.danilocampos.storefront.controller.response.ProductDetailResponse;
import com.danilocampos.storefront.controller.response.ProductSavedResponse;
import com.danilocampos.storefront.mapper.IProductMapper;
import com.danilocampos.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

  private final IProductService service;
  private final IProductMapper mapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  ProductSavedResponse create(@RequestBody final ProductSaveRequest request) {
    var entity = mapper.toEntity(request);
    entity = service.save(entity);
    return mapper.toResponse(entity);
  }

  @PostMapping("{id}/purchase")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void purchase(@PathVariable final UUID id) {
    service.purchase(id);
  }

  @GetMapping
  List<ProductAvailableResponse> listAvailable() {
    var entities = service.findAllActive();
    return mapper.toResponse(entities);
  }

  @GetMapping("{id}")
  ProductDetailResponse findById(@PathVariable final UUID id) {
    var dto = service.findInfo(id);
    return mapper.toResponse(dto);
  }
}
