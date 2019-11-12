BOM(Browser Object Model)
===

Condtents
---
- [BOM](#bom)
  - [브라우저 공통 BOM 객체들과 기능](#브라우저-공통-bom-객체들과-기능)
- [window](#window)
  - [윈도우 열기](#윈도우-열기)
    - [sWindowName](#swindowname)
    - [sFeature](#sfeature)
  - [윈도우 닫기](#윈도우-닫기)
  - [윈도우 위치 및 크기 조절](#윈도우-위치-조절-및-크기-조절)
  - [웹 페이지 스크롤](#웹-페이지-스크롤)

BOM
---
- 자바스크립트로 브라우저를 제어하기 위해 지원하는 객체들

### 브라우저 공통 BOM 객체들과 기능
- window: 브라우저 윈도우 모양 제어, 새 윈도우 열기/닫기
- navigator: 브라우저에 대한 다양한 정보 제공
- history: 브라우저 윈도우에 로드한 URL 리스트와 히스토리
- location: 브라우저 윈도우에 로드한 HTML 페이지의 URL 관리
- screen: 브라우저가 실행되고 있는 스크린 장치에 대한 정보 제공

> 국제 표준이 없기 때문에, 브라우저별로 BOM 객체가 상이

window
---
- 열려 있는 브라우저 윈도우나 탭 윈도우의 속성을 나타내는 객체
- 브라우저 윈도우나 탭 윈도우마다 별도의 window 객체 생성
window 객체의 생성
- 브라우저가 새로운 웹 페이지를 로드
- `<iframe>` 태그 당 하나의 window 객체 생성
- 자바스크립트 코드로 윈도우 열기 시
자바스크립트 코드로 window 객체 접근
- window 혹은 window.self 혹은 self
- 다양한 윈도우 객체의 프로퍼티, 메소드, 이벤트 리스너

### 윈도우 열기
window.open()
- 윈도우를 새로 열고 웹 페이지 출력
- 3개의 매개변수를 가진 함수
  - window.open(sURL, sWindowName, sFeature)
    - sURL: 윈도우에 출력할 웹 페이지 주소 문자열
    - sWindowName: 새로 여는 윈도우의 이름 문자열로, 생략 가능
    - sFeature: 윈도우 모양, 크기 등의 속성들을 표현하는 문자열
- 윈도우 이름: 개발자가 임의로 정하지만, 지정된 윈도우가 존재

#### sWindowName
| 이름 | 설명 |
| :------------- | :------------- |
| \_blank | 이름 없는 새 윈도우를 열고, 웹 페이지 로드 |
| \_parent | 현재 윈도우의 부모 윈도우에 웹 페이지 로드, 부모 없으면 현재 윈도우 이용 |
| \_self | 현재 윈도우에 웹 페이지 로드 |
| \_top | 브라우저 윈도우에 웹 페이지 로드 |

#### sFeature
| 속성 | 설명 | 속성 값의 종류 |
| :------------- | :------------- | :------------ |
| width | 윈도우의 폭, 픽셀 값 | 정수 |
| height | 윈도우의 높이, 픽셀 값 | 정수 |
| left | 스크린 상의 윈도우 x 좌표, 픽셀 값 | 정수 |
| right | 스크린 상의 윈도우 y 좌표, 픽셀 값 | 정수 |
| resizable | 마우스로 윈도우 크기 조절 가능 여부 | yes/no/1/0 |
| location | URL 입력 창을 출력하도록 지정 | yes/no/1/0 |
| menubar | 메뉴바를 출력하도록 지정 | yes/no/1/0 |
| scrollbars | 수직/수평 스크롤바를 출력하도록 지정 | yes/no/1/0 |
| status | 윈도우 하단에 상태바를 출력하도록 지정 | yes/no/1/0 |
| toolbar | 툴바를 출력하도록 지정 | yes/no/1/0 |

> yes는 속성을 반영하도록 지시
> no가 디폴트이며 0과 같은 값

### 윈도우 닫기
```js
var newWin=null; // 새로 연 윈도우 기억
function load(URL) {
newWin = window.open(URL, "myWin", "left=300,top=300,width=400,height=300");
}
function closeNewWindow() {
if(newWin==null || newWin.closed) // 윈도우가 열리지 않았거나 닫힌 경우
return; // 윈도우가 없는 경우 그냥 리턴
else
newWin.close(); // 열어 놓은 윈도우 닫기
}
```

### 타이머 활용
window 객체의 타이머 기능 2가지
- 타임아웃 코드 1회 호출
  - setTimeout()/clearTimeout()
- 타임아웃 코드 반복 호출
  - setInterval()/clearInterval()

#### setTimeout()/clearTimeout()
```js
var timerID = setTimeout("timeOutCode", msec);
clearTimeout(timerID);
```
#### setInterval()/clearInterval()
```js
var timerID = setInterval("timeOutCode", msec);
clearInterval(timerID);
```

윈도우 위치 및 크기 조절
---

윈도우를 오른쪽으로 5픽셀, 아래로 10픽셀 이동
```js
window.moveBy(5, 10);
moveBy(5, 10);
```
윈도우를 스크린의 (25, 10) 위치로 이동
```js
window.moveTo(25, 10);
self.moveTo(25, 10);
```
윈도우 크기를 5 픽셀 좁게, 10픽셀 길게 조절
```js
window.resizeBy(-5, 10);
resizeTo(self.outerWidth-5, self.outerHeight+10);
```
윈도우 크기를 200x300으로 조절
```js
window.resizeTo(200, 300);
```

웹 페이지 스크롤
---
웹 페이지를 위로 10픽셀 스크롤(마우스 스크롤 다운)
```js
window.scrollBy(0, 10); // 옆으로 0, 위로 10픽셀
```
웹 페이지를 왼쪽으로 10픽셀, 아래로 15픽셀 스크롤(마우스 스크롤 업)
```js
window.scrollBy(10, -15);
```
웹 페이지의 (0, 200) 좌표 부분이 현재 윈도우의 왼쪽 상단 모서리에 출력되도록 스크롤
```js
window.scrollTo(0, 200);
```
