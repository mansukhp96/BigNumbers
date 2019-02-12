import org.junit.Test;

import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import static org.junit.Assert.assertEquals;

public class BigNumberImplTest {

  private BigNumber num;

  @Test
  public void testInit() {
    num = new BigNumberImpl("");
    assertEquals("yo", num.length());
  }
}
