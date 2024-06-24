package com.example.account.dto;

import com.example.account.type.ErrorCode;
import lombok.*;

/**
 * 에러 응답을 위한 Dto
 * @author 이희영
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private ErrorCode errorCode;

    private String errorMessage;
}
