package com.voidfall.tasktree;

import java.util.Iterator;
import java.util.Vector;

/**
 * Task
 */
public class Task {
    private String text;
    private Vector<Task> subTasks;

    public Task(String text) {
        this.text = text;
        this.subTasks = new Vector<>();
    }

    public Task() {
        this.text = null;
        this.subTasks = new Vector<>();
    }

    public String getText() {
        return text;
    }

    public String getFirstLine() {
        String firstLine = null;
        if (text != null)
            firstLine = text.split("\\n", 1)[0];
        return firstLine;
    }

    public Iterator<Task> getSubTaskIterator() {
        return subTasks.iterator();
    }

    public void addSubTask(Task task) {
        this.subTasks.add(task);
    }

    public void setText(String text) {
        this.text = text;
    }
}