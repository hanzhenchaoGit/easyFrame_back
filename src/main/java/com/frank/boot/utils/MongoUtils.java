package com.frank.boot.utils;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class MongoUtils {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MongoDbFactory dbFactory ;
    static GridFsTemplate gridFsTemplate;
    private GridFsTemplate getGridFs(){
        if(gridFsTemplate == null){
            gridFsTemplate =  new GridFsTemplate(dbFactory, mongoTemplate.getConverter());
        }
        return gridFsTemplate;
    }
    public ObjectId store(InputStream in, String fileName, String contentType) {
        getGridFs();
        return gridFsTemplate.store(in,fileName,contentType);
    }

    public GridFsResource getFile(String fileName){
        getGridFs();
        return gridFsTemplate.getResource(fileName);
    }

    public GridFSFile getFileByMongoId(String mongoId){
        return gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(new ObjectId(mongoId))));
    }
}
