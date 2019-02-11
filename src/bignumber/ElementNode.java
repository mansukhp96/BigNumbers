package bignumber;

public class ElementNode implements NodeInterface {
  private int num;
  private NodeInterface rest;

  public ElementNode(int num, NodeInterface rest) {
    this.num = num;
    this.rest = rest;
  }

  @Override
  public int length() {
    return 1 + this.rest.length();
  }

  @Override
  public NodeInterface shiftRight(int rShift) {
    return null;
  }

  @Override
  public NodeInterface shiftLeft(int lShift) {
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
