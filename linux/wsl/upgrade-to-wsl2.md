기존 WSL1의 문제점
---

- WSL(Windows Subsystem for Linux)은 기존 Windows의 단점이던 개발환경을 획기적으로 개선
- 다만 기존 `WSL1`은 시스템 콜 에뮬레이션 방식으로 구동되기 때문에 성능저하가 존재

> 리눅스 시스템 콜을 윈도우 시스템 콜로 번역하여 윈도우NT 커널에서 이를 처리

WSL2, 무엇이 달라졌나?
---

- `WSL2`는 기존 `WSL1`의 문제를 개선하기 위해 리눅스 커널을 그대로 탑재하였다.
- 이를 통해서 기존에 문제시 되던 I/O성능과 시스템 호출 호환성이 개선이 이루어졌다.

> 실제 리눅스 커널은 경량화된 하이퍼-V 가상화 기술을 통해 구동된다.

WSL2 업그레이드 방법
---

### 사전 준비

- 2004 이상 버전의 윈도우 10
  - `설정 > 시스템 > 정보 > 버전`
- `WSL1`의 설치
  - 설치가 되어 있지 않다면 [해당 페이지](linux/wsl/installation.md)를 참고
- [WSL2 Lunix 커널 업데이트 패키지 설치](https://docs.microsoft.com/ko-kr/windows/wsl/wsl2-kernel)

### 1. Virtual Machine Platform 활성화

`WSL2`는 `Virtual Machine Platform`을 기반으로 동작하기 때문에 이를 활성화시켜 주어야 한다.

- PowerShell을 우선 관리자권한으로 실행
- 아래 명령어 실행
  ```powershell
  Enable-WindowsOptionalFeature -Online -FeatureName VirtualMachinePlatform
  ```

> Hyper-V가 Windows 10 Home에는 설치되지 않으므로 Pro버전으로 업그레이드 해야 할 수도 있다.

### 2. 업그레이드 적용

#### 사용중인 리눅스 배포판 목록 조회

```powershell
wsl -l -v
```

#### 기존 배포판 WSL2 전환

```powershell
wsl --set-version <distro> 2
```
> WSL2로 전환할 리눅스 배포판의 이름을 잘 기억해뒀다가 <distro> 대신 작성해주면 된다.

#### WSL2를 디폴트로 설정

이후 설치하는 리눅스 배포판을 `WSL2`로 적용하길 원한다면 다음 명령어를 입력하면 된다.

```powershell
wsl --set-default-version 2
```
