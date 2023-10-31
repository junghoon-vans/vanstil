---
tags:
  - spring-data
---
## API

[org.springframework.data.util.TypeInformation](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/util/TypeInformation.html)

```java
public interface TypeInformation<S>
```

- 프로퍼티 타입에 접근하기 위한 인터페이스
## 사용 사례

- [[PersistentEntity]]와 [[PersistentProperty]] 의 타입 정보
- [[TypeMapper]]에서 도메인 객체를 저장하는데 필요한 타입 정보

## 주요 메서드

- [isCollectionLike](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/util/TypeInformation.html#isCollectionLike())
	- Collection, Array, Iterable을 의미
- [isMap](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/util/TypeInformation.html#isMap())
