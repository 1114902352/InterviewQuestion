# 文件目录说明

##### com.algorithm.data(数据结构)
###### binaryTree(二叉树)
+ BinarySearchTree(二叉查找树)
```
// 二叉树查找树最小祖先
lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
// 获取目标节点路径，以字符串方式输出
getPath(TreeNode root,TreeNode target)
// 对二叉查找树上的每一个数字进行修改，其值为原值加上树中比其大的数
convertBST(TreeNode root)
// 二叉查找树新增节点
addNode(TreeNode root,int key)
// 二叉查找树删除节点
delete(TreeNode root,int val)
```

+ BinaryTreeUtil(二叉树工具类)
```
// 根据数组创建完全二叉树
createBinaryTree(Integer[] array)
// 广度优先遍历 Breadth First Search,队列实现
bfs(TreeNode root)
// 广度优先遍历,按层级输出
levelOrder(TreeNode root)
// 非递归先序遍历实现1
preorder1(TreeNode root)
// 非递归先序遍历实现2
preorder2(TreeNode root)
// 非递归的中序遍历
inorder(TreeNode root)
// 非递归的后序遍历
postOrder(TreeNode root)
// 二叉树遍历综合方法，先序/中序/后序
scanNodes(TreeNode root, String flag)
// 求最大深度
maxDepth(TreeNode root)
// 求最小深度
minDepth(TreeNode root)
// 判断两个二叉树是否是同一树
isSameTree(TreeNode p, TreeNode q)
// 寻找最底层最左边的节点
findBottomLeftValue(TreeNode root)
// 普通树 查找最小祖先方法1,通过递归直接查找
lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
// 普通树 查找最小祖先方法2,求出路径后再比较路径得出
lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)
// 找到指定目标在树中的路径
getPath(TreeNode root, TreeNode p, Stack<TreeNode> stackp)
// 判断是否是深度平衡树
isBalanced(TreeNode root)
// 置换二叉树的左右节点
invertTree(TreeNode root)
// 判断是否是为镜像树
isSymmetric(TreeNode root)
// 检查两个子树是否互为镜像树
isSymmetric(TreeNode t1,TreeNode t2)
// 合并两棵树
mergeTrees(TreeNode t1,TreeNode t2)
``` 

+ BTreePrinter(二叉树打印工具)

+ HeapSort(堆排序，借助最大堆)

+ MaximumBinaryTree(构建最大值二叉树，所有子树的根节点是最大值)

+ Permute(给定数组，求所有的排列组合，用深度遍历实现)

+ PruningBinaryTree(修剪一个值为0或者1的二叉树)

+ Subsets(给定数组，求所有的子序列)

+ Partition(给定数组，判断是否能分区，且分区之和相等)



###### graph(图)
+ AdjacencyListGraph(邻接列表)

+ AdjacencyMatrixGraph(邻接矩阵)

+ BroadFirstSearchAlgorithm(图广度优先算法封装)

+ FriendCircle(朋友圈问题)

+ Graph无向图
```
// 从起点到{@code vertex}点的最短路径
findPathTo(String vertex)
// 添加一条边
addEdge(String fromVertex, String toVertex)
// 添加一个顶点
addVertex(String vertex)
```

+ MatrixRotate(二维数组90度旋转)

###### queue(队列)
+ Queue(用两个栈实现队列)

###### singlelinked(单链表)
+ DelDuplicates(删除重复元素)

+ LinkedListCycle(判断单链表是否带环)

+ OddEvenList(列表中，奇数排最前，偶数排最后)

+ SingleLinked(单链表常规操作)
```
// 单链表遍历
scanNode(SingleLinked node)
// 单链表删除子节点 
deleteNode(SingleLinked node)
// 扭转单向链表
reverseList(SingleLinked head)
// 寻找最后一个节点
getLastOne(SingleLinked head)
// 合并两个有序链表，使新链表有序
mergeTwoLists(SingleLinked l1, SingleLinked l2)
// 链表排序
 sortLinkList(SingleLinked list)
```

###### string(字符串问题)
+ GenerateParenthesis(生成括号)

+ KMPSearch(KMP查找算法)

+ PartitionLabels(划分字母区间)

+ ScoreOfParentheses(括号分数)

+ Trie(AC自动机算法)

###### TOPK(TOPK算法)
+ MaxHeap(最大堆)
+ MinHeap(最小堆)
+ TopK(算法入口)

--- 

##### com.algorithm.dynamicProgramming(动态规划)
``` https://zhuanlan.zhihu.com/p/78220312 ```
+ Coin(硬币凑钱问题)