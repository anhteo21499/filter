package com.example.demo.models.ins;

import java.time.LocalDateTime;

public class FilterIn {
    private String categoryNameOne;
    private String categoryNameTwo;
    private String title;
    private boolean favorite;
    private LocalDateTime toDateTime;
    private LocalDateTime fromDateTime;

    public FilterIn() {
    }

    public FilterIn(String categoryNameOne, String getCategoryNameTwo) {
        this.categoryNameOne = categoryNameOne;
        this.categoryNameTwo = getCategoryNameTwo;
    }

    public FilterIn(String title, boolean favorite, LocalDateTime toDateTime, LocalDateTime fromDateTime) {
        this.title = title;
        this.favorite = favorite;
        this.toDateTime = toDateTime;
        this.fromDateTime = fromDateTime;
    }

    public FilterIn(String categoryNameOne, String categoryNameTwo, String title, boolean favorite, LocalDateTime toDateTime, LocalDateTime fromDateTime) {
        this.categoryNameOne = categoryNameOne;
        this.categoryNameTwo = categoryNameTwo;
        this.title = title;
        this.favorite = favorite;
        this.toDateTime = toDateTime;
        this.fromDateTime = fromDateTime;
    }

    public String getCategoryNameOne() {
        return categoryNameOne;
    }

    public void setCategoryNameOne(String categoryNameOne) {
        this.categoryNameOne = categoryNameOne;
    }

    public String getCategoryNameTwo() {
        return categoryNameTwo;
    }

    public void setCategoryNameTwo(String categoryNameTwo) {
        this.categoryNameTwo = categoryNameTwo;
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

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }
}
