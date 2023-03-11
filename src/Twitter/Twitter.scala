package Twitter

import scala.collection.mutable


// https://leetcode.com/problems/design-twitter/description/
class Twitter() {

	private type UserId = Int
	private type TweetId = Int
	private type Post = (UserId, TweetId)

	private final val MAX_POSTS = 10

	private var feed: List[Post] = List()
	private val followees: mutable.HashMap[UserId, List[UserId]] =
		new mutable.HashMap[UserId, List[UserId]]()
			{ override def default(key: UserId): List[UserId] = List(key) }


	def postTweet(userId: UserId, tweetId: TweetId) {
		feed ::= (userId, tweetId)
	}

	def getNewsFeed(userId: UserId): List[TweetId] = {
		feed
		.filter(
			post => followees(userId).contains(post._1)
		)
		.take(MAX_POSTS)
		.map(_._2)
	}


	def follow(followerId: UserId, followeeId: UserId) {
		followees
		.update(
			followerId,
			followeeId :: followees(followerId)
		)
	}

	def unfollow(followerId: UserId, followeeId: UserId) {
		followees
		.update(
			followerId,
			followees(followerId)
			.diff(List(followeeId))
		)
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = new Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
