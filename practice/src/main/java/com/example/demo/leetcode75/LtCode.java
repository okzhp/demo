package com.example.demo.leetcode75;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhp
 * @date 2023/4/18 15:53
 **/
public class LtCode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //876. 链表的中间结点 快慢双指针，快指针每次走两步，慢指针每次走一步，快指针走到头时慢指针刚好停在链表中间。
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //142. 环形链表，遍历链表的同时将节点放在set中，遍历过程中如果set包含当前节点直接返回，否则不存在环。
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }



    //121. 买卖股票的最佳时机 遍历价格时，记录截止当前股票最低价，用今天的股价减去最低股价就是今天最大的利润，同时记录截止当前的最大利润，遍历结束即可获得最大利润。
    //ps: 动态规划dp[] 记录到第i天时的最大利润，数组可以优化为单个变量
    public int maxProfit(int[] prices) {
        int tmp = 0;
        for (int i = 1,min = prices[0]; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            tmp = Math.max(tmp,prices[i]-min);
        }
        return tmp;
    }

    //409. 最长回文串  ASCII码 字母z为122，因此建立大小为123的数组就够了。
    // 首先遍历一遍字符串并将偶数个的字母统计进去，最后还需要判断一下是否存在单个字符，单个字符只能算一次。
    public int longestPalindrome(String s) {
        int[] charArray = new int[123];
        int len = 0;
        for (char c : s.toCharArray()) {
            charArray[c]++;
            if ((charArray[c]&1)==0){
                len += 2;
                charArray[c] -= 2;
            }
        }
        for (int i : charArray) {
            if ((i&1)==1){
                len ++;
                break;
            }
        }
        return len;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //589. N叉树的前序遍历，前序遍历，递归访问根节点->子节点，同时将结果放在一个全局变量。
    List res598 = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res598;
        Node cur = root;
        res598.add(cur.val);
        List<Node> nodes = cur.children;
        for (Node node : nodes) {
            preorder(node);
        }
        return res598;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }
    }

    //---------------------------------------------------------------------------------------------------------
    //102. 二叉树的层序遍历 层序遍历属于广度优先搜索BFS，
    // BFS通常借助队列实现，首先将根节点放入队列，当队列不为空时，根据队列size判断每层的节点数量，按顺序出队，随后轮流将左右节点放入队列，
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null)queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left!=null)queue.add(cur.left);
                if (cur.right!=null)queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }

    //---------------------------------------------------------------------------------------------------------
    //704. 二分查找, 两个细节，1.右指针等于数组长度减一，而不是数组长度 2、while的条件 i<=j,注意可以等于。
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1,mid;
        while(i<=j){
            mid = (i+j)/2;
            if (nums[mid]==target)return mid;
            else if (nums[mid]>target)j=mid-1;
            else i = mid+1;
        }
        return -1;
    }


    @Test
    public void test(){

    }
    //278. 第一个错误的版本
//    public int firstBadVersion(int n) {
//        int left = 1, right = n ,mid=0;
//        while (left<right){
//            mid = left+(right-left)/2;
//            if (isBadVersion(mid)){
//                right = mid;
//            }else{
//                left = mid+1;
//            }
//        }
//        return left;
//    }

//---------------------------------------------------------------------------------------------------------
    private long pre = Long.MIN_VALUE;
    //98. 验证二叉搜索树   中序遍历，
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        if (!isValidBST(root.left))return false;
        if (root.val<=pre)return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    //---------------------------------------------------------------------------------------------------------

    //235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)return root;
        if ((p.val<=root.val&&q.val>=root.val)||(p.val>=root.val&&q.val<=root.val))return root;
        else if (p.val<=root.val&&q.val<=root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }

    }

    //---------------------------------------------------------------------------------------------------------
    int[] x = {0,1,0,-1};
    int[] y = {1,0,-1,0};
    //733. 图像渲染 方式一：广度优先搜索
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc]==color)return image;
        int curColor = image[sr][sc];
        image[sr][sc] = color;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{sr,sc});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + x[i],ny = cur[1] + y[i];
                if (!outSide(image, nx,ny)&&image[nx][ny]==curColor){
                    image[nx][ny] = color;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }
        return image;
    }
    private boolean outSide(int[][] image, int sr, int sc){
        return sr<0||sc<0||sr>=image.length||sc>=image[0].length;
    }
    //733. 图像渲染 方式二：深度优先搜索
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc]==color)return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    private int[][] dfs(int[][] image, int sr, int sc, int color, int curColor) {
        if (image[sr][sc]==curColor){
            image[sr][sc] = color;
            for (int i = 0; i < 4; i++) {
                int nx = sr + x[i],ny = sc + y[i];
                if (!outSide(image,nx,ny)&&image[nx][ny]==curColor){
                    dfs(image,nx,ny,color,curColor);
                }
            }
        }
        return image;
    }

//---------------------------------------------------------------------------------------------------------

    //200. 岛屿数量 深度优先搜索，每次搜索到陆地将数量加一并将整个陆地标记，
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    cnt++;
                    dfs200(grid,i,j);
                }

            }
        }
        return cnt;
    }
    private void dfs200(char[][] grid,int x,int y){
        if (x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]=='0'||grid[x][y]=='M')return;
        if (grid[x][y]=='1')grid[x][y]='M';
        dfs200(grid,x-1,y);
        dfs200(grid,x,y-1);
        dfs200(grid,x+1,y);
        dfs200(grid,x,y+1);
    }


    //509. 斐波那契数 1、使用动态规划数组 2、可以将数组优化为三个变量
    public int fib(int n) {
        if (n==0 || n==1)return n;
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
        int res=0,tmp=1,pre=0;
        for (int i = 2; i <= n; i++) {
            res = tmp + pre;
            pre = tmp;
            tmp = res;
//            dp[i] = dp[i-1] + dp[i-2];
        }
        return res;
    }


    //70. 爬楼梯 使用递归将超出时间限制
    public int climbStairs(int n) {
//        if (n==1||n==2)return n;
//        return climbStairs(n-1)+climbStairs(n-2);
        if (n==1||n==2)return n;
        int res = 0,tmp=2,pre=1;
        for (int i = 3; i <= n; i++) {
            res = tmp + pre;
            pre = tmp;
            tmp = res;

        }
        return res;
    }



    //746. 使用最小花费爬楼梯
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==1)return cost[0];
        if (cost.length==2)return Math.min(cost[0],cost[1]);
        //dp定义：爬到第i台阶最小花费
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        int res =0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i-2]+dp[i-2],cost[i-1]+dp[i-1]);
        }
        res = Math.min(dp[cost.length-1]+cost[cost.length-1],dp[cost.length-2]+cost[cost.length-2]);
        return res;
    }

    //62. 不同路径
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
