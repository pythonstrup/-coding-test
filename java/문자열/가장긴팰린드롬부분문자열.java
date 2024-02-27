package no;

public class 가장긴팰린드롬부분문자열 {

  private int left;
  private int maxLen;

  public String solution(String str) {
    int length = str.length();

    if (length < 2) {
      return str;
    }

    for (int i = 0; i < length - 1; i++) {
      extendPalindrome(str, i, i + 1);
      extendPalindrome(str, i, i + 2);
    }

    return str.substring(left, left + maxLen);
  }

  public void extendPalindrome(String str, int j, int k) {
    int length = str.length();
    while (j >= 0 && k < length && str.charAt(j) == str.charAt(k)) {
      j--;
      k++;
    }

    if (maxLen < k - j - 1) {
      left = j + 1;
      maxLen = k - j - 1;
    }
  }
}
