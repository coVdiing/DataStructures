package com.vi.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//创建一个原始二维数组11*11
				//0:表示没有棋子，1表示黑子，2表示蓝子
				int chessArr1[][] = new int[11][11];
				chessArr1[1][2] = 1;
				chessArr1[2][3] = 2;
				int sum = 0;
				//输出原始的二维数组
				for (int[] row : chessArr1) {
					for(int data : row) {
						System.out.printf("%d\t",data);
					}
					System.out.println();
				}
				
				//将二维数组转稀疏数组的思想
				for (int i = 0; i < chessArr1.length;i++) {
					for(int j = 0; j < chessArr1[0].length;j++) {
						if(chessArr1[i][j] != 0) {
							sum++;
						}
					}
				}
				System.out.println("sum="+sum);
			
				//2.创建对应的稀疏数组
				int sparseArr[][] = new int[sum+1][3];
				//给稀疏数组赋值
				sparseArr[0][0] = chessArr1.length;
				sparseArr[0][1] = chessArr1[0].length;
				sparseArr[0][2] = sum;
				int count = 0;
				//3.遍历二维数组，将非0的值存放到sparseArr中
				for (int i = 0; i < chessArr1.length;i++) {
					for(int j = 0; j < chessArr1[0].length;j++) {
						if(chessArr1[i][j] != 0) {
							count++;
							sparseArr[count][0] = i;
							sparseArr[count][1] = j;
							sparseArr[count][2] = chessArr1[i][j];
						}
					}
				}
				
				//输出稀疏数组的形式
				System.out.println();
				System.out.println("得到稀疏数组为:");
				for(int i = 0; i < sparseArr.length;i++) {
					System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
					System.out.println();
				}
	}

	
	
}
