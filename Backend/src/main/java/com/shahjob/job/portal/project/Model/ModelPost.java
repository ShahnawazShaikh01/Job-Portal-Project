package com.shahjob.job.portal.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobpost")
public class ModelPost {
    private String profile;
    private int id;
    private String desc;
    private int exp;
    private String techs[];
}
