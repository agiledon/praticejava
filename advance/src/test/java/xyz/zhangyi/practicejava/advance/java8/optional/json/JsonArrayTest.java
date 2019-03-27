package xyz.zhangyi.practicejava.advance.java8.optional.json;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonArrayTest {
    private JsonObject rootJsonObj;

    @Before
    public void setUp() throws Exception {
        rootJsonObj = Json.parse(provideJsonString());
    }

    @Test
    public void should_return_JsonArray_for_List() {
        List<JsonObject> jsonObjects = new ArrayList<>();
        jsonObjects.add(rootJsonObj);
        JsonArray jsonArray = new JsonArray(jsonObjects);

        assertThat(jsonArray.size()).isEqualTo(1);
        assertThat(jsonArray.get(0)).isEqualTo(rootJsonObj);
    }

    @Test
    public void should_return_JsonArray_for_plain_object() {
        Optional<JsonArray> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.getJsonArray("FRLT"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray jsonArray = jsonArrayOpt.get();
        assertThat(jsonArray.size()).isEqualTo(1);
        assertThat(jsonArray.get(0)).isEqualTo("20130810224900");
    }

    @Test
    public void should_return_empty_JsonArray() {
        Optional<JsonArray> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.getJsonArray("TEST_EMPTY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray jsonArray = jsonArrayOpt.get();
        assertThat(jsonArray.isEmpty()).isEqualTo(true);
    }

    @Test
    public void should_return_JsonArray_with_JSONObject() {
        Optional<JsonArray<JsonObject>> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .map(msg -> msg.getJsonArray("DFLT"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray<JsonObject> jsonArray = jsonArrayOpt.get();
        assertThat(jsonArray.get(0).getString("FLID")).isEqualTo("3084916");
    }

    @Test
    public void should_return_JsonArray_of_String_for_array() {
        Optional<JsonArray> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.getJsonArray("TEST_STRING_ARRAY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray jsonArray = jsonArrayOpt.get();
        assertThat(jsonArray.size()).isEqualTo(3);
        assertThat(jsonArray.get(0)).isEqualTo("A");
    }

    @Test
    public void should_return_JsonArray_of_JsonObject_for_array() {
        Optional<JsonArray<JsonObject>> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.<JsonObject>getJsonArray("TEST_OBJECT_ARRAY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray<Integer> jsonArray = jsonArrayOpt.get().map(o -> o.getInteger("A"));
        assertThat(jsonArray.size()).isEqualTo(3);
        assertThat(jsonArray.get(0)).isEqualTo(1);
    }

    @Test
    public void should_filter_JsonArray_of_JsonObject_for_array() {
        Optional<JsonArray<JsonObject>> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.<JsonObject>getJsonArray("TEST_OBJECT_ARRAY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray<JsonObject> jsonArray = jsonArrayOpt.get().filter(o -> o.getInteger("A") > 1);
        assertThat(jsonArray.size()).isEqualTo(2);
        assertThat(jsonArray.get(0).getInteger("A")).isEqualTo(2);
    }

    @Test
    public void should_return_JsonArray_of_JsonArray_for_array() {
        Optional<JsonArray<JsonArray<JsonObject>>> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.getJsonArray("TEST_ARRAY_OF_ARRAY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray<JsonArray<JsonObject>> jsonArray = jsonArrayOpt.get();
        assertThat(jsonArray.size()).isEqualTo(3);
        assertThat(jsonArray.get(0).size()).isEqualTo(2);
    }

    @Test
    public void should_return_JsonArray_of_JsonObject_with_Array_for_array() {
        Optional<JsonArray<JsonObject>> jsonArrayOpt = rootJsonObj.getJsonObject("caacetc")
                .flatMap(caacetc -> caacetc.getJsonObject("data"))
                .flatMap(data -> data.getJsonObject("MSG"))
                .flatMap(msg -> msg.getJsonObject("DFLT"))
                .map(dflt -> dflt.getJsonArray("TEST_ARRAY_OF_OBJECT_WITH_ARRAY"));
        assertThat(jsonArrayOpt.isPresent()).isTrue();

        JsonArray<Integer> jsonArray = jsonArrayOpt.get().flatMap(o -> o.getJsonArray("VALUE"));
        assertThat(jsonArray.size()).isEqualTo(6);
        assertThat(jsonArray.get(0)).isEqualTo(1);
    }

    private String provideJsonString() {
        return "{\n" +
                "  \"caacetc\": {\n" +
                "    \"messageId\": \"123456\",\n" +
                "    \"originalTimestamp\": \"201807180954\",\n" +
                "    \"data\": {\n" +
                "      \"MSG\": {\n" +
                "        \"META\": {\n" +
                "          \"SNDR\": \"FIMS\",\n" +
                "          \"SEQN\": \"651\",\n" +
                "          \"DDTM\": \"20130810225122\",\n" +
                "          \"TYPE\": \"DFME\",\n" +
                "          \"STYP\": \"NXTE\"\n" +
                "        },\n" +
                "        \"DFLT\": {\n" +
                "          \"FLID\": \"3084916\",\n" +
                "          \"FFID\": \"CZ-6115-20100103081030-D\",\n" +
                "          \"FLTK\": \"W/Z\",\n" +
                "          \"FATT\": \"2403\",\n" +
                "          \"FRLT\": \"20130810224900\",\n" +
                "          \"TEST_EMPTY\": [],\n" +
                "          \"TEST_STRING_ARRAY\": [\"A\", \"B\", \"C\"],\n" +
                "          \"TEST_OBJECT_ARRAY\": [{\"A\": 1}, {\"A\": 2}, {\"A\": 3}],\n" +
                "          \"TEST_ARRAY_OF_OBJECT_WITH_ARRAY\": [{\"VALUE\": [1, 2]}, {\"VALUE\": [3]}, {\"VALUE\": [4, 5, 6]}],\n" +
                "          \"TEST_ARRAY_OF_ARRAY\": [[{\"A\": 1}, {\"A\": 2}], [{\"A\": 3}], [{\"A\": 4}, {\"A\": 5}]]" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }
}
