package bignumber;

public class BigNumberImpl implements BigNumber {

  private NodeInterface head;

  public BigNumberImpl() {
    head = new ElementNode(0, new EmptyNode());
  }

  public BigNumberImpl(String data) {
    head = new ElementNode(0, new EmptyNode());
    for (int i = 0; i < data.length(); i++) {
      this.head = head.shiftLeft();
      this.head = head.addDigit(data.charAt(i));
    }
  }

  @Override
  public int length() {
    return head.count() - 1;
  }

  @Override
  public void shiftRight(int rShift) {
    head = head.shiftRight(rShift);
  }

  @Override
  public void shiftLeft(int lShift) {
    head = head.shiftLeft();
  }

  @Override
  public void addDigit(int num) {
    head = head.addDigit(num);
  }

  @Override
  public int getDigitAt(int pos) {
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
}