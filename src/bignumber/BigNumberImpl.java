package bignumber;

public class BigNumberImpl implements BigNumber {

  private String data;

  public BigNumberImpl() {
    this.data = "0";
  }

  public BigNumberImpl(String data) {
    this.data = data;
  }

  @Override
  public int length() {
    return data.length();
  }

  @Override
  public long shiftRight(int rShift) {
    if (rShift > 0) {
      int temp = Integer.parseInt(this.data);
      return (long) (temp / Math.pow(10, rShift));
    } else
      return shiftLeft(Math.abs(rShift));
  }

  @Override
  public long shiftLeft(int lShift) {
    if (lShift > 0) {
      int temp = Integer.parseInt(this.data);
      return (long) (temp * Math.pow(10, lShift));
    } else {
      return shiftRight(Math.abs(lShift));
    }
  }

  @Override
  public long addDigit(int num) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public long getDigitAt(int pos) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public long copy() {
    return 0;
  }

  @Override
  public BigNumber add(BigNumber Bn) {
    return null;
  }

  @Override
  public boolean cmp(BigNumber Bn, BigNumber Bnq) {
    return true;
  }
}