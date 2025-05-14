package com.chatgpt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
	
public class CreateJunitFile {
	// 1차 진행은 고정된 폴더를 지정하여 해당 폴더내 java 소스만 junit test code를 작성하게 개발함
	private static final String readFilePath = "D:\\workspace\\SimpleTD\\src\\main\\java\\com\\example\\"; 
	private static final String writeFilePath = "D:\\workspace\\SimpleTD\\src\\test\\java\\com\\example\\";


	public static void main(String[] args) {
		File dir = new File(readFilePath);
		FileFilter filter = new FileFilter() {
			public boolean accept(File f) {
				return f.getName().endsWith(".java");	// 자바파일만 처리한다
			}
		};
		File files[] = dir.listFiles(filter);
		
		// java파일 필터 한것만 루프돌리면서  test code 파일 생성 api를 호출해야함
		for (File file : files) {	
			// 오류방지용 체크인데 else는 무시하기 -> 정상파일 생성이 불가능하니깐...
			if( file.isFile() && file.canRead() ){ 
				System.out.println("file : " + file.getName());
				// 원본파일명
				String junitTestFileNm = file.getName();	
				String junitTestCode = "";
				// junit테스트 파일명 
				junitTestFileNm = junitTestFileNm.replaceAll(".java", "Test.java");	
				String junitTestResult = "";
				
				try {
					FileInputStream input = new FileInputStream(file);
				    InputStreamReader fileReader;
				    String sourceCode = "";
					try {
						fileReader = new InputStreamReader(input,"UTF-8");
					
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						// 읽기 수행
						String line = "";
						try {
							// 파일 내 문자열을 1줄씩 읽기 while
							while( (line = bufferedReader.readLine()) != null ){ 
								sourceCode += line + " ";	
							}
							// 읽은 파일의 문자 치환
							sourceCode = ReplaceRequest(sourceCode); 
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("file read err");
							e.printStackTrace();
						}
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						junitTestCode = "";
						junitTestResult = "";
						IfChatGptGetJunitCode ifJunitCode = new IfChatGptGetJunitCode();
						junitTestCode = ifJunitCode.sendChatGPTRequest(sourceCode);
						//Thread.sleep(5000);
						junitTestResult = CreateFile(junitTestFileNm, junitTestCode);
						System.out.println("file create result --------->" + junitTestResult);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("api call err");
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("read file loof err");
					e.printStackTrace();
				}
		    }
		}
	}
	
	// 문자 치환없으면 오류가남... os별로 개행문자 인식이 다를텐데....어떻게 개선할수 있을까??	
	/*
	 * 소스파일 read시 문자 치환
	 */
	public static String ReplaceRequest(String replaceText) {
		
		replaceText = replaceText.replaceAll("\\\"", "\\\\\""); 
		replaceText = replaceText.replaceAll("\\\'", "\\\\\'"); 
		replaceText = replaceText.replaceAll("\t", " ");
		replaceText = replaceText.replaceAll("\n", " ");
		replaceText = replaceText.replaceAll("\r", " ");
		replaceText = replaceText.replaceAll("\r\n", " ");
		replaceText = replaceText.replaceAll("\n\r", " ");
		
		return replaceText;
	}
	
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
