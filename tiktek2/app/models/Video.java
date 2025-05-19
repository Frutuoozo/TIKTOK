package models;

import java.util.ArrayList;
import java.util.List;

public class Video {
    private String id;
    private String title;
    private User owner;
    private List<String> likes;
    private List<String> comments;

    public Video(String id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public User getOwner() { return owner; }

    public void addLike(String userName) {
        likes.add(userName);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public List<String> getLikes() { return likes; }
    public List<String> getComments() { return comments; }

    // Amanda

    private List<User> shares = new ArrayList<>();
    private List<User> saves = new ArrayList<>();

    public void addShare(User user) {
      if (!shares.contains(user)) {
        shares.add(user);
      }
    }
    
    public void addSave(User user) {
        if (!saves.contains(user)) {
            saves.add(user);
        }
    }

    public List<User> getShares() {
        return shares;
    }

    public List<User> getSaves () {
        return saves;
    }

}

