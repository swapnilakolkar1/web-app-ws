package com.opti.shope.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opti.shope.io.entity.PassbookEntity;
import com.opti.shope.service.TransactionService;
import com.opti.shope.shared.dto.TransactionDto;
import com.opti.shope.ui.model.request.TransactionDetailRquestModel;
import com.opti.shope.ui.model.response.TransactionRest;

@RestController
@RequestMapping("/transaction")
public class UserTransactionController {

	@Autowired
	private TransactionService transactionService;

	private ModelMapper mp = new ModelMapper();

	@GetMapping(path = "/{userId}")
	public List<TransactionRest> transaction(@PathVariable String userId) {

		List<TransactionRest> transactionList = new ArrayList<>();

		if (userId != null) {
			List<TransactionDto> trList = transactionService.getTransactionStatement(userId);
			for(TransactionDto transaction:trList) {
				TransactionRest trObj= new TransactionRest();
				mp.map(transaction, trObj);
				transactionList.add(trObj);
			}
		}
		return transactionList;
	}

	@PostMapping(path = "/{userId}")
	public String addTransaction(@RequestBody TransactionDetailRquestModel trDetailModel, @PathVariable String userId) {
		TransactionDto trDto = new TransactionDto();
		mp.map(trDetailModel, trDto);

		transactionService.addTransaction(trDto, userId);
		return userId;
	}
}
