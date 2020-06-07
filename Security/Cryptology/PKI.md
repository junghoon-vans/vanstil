공개키 기반 구조(PKI)
===

공개키 암호 및 전자서명의 기술을 사회적인 기반구조로 만들어 가는 것

- 공개키 알고리즘을 위한 키 관리 구조
- 제공 서비스
  - 기밀성, 무결성, 인증, 부인방지, 접근제어

Contents
---

- [구성요소](#구성요소)
  - [인증기관(CA, Certification Authority)](#인증기관ca-certification-authority)
    - [정책승인기관(PAA, Policy Approving Authority)](#정책승인기관paa-policy-approving-authority)
    - [정책인증기관(PCA, Policy Certification Authority)](#정책인증기관pca-policy-certification-authority)
    - [인증기관(CA)](#인증기관ca)
  - [검증기관(VA, Validation Authority)](#검증기관va-validation-authority)
  - [등록기관(RA, Registration Authority)](#등록기관ra-registration-authority)
- [형태](#형태)
  - [계층 구조](#계층-구조)
  - [네트워크 구조](#네트워크-구조)
- [공개키 인증서](#공개키-인증서)
  - [인증서 표준 규격(X.509)](#인증서-표준-규격x509)
  - [X.509 인증서 폐지 목록 프로파일](#x509-인증서-폐지-목록-프로파일)
    - [폐지 사유](#폐지-사유)
    - [폐지 목록(CRL, Certificate Revocation List)](#폐지-목록crl-certificate-revocation-list)
  - [운영 프로토콜](#운영-프로토콜)
    - [온라인 인증서 상태 검증 프로토콜(OCSP, Online Certificate Status Protocol)](#온라인-인증서-상태-검증-프로토콜ocsp-online-certificate-status-protocol)
    - [인증서 관리 프로토콜(CMP, Certificate Management Protocol)](#인증서-관리-프로토콜cmp-certificate-management-protocol)

구성요소
---

크게 인증기관, 검증기관, 등록기관, 저장소, 사용자로 구성

### 인증기관(CA, Certification Authority)

#### 정책승인기관(PAA, Policy Approving Authority)

- `루트 인증기관`으로, `PKI 전반의 정책`을 생성 및 수립
- 하위 기관들의 `정책 준수 상태` 및 `적정성 감사`

#### 정책인증기관(PCA, Policy Certification Authority)

- PAA 하위 계층
- 도메인 내의 `사용자와 CA의 정책` 수립
- `인증서`, `인증서 폐지 목록` 등 관리

#### 인증기관(CA)

- PCA 아래 계층으로 인증 정책 수립
- `사용자/등록기관`의 요청에 `공개키 인증서` 발행 및 폐지
- 사용자에게 자신의 공개키와 상위 기관을 공개키 전달
- PA요청에 의해 인증서 발급

### 검증기관(VA, Validation Authority)

- `인증서의 유효성` 여부, `관련 거래의 유효성` 여부 등 확인
- VA가 없다면 안정성이 떨어짐
- CA에서 직접 운영 가능

### 등록기관(RA, Registration Authority)

- 사용자와 CA가 원거리에 있는 경우
- CA 대신 사용자의 신분/소속 등 확인
- 선택적 요소

형태
---

### 계층 구조

- 최상위에 루트 CA가 존재하고 그 밑으로 하위 CA가 계층적으로 존재
- 상위 CA가 하위 CA에 인증서를 발행하고, 하위 CA는 상위 CA의 인증정책에 영향
- 루트 CA 간에 상호인증은 허용, 하위 CA 간에 상호인증은 불가능
- 인증경로 탐색이 용이하고, 모든 사용자가 최상위 CA의 공개키를 알고 있어서 검증이 용이
- 최상위 CA에 집중되는 오버헤드가 발생
- 최상위 CA의 비밀키 노출이 되면 피해 막대

### 네트워크 구조

- 각각의 CA들이 자신의 인증정책에 따라 독립적으로 존재
- 모든 상호인증이 허용되면 상호인증 수 대폭 증가
- 유연하고 인증경로가 단순하여 실직적인 업무관계에 적합
- CA의 비밀키가 노출되어도 피해가 적음
- 인증경로 탐색이 복잡
- 정책 수립과 적용이 어려움

공개키 인증서
---

해당 키가 `특정인의 것임을 보증`해주는 것

- 표준화된 양식으로 믿을 수 있는 제 3자가 발행하며 PKI의 근간
- 개인정보와 그 사람의 공개키가 기재되며 CA의 개인키로 서명됨

### 인증서 표준 규격(X.509)

- 인증서 표준 규격
- IP Security, SSL, 안전한 전자거래(SET)와 S/MIME 같은 `네트워크 보안 응용`에 사용

| 요소 | 구분 | 설명 |
|------|------|------|
| 버전 (Version) | 필수 | X.509의 버전 |
| 일렬번호 (Serial Number) | 필수 | CA에 의해 인증서에 부여되는 유일한 번호. (발행자이름과 일렬번호로 인증서를 유일하게 구분할 수 있어야 한다.) |
| 서명 알고리즘 식별자 (Signature Algorithm ID) | 필수 | CA가 인증서를 서명하기 위한 알고리즘과 알고리즘 식별자를 포함. 이 정보는 끝부분 서명 필드에도 포함되어 있다. |
| 발행자 이름 (Issuer name) | 필수 | 인증서 발행자(보통 CA)의 이름 |
| 유효기간 (Validity period) | 필수 | 인증서 유효기간의 시작날짜와 종료날짜 |
| 주체 이름 (Subject name) | 필수 | 사용자(피발급자)의 이름 <br> 상위 CA가 하위 CA에게 인증서를 발행하는 경우 이 필드에는 CA의 이름이 된다. |
| 주체의 공개키 정보 (Subject Public Key) | 필수 | 사용자의 공개키, 관련 알고리즘 |
| 발행자 유일 식별자 (Issuer Unique ID) | 선택(v2) | 발행자나 사용자의 이름이 중복되는 경우 이를 구별하기 위한 수단 |
| 주체 유일 식별자 (Subject Unique ID) | 선택(v2) | 주체를 유일하게 구별하는 데 사용 |
| 확장 (Extensions) | 선택(v3) | 발행자가 인증서에 추가적으로 사적인 정보를 넣을 수 있는 필드 |
| 서명 (Signature) | 필수 | 인증서에 대한 서명 값이 들어있는 필드 나머지 전체 필드를 보호하는 역할을 한다. 다른 필드 전체를 해시해서 나온 해시 값을 CA의 개인키로 암호화한 값이 들어간다. |

> 확장 영역에는 키와 정책 정보, 사용자와 발행자 속성, 인증 경로 제약조건이 들어간다.

### X.509 인증서 폐지 목록 프로파일

#### 페지 사유

- 사용자의 개인키가 노출되거나 훼손된 것으로 판단될 때
- CA가 사용자를 더 이상 인증해줄 수 없을 때
- CA의 개인키가 노출되었거나 훼손된 것으로 판단될 때

#### 폐지 목록(CRL, Certificate Revocation List)

- 신뢰 당사자가 언제든지 이 목록을 검색할 수 있어야 함
- 폐기된 인증서들은 `일련번호`에 의해서 확인 가능

### 운영 프로토콜

#### 온라인 인증서 상태 검증 프로토콜(OCSP, Online Certificate Status Protocol)

- 실시간으로 인증서 상태 확인 가능
- 백그라운드에서 자동 수행
- CA에 의해 관리되는 CRL을 검사

#### 인증서 관리 프로토콜(CMP, Certificate Management Protocol)

- PKI 환경에서 인증서 관리 서비스를 제공하기 위한 PKI 실체들 간 통신 프로토콜
  - PKI 실체: 이용자, 인증기관, 등록기관, 인증서 저장소 등
