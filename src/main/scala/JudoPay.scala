import scala.collection.mutable

object JudoPay {
  def lengthOfLongestSubstring(s: String) = {
    s.foldLeft[(List[Char], Int)](List.empty, 0) {
        case ((previous, maxLength), c) if !previous.contains(c) =>
          (previous :+ c, Math.max(maxLength, previous.length + 1))

        case ((previous, maxLength), c) =>
          val removedDuplication = previous.dropWhile(_ != c).drop(1)
          (
            removedDuplication :+ c,
            Math.max(maxLength, removedDuplication.length)
          )
      }
      ._2
  }

  def lengthOfLongestSubstring2(s: String) = {
    val characterIndex: mutable.Map[Char, Int] = mutable.HashMap[Char, Int]()

    s.foldLeft((0, 0, 0)) {
        case ((index1, index2, longest), next) =>
          val ii = if (characterIndex.contains(next)) {
            Math.max(characterIndex.getOrElse(next, -1), index2)
          } else index2
          characterIndex += (next -> (index1 + 1))
          (index1 + 1, ii, Math.max(longest, index1 - ii + 1))
      }
      ._3
  }
}
