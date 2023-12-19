package org.example.app.controller;

import org.example.app.repository.LikeInforRepository;
import org.example.app.service.LikedInforService;

import java.util.List;

public class LikedInforController {
    private LikedInforController(){

    }
    private static LikedInforController INSTANCE = new LikedInforController();

    public static LikedInforController getINSTANCE() {
        return INSTANCE;
    }
    public void addNewLikeInfor(String userId, String postId) throws Exception {
        LikedInforService.getINSTANCE().addNewLikeInfor(userId, postId);
    }
    public boolean alreadyLiked(String userId, String postId) throws Exception {
       return LikedInforService.getINSTANCE().alreadyLiked(userId, postId);
    }
    public long getNumLikeInfor(String postId) throws Exception {
        return LikedInforService.getINSTANCE().getNumLikeInfor(postId);
    }
    public List<String> getUsersLiked(String postId) throws Exception {
        return LikedInforService.getINSTANCE().getUsersLiked(postId);
    }
    public void deletePost(String postId) throws Exception {
        LikedInforService.getINSTANCE().deletePost(postId);
    }
}
