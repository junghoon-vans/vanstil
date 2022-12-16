복합 객체의 생성 과정과 표현방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴

활용성
---

- 복합 객체의 생성 알고리즘이 객체를 합성하는 요소들과 이들의 조립 방법에 독립적일 때
- 합성할 객체들의 표현이 서로 다르더라도 생성 객체에서 이를 지원해야 할때

구조
---

![builder](https://www.cs.unc.edu/~stotts/GOF/hires/Pictures/builder.gif)

참여자
---

- `Builder`: `Product` 객체의 일부 요소들을 생성하기 위한 추상 인터페이스
- `ConcreteBuilder`: `Builder` 클래스에서 정의한 인터페이스를 구현하고, 제품의 부품들을 모아 빌더를 복합함
- `Director`: Builder 인터페이스를 사용하는 객체를 합성
- `Product`: 생성할 복합 객체

협력 방법
---

![build](https://www.cs.unc.edu/~stotts/GOF/hires/Pictures/build095.gif)

- 사용자는 `Director` 객체를 생성하고, 이렇게 생성된 객체를 자신이 원하는 `Builder` 객체로 합성
- 제품의 일부가 구축될 때마다 Director는 Builder에게 통보
- Builder는 Director의 요청을 처리하여 제품에 부품을 추가
- 사용자는 Builder에서 제품을 검색

결과
---

- 제품에 대한 내부 표현을 다양하게 변화
- 생성과 표현에 필요한 코드를 분리
- 복합 객체를 생성하는 절차를 보다 세밀화

관련 패턴
---

복잡한 객체를 생성해야 할 때 추상 팩토리 패턴은 빌더 패턴과 비슷하다. `빌더 패턴`은 복잡한 객체의 `단계별 생성`에 중점을 둔다면, `추상 팩토리 패턴`은 `유사군`들에 대한 유연한 설계가 중점이다. 빌더 패턴은 생성의 마지막 단계에서 생성한 제품을 반환하는 반면, 추상 팩토리 패턴에서는 만드는 즉시 제품을 반환한다는 차이도 있다.

참고 문헌
---

- Gof의 디자인 패턴 번역본
- [Department of Computer Science University of North Carolina](https://www.cs.unc.edu/~stotts/GOF/hires/pat3bfso.htm)