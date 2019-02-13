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
    BigNumber big = new BigNumberImpl(str);
    return big;
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
//      int temp = Integer.parseInt(String.valueOf(this.toString()));
//      temp = temp + num;
//      BigNumber Big = new BigNumberImpl("" + temp);
//      System.out.println(temp);
//      return Big;
//  } else
//          throw new
//
//  IllegalArgumentException("Digit");
  }

  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    if (pos > this.length() - 1 || pos < 0) {
      throw new IllegalArgumentException("Invalid Position");
    } else {
      String str = new StringBuilder(this.toString()).reverse().toString();
      return Integer.parseInt(String.valueOf(str.charAt(pos)));
    }
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
    return 0;
  }

  @Override
  public String toString() {
    return this.num + this.rest.toString();
  }
}
