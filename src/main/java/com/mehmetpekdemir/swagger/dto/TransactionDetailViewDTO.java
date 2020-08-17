package com.mehmetpekdemir.swagger.dto;

import java.io.Serializable;

import com.mehmetpekdemir.swagger.entity.TransactionDetail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@ApiModel(value = "Transaction Detail View ", description = "All details about the Trancation Detail")
public final class TransactionDetailViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "From Account")
	private final String fromAccount;

	@ApiModelProperty(value = "To Account")
	private final String toAccount;

	@ApiModelProperty(value = "Amount")
	private final Double amount;

	private TransactionDetailViewDTO(String fromAccount, String toAccount, Double amount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	public static TransactionDetailViewDTO of(TransactionDetail transactionDetail) {
		return new TransactionDetailViewDTO(transactionDetail.getFromAccount(), transactionDetail.getToAccount(),
				transactionDetail.getAmount());
	}

}
