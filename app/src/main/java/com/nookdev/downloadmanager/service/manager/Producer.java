package com.nookdev.downloadmanager.service.manager;

import com.nookdev.downloadmanager.database.models.Task;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable,QueueControls{

    LinkedBlockingQueue queue;
    private boolean running = false;
    List<Task> tasks = new LinkedList<Task>();

    public Producer(LinkedBlockingQueue queue, List<Task> tasks) {
        this.queue = queue;
        this.running = false;
        this.tasks.clear();
        this.tasks.addAll(tasks);

    }

    public void add(Task task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(Task task){
        queue.remove(task);
    }

    @Override
    public void addAll(List<Task> tasks) {
        queue.addAll(tasks);
    }

    @Override
    public void clear() {
        queue.clear();
    }

    public LinkedBlockingQueue getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        setRunning(true);

        for (Task task:tasks){
            try {
                queue.put(task);
                tasks.remove(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
