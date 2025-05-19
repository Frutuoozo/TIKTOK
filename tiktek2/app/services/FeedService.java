package services;

import interfaces.IFeedService;
import models.Video;

import java.util.List;

public class FeedService implements IFeedService {
    private List<Video> videos;

    public FeedService(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public void showFeed() {
        for (Video video : videos) {
            System.out.println("🎬 Título: " + video.getTitle() + " | Dono: " + video.getOwner().getName());
            System.out.println("👍 Curtidas: " + video.getLikes().size());
            for (String comment : video.getComments()) {
                System.out.println("💬 " + comment);
            }
            System.out.println("-------------");
        }
    }
}
