package com.Lab3Solution1.controller;

import java.util.Stack;

public class BalancingBrackets{
    public static void main(String[] args) {
        String inputUnBalanced = "( [ [ { } ] ] ) )";
        String inputBalanced =   "( [ [ { } ] ] )";

        if(checkBalancedBrackets(inputUnBalanced)){
            System.out.println("Balanceed Brackets");
        }
        else{
            System.out.println("Unbalanced Brackets");
        }
    }

    static boolean checkBalancedBrackets(String bracketExpression) {
        Stack<Character> expresstionStack = new Stack<>();

        for (int i = 0; i < bracketExpression.length(); i++) {
            char expch = bracketExpression.charAt(i);
            if (expch == '[' || expch == '{' || expch == '(') {
                expresstionStack.push(expch);
                continue;
            }
            if (expresstionStack.isEmpty())
                return false;

            char tempch;
            switch (expch) {
                case '}':
                    tempch = expresstionStack.pop();
                    if (tempch == '(' || tempch == '[') {
                        return false;
                    }
                    break;
                case ')':
                    tempch = expresstionStack.pop();
                    if (tempch == '{' || tempch == '[') {
                        return false;
                    }
                    break;
                case ']':
                    tempch = expresstionStack.pop();
                    if (tempch == '{' || tempch == '(') {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        return expresstionStack.isEmpty();
    }
}