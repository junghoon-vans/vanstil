---
tags:
  - spring-data
---
## API

[org.springframework.data.mapping.PersistentEntity](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/PersistentEntity.html)

```java
Interface PersistentEntity<T,P extends PersistentProperty<P>>
```

- 영속성 객체를 나타내는 인터페이스이다.
- `Iterator`를 사용하여 프로퍼티들이 반환되며, 순서는 보장되지 않는다.

## 추가 설명

> 공식 문서에 부족한 내용을 경험을 토대로 작성하였습니다.

- 여기서 `영속성(Persistent)`란 `데이터 저장소(Data Store)`를 의미한다.
	- JPA의 영속성 컨텍스트와는 무관하다.
- 데이터 저장소에 저장될 Entity에 대한 메타데이터이다.
	- Entity의 프로퍼티 정보인  [[PersistentProperty]]들을 내부 필드로 가진다.
- [getIdProperty()](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/PersistentEntity.html#getIdProperty()) 통해 `@Id`로 설정된 프로퍼티를 가져올 수 있다.
	- 특정 프로퍼티가 id 프로퍼티가 맞는지 파악하고 싶다면 [isIdProperty()](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/PersistentEntity.html#isIdProperty(org.springframework.data.mapping.PersistentProperty))를 사용한다.
- 이외 다양한 프로퍼티들에 대한 정보를 가지고 있다.
