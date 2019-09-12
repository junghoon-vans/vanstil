WSL Terminal Customizing
------------------------

### WSL 터미널 테마 변경

`Windows Subsystem for Linux` 터미널의 문제점

-	기본적으로 제공하는 색상이나 폰트가 예쁘지 않고 가독성이 떨어짐.
-	Windows에서 제공하는 기본 터미널인 CMD를 기반으로 하기 때문

#### 터미널 색상 변경

폰트나 배경 색상을 바꾸는 것으로 위 문제점들을 해결할 수 있음. WSL에서 제공하는 터미널은 CMD를 활용한 것이므로, CMD의 색상 설정으로 WSL 색상 변경이 가능함.

-	WSL의 테마 설정만 변경하는 방법

	-	설치된 `Ubuntu`와 같은 WSL Shell을 실행
	-	창에서 마우스 우클릭, 속성 선택
	-	WSL 설정 창에서 색 탭 선택
	-	색상 슬롯의 RGB값을 지정

우분투 기본 색상에 맞추고 싶으면 아래와 같이 설정해준다.

-	Ubuntu default Background-color: `RGB(48,10,36)`
