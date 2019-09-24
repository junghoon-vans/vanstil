zsh-syntax-highlighting
==
Contents
---
- 설치
  - [zshrc에 설치](#zshrc에-설치)
  - [plugin manager 이용](#plugin-manager-이용)

설치
---
### zshrc에 설치

1. 설치
```Bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git
echo "source ${(q-)PWD}/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh" >> ${ZDOTDIR:-$HOME}/.zshrc
```
위 코드를 그대로 복사 후 Shell에서 실행

2. 적용
```Bash
source ./zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
```
> syntax highlighting 바로 적용

### plugin manager 이용
oh-my-zsh의 plugin으로써 설치하고 사용하는 방법은 다음과 같다.

1. 설치
```Bash
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

2. 플러그인을 .zshrc에 추가
```Bash
plugins=( [plugins...] zsh-syntax-highlighting) # zsh-syntax-highlighting 마지막에 추가
```

3. 재실행
우분투 Shell을 재실행하면 적용된다.
