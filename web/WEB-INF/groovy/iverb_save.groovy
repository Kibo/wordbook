import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

def iverb = (params.id != "0") ? IVerb.get( params.id) : new IVerb(["owner": user, "users": [user] ])
iverb.infinitiveEn = params.infinitiveEn
iverb.pastSimple = params.pastSimple
iverb.pastParticiple = params.pastParticiple
iverb.infinitiveCs = params.infinitiveCs
iverb.tags =  (params.tags instanceof String) ? [params.tags] : params.tags as Set

if( iverb.validate() ){

    if(iverb.id == 0){
        log.info "new iverb"
        iverb.save()
        new Preference(["parent": iverb.key, "user":user, "period":1, "next": new Date(), "type": IVerb.class.getSimpleName() ]).save()
    }else{
        log.info "update iverb"
        iverb.save()
    }

    redirect '/nepravidelna_slovesa/knihovna'
    return

}else{
    request.message = true
    request.iverb = iverb
    forward '/iverb_form.gtpl'
    return
}

