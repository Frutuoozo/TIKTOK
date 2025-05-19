import interfaces.ICommentService;
import interfaces.IFeedService;
import interfaces.IReactions;

import java.util.*;

import models.User;
import models.Video;

import services.CommentService;
import services.FeedService;
import services.FollowService;
import services.LikeService;
import services.SaveService;
import services.ShareService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TIK TOK ===");
        System.out.println("Bem-vindo ao Tik Tok!");
        System.out.println("Digite seu nome de usuário:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        User currentUser = new User("1", username);
        User user2 = new User("2", "Anisio4355");

        Video video1 = new Video("v1", "Aprenda Matematica em 5min", user2);
        List<Video> videos = new ArrayList<>();
        videos.add(video1);

        IReactions likeService = new LikeService();
        IReactions shareService = new ShareService();
        IReactions saveService = new SaveService();
        ICommentService commentService = new CommentService();
        IFeedService feedService = new FeedService(videos);
        FollowService followService = new FollowService();

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Ver feed");
            System.out.println("2 - Curtir vídeo");
            System.out.println("3 - Comentar vídeo");
            System.out.println("4 - Criar um post");
            System.out.println("5 - Compartilhar vídeo");
            System.out.println("6 - Salvar vídeo");
            System.out.println("7 - Seguir usuário");
            System.out.println("8 - Ver seguidores/seguindo");
            System.out.println("0 - Sair");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    feedService.showFeed();
                    break;
                case 2:
                    int videoIndex = selecionarVideo(scanner, videos, "curtir");
                    if (videoIndex != -1) {
                        likeService.react(videos.get(videoIndex), currentUser);
                        System.out.println("Você curtiu o vídeo!");
                    }
                    break;
                case 3:
                    int videoCommentIndex = selecionarVideo(scanner, videos, "comentar");
                    if (videoCommentIndex != -1) {
                        System.out.println("Digite seu comentário:");
                        String comentario = scanner.nextLine();
                        commentService.comment(videos.get(videoCommentIndex), currentUser, comentario);
                        System.out.println("Comentário adicionado!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o título do vídeo:");
                    String titulo = scanner.nextLine();
                    Video novoVideo = new Video(UUID.randomUUID().toString(), titulo, currentUser);
                    videos.add(novoVideo);
                    System.out.println("Vídeo criado com sucesso!");
                    break;
                case 5:
                    int shareIndex = selecionarVideo(scanner, videos, "compartilhar");
                    if (shareIndex != -1) {
                        shareService.react(videos.get(shareIndex), currentUser);
                        System.out.println("Vídeo compartilhado!");
                    }
                    break;
                case 6:
                    int saveIndex = selecionarVideo(scanner, videos, "salvar");
                    if (saveIndex != -1) {
                        saveService.react(videos.get(saveIndex), currentUser);
                        System.out.println("Vídeo salvo!");
                    }
                    break;
                case 7:
                    System.out.println("Você está tentando seguir: " + user2.getName());
                         followService.seguir(currentUser, user2);
                        System.out.println("Agora você está seguindo " + user2.getName());
                    break;
                case 8:
                    List<User> meusSeguidores = followService.getSeguidores(currentUser);
                    List<User> estouSeguindo = followService.getSeguindo(currentUser);

                    System.out.println("Você tem " + meusSeguidores.size() + " seguidores.");
                    System.out.println("Você está seguindo " + estouSeguindo.size() + " usuários.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int selecionarVideo(Scanner scanner, List<Video> videos, String acao) {
        System.out.println("Escolha o número do vídeo para " + acao + ":");
        for (int i = 0; i < videos.size(); i++) {
            System.out.println((i + 1) + " - " + videos.get(i).getTitle());
        }
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número válido.");
            scanner.next();
        }
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index >= 0 && index < videos.size()) {
            return index;
        } else {
            System.out.println("Vídeo inválido!");
            return -1;
        }
    }
}
