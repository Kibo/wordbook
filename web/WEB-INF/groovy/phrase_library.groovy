import cz.kibo.wordbook.model.*;

request.phrases = Phrase.findAllByUser(user)

forward '/phrase_library.gtpl'
return