package bignumber;

public interface BigNumber {

  int length();

  long shiftLeft(int lShift);

  long shiftRight(int rShift);

  long addDigit(int num) throws IllegalArgumentException;

  long getDigitAt(int pos) throws IllegalArgumentException;

  long copy();

  BigNumber add(BigNumber bigNum);

  boolean cmp(BigNumber bNum1, BigNumber bNum2);

}
