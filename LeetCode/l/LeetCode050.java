package l;

public class LeetCode050 {

    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if(n > 0){
            if (n % 2 == 0){
                return myPow(x*x, n / 2);
            }else {
                return x*myPow(x*x, (n-1) / 2);
            }
        }else {
            if(Integer.MIN_VALUE == n){
                return 1/x*myPow(1/x,Integer.MAX_VALUE);
            }else{
                return myPow(1/x,-n);
            }

        }
    }
}
