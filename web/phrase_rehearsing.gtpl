<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglické fráze - Procvičování | drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglické fráze."/>
        <meta name="keywords" content="anglické fráze"/>

        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript" src="/js/main.js"></script>
    </head>
    <body id="phrasePage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/fraze.html">Fráze</a> &gt; Procvičování (${request.count}) </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <div class="monkey">
                        <fieldset>
                            <div>
                                ${request.phrase.front.value}
                            </div>
                         </fieldset>
                        <div class="cleaner"></div>
                   </div>


                    <div class="student hidden">
                        <fieldset>
                            <div>
                                ${request.phrase.back.value}
                            </div>
                            
                            <%if(!request.phrase.gramar.value.isEmpty()){%>
                            <div class="line"></div>
                                <div>
                                    ${request.phrase.gramar.value}
                                </div>
                            <%}%>
                        </fieldset>
                         <div class="cleaner"></div>
                    </div>


                        <div class="line"></div>

                        <div id="rehearsingMenuBar" class="clearfix">

                            <input type="button" class="button getFocus" value="Kontrola" onclick="showResult(); speech('${request.phrase.textToSpeech()}');" />

                            <form action="/fraze/preference/save" method="post">
                                <input type="hidden" name="phrase" value="${request.phrase.id}" />
                                <input type="hidden" name="preference" value="${request.preference.id}" />
                                <input type="hidden" name="success" value="true" />
                                <input type="submit" class="button" value="Dobře" />
                            </form>
                       
                            <form action="/fraze/preference/save" method="post">
                                <input type="hidden" name="phrase" value="${request.phrase.id}" />
                                <input type="hidden" name="preference" value="${request.preference.id}" />                             
                                <input type="submit" class="button" value="Špatně" />
                            </form>
                           
                            <%if(request.phrase.owner.equals(user)){%>
                                <a href="/fraze/edit/${request.phrase.id}">upravit</a> |
                            <%}%>
                            <a href="/fraze/remove/${request.phrase.id}">odstranit</a>


                        </div>

                        <div id="mp3Player"></div>
                             
                </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

             <div id="local">
                <div class="space">
                    <% include '/WEB-INF/includes/phrase_local_navigation.gtpl' %>

                    <div class="block corner">
                        <% include '/WEB-INF/includes/phrase_tags.gtpl' %>
                    </div> <!-- class="block" -->

                </div> <!-- id="space" -->
               <hr />
             </div> <!-- id="main" -->

        </div>  <!-- id="content" -->

        <% include '/WEB-INF/includes/footer.gtpl' %>

      </div> <!-- id="page" -->
           
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/swfobject/2.2/swfobject.js"></script>
    </body>
</html>


