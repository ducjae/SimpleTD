package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordValidatorTest {

    @Test
    public void testNullPassword() {
        assertEquals("��й�ȣ�� �Է��� �ּ���.", PasswordValidator.validatePassword(null));
    }

    @Test
    public void testEmptyPassword() {
        assertEquals("��й�ȣ�� �Է��� �ּ���.", PasswordValidator.validatePassword(""));
    }

    @Test
    public void testShortPassword() {
        assertEquals("��й�ȣ�� �ּ� 8���� �̻��̾�� �մϴ�.", PasswordValidator.validatePassword("Ab1"));
    }

    @Test
    public void testPasswordWithoutLowerCase() {
        assertEquals("��й�ȣ�� �ҹ��ڸ� �����ؾ� �մϴ�.", PasswordValidator.validatePassword("PASSWORD1"));
    }

    @Test
    public void testPasswordWithoutUpperCase() {
        assertEquals("��й�ȣ�� �빮�ڸ� �����ؾ� �մϴ�.", PasswordValidator.validatePassword("password1"));
    }

    @Test
    public void testPasswordWithoutDigit() {
        assertEquals("��й�ȣ�� ���ڸ� �����ؾ� �մϴ�.", PasswordValidator.validatePassword("Password"));
    }

    @Test
    public void testValidPassword() {
        assertEquals("��й�ȣ�� ��ȿ�մϴ�.", PasswordValidator.validatePassword("Valid1Password"));
    }
}
