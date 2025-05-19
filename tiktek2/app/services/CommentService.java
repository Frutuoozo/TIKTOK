package services;

import interfaces.ICommentService;
import models.User;
import models.Video;

public class CommentService implements ICommentService {
    @Override
    public void comment(Video video, User user, String comment) {
        video.addComment(user.getName() + ": " + comment);
    }
}
