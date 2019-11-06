package com.hcl.trade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.model.Stocks;
import com.hcl.trade.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;

	public List<Stocks> findAllStocks() {
		return (List<Stocks>)stockRepository.findAll();
	}
	
	public Stocks findStockByStockId(int stockId){
		Stocks stocks=stockRepository.findById(stockId);
		return stocks;
	}

	public boolean saveStock(Stocks stocks) {
		stockRepository.save(stocks);
		return true;
	}

}
