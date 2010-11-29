import cz.kibo.wordbook.model.*;

def phrase = Phrase.get(params.id)
if (!phrase.users.contains( user )){

    phrase.users.add( user )
    phrase.save()
    new Preference(["parent": phrase.key, "user":user, "period":1, "next": new Date(), "type": Phrase.class.getSimpleName()]).save()
}

redirect "/fraze/knihovna"
return