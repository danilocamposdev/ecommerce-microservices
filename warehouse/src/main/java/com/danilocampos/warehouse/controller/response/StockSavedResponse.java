package com.danilocampos.warehouse.controller.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.danilocampos.warehouse.entity.StockStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StockSavedResponse(
		@JsonProperty("id")
		UUID id,
		@JsonProperty("amount")
		Long amount,
		@JsonProperty("boughtPrice")
		BigDecimal boughtPrice,
		@JsonProperty("satus")
		StockStatus status,
		@JsonProperty("soldPrice")
		BigDecimal soldPrice,
		@JsonProperty("productId")
		UUID productId,
		@JsonProperty("productName")
		String productName) {
}
