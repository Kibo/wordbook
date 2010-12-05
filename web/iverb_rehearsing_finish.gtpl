<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglická nepravidelná slovesa - Procvičování | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická nepravidelná slovesa."/>
        <meta name="keywords" content="anglická nepravidelná slovesa"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    </head>
    <body id="iVerbPage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/nepravidelna_slovesa.html">Nepravidelná slovesa</a> &gt; Procvičování </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <h4>Nemáte slovesa k procvičení.</h4>
                   <img src="/images/monkey4.jpg" class="img" width="300" height="200"   alt="anglická slovíčka" title="anglická slovíčka" />


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

      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>



