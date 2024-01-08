package org.example.app.service;

import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
import org.example.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public String addNewPost(String userId, String name, String content, String type) throws Exception {
         return postRepository.addNewPost(userId, name, content, type);
    }
    public PostDTO findDTOByKey(String postId) throws Exception {
        return postRepository.findPostDisplayById(postId);
    }
    public Post findByKey(String postId) throws Exception {
        return postRepository.findPostById(postId);
    }
    public void remove(String postId) throws Exception {
        postRepository.deletePost(postId);
    }
    public boolean isValid(String postId) throws Exception{
        return postRepository.isValidPostId(postId);
    }
    public ArrayList<PostDTO> getOtherPostById(String userId) throws Exception {
        return postRepository.getPostsDisplayById(userId);
    }
    public boolean existPostOfUserId(String postId, String userId) throws Exception {
        return postRepository.existPostOfUserId(postId, userId);
    }
    public List<String> getListPostIdByUserId(String userId) throws Exception {
        return postRepository.getListPostId(userId);
    }
}
