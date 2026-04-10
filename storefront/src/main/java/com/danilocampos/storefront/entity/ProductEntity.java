package com.danilocampos.storefront.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Getter
@Setter
@ToString

public class ProductEntity {
	@Id
	private UUID id;
	private String name;
	private boolean active;

	// implementar equals e hashcode
}
