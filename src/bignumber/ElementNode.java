package bignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents the Element Node class for the BigNumber. This is the element node that
 * contains the input sent as digits in each node.
 */

public class ElementNode implements BigNumber {
  private int num;
  private BigNumber rest;

  /**
   * This constructor creates a node with the number and the rest of the numbers.
   *
   * @param num  is the number that was entered into the node.
   * @param rest is the remaining numbers apart from the head.
   */
  public ElementNode(int num, BigNumber rest) {
    this.num = num;
    this.rest = rest;
  }

  /**
   * A method to find the size of the list.
   *
   * @return the length of the input.
   */
  @Override
  public int length() {
    return 1 + this.rest.length();
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
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(this.toString());
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    }
    return shiftRightHelp(rShift);
  }

  /**
   * Shift right helper method.
   */
  public BigNumber shiftRightHelp(int num) {
    if (num >= this.length()) {
      return new ElementNode(0, new EmptyNode());
    }
    String str = this.toString().substring(0, this.length() - num);
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(str);
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    }
    return new BigNumberImpl(str);
  }

  /**
   * shiftLeft Helper method.
   *
   * @param num is the number of shifts that are to be done on the number.
   */
  @Override
  public BigNumber shiftLeftHelp(int num) {
    this.rest = this.rest.shiftLeftHelp(num);
    return this;
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
    Pattern pattern = Pattern.compile("[0]+");
    Matcher matcher = pattern.matcher(this.toString());
    if (matcher.matches()) {
      return new ElementNode(0, new EmptyNode());
    } else {
      for (int i = 0; i < lShift; i++) {
        shiftLeftHelp(lShift);
      }
    }
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
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher("" + digit);
    if (matcher.matches()) {
      int sum = Integer.parseInt(String.valueOf(this.toString().charAt(this.length() - 1)));
      sum = sum + digit;
      if (sum >= 10) {
        int carry = 1;
        int temp = Integer.parseInt(String.valueOf(this.toString().charAt(this.length() - 2)));
        temp = temp + carry;
        String fina = this.toString().substring(0, this.length() - 2);
        return new BigNumberImpl(fina + temp + sum);
      } else {
        String fina = this.toString().substring(0, this.length() - 1);
        return new BigNumberImpl(fina + sum);
      }
    } else {
      throw new IllegalArgumentException("Digit Illegal!");
    }
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
    if (pos > this.length() - 1 || pos < 0) {
      throw new IllegalArgumentException("Invalid Position!");
    }
    return Integer.parseInt(this.toString()
            .substring(this.length() - 1 - pos, this.length() - pos));
  }

  /**
   * This method creates a copy of the input list and returns it.
   *
   * @return the new duplicated list.
   */
  @Override
  public BigNumber copy() {
    return new BigNumberImpl(this.toString());
  }

  /**
   * Takes in another input number list and adds both the lists.
   *
   * @param anotherList another number list.
   * @return new list that is the sum of the two lists
   */
  @Override
  public BigNumber add(BigNumber anotherList) {
    int temp = Integer.parseInt(String.valueOf(this.toString()));
    temp = temp + Integer.parseInt(String.valueOf(anotherList.toString()));
    BigNumber bigN = new BigNumberImpl("" + temp);
    return bigN;
  }

  /**
   * Compares two BigNumber lists.
   *
   * @param anotherList another list that has to be compared.
   * @return if the new list if greater than, lesser than or equal to the list.
   */
  @Override
  public int compareTo(BigNumber anotherList) {
    String s1 = this.toString();
    s1 = s1.replaceFirst("^0+(?!$)", "");
    String s2 = anotherList.toString();
    s2 = s2.replaceFirst("^0+(?!$)", "");
    if (s1.length() > s2.length()) {
      return 1;
    } else if (s2.length() > s1.length()) {
      return -1;
    } else {
      for (int i = 0; i < s1.length(); i++) {
        int temp = Integer.parseInt(String.valueOf(s1.charAt(i)))
                - Integer.parseInt(String.valueOf(s2.charAt(i)));
        if (temp > 0) {
          return 1;
        } else if (temp < 0) {
          return -1;
        }
      }
      return 0;
    }
  }

  /**
   * returns the string that was sent as input.
   */
  @Override
  public String toString() {
    return this.num + this.rest.toString();
  }
}