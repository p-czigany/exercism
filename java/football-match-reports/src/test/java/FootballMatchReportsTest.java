import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FootballMatchReportsTest {

//    @Ignore("not yet under test")
    @Test
    public void test_goal() {
        assertThat(FootballMatchReports.onField(1)).isEqualTo("goalie");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_left_back() {
        assertThat(FootballMatchReports.onField(2)).isEqualTo("left back");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_right_back() {
        assertThat(FootballMatchReports.onField(5)).isEqualTo("right back");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_center_back() {
        assertThat(FootballMatchReports.onField(3)).isEqualTo("center back");
        assertThat(FootballMatchReports.onField(4)).isEqualTo("center back");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_midfielder() {
        assertThat(FootballMatchReports.onField(6)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(7)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(8)).isEqualTo("midfielder");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_left_wing() {
        assertThat(FootballMatchReports.onField(9)).isEqualTo("left wing");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_striker() {
        assertThat(FootballMatchReports.onField(10)).isEqualTo("striker");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_right_wing() {
        assertThat(FootballMatchReports.onField(11)).isEqualTo("right wing");
    }

//    @Ignore("not yet under test")
    @Test
    public void test_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FootballMatchReports.onField(13));
    }

//    @Ignore("not yet under test")
    @Test
    public void test_exception_negative_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FootballMatchReports.onField(-1));
    }
}
