<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická slovíčka | drilujeme.cz</title>
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
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; Slovíčka </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">
                    <img src="/images/monkey3.jpg" class="toRight img" width="200" height="150"  alt="anglická slovíčka" title="anglická slovíčka" />
                    <h4>Popis nástroje Anglická slovíčka</h4>
                    <p>Nástroj Anglická slovíčka slouží ke <strong>drilování anglických slovíček</strong>. Pomocí zabudovaného <a href="/slovicka/slovnik">anglicko-českého slovníku</a> objevíte množství významů anglických slov.
                       Jediným kliknutím přidáte anglické slovíčko do <strong>knihovny slovíček</strong>.
                       Nechávejte se <strong>pravidelně přezkoušet</strong> z anglických slovíček uložených ve Vaší <strong>knihovně slovíček</strong>.
                       
                    </p>

                    <p>Více se o používání nástroje <strong>Anglická slovíčka</strong> dočtete v <a href="#" onClick="showHelp();">nápovědě</a>.</p>

                    <div class="cleaner"></div>
                    <div class="help hidden">
                    <div class="line"></div>
                    <p>Na nápovědě se pracuje. Děkujeme za pochopení.</p>
                    
                    </div>


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

    </body>
</html>



