package bignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements the BigNumber interface, and hence implements all it's methods. All the
 * operations implementations are available here.
 */

public class BigNumberImpl implements BigNumber {

  private BigNumber head; //head that keeps track of the head of the list

  /**
   * A constructor that creates a list with the number 0 and length 1.
   */
  public BigNumberImpl() {
    head = new ElementNode(0, new EmptyNode());
  }

  /**
   * A constructor that creates a list with the given input number as a string.
   *
   * @param data is the input provided that is a string which will be represented as a number.
   * @throws IllegalArgumentException if the string input has anything but numbers in it.
   */
  public BigNumberImpl(String data) throws IllegalArgumentException {
    Pattern pattern = Pattern.compile("[0-9]+"); //Regex to check input is a string as a number.
    Matcher matcher = pattern.matcher(data);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid Input!");
    }
    head = new EmptyNode();
    head = numStr(data, data.length() - 1);
  }

  /**
   * Private helper method that converts the input string to nodes with the digits in the list.
   *
   * @param data is the input string number that was sent to the contructor.
   * @param pos  is the position to be inserted at.
   */
  private BigNumber numStr(String data, int pos) {
    if (pos >= 0) {
      this.head = new ElementNode(Integer.parseInt(String.valueOf(data.charAt(pos))), this.head);
      pos--;
      numStr(data, pos);
      return head;
    } else {
      return null;
    }
  }

  /**
   * A method to find the size of the list.
   *
   * @return the length of the input.
   */
  @Override
  public int length() {
    return head.length();
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
    if (rShift < 0) {
      return shiftLeft(Math.abs(rShift));
    }
    return head.shiftRight(rShift);
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
    if (lShift < 0) {
      return shiftRight(Math.abs(lShift));
    }
    return head.shiftLeft(lShift);
  }

  /**
   * Left Shift helper method.
   *
   * @param num is the number of shifts that are to be done on the number.
   * @return type of BigNumber to the ShiftLeft.
   */
  @Override
  public BigNumber shiftLeftHelp(int num) {
    return head.shiftLeftHelp(num);
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
    return head.addDigit(digit);
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
    return head.getDigitAt(pos);
  }

  /**
   * This method creates a copy of the input list and returns it.
   *
   * @return the new duplicated list.
   */
  @Override
  public BigNumber copy() {
    return head.copy();
  }

  /**
   * Takes in another input number list and adds both the lists.
   *
   * @param anotherList another number list.
   * @return new list that is the sum of the two lists
   */
  @Override
  public BigNumber add(BigNumber anotherList) {
    return head.add(anotherList);
  }

  /**
   * Compares two BigNumber lists.
   *
   * @param anotherList another list that has to be compared.
   * @return if the new list if greater than, lesser than or equal to the list.
   */

  @Override
  public int compareTo(BigNumber anotherList) {
    return head.compareTo(anotherList);
  }

  /**
   * returns the string that was sent as input.
   */
  @Override
  public String toString() {
    return head.toString();
  }
}