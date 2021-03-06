package com.algorithm.data.graph;

/**
 * Leetcode 朋友圈问题
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ithand jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 */

//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
//The 2nd student himself is in a friend circle. So return 2.

//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
//so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
public class FriendCircle {

	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0)
			return 0;
		int n = M.length;
		boolean[] visited = new boolean[n];
		int count = 0;
		// 如果dfs大于0，说明有未遍历的结点
		// 只需要遍历所有结点
		for (int i = 0; i < n; i++)
			if (dfs(M, i, visited) > 0)
				count++;
		return count;
	}
	
	// 返回值代表i元素下最深路径节点的个数
	public int dfs(int[][] mat, int i, boolean[] visited) {
		if (visited[i])
			return 0;
		visited[i] = true;
		int count = 1;
		for (int j = 0; j < visited.length; j++)
			if (i != j && mat[i][j] == 1)
				count += dfs(mat, j, visited);
		return count;
	}

	
	public static void main(String[] args) {
//		int[][] mat = {{1,1,0,1},{1,1,1,0},{0,1,1,0},{1,0,0,1}};
//		int[][] mat = {{1,1,0},{1,1,1},{0,1,1}};
		int[][] mat = {{0,1,1,1},{1,0,0,1},{1,0,0,1},{1,1,1,0}};
		boolean[] visited = new boolean[4];
		FriendCircle circle = new FriendCircle();
//		circle.bfs(mat,0,visited);
		System.out.println(circle.dfs(mat, 0, visited));
	}
	
}
