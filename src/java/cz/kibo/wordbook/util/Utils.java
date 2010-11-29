package cz.kibo.wordbook.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author kibo
 */
public final class Utils {

    private Utils(){}

    public static String getAsciiTitleFromRequest( HttpServletRequest req ){
        // from "/jsp/masinka_tomas.htm" return masinka_tomas
        String START = "/";
        String END = ".";
        return req.getServletPath().substring(req.getServletPath().lastIndexOf(START) + START.length(), req.getServletPath().lastIndexOf(END));
    }

     /**
     *
     * @param fileName - "myFile-123-ěšč-@-.jpg"
     * @return "myfile-123-esc.jpg"
     */
    public static String correctTextToAscii(String origText){

        String correctNameWithoutExtension = cutDashInStartAndEndSentence(
                                                cutDashes(
                                                    replaceSpecialChars(
                                                        convertToAscii(origText))));

        return (correctNameWithoutExtension).toLowerCase();
    }



    /**
     * Cut HTML tags from html code
     * @param text text HTML code
     * @param numberOFChars - when is 0 then parse all text
     * @return text without HTML code with length = numberOFChars,
     */
    public static String cutHtmlTags(String text, int numberOfChars){
        if (text.length() == 0)
            return text;

        StringBuffer result = new StringBuffer(200);
        int openParenthesis = 0;
        int closetParenThesis = 0;

        while ((openParenthesis = text.indexOf("<")) != -1){
                result.append(text.substring(0, openParenthesis));
                closetParenThesis = text.indexOf(">") + 1;
                text = text.substring(closetParenThesis);

                if (numberOfChars != 0 && result.length() >= numberOfChars)
                    break;
        }

        if (result.length() == 0)
            result.append(text);

        int countOfChars = (result.length() >= numberOfChars) ? numberOfChars : (result.length());
        return (numberOfChars == 0) ? result.toString() : result.substring(0, countOfChars); //============>
    }


    private static String date2GMT(Date date){
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format( date  ) + " GMT";
    }

    private static String czechDateTime(Date date){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return df.format( new Date() );
    }

    //#######################################
    /*
     * Take out punctuation from input text
     * @return text without punctuation
     */
    public static String convertToAscii(String text){
        return Normalizer.normalize(text, Form.NFD).replaceAll("[^\\p{ASCII}]","");
    }

    public static String convertToLowerCase(String text){
        return text.toLowerCase();
    }

    // replase all special chars to [-]
    // let only [0-9] [a-b] [_] [-]
    public static String replaceSpecialChars(String text){
        return text.replaceAll("[^\\w_]", "-");
    }

    //cut 2 and more [-] side-by-side
    public static String cutDashes(String text){
        return text.replaceAll("-{2,}", "-");
    }

    public static String cutDashInStartAndEndSentence(String text){
        text = text.replaceAll("^-", "");
        return text.replaceAll("-$", "");
    }


      //####################  TEST  #########################
    public static void main(String[] args){
        String text = convertToAscii("-Tomáš Jurmaněščřřř?!!!!!! 78_9!!!-");
        System.out.println( text );

        text = convertToLowerCase(text);
        System.out.println( text );

        text = replaceSpecialChars(text);
        System.out.println( text );

        text = cutDashes(text);
        System.out.println( text );

        text = cutDashInStartAndEndSentence(text);
        System.out.println( text );

        String str = "<p>Slovo <h3>slovo</h3> slovo, <strong>slovo</strong>. </p>";
	System.out.println(cutHtmlTags(str, 0));
	System.out.println(cutHtmlTags(str, 100));

        String str2 = "Slovo slovo slovo, slovo";
	System.out.println(cutHtmlTags(str2, 0));
	System.out.println(cutHtmlTags(str2, 100));


        String str3 = "Finanční účetnictví I. - demo";
        System.out.println( str3 );
        System.out.println( correctTextToAscii(str3) );

        System.out.println(  date2GMT(new Date()) );

    }
    
}
