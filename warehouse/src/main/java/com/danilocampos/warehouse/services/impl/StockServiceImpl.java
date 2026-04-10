package com.danilocampos.warehouse.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.danilocampos.warehouse.dto.StockStatusMessage;
import com.danilocampos.warehouse.entity.StockEntity;
import com.danilocampos.warehouse.entity.StockStatus;
import com.danilocampos.warehouse.repository.StockRepository;
import com.danilocampos.warehouse.services.IProductChangeAvailabilityProducer;
import com.danilocampos.warehouse.services.IProductQueryService;
import com.danilocampos.warehouse.services.IStockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService{
	private final StockRepository repository;
	private final IProductQueryService productQueryService;
	private final IProductChangeAvailabilityProducer producer;

	@Override
	public StockEntity save(StockEntity entity) {
		entity.setProduct(productQueryService.findById(entity.getProduct().getId()));
		return repository.save(entity);
	}

	@Override
	public void release(UUID id) {
		changeStatus(id, StockStatus.AVAILABLE);
	}

	@Override
	public void inactive(UUID id) {
		changeStatus(id, StockStatus.UNAVAILABLE);
	}

	@Override
	public void changeStatus(UUID id, StockStatus status) {
		var entity = repository.findById(id).orElseThrow();
		entity.setStatus(status);
		repository.save(entity);
		producer.notifyStatusChange(new StockStatusMessage(entity.getProduct().getId(), status));
	}

	
}
