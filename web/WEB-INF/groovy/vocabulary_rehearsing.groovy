import cz.kibo.wordbook.model.*;

def preferences = Preference.findAllForRehearsing( user, Vocabulary.class.getSimpleName() )
def count = preferences.size()

if(count > 0){
    Collections.shuffle( preferences )
    request.vocabulary = Vocabulary.get(preferences[0].key.parent.id)
    request.preference = preferences[0]
    request.count = count
    forward '/vocabulary_rehearsing.gtpl'
    return
}

forward '/vocabulary_rehearsing_finish.gtpl'