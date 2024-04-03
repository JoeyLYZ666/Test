package org.example.bubble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSortUltimate {
    public List<Integer> bubbleSort(List<Integer> list) {
        if(list == null || list.size() < 2)
            return list;
        List<Integer> result = new ArrayList(list);
        int flag = 1;
        do{
            flag = 1;
            for(int i = 0 ; i < result.size() - 1 ; i++){
                if(result.get(i) > result.get(i+1)){// 顺序错误
                    Collections.swap(result , i , i+1);
                    flag = 0;
                }
            }
        }while(flag != 1);
        return result;
    }
}
