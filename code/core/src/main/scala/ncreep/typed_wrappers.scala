package ncreep

case class AppID(value: Int)
case class PostID(value: Int)
case class FeedID(value: Int)

case class PostContent(value: String)

object TypedWrappers {
  def fetchPost(appID: AppID,
                postID: PostID,
                feedID: FeedID): PostContent = ???
}