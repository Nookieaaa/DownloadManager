package com.nookdev.downloadmanager.service.manager;


import com.nookdev.downloadmanager.database.models.Task;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class DownloadManager {
    LinkedBlockingQueue<Task> workQueue = new LinkedBlockingQueue<Task>();
    ThreadPoolExecutor executor;


    public static final int DEFAULT_POOL_SIZE = 1;
    public static final int DEFAULT_MAX_POOL_SIZE = 1;
    public static final long DEFAULT_KEEP_ALIVE_TIME = 1000;

    private static DownloadManager instance = new DownloadManager();

    private DownloadManager(){
        //executor = new ThreadPoolExecutor(DEFAULT_POOL_SIZE,DEFAULT_MAX_POOL_SIZE,DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue);
        workQueue = new LinkedBlockingQueue<Task>();
    }

    public static DownloadManager getInstance() {
        return instance;
    }

    public void start(){
        while (workQueue.size()>0){
            try {
                Task task = workQueue.take();
                Thread downloadThread = new Thread(new Consumer(task));
                downloadThread.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void enqueue(Task task){
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
