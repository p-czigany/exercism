import java.util.AbstractMap;
import java.util.Map;

public class Blackjack {
    private static final int BLACKJACK_VALUE = 21;
    private static final Map<String, Integer> CARD_VALUES = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("ace", 11),
            new AbstractMap.SimpleEntry<>("two", 2),
            new AbstractMap.SimpleEntry<>("three", 3),
            new AbstractMap.SimpleEntry<>("four", 4),
            new AbstractMap.SimpleEntry<>("five", 5),
            new AbstractMap.SimpleEntry<>("six", 6),
            new AbstractMap.SimpleEntry<>("seven", 7),
            new AbstractMap.SimpleEntry<>("eight", 8),
            new AbstractMap.SimpleEntry<>("nine", 9),
            new AbstractMap.SimpleEntry<>("ten", 10),
            new AbstractMap.SimpleEntry<>("jack", 10),
            new AbstractMap.SimpleEntry<>("queen", 10),
            new AbstractMap.SimpleEntry<>("king", 10),
            new AbstractMap.SimpleEntry<>("other", 0)
    );
    public int parseCard(String card) {
        return CARD_VALUES.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == BLACKJACK_VALUE;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) return "P";
        if (dealerScore < 10) return "W";
        return "S";
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) return "S";
        if (handScore <= 11) return "H";
        if (dealerScore < 7) return "S";
        return "H";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
