package array;

public class sum_subset {
	public int getMaxLength(int[] arr, int k){
		if (arr.length==0 || k<=0){
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int len = 0;
		while(right<arr.length){
			if (sum==k){
				len = Math.max(len, right-left+1);
				sum -= arr[left++];
			}
			else if(sum<k){
				right += 1;
				//遗漏的地方
				if (right==arr.length){
					break;
				}
				sum += arr[right];
			}
			else{
				sum -= arr[left++];
			}
		}
		return len;
	}
}
