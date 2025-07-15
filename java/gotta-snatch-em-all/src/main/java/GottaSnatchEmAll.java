import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(final List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(final String card, final Set<String> collection) {
        return !collection.contains(card) && collection.add(card);
    }

    static boolean canTrade(final Set<String> myCollection,
                            final Set<String> theirCollection) {
        final boolean myCollectionHasUniqueItems = myCollection.stream()
                .anyMatch(item -> !theirCollection.contains(item));
        final boolean theirCollectionHasUniqueItems = theirCollection.stream()
                .anyMatch(item -> !myCollection.contains(item));
        return myCollectionHasUniqueItems && theirCollectionHasUniqueItems;
    }

    static Set<String> commonCards(final List<Set<String>> collections) {
        if (collections == null || collections.isEmpty()) {
            return Set.of();
        }
        return collections.stream()
                .filter(Objects::nonNull)
                .filter(collection -> !collection.isEmpty())
                .reduce((set1, set2) -> {
                    final Set<String> intersection = new HashSet<>(set1);
                    intersection.retainAll(set2);
                    return intersection;
                })
                .orElse(Set.of());
    }

    static Set<String> allCards(final List<Set<String>> collections) {
        return collections == null ? Set.of() : collections.stream()
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}
