import java.net.URLEncoder;
import net.sf.json.groovy.JsonSlurper;
import net.sf.json.JSON;
import cz.kibo.wordbook.model.*;

if( params.q.isEmpty() ){
    redirect '/slovicka/slovnik'
    return
}

def q = URLEncoder.encode(params.q, "utf-8")
def sl = params.lang
def tl = (sl=="en") ? "cs" : "en";

/*
 *  http://www.google.com/dictionary/json?callback=data&q=leave&sl=en&tl=cs&restrict=pr,re
 *   pr - primaries
 *   re - related
 *   de - definition
 *   sy - synonyms //must be in en language
*/

def url = new URL("http://www.google.com/dictionary/json?callback=data&q=${q}&sl=${sl}&tl=${tl}&restrict=pr%2Cre")
def response = url.get()
def text = response.getText("utf-8")
def json = new JsonSlurper().parseText(text.substring( text.indexOf("{") , (text.lastIndexOf("}") + 1)))
def lang = json.sourceLanguage

def entries = []
try{
    json.primaries.entries.entries.terms.text.each(){ t ->
        t.each(){ k->
            k.each(){ m ->
                entries.add( m[0] )
            }
        }
    }

}catch(NullPointerException e){
    //no result found        
}

def related = [:]
try{
    if(lang == "en"){
        json.relatedPhrases.terms.text.eachWithIndex(){ t, idx ->
            related.put( t[0], json.relatedPhrases.entries.terms.text[idx][0][0])
        }
    }else{
        json.relatedPhrases.terms.text.eachWithIndex(){ t, idx ->
            related.put( json.relatedPhrases.entries.terms.text[idx][0][0], t[0] )
        }
    }
}catch(NullPointerException e){
    //no result found
}

def vocabulary = new Vocabulary( ["source":params.q, "lang":lang, "entries":entries] )
vocabulary.setRelated(related)

request.vocabulary = vocabulary


forward '/vocabulary_dictionary.gtpl'
return
