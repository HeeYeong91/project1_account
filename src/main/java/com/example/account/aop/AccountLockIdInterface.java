package com.example.account.aop;

/**
 * Account Lock Id Interface
 * UseBalance와 CancelBalance의 Request에서
 * accountNumber를 가져오기 위한 인터페이스
 * @author 이희영
 */
public interface AccountLockIdInterface {

    String getAccountNumber();
}
