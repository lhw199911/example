package com.example;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/15/19:55
 * @Description:
 */
public class Main04 {

    /**
     * 判断是否超出边界，未超过则打印0，否则打印-1，判断依据，编辑值从1开始，被判断值从0开始，当两者相等时，则判断超出边界
     *
     * @param Integer[] num 第一二个数为两个边界，后继每隔两个数为需要判断的数
     * @return 判断是否超出边界，未超过则返回true，否则返回false
     **/

    /*private static boolean isOverMaxBorder(Integer... num) {
        Boolean flag = true;

        if (num.length % 2 == 0){
            Integer maxRow = num[0];
            Integer maxCol = num[1];
            for (int i = 2; i < num.length; i = i + 2) {
                flag = flag && num[i] < maxRow && num[i + 1] < maxCol;
            }
        }else {
            Integer maxBorder = num[0];
            Integer currentBorder = num[1];
            Integer addBorder = num[2];
            flag = currentBorder < maxBorder && addBorder < currentBorder;
        }
        System.out.println(flag ? 0 : -1);
        return flag;
    }*/
    private static boolean f(Integer index, List<Integer> list, Integer target) {
        if (index == list.size()) return target == 0;
        return f(index + 1, list, target - list.get(index)) || f(index + 1, list, target);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*描述
        输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
        数据范围：每个数组大小满足 1≤n≤50  ，输入的数据大小满足 ∣val∣≤500
        输入描述：
        第一行是数据个数，第二行是输入的数据
        输出描述：
        返回true或者false*/

        ArrayList<Integer> integers = new ArrayList<>();
        Integer i5 = 0;
        Integer i3 = 0;
        Integer sum = 0;
        int i = scanner.nextInt();
        for (int ii =0;ii<i;ii++) {
            Integer integer = scanner.nextInt();
            sum += integer;
            if (integer % 5 == 0) {
                i5 += integer;
            } else if (integer % 3 == 0) {
                i3 += integer;
            } else {
                integers.add(integer);
            }
        }
        if (sum % 2 != 0) {
            System.out.println("false");
            System.exit(0);
        }
        int target = sum / 2 - i3;
        System.out.println(f(0,integers, target));

        /*输入整型数组和排序标识，对其元素按照升序或降序进行排序
        数据范围：
        1≤n≤1000  ，元素大小满足 0≤val≤100000
        输入描述：
        第一行输入数组元素个数
        第二行输入待排序的数组，每个数用空格隔开
        第三行输入一个整数0或1。0代表升序排序，1代表降序排序
        输出描述：
        输出排好序的数字*/

        /*ArrayList<Integer> integers = new ArrayList<>();
        int numRow = scanner.nextInt();
        for (int i = 0; i < numRow; i++) {
            integers.add(scanner.nextInt());
        }
        Collections.sort(integers);
        if (scanner.nextInt() == 0) {
            for (int i = 0; i < numRow; i++) {
                System.out.print(integers.get(i));
                System.out.print(" ");
            }
        } else {
            for (int i = 0; i < numRow; i++) {
                System.out.print(integers.get(numRow - i - 1));
                System.out.print(" ");
            }
        }*/

        /*描述
        有一个  m∗n 大小的数据表，你会依次进行以下5种操作：
        1.输入 m 和 n ，初始化 m∗n 大小的表格。
        2.输入 x1、y1、y2 ，交换坐标在 (x1,y1) 和 (x2,y2) 的两个数。
        3.输入 x ，在第 x 行上方添加一行。
        4.输入 y ，在第 y 列左边添加一列。
        5.输入 x,y ，查找坐标为 (x,y) 的单元格的值。
        请编写程序，判断对表格的各种操作是否合法。
        详细要求:
        1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
        2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的 m∗n 大小，多出的数据则应舍弃。
        3.所有输入坐标操作，对 m∗n 大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
        本题含有多组样例输入！行列从0开始标号
        数据范围：数据组数： 1≤t≤5
        进阶：时间复杂度：O(1) ，空间复杂度：O(1)
        输入描述：
        输入数据按下列顺序输入：
        1 表格的行列值
        2 要交换的两个单元格的行列值
        3 输入要插入的行的数值
        4 输入要插入的列的数值
        5 输入要查询的单元格的坐标

        输出描述：
        输出按下列顺序输出：
        1 初始化表格是否成功，若成功则返回0， 否则返回-1
        2 输出交换单元格是否成功
        3 输出插入行是否成功
        4 输出插入列是否成功
        5 输出查询单元格数据是否成功*/

        /*while (scanner.hasNextLine()) {
            Integer[][] dataTable = new Integer[0][0];

            String[] split = scanner.nextLine().split(" ");
            Integer numRow = Integer.valueOf(split[0]);
            Integer numCol = Integer.valueOf(split[1]);
            if (isOverMaxBorder(9,9,numRow-1,numCol-1)){
                dataTable = new Integer[numRow][numCol];
            }

            String[] split1 = scanner.nextLine().split(" ");
            Integer x1 = Integer.valueOf(split1[0]) ;
            Integer y1 = Integer.valueOf(split1[1]) ;
            Integer x2 = Integer.valueOf(split1[2]) ;
            Integer y2 = Integer.valueOf(split1[3]) ;
            if (isOverMaxBorder(numRow,numCol,x1,y1,x2,y2)){
                Integer integer1 = dataTable[x1][y1];
                dataTable[x1][y1] = dataTable[x2][y2];
                dataTable[x2][y2] = integer1;
            }

            Integer addRow = Integer.valueOf(scanner.nextLine());
            if (isOverMaxBorder(9,numRow,addRow)){
                dataTable = new Integer[numRow + 1][numCol];
            }
            dataTable = new Integer[numRow][numCol];

            Integer addCol = Integer.valueOf(scanner.nextLine());
            if (isOverMaxBorder(9,numCol,addCol)){
                dataTable = new Integer[numRow][numCol + 1];
            }
            dataTable = new Integer[numRow][numCol];

            String[] split2 = new String[0];
            try{
                String s = scanner.nextLine();
                split2 = s.split(" ");
            }catch (Exception e){
                System.out.println();
            }
            Integer searchRow = Integer.valueOf(split2[0]);
            Integer searchCol = Integer.valueOf(split2[1]);
            isOverMaxBorder(numRow,numCol,searchRow,searchCol);
        }*/

        /*描述
        题目标题：
        将两个整型数组按照升序合并，并且过滤掉重复数组元素。
        输出时相邻两数之间没有空格。
        输入描述：
        输入说明，按下列顺序输入：
        1 输入第一个数组的个数
        2 输入第一个数组的数值
        3 输入第二个数组的个数
        4 输入第二个数组的数值
        输出描述：
        输出合并之后的数组*/

        /*int numFirst = Integer.valueOf(scanner.nextLine());
        List<String> firstList = Arrays.asList((scanner.nextLine()).split(" "));
        int numSecond = Integer.valueOf(scanner.nextLine());
        List<String> secondList = Arrays.asList((scanner.nextLine()).split(" "));

        TreeSet<Integer> resultSet = new TreeSet<>();
        for (String str:firstList) {
            resultSet.add(Integer.valueOf(str));
        }
        for (String str:secondList) {
            resultSet.add(Integer.valueOf(str));
        }
        for (Integer i:resultSet) {
            System.out.print(i);
        }*/

    }
}
