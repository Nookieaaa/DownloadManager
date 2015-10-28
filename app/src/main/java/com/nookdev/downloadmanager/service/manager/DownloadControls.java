package com.nookdev.downloadmanager.service.manager;


public interface DownloadControls {
    public boolean start();
    public boolean resume();
    public boolean pause();
    public boolean delete();
}
