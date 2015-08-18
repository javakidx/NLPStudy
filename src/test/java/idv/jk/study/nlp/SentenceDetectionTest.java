package idv.jk.study.nlp;

import com.tamingtext.TamingTextTestJ4;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by bioyang on 15/8/19.
 *
 * http://opennlp.sourceforge.net/models-1.5/
 */
public class SentenceDetectionTest extends TamingTextTestJ4
{
    @Test
    public void testOpenNLP() throws Exception {

        File modelDir = getModelDir();

        //<start id="openSentDetect"/>
        //... Setup the models
        File modelFile = new File(modelDir, "en-sent.bin");
        InputStream modelStream = new FileInputStream(modelFile);
        SentenceModel model = new SentenceModel(modelStream);
        SentenceDetector detector = //<co id="openSentDetect.co.detect"/>
                new SentenceDetectorME(model);
        String testString = "This is a sentence. It has fruits, vegetables," +
                " etc. but does not have meat. Mr. Smith went to Washington.";
        String[] result = detector.sentDetect(testString); //<co id="openSentDetect.co.run"/>
        for (int i = 0; i < result.length; i++) {
            System.out.println("Sentence: " + result[i]);
        }
    /*<calloutlist>
        <callout arearefs="openSentDetect.co.detect"><para>Create the <command>SentenceDetector</command> with the en-sent.bin model</para></callout>
        <callout arearefs="openSentDetect.co.run"><para>Invoke the detection process</para></callout>
    </calloutlist>*/
        //<end id="openSentDetect"/>
        assertTrue("result Size: " + result.length + " is not: " + 3, result.length == 3);
    }
}
