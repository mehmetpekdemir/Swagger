package com.mehmetpekdemir.swagger.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekdemir.swagger.dto.TransactionDetailCreateDTO;
import com.mehmetpekdemir.swagger.dto.TransactionDetailViewDTO;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TransactionDetailService {
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	List<TransactionDetailViewDTO> getTransactionDetails();
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	TransactionDetailViewDTO getTransactionDetailById(Long id);

	TransactionDetailViewDTO createTransactionDetail(TransactionDetailCreateDTO transactionDetailCreateDTO);

}
