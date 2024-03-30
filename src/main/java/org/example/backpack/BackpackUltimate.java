package org.example.backpack;

import java.util.List;

public class BackpackUltimate {

    public int backpack(List<Integer> weights, List<Integer> values, int capacity) {
        if (weights == null || values == null || weights.size() != values.size())
            return 0;
        for(Integer weight: weights){
            if(weight <= 0)
                return 0;
        }
        for(Integer value: values)
            if(value <= 0)
                return 0;
        if (capacity == 0)
            return 0;
        int c[][] = new int[weights.size() + 1][capacity + 1];
        for (int i = 0; i < weights.size() + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < capacity + 1; j++) {
            c[0][j] = 0;
        }
        int max = 0;
        for (int i = 1; i < weights.size() + 1; i++) {// 物品从1到n
            for (int j = 1; j < capacity + 1; j++) {//重量从1到capacity
                if (weights.get(i - 1) <= j) {//重量小
                    if (c[i - 1][j] < (c[i - 1][j - weights.get(i - 1)] + values.get(i - 1))) {
                        c[i][j] = c[i - 1][j - weights.get(i - 1)] + values.get(i - 1);
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
                if (c[i][j] > max)
                    max = c[i][j];
            }
        }
        return max;
    }
}
