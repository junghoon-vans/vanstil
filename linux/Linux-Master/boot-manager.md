개요
----

컴퓨터 상에 여러 운영체제가 설치되어 있는 경우 선택하여 부팅할 수 있게 하는 프로그램이다. `부트로더(Boot Loader)`라고도 하며, 하드디스크의 맨 앞 영역인 `MBR(Master Boot Record)`에 설치된다.

> MBR은 하드디스크의 첫 번째 섹터인 512바이트 부트섹터로, 부트 매니저와 파티션 정보가 기록되어 있다.

### 운영체제의 부팅과정

1.	바이오스가 컴퓨터에 장착된 하드웨어 점검
2.	CMOS에 설정된 첫 부팅 하드디스크를 확인
3.	부팅디스크의 MBR 영역에 있는 부트 매니저 실행
4.	관련 환경 설정 파일을 참고하여 OS 부팅

종류
----

### LILO

`LILO(Linux Loader)`는 특정 파일 시스템에 구애받지 않으며, 플로피 디스크와 하드디스크를 이용한 부팅을 지원하였다. 하지만 8GB 영역이 넘어가는 곳에 리눅스가 설치되면 부팅이 되지 않는 문제가 있었고, 환경 설정 파일인 `/etc/lilo.conf`를 수정하면 `lilo`라는 명령어를 반드시 수행해야 한다는 불편함이 있어서 현재는 잘 사용하지 않는다.

### GRUB

GNU프로젝트에서 만든 부트로더로 `LILO`에 비해 다양한 파일 시스템을 지원하고, 부팅 시 커널 인자를 조정하여 동적인 부팅을 지원한다.

#### 부트 화면

-	메뉴 목록 GUI로 표시
-	상하 방향키와 [ENTER] 사용
-	[a], [e], [c]를 눌러 커널 인자 조정

#### 부트 모드

-	[a]: `grub.conf`에 커널과 관련된 부분의 매개변수 추가 가능
-	[e]: `grub.conf`에 등록된 부팅 목록의 모든 항목을 직접 편집
-	[c]: 상호대화식으로 직접 입력할 수 있는 모드

> 편집모드에서 지원하는 키 - e: 커서가 위치한 줄 편집 - d: 커서가 위치한 줄 삭제 - o: 명령 줄을 커서가 위치한 줄 아래에 추가 - O: 명령 줄을 커서가 위치한 줄 위에 추가 - b: 부팅 시작

#### 환경설정 파일

> `/boot/grub/grub.conf`

로그인/로그아웃
---------------

### 실행레벨

컴퓨터 실행시 `GRUB`은 커널을 로드하고, 파일 시스템을 마운트하고 점검한다. 이후 실행되는 `init` 프로세스는 시스템 부팅에 필요한 `rc.sysinit`, `rc`, `rc.local`을 실행하고 로그인 창을 호출한다.

| 레벨 | 설명                                                                                                  |
|:----:|-------------------------------------------------------------------------------------------------------|
|  0   | 시스템을 중지할 때 호출                                                                               |
|  1   | 단일사용자모드로 로그인 과정 없이 root 사용자로 부팅, root 패스워드를 잊어버렸거나 시스템 점검시 접근 |
|  2   | 네트워크를 사용하지 않는 다중사용자모드                                                               |
|  3   | 다중사용자모드, X윈도를 사용하지 않고 메모리를 효율적으로 이용 가능                                   |
|  4   | 사용자가 정의하여 사용가능                                                                            |
|  5   | X윈도를 사용하는 다중사용자모드                                                                       |
|  6   | 시스템을 재부팅할 때 호출                                                                             |

### 로그인

-	실행레벨이 3인 경우

	-	[CTRL]+[ALT]+[F1~6]로 가상 콘솔 실행
	-	`getty`라는 프로그램이 콘솔에 로그인 프로그램을 실행함.

-	실행레벨이 5인 경우

	-	X-Windows 기반의 그래픽 로그인 창이 나타남

### 로그아웃

-	logout 또는 exit 명령어
-	[CTRL]+[D]
-	X-Windows에서는 메뉴 클릭

> 일정시간 작업하지 않을 시 강제 로그아웃: `/etc/profile`에 'TMOUT=초'를 설정
