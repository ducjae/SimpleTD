package com.example.demo;

import java.util.*;  // 사용하지 않는 import

public class GuaranteedPMDIssues {
    
    // 1. 사용하지 않는 private 필드
    private String neverUsed = "This field is never used";
    
    // 2. 사용하지 않는 지역 변수와 빈 catch 블록
    public void problematicMethod() {
        String unused1 = "not used";  // UnusedLocalVariable
        int unused2 = 42;            // UnusedLocalVariable
        
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // 빈 catch 블록 - PMD가 확실히 검출
        }
        
        // SystemPrintln 사용
        System.out.println("Hello World");
    }
    
    // 3. 너무 짧은 변수명들
    public void shortNames() {
        int a = 1;    // 변수명이 너무 짧음
        String b = "test";  // 변수명이 너무 짧음
    }
    
    // 4. 불필요한 지역 변수
    public String unnecessaryVariable() {
        String result = "Hello";
        return result;  // 바로 return하면 되는데 변수 사용
    }
    
    // 5. 복잡한 중첩 if문
    public void complexNesting(int x, int y) {
        if (x > 0) {
            if (y > 0) {
                if (x > y) {
                    if (x > 10) {
                        System.out.println("Complex nesting");
                    }
                }
            }
        }
    }
}

// 6. 중복 코드를 위한 클래스
class DuplicateCode {
    public void duplicateMethod() {
        String unused1 = "not used";  // 위와 동일한 패턴
        int unused2 = 42;            // 중복 코드
        
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // 중복된 빈 catch 블록
        }
    }
}