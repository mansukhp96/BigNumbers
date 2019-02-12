package bignumber;

/**
 * This interface represents a BigNumber list. It represents the various operations that can be
 * done.
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

  void shiftLeft(int lShift);

  /**
   * This shifts the list to the right by the number of times passed as a parameter. if the
   * parameter is negative then the list is shifted to the left.
   *
   * @param rShift number of right shifts.
   */
  void shiftRight(int rShift);

  /**
   * Adds a digit to the passed input number.
   *
   * @param num is thhe number to be added to the input number.
   * @throws IllegalArgumentException if the number passed is not a single-digit non neg number.
   */

  void addDigit(int num) throws IllegalArgumentException;

  /**
   * Returns the number at a given position passed as a parameter.
   *
   * @param pos is the position of the digit that has to be returned
   * @return the digit at the passed position.
   */

  int getDigitAt(int pos);

  /**
   * Makes a copy of the number list input.
   *
   * @return the copy list.
   */

  BigNumber copy();

  /**
   * Takes in another input number list and adds both the lists.
   *
   * @param bNum another number list.
   * @return new list that is the sum of the two lists
   */

  BigNumber add(BigNumber bNum);

  /**
   * Compares two BigNumber objects.
   *
   * @param bNum another list that has to be compared.
   * @return if the new list if greater than, lesser than or equal to the list.
   */

  int compareTo(BigNumber bNum);
}
