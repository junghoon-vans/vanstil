우분투의 경우 apt 패키지를 ``` http://archive.ubuntu.com/ubuntu```에서 가져오도록 설정되어 있는데, 해당 주소에서 다운 속도가 느리기 때문에 한국 서버로 변경하면 편리하다.

다음카카오에서 apt 패키지를 다운받을 수 있는 ftp서버를 제공하고 있으므로 이것을 이용하도록 하자.

설정
---

```bash
$ sudo vi /etc/apt/sources.list
```

vi 편집모드에서 ```:%s/archive.ubuntu.com/ftp.daumkakao.com/g```를 입력하면 기존 주소들을 모두 다음카카오 서버주소로 변경시킬 수 있다.

이후 apt 패키지를 다운받으면 정상적으로 카카오서버에서 받아오는 것을 확인할 수 있다.