package com.coursea.part1.unionfind.question;

/**
 * Interview Questions: Union–Find
 * <p>
 * 第 1 个问题
 * Social network connectivity. Given a social network containing nn members and
 * a log file containing mm timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.
 * <p>
 * Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.
 * <p>
 * the key to this question is to tell whether all members  are connected.
 * Since the log file is sorted by timestamp, then we add the connection in turn,
 * and the timestamp which makes all members connected at first time is the timestamp we are looking for.
 * As for the question whether all the members are connected, we make a member special,
 * and use the improved weigh union find. we keep another set to record the member which has no connection to the special member.
 * we know they are all connected when the set is empty.
 * <p>
 * Union-find with specific canonical element.
 * Add a method \mathtt{find()}find() to the union-find data type so that \mathtt{find(i)}find(i)
 * returns the largest element in the connected component containing ii. The operations, \mathtt{union()}union(),
 * \mathtt{connected()}connected(), and \mathtt{find()}find() should all take logarithmic time or better.
 * <p>
 * For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9},
 * then the \mathtt{find()}find() method should return 99 for each of the four elements in the connected components.
 * <p>
 * The question requires logarithmic time, So we can neglect quick-find algorithm.
 * And quick union algorithm may end up with a very tall tree,
 * so we use weigh quick union algorithm. the question transfers to find the biggest member in a tree.
 * <p>
 * Successor with delete. Given a set of nn integers S = \{ 0, 1, ... , n-1 \}S={0,1,...,n−1} and a sequence of requests of the following form:
 * <p>
 * Remove xx from SS
 * Find the successor of xx: the smallest yy in SS such that y \ge xy≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */

/**
 * 第 1 个问题
 * Social network connectivity. Given a social network containing nn members and
 * a log file containing mm timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.
 *
 * Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.
 */
/**
 *the key to this question is to tell whether all members  are connected.
 * Since the log file is sorted by timestamp, then we add the connection in turn,
 * and the timestamp which makes all members connected at first time is the timestamp we are looking for.
 * As for the question whether all the members are connected, we make a member special,
 * and use the improved weigh union find. we keep another set to record the member which has no connection to the special member.
 * we know they are all connected when the set is empty.
 */


/**
 *Union-find with specific canonical element.
 * Add a method \mathtt{find()}find() to the union-find data type so that \mathtt{find(i)}find(i)
 * returns the largest element in the connected component containing ii. The operations, \mathtt{union()}union(),
 * \mathtt{connected()}connected(), and \mathtt{find()}find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is \{1, 2, 6, 9\}{1,2,6,9},
 * then the \mathtt{find()}find() method should return 99 for each of the four elements in the connected components.
 */
/**
 *The question requires logarithmic time, So we can neglect quick-find algorithm.
 * And quick union algorithm may end up with a very tall tree,
 * so we use weigh quick union algorithm. the question transfers to find the biggest member in a tree.
 */


/**
 * Successor with delete. Given a set of nn integers S = \{ 0, 1, ... , n-1 \}S={0,1,...,n−1} and a sequence of requests of the following form:
 *
 * Remove xx from SS
 * Find the successor of xx: the smallest yy in SS such that y \ge xy≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
/**
 *
 */