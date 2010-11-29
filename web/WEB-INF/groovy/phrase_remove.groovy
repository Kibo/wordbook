import cz.kibo.wordbook.model.*;

def phrase = Phrase.get(params.id)
def preference = phrase.getPreference(user)
preference.delete()

phrase.users.remove(user)
if ( phrase.users.isEmpty() ){
    phrase.delete()
}else{
    phrase.save()
}

redirect '/fraze/knihovna'