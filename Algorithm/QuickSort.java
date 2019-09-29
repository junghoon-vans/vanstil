
import java.util.*;

public class QuickSort {
	static int i = 0;

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

	public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end); // 분할
            quickSort(arr, begin, p - 1); // 왼쪽 부분 배열 정렬
            quickSort(arr, p + 1, end); // 오른쪽 부분 배열 정렬
        }
    }

	public static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int arr[], int begin, int end) {
        int left = begin;
        int right = end;
        int pivot = (left + right) / 2;

        System.out.println("퀵 정렬 " + ++i + "단계: pivot: " + arr[pivot]);

        while (left < right) {
            while ((arr[left] < arr[pivot]) && (left < right))
                // L 움직이는 부분
                left++;
            while ((arr[right] >= arr[pivot]) && (left < right))
                // R 움직이는 부분
                right--;

            if (left < right) {
                swap(arr, left, right);
            }
        }

        swap(arr, pivot, right);
        System.out.println(Arrays.toString(arr));

        return left;
    }

}
