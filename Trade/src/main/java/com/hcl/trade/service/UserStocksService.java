package com.hcl.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trade.buy.Buy;
import com.hcl.trade.model.Stocks;
import com.hcl.trade.model.User;
import com.hcl.trade.model.UserStocks;
import com.hcl.trade.repository.StockRepository;
import com.hcl.trade.repository.UserStocksRepository;

@Service
public class UserStocksService {
	
	@Autowired
	UserStocksRepository userStocksRepository;
	
	@Autowired
	StockService stockService;
	
	public List<UserStocks> findByUserId(Integer userId){
		return userStocksRepository.findByUserId(userId);
	}
	
	public String buy(Buy buy) {
		Stocks stocks=stockService.findStockByStockId(buy.getStockId());
		int quantityOrdered=buy.getQuantityOrdered();
		int quantity=stocks.getQuantity();
		String res="";
		if(quantity >= quantityOrdered) {
			quantity=quantity-quantityOrdered;
			stocks.setQuantity(quantity);
			int brokerage=stocks.getBrokerage();
			double pricePerStock=stocks.getPrice();
			double totalPrice=0.0;
			double brokerageAmount=0;
			brokerageAmount=pricePerStock*quantityOrdered*brokerage/100;
			totalPrice=(pricePerStock*quantityOrdered) + brokerageAmount;
			UserStocks userStocks=new UserStocks();
			userStocks.setUserId(buy.getUserId());
			userStocks.setStockId(buy.getStockId());
			userStocks.setStockName(stocks.getStockName());
			userStocks.setQuantityOrdered(buy.getQuantityOrdered());
			userStocks.setTotalPrice(totalPrice);
			userStocksRepository.save(userStocks);
			stockService.saveStock(stocks);
			return res="Ordered Successfully";
		} else {
			res="Sorry..Order not Placed";
		}
		
		return res;
		
	}
}
