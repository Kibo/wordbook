<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická nepravidelná slovesa - Procvičování | drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická nepravidelná slovesa."/>
        <meta name="keywords" content="anglická nepravidelná slovesa"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>        
    </head>
    <body id="iVerbPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/nepravidelna_slovesa.html">Nepravidelná slovesa</a> &gt; Procvičování (${request.count}) </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <form action="/nepravidelna_slovesa/preference/save" method="post">
                    
                    <div class="monkey">
                         <fieldset>
                            <p>
                               <label>${request.iverb.infinitiveCs}</label>
                            </p>
                         </fieldset>
                         <div class="cleaner"></div>
                    </div>

                    <div class="student">
                        <fieldset>
                            <p>
                               <label for="infinitiveEnStudent" class="label" >Infinitiv</label>
                               <input type="text" id="infinitiveEnStudent" name="infinitiveEnStudent" value="${request.iverb.infinitiveEnStudent}" class="getFocus corner" autocomplete="off"  />
                               <input type="hidden" id="infinitiveEn" name="infinitiveEn" value="${request.iverb.infinitiveEn}" />
                            </p>

                            <p>
                               <label for="infinitiveEnStudent" class="label" >Minulý čas</label>
                               <input type="text" id="pastSimpleStudent" name="pastSimpleStudent" value="${request.iverb.pastSimpleStudent}" class="corner" autocomplete="off"  />
                               <input type="hidden" id="pastSimple" name="pastSimple" value="${request.iverb.pastSimple}" />
                            </p>

                            <p>
                               <label for="infinitiveEnStudent" class="label" >Příčestí minulé</label>
                               <input type="text" id="pastParticipleStudent" name="pastParticipleStudent" value="${request.iverb.pastParticipleStudent}" class="corner" autocomplete="off" />
                                <input type="hidden" id="pastParticiple" name="pastParticiple" value="${request.iverb.pastParticiple}" />
                            </p>
                        </fieldset>
                        <div class="cleaner"></div>
                    </div>

                    <div class="monkey hidden">
                         <fieldset>
                            <p>
                               <label>
                                   ${request.iverb.infinitiveEn}, ${request.iverb.pastSimple}, ${request.iverb.pastParticiple}
                               </label>
                            </p>
                         </fieldset>
                         <div class="cleaner"></div>
                    </div>


                   <div class="line"></div>
                        <div id="rehearsingMenuBar" class="clearfix">

                            <input type="button" class="button" value="Kontrola" onclick="showResultIVerbs(); speech('${request.iverb.textToSpeech()}');" />


                            <input type="hidden" name="iverb" value="${request.iverb.id}" />
                            <input type="hidden" name="preference" value="${request.preference.id}" />
                            <input type="submit" class="button" value="Daší" />

                            <%if(request.iverb.owner.equals(user)){%>
                                <a href="/nepravidelna_slovesa/edit/${request.iverb.id}">upravit</a> |
                            <%}%>
                            <a href="/nepravidelna_slovesa/remove/${request.iverb.id}">odstranit</a>

                        </div>
                        <div id="mp3Player"></div>
                    </form>
                </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

             <div id="local">
                <div class="space">
                    <% include '/WEB-INF/includes/iverb_local_navigation.gtpl' %>

                    <div class="block corner">
                        <% include '/WEB-INF/includes/iverb_tags.gtpl' %>
                    </div> <!-- class="block" -->

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



