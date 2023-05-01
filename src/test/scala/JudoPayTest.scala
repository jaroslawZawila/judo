import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.time.Instant
import scala.util.Random;

class JudoPayTest extends AnyFlatSpec with Matchers {

  import JudoPay._;

  def lenghtOfLongerSubstringTest(name: String,
                                  calculateLength: String => Int) {
    it should "return zero for empty string" in {
      calculateLength("") shouldBe 0
    }

    it should "return 1 for single element" in {
      calculateLength("a") shouldBe 1
    }

    it should "return 1 for string of the same character" in {
      val string =
        List.iterate('A', Random.nextInt(1000))(identity).mkString("")

      calculateLength(string) shouldBe 1
    }

    it should "handle 3 different characters" in {
      calculateLength("abc") shouldBe 3
    }

    it should "handle repeated pattern of characters" in {
      calculateLength("abcabcabcc") shouldBe 3
    }

    it should "handle 2 different characters" in {
      calculateLength("au") shouldBe 2
    }

    it should "handle 2 different characters with multiplayed first" in {
      calculateLength("aau") shouldBe 2
    }

    it should "handle repeated characters of different patterns" in {
      calculateLength("ababbcbccdcddeded") shouldBe 2
    }

    it should "handle pwwkew string" in {
      calculateLength("pwwkew") shouldBe 3
    }

    it should "handle aabaab!bb" in {
      calculateLength("aabaab!bb") shouldBe 3
    }

    s"Execution time ${name}" should "printed" in {
      val string = Random.alphanumeric.take(50000).mkString("")

      val before = Instant.now().toEpochMilli;
      calculateLength(string)
      val time = Instant.now().toEpochMilli - before
      println(time)

    }
  }

  "Immutable implementation" should behave like lenghtOfLongerSubstringTest(
    "immutable",
    lengthOfLongestSubstring
  )

  "Mutable implementation" should behave like lenghtOfLongerSubstringTest(
    "mutable",
    lengthOfLongestSubstring2
  )

}
