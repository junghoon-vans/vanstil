---
title: "Document"
linkTitle: "Document"
date: 2020-11-16
type: docs
draft: false
weight: 6
description: >
  DOM 트리의 최상위 객체
---

HTML 문서 전체를 대변하는 객체이자 DOM 객체를 접근하는 경로의 시작점
> HTML 문서 로드 전, Document 객체를 생성하고 DOM 트리 생성

- 프로퍼티: HTML 문서의 전반적인 속성 내포
- 메소드: DOM 객체 검색, DOM 객체 생성, HTML 문서 전반적 제어
- 컬렉션: HTML 태그들을 배열처럼 접근할 수 있는 컬렉션을 둠

Document 객체 접근
---

- window.document 또는 document 이름으로 접근
- document 객체는 DOM 객체가 아님

write() and writeln()
---

- write()
  - 현재 document 객체에 담긴 HTML 콘텐츠 마지막에 HTML 텍스트를 추가
  - 추가되는 HTML 텍스트는 DOM 객체로 바뀌고 DOM 트리에 추가
  - 삽입된 HTML 텍스트가 브라우저 화면에 출력
- writeln()
  - HTML 텍스트에 `\n`을 덧붙여 출력. 한 칸 띄는 효과

open() and close()
---

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

문서의 동적 구성
---

### DOM 객체 동적 생성
```js
var newDIV = document.createElement("div");
newDIV.innerHTML = "새로 생성된 DIV입니다.";
newDIV.setAttribute("id", "myDiv");
newDIV.style.backgroundColor = "yellow";
```

### DOM 트리에 삽입
```js
var p = document.getElementById("p");
p.appendChild(newDiv);
```

### DOM 객체의 삭제
```js
var myDiv = document.getElementById("myDiv");
var parent = myDiv.parentElement;
parent.removeChild(myDiv); // 부모에서 myDiv 객체 삭제
```
