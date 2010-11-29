import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

def parent = KeyFactory.createKey(Phrase.class.getSimpleName(), params.phrase as Long)
def preference =  Preference.get(parent, params.preference)

if(params.success){
    log.info "well"
    preference.next = new Date() + (preference.period as int)
    preference.period = preference.period * 2    
}else{
    log.info "wrongly"   
    preference.period = 1
}

preference.save()

redirect '/fraze/procvicovani'


