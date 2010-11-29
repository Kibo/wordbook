import cz.kibo.wordbook.model.*;

request.iverbs = IVerb.findAllByUser(user)

forward '/iverb_library.gtpl'
return