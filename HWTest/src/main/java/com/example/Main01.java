package com.example;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/10/20:00
 * @Description:
 */

public class Main01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            String a = split[0];
            String b = split[1];

            String[] maxStr = a.split("");
            String[] minStr = b.split("");

            if (maxStr.length < minStr.length){
                String[] tempStr = maxStr;
                maxStr = minStr;
                minStr = tempStr;
            }

            int maxLength =maxStr.length;
            int minLength =minStr.length;


            int[] ints = new int[maxLength + 1];

            boolean addOne = false;
            for (int i=0; i< minLength;i++){
                int i1 = (addOne? 1 : 0) + Integer.valueOf(maxStr[maxLength - 1 - i]) + Integer.valueOf(minStr[minLength -1 - i]);
                addOne = i1 > 9;
                if (addOne){
                    ints[maxLength - i] = i1 - 10;
                }else {
                    ints[maxLength - i] = i1;
                }
            }

            if (maxLength != minLength){
                ints[maxLength - minLength -1] = (addOne? 1 : 0) + Integer.valueOf(maxStr[maxLength - minLength - 1]) ;
                for (int i=minLength + 1;i<maxLength;i++){
                    int i1 =(addOne? 1 : 0) + Integer.valueOf(maxStr[maxLength - minLength - 1 -i]) ;
                    addOne = i1 > 9;
                    if (addOne){
                        ints[maxLength - minLength -1 -i] = i1 -10;
                    }else {
                        ints[maxLength - minLength -1 -i] = i1;
                    }
                }
            }

            if (addOne)
                System.out.print(1);
            for(int i=1;i<ints.length;i++)
                System.out.print(ints[i]);
        }
        System.out.println();

        /*while (scanner.hasNextLine()){
            String[] split = scanner.nextLine().split(",");
            Arrays.sort(split);
            for (int i=0;i<split.length;i++){
                System.out.print(split[i]);
                if (i<split.length -1){
                    System.out.print(",");
                }else{
                    System.out.println();
                }
            }
        }*/

        /*while (scanner.hasNextLine()){
            String[] split = scanner.nextLine().split(" ");
            Arrays.sort(split);
            for (int i=0;i<split.length;i++){
                System.out.print(split[i] + " ");
            }
            System.out.println();

        }*/


        /*int numItems = Integer.valueOf(scanner.nextLine()) ;
        String[] split = scanner.nextLine().split(" ");
        Arrays.sort(split);
        for (int i =0;i<split.length;i++){
            System.out.print(split[i] + " ");
        }*/

        /*int numRow = scanner.nextInt();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> resultArr = new ArrayList<>();

        for (int i=0;i<numRow;i++){
            strings.add(scanner.next());
        }

        while (!strings.isEmpty()){
            String str1 = strings.get(0);
            int index =0;
            for (int j=0;j<strings.size();j++){
                String str2= strings.get(j);
                if (str1.compareTo(str2) > 0 ){
                    str1 = str2;
                    index = j;
                }
            }
            strings.remove(index);
            resultArr.add(str1);
        }

        for (String s : resultArr){
            System.out.print(s + " ");
        }*/

        /*while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int sum = 0;
            String[] split = s.split(" ");
            for (String val : split) {
                sum +=Integer.valueOf(val) ;
            }
            System.out.println(sum);
        }*/

        /*while (scanner.hasNextInt()) {
            int numSum = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i < numSum; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }*/

       /* int numRow = scanner.nextInt();

        for (int i = 0; i < numRow; i++) {
            int numSum = scanner.nextInt();
            int sum = 0;
            for (int j = 0; j < numSum; j++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }*/


        /*while(scanner.hasNextInt()){
            int sum = 0;
            int numInteger = scanner.nextInt();

            if(numInteger == 0){
                break;
            }

            for (int i = 0; i < numInteger; i++){
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }*/



       /* while (scanner.hasNextLong()){
            long a = scanner.nextLong();

            if (a == 0){
                System.exit(0);
            }

            long b = scanner.nextLong();

            if (b == 0){
                System.exit(0);
            }

            System.out.println(a + b);
        }*/


        /*int numArr = scanner.nextInt();

        for (int i = 0; i < numArr; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(a + b);
        }*/

        /*while (scanner.hasNextInt()){
            System.out.println(scanner.nextInt() + scanner.nextInt() );
        }*/
    }
}