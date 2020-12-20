---
title: "DoS Attack"
linkTitle: "DoS Attack"
date: 2020-11-16
type: docs
draft: false
weight: 3
description: >
  서비스 거부 공격
---

서비스 거부 공격(DoS)
---

시스템에 과도한 `부하`를 일으켜 시스템의 `사용을 방해`하는 공격 방식(가용성 침해)

### TCP SYN Flooding Attack

TCP 연결 과정 중에 3-way handshaking 과정에서 `Half-Open` 연결 시도가 가능하다는 취약점을 이용한 공격 기법

![TCP SYN Flooding Attack](images/2020-05-31-16-21-21.png)

- 클라이언트가 `SYN`을 보내면 서버는 이에 대한 응답으로 `SYN + ACK`을 보내고 `SYN Received` 상태가 됨
- 이후 서버는 클라이언트로부터의 ACK 패킷 수신을 `일정시간동안 대기`하게 된다.

#### 공격 방법
- 조작된 IP로부터 `SYN` 메시지를 공격대상자에게 대량 전송
- 서버는 조작된 IP로 `SYN+ACK` 전송
- 만약 시스템이 존재하는 IP라면 `RST(Reset)` 패킷이 전송되어 연결 끊김
  - 해당 클라이언트가 서비스 요청을 하지 않았음을 확인
- 존재하지 않는 IP라면 클라이언트가 RST 패킷을 전송하지 않음
- 서버는 일정시간동안 `SYN+ACK을 재전송하며 대기`
- 서버의 TCP 연결테이블 공간을 차지하기 때문에 정상적인 서비스 요청이 거부됨

#### 보안 대책

- SYN 연결 요청에 임계치 설정
  - 동일 클라이언트로부터 과도한 연결요청 DROP
- SYN쿠키 기법
  - 요청이 들어오면 SYN쿠키만 보내놓고 세션을 닫음
  - 공격자의 계속적인 SYN Flooding을 막는 방법
- TCP 연결테이블 엔트리 선택적 삭제
  - 테이블 오버플로우 발생 시 일부 삭제
- 연결테이블 확장

### SMURF Attack

IP 위장과 ICMP의 특징을 이용한 광범위한 DoS 공격

#### 공격 방법

- 공격자는 IP를 공격대상 `서버의 IP주소`로 위장, `ICMP`를 broadcast로 다수의 시스템에 전송
- ICMP broadcast를 수신한 다수의 시스템은 `ICMP Echo 패킷`을 공격대상 `서버로 전송`하게 됨
- 다수의 ICMP Echo를 수신한 공격대상 서버는 시스템 성능에 문제가 생기게 됨

#### 보안 대책

- 라우터에서 다른 네트워크에서 자신의 네트워크로 들어오는 `IP directed broadcast 패킷`을 막도록 설정
- 호스트는 `IP broadcast address`로 전송된 ICMP 패킷에 대해 응답하지 않도록 함
- `침입탐지 시스템`(IPS)를 통해서 패킷 모두 DROP

### Land Attack

패킷 전송 시 `출발지 IP 주소`와 `목적지 IP 주소 값`을 똑같이 만들어서 공격 대상에 보내는 기법

#### 보안 대책

- 출발지 주소가 `내부 IP`인 패킷을 차단
- 자신의 시스템 주소와 동일한 출발지 주소를 가진 외부 패킷을 필터링

### Ping of Death

ping을 이용하여 `ICMP 패킷`을 정상 크기(65,535bytes)보다 `아주 크게` 만들어 전송

- 라우팅되어 공격대상자에게 전송되는 동안 많은 `Fragment`로 쪼개서 전송됨
- 공격 대상은 조각화된 패킷을 모두 처리해야 하므로 부하가 발생

#### 보안 대책

- OS 패치
- 방화벽에서 ICMP 차단

### Teardrop Attack

IP 단편화시 `오프셋 값`을 고의적으로 `중복`되도록 설정하거나 범위를 넘어서는 `오버플로우`를 일으켜 시스템 기능을 마비시킴

> 패킷을 전송할 때 IP 단편화(fragmentation)를 진행하고, 수신자는 재조립을 통해 단편화된 데이터를 복구하는데 이 과정에서 정확한 조립을 위해 `오프셋 값`을 사용한다.

#### 보안 대책

- 침입차단시스템(IPS), 방화벽
- OS 패치

### Inconsistent Fragmentation Attack

- Bonk: 패킷을 fragment(조각화)하여 전송할 때 `순서번호`를 모두 `1번`으로 조작하여 전송
- Boink: 패킷 `순서번호`를 `비정상적인 상태`로 보내는 공격

분산 서비스 거부 공격(DDos)
---

여러 대의 컴퓨터(`좀비 PC`)로 엄청난 분량의 패킷을 동시에 전송하여 네트워크 성능 저하나 시스템 마비를 유발

### 구성 요소

- 공격자(봇 마스터): 공격을 주도하는 해커의 컴퓨터
- 마스터(C&C 서버): 공격자에게 직접 명령을 받은 시스템
  - 여러 에이전트를 관리
- 에이전트(좀비): 공격 대상에 직접적인 공격을 가하는 시스템
- 데몬 프로그램: 에이전트 역할을 수행

### 대응 절차

#### 공격의 인지

- 유입 트래픽 크기
  - IDS, 방화벽 등 사용
- 웹 서버 로그
- 동시접속 정보
- 유입 트래픽 샘플링

#### 공격 유형 파악

- 패킷 덤프를 이용한 트래픽 확보
- 확보된 트래픽 분석
- 시나리오 기반의 공격유형 파악
- 웹서버 접속 로그

#### 유형에 따른 차단정책

**대역폭 소진 공격 대응 방안**

- 공격 유형: UDP Flooding, ICMP Flooding
  - 방화벽이나 웹서버 상단의 라우터 해당 프로토콜을 차단하는 ACL 정책 적용
- 공격 유형: TCP Flooding
  - 프로토콜로 기준으로 차단하는 것에 한계가 있음
  - Source IP별 PPS 임계치 설정

**웹서버 자원 소모 대응 방안**

- 공격 유형: SYN Flooding
  - Source IP별 PPS 임계치 설정
  - 패킷 헤더 검사를 통한 비정상적인 옵션 필드 가진 패킷 차단
- 공격 유형: Slow Header Flooding, Slow Data Flooding
  - 완료되지 않은 연결 상태 유지
  - 요청에 대한 타임아웃 설정

**DB 커넥션 부하 유발 대응 방안**

- 공격 유형: Get Flooding, Post Flooding
  - 다량의 HTTP 요청으로 웹서버와 DB연동에 부하
  - 클라이언트 요청 수에 대한 임계치 초과하는 IP 차단
  - HTTP 표준에 맞지 않는 필드값을 차단 시그니처로 설정
  
#### 사후 조치
  
- 정책 업데이트
- 좀비 PC IP 확보

### 공격 사례

- 트리누(Trinoo) 공격
  - `UDP Flood` 서비스 공격을 유발
- TFN(Tribed Flood Network) 공격
  - 트리누의 발전형
  - UDP Flood 외 다양한 공격(TCP SYN Flood, smurf 공격) 가능
- Stacheldraht 공격
  - 마스터 시스템 및 에이전트 데몬과의 사이 `암호화 통신`(TELNETC)
- TFN2K 공격
  - TFN의 발전된 형태. 통신에 특정 포트가 사용되지 않고 암호화
  - 조금 더 `다양한 OS`에서 사용 가능
  - UDP, TCP, ICMP가 복합적으로 사용
  - 지정한 TCP 포트에 백도어 실행 가능

### 공격 유형

#### HTTP Traffic Flooding 공격

- GET Flooding
  - TCP 3-way handshaking 과정을 통해 정상 접속
  - 특정 페이지를 HTTP의 `GET Method`를 통해 `무한대`로 실행
- Cache Control Attack (CC Attack)
  - HTTP 메시지의 `캐시 옵션`을 조작
  - 캐싱서버가 아닌 웹서버가 메시지를 처리하도록 하여 `웹서버의 자원 소진`
- 동적 HTTP Request Flooding 공격
  - `웹 방화벽 차단 기법을 우회`하기 위해 지속적으로 `요청 페이지를 변경`하여 웹페이지를 요청

#### HTTP Header/Option Spoofing Flooding 공격

- Slow HTTP POST DoS
  - POST 지시자를 통해서 서버에 전송할 다량의 데이터를 `장시간`에 걸쳐 분할전송
  - 서버는 POST 데이터를 모두 수신하지 않았다고 판단하여 연결을 장시간 유지
- Slow HTTP Header DoS(Slowloris)
  - `헤더 정보`를 조작하여 `구분할 수 없게` 만듬
  - 헤더 정보 수신을 위해 서버는 장시간 연결 유지
- Slow HTTP Read DoS
  - `TCP 윈도우 크기` 및 `데이터 처리율`을 감소시킨 후 HTTP 데이터를 송신
  - 웹서버가 정상적으로 응답하지 못하도록 DoS 상태

#### HULK(Http Unbearable Load King) DoS

웹서버의 `가용량`(최대 접속 가능 클라이언트 수)을 모두 사용하도록 하여 정상적인 서비스가 불가능하도록 유도

> GET Flooding 공격 중 하나

#### SIP(Session Initiation Protocol) Flood

- 하나의 `INVITE request` 메시지가 상당한 양의 자원을 소모하게 한다는 것을 이용
- 수많은 INVITE request를 `위조된 시작주소`에 넣어 전송하는 공격
- `SIP Proxy` 서버에 부하

> SIP: VoIP 전화 연결에 많이 사용하는 프로토콜

분산 반사 서비스 거부 공격(DRDoS)
---

별도의 에이전트 설치 없이 `프로토콜 구조의 취약점`을 이용해 정상적인 서비스를 운영하는 시스템을 에이전트로 활용하여 공격

- DNS 증폭 DRDoS 공격
  - 많은 양의 레코드 정보를 요구하는 DNS 질의 타입을 요청
  - 공격 대상에게 대량의 트래픽을 유발시킴
- NTP 증폭 DRDoS 공격
  - 최근 접속한 클라이언트 목록(monlist 명령)을 요청
- SNMP 증폭 DRDoS 공격
  - MIB와 같은 정보를 대량 요청
- CHARGEN 증폭 DRDoS 공격
  - 대량의 문자열 전송

### 위협 요소

- 패킷이 전송되는 `경로가 무수히 많음`
- 반사 서버의 단계적 사용 및 확산
  - `공격 경로`를 `끊임없이 변경` 가능
- 공격대상 IP를 출발지 IP로 위조하여 전송
  - 역추적 어려움

### 대응 방안

- 네트워크에서의 대응
  - IP 주소가 `위조된 패킷`이 인터넷망으로 들어오지 않도록 `ISP가 직접 차단`(Ingress Filtering)
- 반사서버에서의 대응
  - `ICMP 프로토콜`이 필요 없는 시스템인 경우 해당 프로토콜을 `차단`
- 공격대상에서의 대응
  - 내부 사용자용 DNS 서버인 경우 내부 사용자 주소만 `Recursive Query`가 가능하도록 제한
