package com.example;

public class PasswordValidator {
	public static String validatePassword(String password) {
        // 비밀번호가 null이거나 비어있는지 확인
        if (password == null || password.isEmpty()) {
            return "비밀번호를 입력해 주세요.";
        }
        // 비밀번호가 10글자 이상인지 확인
        if (password.length() < 8) {
            return "비밀번호는 최소 8글자 이상이어야 합니다.";
        }
        // 소문자, 대문자, 숫자 포함 여부 확인
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        if (!hasLowerCase) {
            return "비밀번호는 소문자를 포함해야 합니다.";
        }

        if (!hasUpperCase) {
            return "비밀번호는 대문자를 포함해야 합니다.";
        }

        if (!hasDigit) {
            return "비밀번호는 숫자를 포함해야 합니다.";
        }

        // 모든 조건을 만족하는 경우
        return "비밀번호가 유효합니다.";
    }
}
