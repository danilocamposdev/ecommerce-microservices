package com.danilocampos.warehouse.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danilocampos.warehouse.controller.request.StockSaveRequest;
import com.danilocampos.warehouse.controller.response.StockSavedResponse;
import com.danilocampos.warehouse.mapper.IStockMapper;
import com.danilocampos.warehouse.services.IStockService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("stocks")
@AllArgsConstructor
public class StockController {

  private final IStockService service;
  private final IStockMapper mapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  StockSavedResponse save(@RequestBody final StockSaveRequest request) {
    var entity = mapper.toEntity(request);
    entity = service.save(entity);
    return mapper.toResponse(entity);
  }

  @PutMapping("{id}/releasse")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void release(@PathVariable final UUID id) {
    service.release(id);
  }

  @DeleteMapping("{id}/inactive")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void inactive(@PathVariable final UUID id) {
    service.inactive(id);
  }

}
