core.autocrlf
===
`git`을 통해서 윈도우와 맥이나 리눅스 개발자가 협업을 할 때 개행문자의 차이로 인해 `whitespace` 에러가 발생한다.

```bash
$ git add README.md
warning: LF will be replaced by CRLF in README.md.
The file will have its original line endings in your working directory
```
> 운영체제에 맞춰서 개행 문자를 바꾸게 된다는 것을 매번 에러 메시지로 알려준다.

이러한 문제를 해결하는 가장 간단한 방법은 개행 문자를 LF로 통일하는 것이다. 이를 가능하게 해주는 기능이 `git`에 이미 존재하는데 그것이 바로 `core.autocrlf`이다.

### 윈도우 사용자
``` bash
git config --global core.autocrlf true
```
윈도우에서 사용되는 파일은 CRLF이기 때문에 커밋할 때 LF로 바꿔주고, checkout할 때는 LF를 CRLF로 바꿔주는 과정이 필요하다.

### 맥이나 리눅스
``` bash
git config --global core.autocrlf input
```
맥이나 리눅스는 개행문자가 LF이기 때문에 커밋할 때 바꾸지 않아도 되고, 가져올 때도 변경할 필요가 없다. 하지만 혹시라도 로컬에 있는 파일에 CRLF가 있다면 LF로 변경해주길 원한다면 다음과 같은 코드를 사용하자.

### 메시지 삭제
오류 메시지만 지우고 알아서 작업하고 싶은 경우에는 다음 코드를 사용하면 된다.
``` bash
git config --global core.autocrlf false
```
