package com.danilocampos.storefront.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.danilocampos.storefront.dto.StockStatusMessage;
import com.danilocampos.storefront.service.IProductChangeAvailabilityConsumer;
import com.danilocampos.storefront.service.IProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductChangeAvailabilityComsumerImpl implements IProductChangeAvailabilityConsumer{

	private final IProductService service;

	@RabbitListener(queues = "${spring.rabbitmq.queue.product-change-availability}")
	@Override
	public void receive(StockStatusMessage message) {
		service.changeActivated(message.id(), message.active());
	}
	
}
