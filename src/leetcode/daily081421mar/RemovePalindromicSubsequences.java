package leetcode.daily081421mar;

public class RemovePalindromicSubsequences {

  public int removePalindromeSub(String s) {
    if(s.length() == 0) {
        return 0;
    }
    char[] ch = s.toCharArray();
    for(int i=0,j=ch.length-1;i<=ch.length/2;i++,j--) {
        if(ch[i] != ch[j]) {
            return 2;
        }
    }
    return 1;
  }
}
