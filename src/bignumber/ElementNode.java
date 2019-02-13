package bignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementNode implements BigNumber {
  private int num;
  private BigNumber rest;

  public ElementNode(int num, BigNumber rest) {
    this.num = num;
    this.rest = rest;
  }

  @Override
  public int length() {
    return 1 + this.rest.length();
  }

  @Override
  public BigNumber shiftRight(int rShift) {
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(this.toString());
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    }
    return shiftRightHelp(rShift);
  }

  public BigNumber shiftRightHelp(int num) {
    if (num >= this.length()) {
      return new ElementNode(0, new EmptyNode());
    }
    String str = this.toString().substring(0, this.length() - num);
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(str);
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    }
    return new BigNumberImpl(str);
  }

  @Override
  public BigNumber shiftLeftHelp(int num) {
    this.rest = this.rest.shiftLeftHelp(num);
    return this;
  }

  @Override
  public BigNumber shiftLeft(int lShift) {
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(this.toString());
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    } else
      for (int i = 0; i < lShift; i++) {
        shiftLeftHelp(lShift);
      }
    return this;
  }

  @Override
  public BigNumber addDigit(int num) {
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher("" + num);
    if (matcher.matches()) {
      int sum = Integer.parseInt(String.valueOf(this.toString().charAt(this.length() - 1)));
      sum = sum + num;
      if (sum >= 10) {
        int carry = 1;
        int temp = Integer.parseInt(String.valueOf(this.toString().charAt(this.length() - 2)));
        temp = temp + carry;
        String fina = this.toString().substring(0, this.length() - 2);
        return new BigNumberImpl(fina + temp + sum);
      } else {
        String fina = this.toString().substring(0, this.length() - 1);
        return new BigNumberImpl(fina + sum);
      }
    } else
      throw new IllegalArgumentException("Digit required!");
  }

  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    if (pos > this.length() - 1 || pos < 0) {
      throw new IllegalArgumentException("Invalid Position!");
    }
    return Integer.parseInt(this.toString().substring(this.length() - 1 - pos, this.length() - pos));
  }

  @Override
  public BigNumber copy() {
    return new BigNumberImpl(this.toString());
  }

  @Override
  public BigNumber add(BigNumber Bn) {
    int temp = Integer.parseInt(String.valueOf(this.toString()));
    temp = temp + Integer.parseInt(String.valueOf(Bn.toString()));
    BigNumber Big = new BigNumberImpl("" + temp);
    return Big;
  }

  @Override
  public int compareTo(BigNumber bNum) {
    String s1 = this.toString();
    s1 = s1.replaceFirst("^0+(?!$)", "");
    String s2 = bNum.toString();
    s2 = s2.replaceFirst("^0+(?!$)", "");
    if (s1.length() > s2.length()) {
      return 1;
    } else if (s2.length() > s1.length()) {
      return -1;
    } else {
      for (int i = 0; i < s1.length(); i++) {
        int temp = Integer.parseInt(String.valueOf(s1.charAt(i))) - Integer.parseInt(String.valueOf(s2.charAt(i)));
        System.out.println(Integer.parseInt(String.valueOf(s1.charAt(i))) + "s1");
        System.out.println(Integer.parseInt(String.valueOf(s2.charAt(i))) + "s2");
        if (temp > 0) {
          return 1;
        } else if (temp < 0) {
          return -1;
        }
      }
      return 0;
    }
  }

  @Override
  public String toString() {
    return this.num + this.rest.toString();
  }
}
