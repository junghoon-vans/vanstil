Box Model
===

Contents
---
- [박스 모델](#박스-모델)
  - [구성](#구성)
  - [프로퍼티](#프로퍼티)
- [다양한 스타일](#다양한-스타일)
  - [둥근 모서리](#둥근-모서리)
  - [이미지 테두리](#이미지-테두리)
  - [배경](#배경)
  - [시각적 효과](#시각적-효과)
    - [텍스트 그림자](#텍스트-그림자)
    - [박스 그림자](#박스-그림자)
- [배치](#배치)
  - [블록 박스와 인라인 박스](#블록-박스와-인라인-박스)
  - [박스 유형 제어](#박스-유형-제어)

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
broder-radius: 0px 20px 40px 60px;
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
- background-position: 배경 이미지 위치#
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

### 박스 유형 제어
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
