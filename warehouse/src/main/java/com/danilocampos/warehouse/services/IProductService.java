package com.danilocampos.warehouse.services;

import java.util.UUID;

import com.danilocampos.warehouse.entity.ProductEntity;

public interface IProductService {

  ProductEntity save(final ProductEntity entity);

  void purchase(final UUID id);
}
