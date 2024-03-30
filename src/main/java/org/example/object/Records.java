package org.example.object;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private List<Item> path;
    private int max_value;

    public void setMax_value(int max_value) {
        this.max_value = max_value;
    }

    public List<Item> getPath() {
        return path;
    }

    public int getMax_value() {
        return max_value;
    }

    public Records(){
        path = new ArrayList<>();
        max_value = 0;
    }

}
