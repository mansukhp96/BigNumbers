package bignumber;

public interface NodeInterface {

  int count();

  NodeInterface shiftLeft();

  NodeInterface shiftRight(int rShift);

  NodeInterface addDigit(int num);

  int getDigitAt(int pos);

  NodeInterface copy();

  NodeInterface add(NodeInterface bigNum);

  int compareTo(NodeInterface Bn);
}
