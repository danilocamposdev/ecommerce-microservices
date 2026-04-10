package com.danilocampos.warehouse.dto;

import java.util.UUID;

import com.danilocampos.warehouse.entity.StockStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StockStatusMessage(
		@JsonProperty("id")
		UUID id,
		@JsonProperty("status")
		StockStatus status) {
}
