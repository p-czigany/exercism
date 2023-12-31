import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class BlackjackTest {

    private Blackjack blackjack;

    @Before
    public void setUp() {
        blackjack = new Blackjack();
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesAce () {
        assertThat(blackjack.parseCard("ace")).isEqualTo(11);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesTwo () {
        assertThat(blackjack.parseCard("two")).isEqualTo(2);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesThree () {
        assertThat(blackjack.parseCard("three")).isEqualTo(3);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesFour () {
        assertThat(blackjack.parseCard("four")).isEqualTo(4);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesFive () {
        assertThat(blackjack.parseCard("five")).isEqualTo(5);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesSix () {
        assertThat(blackjack.parseCard("six")).isEqualTo(6);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesSeven () {
        assertThat(blackjack.parseCard("seven")).isEqualTo(7);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesEight () {
        assertThat(blackjack.parseCard("eight")).isEqualTo(8);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesNine () {
        assertThat(blackjack.parseCard("nine")).isEqualTo(9);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesTen () {
        assertThat(blackjack.parseCard("ten")).isEqualTo(10);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesJack () {
        assertThat(blackjack.parseCard("jack")).isEqualTo(10);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesQueen () {
        assertThat(blackjack.parseCard("queen")).isEqualTo(10);
    }

//    @Ignore("not yet under test")
    @Test
    public void correctParsesKing () {
        assertThat(blackjack.parseCard("king")).isEqualTo(10);
    }

//    @Ignore("not yet under test")
    @Test
    public void blackjackWithTenAceSecond() {
        assertThat(blackjack.isBlackjack("ten", "ace")).isEqualTo(true);
    }

//    @Ignore("not yet under test")
    @Test
    public void blackjackWithJackAceSecond() {
        assertThat(blackjack.isBlackjack("jack", "ace")).isEqualTo(true);
    }

//    @Ignore("not yet under test")
    @Test
    public void blackjackWithQueenAceSecond() {
        assertThat(blackjack.isBlackjack("queen", "ace")).isEqualTo(true);
    }

//    @Ignore("not yet under test")
    @Test
    public void blackjackWithKingAceSecond() {
        assertThat(blackjack.isBlackjack("king", "ace")).isEqualTo(true);
    }


//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithFive() {
        assertThat(blackjack.isBlackjack("ace", "five")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithNine() {
        assertThat(blackjack.isBlackjack("ace", "nine")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithTwoAces() {
        assertThat(blackjack.isBlackjack("ace", "ace")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithTwoFigures() {
        assertThat(blackjack.isBlackjack("queen", "jack")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithKingAndFive() {
        assertThat(blackjack.isBlackjack("king", "five")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void noBlackjackWithEightAndFive() {
        assertThat(blackjack.isBlackjack("eight", "five")).isEqualTo(false);
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithAceAceAndDealerAce () {
        assertThat(blackjack.firstTurn("ace", "ace", "ace")).isEqualTo("P");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithJackJackAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "jack", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithKingKingAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "king", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoTwoAndDealerAce () {
        assertThat(blackjack.firstTurn("two", "two", "ace")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFiveFiveAndAce () {
        assertThat(blackjack.firstTurn("five", "five", "ace")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithJackAceAndDealerAce () {
        assertThat(blackjack.firstTurn("jack", "ace", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithAceKingAndDealerQueen () {
        assertThat(blackjack.firstTurn("ace", "king", "queen")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTenAceAndDealerFive () {
        assertThat(blackjack.firstTurn("ten", "ace", "five")).isEqualTo("W");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithKingAceAndDealerNine () {
        assertThat(blackjack.firstTurn("king", "ace", "nine")).isEqualTo("W");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithKingTenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "ten", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithNineTenAndDealerAce () {
        assertThat(blackjack.firstTurn("nine", "ten", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithEightTenAndDealerAce () {
        assertThat(blackjack.firstTurn("eight", "ten", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithKingSevenAndDealerAce () {
        assertThat(blackjack.firstTurn("king", "seven", "ace")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithSixTenAndDealerSix () {
        assertThat(blackjack.firstTurn("six", "ten", "six")).isEqualTo("S");
    }

    @Ignore("not yet under test")
    @Test
    public void firstTurnWithSixTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("six", "ten", "seven")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithSixTenAndDealerAce () {
        assertThat(blackjack.firstTurn("six", "ten", "ace")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFiveTenAndDealerSix () {
        assertThat(blackjack.firstTurn("five", "ten", "six")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFiveTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("five", "ten", "seven")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFiveTenAndDealerKing () {
        assertThat(blackjack.firstTurn("five", "ten", "king")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFourTenAndDealerSix () {
        assertThat(blackjack.firstTurn("four", "ten", "six")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFourTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("four", "ten", "seven")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithFourTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("four", "ten", "queen")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithThreeTenAndDealerSix () {
        assertThat(blackjack.firstTurn("three", "ten", "six")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithThreeTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("three", "ten", "seven")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithThreeTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("three", "ten", "queen")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoTenAndDealerSix () {
        assertThat(blackjack.firstTurn("two", "ten", "six")).isEqualTo("S");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoTenAndDealerSeven () {
        assertThat(blackjack.firstTurn("two", "ten", "seven")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoTenAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "ten", "queen")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoNineAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "nine", "queen")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoEightAndDealerTwo () {
        assertThat(blackjack.firstTurn("two", "eight", "two")).isEqualTo("H");
    }

//    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoThreeAndDealerQueen () {
        assertThat(blackjack.firstTurn("two", "three", "queen")).isEqualTo("H");
    }

    @Ignore("not yet under test")
    @Test
    public void firstTurnWithTwoTwoAndDealerFive () {
        assertThat(blackjack.firstTurn("two", "two", "five")).isEqualTo("H");
    }

}
