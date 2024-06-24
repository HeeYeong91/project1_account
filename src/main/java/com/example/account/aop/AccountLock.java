package com.example.account.aop;

import java.lang.annotation.*;

/**
 * Custom Annotation
 * 동시성 문제 해결을 위해 Redis 사용
 * @author 이희영
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AccountLock {

    long tryLockTime() default 5000L;
}
