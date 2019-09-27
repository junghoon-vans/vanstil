Selector
===
Contents
---
- [정의](#정의)
- [태그 선택자](#태그-선택자)
- [class, id 선택자](#class-id-선택자)
  - [class 선택자](#class-선택자)
  - [id 선택자](#id-선택자)
  - [특징](#특징)
    - [class 선택자 특징](#class-선택자-특징)
    - [id 선택자-특징](#id-선택자-특징)
- [이외 선택자](#이외-선택자)
  - [선택자 조합](#선택자-조합)
  - [전체 선택자와 속성 선택자](#전체-선택자와-속성-선택자)
  - [가상 클래스 선택자](가상-클래스-선택자)

정의
---
선택자(Selector): HTML 태그의 모양을 꾸밀 스타일 시트를 선택하는 기능

태그 선택자
---
- 태그 이름이 선택자로 사용됨
- 선택자와 같은 이름의 모든 태그에 CSS3 스타일 시트 적용

### class, id 선택자
#### class 선택자
- `.`으로 시작하는 이름의 선택자
- HTML 태그의 class 속성으로 지정

```HTML
<head>
  <style>
    .warning {color : red }
    body.main { background : aliceblue }
  </style>
</head>

<body class="main">
  <div class="warning">
    60점 이하는 F
  </div>
</body>
```

### id 선택자
- `#`으로 시작하는 이름의 선택자
- HTML 태그의 id 속성으로 지정

```HTML
<head>
  <style>
    #list { background : aliceblue }
  </style>
</head>

<body>
  <ul id = "list">
    <li>HTML</li>
    <li>CSS</li>
    <li>JS</li>
  </ul>
</body>
```

### 특징
#### id 선택자 특징
- id 속성의 목적은 각 태그를 유일하게 구분
- 적합한 활용
    - id 선택자는 여러 태그 중 특정 태그에만 CSS 스타일을 적용

#### class 선택자 특징
- 태그의 종류와 관계없이 class 활용 가능
- 적합한 활용
  - 여러 태그를 하나의 그룹으로 묶어 동일한 CSS 스타일을 적용

이외 선택자
---

### 선택자 조합
- 2개 이상의 선택자 조합
  - 조합에 적합한 HTML 태그에만 사용
- 자식 선택자
  - 부모 자식 관계인 두 선택자를 `>`기호로 조합
  - 예) `div > strong {background-color: yellow;}`
- 자손 선택자
  - 자손 관계인 2개 이상의 태그 나열
  - 예) `div strong {background-color: yellow;}`

### 전체 선택자와 속성 선택자
- 전체 선택자
  - `와일드 문자(*)`를 사용하여 모든 태그에 적용시키는 선택자
- 속성 선택자
  - HTML 태그의 특정 속성에 대해 값이 일치하는 태그에만 스타일 적용하는 선택자
  - ex) input[type=text] `{ color : red; }`
    - type 속성값이 'text'인 `<input>`태그에 적용


### 가상 클래스 선택자
- 어떤 조건이나 상황에서 스타일을 적용하도록 만든 선택자
- 40여개의 가상 클래스 선택자 존재

| 셀렉터 | 설명  |
| :------------- | :------------- |
| :hover     | 마우스가 올라갈 때 스타일 적용    |
| :active | 마우스로 누르고 있는 상황에서 스타일 적용 |
| :focus | 폼 요소가 키보드나 마우스 클릭으로 포커스를 받을 때 스타일 적용 |
| :link | 방문하지 않은 링크에 스타일 적용 |
| :visited | 방문한 링크에 스타일 적용 |

ex) `a:visited { color : green; }`
방문한 사이트 링크에 `color : green` 스타일 적용
