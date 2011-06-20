<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická nepravidelná slovesa - ${ (request.tag) ? cz.kibo.wordbook.constant.Constant.IVERB_TAGS.get(params.tag) : 'Moje knihovna' } | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická nepravidelná slovesa."/>
        <meta name="keywords" content="anglická nepravidelná slovesa"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css" media="screen,handheld,projection,tv"/>
        <link rel="stylesheet" type="text/css" href="/css/print.css" media="print"/>
    </head>
    <body id="iVerbPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/nepravidelna_slovesa.html">Nepravidelná slovesa</a> &gt; ${ (request.tag) ? cz.kibo.wordbook.constant.Constant.IVERB_TAGS.get(params.tag) : 'Moje knihovna' } (${request.iverbs.size()}) </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">
                    
                    <table class="tablesorter">
                        <thead>
                            <tr>
                                <th>Český význam</th>
                                <th>Infinitiv</th>
                                <th>Minulý čas</th>
                                <th>Příčestí minulé</th>
                                <th class="noPrint">Hodnocení</th>
                                <th class="noPrint">Akce</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% request.iverbs.each(){ iverb -> %>
                                <tr>
                                    <td>${iverb.infinitiveCs}</td>
                                    <td>${iverb.infinitiveEn}</td>
                                    <td>${iverb.pastSimple}</td>
                                    <td>${iverb.pastParticiple}</td>
                                    <td class="noPrint">${iverb.rating()}</td>
                                    <td class="noPrint">

                                        <%if(request.tag){%>
                                            <a href="/nepravidelna_slovesa/knihovna/add/${iverb.id}"  >přidej do knihovny</a>
                                        <%}else{%>

                                                <%if(iverb.owner.equals(user)){%>
                                                    <a href="/nepravidelna_slovesa/edit/${iverb.id}">upravit</a>
                                                <%}else{%>
                                                    upravit
                                                <%}%>
                                                |
                                                <a href="/nepravidelna_slovesa/remove/${iverb.id}" onclick="return confirm('Smazat sloveso?')" >odstranit</a>
                                        <%}%>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>

                    </table>


               <div class="right">
                    <input type="button" class="button noPrint"  value="Tisk" onclick="window.print();"/>
               </div>

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
      <script type="text/javascript" src="/js/jquery.tablesorter.js"></script>
      <script type="text/javascript" src="/js/main.js"></script>

      
      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>