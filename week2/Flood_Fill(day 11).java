/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, 
and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), 
and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
*/


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor)
        {
            return image;
        }
        fillflood(image,image[sr][sc],newColor,sr,sc);
        return image;
    }
    public void fillflood(int[][] image,int color,int newColor,int i,int j)
    {
        if(i>=image.length || i<0 || j>=image[i].length || j<0 || image[i][j]!=color)
            return;
        image[i][j]=newColor;
        fillflood(image,color,newColor,i,j+1);
        fillflood(image,color,newColor,i,j-1);
        fillflood(image,color,newColor,i+1,j);
        fillflood(image,color,newColor,i-1,j);
    }
}
