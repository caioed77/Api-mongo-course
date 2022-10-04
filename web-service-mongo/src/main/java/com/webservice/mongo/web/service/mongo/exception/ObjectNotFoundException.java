package com.webservice.mongo.web.service.mongo.exception;

public class ObjectNotFoundException  extends  RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
