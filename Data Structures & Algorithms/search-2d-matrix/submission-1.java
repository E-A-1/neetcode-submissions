class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = matrix.length - 1;
        int ourTarget = 0;
        while (top <= bottom ) {
            int row = (top+bottom)/2;
            if (target> matrix[row][cols-1]){
                top = row+1;
            }else if (target < matrix[row][0]) {
                bottom = row -1;
            }
            else {
                break;
            }
        }

        if (!(top<=bottom)) {
            return false;
        }

        int row = (top + bottom)/2;
        int l = 0;
        int r = cols -1;
        while (l<=r) {
            int mid = (l+r)/2;
            if (target > matrix[row][mid]) {
                l = mid+1;
            }
            else if (target < matrix[row][mid]) {
                r = mid-1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
