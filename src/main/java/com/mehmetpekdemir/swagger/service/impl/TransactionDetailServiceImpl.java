package com.mehmetpekdemir.swagger.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mehmetpekdemir.swagger.dto.TransactionDetailCreateDTO;
import com.mehmetpekdemir.swagger.dto.TransactionDetailViewDTO;
import com.mehmetpekdemir.swagger.entity.TransactionDetail;
import com.mehmetpekdemir.swagger.exception.TransactionDetailNotFoundException;
import com.mehmetpekdemir.swagger.repository.TransactionDetailRepository;
import com.mehmetpekdemir.swagger.service.TransactionDetailService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor // Constructor Injection with lombok
public class TransactionDetailServiceImpl implements TransactionDetailService {

	private final TransactionDetailRepository transactionDetailRepository;

	@Override
	public List<TransactionDetailViewDTO> getTransactionDetails() {
		return transactionDetailRepository.findAll().stream().map(TransactionDetailViewDTO::of)
				.collect(Collectors.toList());
	}

	@Override
	public TransactionDetailViewDTO getTransactionDetailById(Long id) {
		final TransactionDetail transactionDetail = transactionDetailRepository.findById(id)
				.orElseThrow(() -> new TransactionDetailNotFoundException(
						String.format("Transaction detail not found with ID %d, id")));

		return TransactionDetailViewDTO.of(transactionDetail);
	}

	@Override
	public TransactionDetailViewDTO createTransactionDetail(TransactionDetailCreateDTO transactionDetailCreateDTO) {

		final TransactionDetail transactionDetail = transactionDetailRepository
				.save(new TransactionDetail(transactionDetailCreateDTO.getFromAccount(),
						transactionDetailCreateDTO.getToAccount(), (double) transactionDetailCreateDTO.getAmount()));

		return TransactionDetailViewDTO.of(transactionDetail);
	}

}
