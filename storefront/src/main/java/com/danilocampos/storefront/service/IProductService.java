package com.danilocampos.storefront.service;

import java.util.List;
import java.util.UUID;

import com.danilocampos.storefront.dto.ProductInfoDTO;
import com.danilocampos.storefront.entity.ProductEntity;

public interface IProductService {

	ProductEntity save(final ProductEntity entity);

	void changeActivated(final UUID id, final boolean active);

	List<ProductEntity> findAllActive();

	ProductInfoDTO findInfo(final UUID id);

	void purchase(final UUID id);

}
