
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginChkTest {

    @Test
    void testLoginIdSuccess() {
        assertTrue(LoginChk.loginId("a"), "The loginId method should return true for a valid ID.");
    }

    @Test
    void testLoginIdFailure() {
        assertFalse(LoginChk.loginId("b"), "The loginId method should return false for an invalid ID.");
    }

    @Test
    void testLoginPwdSuccess() {
        PasswordValidator mockValidator = new PasswordValidator() {
            @Override
            public String validatePassword(String pwd) {
                return "비밀번호가 유효합니다.";
            }
        };
        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("1");
        assertEquals("비밀번호가 유효합니다.", result, "The loginPwd method should return success message for a valid password.");
    }

    @Test
    void testLoginPwdFailure() {
        PasswordValidator mockValidator = new PasswordValidator() {
            @Override
            public String validatePassword(String pwd) {
                return "비밀번호가 유효하지 않습니다.";
            }
        };
        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("wrongPassword");
        assertEquals("비밀번호가 유효하지 않습니다.", result, "The loginPwd method should return failure message for an invalid password.");
    }
}
