import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

def parent = KeyFactory.createKey(Vocabulary.class.getSimpleName(), params.vocabulary as Long)
def preference =  Preference.get(parent, params.preference)

def entries = params.entries.split(",") as List


//user set your answer as correct
def forceCorrect = params.isCorrect == null ? false : true;

def success = true

if ( !forceCorrect ){
    for( int i = 0; i< entries.size(); i++ ){
        if (!entries.contains( params."entriesStudent${i}".trim()  )){
            success = false
            break
        }
    }
}

if(success){
    log.info "well"
    preference.next = new Date() + (preference.period as int)
    preference.period = preference.period * 2
}else{
    log.info "wrongly"
    preference.period = 1
}

preference.save()

redirect '/slovicka/procvicovani'
return