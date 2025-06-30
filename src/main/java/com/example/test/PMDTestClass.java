package com.example.test;

import java.util.*;
import java.io.*;

/**
 * PMD 룰 위반을 테스트하기 위한 클래스
 * 다양한 코드 품질 문제들을 포함하고 있습니다.
 */
public class PMDTestClass {
    
    // 1. UnusedPrivateField - 사용되지 않는 private 필드
    private String unusedField = "never used";
    
    // 2. TooManyFields - 너무 많은 필드들
    private String field1, field2, field3, field4, field5;
    private String field6, field7, field8, field9, field10;
    private String field11, field12, field13, field14, field15;
    
    // 3. UnusedLocalVariable를 위한 메서드
    public void methodWithUnusedVariable() {
        String unusedVariable = "I'm not used";  // UnusedLocalVariable
        int anotherUnused = 42;  // UnusedLocalVariable
        
        System.out.println("Hello World");
    }
    
    // 4. EmptyCatchBlock - 빈 catch 블록
    public void methodWithEmptyCatch() {
        try {
            Integer.parseInt("not a number");
        } catch (NumberFormatException e) {
            // Empty catch block - PMD will detect this
        }
    }
    
    // 5. TooManyMethods를 위한 많은 메서드들
    public void method1() { System.out.println("method1"); }
    public void method2() { System.out.println("method2"); }
    public void method3() { System.out.println("method3"); }
    public void method4() { System.out.println("method4"); }
    public void method5() { System.out.println("method5"); }
    public void method6() { System.out.println("method6"); }
    public void method7() { System.out.println("method7"); }
    public void method8() { System.out.println("method8"); }
    public void method9() { System.out.println("method9"); }
    public void method10() { System.out.println("method10"); }
    public void method11() { System.out.println("method11"); }
    public void method12() { System.out.println("method12"); }
    public void method13() { System.out.println("method13"); }
    public void method14() { System.out.println("method14"); }
    public void method15() { System.out.println("method15"); }
    
    // 6. CyclomaticComplexity - 복잡한 메서드
    public String complexMethod(int value) {
        if (value > 0) {
            if (value < 10) {
                if (value % 2 == 0) {
                    if (value > 5) {
                        if (value < 8) {
                            return "small even";
                        } else {
                            return "medium even";
                        }
                    } else {
                        return "tiny even";
                    }
                } else {
                    if (value > 5) {
                        return "medium odd";
                    } else {
                        return "small odd";
                    }
                }
            } else {
                return "large";
            }
        } else if (value < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }
    
    // 7. UnnecessaryLocalBeforeReturn - 불필요한 로컬 변수
    public String unnecessaryLocal() {
        String result = "Hello World";
        return result;  // 바로 return하면 되는데 변수 사용
    }
    
    // 8. CollapsibleIfStatements - 중첩된 if문
    public void collapsibleIf(boolean condition1, boolean condition2) {
        if (condition1) {
            if (condition2) {  // 이 두 if문은 합칠 수 있음
                System.out.println("Both conditions true");
            }
        }
    }
    
    // 9. UseStringBufferForStringAppends - String 연결 문제
    public String inefficientStringAppend() {
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += "item" + i;  // StringBuilder를 사용해야 함
        }
        return result;
    }
    
    // 10. AvoidInstantiatingObjectsInLoops - 루프 내 객체 생성
    public void objectInLoop() {
        for (int i = 0; i < 100; i++) {
            Date currentDate = new Date();  // 루프 밖에서 생성해야 함
            System.out.println(currentDate);
        }
    }
    
    // 11. UnusedImports는 클래스 상단의 import에서 체크됨
    // java.io.* 을 import했지만 사용하지 않음
    
    // 12. ShortVariable - 너무 짧은 변수명
    public void shortVariables() {
        int a = 1;  // 변수명이 너무 짧음
        String b = "test";  // 변수명이 너무 짧음
        boolean c = true;  // 변수명이 너무 짧음
    }
    
    // 13. LongVariable - 너무 긴 변수명
    public void longVariables() {
        String thisIsAnExtremelyLongVariableNameThatExceedsReasonableLimits = "too long";
    }
    
    // 14. AvoidDeeplyNestedIfStmts - 깊게 중첩된 if문
    public void deeplyNested(int a, int b, int c, int d) {
        if (a > 0) {
            if (b > 0) {
                if (c > 0) {
                    if (d > 0) {
                        if (a + b > c + d) {
                            System.out.println("Too deeply nested");
                        }
                    }
                }
            }
        }
    }
    
    // 15. EmptyIfStmt - 빈 if문
    public void emptyIf(boolean condition) {
        if (condition) {
            // Empty if statement
        }
    }
    
    // 16. UnnecessaryReturn - 불필요한 return
    public void unnecessaryReturn() {
        System.out.println("Method body");
        return;  // void 메서드에서 불필요한 return
    }
    
    // 17. SystemPrintln - System.out.println 사용 (로깅 프레임워크 사용 권장)
    public void systemPrintln() {
        System.out.println("Should use logging framework instead");
        System.err.println("This is also problematic");
    }
}

// 18. 중복 코드 테스트를 위한 추가 클래스
class DuplicatedCodeExample {
    
    // 위 클래스의 methodWithUnusedVariable과 거의 동일한 코드 (CPD가 검출)
    public void anotherMethodWithUnusedVariable() {
        String unusedVariable = "I'm not used";  // 중복 코드
        int anotherUnused = 42;  // 중복 코드
        
        System.out.println("Hello World");  // 중복 코드
    }
    
    // 위 클래스의 shortVariables와 거의 동일한 코드 (CPD가 검출)  
    public void moreShortVariables() {
        int a = 1;  // 중복 코드
        String b = "test";  // 중복 코드  
        boolean c = true;  // 중복 코드
    }
}