- 대칭키 암호, 일방향 해시함수, MAC, 의사난수 생성기, 전자서명을 조합해 안전한 통신 수행
- 암호 스위트를 변경하여 강력한 알고리즘 사용 (특정 암호기술에 의존 X)

> 암호 스위트: SSL/TLS 암호화 통신에 사용할 암호 알고리즘

보안 서비스
---

- 기밀성
  - 대칭키 암호화 알고리즘을 사용하여 제공
  - 비밀키는 `Handshake Protocol`을 통해 생성
- 클라이언트와 서버 상호 인증
  - RSA 같은 비대칭키 암호 알고리즘
  - DSS와 같은 전자서명 알고리즘
  - X.509 공개키 인증서
- 무결성
  - 해시 알고리즘을 사용해 MAC를 만들어 메시지에 포함시켜 제공

절차
---

1. 지원 가능한 알고리즘 서로 교환
2. 키 교환, 인증
3. 대칭키 암호로 암호화하고 메시지 인증

> 메시지 인증 코드는 HMAC 해시 함수를 이용

TLS 프로토콜
---

`SSL 3.0`을 기초로 인터넷 표준버전이 되도록 만든 IETF 표준

- TCP에 의존하는 프로토콜
- 응용계층과 전송계층 사이에서 동작

> SSL은 현재 취약점이 발견되어 사용이 권장되지 않음

TLS 구조
---

![TLS 구조](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-06-04-18-39-22.png)

### Record Protocol

데이터를 암호화하고 압축하여 안전하게 전송하는 프로토콜

- 데이터를 SSL에서 처리할 수 있는 단위로 단편화, 압축, MAC 계산, 암호화하여 TCP 단편으로 전송

### Handshake Protocol

- 클라이언트-서버간 안전한 연결 수립을 위한 `상호 인증`
- 암호화 `MAC 알고리즘` 및 TLS Recode 내 데이터 보호를 위한 `암호키` 협상
- 구성 필드
  - 유형(1byte)
    | 유형 | 매개변수 |
    |------|----------|
    | hello-request | null |
    | client- hello | 버전, 랜덤, 세션 id, 암호도구, 압축방법 |
    | server-hello | 버전, 랜덤, 세션 id, 암호도구, 압축방법 |
    | certificate | 연속된 X.509v3 인증서 |
    | server_key_exchange | 매개변수, 서명 |
    | certificat_request | 유형, 기관 |
    | server_hello_done | null |
    | certificate_verify | 서명 |
    | client_key_exchange | 매개변수, 서명 |
    | finished | 해시값 |
  - 길이(3byte)
  - 내용(0byte 이상)

#### 초기협상 단계

클라이언트와 서버는 SSL 버전, 키교환/메시지인증/암호화를 위한 알고리즘, 압축 방법, 난수 등을 수집

![초기협상 단계](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-06-05-01-33-39.png)

- Hello_Request: 서버가 클라이언트에게 협상의 시작을 요구
- Client_Hello: 클라이언트가 서버에 연결을 시작하거나 `HelloRequest` 메시지에 대해 응답
- Server_Hello: Client_Hello 메시지에 대한 응답

#### 서버 인증 단계

서버는 인증서와 키 교환 전송 후 인증서를 요청, hello 메시지 종료 시그널 전송

![서버 인증 단계](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-06-05-01-39-28.png)

- Certificate: 선택된 `cipher suite`의 키 교환 알고리즘에 맞는 `서버의 인증서`를 보냄
- Server_Key_Exchange: 인증서를 보내지 않았거나, 보낸 인증서에 정보가 부족할 때 전송
- Certificate_Request: 클라이언트의 인증서를 요청, 상호 인증이 이루어짐(선택 사항)
- Server_Hello_Done: 서버가 메시지를 다 보냈다고 알리는 메시지

#### 클라이언트 인증 단계

클라이언트는 요청이 있을 시 인증서, 키 교환, 인증서 확인 전송

![클라이언트 인증 단계](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-06-05-02-25-39.png)

- Certificate: 서버가 클라이언트의 인증을 요구할 경우 클라이언트가 보내는 메시지
- Client_Key_Exchange: 세션키를 생성하기 위해 48bytes의 비밀 정보를 생성, 공개키 알고리즘을 사용하여 `pre_master_secret`를 서버와 공유
- Certificate_Verify: 클라이언트 인증서의 명백한 확인을 위해 `handshake` 메시지를 `전자서명`하여 전송

#### 종료 단계

암호 스위트 변경 후 handshake 프로토콜 종료

![종료 단계](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-06-05-02-25-51.png)

- Change_Cipher_Spec: 이 메시지 이후에 전송되는 메시지는 새롭게 협상된 알고리즘과 키를 이용할 것임을 나타냄. (Handshake 프로토콜에 포함되지 않음)
- Finished: `협상된 알고리즘과 키`가 처음으로 적용, 이후 `데이터 전송`이 시작됨

### ChangeCipherSpec Protocol

- 종단 간 협상된 보안 파라미터를 `이후부터 적용/변경`함을 알리기 위해 사용
- 1 바이트 메시지

### Alert Protocol

- 통신 과정에서 발생하는 `오류를 통보`하기 위해 경고 할 때 사용
- 구성 필드(2바이트)
  - 첫번째 바이트: warning(1), fatal(2)
  - 두번째 바이트: 세부 에러코드

### Heartbeat Protocol

- 정상적으로 동작한다는걸 나타내기 위한 S/W나 S/W가 생성하는 주기적 신호
- 가용성을 모니터링 할 때 사용함

공격 및 보안대책
---

### OpenSSL의 HeartBleed 취약점

`heartbeat 프로토콜의 확장`이라는 기능에 요구 데이터 길이에 대한 점검 결여로 인해 메모리상 관계없는 정보까지 상대방에게 넘어가 버리는 공격

> 공격자는 heartbleed 공격으로 서버의 정보를 일정범위까지 훔칠 수 있음

#### 보안대책

- 취약성 대책이 실행된 버전으로 `OpenSSL` 갱신
- heartbeat 확장 사용을 하지 않는 옵션으로 재컴파일

### POODLE 공격

공격자가 TLS를 `SSL 3.0으로 다운그레이드`한 통신을 강요하여 `MITM(중간자 공격)`을 통해 암호화되어 송ㆍ수신되는 쿠키정보, 데이터를 추출하는 공격

#### 보안대책

- 브라우저 상에서 `SSL 3.0`의 비활성화

### FREAK 공격

SSL/TLS 서버가 `RSA Export Suites`라고 불리는 약한 암호 스위트를 사용하게 만드는 공격

#### 보안대책

- OpenSSL 최신버전 업그레이드
- OS 및 브라우저 업그레이드
