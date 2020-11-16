---
title: "Tag"
linkTitle: "Tag"
date: 2020-11-16
type: docs
draft: false
weight: 2
---

메타 태그
---

HTML 페이지에 대한 메타 데이터를 담기 위한 태그
`<base>`, `<link>`, `<script>`, `<style>`, `<title>` 등이 있음.

메타 태그들은 `<head>` 태그안에 작성
`<script>`는 `<body>`안에 작성하는 경우도 있음

### base
웹 페이지들은 기본 URL과 페이지가 출력될 윈도우 지정

```HTML
<head>
  <base href="http://mysite.com/score/">
</head>
```

### link
외부 자원 연결

```HTML
<head>
  <link type="text/css" rel="stylesheet" href="mystyle.css">
  <!--해당 주소에 있는 파일을 가져올 수 있음-->
</head>
```

### meta
다양한 메타 데이터 표현

- 웹 페이지의 저작자, 문자 인코딩 방식, 내용 등

```HTML
<meta name="author" content="반정훈">
<meta name="description" content="내용 설명">
<meta name="keywords" content="키워드">
<meta charset="utf-8">
```

기본 태그
---

### img

```html
<img src="이미지 소스" alt="이미지 손상시 표시" width="가로" height="세로">
```

### list

#### 순서 있는 리스트 <ol>

```HTML
<ol type="A">
  <li>순서</li>
  <li>있는</li>
  <li>리스트/li>
</ol>
```

> `<ol>`은 type속성을 이용해서 표시기호를 변경할 수 있음.
 ex) `type = "A"` 알파벳 대문자로 표기

#### 순서 없는 리스트 <ul>

```HTML
<ul>
  <li>uno</li>
  <li>dos</li>
  <li>tres</li>
</ul>
```

#### 정의 리스트 <dl>

```HTML
<dl>
  <!--용어-->
  <dt>Markdown</dt>
  <!--설명-->
  <dd>일반 텍스트 문서의 양식을 편집하는 문법이다.</dd>
</dl>
```

### table
`<table>`은 표 생성 태그로 `<tr>, <th>, <td>` 태그를 이용해서 실제 내용을 삽입한다.

```html
<table>
  <caption>표제목</caption>
  <thead>
    <tr>
      <th>이름</th>
      <th>학번</th>
    </tr>
  </thead> <!--표 제목-->
  <tfoot>
    <tr>
      <td>인원</td>
      <td>1명</td>
    </tr>
  </tfoot> <!--표 밑글-->
  <tbody>
    <tr>
      <td>반정훈</td>
      <td>60181895</td>
    </tr>
  </tbody> <!--표 내용-->
</table>
```

#### 비정형 표
- colspan: 셀의 세로 길이를 지정
- rowspan: 셀의 가로 길이를 지정

### hyperlink
`<a>` 태그의 href 속성을 이용하여 하이퍼링크를 작성한다.

- 같은 웹 사이트에 있는 웹 페이지에 연결
```HTML
<a href="pick.html"></a>
```
- 다른 웹 사이트 웹페이지 연결
```HTML
<a href="이동할 사이트 주소"></a>
```
- 이미지 하이퍼링크 만들기
```HTML
<a href="주소">
  <img>
</a>
```

**target 속성**
- blank: 새로운 윈도우로 링크 접속
- \_self: 현재 윈도우로 링크 접속
- \_parent: 파생되어 온 윈도우로 링크 접속
- \_top: 브라우저 윈도우로 링크 접속

**앵커**

html 페이지 내의 특정 위치 지정

```HTML
<a href=#meta> 메타태그 </a> <!-- 지정한 id로 이동-->
<a href=#standard> 기본태그 </a>


<h1 id="meta"> 메타태그 </h1>
<h1 id="standard"> 기본태그 </h1>
```

### Inline Frame
`<iframe>`을 통해서 인라인 프레임을 생성
HTML 페이지 내에 HTML 페이지 삽입

```HTML
<iframe src="html 파일" width="100" height="100"></iframe>
```

### 미디어삽입
HTML5에서 웹 페이지에 미디어 삽입 표준화
- `audio`, `video` 태그
  - 플러그인 필요 없음
  - 지원되는 확장자 미디어 재생
- 비표준 미디어 재생시
  - flash
  - `embed`, `object` 태그 이용

#### video
```HTML
<video src="파일" width="320" height="240" controls autoplay loop></video>

<video controls autoplay>
  <source src="파일">
  <!--source 태그로 지정 가능-->
</video>
```

> autoplay 속성은 크롬에서는 지원하지 않는다.

#### audio
```HTML
<audio src="파일" controls autoplay loop></audio>
```
