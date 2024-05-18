package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/26/18:54
 * @Description:
 */
public class Main08 {
    public static void main(String[] args) {
        Main08 main08 = new Main08();

//        List<String> list = main08.restoreIpAddresses("101023");

        System.out.println(main08.multiply("999", "999"));

    }

    /*有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

       例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
       给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

       示例 1：

       输入：s = "25525511135"
       输出：["255.255.11.135","255.255.111.35"]
       示例 2：

       输入：s = "0000"
       输出：["0.0.0.0"]
       示例 3：

       输入：s = "101023"
       输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

       提示：
       1 <= s.length <= 20
       s 仅由数字组成*/
    public List<String> restoreIpAddresses(String s) {
        Vector<String> strings = new Vector<>();

        if (s.length() < 4 || s.length() > 12) {
            return strings;
        }

        String[] strArr = new String[4];

        for (int i = 1; i < s.length() - 2; i++) {
            strArr[0] = s.substring(0, i);
            if ((strArr[0].length() > 1 && strArr[0].indexOf("0") == 0) || s.substring(i).length() < 3 || s.substring(i).length() > 9 || Integer.valueOf(strArr[0]) > 255) {
                continue;
            }
            for (int i1 = i + 1; i1 < s.length() - 1; i1++) {
                strArr[1] = s.substring(i, i1);
                if ((strArr[1].length() > 1 && strArr[1].indexOf("0") == 0) || s.substring(i1).length() < 2 || s.substring(i1).length() > 6 || Integer.valueOf(strArr[1]) > 255) {
                    continue;
                }
                for (int i2 = i1 + 1; i2 < s.length(); i2++) {
                    strArr[2] = s.substring(i1, i2);
                    strArr[3] = s.substring(i2);
                    if ((strArr[2].length() > 1 && strArr[2].indexOf("0") == 0) || (strArr[3].length() > 1 && strArr[3].indexOf("0") == 0) || strArr[3].length() < 1 || strArr[3].length() > 3 || Integer.valueOf(strArr[2]) > 255 || Integer.valueOf(strArr[3]) > 255) {
                        continue;
                    }
                    strings.add(strArr[0] + "." + strArr[1] + "." + strArr[2] + "." + strArr[3]);
                }
            }
        }
        return strings;
    }

    /*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

    注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。

    示例 1:

    输入: num1 = "2", num2 = "3"
    输出: "6"
    示例 2:

    输入: num1 = "123", num2 = "456"
    输出: "56088"

    提示：
            1 <= num1.length, num2.length <= 200
    num1 和 num2 只能由数字组成。
    num1 和 num2 都不包含任何前导零，除了数字0本身。*/
    public String multiply(String num1, String num2) {

        List<String> list = Arrays.asList(num1.split(""));
        List<String> list1 = Arrays.asList(num2.split(""));

        Collections.reverse(list);
        Collections.reverse(list1);

        String strTemp = "";

        for (int i = 0; i < list.size(); i++) {

            String strT = "";
            String s = list.get(i);

            for (int j = 0; j < list1.size(); j++) {
                String s1 = list1.get(j);
                String add = String.valueOf(Integer.valueOf(s)*Integer.valueOf(s1));
                for (int z = 1; z <= j; z++) {
                    add += "0";
                }
                strT = add(strT, add);
            }
            for (int z = 1; z <= i; z++) {
                strT += "0";
            }
            strTemp = add(strTemp, strT);
        }
        return strTemp;
    }

    private String add(String str, String str1) {

        StringBuilder stringBuilder = new StringBuilder();

        int length = str.length();
        int length1 = str1.length();

        int abs = Math.abs(length1 - length);

        String minStr = "";
        String maxStr = "";
        if (length > length1) {
            minStr = str1;
            maxStr = str;
        } else {
            minStr = str;
            maxStr = str1;
        }


        int sT = 0;

        int addOne = 0;
        for (int i = minStr.length() - 1; i >= 0; i--) {
            sT = (maxStr.charAt(i + abs) - '0') + ((minStr.charAt(i)) - '0') + addOne;
            if (sT > 9) {
                stringBuilder.append(String.valueOf(sT - 10));
                addOne = 1;
            } else {
                stringBuilder.append(String.valueOf(sT));
                addOne = 0;
            }
        }

        String strT = "1";
        for (int z = 0; z < minStr.length(); z++) {
            strT += "0";
        }

        String add = "";
        if (addOne == 1) {
            add = add(reserveStr(stringBuilder.toString()), strT);
        } else {
            add = stringBuilder.toString();

            add = reserveStr(add);

            String substring = maxStr.substring(0, abs);
            add =substring + add;
        }

        return add;
    }

    private String reserveStr(String str){
        List<String> list1 = Arrays.asList(str.split(""));
        Collections.reverse(list1);
        return list1.toString().replace("[", "").replace("]", "").replace(", ", "");
    }

}