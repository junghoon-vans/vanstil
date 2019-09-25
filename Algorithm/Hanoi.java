import java.util.Scanner;

public class Hanoi {

	public int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("원판 갯수를 입력하세요.");
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
			System.out.println(n+" : "+source+" -> "+destination); // 마지막 원판 목적지로 이동(전체 원판수가 1이 아닐때)
			++count;
			move(n-1, auxiliary, source, destination); // 보조 기둥-> 목적지 기둥
		}
	}

	public void showCount() {
		System.out.println("이동 횟수: " + count);
	}

}
