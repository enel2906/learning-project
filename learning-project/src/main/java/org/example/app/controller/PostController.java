package org.example.app.controller;

import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
import org.example.app.repository.PostRepository;
import org.example.app.service.PostService;

import java.util.ArrayList;

public class PostController {
    private PostController(){

    }
    private static PostController INSTANCE = new PostController();

    public static PostController getINSTANCE() {
        return INSTANCE;
    }

    public String addNewPost(String userId, String name, String content, String type) throws Exception {
        return PostService.getINSTANCE().addNewPost(userId, name, content, type);
    }

    public void deletePost(String postId, String userId) throws Exception {
        PostService.getINSTANCE().deletePost(postId, userId);
    }

    public ArrayList<PostDTO> getAllPostById(String userId) throws Exception {
        return PostService.getINSTANCE().getOtherPostById(userId);
    }

    public ArrayList<PostDTO> getAllPostByName(String userName) throws Exception {
        return PostService.getINSTANCE().getOtherPostByName(userName);
    }
    public boolean isExistPostOfUserId(String postId, String userId) throws Exception {
        return PostService.getINSTANCE().existPostOfUserId(postId,userId);
    }

    public boolean alreadyLike(String userId, String postId) throws Exception {
        return PostService.getINSTANCE().alreadyLike(userId, postId);
    }

    public void addLike(String userId, String postId) throws Exception{
        PostService.getINSTANCE().addLike(userId, postId);
    }

    public PostDTO findPostDisplayById(String postId) throws Exception {
        return PostService.getINSTANCE().getPostDisplayById(postId);
    }

    public Post findPostById(String postId) throws Exception {
        return PostService.getINSTANCE().findPostById(postId);
    }
}
