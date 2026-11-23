package api;


import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.nio.charset.StandardCharsets;


public class BaseAPITest {

    @BeforeTest
    public static void setUp() {
        RestAssured.baseURI = "https://automationexercise.com";

    }

    @BeforeMethod
    public void setupApi() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), (requestSpec, responseSpec, ctx) -> {
            Response originalResponse = ctx.next(requestSpec, responseSpec);

            byte[] rawBytes = originalResponse.getBody().asByteArray();
            if (rawBytes.length > 0 && rawBytes[0] == '<') {
                String body = new String(rawBytes, StandardCharsets.UTF_8);
                if (body.contains("<html") || body.contains("<body")) {
                String json = body.replaceAll("</?(html|body)>", "").trim();
                return new ResponseBuilder()
                        .clone(originalResponse)
                        .setBody(json)
                        .setContentType(ContentType.JSON)
                        .setHeader("Content-Type", "application/json")
                        .build();
            }}
            return originalResponse;
        });
    }


}
