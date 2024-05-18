package com.example;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/23/18:47
 * @Description:
 */
public class Main07 {
    public static void main(String[] args) {
        /*char[] chars = {'A', 'A', 'A', 'B', 'B', 'B','C','C','C','D','D','E'};
        Solution solution = new Solution();
        int i = solution.leastInterval(chars, 2);
        System.out.println(i);*/

        int[][] points = {{1,2},{4,5},{1,5}};
        Solution solution = new Solution();
        int minArrowShots = solution.findMinArrowShots(points);
        System.out.println(minArrowShots);

    }

}


class Solution {
    /*给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表，用字母 A 到 Z 表示，以及一个冷却时间 n。每个周期或时间间隔允许完成一项任务。任务可以按任何顺序完成，但有一个限制：两个 相同种类 的任务之间必须有长度为 n 的冷却时间。

返回完成所有任务所需要的 最短时间间隔 。



示例 1：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
示例 3：

输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A*/
    public int leastInterval(char[] tasks, int n) {

        Vector<Character> charResult = new Vector<>();

        int maxlen = 0; // 同类任务最大个数
        int maxNum = 0; // 最大个数任务的个数

        LinkedHashMap<Character, Integer> taskMap = new LinkedHashMap<>();
        Character[] chars = new Character[1];
        Set<Character> characters = taskMap.keySet();
        for (char c : tasks) {
            if (characters.contains(c)) {
                taskMap.put(c, taskMap.get(c) + 1);
                maxlen = Math.max(maxlen, taskMap.get(c));
            } else {
                taskMap.put(c, 1);
            }
        }

        Collection<Integer> values = taskMap.values();

        for (Integer i : values) {
            if (maxlen == i) {
                maxNum++;
            }
        }

        int i1 = (maxlen - 1) * (n + 1) + maxNum;

        return Math.max(tasks.length, i1);

        /*Vector<Map.Entry<Character, Integer>> entries = new Vector<>(taskMap.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        Collections.reverse(entries);
        taskMap.clear();
        for (Map.Entry<Character, Integer> m : entries) {
            taskMap.put(m.getKey(), m.getValue());
        }

        while (!taskMap.isEmpty()) {

            List<Character> list = Arrays.asList(characters.toArray(chars));

            for (int i = 0; i < list.size(); i++) {
                Character c = list.get(i);
                Integer integer = taskMap.get(c);
                if (charResult.subList(Math.max(charResult.size() - n, 0), charResult.size()).contains(c)) {
                    if (i < list.size() - 1) {
                        continue;
                    } else {
                        charResult.add('@');
                        break;
                    }
                }
                charResult.add(c);
                taskMap.put(c, taskMap.get(c) - 1);
                if (taskMap.get(c) == 0) {
                    taskMap.remove(c);
                }else {
                    for (int j = i + 1; j<list.size();j++){
                        char character = list.get(j - 1);
                        char character1 = list.get(j);
                        Integer integer1 = taskMap.get(character);
                        Integer integer2 = taskMap.get(character1);
                        if (integer1 < integer2){
                            taskMap.remove(character);
                            taskMap.remove(character1);
                            taskMap.put(character1,integer2);
                            taskMap.put(character,integer1);
                        }else {
                            break;
                        }
                    }
                }
                break;
            }
        }
        return charResult.size();*/
    }

    /*如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
    例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
    相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
    子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
    给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
    示例 1：
    输入：nums = [1,7,4,9,2,5]
    输出：6
    解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
    示例 2：

    输入：nums = [1,17,5,10,13,15,10,5,16,8]
    输出：7
    解释：这个序列包含几个长度为 7 摆动序列。
    其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
    示例 3：

    输入：nums = [1,2,3,4,5,6,7,8,9]
    输出：2*/
    public int wiggleMaxLength(int[] nums) {
        int res = 0; // 结果
        int reserve = 0; // 记录上坡或下坡，1是上坡，2是下坡

        for (int i = 1; i < nums.length; i++) {
            int i1 = nums[i] - nums[i - 1];
            if (i1 > 0 && reserve != 1) {
                res++;
                reserve = 1;
            } else if (i1 < 0 && reserve != 2) {
                res++;
                reserve = 2;
            }
        }
        return res;
    }

    /*有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

    一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

    给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。

    示例 1：

    输入：points = [[10,16],[2,8],[1,6],[7,12]]
    输出：2
    解释：气球可以用2支箭来爆破:
            -在x = 6处射出箭，击破气球[2,8]和[1,6]。
            -在x = 11处发射箭，击破气球[10,16]和[7,12]。
    示例 2：

    输入：points = [[1,2],[3,4],[5,6],[7,8]]
    输出：4
    解释：每个气球需要射出一支箭，总共需要4支箭。
    示例 3：

    输入：points = [[1,2],[2,3],[3,4],[4,5]]
    输出：2
    解释：气球可以用2支箭来爆破:
            - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
            - 在x = 4处射出箭，击破气球[3,4]和[4,5]。*/
    public int findMinArrowShots(int[][] points) {
        int res = 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]){
                    return 1;
                }else if (o1[1] < o2[1]){
                    return -1;
                }
                if (o1[0] < o2[0]){
                    return -1;
                }
                return 0;
            }
        });

        if (points.length == 0){
            return 0;
        }
        Integer next = points[0][1];

        for (int i=1;i<points.length;i++){
            if (next<points[i][0]){
                next = points[i][1];
                res++;
            }
        }
        return ++res;


        /*int row = points.length;
        int res = 0;
        Vector<Integer> starts = new Vector<>();
        Vector<Integer> ends = new Vector<>();

        for (int i = 0; i < row; i++) {
            starts.add(points[i][0]);
            ends.add(points[i][1]);
        }

        Vector<Integer> preTemp = new Vector<>();
        int pre = 0; // 记录上一个位置射箭射中的数量
        int i = Collections.min(starts);
        int endIndex = ends.get(starts.indexOf(i));

        while (true) {
            int next = 0;
            Vector<Integer> nextTemp = new Vector<>();

            for (int j = 0; j < starts.size(); j++) {
                int start = starts.get(j);
                int end = ends.get(j);
                if (i >= start && i <= end) {
                    nextTemp.add(j);
                    next++;
                }
            }
            if (next < pre || i > endIndex) {
                Collections.reverse(preTemp);
                for (int ii : preTemp) {
                    starts.remove(ii);
                    ends.remove(ii);
                }

                res++;
                if (starts.isEmpty()){
                    return res;
                }
                preTemp.clear();
                i = Collections.min(starts);
                endIndex = ends.get(starts.indexOf(i));
                pre = 0;
                continue;
            }
            preTemp = new Vector<>(nextTemp);
            pre = next;
            i++;
        }*/
    }

}

/*你的任务是为一个很受欢迎的银行设计一款程序，以自动化执行所有传入的交易（转账，存款和取款）。银行共有 n 个账户，编号从 1 到 n 。每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。

请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：

指定的账户数量在 1 和 n 之间，且
取款或者转账需要的钱的总数 小于或者等于 账户余额。
实现 Bank 类：

Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。*/
class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (account1 < balance.length && account2 < balance.length && this.balance[account1] >= money) {
            this.balance[account1] -= money;
            this.balance[account2] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (account < balance.length) {
            this.balance[account] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (account < balance.length && money <= this.balance[account]) {
            this.balance[account] -= money;
            return true;
        }
        return false;
    }
}