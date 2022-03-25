import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static boolean isCompatible(int grid[][], int x, int y, int color, int n, int m){
        int rv[] = {0, 0, 1, -1};
        int cv[] = {1, -1, 0, 0};
        
        boolean flag = true;
        
        for(int i = 0; i < 4; i++){
            if (x + rv[i] < 0 || y + cv[i] < 0) continue;
            if (x + rv[i] >= n || y + cv[i] >= m) continue;
            
            if (grid[x + rv[i]][y + cv[i]] == color){
                flag = false;
                break;
            }
            
        }
        return flag;
    }
    
    public static void colorTheGrid(int grid[][], int n, int m, int x, int y){
        int maxUsed = 2;
        
        grid[x][y] = 0;
        
        isCompatible(grid, x, y, 1, m, n);
        
        for (int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                
                if (grid[r][c] == 0){
                    
                    for(int color = 1; color <= maxUsed; color++){
                        if(isCompatible(grid, r, c, color, n, m)){
                            grid[r][c] = color;
                            break;
                        }
                        
                    }
                    
                    if (grid[r][c] == 0){
                        grid[r][c] = maxUsed + 1;
                        maxUsed += 1;
                    }
                    
                }
            }
        }
    }
    
    
    public static void printTheGrid(int grid[][], int n, int m){
                
        for (int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++){
		    String temp[] = br.readLine().split(" ");
		    int n = Integer.parseInt(temp[0]);
		    int m = Integer.parseInt(temp[1]);
            
            temp = br.readLine().split(" ");
		    int x1 = Integer.parseInt(temp[0]);
		    int y1 = Integer.parseInt(temp[1]);
            
		    temp = br.readLine().split(" ");
		    int x2 = Integer.parseInt(temp[0]);
		    int y2 = Integer.parseInt(temp[1]);
            
            int grid[][] = new int[n][m];
                
            grid[x1 - 1][y1 - 1] = 1;
            grid[x2 - 1][y2 - 1] = 2;
            
            colorTheGrid(grid, n, m, x1 - 1, y1 - 1);
            printTheGrid(grid, n, m);
		}
	}
}
