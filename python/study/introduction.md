---
title: "Introduction"
linkTitle: "Introduction"
date: 2020-11-16
type: docs
draft: false
weight: 1
description: >
  파이썬 시작하기
---

파이썬이 설치되어 있지 않다면 우선 [이 링크](https://www.python.org/)에 접속하여 설치한다.
> 맥이나 리눅스의 경우 Python2는 기본적으로 설치되어 있고,
우분투와 같은 경우에는 Python3 또한 설치되어 있다.

파이썬을 간단히 살펴보기 위해서 이 교안에서는 프롬프트를 사용할 것이다.
shell(cmd나 bash)을 실행하여 `python` 명령어로 파이썬 프롬프트를 실행할 수 있다.
> 맥이나 리눅스는 `python3` 명령어를 사용해야 한다.

윈도우의 경우 파이썬 shell, 맥의 경우 IDLE를 사용하여도 된다.

아래와 같이 실행이 되면, 파이썬을 사용할 준비가 된 것이다.

```python
$ python3
Python 3.8.0 (v3.8.0:fa919fdf25, Oct 14 2019, 10:23:27)
[Clang 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>>
```

기본문법
---

### 들여쓰기

다른 프로그래밍 언어와 달리 파이썬에서 들여쓰기는 매우 중요하다. 들여쓰기를 잘못 사용하면 코드 문법상 오류가 날 수 있으므로 주의해야 한다!

### 주석

파이썬에서는 `#`을 사용해서 주석처리를 할 수 있다.

```python
>>> print('Hello World') #문자열을 출력하는 함수
    Hello World
```

### 세미콜론

파이썬은 기본적으로 세미콜론을 입력하지 않는 언어이다. C언어나 자바가 문장의 구분을 세미콜론을 사용하는 반면 파이썬을 문장 구분을 들여쓰기와 같은 공백으로 인식하기 때문이다.

> 세미콜론을 사용해도 에러가 나지는 않지만 굳이 사용할 필요가 없다.
