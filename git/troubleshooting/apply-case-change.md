Git은 일반적인 파일명 변경으로는 대소문자를 변경이 적용되지 않는다.

해결
---

이러한 경우 대소문자 적용은 파일 이동 명령어인 `mv`의 `--force` 옵션을 사용하면 된다.

```bash
git mv --force pre_file new_file
git commit -m "message"
git push
```
