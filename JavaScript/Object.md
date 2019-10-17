Object
===

Contents
---
- [구성](#구성)
- [종류](#종류)
- [코어 객체](#코어-객체)
  - [생성](#생성)
  - [접근](#접근)
  - [종류](#종류)
    - [Date 객체](#date-객체)
    - [String 객체](#string-객체)
- [사용자 객체 생성](#사용자-객체-생성)
  - [new Object()](#new-object)
  - [리터럴 표기법](#리터럴-표기법)

구성
---
여러 개의 프로퍼티와 메소드로 구성
- 프로퍼티: 객체의 고유한 속성(변수)
- 메소드: 함수

종류
---
자바스크립트는 객체 기반 언어
> 객체 지향 언어는 아님

- 코어 객체
  - 자바스크립트 언어가 실행되는 어디서나 사용 가능한 기본 객체
  - 기본 객체로 표준 객체
  - Array, Date, String, Math 타입 등
- HTML DOM 객체
  - HTML 문서에서 작성된 각 HTML 태그들을 객체화 한 것
  - HTML 문서의 내용과 모양을 제어하기 위한 목적
- 브라우저 객체
  - 자바스크립트로 브라우저를 제어하기 위해 제공되는 객체
  - BOM을 따르는 객체

코어 객체
---

Array, Date, String, Math 등

### 생성
```js
var today = new Date();
var msg = new String("Hello");
```
객체가 생성되면 객체 내부에 프로퍼티와 메소드들이 존재한다.
### 접근
객체와 멤버 사이에 점(.) 연산자 이용
```js
obj.프로퍼티 = 값; // 객체의 프로퍼티 값 변경
변수 = obj.프로퍼티; // 객체 onh의 프로퍼티 값 가져오기
obj.메소드(매개변수); // 객체 obj의 메소트 호출
```

### 종류
#### Date 객체
- 시간 정보를 담는 객체
- 현재 시간 정보
  ```js
  var now = new Date(); // 현재 날짜와 시간(시, 분, 초)
  var date = now.getDate(); // 오늘 날짜. date = 15
  var hour = now.getHours(); // 지금 시간. hour = 20
  ```
- 특정 시간 정보
  ```js
  var startDay = new Date(2017, 2, 1);
  ```
> 월 값은 '0'부터 시작

#### String 객체
문자열을 담기 위한 객체

```js
var hello = new String("Hello");
var res = hello.concat("Javascript");
// concat() 후 hello의 문자열 변화 없음
```
> String 객체는 일단 생성되면 수정 불가능

**특징**
- 문자열 길이
  ```js
  var hello = new String(“Hello”);
  var every = “Boy and Girl”;

  var m = hello.length; // m은 5
  var n = every.length; // n은 12
  var n = "Thank you".length; // n은 9
  ```
  > String 객체의 length 프로퍼티 : 읽기 전용

- 문자열을 배열처럼 사용
  ```js
  var hello = new String("Hello");
  var c = hello[0]; // c = "H". 문자 H가 아니라 문자열 “H”
  ```
  > [] 연산자를 사용하여 각 문자 접근

**String 메소드**

| 메소드                     | 설명                                                                                                                       |
|:---------------------------|:---------------------------------------------------------------------------------------------------------------------------|
| charAt(index)              | 인덱스 idx에 있는 문자를 문자열로 만들어 리턴                                                                              |
| charCodeAt(index)          | 인덱스 idx에 있는 문자의 16비트 유니코드 값 리턴                                                                           |
| concat(s1, s2, ..., sN)    | 현재 문자열 뒤에 문자열 s1,s2,...sN을 순서대로 연결한 새로운 문자 열 리턴                                                  |
| indexOf(s[,idx])           | 인덱스 idx 위치부터 문자열 s가 처음으로 나타나는 인텍스 리턴, idx가 생략되면 처음부터 검색. 발견할 수 없으면 -1 리턴       |
| replace(strA,strB)         | 문자열 strA를 찾아 strB로 수정한 새로운 문자열 리턴                                                                        |
| slice(iidxA[,idxB])        | 인덱스 idxA에서 idxB 앞까지 문자열을 복사하여 리턴, idxB가 생략되면 idxA에서 끝까지 리턴                                   |
| split([separator[,limit]]) | Separator 문자열을 구분자로 하여 문자열을 분리하여 문자열 배열을 만들어 리턴. Limit는 리턴하는 배열의 크기를 제한하는 정수 |
| substr(idxA[,len])         | 인덱스 idxA에서부터 len 문자 개수만큼 새로운 문자열 리턴. Len이 생략되면 문자열 끝까지 리턴                                |
| substring(idxA,idxB)       | idxA에서 idxB 앞까지 두 인덱스 사이의 문자열 리턴                                                                          |
| trim()                     | 문자열의 앞뒤 공백 문자(빈칸, 탭, 엔터키)를 제거한 새로운 문자열 리 턴                                                     |
| toLowerCase()              | 소문자로 변환된 새로운 문자열 리턴                                                                                         |
| toUpperCase()              | 대문자로 변환된 새로운 문자열 리턴                                                                                         |
| fromCharCode(char)         | char의 문자를 문자열로 만들어 리턴                                                                                         |

#### Math 객체
- 수학 계산을 위한 프로퍼티와 메소드 제공
- new Math()로 객체 생성하지 않고 사용
  ```js
  var sq = Math.sqrt(4); // 4의 제곱근을 구하면 2
  var area = Math.PI*2*2; // 반지름이 2인 원의 면적
  ```

- 난수 발생
  - Math.random() : 0~1사이의 랜덤한 실수 리턴
  - Math.floor(m)은 m의 소수점 이하를 제거한 정수 리턴
  ```js
  // 0~99까지 랜덤한 정수를 10개 만드는 코드
  for(i=0; i<10; i++) {
  var m = Math.random()*100; // m은 0~99.999... 보다 작은 실수 난수
  var n = Math.floor(m); // m에서 소수점 이하를 제거한 정수(0~99사이)
  document.write(n + " ");
  }
  ```

**주요 메소드**
| 메소드   | 설명                                      |
|:---------|:------------------------------------------|
| abs(x)   | x의 절대값 리턴                           |
| sin(x)   | 싸인 x 값 리턴                            |
| exp(y)   | e^y 값 리턴                               |
| pow(x,y) | x^y 값 리턴                               |
| random() | 0~1보다 작은 임의의 실수 리턴             |
| floor(x) | x보다 작거나 같은 수 중 가장 큰 정수 리턴 |
| round(x) | x를 반올림한 정수 리턴                    |
| sqrt(x)  | x의 제곱근 리턴                           |
> x와 y는 정수/실수 가능

사용자 객체 생성
---
- 직접 객체 만들기
  - new Object() 이용: 자바스크립트 코어 객체 중 Object타입 이용
  - 리터럴 표기법 이용
- 객체의 틀(프로토타입)을 만들고 객체 생성하기

### new Object()
- new Object()로 빈 객체 생성
- 빈 객체에 프로퍼티 추가
  - 새로운 프로퍼티 추가(프로퍼티 이름과 초기값 지정)
- 빈 객체에 메소드 추가
  - 메소드로 사용할 함수 미리 작성
  - 새 메소드 추가(메소드 이름에 함수 지정)

```js
//메소드로 사용할 3 개의 함수 작성
function inquiry() { return this.balance; } // 잔금 조회
function deposit(money) { this.balance += money; } // money 만큼 저금
function withdraw(money) { // 예금 인출, money는 인출하고자 하는 액수
// money가 balance보다 작다고 가정
  this.balance -= money;
  return money;
}
// 사용자 객체 만들기
var account = new Object();
account.owner = "반정훈"; // 계좌 주인 프로퍼티 생성 및 초기화
account.code = "111"; // 코드 프로퍼티 생성 및 초기화
account.balance = 35000; // 잔액 프로퍼티 생성 및 초기화
account.inquiry = inquiry; // 메소드 작성
account.deposit = deposit; // 메소드 작성
account.withdraw = withdraw; // 메소드 작성
```

### 리터럴 표기법
중괄호를 이용하여 객체의 프로퍼티와 메소드를 한 번에
작성 가능, 가독성이 높다

```js
var account = {
  // 프로퍼티 생성 및 초기화
  owner : "반정훈", // 계좌 주인 프로퍼티 추가
  code : "111", // 계좌 코드 프로퍼티 추가
  balance : 35000, // 잔액 프로퍼티 추가

  // 메소드 작성
  inquiry : function () { return this.balance; }, // 잔금 조회
  deposit : function(money) { this.balance += money; }, // 저금. money 만큼 저금
  withdraw : function (money) { // 예금 인출, money는 인출하고자 하는 액수
  // money가 balance보다 작다고 가정
    this.balance -= money;
    return money;
  }
};
```
