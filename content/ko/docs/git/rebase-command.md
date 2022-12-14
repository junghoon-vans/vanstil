---
title: "Rebase Command"
linkTitle: "Rebase Command"
date: 2020-11-16
type: docs
draft: false
description: >
    커밋 정리하기
---

커밋 수정
---

### 가장 최근 커밋 수정

```bash
$ git commit --amend # vi 등 편집기로 수정
$ git commit --amend -m "rewrite message" # 옵션으로 변경도 가능
$ git commit --amend --author="auther_name <auther_email>"
```

`git add` 명령어로 변경사항을 Staging Area에 넣고, `git commit --amend` 명령어를 실행하면 최신 커밋에 변경사항이 반영된다.

### 특정 커밋 수정

```bash
$ git rebase -i <commit hash>
# pick -> edit
$ git commit --amend
$ git rebase --continue
$ git push -f
```

여러 개의 커밋을 수정하는 것도 가능한데 `git rebase -i` 명령어를 실행하고 수정할 커밋을 모두 edit으로 지정해주면 된다. 이후에는 `git commit --amend`와 `git rebase --continue` 명령어를 반복해서 진행하며 메시지를 하나씩 수정해주면 된다.

> 해시는 `git log` 명령어로 확인 가능하다.

커밋 합치기
---

```bash
$ git rebase -i HEAD~2 # 가장 최근 커밋 두개
# 합치고 없앨 커밋 pick -> f, fixup
$ git commit --amend 
$ git push -f
```

git을 관리하다 보면 커밋을 합쳐야 하는 경우가 있다. 예를 들면 하나의 기능 구현에 대한 커밋이 여러 개로 나누어져 있는 경우, 모두 하나로 합쳐서 올리는 것이 바람직하다. 이럴 때 위 명령어를 이용하면 손쉽게 합칠 수 있다.

작성시간 변경
---

```bash
$ git rebase -i <commit hash>
pick -> edit
$ GIT_COMMITTER_DATE="Mon 21 Oct 00:00:00 2019 KST" git commit --amend --no-edit --date "Mon 21 Oct 00:00:00 2019 KST"
$ git rebase --continue
$ git push -f
```
