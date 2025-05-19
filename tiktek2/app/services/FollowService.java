package services;

import models.User;

import  java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FollowService {
    
    private Map<User, List<User>> seguidores = new HashMap<>();
    private Map<User, List<User>> seguindo = new HashMap<>();

    public void seguir(User seguidor, User seguido) {
        if (seguidor.equals(seguido)) return;

        seguindo.putIfAbsent(seguidor, new ArrayList<>());
        seguidores.putIfAbsent(seguido, new ArrayList<>());

        if (!seguindo.get(seguidor).contains(seguido)) {
            seguindo.get(seguidor).add(seguido);
            seguidores.get(seguido).add(seguidor);

        }
    }

      public List<User> getSeguidores(User user) {
        return seguidores.getOrDefault(user, new ArrayList<>());
      }

      public List<User> getSeguindo(User user) {
        return seguindo.getOrDefault(user, new ArrayList<>());
    }

 }
