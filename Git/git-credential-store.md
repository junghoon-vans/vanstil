git credential store
===
윈도우나 맥에서는 기본적으로 깃 사용자의 아이디 및 비밀번호를 저장하여 관리한다.
반면 우분투에서 깃을 사용하면 `git pull/push`를 할 때마다 아이디 비밀번호를 입력해야만 한다. 이러한 번거로움을 줄이고자 `git credential`이라는 계정정보 저장기능을 이용할 수 있다.

### 영구 저장
```bash
git config --global credential.helper store
```

### 캐시로 저장
```bash
git config --global credential.helper cache
```
> global 속성을 제외하면 해당 디렉토리에만 적용된다.
