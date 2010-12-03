// example routes
/*
get "/blog/@year/@month/@day/@title", forward: "/WEB-INF/groovy/blog.groovy?year=@year&month=@month&day=@day&title=@title"
get "/something", redirect: "/blog/2008/10/20/something", cache: 2.hours
get "/book/isbn/@isbn", forward: "/WEB-INF/groovy/book.groovy?isbn=@isbn", validate: { isbn ==~ /\d{9}(\d|X)/ }
*/

//--FRAZE--------------------------------------------------
//TODO index, new - add cache
get "/",  forward: "/index.gtpl", cache: 24.hours
get "/fraze.html", forward: "/WEB-INF/groovy/phrase_index.groovy", cache: 24.hours
get "/fraze/procvicovani", forward: "/WEB-INF/groovy/phrase_rehearsing.groovy"
get "/fraze/knihovna", forward: "/WEB-INF/groovy/phrase_library.groovy"
get "/fraze/nova", forward: "/WEB-INF/groovy/phrase_new.groovy", cache: 24.hours
post "/fraze/save", forward: "/WEB-INF/groovy/phrase_save.groovy"
post "/fraze/preference/save", forward: "/WEB-INF/groovy/phrase_preference_save.groovy"
get "/fraze/edit/@id", forward: "/WEB-INF/groovy/phrase_edit.groovy?id=@id"
get "/fraze/remove/@id", forward: "/WEB-INF/groovy/phrase_remove.groovy?id=@id"

//get "/fraze/tag/@tag", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=@tag"
get "/fraze/tag/slovesne_casy", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=slovesne_casy", cache: 24.hours
get "/fraze/tag/predlozky", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=predlozky", cache: 24.hours
get "/fraze/tag/vazby", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=vazby", cache: 24.hours
get "/fraze/tag/fraze", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=fraze", cache: 24.hours
get "/fraze/tag/slovni_spojeni", forward: "/WEB-INF/groovy/phrase_tag.groovy?tag=slovni_spojeni", cache: 24.hours

get "/fraze/knihovna/add/@id", forward: "/WEB-INF/groovy/phrase_library_add.groovy?id=@id"
post "/fraze/knihovna/add", forward: "/WEB-INF/groovy/phrase_library_add_more.groovy"

//--IVERBS-----------------------------------------------
get "/nepravidelna_slovesa.html", forward: "/WEB-INF/groovy/iverb_index.groovy", cache: 24.hours

get "/nepravidelna_slovesa/knihovna", forward: "/WEB-INF/groovy/iverb_library.groovy"
get "/nepravidelna_slovesa/nova", forward: "/WEB-INF/groovy/iverb_new.groovy", cache: 24.hours
post "/nepravidelna_slovesa/save", forward: "/WEB-INF/groovy/iverb_save.groovy"
get "/nepravidelna_slovesa/edit/@id", forward: "/WEB-INF/groovy/iverb_edit.groovy?id=@id"
get "/nepravidelna_slovesa/remove/@id", forward: "/WEB-INF/groovy/iverb_remove.groovy?id=@id"

get "/nepravidelna_slovesa/tag/tri_tvary_stejne", forward: "/WEB-INF/groovy/iverb_tag.groovy?tag=tri_tvary_stejne", cache: 24.hours
get "/nepravidelna_slovesa/tag/dva_tvary_stejne", forward: "/WEB-INF/groovy/iverb_tag.groovy?tag=dva_tvary_stejne", cache: 24.hours
get "/nepravidelna_slovesa/tag/odlisne_tvary", forward: "/WEB-INF/groovy/iverb_tag.groovy?tag=odlisne_tvary", cache: 24.hours

get "/nepravidelna_slovesa/knihovna/add/@id", forward: "/WEB-INF/groovy/iverb_library_add.groovy?id=@id"

get "/nepravidelna_slovesa/procvicovani", forward: "/WEB-INF/groovy/iverb_rehearsing.groovy"
post "/nepravidelna_slovesa/preference/save", forward: "/WEB-INF/groovy/iverb_preference_save.groovy"

//--VOCABULARY-----------------------------------------------
get "/slovicka.html", forward: "/WEB-INF/groovy/vocabulary_index.groovy", cache: 24.hours
get "/slovicka/slovnik", forward: "/WEB-INF/groovy/vocabulary_dictionary.groovy", cache: 24.hours
post "/slovicka/slovnik/hledej", forward: "/WEB-INF/groovy/vocabulary_dictionary_search.groovy"
post "/slovicka/save", forward: "/WEB-INF/groovy/vocabulary_save.groovy"

get "/slovicka/edit/@id", forward: "/WEB-INF/groovy/vocabulary_edit.groovy?id=@id"

get "/slovicka/knihovna", forward: "/WEB-INF/groovy/vocabulary_library.groovy"
get "/slovicka/remove/@id", forward: "/WEB-INF/groovy/vocabulary_remove.groovy?id=@id"

get "/slovicka/procvicovani", forward: "/WEB-INF/groovy/vocabulary_rehearsing.groovy"
post "/slovicka/preference/save", forward: "/WEB-INF/groovy/vocabulary_preference_save.groovy"
