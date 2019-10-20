Rebase Commit
===

### 작성자 변경
```bash
$ git rebase -i <commit hash>
pick -> edit
$ git commit —amend —author="AuthorName <email@address.com>"
$ git rebase —continue
$ git push -f
```

### 작성시간 변경
```bash
$ git rebase -i <commit hash>
pick -> edit
$ GIT_COMMITTER_DATE="Sat 19 Oct 00:00:00 2019 KST" git commit --amend --no-edit --date "Sat 19 Oct 00:00:00 2019 KST"
$ git rebase —continue
$ git push -f
```
