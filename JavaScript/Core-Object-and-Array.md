Core Object and Array
===

Contents
---
- [객체](#객체)
  - [구성](#구성)
  - [종류](#종류)
- [코어 객체](#코어-객체)
  - [생성](#생성)
  - [접근](#접근)
  - [종류](#종류)
    - [Date 객체](#date-객체)
- [배열](#배열)
  - [생성방법](#생성방법)
    - [[]로 배열 만들기](#로-배열-만들기)
    - [Array 객체로 만들기](#array-객체로-만들기)
  - [length 프로퍼티](#length-프로퍼티)
    - [원소 개수](#원소-개수)
    - [배열 크기 변경](#배열-크기-변경)
  - [특징](#특징)
  - [주요 메소드](#주요-메소드)

객체
---
### 구성
여러 개의 프로퍼티와 메소드로 구성
- 프로퍼티: 객체의 고유한 속성(변수)
- 메소드: 함수

### 종류
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

배열
---

- 여러 개의 원소들을 연속적으로 저장
- 전체를 하나의 단위로 다루는 데이터 구조

### 생성방법
- `[]`로 배열 만들기
- Array 객체로 만들기

#### []로 배열 만들기
- `[]` 안에는 원소들의 초기값 나열
  ```js
  var week = ["월", "화", "수", "목", "금", "토", "일"]
  var plots = [-20, -5, 0, 15, 20];
  ```
- 배열 크기는 고정적이지 않으며, 원소 추가시 확장

  ```js
  plots[5] = 33; // plots 배열에 6번째 원소 추가. 배열 크기 = 6
  plots[6] = 22; // plots 배열에 7번째 원소 추가. 배열 크기 = 7
  ```

#### Array 객체로 만들기
- 초기 값을 가진 배열 생성
  ```js
  var week = new Array("월", "화", "수", "목", "금", "토", "일");
  ```
- 초기화되지 않은 배열 생성
  ```js
  var week = new Array(7); // 7개의 원소를 가진 배열 생성
  week[0] = “월”;
  week[1] = “화”;
  ...
  week[6] = “일”;
  ```
- 빈 배열 생성
  ```js
  var week = new Array(); // 빈 배열 생성
  week[0] = "월"; // 배열 크기 = 1
  week[1] = "화"; // 배열 크기 = 2
  ```
  > 배열에 원소 추가시 크기가 확장된다.

### length 프로퍼티
#### 원소 개수
배열 크기는 Array 객체의 length 프로퍼티를 사용
```js
var plots = [-20, -5, 0, 15, 20];
var week = new Array("월", "화", "수", "목", "금", "토", "일");
var m = plots.length; // m = 5
var n = week.length; // n = 7
```
#### 배열 크기 변경
- length 프로퍼티는 Array 객체에 의해 자동 관리
- 사용자가 임의로 값 변경 가능
```js
plots.length = 10; // plots의 크기는 5에서 10으로 늘어남
plots.length = 2; // plots의 크기는 2로 줄어 들어, 처음 2개의 원소 외에는 모두 삭제 됨
```

### 특징
- 여러 타입의 데이터 저장 가능
- 배열은 Array 객체
> []로 생성해도 Array 객체로 다루어짐

### 주요 메소드
| 메소드 | 설명  |
| :------------- | :------------- |
| concat(arr)    | 현재 배열에 arr의 원소들을 덧붙여 리턴  |
| join([separator])|배열의 모든 원소를 연결하여 하나의 문자열로 만들어 리턴|
| reverse() | 원소를 역순으로 재배열하고, 이를 복사한 새로운 배열 리턴 |
| slice(a,[b])| 두 인덱스 a, b 사이 원소들로 구성된 새 배열 리턴 |
| sort() | 문자열을 사전 순으로 정렬, 새로운 배열 리턴 |
| toString() | 원소들을 모두 연결하여 문자열 리턴. 원소 사이에 "," 삽입 |
