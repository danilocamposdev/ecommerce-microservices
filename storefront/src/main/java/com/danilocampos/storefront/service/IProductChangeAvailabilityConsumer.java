package com.danilocampos.storefront.service;

import com.danilocampos.storefront.dto.StockStatusMessage;

public interface IProductChangeAvailabilityConsumer {

	void receive(final StockStatusMessage message);
}
