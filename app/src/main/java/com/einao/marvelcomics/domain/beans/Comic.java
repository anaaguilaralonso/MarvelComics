package com.einao.marvelcomics.domain.beans;

/**

 */

public class Comic {

    private String title;

    public Comic(String title) {
        this.title = title;
    }

    public Comic() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
