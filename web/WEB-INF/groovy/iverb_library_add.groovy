import cz.kibo.wordbook.model.*;

def iverb = IVerb.get(params.id)
if (!iverb.users.contains( user )){

    iverb.users.add( user )
    iverb.save()
    new Preference(["parent": iverb.key, "user":user, "period":1, "next": new Date(), "type": IVerb.class.getSimpleName()]).save()
}

redirect "/nepravidelna_slovesa/knihovna"
return