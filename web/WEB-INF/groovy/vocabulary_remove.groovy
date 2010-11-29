import cz.kibo.wordbook.model.*;

def vocabulary = Vocabulary.get(params.id)
def preference = vocabulary.getPreference(user)
preference.delete()

vocabulary.delete()

redirect '/slovicka/knihovna'