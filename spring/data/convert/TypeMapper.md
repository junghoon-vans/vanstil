---
tags:
  - spring-data
---

```mermaid
flowchart LR
	S <--> TypeMapper <--> TypeInformation
```

도메인 객체를 데이터스토어에 저장하는 과정에서 기존 타입 정보(Type Information)는 유실될 수 있다. 그렇기 때문에 `TypeMapper`를 사용하여  [[TypeInformation]]을 저장해야 한다. 이때 사용되는 key를 `TypeKey`라 부르며, 일반적으로 `_class`를 사용한다.

