package com.example;

public class LoginChk {

    public static boolean loginId(String id) {
    	// id는
    	if (!"a".equals(id)) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    // PasswordValidator.java 호출시 
    public static String loginPwd(String pwd) {
    	PasswordValidator pwdVal = new PasswordValidator();
    	String pwdChk = pwdVal.validatePassword(pwd);
    	return pwdChk;
    }

    
    public static void main(String[] args) {

        String inputUsername = "a";
        String inputPassword = "1";
        // 아이디 점검
        if (loginId(inputUsername)) {
            System.out.println("아이디 인증 성공!");
        } else {
            System.out.println("아이디가 잘못되었습니다.");
        }
        
        // PasswordValidator.java 호출시 비밀번호 점검
        String pwdResult = loginPwd(inputPassword);
        if ("비밀번호가 유효합니다.".equals(pwdResult)) {
            System.out.println("비밀번호 인증 성공!");
        } else {
            System.out.println("비밀번호 인증 실패: " + pwdResult);
        }

    }
}
