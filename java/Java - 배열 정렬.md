
오름차순
---

`java.util.Arrays` 클래스의 `sort()` 메서드를 이용하면 쉽게 오름차순 정렬이 가능하다.

```java
int[] array = {3, 1, 5, 2, 4};
Arrays.sort(arr); // {1, 2, 3, 4, 5}
```

내림차순
---

내림차순의 경우 `Collections` 클래스의 `reverseOrder()`를 사용하면 쉽게 할 수 있다.

> `reverseOrder()`는 역순으로 정렬하기 위한 `Comparator<T>` 객체를 반환한다.

```java
int[] array = {3, 1, 5, 2, 4};
Integer[] genericArray = Arrays.stream(array)
	.boxed()
	.toArray(Integer[]::new);
Arrays.sort(genericArray, Collections.reverseOrder()); // {5, 4, 3, 2, 1};
```
주의할 점은 Collections를 사용하여 정렬하는 경우 데이터타입이 `참조형`이어야 한다는 점이다.
따라서 `int[]`형의 배열을 정렬한다면 `Integer[]`형으로 변환해야 한다.

> `String`형 배열의 경우 이미 참조형이므로 이러한 변환 과정이 필요없다.

```java
array = Arrays.stream(genericArray)
	.mapToInt(Integer::intValue)
	.toArray();
```
만약 `Interger[]`형의 배열을 다시 `int[]`형의 배열로 변환하고 싶다면 위와 같이 `stream`을 사용하면 된다.