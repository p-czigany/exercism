import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

class ProteinTranslator {

    private static final List<String> stopCodons = List.of("UAA", "UAG", "UGA");
    private static final Map<String, String> sequences = Map.ofEntries(
            entry("AUG", "Methionine"),
            entry("UUU", "Phenylalanine"),
            entry("UUC", "Phenylalanine"),
            entry("UUA", "Leucine"),
            entry("UUG", "Leucine"),
            entry("UCU", "Serine"),
            entry("UCC", "Serine"),
            entry("UCA", "Serine"),
            entry("UCG", "Serine"),
            entry("UAU", "Tyrosine"),
            entry("UAC", "Tyrosine"),
            entry("UGU", "Cysteine"),
            entry("UGC", "Cysteine"),
            entry("UGG", "Tryptophan")
    );

    List<String> translate(String rnaSequence) {
        List<String> results = new ArrayList<>();
        StringBuilder remainingSequence = new StringBuilder(rnaSequence);
        while (remainingSequence.length() >= 3) {
            String subSequence = remainingSequence.substring(0, 3);
            remainingSequence.delete(0, 3);
            if (stopCodons.contains(subSequence)) break;
            results.add(sequences.get(subSequence));
        }
        return results;
    }
}
