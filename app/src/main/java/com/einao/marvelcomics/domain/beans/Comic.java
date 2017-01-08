package com.einao.marvelcomics.domain.beans;


public class Comic {

    private Integer id;
    private String title;
    private String description;
    private String imageUrl;

    public Comic(ComicBuilder comicBuilder){
        id = comicBuilder.id;
        title = comicBuilder.title;
        description = comicBuilder.description;
        imageUrl = comicBuilder.imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comic comic = (Comic) o;

        if (id != null ? !id.equals(comic.id) : comic.id != null) return false;
        if (title != null ? !title.equals(comic.title) : comic.title != null) return false;
        if (description != null ? !description.equals(comic.description) : comic.description != null) return false;
        return imageUrl != null ? imageUrl.equals(comic.imageUrl) : comic.imageUrl == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }

    public static class ComicBuilder {

        private Integer id;
        private String title;
        private String description;
        private String imageUrl;

        public ComicBuilder setId(Integer id){
            this.id = id;
            return this;
        }

        public ComicBuilder setTitle(String title){
            this.title = title;
            return this;
        }

        public ComicBuilder setDescription(String description){
            this.description = description;
            return this;
        }

        public ComicBuilder setImageUrl(String imageUrl){
            this.imageUrl = imageUrl;
            return this;
        }

        public Comic build(){
            return new Comic(this);
        }


    }


}
