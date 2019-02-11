package bignumber;

public interface BigNumber {

  int length();

  void shiftLeft(int lShift);

  void shiftRight(int rShift);

  void addDigit(int num);

  int getDigitAt(int pos);

  BigNumber copy();

  BigNumber add(BigNumber bigNum);

  int compareTo(BigNumber Bn);
}
