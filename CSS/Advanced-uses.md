Advanced uses
=============

Contents
--------

-	[리스트 꾸미기](#리스트-꾸미기)
	-	[마커 위치](#마커-위치)
	-	[마커 종류](#마커-종류)
	-	[이미지 마커](#이미지-마커)
	-	[단축 프로퍼티](#단축-프로퍼티)
-	[표 꾸미기](#표-꾸미기)
	-	[테두리](#테두리)
	-	[셀 크기](#셀-크기)
	-	[셀 여백 및 정렬](#셀-여백-및-정렬)
	-	[배경색과 테두리 효과](#배경색과-테두리-효과)
	-	[줄무늬](#줄무늬)
-	[폼 꾸미기](#폼-꾸미기)
-	[동적 변화](#동적-변화)
	-	[애니메이션](#애니메이션)
	-	[전환](#전환)
	-	[변환](#변환)

리스트 꾸미기
-------------

리스트는 데이터 나열 이외에도 목차나 메뉴를 만들거나 관련 링크 모음을 만드는 등 여러 용도로 활용

### 마커 위치

```css3
list-style-position: inside|outside
```

### 마커 종류

```css3
list-style-type: disc|armenian|circle|cjk-ideographic|decimal|georgian|lower-alpha|lower-roman|square|upper-alpha|upper-roman|none
```

### 이미지 마커

사용자가 이미지 마커 지정`CSS3
lis-style-image: url("이미지 위치");
`

### 단축 프로퍼티

```css3
list-style: list-style-type list-style-position list-style-image
```

표 꾸미기
---------

### 테두리

```css3
table{
  border: 1px solid blue;
  /* 테두리 두께, 선 스타일, 색상 */
  border-collapse: collapse;
  /* 중복된 테두리 합치기 */
}
```

### 셀 크기

```css3
th {
  height: 40px;
  width: 100px;
}
td {
  height: 20px;
  width: 100px;
}
```

### 셀 여백 및 정렬

```css3
td {
  padding: 10px; /* 여백 */
  text-align: left|center|right
}
```

### 배경색과 테두리 효과

```CSS3
thead {
  background : darkgray;
  color : yellow;
}
td, tfoot th {
  border-bottom : 1px solid gray
  /* 아래쪽테두리만회색*/
}
```

### 줄무늬

행에 번갈아 배경색을 주어 줄무늬를 만들어 가도성을 높임

```css3
tbody tr:nth-child(even) { /* 짝수<tr>에적용*/
   background : aliceblue;
 }
```

폼 꾸미기
---------

```css3
input[type=text]:hover {
  border: 2px solid skyblue;
  border-radius: 5px;
}
```

> 마우스가 위에 올라갔을 때 text 속성을 가진 input 태그 스타일이 적용됨

동적 변화
---------

### 애니메이션

HTML 태그의 모양 변화를 시간 단위로 설정

1.	`@keyframes`로 HTML 태그의 시간별 모양 변화 그리기

```css3
@keyframestextColorAnimation{
   0% { color : blue; } /* 시작시. 0% 대신 from 사용가능*/
   30% { color : green; } /* 30% 경과시까지*/
   100% { color : red; } /* 끝까지. 100% 대신 to 사용가능*/
```

1.	애니메이션 스타일 시트 작성

```CSS3
span {
	animation-name : textColorAnimation; /* 애니메이션코드이름*/
	animation-duration : 5s; /* 애니메이션1회시간은5초*/
	animation-iteration-count : infinite; /* 무한반복*/
}
```

### 전환

HTML 태그에 적용된 CSS3 프로퍼티 값의 변화를 서서히 진행시켜 애니메이션 효과 생성, `transition` 프로퍼티 사용

```CSS3
span{
	transition : font-size 5s;
}
span:hover{
	font-size : 500%;
 }
```

### 변환

텍스트나 이미지를 회전, 확대 다양한 기하학적인 모양으로 출력

```CSS3
div {
	transform : rotate(20deg);
}
```
