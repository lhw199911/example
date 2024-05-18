package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/04/16/20:01
 * @Description:
 */
public class Main05 {

    /* HuaWei HJ16 购物单 */
    private static Integer maxOrder = 0;
    private static List<Integer> contains = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int feeCost = scanner.nextInt();
        int numCost = scanner.nextInt();

        Good[][] goods = new Good[numCost + 1][4];
        int[] maxCosts = new int[feeCost / 10 + 1];
        Good good;

        for (int i = 1; i <= numCost; i++) {
            good = new Good();
            good.v = scanner.nextInt() / 10;
            good.vp = good.v * scanner.nextInt();
            int masterIndex = scanner.nextInt();

            if (masterIndex == 0) {
                goods[i][0] = good;
            } else if (goods[masterIndex][1] == null) {
                goods[masterIndex][1] = good;
            } else {
                goods[masterIndex][2] = good;
            }
        }

        for (int i = 1; i <= numCost; i++) {
            int maxCost = maxCosts[feeCost / 10];
            for (int j = feeCost / 10; j >= 0 && goods[i][0] != null; j--) {
                Good goodMaster = goods[i][0];
                int max = maxCosts[j];
                int vt;
                if (j >= goodMaster.v && max < maxCosts[j - goodMaster.v] + goodMaster.vp) {
                    max = maxCosts[j - goodMaster.v] + goodMaster.vp;
                }
                if (goods[i][1] != null) {
                    vt = goodMaster.v + goods[i][1].v;
                    if (j >= vt
                            && max < maxCosts[j - vt] + goodMaster.vp + goods[i][1].vp) {
                        max = maxCosts[j - vt] + goodMaster.vp + goods[i][1].vp;
                    }
                }
                if (goods[i][2] != null) {
                    vt = goodMaster.v + goods[i][2].v;
                    if (j >= vt
                            && max < maxCosts[j - vt] + goodMaster.vp + goods[i][2].vp) {
                        max = maxCosts[j - vt] + goodMaster.vp + goods[i][2].vp;
                    }
                    vt = goodMaster.v + goods[i][1].v + goods[i][2].v;
                    if (j >= vt
                            && max < maxCosts[j - vt] + goodMaster.vp + goods[i][1].vp + goods[i][2].vp) {
                        max = maxCosts[j - vt] + goodMaster.vp + goods[i][1].vp + goods[i][2].vp;
                    }
                }
                maxCosts[j] = max;
            }
        }
        System.out.println(maxCosts[feeCost / 10] * 10);

    }

}

class Good {
    public int v;
    public int vp;
    public Good(int v, int vp) {
        this.v = v;
        this.vp = vp;
    }

    public Good() {
    }
}