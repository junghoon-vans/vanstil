Selector
===
HTML 태그의 모양을 꾸밀 스타일 시트를 선택하는 기능

### 태그 이름 셀렉터
- 태그 이름이 셀렉터로 사용됨
- 셀렉터와 같은 이름의 모든 태그에 CSS3 스타일 시트 적용

### Class 셀렉터
- `.`으로 시작하는 이름의 셀렉터
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

### id 셀렉터
- `#`으로 시작하는 이름의 셀렉터
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

### id 셀렉터와 class 셀렉터 비교
#### id 셀렉터
- id 속성의 목적은 각 태그를 유일하게 구분
- 적합한 활용
    - id 셀렉터는 여러 태그 중 특정 태그에만 CSS 스타일을 적용
#### class 셀렉터
- 태그의 종류와 관계없이 class 활용 가능
- 적합한 활용
  - 여러 태그를 하나의 그룹으로 묶어 동일한 CSS 스타일을 적용

### 셀렉터 조합
- 2개 이상의 셀렉터 조합
  - 조합에 적합한 HTML 태그에만 사용
- 자식 셀렉터
  - 부모 자식 관계인 두 셀렉터를 `>`기호로 조합
  - 예) `div > strong {background-color: yellow;}`
- 자손 셀렉터
  - 자손 관계인 2개 이상의 태그 나열
  - 예) `div strong {background-color: yellow;}`

### 전체 셀렉터와 속성 셀렉터
- 전체 셀렉터
  - `와일드 문자(*)`를 사용하여 모든 태그에 적용시키는 셀렉터
- 속성 셀렉터
  - HTML 태그의 특정 속성에 대해 값이 일치하는 태그에만 스타일 적용하는 셀렉터

### 가상 클래스 셀렉터
- 어떤 조건이나 상황에서 스타일을 적용하도록 만든 셀렉터
