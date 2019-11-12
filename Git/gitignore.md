gitignore
===
깃으로 관리하지 않을 파일을 지정

적용 방법
---
1. 프로젝트 폴더 내에 `.gitignore` 파일 생성
2. 레파지토리에 업로드하지 않을 파일이나 폴더 지정

> [링크](http://www.gitignore.io)에 프로그래밍 언어나 IDE를 입력하면, 불필요한 파일을 제거하기 위한 `.gitignore`를 빠르게 작성 가능하다.

제대로 적용되지 않는 문제 해결
---
이미 깃 저장소에 올라간 파일에 대해서 `gitignore`가 적용되지 않는 경우, 아래와 같은 코드로 해결 가능하다.

```bash
$ git rm -r --cached .
$ git add .
$ git commit -m "fixed untracked files"
```
