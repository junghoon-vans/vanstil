Set Timezone
===

프로젝트 진행 중, 프론트 단에서 시간을 불러와야 하는 상황이 발생하였다. 다만 aws ec2 서버의 기준 시간대가 UTC로 잡혀있었고 이를 한국시간대로 변경해야 했다. `tzselect` 명령어를 사용해봤지만 시간대 적용이 되지 않아 다음과 같은 방법으로 서버시간대를 변경할 수 있었다.

문제해결
---

```bash
$ cat /etc/localtime
TZif2UTCTZif2�UTC
UTC0
$ sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
$ date
Mon Mar  9 02:21:42 KST 2020
```