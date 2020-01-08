Install Django
===

Contents
---
- [가상환경](#가상환경)
  - [생성 명령어](#생성-명령어)
  - [실행 명령어](#실행-명령어)
  - [종료 명령어](#종료-명령어)
- [장고 설치](#장고-설치)
  - [설치 명령어](#설치-명령어)
  - [삭제 명령어](#삭제-명령어)

가상환경
---

가상환경(Virtual Environment, venv)은 독립적인 파이썬 개발 환경을 생성하는 것으로, 특정 버전의 파이썬이나 라이브러리를 설치하여 사용한다. 이를 통해 여러 프로젝트를 효과적으로 관리하는 것이 가능하다.

### 생성 명령어

```bash
$ python -m venv "가상환경 이름"
# MacOS or Linux의 경우 python3로 진행
```

### 실행 명령어
```bash
$ source "가상환경 이름"/Scripts/activate
```

### 종료 명령어
```bash
$ deactivate
```

장고 설치
---
효율적인 프로젝트 관리를 위해 장고는 가상환경 안에 설치해주는 것이 좋다. 장고는 pip(파이썬 패키지 관리 시스템)를 통해 설치한다.

### 설치 명령어
```bash
$ pip install django
```

### 삭제 명령어
```bash
$ pip uninstall django
```
