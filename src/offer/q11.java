package offer;

import java.util.Scanner;

public class q11 {
    // 数值的整数次方
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double base = in.nextDouble();
        int pow = in.nextInt();
        double result = 1;

//        for (int i=0; i<pow; i++){
//            result *= base;
//        }
        result = powerWithPow(base, pow);

        System.out.println(result);
    }
    public static double powerWithPow(double base, int pow){
        if (pow == 1){
            return base;
        }
        double result = powerWithPow(base, pow>>1);
        result *= result;
        if ((pow & 1) != 0){
            return result *= base;
        }
        return result;
    }
}
