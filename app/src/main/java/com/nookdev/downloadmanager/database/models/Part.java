package com.nookdev.downloadmanager.database.models;


public class Part {
    private int id;
    private int task_id;
    private int start_byte;
    private int end_byte;
    private int part_size;
    private String source;
    private String output;
    private int status;

    public Part(int id, int task_id, int start_byte, int end_byte, int part_size, String source, String output, int status) {
        this.id = id;
        this.task_id = task_id;
        this.start_byte = start_byte;
        this.end_byte = end_byte;
        this.part_size = part_size;
        this.source = source;
        this.output = output;
        this.status = status;
    }
}
