<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Anglické fráze | www.drilujeme.cz</title>
        <meta name="description" content="Drilujte s námi anglické fráze."/>
        <meta name="keywords" content="anglické fráze"/>

        <meta name="robots" content="all, follow"/>        
        <link rel="stylesheet" type="text/css" href="/css/main.css"/>   
    </head>
    <body id="phrasePage">
      <div id="page">

        <% include '/WEB-INF/includes/header.gtpl' %>

        <div id="bar" class="clearfix corner">
            <% include '/WEB-INF/includes/nav.gtpl' %>
            <h3 id="breadcrumb"><a href="/">Home</a> &gt; Fráze </h3>
        </div> <!-- id="bar" -->

         <div id="content" class="clearfix">

              <div id="main">
                <div class="space">

                    <div class="toRight">
                        <object width="300" height="250"><param name="movie" value="http://www.youtube.com/v/dmdLyThTKbE?fs=1&amp;hl=cs_CZ&amp;rel=0"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/dmdLyThTKbE?fs=1&amp;hl=cs_CZ&amp;rel=0" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="300" height="250"></embed></object>
                    </div>

                    <h4>Jak na to</h4>
                    <p>Nástroj Anglické fráze slouží ke <strong>drilování anglických frází</strong>.


                       Při čtení anglických textů, nebo studiu obtížné anglické gramatiky narázíte na <strong>opakující se fráze</strong> nebo <strong>slovní spojení</strong>.
                       Vytvořte si z těchto frází knihovnu, a nechávejte se <strong>pravidelně přezkoušet</strong>.
                     
                    </p>

                    <p>Více se o používání nástroje <strong>Anglické fráze</strong> dočtete v <a href="#" onclick="showHelp();">nápovědě</a>.</p>

                    <div class="cleaner"></div>

                    <div class="help hidden">
                
                    <div class="line"></div>
                    <h4 id="nova_fraze">Vytvoření nové fráze</h4>
                     <p>Každá fráze se skládá ze tří polí.</p>
                        <ol>
                                <li><em>České znění fráze</em></li>
                                <li><em>Anglická fráze</em></li>
                                <li><em>Použitá gramatika</em></li>
                        </ol>


                        <p>Políčko <em>České znění fráze</em> musí obsahovat <strong>český překlad anglické fráze</strong>.
                        Pouze toto políčko se Vám zobrazí při procvičování. Na základě tohoto políčka budete odpovídat anglickou frází.</p>

                        <p>Políčko <em>Anglická fráze</em> musí obsahovat anglický text, tedy <strong>anglickou frázy, kterou hodláte procvičovat</strong>.</p>

                        <p>Do políčka <em>Použitá gramatika</em> můžete vložit text, který Vám později připomene gramatiku používanou v anglické frázi.</p>

                        <img src="/images/form.png" width="500" height="371" alt="formulář - nová fráze" />


                        <h4>Příklad</h4>

                        <p>V anglické knize jsem našel tuto anglickou větu: <q>I arrived in Prague at 9.</q> Věta se mi líbila natolik, že jsem se rozhodl vložit ji jako novou frázi do nástroje Fráze.</p>

                        <ol>
                        <li>Po kliknutí na tlačítko <em>Nová fráze</em> se mi objevil formulář se třemi poli.</li>
                        <li>Do prvního pole<em> České znění fráze </em>jsem vložil překlad anglické fráze: <q>Dorazil jsem do Prahy v devět.</q></li>

                        <li>Do druhého políčka <em>Anglická fráze</em>  jsem vložil samotnou anglickou větu: <q>I arrived in Prague at 9.</q></li>

                        <li>Do třetího políčka <em>Použitá gramatika</em> jsem si vložil poznámky: <q>Ačkoli sloveso ARRIVE popisuje pohyb, neváže se s 'pohybovou' předložkou TO.</q>
                        </li>
                        <li>Před kliknutím na tlačítko uložit jsem ještě zaškrtnul tag <em>předložky</em>. Naznačil jsem tak ostatním studentům, kteří by se rozhodli novou frázi používat, jakého gramatického jevu se anglická fráze týká.
                        </li>
                        <li>Po kliknutí na tlačítko uložit se nová fráze objevila v <em>mé knihovně frází</em>.</li>
                        </ol>

                        <div class="line"></div>
                            <h4 id="procvicovani">Procvičování</h4>

                            <p>Nástroj fráze sestavuje sadu frází k procvičování <strong>z Vaší knihovny frází</strong>.
                            Před procvičováním je tedy nutné nejprve do knihovny <a href="#nova_fraze">vložit fráze</a>.</p>

                            <p>Každá fráze se skládá ze <a href="#nova_fraze">tří polí</a>.</p>
                            <ol>
                                    <li>Při procvičování se vždy nejprve zobrazí pouze pole <em>České znění fráze</em>.</li>
                                    <li>Předpokládá se, že si v duchu nebo nahlas<strong> vyslovíte anglickou frázi</strong> a následně kliknete na tlačítko <em>Kontrola</em>.</li>
                                    <li>Teprve nyní se zobrazí další dvě pole a Vy máte možnost sebehodnocení tlačítkem<em> Špatně</em>, nebo tlačítkem <em>Dobře</em>.</li>
                            </ol>


                            <p>Tímto způsobem procvičíte celou sadu frází. Další sada frází k procvičování pro Vás bude připravena <strong>až další den</strong>.
                            Nezapomeňte si ji tedy vyzvednout.</p>
                            <p>
                            Pro efektivní procvičování je nutné <strong>neustále budouvat Vaši knihovnu frází</strong>.
                            Při čtení anglických textů nebo při studiu anglické gramatiky pravidelně ukládejte fráze, texty, věty, které Vás něčím zaujaly do Vaší knihovny frází.
                            Jedině tak bude možné naplno využít nástroj Fráze. </p>



                            <img src="/images/fraze2.png"  width="500" height="160" alt="České znění fráze" />


                            <div class="line"></div>
                            <img src="/images/knihovna.png" class="toRight" width="500" height="223" alt="Moje knihovna" />
                            <h4 id="knihovna">Moje knihovna</h4>

                            <p>Knihovna obsahuje Vaše anglické fráze. Knihovnu frází byste měli neustále doplňovat.
                            Do knihovny frází si ukládejte slovní spojení, fráze a anglické věty, které Vás něčím zaujaly při studiu angličtiny.
                            Čím více kvalitně zpracovaných frází do <em>Knihovny</em> vložíte, tím větší užitek Vám přinese <a href="#procvicovani">Procvičování</a> frází.</p>


                            <p>Fráze v knihovně můžete kdykoliv upravovat. Dobře naučené fráze můžete z knihovny odebrat.</p>



                            <div class="line clearfix"></div>

                        <h4 id="tagy">Tagy</h4>
                        <img src="/images/tagy.png" class="toRight"  width="290" height="149" alt="Tagy" />


                        <p>Tag slouží k označení frází. Naznačíme tak, do jakého gramatického jevu fráze patří.
                        Správně označenou frází pomůžeme ostatním studentům při vyhledávání frází (například jen frází, které se týkají předložek).</p>

                        <p>Fráze, které patří do dané skupiny, zobrazíte kliknutím na název tagu. Takto zobrazené fráze můžete přidávat do V<em>aší knihovny</em>.</p>
                    </div>

                    <div class="line cleaner"></div>
                    <h3>Sdělte nám Váš názor</h3>
                    <div id="fb-root"></div><script src="http://connect.facebook.net/cs_CZ/all.js#appId=171871726186416&amp;xfbml=1"></script><fb:comments xid="171871726186416" numposts="10" width="810" publish_feed="true"></fb:comments>
                    
                </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

             <div id="local">
                <div class="space">

                <% include '/WEB-INF/includes/phrase_local_navigation.gtpl' %>

                <div class="block corner">
                    <% include '/WEB-INF/includes/phrase_tags.gtpl' %>
                </div> <!-- class="block" -->

               <% include '/WEB-INF/includes/advertisement.gtpl' %>
              
                </div> <!-- id="space" -->
               <hr />
              </div> <!-- id="main" -->

        </div>  <!-- id="content" -->
       

        <% include '/WEB-INF/includes/footer.gtpl' %>

      </div> <!-- id="page" -->

       <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
        <script type="text/javascript" src="/js/main.js"></script>

        <% include '/WEB-INF/includes/gaq.gtpl' %>
    </body>
</html>



