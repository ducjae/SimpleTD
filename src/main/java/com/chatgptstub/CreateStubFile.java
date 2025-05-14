package com.chatgptstub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
//import ai.djl.huggingface.tokenizers.*;
	
public class CreateStubFile {
	// 1차 진행은 고정된 폴더를 지정하여 해당 폴더내 java 소스만 junit test code를 작성하게 개발함
	
	private static final String writeFilePath = "D:\\workspace\\SimpleTD\\src\\main\\java\\com\\exampleStub\\";
	
	public static void main(String[] args) {
		try {
			
//			int tokenLength = tokenizers.encode(sourceCode).getTokens().length;
			
			String junitTestCode = "";
			String junitTestResult = "";
			IfChatGptGetStubCode ifJunitCode = new IfChatGptGetStubCode();
			junitTestCode = ifJunitCode.sendChatGPTRequest("비밀번호를 검증하는 stub java로직을 만들어줘 단, 문자 1을 입력하면  true, 아니면 false를 값을 리턴해야하고 패키지는 package com.exampleStub, 파일명은  PasswordValidatorStub.java 로 설명없이 만들어줘");
			if(junitTestCode.equals("Send request err") || junitTestCode.equals("Read response err")) {
				System.out.println("api err --------->" + junitTestCode);
			} else {
				junitTestResult = CreateFile("PasswordValidatorStub.java", junitTestCode);
				System.out.println("file create result --------->" + junitTestResult);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("api call err");
			e.printStackTrace();
		}
	}
	
	// 문자 치환없으면 오류가남... os별로 개행문자 인식이 다를텐데....어떻게 개선할수 있을까??	
	/*
	 * 소스파일 write시 문자 치환
	 */
	public static String ReplaceResponse(String replaceText) {
		
		replaceText = replaceText.replaceAll("\\\\n", "\r\n");	
		replaceText = replaceText.replaceAll("\\\\\"", "\\\"");		
		replaceText = replaceText.replaceAll("\\\\\'", "\\\'");	
		
		return replaceText;
	}
	/*
	 * test 파일을 만들기
	 */
	public static String CreateFile(String fileNm, String fileMsg) {
		File file = new File(writeFilePath + fileNm);
		try {
		    
			if(!file.exists()){ // 파일이 존재하지 않으면
	            file.createNewFile(); // 신규생성
	        }
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        
	        String writeMsg = fileMsg;
	        
	        // 문자치환
	        writeMsg = ReplaceResponse(writeMsg);	
	        
	        // 파일에 쓰기
	        writer.write(writeMsg);
	
	        // 버퍼 및 스트림 뒷정리
	        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
	        writer.close(); // 스트림 종료
	        
	        return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "err";
		}
	}
}
