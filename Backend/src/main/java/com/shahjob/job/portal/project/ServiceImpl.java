package com.shahjob.job.portal.project;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shahjob.job.portal.project.Model.ModelPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ServiceImpl implements SearchService{
    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;
    @Override
    public List<ModelPost> searchByText(String text) {
        final List<ModelPost> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("Shahjob");
        MongoCollection<Document> collection = database.getCollection("jobpost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "searchfeature")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("profile", "desc")))),
                new Document("$sort",
                        new Document("exp", 1L))));
        result.forEach(document -> posts.add(converter.read(ModelPost.class,document)));

        return posts;
    }
}
