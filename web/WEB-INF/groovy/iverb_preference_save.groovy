import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

def parent = KeyFactory.createKey(IVerb.class.getSimpleName(), params.iverb as Long)
def preference =  Preference.get(parent, params.preference)

if( params.infinitiveEn.trim() == params.infinitiveEnStudent.trim() &&
    params.pastSimple.trim() == params.pastSimpleStudent.trim() &&
    params.pastParticiple.trim() == params.pastParticipleStudent.trim()
){
    log.info "well"  
    preference.next = new Date() + (preference.period as int)
    preference.period = preference.period * 2
}else{
    log.info "wrongly"  
    preference.period = 1
}

preference.save()

redirect '/nepravidelna_slovesa/procvicovani'