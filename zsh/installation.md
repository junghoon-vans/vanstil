---
title: "Installation"
linkTitle: "Installation"
date: 2020-11-16
type: docs
draft: false
weight: 1
description: >
  ZSH 설치하기
---


`ZSH(Z Shell)`은 강력한 자동완성 기능을 제공하는 bash보다 개선된 쉘이다. 그렇기 때문에 개발하는 데 있어서 명령어를 모두 외우지 않아도 된다는 점에서 사용자에게 큰 편의성을 제공한다. 그래서 인지 `macOS Catalina`에서는 기본 쉘로 zsh이 채택되기도 했다. 

### zsh 설치

```Bash
    $ sudo apt-get install zsh
    # 기본 쉘을 zsh로 변경
    $ chsh -s /usr/bin/zsh
```

혹시라도 아래와 같은 메시지가 나오면 2번을 선택해주면 된다.

```Bash
This is the Z Shell configuration function for new users,
zsh-newuser-install.
You are seeing this message because you have no zsh startup files
(the files .zshenv, .zprofile, .zshrc, .zlogin in the directory
~). This function can help you with a few settings that should
make your use of the shell easier.

You can:

(q) Quit and do nothing. The function will be run again next time.

(0) Exit, creating the file ~/.zshrc containing just a comment.
That will prevent this function being run again.

(1) Continue to the main menu.

(2) Populate your ~/.zshrc with the configuration recommended
by the system administrator and exit (you will need to edit
the file by hand, if so desired).
```

### oh-my-zsh 설치

oh-my-zsh는 zsh에 여러가지 플러그인을 추가하여 커스터마이징할 수 있도록 하는 플러그인이다. 설치하는 방법은 아래와 같다.

```Bash
    $ curl -L https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh | sh
```

### 테마 적용

`oh-my-zsh`의 기본 테마는 `robbyrussell`로 되어 있으나 `agnoster`라는 더 이쁜 테마를 사용할 수도 있다. 적용 방법은 이와 같다.  

```Bash
    $ sudo vi ~/.zshrc
```

```vim
    ZSH_THEME = "agnoster" # 해당 부분만 변경 후 저장
```
