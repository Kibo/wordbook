<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická slovíčka - knihovna | www.drilujeme.cz</title>
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
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/slovicka.html">Slovíčka</a> &gt; Moje knihovna</h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <table class="tablesorter">
                        <thead>
                            <tr>
                                <th>Slovíčko</th>
                                <th>Význam</th>
                                <th>Jazyk</th>
                                <th>Akce</th>
                            </tr>
                        </thead>

                         <tbody>
                            <% request.vocabularies.each(){ vocabulary -> %>
                                <tr>
                                    <td>${vocabulary.source}</td>
                                    <td>
                                        <% vocabulary.entries.each(){ en ->  println en } %>
                                    </td>
                                    <td>${vocabulary.lang}</td>
                                    <td>
                                         <%if(vocabulary.owner.equals(user)){%>
                                            <a href="/slovicka/edit/${vocabulary.id}">upravit</a> |
                                         <%}%>

                                        <a href="/slovicka/remove/${vocabulary.id}" onclick="return confirm('Smazat slovíčko?')" >odstranit</a>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>

                    </table>


                </div> <!-- id="space" -->
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
      <script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
      <script type="text/javascript" src="/js/main.js"></script>

      
      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>



