package com.mehmetpekdemir.swagger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction_details")
public class TransactionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "from_account", length = 50, nullable = false)
	private String fromAccount;

	@Column(name = "to_account", length = 50, nullable = false)
	private String toAccount;

	@Column(name = "amount", length = 50, nullable = false)
	private Double amount;

	public TransactionDetail(String fromAccount, String toAccount, Double amount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

}
