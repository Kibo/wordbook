import cz.kibo.wordbook.model.*;

def preferences = Preference.findAllForRehearsing( user, Phrase.class.getSimpleName() )
def count = preferences.size()

if(count > 0){
    Collections.shuffle( preferences )
    request.phrase = Phrase.get(preferences[0].key.parent.id)
    request.preference = preferences[0]
    request.count = count
    forward '/phrase_rehearsing.gtpl'
    return
}

forward '/phrase_rehearsing_finish.gtpl'