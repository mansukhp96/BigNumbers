package bignumber;

/**
 * This interface represents a BigNumber list. It represents the various operations that can be done
 * on it.
 */
public interface BigNumber {
  /**
   * A method to find the size of the list.
   *
   * @return the size of the list.
   */
  int length();

  /**
   * This shifts the list to the left by the number of times passed as a parameter. if the parameter
   * is negative then the list is shifted to the right.
   *
   * @param lShift number of left shifts.
   */

  BigNumber shiftLeft(int lShift);

  /**
   * This shifts the list to the right by the number of times passed as a parameter. if the
   * parameter is negative then the list is shifted to the left.
   *
   * @param rShift number of right shifts.
   */
  BigNumber shiftRight(int rShift);

  /**
   * This method is a helper method for shiftLeft.
   *
   * @param num is the number of shifts that are to be done on the number.
   * @return to the shiftLeft method.
   */

  BigNumber shiftLeftHelp(int num);

  /**
   * Adds a digit to the passed input number.
   *
   * @param digit is thhe number to be added to the input number.
   * @return the new list with the resulted output of type BigNumber.
   * @throws IllegalArgumentException if the number passed is not a single-digit non neg number.
   */

  BigNumber addDigit(int digit) throws IllegalArgumentException;

  /**
   * Returns the number at a given position passed as a parameter.
   *
   * @param pos is the position of the digit that has to be returned.
   * @return the digit at the passed position.
   * @throws IllegalArgumentException if the position entered is more than the input length.
   */

  int getDigitAt(int pos) throws IllegalArgumentException;

  /**
   * Makes a copy of the number list input.
   *
   * @return the copy list.
   */

  BigNumber copy();

  /**
   * Takes in another input number list and adds both the lists.
   *
   * @param anotherList another number list.
   * @return new list that is the sum of the two lists
   */

  BigNumber add(BigNumber anotherList);

  /**
   * Compares two BigNumber lists.
   *
   * @param anotherList another list that has to be compared.
   * @return if the new list if greater than, lesser than or equal to the list.
   */

  int compareTo(BigNumber anotherList);
}