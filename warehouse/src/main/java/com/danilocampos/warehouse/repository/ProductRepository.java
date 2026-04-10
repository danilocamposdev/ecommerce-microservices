package com.danilocampos.warehouse.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danilocampos.warehouse.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

  @Override
  @EntityGraph(attributePaths = "stocks")
  Optional<ProductEntity> findById(UUID id);

}
