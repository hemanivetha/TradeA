package com.hcl.trade.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.Stocks;

@Repository
public interface StockRepository extends CrudRepository<Stocks, Integer>{
	
	public Stocks findById(int stockId);

}
