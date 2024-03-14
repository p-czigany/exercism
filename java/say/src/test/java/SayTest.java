import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SayTest {

  private Say say = new Say();

  //    @Disabled("Remove to run test")
  @Test
  void zero() {
    assertThat(say.say(0)).isEqualTo("zero");
  }

  @Test
  void three() {
    assertThat(say.say(3)).isEqualTo("three");
  }

  @Test
  void exceptionalNumbers() {
    assertThat(say.say(14L)).isEqualTo("fourteen");
  }

  //  @Disabled("Remove to run test")
  @Test
  void twentyTwo() {
    assertThat(say.say(22L)).isEqualTo("twenty-two");
  }

  //  @Disabled("Remove to run test")
  @Test
  void fifty() {
    assertThat(say.say(50L)).isEqualTo("fifty");
  }

  //  @Disabled("Remove to run test")
  @Test
  void ninetyEight() {
    assertThat(say.say(98L)).isEqualTo("ninety-eight");
  }

  @Disabled("Remove to run test")
  @Test
  void
      nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
    assertThat(say.say(987_654_321_123L))
        .isEqualTo(
            "nine hundred eighty-seven billion six hundred fifty-four million"
                + " three hundred twenty-one thousand one hundred twenty-three");
  }

  //    @Disabled("Remove to run test")
  @Test
  void illegalNegativeNumber() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> say.say(-1));
  }

  //    @Disabled("Remove to run test") 999,999,999,999
  @Test
  void illegalTooBigNumber() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> say.say(1_000_000_000_000L));
  }

//  @Disabled("Remove to run test")
  @Test
  void breakUpIntoChunksOfThousands() {
    assertThat(say.breakUpIntoChunksOfThousands(1234567890L)).isEqualTo(List.of(1L, 234L, 567L, 890L));
    assertThat(say.breakUpIntoChunksOfThousands(1000L)).isEqualTo(List.of(1L, 0L));
  }
}
