---
title: "Document Obeject Model"
linkTitle: "DOM"
date: 2020-11-16
type: docs
draft: false
weight: 5
description: >
  웹 페이지에 대한 인터페이스
---

자바스트립트 코드는 브라우저로부터 3가지 유형의 객체를 제공받아 활용한다.
- BOM 객체
- 코어 객체
- DOM(Document Object Model) 객체

HTML DOM
---

- 웹 페이지에 작성된 HTML 태그 당 객체 생성
- 목적: HTML 태그가 출력된 모양이나 콘텐츠를 제어하기 위해서
  - DOM 객체를 통해 각 태그의 CSS3 스타일 시트 접근 및 변경
  - HTML 태그에 의해 출력된 텍스트나 이미지 변경
- DOM 트리
  - HTML 태그의 포함관계에 따라 DOM 객체의 트리 생성
  - DOM 트리는 부모 자식 관계
- DOM 객체
  - DOM 트리의 한 노드
  - HTML 태그 당 하나의 DOM 객체 생성
    - `<p>`는 p객체로, `<div>`는 div p객체로
    - DOM 노드, DOM element로 불림

### DOM 트리
- 브라우저는 HTML 페이지를 로드하면서, HTML 태그의 포함관계에 따라 DOM 객체들을 트리 구조로 만듦
  - window 객체는 BOM과 DOM을 포함하여 전체 객체의 최상위
  - document 객체는 window 객체의 자식이면서 DOM 객체의 최상위
- 자바스크립트 코드는 DOM 트리를 따라 DOM 객체들을 마음대로 접근할 수 있다.

#### DOM 트리의 특징
- DOM 트리의 루트는 document 객체
- DOM 객체의 종류는 HTML 태그 종류만큼
- HTML 태그 당 DOM 객체가 하나씩 생성 , 이름은 태그와 같음
- HTML 태그의 포함관계에 따라 DOM 트리에 부모 자식 관계

#### 브라우저가 HTML 태그를 화면에 그리는 과정
1. 브라우저가 DOM 트리의 틀(document 객체) 생성
2. 브라우저가 HTML 태그를 읽고 DOM 트리에 DOM 객체 생성
3. 브라우저는 DOM 객체를 화면에 출력
4. HTML 문서 로딩이 완료되면 DOM 트리 완성
5. DOM 객체 변경 시, 브라우저는 해당 HTML 태그의 출력 모양을 바로 갱신

### DOM 객체 구성 요소
- 프로퍼티(property)
  - HTML 태그의 속성(attribute) 반영
- 메소드(method)
  - DOM 객체의 멤버 함수로서, HTML 태그 제어 가능
- 컬렉션(collection)
  - 자식 DOM 객체들의 주소를 가지는 등 배열과 비슷한 집합적 정보
  - 예: children 컬렉션 – DOM 객체의 모든 자식 DOM 객체에 대한 주소 가짐
- 이벤트 리스너(event listener)
  - HTML 태그에 작성된 이벤트 리스너 반영
  - 약 70여 개의 이벤트 리스너를 가질 수 있음
- CSS3 스타일
  - HTML 태그에 설정된 CSS3 스타일 시트 정보를 반영
  - DOM 객체의 style 프로퍼티를 통해 HTML 태그의 모양 제어 가능

### DOM 객체 프로퍼티
DOM 객체들은 DOM 트리에서 부모, 자식, 형제의 관계로 연결
- parentElement 프로퍼티 – 부모객체
- children 프로퍼티 – 직계 자식들의 컬렉션
- firstElementChild 프로퍼티 – 첫 번째 직계 자식
- lastElementChild 프로퍼티 – 마지막 직계 자식

Sibling이란 DOM 트리에서 동일한 레벨에 있는 모든 사촌 및 형제
DOM 객체를 지칭
> 다른 부모의 자식이어도 같은 레벨이면 sibling

Sibling 관계에 있는 DOM 객체들은 다음 2개의 프로퍼티로 접근
- previousElementSibling 프로퍼티 – 이전 sibling 객체
- nextElementSibling 프로퍼티 – 이후 sibling 객체

### DOM 객체 다루기
#### getElementById
`document.getElementById()`
- DOM 객체 구분
  ```HTML5
  <p id="hi">안녕하세요</p>
  ```
- DOM 객체 찾기
  ```js
  document.getElementById("hi") // id 값이 hi인 DOM 객체 리턴
  ```
- DOM 객체 스타일 변경
  - style 객체 사용
  ```js
  var span = document.getElementById("mySpan"); // id가 mySpan인 객체 찾기
  span.style.color = "green"; // ‘문장입니다’의 글자 색을 green으로 변경
  span.style.fontSize = "30px"; // ‘문장입니다’의 폰트를 30px 크기로 변경
  span.style.border = "3px dotted magenta"; // 3픽셀의 magenta 점선 테두리
  ```
#### getElementByTagName
`document.getElementsByTagName()`
태그 이름이 같은 모든 DOM 객체들을 찾아 컬렉션 리턴

```js
function change() {
  var spanArray = document.getElementsByTagName("span");
  for(var i=0; i<spanArray.length; i++) {
    var span = spanArray[i];
    span.style.color = "orchid";
    span.style.fontSize = "20px";
  }
}
```
#### getElementByClassName
`document.getElementsByClassName()`
class 속성이 같은 모든 DOM 객체들을 찾아 컬렉션 리턴

#### innerHTML 프로퍼티
시작 태그와 종료 태그 사이에 들어 있는 HTML 콘텐츠를 다룸
> innerHTML 프로퍼티 수정 -> HTML 태그의 콘텐츠 변경

```HTML5
<script>
function change() {
var p = document.getElementById("firstP");
p.innerHTML= "나의 <img src='puppy.png'> 강아지";
}
</script>

<p id="firstP" style="color:blue"
onclick="change()">
여기에<span style="color:red">클릭하세요</span>
</p>
```

#### this
객체 자신을 가리키는 자바스크립트 키워드
> DOM 객체에서 객체 자신을 가리키는 용도로 사용

```html5
<div onclick="this.style.backgroundColor='orange'">
```

Document 객체
---
HTML 문서 전체를 대변하는 객체이자 DOM 객체를 접근하는 경로의 시작점
> HTML 문서 로드 전, Document 객체를 생성하고 DOM 트리 생성

- 프로퍼티: HTML 문서의 전반적인 속성 내포
- 메소드: DOM 객체 검색, DOM 객체 생성, HTML 문서 전반적 제어
- 컬렉션: HTML 태그들을 배열처럼 접근할 수 있는 컬렉션을 둠

### Document 객체 접근
- window.document 또는 document 이름으로 접근
- document 객체는 DOM 객체가 아님

### write() and writeln()
- write()
  - 현재 document 객체에 담긴 HTML 콘텐츠 마지막에 HTML 텍스트를 추가
  - 추가되는 HTML 텍스트는 DOM 객체로 바뀌고 DOM 트리에 추가
  - 삽입된 HTML 텍스트가 브라우저 화면에 출력
- writeln()
  - HTML 텍스트에 `\n`을 덧붙여 출력. 한 칸 띄는 효과

### open() and close()
- open()
  - 현재 브라우저에 출력된 HTML 콘텐츠를 지우고 새로운 HTML 페이지 시작.
  - 즉 document 객체에 담긴 DOM 트리를 지우고 새로 시작
- close()
  - 현재 브라우저에 출력된 HTML 페이지 완성
  - 더 이상 document.write() 할 수 없음

```js
// 현재 HTML 페이지의 내용을 지우고 다시 시작
document.open();
document.write(“<html><head>...<body>안녕하세요.”);
document.write(“.......”);
document.write(“</body></html>”);
document.close();
```

### 문서의 동적 구성
#### DOM 객체 동적 생성
```js
var newDIV = document.createElement("div");
newDIV.innerHTML = "새로 생성된 DIV입니다.";
newDIV.setAttribute("id", "myDiv");
newDIV.style.backgroundColor = "yellow";
```

#### DOM 트리에 삽입
```js
var p = document.getElementById("p");
p.appendChild(newDiv);
```

#### DOM 객체의 삭제
```js
var myDiv = document.getElementById("myDiv");
var parent = myDiv.parentElement;
parent.removeChild(myDiv); // 부모에서 myDiv 객체 삭제
```
