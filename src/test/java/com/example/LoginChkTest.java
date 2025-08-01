
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginChkTest {

    @Test
    void testLoginIdSuccess() {
        assertTrue(LoginChk.loginId("a"), "The loginId method should return true for id 'a'");
    }

    @Test
    void testLoginIdFailure() {
        assertFalse(LoginChk.loginId("b"), "The loginId method should return false for any id other than 'a'");
    }

    @Test
    void testLoginPwdSuccess() {
        PasswordValidator mockValidator = mock(PasswordValidator.class);
        when(mockValidator.validatePassword("1")).thenReturn("비밀번호가 유효합니다.");

        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("1");
        assertEquals("비밀번호가 유효합니다.", result, "The loginPwd method should return '비밀번호가 유효합니다.' for valid password");
    }

    @Test
    void testLoginPwdFailure() {
        PasswordValidator mockValidator = mock(PasswordValidator.class);
        when(mockValidator.validatePassword("wrong")).thenReturn("비밀번호가 유효하지 않습니다.");

        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("wrong");
        assertEquals("비밀번호가 유효하지 않습니다.", result, "The loginPwd method should return '비밀번호가 유효하지 않습니다.' for invalid password");
    }
}
