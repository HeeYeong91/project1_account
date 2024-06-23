package com.example.account.repository;

import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Transaction Repository
 * @author 이희영
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * 트랜잭션 아이디로 트랜잭션 찾기
     * @param transactionId 트랜잭션 아이디
     * @return 트랜잭션
     */
    Optional<Transaction> findByTransactionId(String transactionId);
}
