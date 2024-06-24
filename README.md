# :bank: 계좌 관리 시스템
<br />

## :page_facing_up: 목차
1. 프로젝트 소개
2. 프로젝트 기능
   * [1. 계좌 생성 API](#1-계좌-생성-API)
   * [2. 계좌 해지 API](#2-계좌-해지-API)
   * [3. 계좌 확인 API](#3-계좌-확인-API)
   * [4. 잔액 사용 API](#4-계좌-사용-API)
   * [5. 잔액 사용 취소 API](#5-잔액-사용-취소-API)
   * [6. 거래 확인 API](#6-거래-확인-API)
<br />

## :eyes: 1. 프로젝트 소개
1차 실습 프로젝트 Spring boot와 Java를 활용하여 Account 시스템 만드는 프로젝트 <br />

사용자와 계좌의 정보를 저장하고 외부 시스템에서 거래를 요청할 경우 <br />
거래 정보를 받아서 계좌에서 잔액을 거래금액만큼 줄이거나(결제), <br />
거래금액만큼 늘리는(결제 취소) 거래 관리 기능을 제공하는 시스템입니다. <br />
<br />

:smile: 개발 인원 : 1명 <br />
:calendar: 프로젝트 기간 : 2024년 6월 20일 ~ 2024년 6월 24일 <br />
:hammer: Tools : ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) 
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)<br />
:books: languages : ![Spring](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white) 
![Java](https://img.shields.io/badge/JSP-%23ED8B00.svg?style=for-the-badge&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Junit5](https://img.shields.io/badge/Junit5-%23C21325?style=for-the-badge&logo=junit5&logoColor=white)
![H2](https://img.shields.io/badge/H2Database-4479A1.svg?style=for-the-badge) 
![Jpa](https://img.shields.io/badge/Jpa-%236DB33F.svg?style=for-the-badge)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-e0e0e0?style=for-the-badge)
![Lombok](https://img.shields.io/badge/Lombok-%23ffffff.svg?style=for-the-badge) <br />
<br />

프로젝트 엔티티 구조
![Account](https://github.com/HeeYeong91/project1_account/assets/139057065/49c82e00-2bac-4f70-828e-874ab1e0b397) <br />


## :pushpin: 2. 프로젝트 기능
## API 명세
![계좌관련API](https://github.com/HeeYeong91/project1_account/assets/139057065/0d41120b-7a5c-4298-8b63-544bbf1b1b7b) <br />
![거래관련API](https://github.com/HeeYeong91/project1_account/assets/139057065/4c404c8c-6947-42d8-bb6e-c3a0d48513f2) <br />

<br />

## 1. 계좌 생성 API
![계좌생성](https://github.com/HeeYeong91/project1_account/assets/139057065/8246ad69-af34-4d13-9fea-702264a198dd) <br />
:exclamation: 정책 : <br />
사용자가 없는 경우 - 생성 실패 (USER_NOT_FOUND),<br />
계좌가 10개인 경우(사용자당 최대 보유 가능 계좌 수) - 생성 실패 (MAX_COUNT_PER_USER_10)<br />
<br />

## 2. 계좌 해지 API
![계좌해지](https://github.com/HeeYeong91/project1_account/assets/139057065/2d04a5e9-a67d-4e95-b746-7ce05e90a91d) <br />
:exclamation: 정책 : <br />
사용자가 없는 경우 - 해지 실패 (USER_NOT_FOUND),<br />
계좌가 없는 경우 - 해지 실패 (ACCOUNT_NOT_FOUND),<br />
사용자 아이디와 계좌 소유주가 다른 경우 - 해지 실패 (USER_ACCOUNT_UN_MATCH),<br />
계좌가 이미 해지 상태인 경우 - 해지 실패 (ACCOUNT_ALREADY_UNREGISTERED),<br />
잔액이 있는 경우 - 해지 실패 (BALANCE_NOT_EMPTY)<br />
<br />

## 3. 계좌 확인 API
![계좌조회](https://github.com/HeeYeong91/project1_account/assets/139057065/23980b21-51b4-4dc7-8c3c-a2833370b5f2) <br />
:exclamation: 정책 : <br />
사용자가 없는 경우 - 확인 실패 (USER_NOT_FOUND)<br />
<br />

## 4. 잔액 사용 API
![잔액사용](https://github.com/HeeYeong91/project1_account/assets/139057065/4df9dee5-7f26-414e-a48b-76d7a2b975a7) <br />
:exclamation: 정책 : <br />
사용자가 없는 경우 - 사용 실패 (USER_NOT_FOUND),<br />
계좌가 없는 경우 - 사용 실패 (ACCOUNT_NOT_FOUND),<br />
사용자 아이디와 계좌 소유주가 다른 경우 - 사용 실패 (USER_ACCOUNT_UN_MATCH),<br />
계좌가 이미 해지 상태인 경우 - 사용 실패 (ACCOUNT_ALREADY_UNREGISTERED),<br />
거래금액이 잔액보다 큰 경우 - 사용 실패 (AMOUNT_EXCEED_BALANCE)<br />
<br />

## 5. 잔액 사용 취소 API
![잔액사용취소](https://github.com/HeeYeong91/project1_account/assets/139057065/36f40498-daf6-4903-bdb4-df7365261777) <br />
:exclamation: 정책 : <br />
거래가 없는 경우 - 취소 실패 (TRANSACTION_NOT_FOUND),<br />
계좌가 없는 경우 - 취소 실패 (ACCOUNT_NOT_FOUND),<br />
거래와 계좌가 일치하지 않는 경우 - 취소 실패 (TRANSACTION_ACCOUNT_UN_MATCH),<br />
거래금액과 거래취소금액이 다른 경우(부분 취소 불가능) - 취소 실패 (CANCEL_MUST_FULLY),<br />
1년이 넘은 거래는 사용 취소 불가능 - 취소 실패 (TOO_OLD_ORDER_TO_CANCEL)<br />
<br />

## 6. 거래 확인 API
![잔액사용확인](https://github.com/HeeYeong91/project1_account/assets/139057065/5c98257c-0902-49cf-ba07-49c47b7d1115) <br />
:exclamation: 정책 : <br />
거래가 없는 경우 - 확인 실패 (TRANSACTION_NOT_FOUND)<br />
<br />

