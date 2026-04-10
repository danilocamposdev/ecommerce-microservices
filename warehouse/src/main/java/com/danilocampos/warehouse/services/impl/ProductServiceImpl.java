package com.danilocampos.warehouse.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import com.danilocampos.warehouse.dto.ProductStorefrontSaveDTO;
import com.danilocampos.warehouse.dto.ProductStorefrontSavedDTO;
import com.danilocampos.warehouse.entity.ProductEntity;
import com.danilocampos.warehouse.mapper.IProductMapper;
import com.danilocampos.warehouse.repository.ProductRepository;
import com.danilocampos.warehouse.services.IProductQueryService;
import com.danilocampos.warehouse.services.IProductService;
import com.danilocampos.warehouse.services.IStockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

  private final ProductRepository repository;
  private final IProductQueryService queryService;
  private final IStockService stockService;
  private final RestClient storefrontClient;
  private final IProductMapper mapper;

  @Override
  public ProductEntity save(ProductEntity entity) {
    repository.save(entity);
    var dto = mapper.toDTO(entity);
    saveStorefront(dto);
    return entity;
  }

  private void saveStorefront(ProductStorefrontSaveDTO dto) {
    storefrontClient.post().uri("/products")
        .body(dto)
        .retrieve()
        .body(ProductStorefrontSavedDTO.class);
  }

  @Override
  @Transactional
  public void purchase(UUID id) {
    var entity = queryService.findById(id);
    var stock = entity.decStock();
    repository.save(entity);
    if (stock.isUnavailable()) {
      stockService.changeStatus(entity.getId(), stock.getStatus());
    }
  }

}
