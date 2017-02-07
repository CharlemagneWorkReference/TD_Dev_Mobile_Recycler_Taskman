package com.linkpulsion.taskman;

import android.support.annotation.NonNull;

public class TodoItem {
    private String label;

    public Tags getCurentTag() {
        return curentTag;
    }

    public void setCurentTag(Tags curentTag) {
        this.curentTag = curentTag;
    }

    public static enum Tags {
        Faible,
        Normal,
        Important
    }
    private Tags curentTag;
    private boolean done = false;

    public TodoItem(Tags tag, @NonNull String label){
        this.label = label;
        this.curentTag = tag;

    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
