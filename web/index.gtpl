<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Nepravidelná slovesa, anglické fráze, drilování slovíček | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglická slovíčka, anglické fráze a anglická nepravidelná slovesa."/>
        <meta name="keywords" content="dril, anglická nepravidelná slovesa, anglické fráze, drilování, anglická slovíčka"/>
        <meta name="robots" content="all, follow"/>
        <meta name="google-site-verification" content="eJfaH0t3DL3_lO1GabBvaub3hO5ovR2mPGyrI4ABSwQ" />        
        <link href='http://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css' />
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
        <style type="text/css">
            #main{
                width:100%;
            }


            dl{
                margin-bottom: 1em;
            }

            dt{
                font-size: 300%;
                padding: 0.5em 0.5em;
                background:#eee;
                margin-bottom:0.3em;
                color:green;               
            }

            dd.text{              
                line-height: 79px;
                margin-bottom: 1px;
                font-size: 150%;

            }      
        </style>
    </head>
    <body>
      <div id="page">
        
        <% include '/WEB-INF/includes/header.gtpl' %>
       
        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb">Home</h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <dl>
                        <dt class="corner">Drilujte s námi angličtinu</dt>
                        <dd class="picture"> <img src="/images/monkey13.jpg" class="toLeft img" width="400" alt="www.drilujeme.cz" title="anglická slovíčka, anglické fráze, nepravidelná slovesa" /></dd>
                        <dd class="text color1 corner">Anglická <strong><a href="/slovicka.html">slovíčka</a></strong></dd>
                        <dd class="text color2 corner">Anglické <strong><a href="/fraze.html">fráze</a></strong></dd>
                        <dd class="text color3 corner">Anglická <strong><a href="/nepravidelna_slovesa.html">nepravidelná slovesa</a></strong></dd>
                    </dl>

                    <div class="clearfix"></div>
                 
                     <div style="padding:1em; background:#eee; margin-bottom: 1em;" class="corner">
                        <h4>Co k tomu potřebujete?</h4>

                        <p>
                            <a href="/login" class="button toRight" style="font-size: 150%;">Přihlásit nebo registrovat</a>
                            <strong>Drilujeme využívá Google account</strong>. Díky tomu můžete používat Knihovnu frází, slovíček a nepravidelných sloves nezávisle na ostatních uživatelích.
                        </p>
                        <div class="clearfix"></div>
                    </div>

               <div class="clearfix"></div>

                     <div style="width:49%; float:left; background:#eee;" class="corner">
                         <div style="padding:1em">
                            <img src="/images/monkey1.jpg" class="toLeft img" width="150" height="150"  alt="www.drilujeme.cz" title="anglická slovíčka, anglické fráze, nepravidelná slovesa" />
                            <h4>Drilujeme</h4>
                            <p><strong>Pravidelným opakováním</strong> udržíte v paměti <strong>slovíčka</strong>, <strong>fráze</strong> i <strong>nepravidelná slovesa</strong>.</p>
                            <div class="clearfix"></div>
                        </div>
                     </div>

                    <div style="width:50%; float:right; background:#eee;" class="corner">
                             <div style="padding:1em">
                                <img src="/images/monkey2.jpg" class="toLeft img" width="150" height="150"  alt="www.drijume.cz" title="anglická slovíčka, anglické fráze, nepravidelná slovesa" />
                                <h4>Je zdarma</h4>
                                <p>Drilujeme <strong>je zdarma</strong> a nabízí několik nástrojů pro <strong>automatické drilování</strong>.</p>
                                <div class="clearfix"></div>
                            </div>
                    </div>

                   <div class="clearfix"></div>
                              
             </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

        </div>  <!-- id="content" -->
        
        <% include '/WEB-INF/includes/footer.gtpl' %>

      </div> <!-- id="page" -->

    <% include '/WEB-INF/includes/gaq.gtpl' %>

    <%       
        //defaultQueue.add countdownMillis: 5000, url: "/index.gtpl", method: 'PUT'
        //log.warning "GO-TASK"
    %>
    </body>
</html>



