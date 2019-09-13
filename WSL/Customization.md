WSL Terminal Customizing
------------------------

`Windows Subsystem for Linux` 터미널의 문제점

-	기본적으로 제공하는 색상이나 폰트가 예쁘지 않고 가독성이 떨어짐.
-	Windows에서 제공하는 기본 터미널인 CMD를 기반으로 하기 때문임.

### 터미널 색상 변경

---

폰트나 배경 색상을 바꾸는 것으로 위 문제점들을 해결할 수 있다. WSL에서 제공하는 터미널은 CMD를 활용한 것이므로, CMD의 색상 설정으로 WSL 색상 변경이 가능하다.

#### 1. WSL의 테마 설정만 변경하는 방법

-	설치된 `Ubuntu`와 같은 WSL Shell을 실행
-	창에서 마우스 우클릭, 속성 선택
-	WSL 설정 창에서 색 탭 선택
-	색상 슬롯의 RGB값을 지정

우분투 기본 색상에 맞추고 싶으면 아래와 같이 설정해준다.

-	Ubuntu default Background-color: `RGB(48,10,36)`

#### 2. CMD 컬러를 변경하는 방법

-	Microsoft Colortool을 이용

### 터미널 폰트 변경

---

기본 폰트가 코딩을 하는데 있어서 가독성이 떨어지므로, 다른 폰트로 변경하는 것이 좋다.

#### WSL 폰트 변경 방법

-	WSL Shell 실행
-	창에서 마우스 우클릭, 속성 선택
-	WSL 설정 창에서 글꼴 탭 선택
-	설치된 폰트 중에서 선택

#### 가독성 좋은 폰트

기본적으로 윈도우에서 제공하는 `Consolas` 폰트도 괜찮긴 하지만 우분투에서 사용하는데에는 가독성이 좋지 않다. 그러므로 아래와 같은 폰트로 변경하는 것이 좋을 것이다.

-	[Bitstream Vera Sans Mono](https://www.dafont.com/bitstream-vera-mono.font)
-	[DejaVu Sans Mono](https://github.com/powerline/fonts/tree/master/DejaVuSansMono)
-	[D2Coding](https://github.com/naver/d2codingfont)

개인적으로 이 중에서 한글 지원이 잘 되는 `D2Coding` 폰트가 사용하기 좋았다.

### zsh/oh-my-zsh 설치

---

WSL에서 기본적으로 제공하는 리눅스 Shell은 `bash`이다. 다양한 테마와 기능을 제공하는 `zsh`를 사용하면 보다 편리하게 코딩 작업이 가능하다.

-	zsh 설치

```Bash
    $ sudo apt-get install zsh
```

-	oh-my-zsh 설치

```Bash
    sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

-	테마변경

```Bash
    $ sudo vi ~/.zshrc
```

```vim
    ZSH_THEME = "agnoster" # 해당 부분만 변경 후 저장
```
