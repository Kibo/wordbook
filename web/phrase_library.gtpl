<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglické fráze - ${ (request.tag) ? cz.kibo.wordbook.constant.Constant.PHRASE_TAGS.get(params.tag) : 'Moje knihovna' } | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglické fráze."/>
        <meta name="keywords" content="anglické fráze"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    </head>
    <body id="phrasePage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/fraze.html">Fráze</a> &gt; ${ (request.tag) ? cz.kibo.wordbook.constant.Constant.PHRASE_TAGS.get(params.tag) : 'Moje knihovna' } (${request.phrases.size()}) </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">
                                     
                    <table class="tablesorter">
                        <thead>
                            <tr>
                                <th>České znění fráze</th>
                                <th>Anglická fráze</th>
                                <th>Hodnocení</th>
                                <th>Akce</th>
                            </tr>
                        </thead>
                        
                         <tbody>
                            <% request.phrases.each(){ phrase -> %>
                                <tr>
                                    <td>${phrase.front.value}</td>
                                    <td>${phrase.back.value}</td>
                                    <td>${phrase.rating()}</td>
                                    <td>
                                        <%if(request.tag){%>
                                            <a href="/fraze/knihovna/add/${phrase.id}" >přidej do knihovny</a>
                                        <%}else{%>

                                                <%if(phrase.owner.equals(user)){%>
                                                    <a href="/fraze/edit/${phrase.id}">upravit</a>
                                                <%}else{%>
                                                    upravit
                                                <%}%>
                                                |
                                                <a href="/fraze/remove/${phrase.id}" onclick="return confirm('Smazat frázi?')" >odstranit</a>
                                       <%}%>
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

       <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
      <script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
      <script type="text/javascript" src="/js/main.js"></script>

      
      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>



