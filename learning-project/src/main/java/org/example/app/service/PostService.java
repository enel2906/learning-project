package org.example.app.service;

import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
import org.example.app.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class PostService implements ServiceInterfaceDTO<PostDTO, Post>{
    private PostService(){

    }
    private static PostService INSTANCE = new PostService();

    public static PostService getINSTANCE() {
        return INSTANCE;
    }

    public String addNewPost(String userId, String name, String content, String type) throws Exception {
         return PostRepository.addNewPost(userId, name, content, type);
    }
    public PostDTO findDTOByKey(String postId) throws Exception {
        return PostRepository.findPostDisplayById(postId);
    }
    public Post findByKey(String postId) throws Exception {
        return PostRepository.findPostById(postId);
    }
    public void remove(String postId) throws Exception {
        PostRepository.deletePost(postId);
    }
    public boolean isValid(String postId) throws Exception{
        return PostRepository.isValidPostId(postId);
    }
    public ArrayList<PostDTO> getOtherPostById(String userId) throws Exception {
        return PostRepository.getPostsDisplayById(userId);
    }
    public boolean existPostOfUserId(String postId, String userId) throws Exception {
        return PostRepository.existPostOfUserId(postId, userId);
    }
    public List<String> getListPostIdByUserId(String userId) throws Exception {
        return PostRepository.getListPostId(userId);
    }
}
