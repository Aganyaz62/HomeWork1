package HomeWork6;

class Solution {
    int ans;
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        ans=dfs(root);
        return ans;
    }
    public int dfs(Node root){
        if(root==null){
            return 0;
        }
        int maxDepth=0;
        for(Node i : root.children){
            maxDepth=Math.max(maxDepth,dfs(i));
        }
        return 1+maxDepth;
    }
}