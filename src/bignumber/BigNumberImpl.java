package bignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigNumberImpl implements BigNumber {

  private BigNumber head;

  public BigNumberImpl() {
    head = new ElementNode(0, new EmptyNode());
  }

  public BigNumberImpl(String data) throws IllegalArgumentException {
    Pattern pattern = Pattern.compile("[0-9]+");
    Matcher matcher = pattern.matcher(data);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid Input!");
    }
    head = new EmptyNode();
    head = numStr(data, data.length() - 1);
  }

  private BigNumber numStr(String dat, int pos) {
    if (pos >= 0) {
      this.head = new ElementNode(Integer.parseInt(String.valueOf(dat.charAt(pos))), this.head);
      pos--;
      numStr(dat, pos);
      return head;
    } else
      return null;
  }

  @Override
  public BigNumber shiftLeftHelp(int num) {
    return head.shiftLeftHelp(num);
  }

  @Override
  public int length() {
    return head.length();
  }

  @Override
  public BigNumber shiftRight(int rShift) {
    return null;
  }

  @Override
  public BigNumber shiftLeft(int lShift) {
    return head.shiftLeft(lShift);
  }

  @Override
  public BigNumber addDigit(int num) {
    return null;
  }

  @Override
  public int getDigitAt(int pos) {
    return head.getDigitAt(pos);
  }

  @Override
  public BigNumber copy() {
    return head.copy();
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
    return head.toString();
  }

  public static void main(String[] args) {
    BigNumberImpl b = new BigNumberImpl("01");
    System.out.println(b.toString());
    System.out.println(b.length());
    //System.out.println(b.getDigitAt(10));
    //System.out.println(b.copy().toString());
    System.out.println(b.shiftLeft(3));
  }
}