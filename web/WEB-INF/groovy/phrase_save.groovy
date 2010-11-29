import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

def phrase = (params.id != "0") ? Phrase.get( params.id) : new Phrase(["owner": user, "users": [user] ])
phrase.front = params.front as Text
phrase.back = params.back as Text
phrase.gramar = params.gramar as Text
phrase.tags =  (params.tags instanceof String) ? [params.tags] : params.tags as Set

if( phrase.validate() ){
    
    if(phrase.id == 0){
        log.info "new phrase"
        phrase.save()
        new Preference(["parent": phrase.key, "user":user, "period":1, "next": new Date(), "type": Phrase.class.getSimpleName()]).save()
    }else{
        log.info "update phrase"
        phrase.save()
    }

    redirect '/fraze/knihovna'
    return

}else{
    request.message = true
    request.phrase = phrase
    forward '/phrase_form.gtpl'
    return
}

