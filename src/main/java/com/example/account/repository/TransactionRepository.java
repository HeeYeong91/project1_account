package com.example.account.repository;

import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Transaction Repository
 * @author 이희영
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    
}
