package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Account Repository
 * @author 이희영
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * 최근 생성 된 계좌 정보 가져오기
     * @return 계좌 정보
     */
    Optional<Account> findFirstByOrderByIdDesc();

    /**
     * 계좌 수 가져오기
     * @param accountUser 유저
     * @return 계좌 수
     */
    Integer countByAccountUser(AccountUser accountUser);

    /**
     * 계좌 번호로 계좌 찾기
     * @param accountNumber 계좌 번호
     * @return 계좌 정보
     */
    Optional<Account> findByAccountNumber(String accountNumber);

    /**
     * 유저로 계좌 찾기
     * @param accountUser 유저
     * @return 계좌 리스트
     */
    List<Account> findByAccountUser(AccountUser accountUser);
}
