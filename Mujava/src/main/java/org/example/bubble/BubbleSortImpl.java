package org.example.bubble;

import java.util.Collections;
import java.util.List;

public class BubbleSortImpl implements BubbleSort{
    @Override
    public void bubbleSort(List<Integer> list) {
        if(list == null || list.size() < 2)
            return;
        int flag = 1;
        do{
            flag = 1;
            for(int i = 0 ; i < list.size() - 1 ; i++){
                if(list.get(i) > list.get(i+1)){// 顺序错误
                    Collections.swap(list , i , i+1);
                    flag = 0;
                }
            }
        }while(flag != 1);
        return;
    }
}
