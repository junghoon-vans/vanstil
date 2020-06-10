윈도우 서버 보안
===

Contents
---

- [윈도우 시스템](#윈도우-시스템)
- [파일 시스템](#파일-시스템)
  - [NTFS 구조](#ntfs-구조)
- [부팅 순서](#부팅-순서)
- [윈도우 계정](#윈도우-계정)
  - [기본 계정](#기본-계정)
  - [기본 그룹](#기본-그룹)
  - [SID(Security Identifier)](#sidsecurity-identifier)
- [윈도우 인증](#윈도우-인증)
- [공유 자료 관리](#공유-자료-관리)
  - [접근 권한](#접근-권한)
  - [공유 폴더](#공유-폴더)
    - [관리](#관리)
    - [암호 기능](#암호-기능)
- [레지스트리](#레지스트리)
  - [Master Key](#master-key)
  - [Derived Key](#derived-key)
  - [공격](#공격)

윈도우 시스템
---

5개의 링으로 구성됨

![윈도우 시스템 구조](images/2020-05-29-16-43-07.png)

- HAL(Hardware Abstraction Layer): H/W와 S/W가 원활히 통신할 수 있게 도움
- 마이크로 커널: 하드웨어와 통신만 하는 최소한의 커널
  - 프로세스 스케줄링, 메모리 관리 등은 manager가 맡음

파일 시스템
---

| 항목 | FAT16 | FAT32 | NTFS |
|------|-------|-------|------|
| 용량 | 저용량(최대 2GB) | 고용량(2GB~2TB) | 대용량 |
| 암호화ㆍ압축 | X | X | O |
| 클러스터|1632KB|4KB|가변 클러스터(512B ~ 4KB)|
| 장점 | <li>호환성 우수</li><li>저용량 볼륨에 최적화</li> | | <li>강력한 보안기능, 감사 기능</li><li>디스크의 효율적 사용</li><li>대용량 볼륨, 긴 파일이름</li> |
| 단점 | <li>보안 취약</li><li>대용량 볼륨에 비효율적</li> | | <li>NT계열외의 OS에는 호환 X</li><li>저용량 볼륨에서 FAT보다 속도 저하</li> |

### NTFS 구조

| 항목 | 설명 |
|------|------|
| MBR(Master Boot Recode) | 파티션 생성 시 물리적 디스크의 `첫 번째 섹터`에 위치한 512bytes 크기의 영역 <br> 부팅 시 BIOS에 의해 POST 과정을 마친 후 이 영역의 부트 코드를 호출 <br> 부트 코드는 `Active 파티션`을 찾아 해당 `VBR 부트 코드를 호출` |
| VBR(Volume Boot Recode) | 부팅을 위한 기계어 코드와 볼륨 및 클러스터의 크기, `MFT의 시작 주소` 등의 설정 정보를 가짐 |
| MFT(Master File Table) | `모든 파일과 디렉터리의 속성 정보`(파일 이름, 크기, 생성 시간 등)를 담은 테이블 |
| 시스템 파일 | 복구하는데 사용할 파일들이 저장 |
| 파일 영역 | 각 파일에 대한 `실제 데이터`가 저장 |

부팅 순서
---

- 윈도우 XP 이전
  - POST(Power On Self Test)
  - 기본 부팅 관련 설정사항(CMOS) 로드
  - MBR 로드 (기본 파일시스템 정보 로드)
  - NTLDR(NT Loader) 실행
  - ntoskrnl.exe 실행 -> hal.dll을 읽음   
- 윈도우 Vista 이후
  - `3단계`까지 위와 동일
  - 윈도우 부트 서브 시스템 실행
  - 윈도우 OS 로더(Winload.exe) 실행
    - 각종 장치 드라이브를 로드하고, ntoskrnl.exe를 실행

윈도우 계정
---

### 기본 계정

- Administrator: 관리자 권한의 계정
- SYSTEM: 시스템에서 `최고 권한`을 가진 계정
  - 사용자는 이 계정으로 시스템에 로그인할 수 없음
- Guest: 제한적인 권한을 가진 계정

### 기본 그룹

- Administrators: 도메인 자원이나 로컬 컴퓨터에 대한 `모든 권한`
- Account Operators: 계정을 관리하는 그룹
- Backup Operators: 시스템 백업을 위해서 모든 시스템의 파일과 디렉터리에 접근 가능
- Guests: 도메인 사용 권한이 제한
- Print Operators: 도메인 프린터에 접근
- Users: 도메인과 로컬 컴퓨터를 `일반적으로 사용`
  - 개인 사용자 환경을 생성 가능하나 설정 항목에 한계 존재
- Power Users: Users 그룹보다 확장된 권한
  - 디렉터리나 네트워크 공유, 공용 프로그램 그룹 생성, 시계 설정
- Server Operation: 도메인의 `서버를 관리`할 수 있는 권한

### SID(Security Identifier)

Unix/Linux 시스템의 `UID와 비슷`한 윈도우 개념

- 각 사용자나 그룹에게 부여되는 고유 식별번호
- `Whoami /SID` 명령어나 `Whoami /USER` 명령어를 통해 SID를 확인

윈도우 인증
---

- LSA (Local Security Authority)
  - 모든 계정의 `로그인`에 대한 검증, 자원 및 파일에 접근 권한 검사
  - SRM이 생성한 감사로그 기록
  - NT보안의 중심요소, 보안 서브시스템이라고도 함
- SAM (Security Account Manager)
  - 사용자/그룹 `계정 정보`에 대한 DB를 관리
  - 로그인 입력 정보와 SAM 로그인 정보를 비교해 인증 여부 결정
  - 인가되면 SRM에 알림
- SRM (Security Reference Monitor)
  - 사용자에게 `SID를 부여`
  - SID에 기반하여 파일/디렉터리에 대한 `접근 권한` 결정
  - 감사 메시지 생성

공유 자료 관리
---

### 접근 권한

- 제공되는 권한
  - 수정, 읽기 및 실행, 폴더 내용 보기, 읽기, 쓰기
- 사용자가 여러 그룹에 속한 경우 접근 권한은 누적
- 파일에 대한 접근 권한이 디렉터리에 대한 접근 권한에 우선
- 허용 권한보다 거부 권한이 우선

### 공유 폴더

- C$,D$ 등
  - 드라이브에 대한 관리목적 공유 폴더
- ADMIN$
  - 윈도우 설치 폴더에 접근하는 관리목적 공유 폴더
- IPC$(Inter Process Communication)
  - 네트워크 등에서 프로세스 간의 통신을 위해서 사용하는 통로

#### 관리

- `netshare` 명령어로 숨겨진 공유 폴더(이름 끝에 `$`) 확인
- 침입자가 네트워크에 액세스할 수 있는 위험
  - `netshare 공유이름 /delete`로 공유 비활성화 (OS 재부팅 시 활성화)
  - 레지스트리를 통해 완벽하게 제거(HKLM)
- `IPC$`는 정상적인 방법으로 제거할 수 없으며 제거할 경우 특정 서비스가 실행되지 않을 수 있음

#### 암호 기능

- EFS(Encrypting File System)
  - 파일/폴더를 암호화할 수 있는 기능
  - `인증서` 추가/삭제를 통해 EFS가 적용된 파일을 읽을 수 있는 사용자 추가/변경
- BitLocker
  - 볼륨(파티션)에 저장된 `모든 파일`이 자동으로 암호화
  - 시스템 파티션 제외

레지스트리
---

윈도우 부팅 시 하이브 파일에서 값을 읽어 들여 구성

- Master Key: 하이브 파일에서 직접 읽어 들여 구성되는 키
- Derived Key: `Master Key`로부터 값을 가져와서 재구성하는 키

### Master Key

- HKEY_LOCAL_MACHINE(HKLM)
  - `하드웨어와 드라이버 설정 사항`에 관련된 정보
  - HKLM\HARDWARE
    - 부팅 시 하드웨어와 드라이버 정보(휘발성)
  - HKLM\SAM
    - 사용자와 도메인 정보
    - 시스템 계정만 접근 가능
  - HKLM\SECURITY
    - 시스템 범위의 보안 정책과 사용자 권리 할당 정보
    - 시스템 계정만 접근 가능
  - HKLM\SOFTWARE
    - 시스템 범위의 소프트웨어 목록과 그 환경설정 정보(이름, 경로 등)
  - HKLM\SYSTEM
    - 부팅될 때 필요한 시스템 범위의 환경설정 정보(서비스 목록 등)
- HKEY_USERS(HKU)
  - 시스템에 있는 `모든 계정과 그룹`에 관한 정보
  - 모든 계정의 프로파일이 있다는 것을 제외하고 서브키가 HKCU와 동일

### Derived Key
- HKEY_CLASSES_ROOT (HKCR)
  - 시스템에 등록된 `파일 확장자`와 그것을 열 때 사용할 `어플리케이션의 매핑 정보`
  - COM(Component Object Model) 오브젝트 등록 정보
- HKEY_CURRENT_USER (HKCU)
  - 현재 시스템에 `로그인 중인 사용자`와 관련된 시스템 정보
  - HKCU 키에서 설정한 내용이 HKU보다 우선권
- HKEY_CURRENT_CONFIG (HKCC)
  - 시스템이 시작할 때 사용하는 `하드웨어 프로파일` 정보
  - HKLM에 서브로 존재하는 config의 내용만을 담고 있음

### 공격

- 부팅 시 악성코드 실행 공격
  - 재부팅 시 악성 프로그램을 구동시키기 위해 레지스트리(`HKLM`과 `HKCU`)를 변조
  - 대상 파일
    - HKCU\Software\Microsoft\Windows\CurrentVersion\Run (개별 사용자 지속)
    - HKCU\Software\Microsoft\Windows\CurrentVersion\RunOnce (개별 사용자 일회성)
    - HKLM\Software\Microsoft\Windows\CurrentVersion\Run (전체 사용자 지속)
    - HKLM\Software\Microsoft\Windows\CurrentVersion\RunOnce (전체 사용자 일회성)
- 특정 확장자 실행 시 악성코드 실행 공격
  - 특정 확장자 실행 시 원하는 악성 프로그램을 실행
  - `HKCR` 내용 변경하여 수행
