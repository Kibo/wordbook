import cz.kibo.wordbook.model.*;

def DEFAULT_TAG = "dva_tvary_stejne"

request.iverb = new IVerb( ["infinitiveEn":"", "pastSimple":"", "pastParticiple":"", "infinitiveCs":"", "tags":DEFAULT_TAG ] )

forward '/iverb_form.gtpl'