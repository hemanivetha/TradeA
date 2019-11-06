package com.hcl.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trade.buy.Buy;
import com.hcl.trade.model.Stocks;
import com.hcl.trade.model.UserStocks;
import com.hcl.trade.service.UserStocksService;

@RestController
@RequestMapping("/UserStocks")
public class UserStockController {
	
	@Autowired
	UserStocksService userStocksService;
	
	 @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	    public ResponseEntity<List<UserStocks>> showStockById(@PathVariable("userId") Integer userId) {
	       List<UserStocks> userStocks = userStocksService.findByUserId(userId);
	        if (userStocks.isEmpty()) {
	            return new ResponseEntity<List<UserStocks>>(userStocks, HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<List<UserStocks>>(userStocks, HttpStatus.OK);
	    }
	 
	 @PostMapping( "/buy")
	    public ResponseEntity<String> buy(@RequestBody Buy buy) {
	       
	        return new ResponseEntity<String>(userStocksService.buy(buy), HttpStatus.OK);
	    }

}
