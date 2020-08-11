package com.mehmetpekdemir.swagger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@ApiModel(value = "Transaction Detail Create ",description = "All details about the Trancation Detail Create")
public class TransactionDetailCreateDTO {

	@NotNull
	@Size(min = 4, max = 32)
	@ApiModelProperty(value = "From Account")
	private String fromAccount;

	@NotNull
	@Size(min = 4, max = 32)
	@ApiModelProperty(value = "To Account")
	private String toAccount;

	@NotNull
	@Positive
	@ApiModelProperty(value = "Amount")
	private Double amount;

}
