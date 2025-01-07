import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NotEqualsIgnoreCaseTest {
    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"BANANA", "Banana", "banana"})
    void testWordsAreMatchingThemselvesCaseInsensitive(final String s2) {
        assertThat(new NotEqualsIgnoreCase().test("BANANA", s2)).isFalse();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testWordsOtherThanThemselves() {
        assertThat(new NotEqualsIgnoreCase().test("LISTEN", "Silent")).isTrue();

    }
}
