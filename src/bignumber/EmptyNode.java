package bignumber;

public class EmptyNode implements NodeInterface {

  @Override
  public int count() {
    return 0;
  }

  @Override
  public NodeInterface shiftLeft() {
    return this;
  }

  @Override
  public NodeInterface shiftRight(int rShift) {
    return this;
  }

  @Override
  public NodeInterface addDigit(int num) {
    return null;
  }

  @Override
  public int getDigitAt(int pos) {
    return 0;
  }

  @Override
  public NodeInterface copy() {

    return null;
  }

  @Override
  public NodeInterface add(NodeInterface Bn) {

    return null;
  }

  @Override
  public int compareTo(NodeInterface Bn) {

    return 0;
  }
}
