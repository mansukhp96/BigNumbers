package bignumber;

/**
 * This class represents the Empty Node class for the BigNumber. This is the Empty node that exists
 * at the end of a list.
 */

public class EmptyNode implements BigNumber {

  /**
   * A method to find the size of the list.
   *
   * @return the length of the input.
   */
  @Override
  public int length() {
    return 0;
  }

  /**
   * shiftLeft Helper method.
   *
   * @param num is the number of shifts that are to be done on the number.
   */
  @Override
  public BigNumber shiftLeftHelp(int num) {
    return new ElementNode(0, this);
  }

  /**
   * This methods shifts the input to the left if a positive lShift number is provided. It shifts
   * the input to the right if a negative number is sent.
   *
   * @param lShift number of left shifts, or right shifts if the number is negative.
   * @return the new list that is the result of leftShift.
   */
  @Override
  public BigNumber shiftLeft(int lShift) {
    return this;
  }

  /**
   * This methods shiftts the input to the right if a positive rShift number is provided. It shifts
   * the input to the left if a negative number is sent.
   *
   * @param rShift number of right shifts, or left shifts if the number is negative
   * @return the new list that is the result of rightShift.
   */
  @Override
  public BigNumber shiftRight(int rShift) {
    return this;
  }

  /**
   * This method adds a single non-negative number to the input.
   *
   * @param digit is the number to be added to the input number.
   * @return the new list that is the result of adding the new number to the input.
   * @throws IllegalArgumentException if the digit is not a single non-negative number.
   */
  @Override
  public BigNumber addDigit(int digit) throws IllegalArgumentException {
    throw new IllegalArgumentException("Illegal!");
  }

  /**
   * this methods gets the digit at the given position passed to it.
   *
   * @param pos is the position of the digit that has to be returned.
   * @return returns the actual digit in the input at the given position.
   * @throws IllegalArgumentException IllegalArgumentException if the position entered is more than
   *                                  the input length.
   */
  @Override
  public int getDigitAt(int pos) throws IllegalArgumentException {
    throw new IllegalArgumentException("Illegal!");
  }

  /**
   * This method creates a copy of the input list and returns it.
   *
   * @return the new duplicated list.
   */
  @Override
  public BigNumber copy() {
    return this;
  }

  /**
   * Takes in another input number list and adds both the lists.
   *
   * @param anotherList another number list.
   * @return new list that is the sum of the two lists
   */
  @Override
  public BigNumber add(BigNumber anotherList) {
    return null;
  }

  /**
   * Compares two BigNumber lists.
   *
   * @param anotherList another list that has to be compared.
   * @return if the new list if greater than, lesser than or equal to the list.
   */
  @Override
  public int compareTo(BigNumber anotherList) {
    return 0;
  }

  /**
   * returns the string that was sent as input.
   */
  @Override
  public String toString() {
    return "";
  }
}