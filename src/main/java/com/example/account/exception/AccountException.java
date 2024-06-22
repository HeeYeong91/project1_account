package com.example.account.exception;

import com.example.account.type.ErrorCode;
import lombok.*;

/**
 * Custom Exception
 * @author 이희영
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountException extends RuntimeException {

    private ErrorCode errorCode;

    private String errorMessage;

    public AccountException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
