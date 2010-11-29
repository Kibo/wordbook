package cz.kibo.wordbook.model

import com.google.appengine.api.datastore.*;
import java.net.URLEncoder;
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import com.google.appengine.api.users.User

class IVerb extends Model{

     //--CONSTRUCTORS---------------------
    public IVerb(Map params){
        super(params)
    }

    public IVerb(Entity entity){
        super(entity)
    }

    //--HELPER---------------------------
    public int rating(){
        return this.users.size()
    }

    public String textToSpeech(){
        return URLEncoder.encode( this.infinitiveEn + " " + this.pastSimple + " " + this.pastParticiple )
    }

    public boolean validate(){
        if(!this.infinitiveCs.isEmpty() &&
           !this.infinitiveEn.isEmpty() &&
           !this.pastSimple.isEmpty() &&
           !this.pastParticiple.isEmpty() &&
           this.tags != null && this.tags.size() > 0 ){
           return true
        }

        return false
    }

    //--DAO----------------------------
    static def get(id){
        def key = KeyFactory.createKey(IVerb.class.getSimpleName(), id as Long)
        return new IVerb( Model.datastore.get(key) )
    }

    static def findAllByUser(user, pagination=100000){
         def query = new Query(IVerb.class.getSimpleName())
         query.addFilter("users", Query.FilterOperator.EQUAL, user)
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new IVerb(entity) }
    }

    static def findAllByTag(tag, pagination=100000){
         def query = new Query(IVerb.class.getSimpleName())
         query.addFilter("tags", Query.FilterOperator.EQUAL, tag)
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new IVerb(entity) }
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
        if (!(obj instanceof IVerb)) {
         return false
        }
       IVerb stranger = (IVerb) obj
         return new EqualsBuilder().
             append(this.infinitiveEn, stranger.infinitiveEn).
             append(this.pastSimple, stranger.pastSimple).
             append(this.pastParticiple, stranger.pastParticiple).
             isEquals()
    }
    
    @Override
    int hashCode() {
        return new HashCodeBuilder(17, 37).
           append(this.infinitiveEn).
           toHashCode()
    }

    @Override
    String toString(){
        return new ToStringBuilder(this).
	    append(this.id).
	    toString()
    }

}

