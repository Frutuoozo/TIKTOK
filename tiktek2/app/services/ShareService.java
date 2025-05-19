package services;

import interfaces.IReactions;
import models.User;
import models.Video;

public class ShareService implements IReactions {
    @Override
    public void react(Video video, User user) {
        video.addShare(user);
        System.out.println(user.getName() + " compartilhou o vídeo: " + video.getTitle());
    }
}
