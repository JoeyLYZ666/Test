package org.example.backpack;

import org.example.object.Item;
import org.example.object.Records;

import java.util.*;

public class BackpackImpl implements Backpack {
    @Override
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
        List<Item> items = getItems(weights, values);
        List<Object[]> list = new ArrayList<>();
        for (Item item : items) {
            list.add(new Object[]{item, 0});
        }
        Records records = new Records();
        dyunamicProg(list, capacity, 0, records, 0);
//        return greedy(items, capacity);
        return records.getMax_value();
    }

    public List<Item> getItems(List<Integer> weights, List<Integer> values) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weights.size(); i++) {
            double itemDensity = (double) values.get(i) / weights.get(i);
            items.add(new Item(weights.get(i), values.get(i), itemDensity));
        }
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int) (o2.getItemDensity() - o1.getItemDensity());
            }
        });
        return items;
    }

    public int greedy(List<Item> items, int capacity) {
        int max_value = 0;
        for (Item item : items) {
            if (item.getWeight() <= capacity) {
                max_value += item.getValue();
                capacity -= item.getWeight();
            }
        }
        return max_value;
    }

    public void dyunamicProg(List<Object[]> list, int capacity, int currentValue, Records records, int index) {
        // index和currentValue从0开始
        if (index >= list.size() || getCurrentMaxValue(list, index) < records.getMax_value())
            // 访问完成或者剪枝
            return;
        Item currentItem = (Item) list.get(index)[0];
        if (currentItem.getWeight() <= capacity) {
            // 可以放入
            // 1.不放入
            // list不变（仍然0），capacity不变，currentValue不变，records不变，index+1
            index++;
            dyunamicProg(list, capacity, currentValue, records, index);
            index--;
            // 2.放入
            capacity -= currentItem.getWeight();//capacity
            list.set(index, new Object[]{currentItem, 1});//list修改
            currentValue += currentItem.getValue();//currentValue
            List<Item> path = records.getPath();
            path.add(currentItem);//records
            index++;//index
            if (currentValue > records.getMax_value())
                records.setMax_value(currentValue);
            dyunamicProg(list, capacity, currentValue, records, index);
            // 退回的方向和添加的方向要相反
            index--;//index
            path.remove(currentItem);//records
            currentValue -= currentItem.getValue();//currentValue
            list.set(index, new Object[]{currentItem, 0});//list修改
            capacity += currentItem.getWeight();//capacity
        } else {
            // 不能放进去
            index++;
            dyunamicProg(list, capacity, currentValue, records, index);
        }
    }

    public int getCurrentMaxValue(List<Object[]> list, int index) {
        // 获取当前选择情况下最多能得到的value
        int currentMaxValue = 0;
        for (int i = 0; i < list.size(); i++) {
            Item item = (Item) list.get(i)[0];
            if (i < index) {
                int choice = (int) list.get(i)[1];
                currentMaxValue += choice * item.getValue();
            } else {
                currentMaxValue += item.getValue();
            }
        }
        return currentMaxValue;
    }

}
