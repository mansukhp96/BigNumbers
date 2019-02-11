package bignumber;

public class BigNumberImpl implements BigNumber {

  private NodeInterface head;

  public BigNumberImpl() {
    head = new ElementNode(0, new EmptyNode());
  }

  public BigNumberImpl(String data) {
    for (int i = 0; i < data.length(); i++) {
      new BigNumberImpl(Integer.parseInt(String.valueOf(data.charAt(i))));
    }
  }

  private BigNumberImpl(int data) {
  }

  @Override
  public int length() {
    return head.length();
  }

  @Override
  public void shiftRight(int rShift) {
  }

  @Override
  public void shiftLeft(int lShift) {
  }

  @Override
  public void addDigit(int num) throws IllegalArgumentException {
  }

  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public BigNumber copy() {
    return null;
  }

  @Override
  public BigNumber add(BigNumber Bn) {
    return null;
  }

  @Override
  public int compareTo(BigNumber Bn) {
    return 0;
  }

  public static void main(String[] args) {
    BigNumberImpl x = new BigNumberImpl("9876");
  }
}