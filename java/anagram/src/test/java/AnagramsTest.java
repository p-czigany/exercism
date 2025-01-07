import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

class AnagramsTest {
    private Anagrams anagrams;

    @BeforeEach
    void setUp() {
        anagrams = new Anagrams();
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "zombies", "pants"})
    void testNoMatches(final String s2) {
        assertThat(anagrams.test("diaper", s2)).isFalse();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"stream", "maters"})
    void testDetectMultipleAnagrams(final String s2) {
        assertThat(anagrams.test("master", s2)).isTrue();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"dog", "goody"})
    void testEliminateAnagramSubsets(final String s2) {
        assertThat(anagrams.test("good", s2)).isFalse();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"enlists", "google", "banana"})
    void testDetectNoLongerAnagram(final String s2) {
        assertThat(anagrams.test("listen", s2)).isFalse();
    }

    @Test
    void testDetectLongerAnagram() {
        assertThat(anagrams.test("listen", "inlets")).isTrue();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"gallery", "regally", "largely"})
    void testDetectMultipleAnagramsForLongerWord(final String s2) {
        assertThat(anagrams.test("allergy", s2)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ballerina", "clergy", "leading"})
    void testDetectNoMultipleAnagramsForLongerWord(final String s2) {
        assertThat(anagrams.test("allergy", s2)).isFalse();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"Eons", "ONES"})
    void testDetectsMultipleAnagramsWithDifferentCase(final String s2) {
        assertThat(anagrams.test("nose", s2)).isTrue();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testEliminateAnagramsWithSameChecksum() {
        assertThat(anagrams.test("mass", "last")).isFalse();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenBothAnagramAndSubjectStartWithUpperCaseLetter() {
        assertThat(anagrams.test("Orchestra", "Carthorse")).isTrue();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
        assertThat(anagrams.test("Orchestra", "carthorse")).isTrue();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenAnagramStartsWithUpperCaseLetter() {
        assertThat(anagrams.test("orchestra", "Carthorse")).isTrue();

    }

    //    @Disabled("Remove to run test")
    @Test
    void testIdenticalWordRepeatedIsNotAnagram() {
        assertThat(anagrams.test("go", "go Go GO")).isFalse();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testAnagramMustUseAllLettersExactlyOnce() {
        assertThat(anagrams.test("tapper", "patter")).isFalse();
    }

    //    @Disabled("Remove to run test")
    @ParameterizedTest
    @ValueSource(strings = {"BANANA", "Banana", "banana"})
    void testWordsAreAnagramsOfThemselvesCaseInsensitive(final String s2) {
        assertThat(anagrams.test("BANANA", s2)).isTrue();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testWordsOtherThanThemselvesCanBeAnagrams() {
        Anagram detector = new Anagram("LISTEN");

        assertThat(detector.match(Arrays.asList("Listen", "Silent", "LISTEN")))
                .containsExactlyInAnyOrder("Silent");
    }
}
