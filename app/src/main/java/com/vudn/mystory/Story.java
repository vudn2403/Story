package com.vudn.mystory;

import java.io.Serializable;

/**
 * Created by admin on 25/11/2017.
 */

public class Story{
    private int resImg;
    private String name;
    private String author;
    private String category;
    private String status;
    private String numberOfChapter;
    private String timeHadUpload;
    private String timeUpdate;
    private String detailContent;

    public Story(int resImg, String name, String author, String category, String status,
                 String numberOfChapter, String timeHadUpload, String timeUpdate,
                 String detailContent) {
        this.resImg = resImg;
        this.name = name;
        this.author = author;
        this.category = category;
        this.status = status;
        this.numberOfChapter = numberOfChapter;
        this.timeHadUpload = timeHadUpload;
        this.timeUpdate = timeUpdate;
        this.detailContent = detailContent;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberOfChapter() {
        return numberOfChapter;
    }

    public void setNumberOfChapter(String numberOfChapter) {
        this.numberOfChapter = numberOfChapter;
    }

    public String getTimeHadUpload() {
        return timeHadUpload;
    }

    public void setTimeHadUpload(String timeHadUpload) {
        this.timeHadUpload = timeHadUpload;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }
}
