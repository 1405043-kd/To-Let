package com.example.user.tolet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by USER on 6/1/2017.
 */

public class AD implements Serializable{
    public final ArrayList<TaskItem> items;
    public AD() {
        items=new ArrayList<>();
    }
}
