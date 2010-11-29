import cz.kibo.wordbook.model.*;
import com.google.appengine.api.datastore.*;

if (params.phrases == null){
    redirect '/fraze/knihovna'
    return
}

def phrases = (params.phrases instanceof String) ? [params.phrases] : params.phrases as Set

phrases.each(){ row ->

    def both = row.split('&')
    
    def phrase = new Phrase(["owner": user, "users": [user] ])
    phrase.front = row.split('&')[0] as Text
    phrase.back = row.split('&')[1] as Text
    phrase.gramar = new Text("")
    phrase.tags =  (params.tags instanceof String) ? [params.tags] : params.tags as Set
    phrase.save()
    new Preference(["parent": phrase.key, "user":user, "period":1, "next": new Date(), "type": Phrase.class.getSimpleName()]).save()

}

redirect '/fraze/knihovna'
return