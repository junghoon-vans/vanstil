CSS3 개요
---
### 정의
- HTML 문서의 색이나 모양 등 외관을 꾸미는 언어
- CSS로 작성된 코드를 `스타일 시트(Style Sheet)`라 함
- Cascading Style Sheet의 현재 버전: `CSS3`

### 구성
- 셀렉터
  - CSS3 스타일 시트를 HTML 페이지에 적용하도록 만든 이름
- 프로퍼티
  - 스타일 속성 이름, 약 200개 정도의 프로퍼티가 존재
- 값
  - 프로퍼티의 값
- 주석문
  - 스타일 시트 내에 붙이는 설명문
  - `/* ... /*`
  - 여러 줄, 아무 위치나 사용 가능
- 대소문자 구분 없음

### 사용
- `<style>`태그에 스타일 시트 작성
- style 속성에 스타일 시트 작성
- 스타일 시트를 별도 파일로 작성
  - `<link>`태그나 `@import`로 불러와 사용

#### style 태그
```HTML
<head>
  <style>
  body{background-color: mistynose; }
  h3 { color: purple; }
  </style>
</head>
<body>
  <h3> style 태그로 스타일 적용하기</h3>
</body>
```

#### style 속성
```HTML
<p style = "color : magenta; font-size: 30px">
  style 속성으로 스타일 적용하기
</p>"
```

#### CSS 파일
- `style` 태그를 사용하지 않고 `CSS` 파일에 작성하고 저장하여 불러올 수 있음.
- CSS를 불러오는 데에는 `link` 태그 또는 `@import`를 사용할 수 있음
```HTML
<head>
  <link href="style.css" type="text/css" rel="stylesheet">
  @import url("style.css");
  @import 'style.css';
</head>
```
> `@import`는 두 가지 방식으로 사용가능
> 작은 따옴표, 큰 따옴표 모두 가능

CSS3 규칙
---
### 스타일 상속
부모 태그로부터 상속
> 부모태그: 자신을 둘러싸는 태그

### 스타일 합치기
태그에 적용되는 모든 스타일이 합쳐짐

### 오버라이딩
동일한 태그 상의 스타일에서 순위가 높은 스타일이 우선 적용됨.

### 스타일 적용 우선순위
1. style 속성에 선언된 스타일
2. `<style>` 태그에 선언된 스타일
3. `.css` 스타일 시트 파일에 선언된 스타일
4. 브라우저의 디폴트 스타일


CSS 색 표현
---
### 방법

- 16진수
  - ex) `#8A2BE2`
- 10진수코드와 rgb()
  - ex) `rgb(138,43,226)`
- 색 이름
  - CSS3 표준에서는 140개의 색 이름이 지정되어 있음.

### 관련 프로퍼티
```css
color : 색
background-color: 색
border-color: 색
```

텍스트
---

### 프로퍼티

```CSS3
text-indent : <length>|<percentage>; /* 들여쓰기 */
text-align : left|right|center|justify /* 정렬 */
text-decoration none|underline|overline|line-through: /* 라인 */
```

### 폰트
CSS3의 폰트와 모양

- font-family
```css3
font-family: Arial, "Times New Roman", Selif:
```

- font-size
```css3
font-size: 40px;
```

- font 프로퍼티
```css3
font: italic bold 40px consolas, sans-selif;
/* font: font-style font-weight font-size font-family */
```

### CSS3의 표준 길이 단위

| 단위 | 의미     |
| :------------- | :------------- |
| em      | 배수      |
| % | 퍼센트|
| px | 픽셀 수 |
| cm | 센티미터 |
| mm | 밀리미터 |
| in | 인치 |

> HTML5에서는 단위를 사용하지 않으면 CSS 스타일 오류
