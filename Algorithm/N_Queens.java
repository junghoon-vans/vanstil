import java.util.Scanner;

class N_Queens{
	int N = new Scanner(System.in).nextInt();
	int [] cols = new int [N + 1];

    public void queens(int level){
        if(level == N){
            for(int i=0;i<N;i++){
                System.out.print(cols[i]);
            }
            System.out.println("");
        }
        else{
            for(int i=0;i<N;i++){
                cols[level]=i+1;
                if(feasible(level)){
                    queens(level+1);
                }
            }
        }
    }

    public boolean feasible(int level){
        for(int i=0;i<level;i++){
            if(cols[i]==cols[level] || Math.abs(level-i)== Math.abs(cols[level]-cols[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	System.out.println("수를 입력하세요.");
    	System.out.print("> ");
    	N_Queens q = new N_Queens();
    	q.queens(0);
	}
}
