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
    return null;
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
    return this;
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
    return null;
  }

  @Override
  public int compareTo(BigNumber Bn) {
    return 0;
  }

  @Override
  public String toString() {
    return this.num + this.rest.toString();
  }
}
