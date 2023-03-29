package com.code;

public class 대문자와소문자 {

  public static String main(String[] args) {
    String my_string = "cccCCC";

    String answer = "";
    for (int i = 0; i < my_string.length(); i++) {
      if (Character.isUpperCase(my_string.charAt(i))) {
        answer += Character.toString(my_string.charAt(i)).toLowerCase();
      } else {
        answer += Character.toString(my_string.charAt(i)).toUpperCase();
      }
    }
    return answer;

    // 스트림
//    return myString.chars()
//        .mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand))))
//        .collect(Collectors.joining());

    // 나와 비슷한 풀이지만 좀떠 깔끔해보임
//    String answer = "";
//    for(int i=0; i<my_string.length(); i++){
//      char c = my_string.charAt(i);
//      if(Character.isUpperCase(c)){
//        answer += String.valueOf(c).toLowerCase();
//      }else{
//        answer += String.valueOf(c).toUpperCase();
//      }
//    }
//    return answer;
  }
}