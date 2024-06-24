package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.dto.AccountInfo;
import com.example.account.dto.CreateAccount;
import com.example.account.dto.DeleteAccount;
import com.example.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 계좌 관련 컨트롤러
 * 1. 계좌 생성
 * 2. 계좌 해지
 * 3. 유저 아이디로 계좌 조회
 * @author 이희영
 */
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * 계좌 생성
     *
     * @param request 생성 요청
     * @return 생성 응답
     */
    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody
            @Valid
            CreateAccount.Request request
    ) {
        return CreateAccount.Response.from(
                accountService.createAccount(
                        request.getUserId(),
                        request.getInitialBalance())
        );
    }

    /**
     * 계좌 해지
     * 
     * @param request 해지 요청
     * @return 해지 응답
     */
    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
            @RequestBody
            @Valid
            DeleteAccount.Request request
    ) {
        return DeleteAccount.Response.from(
                accountService.deleteAccount(
                        request.getUserId(),
                        request.getAccountNumber())
        );
    }

    /**
     * 유저 아이디로 계좌 조회
     * 
     * @param userId 유저 아이디
     * @return 계좌 리스트
     */
    @GetMapping("/account")
    public List<AccountInfo> getAccountsByUserId(
            @RequestParam("user_id")
            Long userId
    ) {
        return accountService.getAccountsByUserId(userId)
                .stream().map(accountDto -> AccountInfo.builder()
                        .accountNumber(accountDto.getAccountNumber())
                        .balance(accountDto.getBalance())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/account/{id}")
    public Account getAccount(
            @PathVariable
            Long id
    ) {
        return accountService.getAccount(id);
    }
}
