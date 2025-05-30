
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginChkTest {

    @Test
    public void testLoginId_ValidId() {
        assertTrue(LoginChk.loginId("a"), "The loginId method should return true for valid id 'a'");
    }

    @Test
    public void testLoginId_InvalidId() {
        assertFalse(LoginChk.loginId("b"), "The loginId method should return false for invalid id 'b'");
    }

    @Test
    public void testLoginPwd_ValidPassword() {
        PasswordValidator mockValidator = mock(PasswordValidator.class);
        when(mockValidator.validatePassword("1")).thenReturn("비밀번호가 유효합니다.");

        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("1");

        assertEquals("비밀번호가 유효합니다.", result, "The loginPwd method should return '비밀번호가 유효합니다.' for valid password '1'");
    }

    @Test
    public void testLoginPwd_InvalidPassword() {
        PasswordValidator mockValidator = mock(PasswordValidator.class);
        when(mockValidator.validatePassword("wrong")).thenReturn("비밀번호가 유효하지 않습니다.");

        LoginChk loginChk = new LoginChk();
        String result = loginChk.loginPwd("wrong");

        assertEquals("비밀번호가 유효하지 않습니다.", result, "The loginPwd method should return '비밀번호가 유효하지 않습니다.' for invalid password 'wrong'");
    }
}
