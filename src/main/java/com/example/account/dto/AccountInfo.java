package com.example.account.dto;

import lombok.*;

/**
 * 계좌 조회
 * 사용자에게 응답을 주기 위한 Dto
 * 계좌 번호와 잔액
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {

    private String accountNumber;

    private Long balance;
}
