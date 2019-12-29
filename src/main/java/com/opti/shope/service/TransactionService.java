package com.opti.shope.service;

import java.util.List;

import com.opti.shope.shared.dto.TransactionDto;

public interface TransactionService {
	TransactionDto addTransaction( TransactionDto transaction,String userId);
	List<TransactionDto> getTransactionStatement(String userId);
}
