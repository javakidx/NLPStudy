package idv.jk.study.nlp;

import com.tamingtext.TamingTextTestJ4;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by bioyang on 15/8/18.
 */
public class POSTaggerTest extends TamingTextTestJ4
{
    @Test
    public void testPOS() throws IOException
    {
        File posModelFile = new File( //<co id="opennlpPOS.co.tagger"/>
                getModelDir(), "en-pos-maxent.bin");
        FileInputStream posModelStream = new FileInputStream(posModelFile);
        POSModel model = new POSModel(posModelStream);

        POSTaggerME tagger = new POSTaggerME(model);
        String[] words = SimpleTokenizer.INSTANCE.tokenize( //<co id="opennlpPOS.co.tokenize"/>
                "The quick, red fox jumped over the lazy, brown dogs.");
        String[] result = tagger.tag(words);//<co id="opennlpPOS.co.dotag"/>
        for (int i=0 ; i < words.length; i++) {
            System.err.print(words[i] + "/" + result[i] + " ");
        }
        System.err.println("\n");


    }
}
