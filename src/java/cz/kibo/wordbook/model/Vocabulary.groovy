package cz.kibo.wordbook.model

import com.google.appengine.api.datastore.Entity
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import com.google.appengine.api.users.User
import com.google.appengine.api.datastore.*;

/**
 *
 * @author tomas
 */
class Vocabulary extends Model{

    def Map related

    //--CONSTRUCTORS---------------------
    public Vocabulary(Map params){
        super(params)
    }

    public Vocabulary(Entity entity){
        super(entity)
    }

    //--HELPER---------------------------
    public int rating(){
        return this.users.size()
    }

    public String textToSpeech(){

        if( this.lang == "en" ){
            return URLEncoder.encode( this.source )
        }else{
            return URLEncoder.encode( this.entries.toString() )
        }
    }

    //transient
    public void setRelated(Map related){
        this.related = related
    }

    //transient
    public Map getRelated(){
        return this.related
    }

     //--DAO----------------------------

    static def get(id){
        def key = KeyFactory.createKey(Vocabulary.class.getSimpleName(), id as Long)
        return new Vocabulary( Model.datastore.get(key) )
    }

    static def findAllByOwner(owner, pagination=100000){
         def query = new Query(Vocabulary.class.getSimpleName())
         query.addFilter("owner", Query.FilterOperator.EQUAL, owner)
         def preparedQuery = Model.datastore.prepare(query)
         def entities = preparedQuery.asList(FetchOptions.Builder.withLimit(pagination as int))
         return entities.collect { entity -> new Vocabulary(entity) }
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
        if (!(obj instanceof Vocabulary)) {
         return false
        }
       Vocabulary stranger = (Vocabulary) obj
         return new EqualsBuilder().
             append(this.source, stranger.source).
             append(this.language, stranger.language).
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

