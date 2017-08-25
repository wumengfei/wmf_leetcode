package binaryTree;
// 统计节点数为N的二叉树的个数，dp
public class numOfTree {
	public static int numTree(int N){
		int[] nums = new int[N+1];
		nums[0] = 1;
		for(int i=1; i<N+1; i++){
			for(int j=1; j<=i; j++){
				nums[i] += nums[j-1] * nums[i-j]; 
			}
		}
		return nums[N];
	}
	
	public static void main(String[] args){
		System.out.println(numTree(5));
	}
}
