package test;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body- Expected DAta
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */
    @Test
    public void post01(){
        //.1 Url ve body olustur
        String Url= "https://restful-booker.herokuapp.com/booking";
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin" ,"2021-06-01");
        bookingDates.put("checkout", "2021-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" ,"Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" ,false);
        reqBody.put("bookingdates",bookingDates) ;
        reqBody.put("additionalneeds","wi-fi");

        //2.expecteddata olustur


          JSONObject expectedBody=new JSONObject();
          expectedBody.put("bookingid",24);
          expectedBody.put("booking",reqBody);
        //3.response kaydet
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(Url);
        response.prettyPrint();
        //Assertion
        JsonPath resJspath=response.jsonPath();
        Assert.assertEquals(expectedBody.getJSONObject("booking").get("firstname"),resJspath.get("booking.firstname"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").get("lastname"),resJspath.get("booking.lastname"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").get("totalprice"),resJspath.get("booking.totalprice"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").get("depositpaid"),resJspath.get("booking.depositpaid"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").get("additionalneeds"),resJspath.get("booking.additionalneeds"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJspath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJspath.get("booking.bookingdates.checkout"));









        }
}
