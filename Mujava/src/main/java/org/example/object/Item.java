package org.example.object;

public class Item {
    private int weight;
    private int value;
    private double itemDensity;

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                ", itemDensity=" + itemDensity +
                '}';
    }


    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double getItemDensity() {
        return itemDensity;
    }

    public Item(int weight , int value , double itemDensity){
        this.itemDensity = itemDensity;
        this.value = value;
        this.weight = weight;
    }
}
