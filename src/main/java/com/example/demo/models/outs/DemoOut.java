package com.example.demo.models.outs;

import java.time.LocalDateTime;

public class DemoOut {
    private int caId;
    private int diId;
    private String title;
    private String nameCategory;
    private boolean favorite;
    private LocalDateTime createAt;

    public DemoOut() {
    }

    public DemoOut(int caId, int diId, String title, String nameCategory, boolean favorite, LocalDateTime createAt) {
        this.caId = caId;
        this.diId = diId;
        this.title = title;
        this.nameCategory = nameCategory;
        this.favorite = favorite;
        this.createAt = createAt;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getDiId() {
        return diId;
    }

    public void setDiId(int diId) {
        this.diId = diId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
