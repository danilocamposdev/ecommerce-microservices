package com.danilocampos.storefront.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.danilocampos.storefront.dto.ProductDetailDTO;
import com.danilocampos.storefront.dto.ProductInfoDTO;
import com.danilocampos.storefront.entity.ProductEntity;
import com.danilocampos.storefront.mapper.IProductMapper;
import com.danilocampos.storefront.repository.ProductRepository;
import com.danilocampos.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

  private final ProductRepository repository;
  private final RestClient warehouseClient;
  private final IProductMapper mapper;

  @Override
  public ProductEntity save(final ProductEntity entity) {
    return repository.save(entity);
  }

  @Override
  public List<ProductEntity> findAllActive() {
    return repository.findByActiveTrueOrderByNameAsc();
  }

  @Override
  public ProductInfoDTO findInfo(UUID id) {
    var entity = findById(id);
    var price = requestCurrentAmount(id);
    return mapper.toDTO(entity, price);
  }

  @Override
  public void changeActivated(UUID id, boolean active) {
    var entity = findById(id);
    entity.setActive(active);
    repository.save(entity);
  }

  @Override
  public void purchase(UUID id) {
    purchaseWarehouse(id);
  }

  private void purchaseWarehouse(final UUID id) {
    var path = String.format("/products/%s/purchase", id);
    warehouseClient.post()
        .uri(path)
        .retrieve()
        .toBodilessEntity();
  }

  private ProductEntity findById(final UUID id) {
    return repository.findById(id).orElseThrow();
  }

  private BigDecimal requestCurrentAmount(UUID id) {
    var dto = warehouseClient.get()
        .uri("/products/" + id)
        .retrieve()
        .body(ProductDetailDTO.class);
    return dto.price();
  }
}
