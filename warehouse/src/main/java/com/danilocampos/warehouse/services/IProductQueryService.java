package com.danilocampos.warehouse.services;

import java.util.UUID;

import com.danilocampos.warehouse.entity.ProductEntity;

public interface IProductQueryService {

	ProductEntity findById(final UUID id);
}
