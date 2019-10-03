
import java.util.*;

public class QuickSort {
	public static int count = 0;

	public static void main(String[] args) {
		System.out.println("정렬할 리스트의 사이즈를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        // 입력한 수만큼 배열 생성
        int arr[] = new int[scanner.nextInt()];
        System.out.println("리스트의 인수를 차례로 입력하세요.");
        // 입력한 수들을 차례로 배열에 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        // 퀵 정렬 시작
        System.out.println("퀵 정렬 전: " + Arrays.toString(arr));
        System.out.println("-----------------퀵 정렬 시작------------------");
        quickSort(arr, 0, arr.length - 1);

    }

	public static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int arr[], int begin, int end) {
    int left = begin;					// 왼쪽 커서
		int right = end;					// 오른쪽 커서
		int pivot = arr[(left + right) / 2];		// 피벗

		do {
			while (arr[left] < pivot) left++;
			while (arr[right] > pivot) right--;
			if (left <= right)
				swap(arr, left++, right--);
				System.out.print("퀵 정렬 " + ++count + "단계: ");
				System.out.println(Arrays.toString(arr));
		} while (left <= right);

		if (begin < right)  quickSort(arr, begin, right);
		if (left < end) quickSort(arr, left, end);

    }

}
