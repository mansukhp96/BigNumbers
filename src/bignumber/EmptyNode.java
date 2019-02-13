package bignumber;

public class EmptyNode implements BigNumber {

  @Override
  public int length() {
    return 0;
  }

  @Override
  public BigNumber shiftLeftHelp(int num) {
    return new ElementNode(0, this);
  }

  @Override
  public BigNumber shiftLeft(int lShift) {
    return this;
  }

  @Override
  public BigNumber shiftRight(int rShift) {
    return this;
  }

  @Override
  public BigNumber addDigit(int num) {
    return null;
  }

  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    return -6;
  }

  @Override
  public BigNumber copy() {
    return this;
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
    return "";
  }
}