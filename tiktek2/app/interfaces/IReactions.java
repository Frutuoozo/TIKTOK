package interfaces;

import models.User;
import models.Video;

public interface IReactions {
    void react(Video video, User user);
}
