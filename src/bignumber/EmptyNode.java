package bignumber;

public class EmptyNode implements NodeInterface {

  @Override
  public int length() {
    return 0;
  }

  @Override
  public NodeInterface shiftLeft(int lShift) {
    return null;
  }

  @Override
  public NodeInterface shiftRight(int rShift) {
    return null;
  }

  @Override
  public NodeInterface addDigit(int num) {
    return null;
  }

  @Override
  public NodeInterface getDigitAt(int pos) {
    return null;
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
