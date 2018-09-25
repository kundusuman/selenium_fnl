
import java.io.File;

import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class SimpleSuggestionService {
    
    public static void main(String[] args) throws Exception {
        
        File dir = new File("c:/spellchecker/");
        
        Directory directory = FSDirectory.open(dir);
        
        SpellChecker spellChecker = new SpellChecker(directory);
        
        spellChecker.indexDictionary(
             new PlainTextDictionary(new File("c:/fulldictionary00.txt")));
        
        String wordForSuggestions = "hwllo";
        
        int suggestionsNumber = 5;

        String[] suggestions = spellChecker.
            suggestSimilar(wordForSuggestions, suggestionsNumber);

        if (suggestions!=null && suggestions.length>0) {
            for (String word : suggestions) {
                System.out.println("Did you mean:" + word);
            }
        }
        else {
            System.out.println("No suggestions found for word:"+wordForSuggestions);
        }
            
    }

}