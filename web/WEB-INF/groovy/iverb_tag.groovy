import cz.kibo.wordbook.model.*;

request.iverbs = IVerb.findAllByTag(params.tag)
request.tag = true

forward '/iverb_library.gtpl'
return