package org.example.app.controller;

import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
import org.example.app.repository.PostRepository;
import org.example.app.service.PostService;

import java.util.ArrayList;
import java.util.List;

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

    public void deletePost(String postId) throws Exception {
        PostService.getINSTANCE().remove(postId);
    }

    public ArrayList<PostDTO> getAllPostById(String userId) throws Exception {
        return PostService.getINSTANCE().getOtherPostById(userId);
    }

    public boolean isExistPostOfUserId(String postId, String userId) throws Exception {
        return PostService.getINSTANCE().existPostOfUserId(postId,userId);
    }


    public PostDTO findPostDisplayById(String postId) throws Exception {
        return PostService.getINSTANCE().findDTOByKey(postId);
    }

    public Post findPostById(String postId) throws Exception {
        return PostService.getINSTANCE().findByKey(postId);
    }
    public List<String> getListPostIdByUserId(String userId) throws Exception {
        return PostService.getINSTANCE().getListPostIdByUserId(userId);
    }
}
