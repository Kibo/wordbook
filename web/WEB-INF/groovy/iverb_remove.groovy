import cz.kibo.wordbook.model.*;

def iverb = IVerb.get(params.id)
def preference = iverb.getPreference(user)
preference.delete()

iverb.users.remove(user)
if ( iverb.users.isEmpty() ){
    iverb.delete()
}else{
    iverb.save()
}

redirect '/nepravidelna_slovesa/knihovna'