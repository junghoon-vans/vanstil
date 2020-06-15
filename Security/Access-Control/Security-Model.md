보안 모델
===

Contents
---

- [강제적 접근통제(MAC, Mandatory Access Control)](#강제적-접근통제mac-mandatory-access-control))
  - [벨라파듈라 모델(BLP, Bell-LaPadula Confidentiality Model)](#벨라파듈라-모델blp-bell-lapadula-confidentiality-model)
    - [보안 규칙](#보안-규칙)
  - [비바 무결성 모델(Biba Integrity Model)](#비바-무결성-모델biba-integrity-model)
  - [클락-윌슨 무결성 모델(Clark-Wilson Integrity Model)](#클락-윌슨-무결성-모델clark-wilson-integrity-model)
  - [만리장성 모델(Chinese Wall Model)](#만리장성-모델chinese-wall-model))
- [임의적 접근통제(DAC, Discretionary Access Control)](#임의적-접근통제-dac-discretionary-access-control))
  - [접근 제어 행렬(Access Control Matrix)](#접근-제어-행렬access-control-matrix)
  - [자격 목록(Capability List, Capability Tickets)](#자격-목록capability-list-capability-tickets))
  - [접근제어 목록(ACLs, Access Control Lists)](#접근제어-목록acls-access-control-lists))
- [역할기반 접근통제(RBAC, Role-Based Access Control)](#역할기반-접근통제rbac-role-based-access-control)
  - [장점](#장점)

강제적 접근통제(MAC, Mandatory Access Control)
---

자원의 보안 레벨과 사용자의 보안 취급 인가를 비교하여 접근 제어

- `관리자만`이 접근제어의 규칙을 설정, 변경(중앙집중형 보안관리)
- `다중 수준 보안 정책`에 기반함(서로 다른 분류 수준의 데이터가 보호되는 방법)
- 벨라파듈라(BLP), 비바 무결성 모델, 클락-윌슨 모델, 만리장성 모델이 대표적

> 모든 MAC 모델은 벨라파듈라(BLP) 모델을 근간으로 함

- 장점
  - 매우 엄격한 보안
  - 모든 객체에 대한 관리가 용이
- 단점
  - 구현, 운영이 복잡
  - 모든 접근에 대해 확인해야 하므로 성능 저하
  - 상업적인 환경에 부적합

### 벨라파듈라 모델(BLP, Bell-LaPadula Confidentiality Model)

기밀성을 강조하고 수학적 모델에 기반하는 최초의 MAC 모델

| 장점 | 단점 |
|------|------|
| <li>트로이 목마 공격 불가</li><li>낮은 단계에서 높은 단계로 가는 `기밀성 유지`에 강함</li> | <li>낮은 단계에서 높은 단계로 글을 쓸 수 있으므로 `무결성 유지 어려움`</li><li>높은 사용자와 낮은 사용자 간 자원 공유 시 기밀성 유지 훼손</li> |

#### 보안 규칙

|              |  읽기 | 쓰기 | 읽기/쓰기 |
|:------------:|:-----:|:----:|:---------:|
| 상급 보안 계층  | X | O | X |
| 할당된 보안 계층 | O | O | O |
| 하급 보안 계층  | O | X | X |

- 단순 보안 속성: 상향 읽기 X / 하향 읽기 O
- 성형 보안 속성: 상향 쓰기 O / 하향 쓰기 X
- 특수 성형 속성: 동일 레벨에서만 읽기/쓰기 가능

### 비바 무결성 모델(Biba Integrity Model)

BLP를 보완한 무결성 모델(MAC)

- 무결성의 목표 중 비인가자에 의한 부적절한 `변조방지만`을 목적으로 함

**보안 규칙**

|              |  읽기 | 쓰기 | 읽기/쓰기 |
|:------------:|:-----:|:----:|:---------:|
| 상급 보안 계층  | O | X | X |
| 할당된 보안 계층 | O | O | O |
| 하급 보안 계층  | X | O | O |

- 단순 무결성 속성: 상향 읽기 O / 하향 읽기 X
- 무결성 제한: 상향 쓰기 X / 하향 쓰기 O
- 호출 속성: 높은 무결성을 가진 주체에게 서비스 요청 X

### 클락-윌슨 무결성 모델(Clark-Wilson Integrity Model)

조금 더 정교하고 실제적인 무결성 모델

- 무결성의 3가지 목표 제공
  - 비인가자 수정 방지
  - 내/외부 일치성 유지
  - 인가자의 불법적인 수정 방지
- 사용자는 프로그램을 통해서만 객체에 접근
- 상업용

### 만리장성 모델(Chinese Wall Model)

정보 흐름 모델을 기반으로 주체와 객체 사이에서 이해 충돌을 야기하는 방식으로 정보가 흐르지 않도록 함

- 사용자의 이전 동작에 따라 변화할 수 있는 접근 통제(MAC, DAC)
- 자유 재량과 강제적 접근 개념 모두 이용
- 이해 충동을 방지하기 위해 만리장성이라는 벽 사용

임의적 접근통제(DAC, Discretionary Access Control)
---

주체가 속해있는 `그룹의 신원에 근거`하여 객체에 대한 접근을 제한하는 방법

- 객체의 소유자가 접근여부를 결정한다. (분산형 보안관리)
- 하나의 주체마다 객체에 대한 접근 권한을 부여해야 함

> 대부분 운영시스템은 이를 기반으로 함

| 장점 | 단점 |
|------|------|
| <li>객체별 세분화된 접근 제어</li><li>특정 주체가 다른 주체에게 임의적인 접근 제어 가능</li><li>유연한 접근 제어 서비스</li> | <li>시스템 전체 차원의 일관성 있는 접근제어 부족</li><li>멀웨어, 바이러스, 웜, 루트 킷, 트로이 목마 등에 취약</li> |

### 접근 제어 행렬(Access Control Matrix)

`주체를 행`, `객체를 열`로 구성하고 해당 셀에 주체가 객체에 수행할 수 있는 접근 권한을 기록하여 관리

- 효과적인 권한 부여 정책을 정의 가능하지만 주체와 객체의 수가 많아질 경우 행렬의 크기가 커져 관리가 어려움
- 비어 있는 셀이 많아지므로 `공간적으로 비효율적`

### 자격 목록(Capability List, Capability Tickets)

한 주체가 갖는 `자격들의 리스트`

- 콘텐츠의 보안성이 보장받지 못하는 분산환경에서 사용
- 커버로스가 자격목록의 한 예

### 접근제어 목록(ACLs, Access Control Lists)

객체의 관점에서 주체에게 권한을 부여

역할기반 접근통제(RBAC, Role-Based Access Control)
---

주체와 객체 사이에 역할을 두어 역할에 따라 접근통제

- MAC와 DAC의 단점을 보완한 기법이다.
- 주체, 객체에 접근권한을 할당하는 것이 아닌 `역할에 접근권한`을 할당

### 장점

- 관리자에게 편리한 관리능력 제공
- DAC에 비해 유연성은 떨어지나, `일관성 있는 접근제어`가 용이
- 최소권한의 원칙, 직무분리의 원칙 충족 용이
