package it.jugtofunprog.textanalysis;

import it.jugtofunprog.textanalysis.model.AnalyzedText;
import it.jugtofunprog.textanalysis.model.Annotation;
import it.jugtofunprog.textanalysis.model.Entity;
import it.jugtofunprog.textanalysis.model.Mood;
import it.jugtofunprog.textanalysis.model.Polarity;

import java.util.List;
import java.util.Map;

public class JavaAnalyzedTextProcessor implements AnalyzedTextProcessor {

    @Override
    public Mood extractMood(final AnalyzedText analyzedText) {
        List<Annotation> annotations = analyzedText.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Polarity) {
                Polarity pol = (Polarity) annotation;
                return pol.getMood();
            }
        }
        return Mood.NONE;
    }

    @Override
    public Map<Integer, Annotation> indexPersons(AnalyzedText analyzedText) {
        // TODO your code here
        return null;
    }



}
