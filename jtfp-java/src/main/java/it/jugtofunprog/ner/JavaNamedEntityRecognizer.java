package it.jugtofunprog.ner;

import it.jugtofunprog.ner.model.NamedEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JavaNamedEntityRecognizer implements NamedEntityRecognizer {

    private final NamedEntityRepository neRepo;

    public JavaNamedEntityRecognizer(NamedEntityRepository neRepo) {
        this.neRepo = neRepo;
    }

    @Override
    public Collection<NamedEntity> extractNamedEntities(List<String> tokens) {
        Collection<NamedEntity> nes = new ArrayList<>();

        for (String token : tokens) {
            Collection<NamedEntity> reconized = neRepo.recognize(token);
            nes.addAll(reconized);
        }
        return nes;
    }

    @Override
    public Collection<NamedEntity> extractNamedEntities(List<String> tokens, int ngramSize) {
        Collection<NamedEntity> nes = new ArrayList<>();

        List<String> nGrams = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            String token = "";
            int j = i;
            for (; j < tokens.size() ; j++) {
                token += tokens.get(j) + " ";
                if (j - i <= ngramSize-1) {
                    nGrams.add(token.trim());
                }
            }
        }

        nes.addAll(extractNamedEntities(nGrams));
        return nes;
    }

}
