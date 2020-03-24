package com.voidfall.tasktree;

import java.util.Iterator;
import java.util.Scanner;

/**
 * CLI
 */
public class CLI implements Runnable {
    private boolean running;
    private Scanner userInput = new Scanner(System.in);
    private final Task root = new Task("TaskTree\nType \"/h\" for help.");
    private Task current = root;

    public static void main(String[] args) {
        new CLI().run();
    }

    @Override
    public void run() {
        this.running = true;
        while (running) {
            printCurrentTask();
            System.out.print("> ");
            String input = userInput.nextLine();
            switch (input) {
                case "root": {
                    current = root;
                    break;
                }

                case "sub": {
                    Task task = new Task("New task");
                    current.addSubTask(task);
                    current = task;
                    break;
                }

                case "quit": {
                    running = false;
                    break;
                }

                case "z": {
                    String text = current.getText();
                    int lastNewLine = text.lastIndexOf("\n");
                    if (lastNewLine == -1) {
                        current.setText("");
                    } else {
                        current.setText(text.substring(0, lastNewLine));
                    }
                    break;
                }

                default: {
                    String text = current.getText();
                    if (text.length() > 0) {
                        text += "\n" + input;
                    } else {
                        text += input;
                    }
                    current.setText(text);
                    break;
                }

            }
        }
    }

    private void printCurrentTask() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("---------------------------------");
        System.out.println(current.getText());
        Iterator<Task> subTaskIterator = current.getSubTaskIterator();
        while (subTaskIterator.hasNext()) {
            Task subTask = subTaskIterator.next();
            System.out.println("* " + subTask.getText());
        }
    }
}