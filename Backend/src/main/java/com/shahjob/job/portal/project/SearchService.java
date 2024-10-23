package com.shahjob.job.portal.project;

import com.shahjob.job.portal.project.Model.ModelPost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {
    List<ModelPost> searchByText(String text);
}
