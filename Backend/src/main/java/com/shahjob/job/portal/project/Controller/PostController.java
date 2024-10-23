package com.shahjob.job.portal.project.Controller;

import com.shahjob.job.portal.project.Model.ModelPost;
import com.shahjob.job.portal.project.Repository.PostRepo;
import com.shahjob.job.portal.project.SearchService;
import com.shahjob.job.portal.project.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostRepo repo;

    @Autowired
    private SearchService srepo;

    @GetMapping("/all")
    @CrossOrigin
    public List<ModelPost> getAllPosts(){
        return repo.findAll();
    }
    @PostMapping("/create-post")
    @CrossOrigin
    public ModelPost createJob(@RequestBody ModelPost modelPost){
        return repo.save(modelPost);

    }
    @GetMapping("/post/{text}")
    @CrossOrigin
    public List<ModelPost> findBySearch(@PathVariable String text){
        return srepo.searchByText(text);


    }
}
