Window Subsystem for Linux
--------------------------

### WSL?

-	기존에 Windows의 미흡한 개발환경을 보완하고자 등장
-	Windows 상에서 Linux 커널 및 앱을 실행할 수 있게 됨.
-	이러한 시스템을 `Windows Subsystem for Linux` 혹은 `WSL`이라 함.

### Windows 10에서 리눅스 서브시스템 사용하기

#### WSL 활성화

-	관리자 권한으로 Windows PowerShell 실행
-	다음과 같은 명령어를 실행<br>`Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux`

#### Linux 설치

-	`Microsoft Store`에서 Linux 검색 후 Ubuntu 설치
-	설치된 Ubuntu 앱 실행

#### 기본 설정하기

-	User의 ID 및 PW 설정
-	WSL 배포판의 패키지 업데이트<br>`bash
	$ sudo apt-get update
	$ sudo apt-get upgrade
	`

#### WSL에서 Windows 디렉토리 접속 경로

-	`/mnt/드라이브명`를 통해서 자신이 원하는 드라이브로 이동
-	`/mnt/드라이브명/디렉토리명`으로 해당 드라이브 상의 특정 폴더 접속
