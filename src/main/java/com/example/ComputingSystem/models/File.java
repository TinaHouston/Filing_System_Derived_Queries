package com.example.ComputingSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "file_type")
    private FileType fileType;

    @Column(name = "size")
    private int size;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    public File(String name, FileType fileType, int size, Folder folder) {
        this.name = name;
        this.fileType = fileType;
        this.size = size;
        this.folder = folder;
    }

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
