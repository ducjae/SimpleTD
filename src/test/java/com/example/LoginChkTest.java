
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

    // @Test
    // void testLoginPwdSuccess() {
    //     PasswordValidator pwdVal = new PasswordValidator();
    //     String validPassword = "validPassword"; // Assume this is a valid password
    //     assertEquals("비밀번호가 유효합니다.", LoginChk.loginPwd(validPassword), "The loginPwd method should return success message for a valid password.");
    // }

    @Test
    void testLoginPwdFailure() {
        PasswordValidator pwdVal = new PasswordValidator();
        String invalidPassword = "invalid"; // Assume this is an invalid password
        assertNotEquals("비밀번호가 유효합니다.", LoginChk.loginPwd(invalidPassword), "The loginPwd method should not return success message for an invalid password.");
    }
}
