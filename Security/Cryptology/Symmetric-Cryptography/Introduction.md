대칭키 암호(Symmetric Cryptography)
===

암호화할 때 사용하는 키와 복호화할 때 사용하는 키가 같은 암호 알고리즘

Contents
---

- [블록 암호](#블록-암호)
  - [확산과 혼돈](#확산과-혼돈)
  - [전치 요소(P-box)](#전치-요소P-box)
  - [치환 요소(S-box)](#치환-요소S-box)
  - [합성 암호(Product Ciphers)](#합성-암호Product-Ciphers)
    - [Feistel](#feistel)
    - [SPN(Substitution-Permutation Network)](#spnsubstitution-permutation-network)
- [스트림 암호](#스트림-암호)
  - [동기식 스트림 암호](#동기식-스트림-암호)
    - [OTP(One Time Pad)](#otpone-time-pad)
    - [귀환 시프트 레지스터(FSR, Feedback Shift Register)](#귀환-시프트-레지스터fsr-feedback-shift-register)
    - [선형 귀환 시프트 레지스터(LFSR, Linear Feedback Shift Register)](#선형-귀환-시프트-레지스터lfsr-linear-feedback-shift-register)
  - [비동기식 스트림 암호](#비동기식-스트림-암호)
    - [비선형 귀환 시프트 레지스터(NLFSR, Non-Linear Feedback Shift Register)](#비선형-귀환-시프트-레지스터nlfsr-non-linear-feedback-shift-register)

블록 암호
---

치환과 전치를 이용하여 평문을 일정 단위(블록)로 나누어서 암호문을 생성하는 것

### 확산과 혼돈

- 확산(Diffusion): `평문과 암호문` 관계를 숨김
- 혼돈(Confusion): `암호문과 키`의 관계를 숨김

### 전치 요소(P-box)

평문 비트를 전치시키는 역할

- 단순 P-box
  - 입력받는 n 비트와 출력되는 m 비트의 크기가 같음(n = m)
  - 역함수가 존재
- 확장 P-box
  - n 비트를 입력받아 m 비트를 출력(n < m)
  - 입력 비트 중 특정 비트는 한 개 이상의 출력 비트와 연결됨
  - 비트의 양을 증가시키기 위해 사용
- 축소 P-box
  - n 비트를 입력받아 m 비트를 출력(n > m)
  - 입력으로 사용된 비트 중 특정 비트는 소실됨

### 치환 요소(S-box)

평문 비트를 치환하는 역할

> 입력되는 n 비트와 출력되는 m 비트의 크기가 같은 경우에만 역함수 존재

### 합성 암호(Product Ciphers)

S-box와 P-box, 그 외의 요소들을 결합하여 합성 암호를 만들어낸다.

> 이 합성 암호(Round)를 반복 사용함으로 확산과 혼돈 성질을 만족시킴

#### Feistel

- 대부분의 대칭 블록 암호 알고리즘(ex. DES)의 기반
- n 비트의 블록을 반으로 나누어서 반복된 연산 수행(3번 이상의 짝수 라운드)
- `암호화 과정 = 복호화 과정`
- 암호강도 결정 요소
  - 평문 블록 길이(64비트 이상)
  - 키 K의 길이(64비트 내외)
  - 라운드 수(16회 이상)

> 괄호의 조건이 충족되면 충분히 안전함을 의미

#### SPN(Substitution-Permutation Network)

- 입력을 여러 개의 소블록으로 분리
- 각 소블록을 `S-box`로 입력하여 대치
- `S-box의 출력`을 `P-box로 전치`하는 과정을 반복

스트림 암호
---

키스트림을 이용하여 비트 혹은 바이트 단위로 순차적으로 암호화

### 동기식 스트림 암호

- 키 스트림은 `평문 또는 암호문 스트림과 독립적`
- 암ㆍ복호화 과정에서 `상호 동기화` 필요

#### OTP(One Time Pad)

- 암호화를 수행할 때마다 `랜덤 키 스트림` 사용
- 이론적으로 해독 불가 (Shannon에 의해 증명)

#### 귀환 시프트 레지스터(FSR, Feedback Shift Register)

- `시프트 레지스터`와 `귀환 함수`로 구성
- S/W, H/W 환경에서 구현 가능
- H/W에서 구현 용이

#### 선형 귀환 시프트 레지스터(LFSR, Linear Feedback Shift Register)

- 많은 스트림 암호가 LFSR을 이용
- 선형성으로 인해 공격에 취약

### 비동기식 스트림 암호

- 키 스트림의 각 비트는 이전의 `평문이나 암호문에 종속적`으로 결정
- 키스트림과 평문의 함수관계로 암호문이 생성되므로 변조되어도 `자기 동기화` 가능
- 변조된 암호문이 후속 암호문 복호화에 사용되지 않아 `오류 파급 낮음`

#### 비선형 귀환 시프트 레지스터(NLFSR, Non-Linear Feedback Shift Register)

- 비선형성으로 LFSR보다 안전
- `자기 동기식 스트림 암호`라고도 함
