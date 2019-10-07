oh-my-zsh Customization
===

Contents
---

- [사용자 이름 표시 생략](#사용자-이름-표시-생략)
  - [기본 유저 변경](#기본-유저-변경)
  - [prompt context](#prompt-context)
- [멀티 라인 적용](멀티-라인-적용)

사용자 이름 표시 생략
---
방법은 크게 2가지 정도가 있는데, 모두 `~/.zshrc`에 작성해주면 된다.

### 기본 유저 변경
```vi
DEFAULT_USER="$(whoami)"
```
> `whoami`는 기본 유저를 지정하지 않을 때 사용

### prompt context
```vi
prompt_context(){}
```
> 중괄호 사이에는 유저를 프롬프트에 표기하는 형식을 지정할 수 있다. 비워두면 유저명이 생략된다.

멀티 라인 적용
---

`zsh`와 `agnoster`를 이용해서 리눅스 개발환경을 깔끔하게 할 수 있다.
만약 이때 경로가 너무 길어서 보기 불편하다거나, 경로가 표기되는 줄 이후에 명령줄이 나오면 좋겠다면 다음과 같은 방법으로 멀티 라인 적용이 가능하다.


```vi
# 멀티라인 적용 함수
prompt_newline() {
  if [[ -n $CURRENT_BG ]]; then
    echo -n "%{%k%F{$CURRENT_BG}%}$SEGMENT_SEPARATOR
%(?.%F{$CURRENT_BG}.%F{red})❯%f"

  else
    echo -n "%{%k%}"
  fi

  echo -n "%{%f%}"
  CURRENT_BG=''
}
```

우선 위와 같은 코드를 `~/.oh-my-zsh/themes/agnoster.zsh-theme` 파일에 작성해준다.

```vi
## Main prompt
build_prompt() {
  RETVAL=$?
  prompt_status
  prompt_virtualenv
  prompt_context
  prompt_dir
  prompt_git
  prompt_hg
  prompt_newline # 멀티라인 호출
  prompt_end
}
```

`~/.oh-my-zsh/themes/agnoster.zsh-theme` 하단에 위치한 build_prompt()에 `prompt_newline`를 불러올 수 있도록 추가해준다.

---
**참고자료**
https://wayhome25.github.io/etc/2017/03/12/zsh-alias/
