import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class AnagramTest {

    @Test
    void testNoMatches() {
        Anagram detector = new Anagram("diaper");

        assertThat(
                detector.match(
                        Arrays.asList("hello", "world", "zombies", "pants")))
                .isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testDetectMultipleAnagrams() {
        Anagram detector = new Anagram("master");

        assertThat(detector.match(Arrays.asList("stream", "pigeon", "maters")))
                .containsExactlyInAnyOrder("maters", "stream");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");

        assertThat(detector.match(Arrays.asList("dog", "goody"))).isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testDetectLongerAnagram() {
        Anagram detector = new Anagram("listen");

        assertThat(
                detector.match(
                        Arrays.asList("enlists", "google", "inlets", "banana")))
                .containsExactlyInAnyOrder("inlets");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testDetectMultipleAnagramsForLongerWord() {
        Anagram detector = new Anagram("allergy");
        assertThat(
                detector.match(
                        Arrays.asList(
                                "gallery",
                                "ballerina",
                                "regally",
                                "clergy",
                                "largely",
                                "leading")))
                .containsExactlyInAnyOrder("gallery", "regally", "largely");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testDetectsMultipleAnagramsWithDifferentCase() {
        Anagram detector = new Anagram("nose");

        assertThat(detector.match(Arrays.asList("Eons", "ONES")))
                .containsExactlyInAnyOrder("Eons", "ONES");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");

        assertThat(detector.match(Collections.singletonList("last")))
                .isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenBothAnagramAndSubjectStartWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder("Carthorse");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenSubjectStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("Orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "carthorse", "radishes")))
                .containsExactlyInAnyOrder("carthorse");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testCaseInsensitiveWhenAnagramStartsWithUpperCaseLetter() {
        Anagram detector = new Anagram("orchestra");

        assertThat(
                detector.match(
                        Arrays.asList("cashregister", "Carthorse", "radishes")))
                .containsExactlyInAnyOrder("Carthorse");
    }

    //    @Disabled("Remove to run test")
    @Test
    void testIdenticalWordRepeatedIsNotAnagram() {
        Anagram detector = new Anagram("go");

        assertThat(detector.match(Collections.singletonList("go Go GO")))
                .isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testAnagramMustUseAllLettersExactlyOnce() {
        Anagram detector = new Anagram("tapper");

        assertThat(detector.match(Collections.singletonList("patter")))
                .isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testWordsAreNotAnagramsOfThemselvesCaseInsensitive() {
        Anagram detector = new Anagram("BANANA");

        assertThat(detector.match(Arrays.asList("BANANA", "Banana", "banana")))
                .isEmpty();
    }

    //    @Disabled("Remove to run test")
    @Test
    void testWordsOtherThanThemselvesCanBeAnagrams() {
        Anagram detector = new Anagram("LISTEN");

        assertThat(detector.match(Arrays.asList("Listen", "Silent", "LISTEN")))
                .containsExactlyInAnyOrder("Silent");
    }
}
