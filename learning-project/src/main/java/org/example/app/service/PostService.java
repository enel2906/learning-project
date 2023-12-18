package org.example.app.service;

import org.example.app.controller.PostController;
import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
import org.example.app.repository.PostRepository;

import java.util.ArrayList;

public class PostService {
    private PostService(){

    }
    private static PostService INSTANCE = new PostService();

    public static PostService getINSTANCE() {
        return INSTANCE;
    }

    public String addNewPost(String userId, String name, String content, String type) throws Exception {
         return PostRepository.addNewPost(userId, name, content, type);
    }
    public void deletePost(String postId, String userId) throws Exception {
        PostRepository.deletePost(postId, userId);
    }

    public ArrayList<PostDTO> getOtherPostById(String userId) throws Exception {
        return PostRepository.getPostsDisplayById(userId);
    }

    public ArrayList<PostDTO> getOtherPostByName(String userName) throws Exception {
        return PostRepository.getPostsDisplayByName(userName);
    }

    public boolean existPostOfUserId(String postId, String userId) throws Exception {
        return PostRepository.existPostOfUserId(postId, userId);
    }

    public boolean alreadyLike(String userId, String postId) throws Exception{
        return PostRepository.alreadyLiked(userId, postId);
    }

    public void addLike(String userId, String postId) throws Exception{
        PostRepository.addLike(userId, postId);
    }

    public PostDTO getPostDisplayById(String postId) throws Exception {
        return PostRepository.findPostDisplayById(postId);
    }

    public Post findPostById(String postId) throws Exception {
        return PostRepository.findPostById(postId);
    }
}
