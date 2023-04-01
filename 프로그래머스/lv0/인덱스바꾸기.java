package com.code;

public class 인덱스바꾸기 {

  public static String main(String[] args) {
    String my_string = "hello";
    int num1 = 1;
    int num2 = 2;

    String[] strlist = my_string.split("");
    String temp = strlist[num1];
    strlist[num1] = strlist[num2];
    strlist[num2] = temp;
    return String.join("", strlist);

    // Collections.swap 이라는 메소드가 존재한다.
//    List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());
//    Collections.swap(list, num1, num2);
//    return String.join("", list);

    // toCharArray
//    String answer = "";
//    char[] ch = my_string.toCharArray();
//    ch[num1] = my_string.charAt(num2);
//    ch[num2] = my_string.charAt(num1);
//    answer = String.valueOf(ch);
//    return answer;
  }
}