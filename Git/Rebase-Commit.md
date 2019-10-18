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
