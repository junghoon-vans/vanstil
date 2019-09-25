import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
public class MergeSort {

	static int size; // 정렬할 수의 개수 정의
	static List<Integer> list; // 정렬할 수의 리스트
    static int[] sortedList; // 정렬되는 숫자
    
    public static void main(String[] args) {
    	// 병합 정렬할 리스트 입력
    	System.out.println("정렬할 리스트의 사이즈를 입력하세요.");
    	Scanner sc = new Scanner(System.in);
    	size = sc.nextInt();
    	list = new ArrayList<>();
    	
    	System.out.println("리스트의 인수를 차례로 입력하세요.");
    	for(int i=0; i<=size-1; i++) {
    		list.add(sc.nextInt());
    	}
    	
    	sc.close();
    	
        
    	// 병합 정렬 시작
        System.out.println("병합 정렬 전: "+ list.toString());
        System.out.println("-----------------병합 정렬 시작------------------");
        
        if(size==1) {
        	System.out.println("병합 정렬 후: "+ list.toString());
    	}else{
        sortedList = new int[size];
        mergeSort(list, 0, size-1);
    	}
    }
    
    public static void mergeSort(List<Integer> list, int begin, int end) {
        int middle;
        if(begin<end) {
            middle = (begin+end)/2;
            mergeSort(list, begin, middle);    // begin에 대한 분할 작업 수행
            mergeSort(list, middle+1, end);    // end에 대한 분할 작업 수행
            merge(list, begin, middle, end);   // 부분집합에 대하여 정렬과 병합 작업 수행
        }
    }
    
    public static void merge(List<Integer> list, int begin, int middle, int end) {
        int i = begin;             // 첫 번째 부분집합의 시작 위치 설정
        int j = middle+1;     // 두 번째 부분집합의 시작 위치 설정
        int k = begin;             // 배열 sorted에 정렬된 원소를 저장할 위치 설정
        
        while(i<=middle && j<=end) {
            if(list.get(i)<=list.get(j)) {
                sortedList[k] = list.get(i);
                i++;
            }else {
                sortedList[k] = list.get(j);
                j++;
            }
            k++;
	        }
	        if(i>middle) {
	            for(int t=j;t<=end;t++,k++) {
	                sortedList[k] = list.get(t);
	            }
	        }else {
	            for(int t=i;t<=middle;t++,k++) {
	                sortedList[k] = list.get(t);
	            }
	        }
	        
	        for(int t=begin;t<=end;t++) {
	            list.set(t, sortedList[t]);
	        }
	        System.out.println("병합 정렬 후: "+ list.toString());
    }
        
}