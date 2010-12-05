<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglické fráze - nová fráze | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglické fráze."/>
        <meta name="keywords" content="anglické fráze"/>
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>
        <script type="text/javascript" src="/js/fckeditor/fckeditor.js"></script>
       
        <script type="text/javascript">
            window.onload = function(){
                var frontFCKeditor = new FCKeditor( 'front' ) ;
                frontFCKeditor.ToolbarSet = 'Basic' ;
                frontFCKeditor.ReplaceTextarea() ;

                var backFCKeditor = new FCKeditor( 'back' ) ;
                backFCKeditor.ToolbarSet = 'Basic' ;
                backFCKeditor.ReplaceTextarea() ;

                var gramarFCKeditor = new FCKeditor( 'gramar' ) ;
                gramarFCKeditor.ToolbarSet = 'Basic' ;
                gramarFCKeditor.ReplaceTextarea() ;               
            }
        </script>

    </head>
    <body id="phrasePage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; <a href="/fraze.html">Fráze</a> &gt; Nová fráze </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <% if (request.message) {%>
                    <div class="errors">
                        <ul>
                            <li>Nevyplnily jste všechna povinná pole: <em>České znění fráze</em>, <em>Anglická fráze </em>, <em>Tag</em></li>
                        </ul>
                    </div>
                    <% } %>

                    <form action="/fraze/save" method="post">

                        <fieldset class="corner">
                        <legend class="corner">Fráze</legend>

                        <p>
                            <label>České znění fráze
                                <textarea id="front" name="front">${ (request.phrase.front != null) ? request.phrase.front.value : ''}</textarea>                                                             
                            </label>
                        </p>
                        <p>
                            <label>Anglická fráze
                                <textarea id="back" name="back">${ (request.phrase.back != null) ? request.phrase.back.value : ''}</textarea>                              
                            </label>                            
                        </p>
                        <p>
                            <label>Gramatika použitá ve frázi
                                <textarea id="gramar" name="gramar">${ (request.phrase.gramar != null) ? request.phrase.gramar.value : ''}</textarea>                       
                            </label>                            
                        </p>
                        </fieldset>

                        <fieldset class="corner">
                        <legend class="corner">Tagy</legend>
                            <p>
                                <% cz.kibo.wordbook.constant.Constant.PHRASE_TAGS.each(){ k,v -> %>
                                    <label>
                                        <input type="checkbox" name="tags" value="${k}" ${ (request.phrase.tags != null && request.phrase.tags.contains( k )) ? "checked=\"checked\"" :  '' }   />${v}
                                    </label>
                                <% } %>
                            </p>
                        </fieldset>
                        <input type="hidden" name="id" value="${request.phrase.id}" />
                        
                        <div class="right">
                            <input type="submit" value="Uložit" class="button" />
                        </div>

                    </form>
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

      <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>



