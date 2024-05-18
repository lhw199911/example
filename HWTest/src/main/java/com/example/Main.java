package com.example;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/29/18:43
 * @Description:
 */
public class Main {

    private  static int sum = 0;

    private static Stack<Integer> stacks  = new Stack<>();

    private static void a(int cur, int  lp, int ln){
        if (ln==0 && lp == 0){
            if (!stacks.isEmpty()){
                sum ++;
            }
        }
        if (lp>0&&ln>0){
            for(int i = cur;i<cur+4;i++){
                stacks.add(i);
                a(i, lp - i, ln - 1);
            }
        }
        if (!stacks.isEmpty()){
            stacks.pop();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true){
            int m = in.nextInt();
            int n = in.nextInt();

            int mm = 0;
            for (int i=0;i<m;i++) {
                mm += 3 * i;
            }

            int min = 0;
            for (int i =1;i<=n/m;i++){
                if ((n - m * i) <= mm){
                    min = i;
                    break;
                }
            }

            int  max = 0;
            int left = n - m * min;
            for (int i=1;i<=left;i++){
                if (left - m * i < 0){
                    max = min + i -1;
                }
            }

            a(0, left, m);

            System.out.println(sum);
        }


        /*

        String[] split = in.nextLine().split(" ");

        int row = Integer.valueOf(split[0]);
        int col = Integer.valueOf(split[1]);

        Vector<Integer> vals = new Vector<>();
        Vector<Integer> nums = new Vector<>();

        for(int  i =2;i<split.length;i += 2){
            vals.add(Integer.valueOf(split[i]));
            nums.add(Integer.valueOf(split[i+1]));
        }

        split = in.nextLine().split(" ");

        Integer x = Integer.valueOf(split[0]);
        Integer y = Integer.valueOf(split[1]);

        int index = col * x + y + 1;
        int sumIndex = 0;

        for(int i=0;i<vals.size();i++){
            sumIndex += nums.get(i);
            if (sumIndex >= index) {
                System.out.println(vals.get(i));
                break;
            }
        }*/


        /*int i12 = in.nextInt();
        if (i12 % 2 == 1){
            long i11 = i12 / 2;
            System.out.println(i12 + "=" + i11 + "+" + (i11+1));
        }else {
        for (long i=3;i<i12/3;i++){
            if (i12%i==0){
                long l = i12 / i;
                long l1 = l - i + 2;
                System.out.print(i12 + "=" + l1);
                for (int  ii=1;ii<=i-1;ii++){
                    System.out.print("+" + (l1 + ii));
                }
                break;
            }
        }*/

        /*while (true) {
            long i1 = in.nextLong();
            if (i1 % 2 == 1) {
                long i11 = i1 / 2;
                System.out.println(i1 + "=" + i11 + "+" + (i11 + 1));
            } else {
                Vector<Long> integers = new Vector<>();
                long sum = 0;

                for (long i = i1 / 2; i > 0; i--) {
                    if (sum == i1) {
                        break;
                    }
                    if (sum < i1) {
                        integers.add(i);
                        sum += i;
                    }
                    if (sum > i1) {
                        Long remove = integers.remove(0);
                        sum -= remove;
                    }
                }

                if (sum == i1) {
                    System.out.print(i1 + "=" + integers.get(0));
                    for (int i = 1; i < integers.size(); i++) {
                        System.out.print("+" + integers.get(i));
                    }
                } else System.out.println("N");
            }
        }

        }*/
    }

}
