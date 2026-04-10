package com.danilocampos.storefront.controller.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductAvailableResponse(
		@JsonProperty("id")
		UUID id,
		@JsonProperty("name")
		String name		
		) {
}
