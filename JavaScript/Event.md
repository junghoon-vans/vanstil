Event
===

Contents
---
- [개요](#개요)
  - [이벤트 정의](#이벤트-정의)
  - [이벤트 리스너](#이벤트-리스너)
  - [이벤트 종류](#이벤트-종류)
- [이벤트 리스너 생성](#이벤트-리스너-생성)
  - [HTML 태그 내에 작성](#html-태그-내에-작성)
  - [DOM 객체의 이벤트 리스너 프로퍼티에 작성](#dom-객체-프로퍼티에-작성)
  - [DOM 객체의 addEventListener() 메소드 이용](#dom-객체-addeventlistener-메소드)
  - [익명 함수로 이벤트 리스너 작성](#익명-함수로-이벤트-리스너-작성)
- [이벤트-객체](#이벤트-객체)
  - [이벤트-객체-전달받기](#이벤트-객체-전달받기)
    - [이름을 가진 이벤트 리스너](#이름을-가진-이벤트-리스너)
    - [익명 함수의 경우](#익명-함수의-경우)
    - [HTML 태그에 이벤트 리스너](#html-태그에-이벤트-리스너)
  - [이벤트 객체에 들어 있는 정보](#이벤트-객체에-들어-있는-정보)
  - [preventDefault()](#preventdefault)
- [이벤트 흐름](#이벤트-흐름)
  - [이벤트가 흘러가는 과정](#이벤트가-흘러가는-과정)
  - [캡쳐 리스너와 버블 리스너 등록](#캡쳐-리스너와-버블-리스너-등록)
  - [이벤트 흐름 중단](#이벤트-흐름-중단)

개요
---
### 이벤트 정의
마우스 클릭, 키보드 입력, 이미지나 HTML 문서의 로딩, 타이머의 타임아웃 등 사용자의 입력 행위나 문서나 브라우저의 상태 변화를 자바스크립트 코드에게 알리는 통지

### 이벤트 리스너
발생한 이벤트에 대처하기 위해 작성된 자바스크립트 코드

### 이벤트 종류
- HTML5에서 이벤트는 70여가지
- 이벤트 리스너의 이름은 이벤트 이름 앞에 on을 붙임

이벤트 리스너 생성
---
### HTML 태그 내에 작성
HTML 태그의 이벤트 리스너 속성에 리스너 코드 직접 작성
```js
<p onmouseover="this.style.backgroundColor='orchid'" onmouseout="this.style.backgroundColor='white'">
마우스 올리면 orchid 색으로 변경
</p>
```

### DOM 객체 프로퍼티에 작성
DOM 객체의 이벤트 리스너 프로퍼티에 이벤트 리스너 코드 작성

```js
function over() { // onmouseover 리스너로 사용할 함수
...
}
var p = document.getElementById("p");
p.onmouseover = over;
```

### DOM 객체 addEventListener() 메소드
- addEventListener() 사용의 차별점
  - removeEventListener() 이용 제거 가능
  - 동일한 리벤트 리스너에 여러 함수를 중복 등록 가능

```js
var p;
function init() { // 문서가 완전히 로드되었을 때 호출
p = document.getElementById("p");
p.addEventListener("mouseover", over); // 이벤트 리스너 등록
p.addEventListener("mouseout", out); // 이벤트 리스너 등록
}
function over() {
p.style.backgroundColor="orchid";
}
function out() {
p.style.backgroundColor="white";
}
```

### 익명 함수로 이벤트 리스너 작성
```js
p.onmouseover = function () { this.style.backgroundColor = "orchid"; }; // 익명 함수
p.addEventListener("mouseover",
  function () { this.style.backgroundColor = "orchid"; } // 익명 함수
);
```

> 익명 함수(anonymous function): 함수 이름 없이 함수 바로 작성
> 코드가 짧거나 한 곳에서만 사용하는 경우, 익명 함수 편리

이벤트 객체
---
- 발생한 이벤트에 관련된 다양한 정보를 담은 객체
- 이벤트가 처리되고 나면 이벤트 객체 소멸

### 이벤트 객체 전달받기
이벤트 객체는 이벤트 리스너 함수의 첫 번째 매개변수에 전달

#### 이름을 가진 이벤트 리스너
```js
function f(
e) { // 매개변수 e에 이벤트 객체 전달받음
...
}
obj.onclick = f; // obj 객체의 onclick 리스너로 함수 f 등록
```

#### 익명 함수의 경우
```js
obj.onclick = function(e) { // 매개변수
e에 이벤트 객체 전달받음
...
}
```

#### HTML 태그에 이벤트 리스너
event 라는 이름으로 전달
```js
function f(e) {
...
}
...
<button onclick=“f(event)”>버튼</button>
<div onclick=“alert(event.type)”>버튼</div>
```

### 이벤트 객체에 들어 있는 정보
- 현재 발생한 이벤트에 관한 다양한 정보
  - 이벤트 객체의 프로퍼티와 메소드로 알 수 있음
- 이벤트의 종류마다 조금씩 다름
  - 이벤트 객체의 공통 멤버
    | 멤버 | 설명     |
    | :------------- | :------------- |
    | type    | 현재 발생한 이벤트의 종류를 나타내는 문자 (clickm load 등) |
    | target | 이벤트를 발생시킨 객체 (DOM 객체 혹은 HTML 태그) |
    | currentTarget | 현재 이벤트 리스너를 실행하고 있는 DOM 객체 |
    | defaultPrevented | 이벤트의 디폴트 행동이 취소되었는지 나타냄(true/false) |
    | preventDefault() | 이벤트의 디폴트 행동을 취소시키는 메소드 |
- target 프로퍼티
  - 이벤트 타겟 객체 가리킴
  - 이벤트 타겟 : 이벤트를 유발시킨 DOM 객체

### preventDefault()
이벤트 디폴트 행동 취소
> 이벤트 디폴트 행동: 특정 이벤트에 대한 HTML 태그의 기본 행동

```html5
<a href="http://www.naver.com" onclick="event.preventDefault();"
>
이동 안되는 링크
</a>
```

이벤트 흐름
---
이벤트가 발생하면 window 객체에 먼저 도달하고, DOM 트리를 따라 이벤트 타겟에 도착하고, 다시 반대 방향으로 흘러 window 객체에 도달한 다음 사라지는 과정

### 이벤트가 흘러가는 과정
- 캡쳐 단계(capturing phase)
  - 이벤트가 window 객체에서 중간의 모든 DOM 객체를 거쳐 타겟 객체에 전달되는 과정
  - 이벤트가 거쳐가는 모든 DOM 객체(window포함)의 이벤트 리스너 실행
- 버블 단계(bubbling phase)
  - 이벤트가 타겟에서 중간의 모든 DOM 객체를 거쳐 window 객체에 전달되는 과정
  - 이벤트가 거쳐가는 모든 DOM 객체(window포함)의 이벤트 리스너 실행

### 캡쳐 리스너와 버블 리스너 등록
addEventListener()의 3 번째 매개 변수 이용
> true이면 캡쳐 리스너, false이면 버블 리스너

```js
var b = document.getElementById("button");
b.addEventListener("click", capFunc, true); // 캡쳐 단계에서 capFunc() 실행
b.addEventListener("click", bubbleFunc, false); // 버블 단계에서 bubbleFunc() 실행
```

### 이벤트 흐름 중단
이벤트 객체의 stopPropagation() 호출
