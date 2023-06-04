기존에 사용하던 DES의 문제점은 키의 길이가 54bit로 짧아 `Brute Force Attack(무차별 대입 공격)`이 가능하다는 것이었다. 그래서 NIST(미국 국립기술표준원)는 DES를 대체하기 위한 알고리즘을 공모하였고 최종적으로 AES가 선정되었다.

구조
---

![AES 구조](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-05-24-20-22-40.png)

- `non-Feistel` 알고리즘, `SPN` 구조
- 키 사이즈에 따라 라운드가 상이
  - AES-128(10라운드)
  - AES-192(12라운드)
  - AES-256(14라운드)

라운드 과정
---

![Round](https://vanslog.s3.ap-northeast-2.amazonaws.com/image/security/2020-05-24-20-59-09.png)

- SubBytes
  - 바이트 단위로 치환
  - 비 선형성을 갖는 S-box를 적용
- ShiftRows
  - 행 단위로 순환 시프트 수행
- MixColumns
  - 열 단위로 혼합
  - 높은 확산을 제공
  - 마지막 라운드에서 수행 X
- AddRoundKey
  - 라운드 키와 state를 XOR 연산