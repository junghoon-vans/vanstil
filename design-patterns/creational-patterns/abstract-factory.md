상세화된 서브클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체의 군을 생성하기 위한 인터페이스를 제공

> 키트(Kit)라는 이름으로도 불린다.

동기
---

윈도우와 맥 OS의 사용자 인터페이스는 서로 `다른 룩앤 필`을 가지고 있다. 이로 인해 동일한 위젯(스크롤바, 버튼)라 할지라도 모양이 다르고 동작방식도 다르다. 개발한 응용프로그램이 서로 `다른 운영체제`에서의 이식성을 지니기 위해서는, 운영체제에서 제공하는 위젯을 직접 사용해서는 안된다.

해당 문제는 추상 클래스인 `AbstractFactory`를 정의하는 것으로 해결한다. AbstractFactory에 `기본 유저 인터페이스 요소`(윈도우,스크롤바,버튼 등)를 생성할 수 있는 인터페이스를 정의한다. 그리고 실제적으로 생성되는 객체에 대해서는 `AbstractProduct` 인터페이스를 정의하고 이를 상속하는 서브클래스를 정의하여 서로 다른 운영체제에 이식성을 제공한다.

구조
---

![abstract_factory](https://www.cs.unc.edu/~stotts/GOF/hires/Pictures/abfac108.gif)

참여자
---

- `AbstractFactory`: 개념적 제품에 대한 객체를 생성하는 연산으로 인터페이스를 정의
- `ConcreteFactory`: 구체적인 제품에 대한 객체를 생성하는 연산을 구현
- `AbstractProduct`: 개념적 제품 객체에 대한 인터페이스를 정의
- `ConcreteProduct`: 구체적으로 팩토리가 생성할 객체를 정의하고 `AbstractProduct`에서 정의한 인터페이스를 구현
- `Client`: `AbstractFactory`와 `AbstractProduct` 클래스에 선언된 인터페이스를 사용

협력방법
---

- 일반적으로 `ConcreteFactory` 클래스의 인스턴스 한 개가 런타임에 생성된다. 
- 이것은 특정 구현을 갖는 제품 객체를 생성한다.
- `AbstractFactory`는 필요한 제품 객체를 생성하는 책임을 ConcreteFactory 서브클래스에게 `위임`합니다

결과
---

- 구체적인 클래스 분리
- 제품군을 쉽게 대체할 수 있게 함
- 제품 사이에 일관성 증진
- 새로운 종류의 제품을 제공하기 어려움

> 해당 패턴을 사용했을 시 장단점

적용된 사례
---

자바 GUI 라이브러리인 `Swing(AWT)`의 `룩 앤드 필` 변경 기능이 대표적인 예시이다. 해당 기능으로 인해 Swing GUI로 짜인 자바 프로그램은 OS에 따라 적합한 인터페이스를 별도로 제공한다. 동일한 위젯이더라도 윈도우와 맥 OS에서 실행했을 시에 보이는 모양이 다르다.

관련 패턴
---

`AbstractFactory` 클래스는 `팩토리 메서드` 패턴을 이용해서 구현되는데, Prototype 패턴을 이용할 때도 있다. 구체 팩토리는 `Singleton` 패턴을 이용해 구현하는 경우가 많다.

참고문헌
---

- Gof의 디자인 패턴 번역본
- [Department of Computer Science University of North Carolina](https://www.cs.unc.edu/~stotts/GOF/hires/pat3afso.htm)
- [위키피디아 추상 팩토리 패턴](https://ko.wikipedia.org/wiki/%EC%B6%94%EC%83%81_%ED%8C%A9%ED%86%A0%EB%A6%AC_%ED%8C%A8%ED%84%B4)