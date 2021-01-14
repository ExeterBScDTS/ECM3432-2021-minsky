package minskyone;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class UtilsTest {

    @Test
    void jsonNameValue() {
        var testMap = Map.of(
                "a", "b",
                "c", "d"
        );

        var stringVersion = Utils.jsonNameValue(testMap);

        assertThat(stringVersion).isIn(
                "{\"c\":\"d\",\"a\":\"b\"}",
                "{\"a\":\"b\",\"c\":\"d\"}"
        );
    }

    @Test
    void jsonMap() {
        var testString = "{\"a\":\"b\",\"c\":\"d\"}";

        var expectedMap = Map.of(
                "a", "\"b\"",
                "c", "\"d\""
        );

        var realMap = Utils.jsonMap(testString);

        assertThat(realMap).isEqualTo(expectedMap);
    }
}
