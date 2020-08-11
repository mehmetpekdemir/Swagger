package com.mehmetpekdemir.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehmetpekdemir.swagger.entity.TransactionDetail;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

}
