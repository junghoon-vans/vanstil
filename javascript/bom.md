---
title: "Browser Object Model"
linkTitle: "BOM"
date: 2020-11-16
type: docs
draft: false
weight: 8
description: >
  웹 브라우저 조작을 위한 객체
---

- window: 브라우저 윈도우 모양 제어, 새 윈도우 열기/닫기
- location: 브라우저 윈도우에 로드한 HTML 페이지의 URL 관리
- navigator: 브라우저에 대한 다양한 정보 제공
- screen: 브라우저가 실행되고 있는 스크린 장치에 대한 정보 제공
- history: 브라우저 윈도우에 로드한 URL 리스트와 히스토리

자바스크립트로 브라우저를 제어하기 위해 지원하는 객체들은 위와 같다.

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

### 윈도우 위치 및 크기 조절

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

### 웹 페이지 스크롤
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

location
---
- 윈도우에 로드된 웹 페이지의 URL 정보를 나타내는 객체
- location 객체로 현재 윈도우에 웹 페이지 열기
```js
window.location = "http://www.naver.com";
window.location.href = = "http://www.naver.com";
window.location.assign("http://www.naver.com");
window.location.replace("http://www.naver.com");
```
- 새 윈도우에 웹 페이지 열기
```js
var win=window.open(); // 빈 윈도우 열기
win.location="http://www.naver.com"; // 네이버 페이지 로드
```

### 프로퍼티와 메소드
| 프로퍼티 | 설명 |
| :------------- | :------------- |
| hash  | `#`을 포함하는 앵커 이름 문자열 |
| host | 도메인과 포트 번호를 포함하는 웹 서버 주소 문자열 |
| hostname | 웹 서버 이름 |
| href | URL 전체 문자열 |
| pathname | 디렉터리 부분 문자열 |
| port | 포트 번호 문자열 |
| protocol 프로토콜 문자열 |
| search | URL에서 `?`와 그 뒷부분 문자열로서,  주로 웹 서버로 검색을 요청할 때 동반되는 파라미터 문자열 |

| 메소드 | 설명     |
| :------------- | :------------- |
| assign() | 새로운 웹 페이지를 로드한다. |
| reload() | 현재 웹 페이지를 다시 로드한다. 페이지가 수정되었으면 반영한다. |
| replace() | 현재 웹 페이지의 URL을 히스토리에서 제거하고, 새로운 페이지를 로드한다. |

navigator
---

- 현재 작동중인 브라우저에 대한 다양한 정보를 나타내는 객체
- window.navigator 또는 navigator

| 프로퍼티 | 설명     |
| :------------- | :------------- |
| appCodeName | 브라우저의 코드 이름을 가진 문자열 |
| appName | 브라우저 이름 문자열 |
| appVersion | 브라우저의 플랫폼과 버전에 관한 문자열 |
| platform | 운영체제 플랫폼의 이름 |
| product | 브라우저 엔진의 이름 |
| userAgent | 브라우저가 웹 서버로 데이터를 전송할 때, HTTP 헤더 속의 user-agent 필드에 저장하는 문자열로서 웹 서버가 클라이언트를 인식하기 위한 목적 |
| vendor | 브라우저 제작 회사의 이름 문자열 |
| language | 브라우저의 언어를 나타내는 문자열 |
| onLine | 브라우저가 현재 온라인 작동중이면 true, 아니면 false |
| plugins | 브라우저에 설치된 플러그인에 대한 컬렉션 |
| cookieEnabled | 브라우저에 쿠키를 사용할 수 있는 상태면 true, 아니면 false |
| geolocation | 위치 정보를 제공하는 geolocation 객체에 대한 레퍼런스 |

screen
---

- 브라우저가 실행되는 스크린 장치에 관한 정보를 담고 있는 객체
- window.screen 혹은 screen

| 프로퍼티 | 설명 |
| :------------- | :------------- |
| availHeight | 작업 표시줄 등을 제외하고 브라우저가 출력 가능한 영역의 높이 |
| availWidth | 작업 표시줄 등을 제외하고 브라우저가 출력 가능한 영역의 폭 |
| pixelDepth | 한 픽셀의 색을 나타내기 위해 사용되는 비트 수 |
| colorDepth | 한 픽셀의 색을 나타내기 위해 사용되는 비트 수로, pixelDepth와 동일. 대부분 브라우저에서 지원되므로 pixelDepth보다 이것을 사용하는 것이 권장됨 |
| height | 스크린의 수직 픽셀 수 |
| width | 스크린의 수평 픽셀 수 |

history
---

- 윈도우에서 방문한 웹 페이지 리스트(히스토리)를 나타내는 객체
- Window.history 혹은 history

| 프로퍼티 | 설명 |
| :------------- | :------------- |
| length | 히스토리 리스트에 있는 엔트리 수 |

| 메소드 | 설명 |
| :------------- | :------------- |
| back() | 히스토리에 있는 이전 웹 페이지로 이동. 브라우저의 <back> 버튼과 동일 |
| forward() | 히스토리에 있는 다음 웹 페이지로 이동. 브라우저의 <forward> 버튼과 동일 |
| go(n) | 히스토리에서 현재 웹 페이지에서 n만큼 상태적인 웹 페이지로 이동 |
