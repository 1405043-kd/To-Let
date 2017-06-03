package com.example.user.tolet;

/**
 * Created by USER on 5/29/2017.
 */

public class TaskItem {
    String tsk;
    String csu;
    public TaskItem(String Task,String Cause) {
        tsk=Task;
        csu=Cause;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "tsk='" + tsk + '\'' +
                ", csu='" + csu + '\'' +
                '}';
    }
}
