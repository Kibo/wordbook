import cz.kibo.wordbook.model.*;

if (params.entries == null){
    forward '/vocabulary_dictionary.gtpl'
    return
}

def source =  params.source
def lang = params.lang
def entries = ( (params.entries instanceof String) ? [params.entries] : params.entries as Set )

def vocabulary = new Vocabulary(["source":source, "lang":lang, "entries":entries, "owner":user ])
vocabulary.save();
new Preference(["parent": vocabulary.key, "user":user, "period":1, "next": new Date(), "type": Vocabulary.class.getSimpleName()]).save()

redirect '/slovicka/knihovna'
return