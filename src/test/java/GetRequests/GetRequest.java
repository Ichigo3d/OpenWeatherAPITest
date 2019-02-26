package GetRequests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;



public class GetRequest {
    public String nameOfCity = "";

public int getResponseCode(String url) {

    Response resp = RestAssured.get(url);
    int code = resp.getStatusCode();
    return code;
}

public Double getResponseTemp(String url) {

    Response resp = RestAssured.get(url);
    Response body = (Response) resp.getBody();
    //getting certain value from response body.
    JsonPath jsonPathEvaluator = body.jsonPath();
    HashMap <String, Float> main = jsonPathEvaluator.get("main");
    Float tempK = Float.valueOf(main.get("temp"));
    //T(°F) = T(K) × 9/5 - 459.67
    double temp = Math.round((tempK * 9/5 - 459.67)* 100.0) / 100.0;
    nameOfCity= jsonPathEvaluator.get("name");
    //System.out.println(body.asString());
    return temp;

}
}
