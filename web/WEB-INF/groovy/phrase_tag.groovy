import cz.kibo.wordbook.model.*;

request.phrases = Phrase.findAllByTag(params.tag)
request.tag = true

forward '/phrase_library.gtpl'
return