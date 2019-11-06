package com.hcl.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trade.model.UserStocks;

@Repository
public interface UserStocksRepository extends CrudRepository<UserStocks, Integer>{
	
	List<UserStocks> findByUserId(Integer userId);

}
