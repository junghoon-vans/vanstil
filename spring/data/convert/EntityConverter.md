## API

```java
Interface EntityConverter<E extends PersistentEntity<?,P>,P extends PersistentProperty<P>,T,S>
```

- [EntityConverter](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/convert/EntityConverter.html)는 `EntityReader`와 `EntityWriter`를 확장함
- [[MappingContext]]와 [[ConversionService]]에 접근하기 위한 getter를 가짐

## 사용 목적

> 공식 API 문서에 나와있지 않은 내용을 경험을 토대로 보충하였습니다.

```mermaid
flowchart LR
	DomainObject <--> EntityConverter <--> DataObject
```

[[EntityConverter]]는 `도메인 객체(Domain Object)`를 데이터 스토어에 특화된 `데이터 객체(Data Object)`로 변경하기 위해 사용한다. 예를 들어 `Spring Data Redis`의 경우 도메인 객체를 [[EntityConverter]]를 통해 `Map<String, Byte[]>` 타입으로 변환한다.

## 협력 클래스

`EntityConveter`는 혼자 동작하지 않고 여러 클래스와 협력하며, 아래와 같은 클래스들이 필요하다.

> 각 역할에 대해서 자세히 알고싶다면 해당 문서로 이동해주세요.

- [[TypeMapper]]
- [[MappingContext]]
- [[CustomConversions]]


