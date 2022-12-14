---
title: "Form"
linkTitle: "Form"
date: 2020-11-16
type: docs
draft: false
weight: 4
---

웹 페이지에서 사용자 입력을 받는 폼으로 로그인, 등록, 검색, 예약, 쇼핑 등에 사용

작성 방법
---

`form` 태그로 둘러쌈

### name 속성

폼의 이름을 지정

### action 속성

폼 데이터를 처리할 웹 서버 응용프로그램 이름
- `submit`이 눌리면 브라우저는 `action`에 지정된 웹 서버에 실행 요청

### method 속성

폼의 데이터를 웹 서버로 전송하는 형식
- GET/POST


요소
---

- 폼을 만드는 다양한 태그
- `input`, `textarea`, `select` 등

### 텍스트

```html
<input type="text" value="일반 텍스트">
<input type="password" value="비밀번호 형식의 텍스트">
<textarea>이곳에 텍스트가 작성됩니다.</textarea>
```

### 목록

`datalist` 태그
- 목록 리스트를 작성하는 태그
- 네이버 등에서 추천목록 표시에 사용
- `option` 태그로 항목 하나 표현

```html
Countries: <input type="text" list="countries"> <br>
<datalist id ="countries">
  <option value="가나">
  <option value="스위스">
  <option value="브라질">
</datalist>
```

### 버튼

`input`태그나 `button`태그
- type 속성은 버튼의 기능을 정의

```html
<input type="button" name="버튼" value"버튼1">
<button type="button">버튼2</button>

<input type="button" name="버튼" src="이미지">
<button type="button">
  <img src="이미지" alt="이미지버튼">
</button>
```
> 버튼의 type에는 `button`, `reset`, `submit`이 있음

### 선택형 입력

선택형 입력에서는 `checkbox`나 `radio`태그 사용

```html
<form>
짜장면<input type="checkbox|radio" name="요소 이름" value="1">
탕수육<input type="checkbox|radio" name="요소 이름" value="2" checked>   <!-- 체크 -->
짬뽕<input type="checkbox|radio" name="요소 이름" value="3">
</form>
```

### 콤보 박스

`select`태그
- 드롭다운 리스트에 목록 출력
- 목록을 선택하는 입력 방식
- `option` 태그로 항목 하나 표현
> 선택지 이외에 항목 선택 불가

```html
<select name="china">
  <option value="1">짜장면</option>
  <option value="2" selected>탕수육</option>
  <option value="3">짬뽕</option>
</select>
```

### 레이블

폼 요소의 캡션을 정의, 두 가지 방법이 존재
> 캡션: 폼 요소를 한 단위로 묶어 이름을 정의

```html
<label>아이디: <input type="text"></label>

<label for="pass">비밀번호: </label>
<input id="pass" type="password">
```

### 색 입력

```html
<form>
  <input type="color" value="#00BFFF" onchange= "document.body.style.color=this.value">
</form>
```

> html에서의 색 표현은 RGB hex값으로 표기

### 시간 정보

```html
<pre>
  month :<input type="month" value="2016-09"><br>
  week : <input type="week" value="2016-W36"><br>
  data : <input type="date" value="2016-09-01"><br>
  time : <input type="time" value="21:30"><br>
  local:<input type="datetime-local" value="2016-09-01T21:30:10.32"><br>
</pre>
```

### 숫자

- 스핀버튼: `number`
- 슬라이드 바: `range`

```html
<input type="number" min="0.0" max="10.0" step="0.5">

<input type="range" min="0" max="100" list=temperatures>
<datalist id="temperatures">
  <option value="10" label="Low">
  <option value="50" label="Medium">
  <option value="90" label="High">
</datalist>
```

### 입력 정보 힌트

`placeholder` 속성에 사용자가 입력할 데이터 힌트 작성

```html
email: <input type="url" placeholder="id@host">
webpage: <input type="url" placeholder="http://">
phone: <input type="url" placeholder="010-1234-5678">
```

### 그룹핑

`fieldset` 태그로 폼 요소들을 그룹핑하고 `legend`로 그룹 제목 표기
```html
<fieldset>
  <legend>회원정보</legend>
  이메일: <input type="email"><br>
  홈페이지: <input type="url"><br>
  전화번호: <input type="tel">
</fieldset>
```
