package com.danilocampos.warehouse.services;

import java.util.UUID;

import com.danilocampos.warehouse.entity.StockEntity;
import com.danilocampos.warehouse.entity.StockStatus;

public interface IStockService {

	StockEntity save(final StockEntity entity);

	void release(final UUID id);

	void inactive(final UUID id);

	void changeStatus(final UUID id, final StockStatus status);
}
