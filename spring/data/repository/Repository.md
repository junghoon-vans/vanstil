---
tags:
  - spring-data
  - spring-repository
---

> ⚠️ Spring Data 라이브러리를 직접 구현하며 얻은 지식들을 정리한 문서이므로, 내용 상에 오류가 있을 수도 있습니다.

**Spring Data**를 사용하면 인터페이스만 정의하는 것으로 `Repository`를 사용할 수 있다. 해당 문서에서는 어떻게`Repository`가 빈으로 생성되는 지에 대해 다룬다.
## Proxy Repository

사용자가 정의한 인터페이스가 빈으로 등록되는 원리는 Proxy에 있다. `Repository`에 대한 기본 구현을 `BaseClass`로 하여 추가적인 사용자 정의 로직을 담은 Proxy Repository를 만드는 것이다.

![](https://docs.spring.io/spring-framework/reference/_images/aop-proxy-call.png)

- 일반적으로 각 Spring Data 구현체 별 `BaseClass`는 `SimpleXXXRepository`라는 이름으로 구현된다.
	- e.g. [SimpleElasticsearchRepository](https://docs.spring.io/spring-data/elasticsearch/docs/current/api/org/springframework/data/elasticsearch/repository/support/SimpleElasticsearchRepository.html), [SimpleKeyValueRepository](https://docs.spring.io/spring-data/keyvalue/docs/current/api/org/springframework/data/keyvalue/repository/support/SimpleKeyValueRepository.html)
- [[Query Methods]]로 정의한 로직은 동적 생성되어 프록시 객체에 담긴다.
- 따라서 생성되는 프록시 객체는 `기본 구현 + 사용자 정의 로직`을 수행할 수 있다.
## RepositoryFactory

`RepositoryFactory`는 이러한 Proxy Repository의 생성을 담당하며, 추상 클래스인 [RepositoryFactorySupport](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/core/support/RepositoryFactorySupport.html#getRepository(java.lang.Class))로 구현된다.

```java
public <T> T getRepository(Class<T> repositoryInterface, RepositoryFragments fragments)
```

[RepositoryFactorySupport#getRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/core/support/RepositoryFactorySupport.html#getRepository(java.lang.Class)) 메서드는 Repository 인터페이스를 전달받고 Repository 구현을 반환한다. 내부적으로 프록시 객체를 생성하는 로직이 담겨 있다.
## RepositoryFactoryBean

다만 일반적으로 `RepositoryFactory`를 **직접 사용하지 않는다**. 대신 스프링에서는 `RepsitoryFactoryBean`라는 클래스가 초기화되는 시점(afterPropertiesSet)에 `RepositoryFactory#getRepository`를 호출하도록 제공하고 있다. 

이렇게 사용하는 이유에 대해서는 공식 문서에서 찾아볼 수 있는데, [FactoryBean](https://docs.spring.io/spring-framework/docs/6.0.13/javadoc-api/org/springframework/beans/factory/FactoryBean.html) 인터페이스를 제공하면 Spring configuration을 통한 Repository 설정이 쉽기 때문이다. `RepositoryFactoryBean` 또한 마찬가지로 구현은 추상 클래스인 [RepositoryFactoryBeanSupport](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/core/support/RepositoryFactoryBeanSupport.html)를 사용한다.

> Spring Data KeyValue를 사용한 구현체의 경우 별도 구현 없이 제공되는 구현을 사용해도 된다.
> - [KeyValueRepositoryFactory](https://docs.spring.io/spring-data/keyvalue/docs/current/api/org/springframework/data/keyvalue/repository/support/KeyValueRepositoryFactory.html)
> - [KeyValueRepositoryFactoryBean](https://docs.spring.io/spring-data/keyvalue/docs/current/api/org/springframework/data/keyvalue/repository/support/KeyValueRepositoryFactoryBean.html)
