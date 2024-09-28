package tiku;

import java.math.BigInteger;

public class Solution263 {
    public boolean isUgly(int n) {


        if (n<=0) {
            return false;

        }else {
            while (n%2==0||n%3==0||n%5==0){
                if(n%2==0) n = n/2;
                if(n%3==0) n = n/3;
                if(n%5==0) n = n/5;

            }
            if(n>=7){
                return false;
            }else {
                return true;
            }

        }



    }


    public static void main(String[] args) {
        System.out.println(new Solution263().isUgly(-2147483648));
    }
}

