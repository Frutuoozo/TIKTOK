package interfaces;

import models.User;
import models.Video;

public interface ICommentService {
    void comment(Video video, User user, String comment);
}
