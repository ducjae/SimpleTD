
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorTest {

    @Test
    public void testNullPassword() {
        assertEquals("비밀번호를 입력해 주세요.", PasswordValidator.validatePassword(null));
    }

    @Test
    public void testEmptyPassword() {
        assertEquals("비밀번호를 입력해 주세요.", PasswordValidator.validatePassword(""));
    }

    @Test
    public void testShortPassword() {
        assertEquals("비밀번호는 최소 8글자 이상이어야 합니다.", PasswordValidator.validatePassword("Ab1"));
    }

    @Test
    public void testPasswordWithoutLowerCase() {
        assertEquals("비밀번호는 소문자를 포함해야 합니다.", PasswordValidator.validatePassword("ABCDEFG1"));
    }

    @Test
    public void testPasswordWithoutUpperCase() {
        assertEquals("비밀번호는 대문자를 포함해야 합니다.", PasswordValidator.validatePassword("abcdefg1"));
    }

    @Test
    public void testPasswordWithoutDigit() {
        assertEquals("비밀번호는 숫자를 포함해야 합니다.", PasswordValidator.validatePassword("Abcdefgh"));
    }

    @Test
    public void testValidPassword() {
        assertEquals("비밀번호가 유효합니다.", PasswordValidator.validatePassword("Abcdefg1"));
    }
}
