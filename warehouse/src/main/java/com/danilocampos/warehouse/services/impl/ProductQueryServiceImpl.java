package com.danilocampos.warehouse.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danilocampos.warehouse.entity.ProductEntity;
import com.danilocampos.warehouse.repository.ProductRepository;
import com.danilocampos.warehouse.services.IProductQueryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductQueryServiceImpl implements IProductQueryService {

  private final ProductRepository repository;

  @Override
  @Transactional(readOnly = true)
  public ProductEntity findById(UUID id) {
    return repository.findById(id).orElseThrow();
  }

}
