
![JVM 구조](https://www.javainterviewpoint.com/java-virtual-machine-architecture-in-java/jvm-architecture/)

JVM은 자바의 동작을 이해하기 위해서 필수적인 개념이다. 자바 코드는 바이트코드로 컴파일된 이후 JVM 위에서 동작하기 때문이다. JVM은 크게 5가지 영역으로 구분된다.

Class Loader Subsystem
---

JVM은 런타임 동안 RAM에 위치하며, 클래스 로더를 사용하여 바이트코드(.class)를 메모리에 로드한다. 이것은 자바에서 `Dynamic Class Loading`라 불리는 기능이다.

> 런타임 이전에 [[프로그램 실행 과정|로드 타임]]을 수행하는 C/C++ 등의 컴파일 언어와 달리 자바는 런타임시 동적으로 클래스 파일을 로드한다.

### Loading

클래스들은 `BootStrap ClassLoader`, `Extension ClassLoader` 그리고 `Application ClassLoader`라는 세 가지 클래스 로더를 통해 로드된다.

![클래스 로더 구조](https://miro.medium.com/v2/resize:fit:1280/0*MCf4PciEbMGwOL6L)

#### BootStrap ClassLoader

- 모든 클래스 로더의 부모
- 코어 Java 클래스를 로드
	- `java.lang.Object`, `java.lang.String` 및 `java.lang.Class` 등
- BootStrap Class Path
	- `$JAVA_HOME/jre/lib`
- 네이티브 언어(C, C++)로 구현

#### Extension ClassLoader

- `BootStrap ClassLoader`에서 로드하지 못한 클래스를 `외부 경로`에서 로드
- Extension Class Path
	- `$JAVA_HOME/jre/lib/ext`
	- 또는 지정된 다른 경로

#### Application ClassLoader

- 애플리케이션 레벨의 클래스를 로드
- Application Class Path
	- `-cp` 또는 `-classpath` 커맨드라인 옵션으로 지정
- `sun.misc.Launcher$AppClassLoader`로 구현됨

### Linking

로드된 클래스나 인터페이스를 검증(Verify)하고 준비(Prepare)하는 과정이다.

#### Verify

- 클래스 파일이 Java 언어의 규칙을 준수하는 지 확인

#### Prepare

- static 필드에 메모리를 할당하고 기본값으로 초기화

#### Resolve

- 심볼릭 참조를 직접 참조로 변경
	- 실제 객체가 위치한 주소를 사용하도록 변경
	- Method Area를 검색하여 수행

### Initialization

- static 변수를 사용자가 정의한 값으로 초기화

Runtime Data Area
---

JVM 프로그램은 실행 시 5가지 영역으로 구분하여 데이터를 저장한다.

> C/C++의 [[메모리 레이아웃]]과는 다르게 구분된다.

### Method Area

- static 변수를 포함한 `클래스 레벨`의 데이터 저장을 위한 공간
- JVM 내 하나의 Method Area만 존재
	- 모든 쓰레드가 공유하며, 쓰레드 안전하지 않음

### Heap Area

- 모든 `객체`와 `인스턴스 변수 및 배열`를 저장되는 공간
- JVM 내 하나의 Heap Area만 존재
	- 모든 쓰레드가 공유하며, 쓰레드 안전하지 않음

### Stack Area

- 메서드 호출을 저장하기 위해 사용하는 공간
	- 메소드 호출 발생 시 생성
	- `스택 프레임`이라는 단위를 사용
- 메서드가 종료될 때 해제됨
- 쓰레드 별로 각자의 스택 공간을 가짐
	- 따라서 쓰레드 안전

#### 스택 프레임

![스택 프레임](https://miro.medium.com/v2/resize:fit:754/0*9GyWqgKUyoo-F2_g)

함수 처리에 필요한 정보를 저장하기 위한 단위로, C/C++ 언어 등에서 말하는 [[Activation Record]]와 동일한 개념이다.

### PC Register

- `PC(Program Counter)`를 저장하기 위한 공간
- 현재 실행중인 명령어의 주소를 담고 있음
- 명령어 실행이 끝나면 다음 주소로 업데이트 됨

### Native Method Stack

- 네이티브 메서드 정보를 가지고 있음
- 모든 쓰레드는 구분된 Native Method Stack를 생성

Execution Engine
---

**Runtime Data Area**에 정의된 바이트코드는 실행 엔진으로 실행된다.

### Interpreter

- 바이트코드를 번역하는 것은 빠르지만 실행은 느림
- 한 메서드가 여러 번 호출되더라도 매번 해석함

### JIT Compiler

- 인터프리터의 단점을 개선하기 위해 사용
- 반복되는 코드를 네이티브 코드로 변환하여 캐싱하여 성능 개선

### Garbage Collector

- 참조되지 않는 객체를 찾고 제거

Native Method Interface(JNI)
---

- Execution Engine 실행에 필요한 인터페이스
	- Native Method Library와 연동하여 동작
- JVM은 C/C++ 라이브러리를 통해 하드웨어와 상호작용

Native Method Library
---

- C/C++로 작성된 네이티브 라이브러리

참고문헌
---

- [The JVM Architecture Explained](https://dzone.com/articles/jvm-architecture-explained)
- [Understanding JVM Architecture](https://medium.com/platform-engineer/understanding-jvm-architecture-22c0ddf09722)