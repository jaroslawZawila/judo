import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers;

class JudoPayTest extends AnyFlatSpec with Matchers {

  import JudoPay._;

  "The longest string" should "return zero for empty string" in {
    lengthOfLongestSubstring("") shouldBe 0
  }

  it should "return 1 for single element" in {
    lengthOfLongestSubstring("a") shouldBe 1
  }

}
