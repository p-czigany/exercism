import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class LanguageListTest {

    LanguageList languageList = new LanguageList();

    @Test
    public void empty() {
        assertThat(languageList.isEmpty()).isTrue();
    }

//    @Ignore("not yet under test")
    @Test
    public void nonEmpty() {
        languageList.addLanguage("Java");

        assertThat(languageList.isEmpty()).isFalse();
    }

//    @Ignore("not yet under test")
    @Test
    public void addOneLanguage() {
        languageList.addLanguage("Java");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

//    @Ignore("not yet under test")
    @Test
    public void addMultipleLanguages() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Ruby")).isTrue();
        assertThat(languageList.containsLanguage("C++")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
    }

//    @Ignore("not yet under test")
    @Test
    public void removeLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        languageList.removeLanguage("Python");

        assertThat(languageList.containsLanguage("Java")).isTrue();
        assertThat(languageList.containsLanguage("Python")).isFalse();
        assertThat(languageList.containsLanguage("Ruby")).isTrue();
    }

//    @Ignore("not yet under test")
    @Test
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

//    @Ignore("not yet under test")
    @Test
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        assertThat(languageList.count()).isEqualTo(3);
    }

//    @Ignore("not yet under test")
    @Test
    public void countEmpty() {
        assertThat(languageList.count()).isEqualTo(0);
    }

//    @Ignore("not yet under test")
    @Test
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");

        assertThat(languageList.isExciting()).isTrue();
    }

//    @Ignore("not yet under test")
    @Test
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");

        assertThat(languageList.isExciting()).isTrue();
    }

//    @Ignore("not yet under test")
    @Test
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        assertThat(languageList.isExciting()).isFalse();
    }
}
