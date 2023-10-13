## API

[org.springframework.data.mapping.PersistentProperty](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/PersistentProperty.html)

```java
Interface PersistentProperty<P extends PersistentProperty<P>>
```

## 추가 설명

> 공식 문서에 부족한 내용을 경험을 토대로 작성하였습니다.

- 여기서 `영속성(Persistent)`란 `데이터 저장소(Data Store)`를 의미한다.
	- JPA의 영속성 컨텍스트와는 무관하다.
- 데이터 저장소에 저장될 Entity의 프로퍼티 정보이다.
- `Field`에 대한 값은 존재하지 않으며, Field 정보만을 가진다. (중요)
	- [getGetter()](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/mapping/PersistentProperty.html#getGetter()) 메서드를 통해 실제 값에 접근할 수 있다.
- 이외 `Association`, `TypeInformation` 등 정보를 가진다.