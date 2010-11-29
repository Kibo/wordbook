package cz.kibo.wordbook.model

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import cz.kibo.wordbook.model.Model;
import com.google.appengine.api.datastore.*;

class Preference extends Model{

    //--CONSTRUCTORS---------------------
    public Preference(Map params){
         super(params)
    }

    public Preference(Entity entity){
        super(entity)
    }
  
    //--DAO----------------------------
    static def get(parent, id){
        def key = KeyFactory.createKey(parent, Preference.class.getSimpleName(), id as Long)
        return new Preference( Model.datastore.get(key) )
    }
    
    static def findAllForRehearsing( user, type, pagination=100000){
         def query = new Query(Preference.class.getSimpleName())
         query.addFilter("user", Query.FilterOperator.EQUAL, user)
         query.addFilter("type", Query.FilterOperator.EQUAL, type)
         query.addFilter("next", Query.FilterOperator.LESS_THAN, new Date() )
         query.setKeysOnly()
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new Preference(entity) }
    }
    
    //--OVERRIDEN------------------------   
    @Override
    boolean equals(Object obj) {
        if (!(obj instanceof Preference)) {
         return false
        }
       Preference stranger = (Preference) obj
         return new EqualsBuilder().
             append(this.next, stranger.next).
             append(this.period, stranger.period).
             append(this.user, stranger.user).
             isEquals()
    }

    @Override
    int hashCode() {
        return new HashCodeBuilder(17, 37).
           append(this.next).
           toHashCode()
    }

    @Override
    String toString(){
        return new ToStringBuilder(this).
	    append(this.id).
	    toString()
    }

}

