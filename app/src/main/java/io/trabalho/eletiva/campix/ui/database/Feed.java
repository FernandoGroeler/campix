package io.trabalho.eletiva.campix.ui.database;

public class Feed {
    private int id;
    private byte[] image;
    private int likesCount;

    public Feed(byte[] image, int likesCount) {
        this.image = image;
        this.likesCount = likesCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
}
