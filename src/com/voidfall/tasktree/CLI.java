package com.voidfall.tasktree;

import java.util.Iterator;
import java.util.Scanner;

/**
 * CLI
 */
public class CLI implements Runnable {
    private boolean running;
    private Scanner userInput = new Scanner(System.in);
    private Task root;

    public static void main(String[] args) {
        new CLI().run();
    }

    @Override
    public void run() {
        dummy();
        this.running = true;
        while (running) {
            System.out.print("\n> ");
            String input = userInput.nextLine();
            switch (input) {
                case "show":
                    printTask(root);
                    break;

                case "quit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }

    private void dummy() {
        root = new Task("TaskTree\nWelcome to TaskTree!");
        root.addSubTask(new Task("Chores"));
        root.addSubTask(new Task("Shopping"));
        root.addSubTask(new Task("Ideas"));
    }

    private void printTask(Task task) {
        System.out.println(task.getText() + "\n");
        Iterator<Task> subTaskIterator = task.getSubTaskIterator();
        while (subTaskIterator.hasNext()) {
            Task subTask = subTaskIterator.next();
            System.out.println("¤ " + subTask.getFirstLine());
        }
    }
}