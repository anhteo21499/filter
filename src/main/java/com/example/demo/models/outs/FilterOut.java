package com.example.demo.models.outs;

import java.time.LocalDateTime;

public class FilterOut {
    private String categoryName;
    private String title;
    private boolean favorite;
    private LocalDateTime createAt;

    public FilterOut() {
    }

    public FilterOut(String categoryName, String title, boolean favorite, LocalDateTime createAt) {
        this.categoryName = categoryName;
        this.title = title;
        this.favorite = favorite;
        this.createAt = createAt;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
