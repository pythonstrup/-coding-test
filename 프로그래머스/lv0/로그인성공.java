package no;

public class 로그인성공 {
  public String solution(String[] id_pw, String[][] db) {

    for (String[] data: db) {
      if (data[0].equals(id_pw[0]) && data[1].equals(id_pw[1])) {
        return "login";
      }

      if (data[0].equals(id_pw[0])) {
        return "wrong pw";
      }
    }

    return "fail";
  }
}
