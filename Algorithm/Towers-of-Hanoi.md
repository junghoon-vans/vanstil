하노이의 탑(Towers Of Hanoi)
----------------------------

### Contents

-	[개요](#개요)
-	[문제 해결](#문제-해결)
-	[자바 코드](#자바-코드)

### 개요

---

하노이의 탑(Tower of Hanoi)은 퍼즐의 일종이다. 세 개의 기둥과 이 기둥에 꽂을 수 있는 크기가 다양한 원판들이 있고, 퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있다.

게임의 목적은 다음 두 가지 조건을 만족시키면서, 한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것이다.

1.	한 번에 하나의 원판만 옮길 수 있다.
2.	큰 원판이 작은 원판 위에 있어서는 안 된다.

### 문제 해결

---

1.	원판이 한 개일 때
	-	1: 1 > 3
2.	원판이 두 개일 때
	-	1: 1 > 2
	-	2: 1 > 3
	-	1: 2 > 3
3.	원판이 세 개일 때
	-	1: 1 > 3
	-	2: 1 > 2
	-	1: 3 > 2
	-	3: 1 > 3
	-	1: 2 > 1
	-	2: 2 > 3
	-	1: 1 > 3

![towers-of-hanoi](https://i1.wp.com/algorithms.tutorialhorizon.com/files/2015/02/Tower-Of-Hanoi-1.png?resize=733%2C1024&ssl=1)

-	원판이 n개일 때
	-	1 ~ n-1번 원판: 1 > 2
	-	n번 원판: 1 > 3
	-	1 ~ n-1번 원판: 2 > 3

### 자바 코드

---

```java
import java.util.Scanner;

public class Hanoi {

    public int count = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("원반 갯수를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Hanoi hanoi = new Hanoi();
        hanoi.move(n, "1", "2", "3");
        hanoi.showCount();

    }

    public void move(int n, String source, String auxiliary, String destination) {
        if (n==1) {
            System.out.println(n+" : "+source+" -> "+destination);
            ++count;
        } else {
            move(n-1, source, destination, auxiliary); // 소스 기둥 -> 보조 기둥
            System.out.println(n+" : "+source+" -> "+destination); // 마지막 원반 목적지로 이동(전체원반수가 1이 아닐때)
            ++count;
            move(n-1, auxiliary, source, destination); // 보조 기둥-> 목적지 기둥
        }
    }

    public void showCount() {
        System.out.println("이동 횟수: " + count);
    }

}
```

---

<b>참조</b>: https://algorithms.tutorialhorizon.com/towers-of-hanoi/
