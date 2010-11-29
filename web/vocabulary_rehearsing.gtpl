<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická slovíčka - procvičování | drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická slovíčka."/>
        <meta name="keywords" content="anglická slovíčka"/>
        <meta name="robots" content="all, follow"/>      
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
       
    </head>
    <body id="vocabularyPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/slovicka.html">Slovíčka</a> &gt; Procvičování (${request.count}) </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">
                    
                  <form action="/slovicka/preference/save" method="post">

                    <div class="monkey">
                        <fieldset>
                          <p>
                              <label class="label" >${request.vocabulary.source}</label>
                          </p>
                        </fieldset>
                        <div class="cleaner"></div>
                    </div>

                    <div class="student">
                        <fieldset class="corner">
                           <% request.vocabulary.entries.eachWithIndex(){ en, idx -> %>
                             <p>
                                 <input id="entriesStudent${idx}" name="entriesStudent${idx}" class="<% if(idx==0){print 'getFocus ' }%>corner" type="text" maxlength="50" autocomplete="off" />
                             </p>
                           <%}%>
                        </fieldset>
                        <div class="cleaner"></div>
                    </div>
                   
                   <div class="monkey hidden">
                       <fieldset class="corner">
                        <p>
                            <label><% request.vocabulary.entries.eachWithIndex(){ en, idx -> if(idx!=0){ print ","};  print en} %></label>
                        </p>
                       </fieldset>
                      <div class="cleaner"></div>
                   </div>

                    <div class="line"></div>

                    <div id="rehearsingMenuBar" class="clearfix">
                        
                        <input id="entries" name="entries" type="hidden" value='<% request.vocabulary.entries.eachWithIndex(){ en, idx -> if(idx!=0){ print ","};  print en} %>' />
                        <input type="button" class="button" onclick="showResultVocabulary(); speech('${request.vocabulary.textToSpeech()}');" value="Kontrola" />

                        <input type="hidden" name="vocabulary" value="${request.vocabulary.id}" />
                        <input type="hidden" name="preference" value="${request.preference.id}" />
                        <input type="submit" class="button" value="Daší" />

                        <a href="/slovicka/remove/${request.vocabulary.id}">odstranit</a>

                    </div>
                    <div id="mp3Player"></div>
                    </form>
                    
               </div> <!-- class="space" -->
               <hr />
              </div> <!-- id="main" -->

             <div id="local">
                <div class="space">
                    <% include '/WEB-INF/includes/vocabulary_local_navigation.gtpl' %>
                </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

        </div>  <!-- id="content" -->

        <% include '/WEB-INF/includes/footer.gtpl' %>

      </div> <!-- id="page" -->

      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
      <script type="text/javascript" src="/js/main.js"></script>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>

    </body>
</html>



