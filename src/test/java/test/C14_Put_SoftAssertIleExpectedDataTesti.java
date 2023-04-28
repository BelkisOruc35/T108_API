package test;

import org.json.JSONObject;
import org.junit.Test;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */
    @Test
    public void put01(){
        //1.url ve body oluştur
        String url="https://dummy.restapiexample.com/api/v1/update/21";
        JSONObject data=new JSONObject();
        data.put( "name","Ahmet");
        data.put("salary","1230");
        data.put(    "age","44");
        data.put( "id",40);
        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);
        //2.expected data hazırla
        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",reqBody);

        //git init
        //git add README.md
        //git commit -m "first commit"
        //git branch -M main
        //git remote add origin https://github.com/BelkisOruc35/T108_API.git
        //git push -u origin main

    }
}
