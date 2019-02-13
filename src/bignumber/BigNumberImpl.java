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
  public int length() {
    return head.length();
  }

  @Override
  public BigNumber shiftRight(int rShift) {
    if (rShift < 0) {
      return shiftLeft(Math.abs(rShift));
    }
    return head.shiftRight(rShift);
  }

  @Override
  public BigNumber shiftLeft(int lShift) {
    if (lShift < 0) {
      return shiftRight(Math.abs(lShift));
    }
    return head.shiftLeft(lShift);
  }

  @Override
  public BigNumber shiftLeftHelp(int num) {
    return head.shiftLeftHelp(num);
  }

  @Override
  public BigNumber addDigit(int num) {
    return head.addDigit(num);
  }

  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    return head.getDigitAt(pos);
  }

  @Override
  public BigNumber copy() {
    return head.copy();
  }

  @Override
  public BigNumber add(BigNumber Bn) {
    return head.add(Bn);
  }

  @Override
  public String toString() {
    return head.toString();
  }

  @Override
  public int compareTo(BigNumber bNum) {
    return head.compareTo(bNum);
  }
}