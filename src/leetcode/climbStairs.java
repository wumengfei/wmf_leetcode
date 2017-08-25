package leetcode;

public class climbStairs {
	public static int climbStairs(int n) {
		if (n < 1) return 0;
        if (n==1 || n==2){
        	return n;
        }
        int result = 2;
        int pre = 1;
        int tmp = 0;
        for (int i=3; i<=n; i++){
        	tmp = result + pre;
        	pre = result;
        	result = tmp;
        }
        return result;
    }
	public static void main(String[] args){
		int result = climbStairs(5);
		System.out.println(result);
	}
}
