---
title: "Box Model"
date: 2020-11-16
type: docs
draft: false
weight: 3
---

박스 모델
---
HTML 태그는 사각형 박스로 다루어진다.
  - 각 HTML 태그 요소를 하나의 박스로 다룸
  - 박스 크기, 배경 색, 여백, 옆 박스와의 거리 등 제어 가능

### 구성
**Contents**
HTML 태그의 텍스트나 이미지가 출력되는 부분
**Border**
박스 모델의 테두리로서, 직선이나 점선 혹은 이미지로 테두리를 그릴 수 있음
**Padding**
콘텐츠를 직접 둘러싸고 있는 내부 여백
**Margin**
박스의 맨 바깥 영역이며 테두리 바깥의 공간으로 인접한 아래위 이웃 태그의 박스와의 거리

### 프로퍼티
|    | 콘텐츠 | 패딩 | 테두리 | 여백|
| :------------- | :------------- | :------------- | :------------- | :------------- |
| 크기 관련 프로퍼티  |  width <br> height  | padding-top <br> padding-right <br>padding-bottom <br> padding-left | border-top-width <br> border-right-width <br> border-bottom-width <br> border-left-width | margin-top <br> margin-right <br> margin-bottom <br> margin-left |
| 크기 단축 프로퍼티 | | padding | border-width | margin |
| 스타일 관련 프로퍼티| | | border-top-style <br> border-right-style <br> border-bottom-style <br> border-left-style| |
| 스타일 단축 프로퍼티 | | | border-style | |
| 색 관련 프로퍼티 | | | border-top-color <br> border-right-color <br> border-bottom-color <br> border-left-color | |
| 색 단축 프로퍼티 | | | border-color | |
| 전체 단축 프로퍼티 | | | border | |

다양한 스타일
---

### 둥근 모서리
```css3
border-radius: 50px;
border-radius: 0px 20px 40px 60px;
/* 왼쪽 상단부터 시계 방향으로 적용 */
```

### 이미지 테두리
```css3
border-image: url("border.jpg") 30 round:
/* border.jpg 이미지를 불러와서 테두리로 사용 */
```
> round– 테두리 길이만큼 이미지 크기 조절해서 반복 배치
> repeat-이미지 반복 배치, 이미지 크기 조절X
> stretch–이미지를 테두리 길이만큼 늘여 배치

### 배경

- background-color: 배경 색
- background-image: 배경 이미지
- background-position: 배경 이미지 위치
- background-repeat: 배경 이미지 반복 출력

#### 단축 프로퍼티
```CSS3
background : skyblue url("media/spongebob.png") center center/100px 100px repeat-y;
/* color, image, position/size, repeat, origin 순 */
```

###시각적 효과
#### 텍스트 그림자
```css3
text-shadow: h-shadow v-shadow blur-radius color|none
```
- h-shadow v-shadow
  - 원본 텍스트와 그림자 텍스트 사이의 거리
- blur-radius
  - 흐릿한 그림자를 만드는 효과로 번지는 길이

#### 박스 그림자
```css3
box-shadow: h-shadow v-shadow blur-radius spread-radius color|none|inset
```

- spread-radius: 그림자 크기
- inset: 음각 박스로 보이게 박스 상단 안쪽에 그림자 형성

배치
---

### 블록 박스와 인라인 박스
- HTML 태그는 인라인 태그와 블록 태그로 나뉨
  - 인라인 태그는 인라인 박스, 블록 태그는 블록 박스로 출력
- 블록 박스와 인라인 박스의 디폴트 출력 모양

### display
디폴트 박스 유형을 무시하고, HTML 태그의 박스 유형을 달리 지정
```css3
display: block;
display: inline;
display: inline-block;
```

- 블록박스
  - 항상 새 라인에서 시작
  - 블록 박스 내에만 배치
  - 옆에 다른 요소 배치 불가능
  - width와 height로 크기 조절
  - padding, border, margin 조절 가능
- 인라인 박스
  - 새 라인에서 시작 못함
  - 모든 박스 내 배치 가능
  - 옆에 다른 요소 배치 가능
  - width와 height로 크기 조절 불가능
  - padding, border, margin 조절 가능 불가능
- 인라인 블록 박스
  - 새 라인에서 시작 못함
  - 모든 박스 내에서 배치 가능
  - 옆에 다른 요소 배치 가능
  - width와 height로 크기 조절 가능
  - padding, border, margin 조절 가능

### position
박스의 배치에 사용하는 프로퍼티
- normal flow
  - 웹 페이지에 나타난 순서대로 HTML 태그 배치
- position 프로퍼티를 이용한 배치
  - 정적 배치 - `position: static`
  - 상대 배치 - `position: relative`
  - 절대 배치 - `position: absolute`
  - 고정 배치 - `position: fixed`
  - 유동 배치 - `float : left|right`
> position을 이용할 때, 태그 위치와 크기는 top, bottom, left, right, width, height 프로퍼티로 지정

### z-index
HTML 태그들을 z축을 따라 수직으로 쌓는 프로퍼티로 값이 클수록 위에 위치
- z-index의 지정이 없는 경우, HTML문서에 나오는 순서로 z-index의 값이 자동 결정
- z-index는 position의 프로퍼티가 relative나 absolute인 경우에만 작동

### visibility
태그를 보이거나 숨길 때 사용
- 사용법: `visibility: visible|hidden`
- hidden을 사용하더라도 공간은 차지

### overflow
콘텐츠가 width와 height 프로퍼티에서 설정한 태그의 크기를 넘어가는 경우 콘텐츠를 자를지 말지 지정함
- 블록태그에만 적용됨
- overflow 프로퍼티는 박스 크기가 지정되어 있어야 함
- 사용법: `overflow: visible|hidden|scroll|auto`
  - visible: 콘텐츠가 잘리지 않고 태그 영역을 넘어 출력(디폴트)
  - Hidden: 콘텐츠를 태그 크기로 잘라 넘어가는 것은 보이지 않음. 스크롤바없음
  - Scroll: 스크롤바를 항상 부착하여 콘텐츠 출력
  - Auto: 콘텐츠가 박스높이(height)보다 넘치면 스크롤바 자동생성
