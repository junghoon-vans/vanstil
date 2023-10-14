Spring Framework에서 [[Converter]]는 직접 호출하여 사용하는 방법은 권장되지 않는다.
그 대신 [ConversionService](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html)라는 서비스 인터페이스를 활용한다.

## DefaultConversionService

### 등록하기

```java
DefaultConversionService conversion = new DefaultConversionService();
conversion.addConverter(new AtoBConverter());
```

DefaultConversionService를 사용하여 컨버터를 등록하는 예시이다.
### 사용하기

```java
A a = new A();
conversion.convert(a, B.class);
```

이후 ConversionService의 [convert()](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html#convert(java.lang.Object,java.lang.Class)) 메서드를 통해 [Type Conversion](https://docs.spring.io/spring-framework/reference/core/validation/convert.html)을 수행한다. 만약 등록되지 않은 컨버터에 대한 형변환을 진행한다면 수행되지 않는다. 컨버전 서비스를 통해 형변환이 가능한지를 확인하고 싶다면 [canConvert()](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html#canConvert(java.lang.Class,java.lang.Class)) 메서드를 사용할 수 있다. 