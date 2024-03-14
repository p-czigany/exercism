import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NaturalNumberTest {

  //    @Disabled("Remove to run test")
  @Test
  void testSmallPerfectNumberIsClassifiedCorrectly() {
    assertThat(new NaturalNumber(6).getClassification()).isEqualTo(Classification.PERFECT);
  }

  //    @Disabled("Remove to run test")
  @Test
  void Small_abundant_number_is_classified_correctly() {
    assertThat(new NaturalNumber(12).getClassification()).isEqualTo(Classification.ABUNDANT);
  }

  //    @Disabled("Remove to run test")
  @Test
  void Small_deficient_number_is_classified_correctly() {
    assertThat(new NaturalNumber(8).getClassification()).isEqualTo(Classification.DEFICIENT);
  }

  //    @Disabled("Remove to run test")
  @Test
  void testLargerPerfectNumberIsClassifiedCorrectly() {
    assertThat(new NaturalNumber(28).getClassification()).isEqualTo(Classification.PERFECT);
  }

  //    @Disabled("Remove to run test")
  @Test
  void Larger_abundant_number_is_classified_correctly() {
    assertThat(new NaturalNumber(24).getClassification()).isEqualTo(Classification.ABUNDANT);
  }

  @Test
  void Error_is_thrown_for_zero_or_negative() {
    var naturalNumber = new NaturalNumber(0);
    assertThatThrownBy(naturalNumber::getClassification)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("You must supply a natural number (positive integer)");
  }

  //    @Test
  //    void test_aliquot() {
  //        assertThat(new NaturalNumber(1).aliquotSum(6)).isEqualTo(6);
  //        assertThat(new NaturalNumber(1).aliquotSum(28)).isEqualTo(28);
  //        assertThat(new NaturalNumber(1).aliquotSum(12)).isEqualTo(16);
  //        assertThat(new NaturalNumber(1).aliquotSum(24)).isEqualTo(36);
  //        assertThat(new NaturalNumber(1).aliquotSum(8)).isEqualTo(7);
  //    }

}
