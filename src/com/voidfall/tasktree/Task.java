package com.voidfall.tasktree;

import java.util.Iterator;
import java.util.Vector;

/**
 * Represents a task with a text and subtasks.
 */
public class Task {
    private String text;
    private Vector<Task> subTasks;

    /**
     * Creates a task with a given text.
     * @param text The text of the task
     */
    public Task(String text) {
        this.text = text;
        this.subTasks = new Vector<>();
    }

    /**
     * Returns the task text.
     * @return The task text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns an iterator over the task's subtasks.
     * @return An iterator over the task's subtasks
     */
    public Iterator<Task> getSubTaskIterator() {
        return subTasks.iterator();
    }

    /**
     * Add a subtask to the task.
     * @param subTask The subtask to add
     */
    public void addSubTask(Task subTask) {
        this.subTasks.add(subTask);
    }

    /**
     * Remove a subtask by index.
     * @param index The index of the subtask to remove
     */
    public void removeSubTask(int index) {
        this.subTasks.remove(index);
    }

    /**
     * Set the text of the task.
     * @param text The text to be set
     */
    public void setText(String text) {
        this.text = text;
    }
}