$(document).ready(function() {
    
    $(".answer").addClass("hidden");
   
    $(".getFocus").focus();
   
     $(".tablesorter").tablesorter({
        // sort on the third column, order asc
        sortList: [[0,0]],
        widgets: ['zebra']       
        });    
  });

  function speech(speech){   
    var flashvars = {"file":"http://translate.google.com/translate_tts?tl=en%26q="+speech, "songVolume":"80", "showDownload":"false", "autoStart":"true"};
    var params = {};
    var attributes = {};
    swfobject.embedSWF("/swf/singlemp3player.swf", "mp3Player", "0", "0", "9.0.0","", flashvars, params, attributes);
  }

  function showResult(){
      $(".student").removeClass("hidden");
  }

  function showResultIVerbs(){
     
      $('[type=text]').attr( "readonly", "readonly" );
      $(".monkey").removeClass("hidden");

      checkAnswer( $("#infinitiveEnStudent"), $("#infinitiveEn")  )
      checkAnswer( $("#pastSimpleStudent"), $("#pastSimple")  )
      checkAnswer( $("#pastParticipleStudent"), $("#pastParticiple")  )          
  }

  function checkAnswer( student, teacher  ){     
    if ( jQuery.trim( student.attr("value") ) != jQuery.trim(teacher.attr("value")) ){
        student.addClass("false");
    }
  }

  function showResultVocabulary(){

       $('[type=text]').attr( "readonly", "readonly" );
       $(".monkey").removeClass("hidden");

       var entries = $("#entries").attr("value").split(",");

       for(var i = 0; i < entries.length; i++) {
           checkAnswerVocabulary( $("#entriesStudent" + i )  ,  entries);
       }     
  }

  function checkAnswerVocabulary( element ,entries){

      var value = jQuery.trim( element.attr("value"));
      var success = ( jQuery.inArray( value, entries) != -1 )
      if (!success){
            element.addClass("false");
      }
  }


  function addToLibrary( url ){
      //onClick="addToLibrary( '/fraze/knihovna/add/${params.tag}/${phrase.id}'); return false"
      $(".message").remove();

      $.get(url, function(data) {
          $(".tablesorter").before("<div class=\"message corner\">Přidáno do knihovny.</div>");
      });       
  }

  function showHelp(){
      $(".help").removeClass("hidden");
  }



  