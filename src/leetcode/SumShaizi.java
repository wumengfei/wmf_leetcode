package leetcode;

public class SumShaizi {
    //dp算法，理解清楚，博客
    public static void probability(int n){
        int[] probs = new int[6*n];
        //初始化次数的最小值,probs[i]存放和为i+1出现的次数
        if(n==0) return;
        for (int i=0; i<6*n; i++){
            if (i<6) probs[i]=1;
            else probs[i]=0;
        }
        for (int i=1; i<n; i++){
            for (int j=6*(i+1)-1; j>=i; j--){
                int tmp = 0;
                for (int k=1; k<=6 && j-k>=i-1; k++){
                    tmp += probs[j-k];
                }
                probs[j] = tmp;
            }
        }
        int sum = 0;
        for (int i=n-1; i<6*n; i++){
            sum += probs[i];
        }
        for (int i=n-1; i<6*n; i++){
            System.out.println((float)probs[i]/sum);
        }
    }
    public static void main(String[] args){
        probability(3);
    }
}
