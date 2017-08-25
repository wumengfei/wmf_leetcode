package leetcode;

public class hanoi_tower {
	public static int cnt = 0;
	public static void hanoi(int n){
		if (n>0){
			func(n, "left", "middle", "right");
		}
	} 
	public static void func(int n, String from, String middle, String to){
		if (n==1){
			cnt += 1;
			System.out.println(cnt + ": move from " + from + " to " + to);
		}else{
			func(n-1, from, to, middle);
			func(1, from, middle, to);
			func(n-1, middle, from, to);
		}
	}
	
	public static void main(String[] args){
		hanoi(8);
	}
}
