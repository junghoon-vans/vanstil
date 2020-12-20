---
title: "Introduction"
linkTitle: "Introduction"
date: 2020-11-16
type: docs
draft: false
weight: 1
---

HTML 언어의 역사
---

-	1990년 물리학자인 Tim Berners-Lee가 정의
-	표준화된 태그로 웹 페이지를 작성하는 언어
-	HTML, CSS, JavaScripts, 웹 브라우저의 타임라인

HTML5 출현 배경
---

1.	비표준 기술의 혼재, 웹 브라우저의 비호환성

	-	Active-X나 플러그인, 플래시 등 비표준 기술 난립

	-	브라우저 사이에 HTML문서와 웹 자원에 대한 심각한 비호환성

2.	인터넷 기기의 다양화

	-	PC, 모바일 단말기 등에서 모두 웹 사용

	-	기존의 웹 페이지가 모바일에서 작동하지 않음

3.	새로운 범용 웹 표준의 필요성

	-	<strong>HTML5 탄생</strong>

HTMl5 표준과 의의
---

### HTML5 표준 제정

-	W3C와 하이퍼텍스트 워킹 그룹
-	표준에 담긴 내용

	-	웹 페이지의 구조는 HTML5 태그로, 웹 페이지의 모양은 CSS3로, 웹 페이지의 행동은 JavaScript로 분리 개발

-	HTML태그에서 문서의 모양과 관계된 태그나 속성 파기

-	웹 페이지의 플랫폼이나 장치 의존성 제거

HTML5의 기능
---

### HTML5 전체 기능

-	웹 문서 작성을 위한 HTML 태그셋
	-	문서 모양을 표현하는 태그 속성 청산
	-	구조를 명확히 표현하는 시맨틱 태그 추가
-	웹 애플리케이션 작성을 위한 자바스크립트 API 표준화

### HTML5 기능 요약

-	웹 폼
-	오디오, 비디오
-	캔버스 - 자바스크립트 사용 웹브라우저 상 동적 2, 3차원 그래픽
-	SVG - XML로 표현하는 2차원 벡터 그래픽 API
-	웹 스토리지 - 웹 브라우저 실행 로컬 컴퓨터에 데이터 저장 API
-	웹 SQL 데이터베이스
-	인덱스 데이터베이스
-	파일 입출력
-	웹 워커 - 백그라운드 작업 만들 수 있는 API
-	웹 소켓 - 웹 브라우저에서 실행되는 웹 앱이 웹 서버 응용프로그램과 통신 지원 API
-	오프라인 웹 애플리케이션 - 캐시이용 오프라인에서 웹 앱이 실행될 수 있도록 지원 API

HTML5 문서 편집
---

### HTML5 문서 편집기

-	텍스트 편집기
	-	메모장
	-	좋은 편집기
	-	Atom, Eclipse, Text 등
	-	`.html`인 텍스트 파일로 저장
	-	텍스트의 기본 문자셋 - UTF-8
	-	HTML 파일이나 CSS, JS 파일 모두 UTF-8로 저장되어야 함
-	WYSIWYG 편집기
	-	어도비의 Dreamweaver 등
	-	HTML5 태그 정보 제공

### 유효성 검사

[HTML5 유효성 검사](https://html5.validator.nu)

[CSS 유효성 검사](http://www.css-validator.org/)

HTML 페이지 기본
---

### HTML5 페이지 기본 구조

```html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title></title>
</head>
<body>
</body>
```

### HTML5 페이지 필수 태그

```html
<!DOCTYPE HTML> <!-- HTML5임을 지정 -->
<head> <!-- 문서의 메타데이터 정의 -->
</head>
<body> <!-- 문서 내용 작성-->
</body>
```

HTML 태그의 특징
---

### HTML 태그의 구성

-	시작태그와 종료태그가 모두 있는 경우
-	시작태그만 있는 경우
-	태그와 속성은 대소문자 구분 없음
-	속성 값에 불필요한 공백 문자, HTML5 표준에 어긋남

### 문자, 기호, 심볼 입력

-	HTML5의 문자: 유니코드 문자셋, UTF-8 코드 체계
-	예약어: `&entity;`, `&#code;`
-	시맨틱 웹의 철학: 시맨틱 태그 상에 의미를 부여<br> `<b>, <strong>, <i>, <em>`와 같이 동일하게 표시되지만 의미가 다른 태그가 있음

### 블록 태그와 인라인 태그

-	태그: 블록 태그와 인라인 태그로 구분

	-	블록 태그: `<p>, <h1>, <div>, <ul>`

	-	인라인 태그: `<strong>, <a>, <img>, <span>`

-	블록 태그

	-	항상 새 라인에서 시작하여 출력
	-	양 옆에 다른 콘텐트를 배치하지 않고 한 라인 독점 사용
	-	가장 많이 사용하는 블록 태그: `<div>`
	-	블록 전체에 동일한 CSS 스타일을 적용 혹은 자바 스클립트로 블록을 하나의 단위처럼 다루고자 할 때

-	인라인 태그

	-	블록 속에 삽입되어 블록의 일부로 출력
	-	가장 많이 사용되는 인라인 태그: `<span>`
