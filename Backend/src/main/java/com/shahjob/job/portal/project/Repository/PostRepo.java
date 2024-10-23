package com.shahjob.job.portal.project.Repository;

import com.shahjob.job.portal.project.Model.ModelPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends MongoRepository<ModelPost,String> {

}
