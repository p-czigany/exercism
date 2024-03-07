import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EliudsEggsTest {

  private static EliudsEggs eliudsEggs;

  @BeforeAll
  static void setup() {
    eliudsEggs = new EliudsEggs();
  }

  @Test
  @DisplayName("0 eggs")
  void test0Eggs() {
    assertThat(eliudsEggs.eggCount(0)).isZero();
  }

  @Test
  void test1() {
    assertThat(eliudsEggs.eggCount(1)).isOne();
  }

  @Test
  void test2() {
    assertThat(eliudsEggs.eggCount(2)).isOne();
  }

  @Test
  void test3() {
    assertThat(eliudsEggs.eggCount(3)).isEqualTo(2);
  }

  @Test
  void test4() {
    assertThat(eliudsEggs.eggCount(4)).isOne();
  }

//  @Disabled
  @Test
  @DisplayName("4 eggs")
  void test4Eggs() {
    assertThat(eliudsEggs.eggCount(89)).isEqualTo(4);
  }
}
