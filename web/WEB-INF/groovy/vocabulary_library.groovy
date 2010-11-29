import cz.kibo.wordbook.model.*;

request.vocabularies = Vocabulary.findAllByOwner(user)

forward '/vocabulary_library.gtpl'
return