package cz.kibo.wordbook.model

import com.google.appengine.api.datastore.*;
import cz.kibo.wordbook.util.Utils;
import java.net.URLEncoder;
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import com.google.appengine.api.users.User

class Phrase extends Model{
    
    //--CONSTRUCTORS---------------------   
    public Phrase(Map params){
        super(params)
    }

    public Phrase(Entity entity){
        super(entity)
    }

    //--HELPER---------------------------
    public int rating(){
        return this.users.size()
    }

    public String textToSpeech(){
        return URLEncoder.encode(Utils.cutHtmlTags( this.back.value, 0))
    }

    public boolean validate(){
        if(this.front != null && !this.front.value.isEmpty() &&
           this.back != null && !this.back.value.isEmpty() &&      
           this.tags != null && this.tags.size() > 0 ){
           return true
        }

        return false
    }



    //--DAO----------------------------
    static def get(id){
        def key = KeyFactory.createKey(Phrase.class.getSimpleName(), id as Long)
        return new Phrase( Model.datastore.get(key) )
    }
    
    static def findAllByUser(user, pagination=100000){
         def query = new Query(Phrase.class.getSimpleName())
         query.addFilter("users", Query.FilterOperator.EQUAL, user)
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new Phrase(entity) }
    }

    static def findAllByTag(tag, pagination=100000){
         def query = new Query(Phrase.class.getSimpleName())
         query.addFilter("tags", Query.FilterOperator.EQUAL, tag)
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new Phrase(entity) }
    }

    def getPreference(User user){
        def query = new Query(Preference.class.getSimpleName())
        query.setAncestor( this.key )
        query.addFilter("user", Query.FilterOperator.EQUAL, user )
        def preparedQuery = Model.datastore.prepare(query)
        def entity = preparedQuery.asSingleEntity()
        return new Preference( entity )
    }
    
    //--OVERRIDEN---------------------
    @Override
    boolean equals(Object obj) {
        if (!(obj instanceof Phrase)) {
         return false
        }
       Phrase stranger = (Phrase) obj
         return new EqualsBuilder().
             append(this.front, stranger.front).
             append(this.back, stranger.back).
             append(this.gramar, stranger.gramar).
             isEquals()
    }

    @Override
    int hashCode() {
        return new HashCodeBuilder(17, 37).
           append(this.back).
           toHashCode()
    }

    @Override
    String toString(){
        return new ToStringBuilder(this).
	    append(this.id).
	    toString()
    }
}