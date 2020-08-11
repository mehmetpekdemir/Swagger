package com.mehmetpekdemir.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.swagger.dto.TransactionDetailCreateDTO;
import com.mehmetpekdemir.swagger.dto.TransactionDetailViewDTO;
import com.mehmetpekdemir.swagger.service.TransactionDetailService;
import com.mehmetpekdemir.swagger.util.GenericResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor // Constructor Injection with lombok
@Api(value = "Transaction Detail Api")
public class TransactionDetailAPI {

	private final TransactionDetailService transactionDetailService;

	@ApiOperation(value = "View a list of available trancation details", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/v1/transaction/details")
	public ResponseEntity<List<TransactionDetailViewDTO>> getTransactionDetails() {

		final List<TransactionDetailViewDTO> transactionDetails = transactionDetailService.getTransactionDetails();
		return ResponseEntity.ok(transactionDetails);
	}

	@ApiOperation(value = "Get a transaction detail by id")
	@GetMapping("/v1/transaction/detail/{id}")
	public ResponseEntity<TransactionDetailViewDTO> getTransactionDetailById(
			@ApiParam(value = "Transaction detail id from which trancation detail object will retrieve", required = true) @PathVariable("id") Long id) {

		final TransactionDetailViewDTO transactionDetail = transactionDetailService.getTransactionDetailById(id);
		return ResponseEntity.ok(transactionDetail);
	}

	@ApiOperation(value = "Create transaction detail")
	@PostMapping("/v1/transaction/detail")
	public ResponseEntity<?> createTransactionDetail(
			@Valid @RequestBody @ApiParam(value = "Transaction detail object store in database table", required = true) TransactionDetailCreateDTO transactionDetailCreateDTO) {

		transactionDetailService.createTransactionDetail(transactionDetailCreateDTO);
		return ResponseEntity.ok(new GenericResponse("Transaction Detail Created."));
	}

}
