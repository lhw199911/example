package com.example;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/13/15:36
 * @Description:
 */
public class Main03 {

    private static void bubbleSort(List<String> list) {
        for (int ii = 0; ii < list.size(); ii++) {
            for (int jj = 1; jj < list.size() - ii; jj++) {
                String s = list.get(jj - 1);
                String s1 = list.get(jj);
                if (s.compareTo(s1) > 0) {
                    list.set(jj - 1, s1);
                    list.set(jj, s);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*描述
        按照指定规则对输入的字符串进行处理。
        详细描述：
        第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
        第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
        第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
        转换规则如下：
        对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
        如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
        如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
        如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
        根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
        数据范围：输入的字符串长度满足 1≤n≤100
        输入描述：
        样例输入两个字符串，用空格隔开。
        输出描述：
        输出转化后的结果。
        // Eqr v9oEb12U2ur4xu7rd931G1f50qDo
        */

        while (scanner.hasNext()) {
            String[] split = (scanner.next() + scanner.next()).split("");

            ArrayList<String> oddNumArr = new ArrayList<>();
            ArrayList<String> evenNumArr = new ArrayList<>();

            boolean isOdd = true;
            for (int i = 0; i < split.length; i++) {
                if (isOdd) {
                    evenNumArr.add(split[i]);
                } else {
                    oddNumArr.add(split[i]);
                }
                isOdd = !isOdd;
            }

            bubbleSort(oddNumArr);
            bubbleSort(evenNumArr);

            isOdd = false;
            for (int i = 0; i < split.length; i++) {
                if (isOdd) {
                    split[i] = oddNumArr.get(i / 2);
                } else {
                    split[i] = evenNumArr.get(i / 2);
                }
                isOdd = !isOdd;
            }

            for (int z = 0; z < split.length; z++) {
                String s = split[z];

                if (s.compareToIgnoreCase("f") > 0) {
                    System.out.print(split[z]);
                    continue;
                }

                int i = 0;
                if (s.getBytes(StandardCharsets.UTF_8)[0] > 57) {
                    i = 10 + s.toUpperCase().getBytes(StandardCharsets.UTF_8)[0] - 65;
                } else {
                    i = Integer.valueOf(s);
                }
                List<String> list = Arrays.asList(Integer.toBinaryString(i).split(""));

                Integer lenOfBinary = 4;
                String[] strArrs = new String[lenOfBinary];

                for (int ii=0;ii<strArrs.length;ii++){
                    int i1 = list.size() - 1 - ii;
                    if (i1 >= 0){
                        String s1 = list.get(i1);
                        strArrs[lenOfBinary - 1 - ii] = s1;
                    }else {
                        strArrs[lenOfBinary - 1 - ii] = "0";
                    }
                }
                list = Arrays.asList(strArrs);

                Collections.reverse(list);
                Integer j = 0;
                for (int ii = 0; ii < list.size(); ii++) {
                    Integer integer = Integer.valueOf(list.get(list.size() - 1 - ii));

                    j += integer * (int) (Math.pow(2, ii));
                }
                String upperCase;
                if (j > 9) {
                    upperCase = String.valueOf((char) (65 + j - 10)).toUpperCase();
                } else {
                    upperCase = j.toString();
                }
                split[z] = upperCase;
                System.out.print(upperCase);
            }
            System.out.println();
        }

       /* 描述
        对输入的字符串进行加解密，并输出。
        加密方法为：
        当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
        当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
        其他字符不做变化。
        解密方法为加密的逆过程。
        数据范围：输入的两个字符串长度满足 1≤n≤1000 保证输入的字符串都是只由大小写字母或者数字组成
        输入描述：
        第一行输入一串要加密的密码
        第二行输入一串加过密的密码
        输出描述：
        第一行输出加密后的字符
        第二行输出解密后的字符*/

        /*System.out.println(Character.toChars(48));
        System.out.println(Integer.valueOf('9'));
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('Z'));
        byte[] bytes = scanner.nextLine().getBytes();
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            Integer integer = Integer.valueOf(b);
            if (integer <= 57) {
                chars.add(Character.toChars(48 + (integer - 48 + 1) % 10)[0]);
            } else if (integer >= 97) {
                String upperCase = Character.toString((char) (97 + (integer - 97 + 1) % 26)).toUpperCase();
                chars.add(upperCase.toCharArray()[0]);
            } else {
                String lowerCase = Character.toString((char) (65 + (integer - 65 + 1) % 26)).toLowerCase();
                chars.add(lowerCase.toCharArray()[0]);
            }
        }
        for (Character c : chars) {
            System.out.print(c);
        }
        System.out.println();
        bytes = scanner.nextLine().getBytes();
        chars.clear();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            Integer integer = Integer.valueOf(b);
            if (integer <= 57) {
                chars.add(Character.toChars(48 + (integer - 48 - 1 + 10) % 10)[0]);
            } else if (integer >= 97) {
                int i1 = (integer - 97 - 1) % 36;
                String upperCase = Character.toString((char)(97 + (integer - 97 - 1 + 26) % 26) ).toUpperCase();
                chars.add(upperCase.toCharArray()[0]);
            } else {
                String lowerCase = Character.toString((char)(65 + (integer - 65 - 1 + 26) % 26)).toLowerCase();
                chars.add(lowerCase.toCharArray()[0]);
            }
        }
        for (Character c : chars) {
            System.out.print(c);
        }*/

        /*描述
        编写一个程序，将输入字符串中的字符按如下规则排序。
        规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
        如，输入： Type 输出： epTy
        规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
        如，输入： BabA 输出： aABb
        规则 3 ：非英文字母的其它字符保持原来的位置。
        如，输入： By?e 输出： Be?y
        数据范围：输入的字符串长度满足 1≤n≤1000
        输入描述：
        输入字符串
        输出描述：
        输出字符串*/

        /* String[] strs = scanner.nextLine().split("");
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        LinkedList<String> strings = new LinkedList<>();
        for (int i=0;i<strs.length;i++) {
            String str = strs[i];
            if (str.compareToIgnoreCase("A") >=0 && str.compareToIgnoreCase("Z") <=0 ){
                strings.add(str);
            }else {
                integerStringHashMap.put(i, str);
            }
        }
        for(int i=0;i<strings.size();i++){
            for (int j=1;j<strings.size()-i;j++){
                String s = strings.get(j-1);
                String s1 = strings.get(j);
                if(s.compareToIgnoreCase(s1)>0){
                    strings.set(j-1, s1);
                    strings.set(j, s);
                }
            }
        }
        for (int i =0; i<strs.length;i++){
            String s = integerStringHashMap.get(i);
            System.out.print(s != null?s:strings.pollFirst());
        }*/

        /*描述
        实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。

        数据范围：输入的字符串长度满足 1≤n≤20  ，保证输入的字符串中仅出现小写字母
        输入描述：
        字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

        输出描述：
        删除字符串中出现次数最少的字符后的字符串。*/

        /*String s2 = scanner.nextLine();
        char[] charArray = s2.toCharArray();
        HashSet<Character> chars = new HashSet<>();
        int minN = s2.length();
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            char s = charArray[i];
            boolean add = chars.add(s);
            if (add) {
                int intTemp = 1;
                for (int j = i + 1; j < charArray.length; j++) {
                    char s1 = charArray[j];
                    intTemp += s == s1 ? 1 : 0;
                }
                if (minN > intTemp) {
                    characters.clear();
                    characters.add(s);
                    minN = intTemp;
                }else if(minN == intTemp) {
                    characters.add(s);
                    minN = intTemp;
                }
            }
        }
        for (Character s : characters
        ) {
            s2 = s2.replace(s.toString(), "");
        }
        System.out.println(s2);*/

       /* 描述
        给定 n 个字符串，请对 n 个字符串按照字典序排列。
        数据范围： 1 ≤ n ≤ 1000 1≤n≤1000  ，字符串长度满足 1≤len≤100
        输入描述：
        输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
        输出描述：
        数据输出n行，输出结果为按照字典序排列的字符串。*/

       /*ArrayList<String> strings = new ArrayList<>();
        Integer integer = Integer.valueOf(scanner.nextLine());
        while(integer > 0){
            strings.add(scanner.nextLine());
            integer--;
        }
        Collections.sort(strings);
        for (String s:strings
             ) {
            System.out.println(s);
        }*/

        /*描述
        接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

        输入描述：
        输入一行，为一个只包含小写字母的字符串。

        输出描述：
        输出该字符串反转后的字符串。*/

        /*String[] split = scanner.nextLine().split("");
        List<String> list = Arrays.asList(split);
        Collections.reverse(list);
        for (String str:list
             ) {
            System.out.print(str);
        }*/

    }
}
