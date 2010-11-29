import cz.kibo.wordbook.model.*;

def preferences = Preference.findAllForRehearsing( user, IVerb.class.getSimpleName() )
def count = preferences.size()

if(count > 0){
    Collections.shuffle( preferences )

    def iverb = IVerb.get(preferences[0].key.parent.id)
    iverb.infinitiveEnStudent = ""
    iverb.pastSimpleStudent = ""
    iverb.pastParticipleStudent = ""
   
//
//
//    def rand = new Random().nextInt(4)
//    switch(rand){
//        case 0: iverb.infinitiveEnStudent = iverb.infinitiveEn; break;
//        case 1: iverb.pastSimpleStudent = iverb.pastSimple; break;
//        case 2: iverb.pastParticipleStudent = iverb.pastParticiple; break;
//        case 3: iverb.infinitiveCsStudent = iverb.infinitiveCs; break;
//        default: throw new IllegalArgumentException()
//    }
    
    request.iverb = iverb
    request.preference = preferences[0]
    request.count = count
    forward '/iverb_rehearsing.gtpl'
    return
}

forward '/iverb_rehearsing_finish.gtpl'
return