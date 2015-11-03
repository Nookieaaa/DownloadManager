package com.nookdev.downloadmanager.service.manager;


import com.nookdev.downloadmanager.database.models.Task;

import java.util.List;

public interface QueueControls {
    public void add(Task task);
    public void remove(Task task);
    public void addAll(List<Task> tasks);
    public void clear();
}
