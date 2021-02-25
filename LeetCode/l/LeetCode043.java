package l;

public class LeetCode043 {

    /**
     * 你说，怎么样才能突破自己，实现自己的梦想，实现自己无忧的梦想
     * 首先还是，需要控制住自己，控制住自己的精力，自己的时间，不然那些浪费掉的岁月，总会找上门来进行讨债的
     * 其次，你需要坚守一个一个目标：一心一意的做技术，寻找自己适合的技术方向
     * 最后，坚持住！
     */


    /**
     43. Multiply Strings

     Given two non-negative integers num1 and num2 represented as strings,
     return the product of num1 and num2, also represented as a string.

     Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



     Example 1:

     Input: num1 = "2", num2 = "3"
     Output: "6"
     Example 2:

     Input: num1 = "123", num2 = "456"
     Output: "56088"


     Constraints:

     1 <= num1.length, num2.length <= 200
     num1 and num2 consist of digits only.
     Both num1 and num2 do not contain any leading zero, except the number 0 itself.

     * */

    //  1 <= num1.length, num2.length <= 200
    public static String multiply_w(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)) return "0";
        if("1".equals(num1)) return num2;
        if("1".equals(num2)) return num1;

        char[] n1=num1.toCharArray().length > num2.toCharArray().length?num1.toCharArray():num2.toCharArray();
        char[] n2=num1.toCharArray().length > num2.toCharArray().length?num2.toCharArray():num1.toCharArray();

//        n1 = 123
//        n2 = 12

        System.out.println(num1);
        System.out.println(num2);


        int result = 0;int tmpn2=1;
        for (int i = 0; i < n2.length; i++) {
            int n2i = n2[n2.length-1-i] - '0';
            int tmpResult = 0;int carry=0;
//            tmpResult= multiply(n2i,n1);

            result=result+tmpResult*tmpn2;
            tmpn2=tmpn2*10;
        }

//        StringBuilder builder = new StringBuilder();
//        while (result > 0){
//            builder.append(result%10);
//            result=result/10;
//        }


        return String.valueOf(result);
    }

//    private static String multiply(int n2i, char[] n1) {
//        StringBuilder tmpResult = new StringBuilder();
//        int carry=0;
//        for (int i = 0; i < n1.length; i++) {
//            int n1i = n1[n1.length-1-i]-'0';
//            int value = n2i*n1i+carry;
//            int v = value%10;
//            carry=value/10;
//            tmpResult.insert(0,v);
//        }
//        if(carry > 0){
//            tmpResult.insert(0,carry);
//        }
//       return tmpResult.toString();
//    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }



    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(add("123213","544545"));
        System.out.println(multiply(new char[]{'1','0','9'},new char[]{'4','5','9'}));
    }

    private static String multiply(char[] n2, char[] n1) {
        String[] tmpAddString = new String[n2.length];
        for (int i = n2.length-1; i >=0 ; i--) {
            int n2value = n2[i]-'0';
            StringBuilder value = multiply(n2value,n1);
            int add = i;
            while(add < n2.length-1){
                value.append("0");
                add++;
            }
            tmpAddString[n2.length-1-i] = value.toString();
        }

        String result = tmpAddString[0];
        for (int i = 1; i < tmpAddString.length; i++) {
            result= add(result,tmpAddString[i]);
        }
        return result;
    }

    public static String add(String n1,String n2){
        if(n1.length() > n2.length())return add(n2,n1);
        int i = 0,carry=0;
        StringBuilder result = new StringBuilder();
        while(i <= n1.length()-1 || i <= n2.length()-1){
            int n1v = n1.length()-i > 0? n1.charAt(n1.length()-1-i)-'0':0;
            int n2v = n2.length()-i > 0? n2.charAt(n2.length()-1-i)-'0':0;
            int value = n1v+n2v+carry;
            int v = value%10;
            carry=value/10;
            result.insert(0,v);
            i++;
        }
        if(carry>0)result.insert(0,carry);
        return  result.toString();
    }

    private static StringBuilder multiply(int n2i, char[] n1) {
        StringBuilder tmpResult = new StringBuilder();
        int carry=0;
        for (int i = 0; i < n1.length; i++) {
            int n1i = n1[n1.length-1-i]-'0';
            int value = n2i*n1i+carry;
            int v = value%10;
            carry=value/10;
            tmpResult.insert(0,v);
        }
        if(carry > 0){
            tmpResult.insert(0,carry);
        }
        return tmpResult;
    }
}
