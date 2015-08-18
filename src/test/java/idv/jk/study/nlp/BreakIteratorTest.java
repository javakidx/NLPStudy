package idv.jk.study.nlp;

import org.junit.Test;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by bioyang on 15/8/19.
 */
public class BreakIteratorTest
{
    private static final String TEST_STRING = "This is a sentence. It has fruits, vegetables, etc. " +
            "but does not have meat.   Mr. Smith went to Washington";
    @Test
    public void testSentenceDetection()
    {
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(Locale.US);

        sentenceIterator.setText(TEST_STRING);

        int start = sentenceIterator.first();
        int end = -1;

        List<String> sentenceList = new ArrayList<String>();

        while((end = sentenceIterator.next()) != BreakIterator.DONE)
        {
            String sentence = TEST_STRING.substring(start, end);
            start = end;
            sentenceList.add(sentence);

            System.out.println("Sentence: " + sentence);
        }
    }
}
