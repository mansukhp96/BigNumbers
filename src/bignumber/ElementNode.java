package bignumber;

public class ElementNode implements NodeInterface {
  private int num;
  private NodeInterface rest;

  public ElementNode(int num, NodeInterface rest) {
    this.num = num;
    this.rest = rest;
  }

  @Override
  public int count() {

    return 1 + this.rest.count();
  }

  @Override
  public NodeInterface shiftRight(int rShift) {

    return null;
  }

  @Override
  public NodeInterface shiftLeft() {
    return new ElementNode(0, this);
  }

  @Override
  public NodeInterface addDigit(int num) {
//    int cary = 0;
//    this =
    return this;
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
