윈도우나 맥에서는 기본적으로 깃 사용자의 아이디 및 비밀번호를 저장하여 관리한다.
반면 우분투에서 깃을 사용하면 `git pull/push`를 할 때마다 아이디 비밀번호를 입력해야만 한다. 이러한 번거로움을 줄이기 위해 `Git Credential`이라는 계정정보 저장기능을 사용한다.

### 영구 저장
```bash
git config --global credential.helper store
```

> global 속성을 제외하면 해당 디렉토리에만 적용된다.

### 캐시로 저장
```bash
git config --global credential.helper cache
```

> cache는 기본적으로 15분 동안 인증 절차를 요구하지 않는다.

```bash
git config credential.helper 'cache --timeout=3600'
# 3600초 동안 인증 절차를 생략한다.
```

> 시간을 설정할 때는 위와 같이 timeout 속성을 이용한다. (단위는 초)
