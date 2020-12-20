---
title: "Set default python version"
linkTitle: "Set default python version"
date: 2020-11-16
type: docs
draft: false
description: >
  우분투에서 파이썬 명령어를 쉽게 쓰기
---

- 우분투에는 기본적으로 파이썬2가 설치되어 있다.
- `python` 명령어를 사용했을 시 이것이 기본적으로 호출된다.
- 파이썬3를 사용하기 위해서는 `python3` 명령어를 사용해야 한다.

문제 원인
---

```bash
$ python3 --version
Python 3.6.9 # 현재 설치된 파이썬 버전
$ which python
/usr/bin/python # 파이썬 링크 파일 경로
$ ls -al /usr/bin/python
lrwxrwxrwx 1 root root 9 Apr 16  2018 /usr/bin/python -> python2.7
```

> 현재 /usr/bin/python 파일은 2.7 버전을 링크하고 있다.

해결 방법
---

Linux의 alternative를 사용하면 파이썬 버전을 쉽게 변경하는 것이 가능하고 추후 관리가 용이하다.

```bash
$ sudo update-alternatives --config python
update-alternatives: error: no alternatives for python
```

위와 같이 error가 발생할 수 있는데 아직 alternative를 설정하지 않았기 때문이다.

```bash
$ sudo update-alternatives --install /usr/bin/python python /usr/bin/python2.7 1
$ sudo update-alternatives --install /usr/bin/python python /usr/bin/python3.6 2
```

사용할 파이썬 버전들을 alternative에 등록하는 과정으로 컴퓨터 상에 설치된 버전에 따라 위 명령어는 상이할 수도 있다.

```bash
sudo update-alternatives --config python
There are 2 choices for the alternative python (providing /usr/bin/python).

 Selection    Path                Priority   Status
------------------------------------------------------------
* 0            /usr/bin/python3.6   2         auto mode
 1            /usr/bin/python2.7   1         manual mode
 2            /usr/bin/python3.6   2         manual mode

Press <enter> to keep the current choice[*], or type selection number:
```

다시 `sudo update-alternatives --config python`를 해서 alternative 목록을 조회한 다음, 원하는 버전의 번호를 선택하여 엔터를 치면 해당 버전이 기본으로 설정된다.

```bash
$ python --version
Python 3.6.9
```

이제 `python` 명령어로 파이썬3가 호출된다.
