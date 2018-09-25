import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellRequest;
import org.xeustechnologies.googleapi.spelling.SpellResponse;

/**
 * Created by ahmedengu.
 */
public class Client {

    private static Oxford oxford;

    public static void main(String[] args) {
    	 SpellChecker checker = new SpellChecker();

    	 SpellResponse spellResponse = checker.check( "helloo worlrd" );

    	 for( SpellCorrection sc : spellResponse.getCorrections())
    	 {
    		 System.out.println( sc.getValue());
    	}

//    	// This will print all the corrections available for the text "helloo worlrd".
//
//    	// It is also possible to set more options to the request, here is a meatier example.
//
//    	 ``` // Proxy settings Configuration config = new Configuration(); config.setProxy( "my_proxy_host", 8080, "http" );

//    	 SpellChecker checker = new SpellChecker( config ); checker.setOverHttps( true ); // Use https (default true from v1.1) checker.setLanguage( Language.ENGLISH ); // Use English (default)
//
//    	 SpellRequest request = new SpellRequest(); request.setText( "helloo helloo worlrd" ); request.setIgnoreDuplicates( true ); // Ignore duplicates
//
//    	 SpellResponse spellResponse = checker.check( request );
//
//    	 for( SpellCorrection sc : spellResponse.getCorrections() ) System.out.println( sc.getValue() ); 
    }

}