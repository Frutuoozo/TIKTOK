package services;

import interfaces.IReactions;
import models.User;
import models.Video;

public class SaveService implements IReactions {
    @Override
    public void react(Video video, User user) {
        video.addSave(user);
        System.out.println(user.getName() + " salvou o vídeo: " + video.getTitle());
    }
}
