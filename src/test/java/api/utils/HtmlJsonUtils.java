package api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;

public class HtmlJsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    public static <T> T extractAs(ValidatableResponse response, Class<T> clazz) {
        try {
            return response.extract().jsonPath().getObject(".", clazz);
        } catch (Exception e) {
            String body = response.extract().body().asString();
            try {
                return MAPPER.readValue(body, clazz);
            } catch (Exception ex) {
                throw new AssertionError(
                        "Не удалось распарсить ответ в " + clazz.getSimpleName() +
                                "\nТело ответа: " + body, ex);
            }
        }
    }
}

