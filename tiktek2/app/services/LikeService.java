package services;

import interfaces.IReactions;
import models.User;
import models.Video;

public class LikeService implements IReactions {
    @Override
    public void react(Video video, User user) {
        video.addLike(user.getName());
    }
}
