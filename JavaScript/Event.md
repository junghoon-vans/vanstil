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
- [이벤트 객체](#이벤트-객체)
  - [이벤트 객체 전달받기](#이벤트-객체-전달받기)
    - [이름을 가진 이벤트 리스너](#이름을-가진-이벤트-리스너)
    - [익명 함수의 경우](#익명-함수의-경우)
    - [HTML 태그에 이벤트 리스너](#html-태그에-이벤트-리스너)
  - [이벤트 객체에 들어 있는 정보](#이벤트-객체에-들어-있는-정보)
  - [preventDefault()](#preventdefault)
- [이벤트 흐름](#이벤트-흐름)
  - [이벤트가 흘러가는 과정](#이벤트가-흘러가는-과정)
  - [캡쳐 리스너와 버블 리스너 등록](#캡쳐-리스너와-버블-리스너-등록)
  - [이벤트 흐름 중단](#이벤트-흐름-중단)
- [마우스 핸들링](#마우스-핸들링)
  - [마우스 이벤트 객체 프로퍼티](#마우스-이벤트-객체-프로퍼티)
  - [마우스 이벤트](#마우스-이벤트)
- [load](#load)
  - [문서의 로딩](#문서의-로딩)
  - [이미지 로딩](#이미지-로딩)
    - [Image 객체](#image-객체)
    - [onload](#onload)
    - [새로운 이미지 로딩](#새로운-이미지-로딩)
    - [이미지 객체 생성](#이미지-객체-생성)
- [폼과 이벤트 활용](#폼과-이벤트-활용)
  - [라디오버튼과 체크박스](#라디오버튼과-체크박스)
  - [select 객체와 onchange](#select-객체와-onchange)
- [키 이벤트](#키-이벤트)
  - [onkeydown, onkeypress, onkeyup](#onkeydown-onkeypress-onkeyup)
  - [onreset과 onsubmit](#onreset과-onsubmit)

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

마우스 핸들링
---
### 마우스 이벤트 객체 프로퍼티
| 프로퍼티 | 설명 |
| :------------- | :------------- |
| x, y     | (x, y)는 타겟 객체의 부모 객체 내에서의 마우스 좌표 |
| clientX, clientY | (clientX, clientY)는 브라우저 윈도우의 문서출력 영역 내에서의 마우스의 좌표 |
| screenX, screenY | (screenX, screenY)는 스크린을 기준으로 한 마우스 좌표 |
| offsetX, offsetY | (offsetX, offsetY)는 타겟 객체 내에서의 마우스 좌표 |
| button | 0: 아무 버튼도 눌러지지 않았음 <br> 1: 왼쪽 버튼이 눌러졌음 <br> 2: 오른쪽 버튼이 눌러졌음 <br> 3: 왼쪽, 오른쪽 버튼이 모두 눌러졌음 <br> 4: 중간 버튼이 눌러졌음 |
| wheelDelta | 양수: 위쪽으로 굴린 경우 <br> 음수: 아래쪽으로 굴린 경우 |

### 마우스 이벤트
- onclick
  - HTML 태그 클릭될 때
- ondblclick
  - HTML 태그가 더블클릭될 때
- onmousedown/up
  - 마우스 버튼을 누르는(놓는) 순간
- onmouseover/out
  - 마우스가 태그 위로 올라가는(떠나는) 순간
  - 자식 영역도 인지
- onmouseenter/leave
  - 마우스가 태그 위로 올라가는(떠나는) 순간
- onwheel
  - HTML 태그에 마우스 휠이 구르는 동안 계속 호출
  
```js
obj.onwheel = function (e) {
  if(e.wheelDelta < 0) { // 아래쪽으로 휠을 굴린 경우
    ...
  }
  else { // 위쪽으로 휠을 굴린 경우
    ...
  }
};
```
#### oncontextmenu
- HTML 태그 위에 마우스 오른쪽 버튼 클릭
- 디폴트로 컨텍스트 메뉴 출력
- oncontextmenu 리스너에 false 리턴하면 디폴트 행동 취소


load
---
### 문서의 로딩
- window 객체에서 onload 발생
  - 웹 페이지 로딩 완료시 호출되는 이벤트 리스너
- onload 리스너 작성 방법
```js
window.onload="alert('onload');";
```
```html5
<body onload="alert('onload');">
```
> 같은 표현, `<body>`에 onload를 단 window 객체에 load 이벤트가 전달됨
>  document.onload는 최근에 와서 많은 브라우저에서 작동하지 않음

### 이미지 로딩
#### Image 객체
- `<img>` 태그에 의해 생성되는 DOM 객체
- `new Image();` 자바스크립트 코드에 의해 생성되는 객체
#### onload
- 이미지의 로딩이 완료되면 Image객체에 발생하는 이벤트
#### 새로운 이미지 로딩
```js
var myImg = document.getElementById("myImg");
myImg.onload = function () { // 이미지 로딩 완료 시 실행
var width = myImg.width; // 정확한 이미지 폭 읽기
}
myImg.src = "banana.png"; // 이미지 로딩 지시
```

#### 이미지 객체 생성
```js
var bananaImg = new Image(); // 이미지 객체 생성
bananaImg.src = "banana.png"; // 이미지 로딩
```

### 폼과 이벤트 활용
- 포커스
  - 포커스는 현재 키 입력에 대한 독점권
  -	브라우저는 포커스를 가지고 있는 HTML 태그 요소에 키 공급
- onblur
  - 포커스를 잃을 때 발생하는 이벤트 리스너
- onfocus
  -	포커스를 잃을 때 발생하는 이벤트 리스너

#### 라디오버튼과 체크박스
라디오버튼
`<input type="radio">`로 만들어진 라디오 버튼 DOM 객체

```html
<form>
	<input type="radio" name="city" value="seoul">서울
	<input type="radio" name="city" value="busan">부산
	<input type="radio" name="city" value="chunchen">춘천
</form>
```

> 라디오 버튼 객체들 알아내기 –> 그 그룹의 Name으로

체크박스
`<input type="checkbox">`로 만들어진 체크박스 DOM 객체

#### select 객체와 onchange
- select 객체는 select 태그로 만들어진 콤보박스
- option 객체는 option 태그로 표현되는 옵션 아이템
```html
<select id="fruits">
  <option value="1">딸기</option>
	<option value="2" selected>바나나</option>
	<option value="3">사과</option>
</select>
```

선택된 옵션 알아내기
```javascript
var sel = document.getElementById("fruits");
var index = sel.selectedIndex;  // index는 선택 상태의 옵션 인덱스
```

옵션 선택
```javascript
sel.selectedIndex = 2;  // 3번째 옵션 “사과” 선택
sel.options[2].selected = true; // 3번째 옵션 “사과” 선택
```			

select와 onchange 리스너
선택된 옵션이 변경되면 select 객체의 onchange 리스너 호출
```html
<select id="fruits" onchange="drawImage()">...</select>
```

키 이벤트
---

### onkeydown, onkeypress, onkeyup
- onkeydown
  - 키가 눌러지는 순간 호출. 모든 키에 대해 작동

- onkeypress
  -	문자 키와 Enter, Space, Esc 키에 대해서만 눌러지는 순간에 추가 호출
  -	문자 키가 아닌 경우(F1, Shift, PgDn, Del, Ins 등) 호출되지 않음

- onkeyup
  -	눌러진 키가 떼어지는 순간 호출

### onreset과 onsubmit

- onreset
  - reset 버튼(`<input type="reset">`) 클릭 시 false를 리턴하면 폼이 초기화되지 않음

- onsubmit
  -	submit(`<input type="submit">`) 버튼 클릭 시 false를 리턴하면 폼 전송하지 않음

- 리스너 작성
  -	onreset과 onsubmit 리스너는 form 태그에 달아야 한다

```html
<form onreset="..." onsubmit="...">
```		

| 프로퍼티  | 설명                                 | r/w |
|:----------|:-------------------------------------|:----|
| keyCode   | 입력된 키의 유니코드 값              | r   |
| altKey    | Alt 키가 눌러진 상태이면 true        | r   |
| altLeft   | 왼쪽 Alt 키가 눌러진 상태이면 true   | r   |
| ctrlKey   | ctrl 키가 눌러진 상태이면 true       | r   |
| ctrlLeft  | 왼쪽 ctrl 키가 눌러진 상태이면 true  | r   |
| shiftKey  | shift 키가 눌러진 상태이면 true      | r   |
| shiftLeft | 왼쪽 shift 키가 눌러진 상태이면 true | r   |
