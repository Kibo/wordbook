<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická slovíčka - úprava | www.drilujeme.cz</title>
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
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/slovicka.html">Slovíčka</a> &gt; Úprava </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">                                             
                    <h4>${request.vocabulary.source} <span>(${request.vocabulary.lang})</span></h4>
                        <form action="/slovicka/save" method="post">
                            <ol>
                                <% request.vocabulary.entries.eachWithIndex(){ term, idx -> %>
                                    <li>
                                        <input type="checkbox" name="entries" value="text${idx}" checked="checked" />
                                        <input type="text" name="text${idx}" value="${term}" maxlength="20" />
                                    </li>
                                <%}%>
                            </ol>

                            <div class="right">
                                <input type="hidden" name="id" value="${request.vocabulary.id}" />
                                <input type="hidden" name="source" value="${request.vocabulary.source}" />
                                <input type="hidden" name="lang" value="${request.vocabulary.lang}" />
                                <input class="button" type="submit" value="Uložit do knihovny" />
                            </div>
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

      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>
