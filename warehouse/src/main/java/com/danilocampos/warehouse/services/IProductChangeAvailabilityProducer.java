package com.danilocampos.warehouse.services;

import com.danilocampos.warehouse.dto.StockStatusMessage;

public interface IProductChangeAvailabilityProducer {

  void notifyStatusChange(final StockStatusMessage message);

}
