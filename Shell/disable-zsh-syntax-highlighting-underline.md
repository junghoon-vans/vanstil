disable zsh-syntax-highlighting underline
===

`zsh-syntax-highlighting`을 사용하는 경우, 파일이나 디렉터리의 경로가 밑줄이 그어진다.
다만 WSL 우분투에 위 기능을 사용하게 되면 창 리사이즈 시 밑줄이 화면 한 줄을 차지해버리는 문제가 발생한다.
따라서 이 기능을 지워서 사용하는 것이 오히려 편리하다.

### underline 기능 없애기

`~/.zshrc`를 편집기로 실행한다.

```vi
ZSH_HIGHLIGHT_STYLES[path]=none
ZSH_HIGHLIGHT_STYLES[path_prefix]=none
```

위 코드를 `.zshrc`의 맨 하단에 추가하고, 저장 및 종료한다.
그러면 파일 경로 밑줄 표시 기능이 없어진다.
