package com.hcl.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trade.model.Stocks;
import com.hcl.trade.service.StockService;

@RestController
@RequestMapping("/Stocks")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("/AllStocks")
    public ResponseEntity<List<Stocks>> listAllStocks() {
        List<Stocks> stocks = stockService.findAllStocks();
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(stocks, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
	
	

}
