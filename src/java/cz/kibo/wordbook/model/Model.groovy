package cz.kibo.wordbook.model

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.*;

abstract class Model {

    def entity
    static def datastore = DatastoreServiceFactory.datastoreService

    public Model(){
        super()
    }

    public Model(Map params){

        this.@entity = (params.parent != null) ?
            new Entity(this.getClass().simpleName, params.parent) :
            new Entity(this.getClass().simpleName);

        params.remove("parent")

        params.each{ key, val ->
            this.setProperty key, val
        }
    }

    public Model(Entity entity){
        this.@entity = entity
    }

    def getProperty(String name) {
        if(name.equals("id")){
            return entity.key.id
        }else{
            return entity."${name}"
        }
    }

    void setProperty(String name, value) {
        entity."${name}" = value
    }

    def save(){
        this.entity.save()
    }

    def delete(){
        this.entity.delete()
    }
}


