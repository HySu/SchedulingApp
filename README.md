# SchedulingApp

## 개요
일정 관리 앱에 대한 API 명세서 작성
스파르타코딩클럽에서 내준 과제로 일정 관리 앱에 대한 API 명세서를 작성한다.

## API 소개
일정 관리 앱에 대한 API 명세서를 작성하여 문서를 보고 프로그래밍 할 수 있게 한다.

### API 명세서
|기능|Method|URL|request|response|상태 코드|
|---|---|---|---|---|---|
|일정 등록|POST|/api/schedules|요청 body|등록 정보|200:OK|
|전체 일정 조회|GET|/api/schedules|없음|전체 응답 정보|200:OK, 400: Bad Request, 404:NOT FOUND|
|선택 일정 조회|GET|/api/schedules/{id}|없음|단건 응답 정보|200:OK, 404:NOT FOUND|
|일정 수정|PUT|/api/schedules/{id}|요청 body|수정 정보|200:OK, 400: Bad Request, 404:NOT FOUND|
|일정 삭제|DELETE|/api/schedules/{id}|없음|-|200:OK, 404:NOT FOUND|

### 일정 등록
#### 요청
- 기능 : 일정 등록
- Method : POST
- URL : /api/schedules
- 요청 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|username|String|varchar(20)|사용자 이름|O|
|title|String|varchar(255)|일정 이름|O|
|contents|String|varchar(255)|일정 내용|O|
|password|String|varchar(255)|비밀번호|O|
|createdScheduleDate|LocalDateTime|-|만들어진 시간|O|
|modifyScheduleDate|LocalDateTime|-|수정된 시간|O|

- Request : 요청 body
    - 요청 body(JSON) 에 대한 JSON 코드
```html
예시)
{
    "username" : "HYUNSU",
    "title" : "첫 번째 일정 등록",
    "contents" : 스파르타코딩클럽 1주차 강의 듣기,
    "password" : "abc123",
    "createdScheduleDate" : "2020-11-05 09:00:00",
    "modifyScheduleDate" : "2020-11-05 09:00:00"
}
```


#### 응답
- 응답 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|id|Bigint|-|일정 번호|O|
|username|String|varchar(20)|사용자 이름|O|
|title|String|varchar(255)|일정 제목|O|
|contents|String|varchar(255)|일정 내용|O|
|created_schedule_date|LocalDateTime|-|만든 날짜와 시간|O|
|modify_schedule_date|LocalDateTime|-|수정 날짜와 시간|O|


- response : 응답 body(JSON)
    - 응답 body(JSON) 에 대한 JSON 키-벨류 값
```html
예시)
{
    "id" : 1,
    "username" : "hyunsu",
    "title" : "안녕하세요",
    "contents" : "저는 배가 부릅니다.",
    "created_schedule_date" : "2024-11-04 17:14:40",
    "modify_schedule_date" : "2024-11-04 17:14:40"
}
```
- 상태 코드 : 200: OK



### 전체 일정 조회
#### 요청
- 기능 : 전체 일정 조회
- Method : GET
- URL : /api/schedules
- Request : 없음
- Response : 전체 응답 정보
- 상태 코드 : 200: OK, 400: Bad Request, 404: NOT FOUND

#### 응답
- response : 응답 body(JSON)
    - 응답 body(JSON) 에 대한 JSON 키-벨류 값
- 응답 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|id|Bigint|-|일정 번호|O|
|username|String|varchar(20)|사용자 이름|O|
|title|String|varchar(255)|일정 이름|O|
|contents|String|varchar(255)|할 일, 일정 내용|O|
|createdScheduleDate|LocalDateTime|-|만들어진 시간|O|
|modifyScheduleDate|LocalDateTime|-|수정된 시간|O|

```html
예시)
[
    {    "id": 1,
         "username": "HYUNSU",
         "title": "제목1",
         "contents": "내용1",
         "createdScheduleDate": "2024-10-31 09:00:00",
         "modifyScheduleDate": "2024-11-01 09:00:00
    },
    {    "id": 2,
         "username": "jihyun",
         "title": "제목2",
         "contents": "내용2",
         "createdScheduleDate" : "2024-10-31 09:00:00",
         "modifyScheduleDate":"2024-11-01 09:00:00"
    },
]
```
- 상태 코드 : 200:OK, 400: Bad Request, 404:NOT FOUND


### 선택 일정 조회
#### 요청
- 기능 : 선택 일정 조회
- Method : GET
- URL : /api/schedules/{id}
- Request : 없음 
- Response : 단건 응답 정보
- 상태 코드 : 200: OK, 404: NOT FOUND

#### 응답
- response : 응답 body(JSON)
    - 응답 body(JSON) 에 대한 JSON 키-벨류 값
- 응답 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|id|Bigint|-|일정 번호|O|
|username|String|varchar(20)|사용자 이름|O|
|title|String|varchar(255)|일정 제목|O|
|contents|String|varchar(255)|일정 내용|O|
|created_schedule_date|LocalDateTime|-|만든 시간|O|
|modify_schedule_date|LocalDateTime|-|수정한 시간|O|

```html
예시)
{
    "id": 1,
    "username": "HYUNSU",
    "title": "제목1",
    "contents": "내용1",
    "createdScheduleDate": "2024-10-31 09:00:00",
    "modifyScheduleDate": "2024-11-01 09:00:00"
}
```
- 상태 코드 : 200:OK, 404:NOT FOUND

### 일정 수정
#### 요청
- 기능 : 일정 수정
- Method : PUT
- URL : /api/schedules/{id}
- Request : 요청 body
- 추가 설명 : {id} 는 URL에서 PathVariable 값을 갖는다. URL 에서 PathVariable 로 넘겨주기 때문에 클라이언트 JSON 값으로 넘겨줄 필요가 없다.
- 요청 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|id|Bigint|-|일정 ID|O|
|title|String|varchar(255)|일정 이름|O|
|contents|String|varchar(255)|일정 내용|O|
|password|String|varchar(255)|비밀번호|O|
```html
예시)
{
    "id" : 1,
    "title" : "두 번째 일정",
    "contents" : "스파르타코딩클럽 Spring 강의 듣기",
    "password" : "abc123"
}
```

#### 응답
- Response : 응답 body(JSON)
    - 응답 body(JSON) 에 대한 JSON 키-벨류 값

- 응답 JSON 값에 대한 설명

|이름|타입|최대글자수|설명|필수|
|---|---|---|---|---|
|id|Bigint|-|일정 ID|O|
|title|String|varchar(255)|일정 이름|O|
|contents|String|varchar(255)|일정 내용|O|
|created_schedule_date|LocalDateTime|-|만든 시간|O|
|modify_schedule_date|LocalDateTime|-|수정한 시간|O|

```html
예시)
{
    "id" : 1,
    "title" : "두 번째 일정",
    "contents" : "스파르타코딩클럽 Spring 강의 듣기",
    "created_schedule_date" : "2024-11-04 17:14:40",
    "modify_schedule_date" : "2024-11-04 17:14:40"
}
```
- 상태 코드 : 200:OK, 400: Bad Request, 404:NOT FOUND

  
### 일정 삭제
#### 요청
- 기능 : 일정 삭제
- Method : DELETE
- URL : /api/schedules/{id}
- Request : 없음
- Response : 수정 정보
- 상태 코드 : 200: OK, 404: NOT FOUND
- 추가 설명 : {id} 는 URL에서 PathVariable 값을 갖는다. URL 에서 PathVariable 로 넘겨주기 때문에 클라이언트 JSON 값으로 넘겨줄 필요가 없다.

#### 응답
- Response : 응답 body
- 반환값 없음
- 상태 코드 : 200: OK, 404: NOT FOUND


## ERD
![제목 없음](https://github.com/user-attachments/assets/76ed2673-5b23-4367-8520-04c26e9a1b84)

## SQL 작성하기
- 필수 기능 가이드 개발에 필요한 테이블을 생성하는 query를 작성
    - `Create`

```html
CREATE TABLE Schedules
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    title VARCHAR(255) NOT NULL,
    contents VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_schedule_date LocalDateTime,
    modify_schedule_date LocalDateTime
);
```

- 일정 생성을 하는 query를 작성
    - `Insert`
```html
- Schedules 테이블
    INSERT INTO Schedules (title, contents, password, created_schedule_date, modify_schedule_date)
    VALUES ('Schedule1', 'contents', 'abc123', '2024-10-10 10:00:00', '2024-10-12 10:00:00');
```
- 전체 일정을 조회하는 query를 작성
    - `Select`
```html
- Schedules 테이블
    SELECT *
    FROM User
    WHERE username='hyunsu' AND (modify_schedule_date BETWEEN '2024-10-31 09:00:00' AND NOW())
    ORDER BY modify_schedule_date DESC;
```

- 선택 일정을 조회하는 query를 작성
    - `Select`
```html
    SELECT *
    FROM Schedules
    WHERE id = 1;
```

- 선택한 일정을 수정하는 query를 작성
    - `Update`
```html
- Schedules 테이블
    UPDATE Schedules
    SET title = 'Modify title', contents = 'Modify contents', modify_schedule_date = NOW()
    WHERE id = 1;
```

- 선택한 일정을 삭제하는 query를 작성
    - `Delete`
```html
- Schedules 테이블
    DELETE FROM Schedules
    WHERE id = 1;
```
