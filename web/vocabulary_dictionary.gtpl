<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická slovíčka - slovník | drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická slovíčka."/>
        <meta name="keywords" content="anglická slovíčka"/>        
        <meta name="robots" content="all, follow"/>      
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript" src="/js/main.js"></script>

    </head>
    <body id="vocabularyPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/slovicka.html">Slovíčka</a> &gt; Nové slovíčko </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">
                      <form action="/slovicka/slovnik/hledej" method="post">
                           <fieldset class="corner">
                                <legend class="corner">Vyhledávání</legend>
                                <p>
                                    <label>Slovo</label>
                                    <input name="q" class="getFocus searchBox corner" type="text" maxlength="30" autocomplete="off" />

                                    <label><input type="radio" name="lang" value="en" checked="checked" />en</label>
                                    <label><input type="radio" name="lang" value="cs" />cs</label>
                                </p>
                            </fieldset>
                            <div class="right">
                                <input class="button" type="submit" value="Hledej ve slovníku" />
                            </div>
                      </form>

                     <% if( request.vocabulary != null) { %>
                        <div class="line"></div>
                            <h4>${request.vocabulary.source} <span>(${request.vocabulary.lang})</span></h4>

                            <form action="/slovicka/save" method="post">
                                <ol>
                                    <% request.vocabulary.entries.each(){ term -> %>
                                        <li><label><input type="checkbox" name="entries" value="${term}" /> ${term}</label></li>
                                    <%}%>
                                </ol>

                                <div class="right">
                                    <input type="hidden" name="source" value="${request.vocabulary.source}" />
                                    <input type="hidden" name="lang" value="${request.vocabulary.lang}" />
                                    <input class="button" type="submit" value="Přidej do knihovny" />
                                </div>
                            </form>

                            <% if( !request.vocabulary.getRelated().isEmpty() ){ %>
                                <div class="line"></div>
                                <h4>Fráze</h4>
                                <form action="/fraze/knihovna/add" method="post">
                                    <ol>
                                        <% request.vocabulary.getRelated().each(){ key, value -> %>
                                            <li><label><input type="checkbox" name="phrases" value="${value}&${key}" />${key} <span>- ${value}</span></label></li>
                                        <%}%>
                                    </ol>
                                    <div class="right">
                                        <input type="hidden" name="tags" value="${cz.kibo.wordbook.constant.Constant.PHRASE_TAG_SLOVNI_SPOJENI}" />
                                        <input type="submit" class="button" value="Přidej do knihovny" />
                                    </div>
                                </form>                            
                            <%}%>
                    <%}%>
                     
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

    </body>
</html>



