---
title: "fatal: the remote end hung up unexpectedly"
linkTitle: "fatal: the remote end hung up unexpectedly"
date: 2020-11-16
type: docs
draft: false
---

문제 발생
---

깃헙 레파지토리의 변경사항을 로컬에 적용하기 위해 `git pull` 명령어를 사용했을 때 발생

```bash
$ git pull

fatal: the remote end hung up unexpectedly
```

문제 원인
---

git의 HTTP `POST Buffer` 사이즈가 작아서 오버플로우 발생

> 해당 문제는 `git pull`뿐 아니라 `git push`에서도 발생할 수 있다.

문제 해결
---

깃 설정을 통해서 버퍼 사이즈를 변경하여 해결하였다.

```bash
$ git config --global http.postBuffer 524288000 #Set to 500MB

$ git pull
From https://github.com/Jeonghun-Ban/TIL
 + 047102b...836e520 master     -> origin/master  (forced update)
Already up to date.
```