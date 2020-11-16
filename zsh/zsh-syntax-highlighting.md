---
title: "zsh-syntax-highlighting"
linkTitle: "zsh-syntax-highlighting"
date: 2020-11-16
type: docs
draft: false
weight: 2
description: >
  ZSH 상에 문법 강조하기
---

설치
---

설치하는 방법에는 두 가지가 존재하는 데 필자는 플러그인으로 추가하는 방법을 추천한다.

### 일반 설치

#### 설치
```Bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git
echo "source ${(q-)PWD}/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh" >> ${ZDOTDIR:-$HOME}/.zshrc
```
위 코드를 그대로 복사 후 Shell에서 실행
> 설치된 경로가 zshrc의 마지막 줄에 추가된다.

#### 적용
```Bash
source ./zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
```
> syntax highlighting 재실행 없이 적용

### plugin manager 이용
oh-my-zsh의 plugin으로써 설치하고 사용하는 방법은 다음과 같다.

#### 설치
```Bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

#### 플러그인을 .zshrc에 추가
```Bash
plugins=( [plugins...] zsh-syntax-highlighting) # zsh-syntax-highlighting 마지막에 추가
```

#### 적용
우분투 Shell을 재실행하면 적용된다.

오류 해결
---
`plugin manager`로 적용시키다 보면 `insecure directories`라는 오류가 발생할 수 있는데, 이럴때는 아래와 같은 코드를 실행하면 된다.

```bash
compaudit | xargs chmod g-w,o-w
```
