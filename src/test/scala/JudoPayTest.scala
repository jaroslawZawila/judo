import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Random;

class JudoPayTest extends AnyFlatSpec with Matchers {

  import JudoPay._;

  "The longest string" should "return zero for empty string" in {
    lengthOfLongestSubstring("") shouldBe 0
  }

  it should "return 1 for single element" in {
    lengthOfLongestSubstring("a") shouldBe 1
  }

  it should "return 1 for string of the same character" in {
    val string = List.iterate('A', Random.nextInt(1000))(identity).mkString("")

    lengthOfLongestSubstring(string) shouldBe 1
  }

  it should "handle 3 different characters" in {
    lengthOfLongestSubstring("abc") shouldBe 3
  }

  it should "handle repeated pattern of characters" in {
    lengthOfLongestSubstring("abcabcabcc") shouldBe 3
  }

}
