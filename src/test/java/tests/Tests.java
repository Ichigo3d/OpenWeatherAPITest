package tests;

import GetRequests.GetRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import support.BuilderUrl;


public class Tests extends GetRequest {
    @Test
    public void getResponseCode() {
        BuilderUrl url = new BuilderUrl();
        int code = getResponseCode(url.getUrl());

        System.out.println("Response code is " + code);
        Assert.assertEquals(code, 200);


    }

    @Test
    public void getResponseCityTemp(){
        BuilderUrl url = new BuilderUrl();

        Double temp = getResponseTemp(url.getUrl());
        System.out.println("Temperature in " + nameOfCity+ " "+ temp + " \u2109"); // "\u2109" is ℉ sign in UNICODE format
    }





}
