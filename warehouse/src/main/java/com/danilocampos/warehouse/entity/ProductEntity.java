package com.danilocampos.warehouse.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ProductEntity {

  @Id
  private UUID id;

  private String name;

  @ToString.Exclude
  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<StockEntity> stocks = new HashSet<>();

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID();
  }

  private StockEntity getStockWithMinSoldPrice() {
    return this.stocks.stream()
        .filter(s -> s.getStatus().equals(StockStatus.AVAILABLE))
        .min(Comparator.comparing(StockEntity::getSoldPrice))
        .orElseThrow();
  }

  public StockEntity decStock() {
    var stock = getStockWithMinSoldPrice();
    stock.decAmount();
    return stock;
  }

  public BigDecimal getPrice() {
    return getStockWithMinSoldPrice().getSoldPrice();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProductEntity other = (ProductEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
