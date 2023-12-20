package org.example.app.service;

import org.example.app.model.LikedInfor;
import org.example.app.repository.LikeInforRepository;

import java.util.List;


public class LikedInforService implements ServiceInterface<Object>{
    private LikedInforService(){

    }
    private static LikedInforService INSTANCE = new LikedInforService();

    public static LikedInforService getINSTANCE() {
        return INSTANCE;
    }
    public void addNewLikeInfor(String userId, String postId) throws Exception {
        LikeInforRepository.addNewLikeInfor(userId, postId);
    }
    public boolean alreadyLiked(String userId, String postId) throws Exception {
        return LikeInforRepository.alreadyLiked(userId, postId);
    }
    public long getNumLikeInfor(String postId) throws Exception {
        return LikeInforRepository.getNumLike(postId);
    }
    public List<String> findByKey(String postId) throws Exception {
        return LikeInforRepository.getLikedUsers(postId);
    }
    public void remove(String postId) throws Exception {
        LikeInforRepository.deletePost(postId);
    }
    public boolean isValid(String postId) throws Exception {
        return LikeInforRepository.isValidPostId(postId);
    }

}
