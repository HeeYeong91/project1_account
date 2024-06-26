package com.example.account.repository;

import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Account User Repository
 * @author 이희영
 */
@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {
}
