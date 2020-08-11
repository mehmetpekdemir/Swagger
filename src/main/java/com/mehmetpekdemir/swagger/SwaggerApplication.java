package com.mehmetpekdemir.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mehmetpekdemir.swagger.dto.TransactionDetailCreateDTO;
import com.mehmetpekdemir.swagger.service.TransactionDetailService;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialTransactionDetail(TransactionDetailService transactionDetailService) {
		return (args) -> {

			TransactionDetailCreateDTO transactionDetail = new TransactionDetailCreateDTO();
			transactionDetail.setFromAccount("Test From Account");
			transactionDetail.setToAccount("Test To Account");
			transactionDetail.setAmount((double) 5000);
			transactionDetailService.createTransactionDetail(transactionDetail);

			TransactionDetailCreateDTO transactionDetail1 = new TransactionDetailCreateDTO();
			transactionDetail1.setFromAccount("Test From Account2");
			transactionDetail1.setToAccount("Test To Account2");
			transactionDetail1.setAmount((double) 950000000.23);
			transactionDetailService.createTransactionDetail(transactionDetail1);

			TransactionDetailCreateDTO transactionDetai2 = new TransactionDetailCreateDTO();
			transactionDetai2.setFromAccount("Test From Account");
			transactionDetai2.setToAccount("Test To Account");
			transactionDetai2.setAmount((double) 399.99);
			transactionDetailService.createTransactionDetail(transactionDetai2);

		};
	}

}
