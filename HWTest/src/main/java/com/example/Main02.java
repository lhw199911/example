package com.example;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/11/19:44
 * @Description:
 */


public class Main02 {

    private static int getMinFactorNum(int sca) {

        if (sca % 2 == 0) {
            return 2;
        }

        for (int j = 3; j <= Math.sqrt(sca); j += 2) {
            int i1 = sca % j;
            if (i1 == 0) {
                return j;
            }
        }
        return sca;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int minFactorNum;
        do {
            minFactorNum = getMinFactorNum(i);
            queue.add(minFactorNum);
            if (i == minFactorNum) break;
            i /= minFactorNum;
        } while (true);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }


        /*System.out.println(Integer.parseInt(scanner.next().substring(2), 16));*/

       /* String s = scanner.nextLine();
        String[] split = s.split("");
        int z = 8;
        int i = split.length / z;
        int j = split.length % z;

        Stack<String> characters = new Stack<>();

        if (j!=0){
            String strTemp = "";
            for (int ii =0; ii < 8; ii++){
                int i1 = s.length() - j;
                strTemp += ((i1>=s.length())?"0":s.substring(i1, i1 +1));
                j--;
            }
            characters.add(strTemp);
        }
        while(i!=0){
            i--;
            characters.add(s.substring(i*z, i*z+z));
        }
        while (characters.size()!=0){
           System.out.println(characters.pop());
        }*/


/*        TreeSet<Short> shorts = new TreeSet<>();
        short i = scanner.nextShort();
        while (i != 0) {
            shorts.add(scanner.nextShort());
            i--;
        }
        Iterator<Short> iterator = shorts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        /*String[] stringArr = scanner.nextLine().split("");
        String strSub = scanner.nextLine();
        short result = 0;
        for (String str : stringArr
        ) {
            result += str.equalsIgnoreCase(strSub) ? 1:0;
        }
        System.out.println(result);*/

        /*String[] split = scanner.nextLine().split(" ");
        String s = split[split.length - 1];
        System.out.println(s.length());*/
    }
}

