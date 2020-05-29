전자서명(Electronic Signature)
===

메시지에 전자적인 서명을 하는 것으로, 메시지와 메시지를 생성한 사람과의 인증을 의미한다.

Contents
---

- [전자서명 개념](#전자서명-개념)
  - [제공 서비스](#제공-서비스)
  - [주요 기능](#주요-기능)
- [전자서명 종류](전자서명-종류)
  - [RSA](#rsa)
  - [ElGamal](#elgamal)
  - [Schnorr](#schnorr)
  - [DSS(Digital Signature Standard)](#dssdigital-signature-standard)
  - [타원곡선 전자서명 구조(ECDSA)](#타원곡선-전자서명-구조ecdsa)
- [전자서명 방식](#전자서명-방식)
- [특수 전자서명](#특수-전자서명)
- [전자투표 시스템](#전자투표-시스템)
  - [요구사항](#요구사항)
  - [방식](#방식)
  - [전자 입찰 시스템](#전자-입찰-시스템)
  - [전자 서명으로 해결할 수 없는 문제](#전자-서명으로-해결할-수-없는-문제)
- [공개키 기반 구조(PKI)](#공개키-기반-구조pki)
  - [구성요소](#구성요소)
  - [형태](#형태)
    - [계층 구조](#계층-구조)
    - [네트워크 구조](#네트워크-구조)
- [공개키 인증서](#공개키-인증서)
  - [표준 규격(X.509)](#표준-규격x509)
  - [운영 프로토콜](#운영-프로토콜)

전자서명 개념
---

- 송신자(서명자)는 서명 알고리즘을 이용하여 메시지에 서명
- 수신자(검증자)의 검증 알고리즘으로 서명자의 서명을 검증
- 공개키 서명 방식
  - 서명자의 검증 정보를 공개하여 누구나 검증 가능
  - 서명 생성 및 검증 간편
- 중재 서명방식
  - 서명 생성과 검증을 제 3자가 중재
  - 제 3자의 참여 필요

### 제공 서비스

- 메시지 인증
  - 수신자는 메시지가 원하는 송신자로부터 왔다는 것을 확신할 수 있음
- 메시지 무결성
  - 메시지가 해시함수와 서명을 통해 전송되므로 변조되지 않음을 알 수 있음
- 부인방지

> 기밀성은 제공되지 않으므로 비밀키/공개키 암호화를 해야함

### 주요 기능

- 위조 불가
  - 합법적인 서명자만이 전자서명을 생성할 수 있음
- 서명자 인증
  - 전자서명의 서명자를 누구든지 검증할 수 있음
- 부인방지
  - 서명자는 서명행위 이후에 서명한 사실을 부인할 수 없음
- 변경 불가
  - 서명한 문서의 내용을 변경할 수 없음
- 재사용 불가
  - 전자문서의 서명을 다른 전자문서의 서명으로 사용할 수 없음

종류
---

### RSA

- 전자 서명 구조에서는 개인키와 공개키의 역할이 반대
- 송신자의 개인키로 암호화하고 수신자가 송신자의 공개키를 이용하여 복호화
  - 비대칭키 구조의 반대 방식
  - 비대칭키 구조: 수신자의 공개키로 암호화하고 수신자의 개인키로 복호화

### ElGamal

- 이산대수 문제를 이용한 최조 서명방식
- ElGmal 암호시스템과 동일한 키를 사용하나 알고리즘은 다름
- RSA보다 서명 길이가 2배, 계산량은 거의 4배

### Schnorr

- ElGamal 기반이지만 서명의 크기를 줄인 새로운 구조

### DSS(Digital Signature Standard)

- ElGamal 전자서명을 개량(이산대수 문제)
- 오직 전자서명 기능만을 제공하도록 설계
- 서명과 검증에 소요되는 계산량을 줄임

### 타원곡선 전자서명 구조(ECDSA)

- 타원곡선에 기반을 둔 DSA
- 짧은 비트 길이로 인해 짧은 처리 시간에 짧은 서명 생성 가능

전자서명 방식
---

- 복원형 전자서명
  - 기존 공개키 암호방식을 이용하여 별도의 전자서명 프로토콜 필요 X
  - 메시지를 일정 블록 크기로 나누어, 각 블록에 서명하므로 시간이 소요
  - 실제로는 사용되지 않음
- 부가형 전자서명
  - 메시지를 해시해서 나온 다이제스트에 한 번의 서명 생성하므로 효율적
  - 전송량이 조금 늘어나나 실제로 많이 사용됨

특수 전자서명
---

공개키 방식을 이용한 전자 서명은 검증하는 키가 공개되므로 검증을 누구나 할 수 있는 문제점이 있다.

- 부인방지 전자서명
  - 자체 인증 방식을 배제시키고 서명 검증할 때, 서명자의 도움이 있어야 검증
- 의뢰 부인방지 서명
  - 신뢰하는 제 3자가 서명을 검증
- 수신자 지정 서명
  - 지정한 검증자만이 서명을 검증할 수 있음
  - 필요시 제 3자에게 그 서명이 서명자에 의해 자신에게 발행된 서명임을 증명 가능
- 위임 서명
  - 부재 중 자신을 대리해서 서명
- 은닉 서명
  - 서명문의 내용을 숨기는 방식
  - 익명성을 유지
- 다중 서명
  - 동일 전자문서에 여러 명이 서명

전자투표 시스템
---

선거인 명부를 구축한 중앙 시스템과 직접 연결된 단말에 자신이 정당한 투표자임을 증명하면 어디서나 무기명 투표를 할 수 있는 방식

### 요구사항

- 완전성
  - 모든 투표가 정확히 집계
- 익명성
  - 투표 결과로부터 투표자 구별 불가
- 건전성
  - 부정 투표자에 의한 선거 방해 없어야 함
- 이중투표방지
  - 정당한 투표자는 단 1회만 투표 허용
- 정당성
  - 투표에 영향을 미치는 것이 없어야 함
- 적임성
  - 투표 권한을 가진 자만이 투표 가능
- 검증 가능
  - 투표 결과를 누구나 확인하여 검증 가능

### 방식

- PSEV 방식
  - 기존 선거 방식 + 전자
- 키오스트(kiosk) 방식
  - 공공장소에 설치
  - 관리자 없음
- REV 방식
  - 어디서든 투표 가능
  - 비밀투표 침해가능성 높음

### 전자 입찰 시스템

- 입찰공고에서 다수의 공급자가 응찰하면 이중에서 가장 싼 가격을 제시한 응찰자와 계약을 받는 입찰방식을 인터넷으로 구현
- 독립성, 비밀성, 무결성, 공평성, 안전성을 보장해야 함

### 전자 서명으로 해결할 수 없는 문제

- 서명을 검증할 때 이용하는 공개키가 진짜 송신자의 공개키여야 함
- 이러한 문제를 해결하기 위해 공개키 인증서가 고안됨

> 공개키 인증서: 공개키를 메시지로 간주하고 신뢰 가능한 제 3자에게 전자서명을 해서 받은 공개키

공개키 기반 구조(PKI)
---

- 공개키 알고리즘을 위한 키 관리 구조
- 제공 서비스
  - 기밀성, 무결성, 인증, 부인방지, 접근제어
- 일방향 해시함수 -> MAC -> 전자서명 -> PKI로 발전

### 구성요소

크게 인증기관, 검증기관, 등록기관, 저장소, 사용자로 구성

- 인증기관(CA, Certification Authority)
  - 정책승인기관(PAA, Policy Approving Authority)
    - 루트 인증기관으로, PKI 전반에 사용되는 정책을 생성 및 수립
    - 하위 기관들의 정책 준수 상태 및 적정성 감사
  - 정책인증기관(PCA, Policy Certification Authority)
    - PAA 하위 계층
    - 도메인 내의 사용자와 CA의 정책 수립
    - 인증서, 인증서 폐지 목록 등 관리
  - 인증기관(CA)
    - PCA 아래 계층으로 인증 정책 수립
    - 사용자/등록기관의 요청에 공개키 인증서 발행 및 폐지
    - 사용자에게 자신의 공개키와 상위 기관을 공개키 전달
    - PA요청에 의해 인증서 발급
- 검증기관(VA, Validation Authority)
  - 인증서의 유효성 여부 / 관련 거래의 유효성 여부 등 확인
  - VA가 없다면 안정성이 떨어짐
  - CA에서 직접 운영 가능
- 등록기관(PA, Registration Authority)
  - 사용자와 CA가 원거리에 있는 경우, CA 대신 사용자의 신분, 소속 등 확인
  - 선택적 요소

### 형태

#### 계층 구조

- 최상위에 루트 CA가 존재하고 그 밑으로 하위 CA가 계층적으로 존재
- 상위 CA가 하위 CA에 인증서를 발행하고, 하위 CA는 상위 CA의 인증정책에 영향
- 루트 CA 간에 상호인증은 허용, 하위 CA 간에 상호인증은 불가능
- 인증경로 탐색이 용이하고, 모든 사용자가 최상위 CA의 공개키를 알고 있어서 검증이 용이
- 최상위 CA에 집중되는 오버헤드가 발생
- 최상위 CA의 비밀키 노출이 되면 피해 막대

#### 네트워크 구조

- 각각의 CA들이 자신의 인증정책에 따라 독립적으로 존재
- 모든 상호인증이 허용되면 상호인증 수 대폭 증가
- 유연하고 인증경로가 단순하여 실직적인 업무관계에 적합
- CA의 비밀키가 노출되어도 피해가 적음
- 인증경로 탐색이 복잡
- 정책 수립과 적용이 어려움

공개키 인증서
---

해당 키가 특정인의 것임을 보증해주는 것

- 표준화된 양식으로 믿을 수 있는 제 3자가 발행하며 PKI의 근간
- 개인정보와 그 사람의 공개키가 기재되며 CA의 개인키로 서명됨

### 표준 규격(X.509)

인증서 형식을 통일하여 정의한 것

- 필수 항목
  - 버전, 일련번호, 서명 알고리즘 식별자, 발행자 이름, 유효기간, 주체 이름, 서명 등
  - 확장 영역에는 키와 정책 정보, 사용자와 발행자 속성, 인증 경로 제약조건이 들어감
- 폐지 목록(CRL, Certificate Revocation List)
  - 신뢰 당사자가 언제든지 이 목록을 검색할 수 있어야 함
  - 폐기된 인증서들은 일련번호에 의해서 확인 가능
- 폐지 사유
  - 사용자의 개인키가 노출되거나 훼손된 것으로 판단될 때
  - CA가 사용자를 더 이상 인증해줄 수 없을 때
  - CA의 개인키가 노출되었거나 훼손된 것으로 판단될 때

### 운영 프로토콜

- 온라인 인증서 상태 검증 프로토콜(OCSP, Online Certificate Status Protocol)
  - 실시간으로 인증서 상태 확인 가능
  - 백그라운드에서 자동 수행
  - CA에 의해 관리되는 CRL을 검사
- 인증서 관리 프로토콜(CMP, Certificate Management Protocol)
  - PKI 환경에서 인증서 관리 서비스를 제공하기 위한 PKI 실체들 간 통신 프로토콜