import org.junit.Test;

import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import static org.junit.Assert.assertEquals;

public class BigNumberImplTest {

  private BigNumber num;

  @Test
  public void testInit() {
    num = new BigNumberImpl("19123");
    assertEquals("yo", num.length());
  }

  @Test
  public void testRShift() {
    num = new BigNumberImpl("456");
    assertEquals("yo2", num.shiftRight(1));
  }

  @Test
  public void testLShift() {
    num = new BigNumberImpl("789");
    assertEquals("yo2", num.shiftLeft(-2));
  }
}
