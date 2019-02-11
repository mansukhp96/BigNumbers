package bignumber;

public interface NodeInterface {

  int length();

  NodeInterface shiftLeft(int lShift);

  NodeInterface shiftRight(int rShift);

  NodeInterface addDigit(int num);

  NodeInterface getDigitAt(int pos);

  NodeInterface copy();

  NodeInterface add(NodeInterface bigNum);

  int compareTo(NodeInterface Bn);
}
