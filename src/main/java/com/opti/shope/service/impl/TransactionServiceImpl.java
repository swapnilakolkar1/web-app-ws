package com.opti.shope.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.opti.shope.io.entity.PassbookEntity;
import com.opti.shope.io.entity.UserEntity;
import com.opti.shope.repositories.PassbookRepository;
import com.opti.shope.repositories.UserRepository;
import com.opti.shope.service.TransactionService;
import com.opti.shope.shared.dto.TransactionDto;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private PassbookRepository passbookRepo;

	@Autowired
	private UserRepository userRepository;

	private ModelMapper mp = new ModelMapper();

	public TransactionDto addTransaction(TransactionDto transaction, String userId) {
		if (transaction != null && !StringUtils.isEmpty(userId)) {
			UserEntity userDetail = userRepository.findByUserId(userId);
			PassbookEntity passbookEntity = new PassbookEntity();
			Double closingBal = 0.0;

			for (PassbookEntity _transaction : userDetail.getPassbookEntity()) {
				Double trAmount = _transaction.getAmount() != null ? _transaction.getAmount() : 0.0;
				if (_transaction.getCode().equals("CR")) {
					closingBal = Double.sum(closingBal, trAmount);
				} else {
					closingBal = (closingBal - trAmount);
				}
				_transaction.setClosingBal(closingBal);
			}
			if (transaction.getCode().equals("CR")) {
				transaction.setClosingBal(Double.sum(closingBal, transaction.getAmount()));
			} else {// WD
				transaction.setClosingBal(closingBal - transaction.getAmount());
			}

			mp.map(transaction, passbookEntity);
			passbookEntity.setUserEntity(userDetail);
			passbookRepo.save(passbookEntity);
		}

		return transaction;
	}

	@Override
	public List<TransactionDto> getTransactionStatement(String userId) {
		List<TransactionDto> trList=new ArrayList<TransactionDto>();
		List<PassbookEntity> passbookEntries=new ArrayList<PassbookEntity>();
		
		if (!StringUtils.isEmpty(userId)) {
			passbookEntries.addAll(userRepository.findByUserId(userId).getPassbookEntity());
			if(!passbookEntries.isEmpty()) {
				for(PassbookEntity passbookEntry:passbookEntries) {
					TransactionDto transaction= new TransactionDto();
					mp.map(passbookEntry, transaction);
					trList.add(transaction);
				}
			}
		}
		return trList;
	}

}
