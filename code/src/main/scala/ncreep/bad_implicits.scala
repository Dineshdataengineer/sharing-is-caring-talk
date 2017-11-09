package ncreep

import scala.language.implicitConversions

object BadImplicits {
  implicit def appID(value: Int): AppID = AppID(value)
  implicit def postID(value: Int): PostID = PostID(value)
  implicit def feedID(value: Int): FeedID = FeedID(value)
}