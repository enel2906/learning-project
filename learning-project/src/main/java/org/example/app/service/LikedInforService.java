package org.example.app.service;

import org.example.app.model.LikedInfor;
import org.example.app.repository.LikeInforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedInforService {
    private LikeInforRepository likeInforRepository;

    public LikedInforService(LikeInforRepository likeInforRepository){
        this.likeInforRepository = likeInforRepository;
    }
    public void addNewLikeInfor(String userId, String postId) throws Exception {
        likeInforRepository.addNewLikeInfor(userId, postId);
    }
    public boolean alreadyLiked(String userId, String postId) throws Exception {
        return likeInforRepository.alreadyLiked(userId, postId);
    }
    public long getNumLikeInfor(String postId) throws Exception {
        return likeInforRepository.getNumLike(postId);
    }
    public List<String> findByKey(String postId) throws Exception {
        return likeInforRepository.getLikedUsers(postId);
    }
    public void remove(String postId) throws Exception {
        likeInforRepository.deletePost(postId);
    }
    public boolean isValid(String postId) throws Exception {
        return likeInforRepository.isValidPostId(postId);
    }

}
