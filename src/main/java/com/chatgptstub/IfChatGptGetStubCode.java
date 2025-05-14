package com.chatgptstub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ApiConfig;

public class IfChatGptGetStubCode {
	// api url 및 key(연결된 정보는 20달러까지만 사용가능하게 적용해둠) -> ?고정된 정보는....설정으로 빼는고싶은데....
	private static final String API_KEY = ApiConfig.getApiKey();
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    /* 
     * api 회신내용중 소스 문장만 발췌하기위한 문자열 자르기
     * 예시는 content": " 이후 구분부터 "까지 문자를 활용하지만 소스내 " 구문이 있을수 있음으로 ```java 이후문장 부터 ``` 문장까지 자르기 적용
     */
    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("```java")+ 9;
        int end = response.indexOf("```", start);
        return response.substring(start, end);
    }
    
    /*
     * api 연결해서 junit test code 회신받기
     * !!! 수정하지 마세요 !!!
     */
    public static String sendChatGPTRequest(String message) throws Exception {
         // Create URL object
         URL url = new URL(API_URL);
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();

         // Set request method
         connection.setRequestMethod("POST");
         connection.setRequestProperty("Content-Type", "application/json");
         connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
         connection.setDoOutput(true);
         
         // String sysMsg = ;
         // Create request body 
         
         String requestBody = "{"
                 + "\"model\": \"gpt-4o-mini\","		
                 + "\"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}],"
                 + "\"temperature\": 0"
                 + "}";
         // Send request
         try (OutputStream os = connection.getOutputStream()) {
             byte[] input = requestBody.getBytes("utf-8");
             os.write(input, 0, input.length);
         } catch (IOException e) {
        	 connection.disconnect();
 			e.printStackTrace();
 			return "Send request err";
 		}
         // Read response
         StringBuilder response = new StringBuilder();
         try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
             String responseLine;
             while ((responseLine = br.readLine()) != null) {
                 response.append(responseLine.trim());
             }
         } catch (IOException e) {
        	 connection.disconnect();
  			e.printStackTrace();
  			return "Read response err";
  		}
         // Close connection
         connection.disconnect();
         // 결과는 junit test code 만 돌려주기
         String resultContent = extractMessageFromJSONResponse(response.toString());
         
         return resultContent;
     }
}
