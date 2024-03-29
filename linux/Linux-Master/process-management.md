프로세스
--------

하드디스크에 설치된 프로그램을 실행하면 메모리에 상주한다. 이렇게 실행중인 프로그램을 프로세스(Process)라 하는데, 실행 시 PID(Process Identity)가 부여된다.

### 생성

하나의 프로세스에서 다른 프로세스를 실행하기 위한 시스템 호출방법에는 `fork`와 `exec`가 있다.

- fork: 새로운 메모리를 할당받아 기존 프로세스를 복사한 코드를 기반으로 실행
- exec: 기존 프로세스 메모리에 새로운 프로세스 코드를 덮어씌워서 실행

> 모든 프로세스는 리눅스 부팅 시 실행되는 `init`을 fork한 것이다.

### 종류
#### Foreground
보통 셸에서 명령을 실행하면 해당 프로세스가 종료될 때까지 기다려야 한다. 이러한 방식의 프로세스를 포어그라운드(Foreground)라 한다.
#### Background
셸에서 보이지 않는 작업으로 다중 작업에 적합하다.

### 멀티태스킹

#### 백그라운드 프로세스로 전환

- `[CTRL]+[z]`를 눌러서 포어그라운드 프로세스를 대기 상태로
- `bg` 명령을 통해서 백그라운드 프로세스로 전환

#### 포어그라운드 프로세스로 전환

- `jobs` 명령어로 현재 백그라운상의 프로세스들을 확인
- `fg %작업번호` 혹은 `fg 작업번호`로 원하는 작업을 전환
- 작업번호를 지정하지 않을 시 주로 처리되고 있는 프로세스를 포어그라운드로 전환
> 주로 처리되는 작업은 `jobs` 실행시 `+`로 표기된다.

통신
----

### 시그널

- 프로세스 간의 통신에 사용
- 사용자가 인터럽트 키를 통한 발생하는 시그널, 프로세스가 발생하는 시그널, 하드웨어가 발생하는 시그널 등이 있다.
- `kill -l`로 시그널의 목록을 확인할 수 있다.

**일반적으로 사용하는 시그널**

| 번호 | 이름          | 설명                                                          |
|:----:|:-------------:|:--------------------------------------------------------------|
|  1   |  SIGHUP(HUP)  | 터미널에서 접속이 끊겼을 때 보내짐                            |
|  2   |  SIGINT(INT)  | 키보드에서 오는 인터럽트 시그널로 실행 중지, [CTRL]+[C]       |
|  3   | SIGQUIT(QUIT) | 키보드에서 오는 실행 중지 시그널, [CTRL]+\[￦]                |
|  9   | SIGKILL(KILL) | 프로세스 강제 종료                                            |
|  15  | SIGTERM(TERM) | 정상 종료, kill명령의 기본 시그널                             |
|  18  | SIGCONT(CONT) | 정지된 프로세스를 Continue                                    |
|  19  | SIGSTOP(STOP) | 터미널에서 입력된 정지 시그널                                 |
|  20  | SIGTSTP(TSTP) | 실행 정지 후 다시 실행하기 위해 대기시키는 시그널, [CTRL]+[Z] |

### 데몬

주기적으로 지속적인 서비스 요청을 처리하기 위해서 계속 실행되는 프로세스로 백그라운드에서 처리된다.

> 보통 데몬 방식의 서버 프로그램에는 뒤에 `d`를 붙인다

#### standalone
부팅 시에 실행되어 해당 프로세스가 메모리에 계속 상주하면서 클라이언트의 서비스 요청을 처리

#### inet
클라이언트의 서비스 요청이 들어왔을 때 관련 프로세스를 실행하고 접속이 종료되면 자동으로 프로세스가 종료됨
> inetd 혹은 xinetd가 이러한 서비스를 관리함

유틸리티
--------

### 관련 명령어

#### ps

동작 중인 프로세스의 상태를 출력한다. ps의 옵션은 운영체제 계열에 따라 나뉜다.
> 보통 System-V에서는 `-`를 옵션에 붙여쓰지 않고, BSD 계열은 사용한다.

```bash
$ ps [option]
$ ps aux # 시스템에 동작 중인 모든 프로세스를 소유자 정보와 함께 출력
```

**주요 옵션**

| 옵션         | 설명                                                 |
|:------------:|:-----------------------------------------------------|
|      a       | 터미널과 연관된 프로세스를 출력(BSD)                 |
|      u       | 프로세스 소유자를 기준으로 출력(BSD)                 |
|      x       | 터미널에 종속되지 않는 프로세스를 출력(BSD)          |
|      l       | 프로세스 정보를 길게 출력                            |
|      e       | 해당 프로세스에 관련된 환경변수 정보 출력            |
|      f       | 프로세스간의 상속관계를 트리구조로 표현              |
|      p       | 특정 PID를 지정할 때 사용(BSD)                       |
|      -A      | 모든 프로세스를 출력(System-V)                       |
|      -e      | 모든 프로세스를 출력                                 |
|      -a      | 터미널에 종속되지 않은 프로세스 출력(세션 리더 제외) |
|      -f      | 유닉스 스타일로 출력(UID, PID, PPID 등 표시)         |
| -C *process* | 지정한 프로세스만                                    |
|  -o *value*  | 출력 포맷을 지정                                     |
|      -p      | 특정 PID를 지정(System-V)                            |
|      -u      | 특정 사용자 프로세스 정보 확인                       |

**- 프로세스 상태코드**

| 값 | 설명                                                    |
|:--:|:--------------------------------------------------------|
| R  | 실행 중이거나 실행가능                                  |
| S  | 인터럽트에 의한 sleep 상태, 특정 이벤트가 끝나길 기다림 |
| D  | 디스크 I/O에 의해 대기중                                |
| T  | 정지 상태(suspend)                                      |
| W  | 페이징 상태(2.6 이후로 사용X)                           |
| Z  | 좀비 상태, 사용 종료되었으나 부모 프로세스로부터 회수X  |
| X  | 죽어있는 상태                                           |
| \< | 우선순위가 인위적으로 높아진 상태                       |
| N  | 다른 사용자에 의해 인위적으로 우선순위가 낮아짐         |
| L  | 메모리 안에서 페이지가 잠금된 상태                      |

#### pstree

프로세스 상태를 트리 구조로 출력해준다.

```bash
$ pstree [option]
```

**주요 옵션**

| 옵션 | 설명                                            |
|:----:|:------------------------------------------------|
|  -a  | 각 프로세스의 명령행 인자까지 표시              |
|  -h  | 현재 프로세스와 이것의 조상을 하이라이트로 강조 |
|  -n  | PID 값으로 정렬                                 |
|  -p  | PID 값을 같이 표시                              |

#### top

동작 중인 프로세스의 상태를 실시간으로 화면에 출력해준다. 프로세스의 상태뿐만 아니라 CPU, 메모리, 부하 상태도 확인이 가능하다

```bash
$ top [option]
```

**주요 옵션**

| 옵션          | 설명                                         |
|:-------------:|:---------------------------------------------|
| -d *갱신시간* | 갱신 시간을 설정(단위:s)                     |
|      -p       | 특정 PID의 프로세스를 모니터링하기 위해 사용 |

#### kill

프로세스에 특정한 시그널을 보내는 명령으로 옵션 없이 실행하면 프로세스 종료 신호를 보낸다.

#### killall

같은 데몬의 여러 프로세스를 한 번에 종료

```bash
$ kill [option] [signal] [PID or %Job_number]
$ kill -9 765 # PID가 765인 프로세스를 강제 종료
$ killall [option] [process_name]
$ killall -HUP httpd # httpd 프로세스 재시작
```

> [시그널](#시그널) 종류 참조

**주요 옵션**

| 옵션        | 설명                 |
|:-----------:|:---------------------|
|     -l      | 시그널의 종류를 출력 |
| -s *signal* | 시그널의 이름을 지정 |

#### jobs

백그라운드로 실행 중인 프로세스나 현재 중지된 프로세스 목록을 출력

```bash
$ jobs -l # PID를 추가로 출력
```

#### fg

백그라운드 프로세스를 포어그라운드 프로세스로 전환하는 명령

#### bg

포어그라운드 프로세스를 백그라운드 프로세스로 전환하는 명령 > 포어그라운드 프로세스를 [CTRL]+[Z]로 일시 중지시킨 뒤 bg명령을 사용

```bash
$ fg [(%)Job_number]
$ bg
```

#### nice

프로세스 우선순위를 변경하는 명령

-	`NI값`을 설정하여 사용한다
-	기본 값 = 0
-	지정 가능 범위(-20~19)

```bash
$ nice [option] process_name
$ nice --10 bash # bash의 NI값을 10만큼 감소시켜서 우선순위를 높인다.
```

#### renice

`nice`와 동일하게 프로세스 우선순위를 변경한다.

-	`PID`를 사용
-	`NI값`을 지정할 수 있음

```bash
$ renice [option] NI값 PID
```

**주요 옵션**

| 옵션 | 설명                      |
|:----:|:--------------------------|
|  -u  | 사용자 이름을 지정        |
|  -g  | 프로세스의 그룹 ID를 지정 |

#### nohup

사용자가 로그아웃하거나 작업 중인 터미널 창이 닫혀도 실행 중인 프로세스를 백그라운드에서 실행할 수 있도록 한다.

```bash
$ nohup 명령
```

### 스케줄링

특정한 시간에 특정한 작업을 수행하게 하는 것으로 리눅스에서는 `at`과 `cron`을 사용한다. `at`은 주로 한 번만 실행할 때 사용하고, `cron`은 주기적으로 실행할 때 사용한다.

#### cron

`root`권한으로 `/etc/crontab`에 등록
> 시스템 운영에 필요한 작업에 사용

**crontab 파일 필드**

| 필드         | 설명                  |
|:------------:|:----------------------|
|    minute    | 분 설정(0~59)         |
|     hour     | 시간 설정(0~23)       |
| day of month | 날 설정(1~31)         |
|    month     | 월 설정(1~12)         |
| day of week  | 요일 설정(0~7)        |
|  user-name   | 사용자 이름(생략가능) |
|   command    | 실행할 명령어 기입    |

**필드 값으로 사용가능한 기호**

- `*`: 모든(all)
- `-`: 연결된 설정 값 지정
- `,`: 연결되지 않은 설정 값 지정
- `/`: 주기 설정


```bash
$ crontab [option] file
```
> 사용자의 필요에 의한 작업일 때 사용

**주요 옵션**

| 옵션 | 설명                                     |
|:----:|:-----------------------------------------|
|  -l  | crontab에 설정된 내용 출력               |
|  -e  | crontab 내용을 작성하거나 수정           |
|  -r  | crontab 내용 삭제                        |
|  -u  | root 사용자가 다른 사용자의 crontab 접근 |
