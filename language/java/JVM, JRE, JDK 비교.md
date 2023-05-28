![jvm-jre-jdk-비교](https://media.geeksforgeeks.org/wp-content/uploads/20210218150010/JDK.png)

자바는 하나의 코드로 여러 플랫폼에서 실행 가능하다는 특징을 가진다. 이를 `WORA(Write Once Run Anywhere)`라고도 한다. 자바는 이것을 위해 [[JVM]](Java Virtual Machine)`이라는 가상 머신을 사용한다. JVM은 운영체제나 하드웨어와 독립적으로 동작하며, `JDK(Java Development Kit)` 또는 `JRE(Java Runtime Environment)`에 포함되어 배포된다.

JVM(Java Virtual Machine)
---

- 자바 프로그램을 실행하기 위한 가상머신
	- 하드웨어와 운영체제와 독립적
- 바이트코드를 런타임에 컴파일하여 실행
	- 이를 위해 JIT 컴파일러와 인터프리터 내장

JRE(Java Runtime Environment)
---

- 자바 프로그램을 실행하기 위한 환경
	- JVM + 런타임 라이브러리
- 보통 개발 환경이 필요없는 경우 사용
	- jar 파일과 같은 바이트코드 실행만 가능

JDK(Java Development Kit)
---

- 자바 프로그램 개발에 필요한 도구 모음
	- JRE + 개발 도구
- 자바 파일을 클래스 파일로 컴파일하기 위해서는 JDK가 필요
	- javac 컴파일러는 JDK에 내장되어 있기 때문

### Java Platform, Standard Edition (Java SE)

- 일반적으로 사용하는 버전
- 데스크탑이나 서버에서 동작하는 애플리케이션 개발에 사용

### Java Platform, Enterprise Edition (Java EE)

- 엔터프라이즈 애플리케이션 개발을 위해 사용
- 주로 JSP 개발을 위해 사용했으나 Spring 등장 이후 잘 사용하지 않음
	- 이것과 관련해서는 블로그 글, [왜 스프링인가](https://vanslog.io/posts/web/spring/why-spring/)를 참고

### Java ME Embedded

- 소형 제품의 애플리케이션 개발을 위해 사용
- 임베디드 시스템이나 모바일 기기 등

참고문헌
---

- [GeeksForGeeks - Differences between JDK, JRE and JVM](https://www.geeksforgeeks.org/differences-jdk-jre-jvm/)
- [Oracle - Java Documentation](https://docs.oracle.com/en/java/index.html)