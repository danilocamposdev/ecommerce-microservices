package com.danilocampos.storefront.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danilocampos.storefront.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
	List<ProductEntity> findByActiveTrueOrderByNameAsc();

}
