## API

[org.springframework.data.mapping.context.MappingContext](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/context/MappingContext.html)

```java
Interface MappingContext<E extends PersistentEntity<?,P>,P extends PersistentProperty<P>>
```

- [[PersistentEntity]]와 [[PersistentProperty]]를 포함하는 컨텍스트
- 객체 간의 `연관관계(Association)`를 생성하는 데 사용되기도 함

## 추가 설명

> 공식 문서에 부족한 내용을 경험을 토대로 작성하였습니다.

`MappingContext`는 [EntityConverter](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/convert/EntityConverter.html)의 동작 과정에서 필요한 컨텍스트이다. EntityConverter는 Spring Repository를 통해 전달된 `도메인 객체`와 데이터 스토어에 특화된 `데이터 객체` 간의 변환을 수행하게 되는데, 이때 [[PersistentEntity]]와 [[PersistentProperty]]는 메타 데이터로써 활용된다.
