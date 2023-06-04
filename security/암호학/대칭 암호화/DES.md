1973년, 미국 국립기술표준원(NIST)에서 국가적으로 사용할 대칭키 암호시스템으로 채택

구조
---

![DES 구조](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-05-24-17-42-53.png)

- 데이터 길이
  - 평문: 64bit
  - 키: 56bit(오류검출비트 8bit 제외)
  - 암호문: 64bit
- 2개의 P-box
  - 초기 전치(initial permutation)
  - 최종 전치(final permutation)
- 라운드 키 생성기
  - 56비트 키에서 `48비트의 라운드 키`를 생성
  - 이러한 라운드 키는 각 라운드에서 사용됨
- 라운드 함수
  - `Feistel` 암호로 되어 있음
  - 혼합기(mixer) 교환기(swapper)가 존재

DES 함수
---

라운드 함수를 구성하는 함수로 4가지로 이루어져 있음

![DES 함수](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-05-24-19-45-56.png)

- 확장 P-box
- 키 XOR
- 8개의 S-box
- 단순 P-box

설계 기준
---

- S-box
  - 비선형 함수
  - `혼돈`을 제공
  - 한 비트가 변경되면 두 비트 이상이 바뀜
- P-box
  - `확산`의 성질을 만족

3DES
---

DES를 세 번 반복해서 사용한 것으로 `암호화-복호화-암호화` 과정을 거친다.

### 특징

- H/W에서 효율적이나 S/W에서 비효율적
- 느린 처리 속도

### 종류

- `2개의 키`를 이용하는 3중 DES
  - 첫 번째와 세 번째에서 동일한 키 사용
  - 기지 평문 공격에 취약
- `3개의 키`를 이용하는 3중 DES(DES-EDE3)
  - 평문을 첫 번째 키로 암호화
  - 그 결과를 두 번째 키로 복호화
  - 그 결과를 세 번째 키로 암호화
