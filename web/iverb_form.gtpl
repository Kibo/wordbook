<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická nepravidelná slovesa - Nové sloveso | drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická nepravidelná slovesa."/>
        <meta name="keywords" content="anglická nepravidelná slovesa"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript" src="/js/main.js"></script>
    </head>
    <body id="iVerbPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/nepravidelna_slovesa.html">Nepravidelná slovesa</a> &gt; Nové sloveso</h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <% if (request.message) {%>
                    <div class="errors">
                        <ul>
                            <li>Nevyplnily jste všechna povinná pole: <em>Infinitiv</em>, <em>Minulý čas</em>, <em>Příčestí minulé</em>, <em>Český význam</em>, </li>
                        </ul>
                    </div>
                    <% } %>
                 
                    <form action="/nepravidelna_slovesa/save" method="post">

                        <fieldset class="corner">
                        <legend class="corner">Nepravidelné sloveso</legend>
                            <p>
                                <label class="label" for="infinitiveCs">Český význam</label>
                                <input type="text" class="getFocus" name="infinitiveCs" value="${request.iverb.infinitiveCs}" maxlength="30" />
                            </p>
                            <p>
                                  <label class="label" for="infinitiveEn">Infinitiv</label>
                                  <input type="text" name="infinitiveEn" value="${request.iverb.infinitiveEn}" maxlength="30" />
                            </p>
                            <p>
                                <label class="label" for="pastSimple">Minulý čas</label>
                                <input type="text" name="pastSimple" value="${request.iverb.pastSimple}" maxlength="30" />
                            </p>
                            <p>
                                <label class="label" for="pastParticiple">Příčestí minulé</label>
                                <input type="text" name="pastParticiple" value="${request.iverb.pastParticiple}" maxlength="30" />
                            </p>
                        </fieldset>
                      
                        <fieldset class="corner">
                        <legend class="corner">Tagy</legend>
                            <p>
                                <% cz.kibo.wordbook.constant.Constant.IVERB_TAGS.each(){ k,v -> %>
                                    <label>
                                        <input type="radio" name="tags" value="${k}" ${ (request.iverb.tags != null && request.iverb.tags.contains( k )) ? "checked=\"checked\"" :  '' }   />${v}
                                    </label>
                                <% } %>
                            </p>
                        </fieldset>
                        <input type="hidden" name="id" value="${request.iverb.id}" />

                        <div class="right">
                            <input type="submit" value="Uložit" class="button" />
                        </div>

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

    </body>
</html>



