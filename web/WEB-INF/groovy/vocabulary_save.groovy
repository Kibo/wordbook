import cz.kibo.wordbook.model.*;

if (params.entries == null){
    forward '/vocabulary_dictionary.gtpl'
    return
}

def source =  params.source
def lang = params.lang
def entries = ( (params.entries instanceof String) ? [params.entries] : params.entries as Set )

def values = [] as Set
entries.each(){ en ->
    values.add (params."${en}")
}

def vocabulary

if (params.id == "0"){ //NEW
    vocabulary = new Vocabulary(["source":source, "lang":lang, "entries":values, "owner":user ])
    vocabulary.save();
    new Preference(["parent": vocabulary.key, "user":user, "period":1, "next": new Date(), "type": Vocabulary.class.getSimpleName()]).save()
}else{ //EDIT
    vocabulary = Vocabulary.get( params.id )
    vocabulary.entries = values
    vocabulary.save();
}

redirect '/slovicka/knihovna'
return