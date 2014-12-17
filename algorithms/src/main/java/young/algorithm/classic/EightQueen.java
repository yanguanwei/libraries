package young.algorithm.classic;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-28
 */
public class EightQueen {
    private static final int SIZE = 8;
    private static int count =0;

    /**
     * chessboard[0][col] == true����col�����Ѿ���һ���ʺ��ˣ�
     * chessboard[1][row-col+SIZE]����row�е�col�е����Խ�������һ���ʺ��ˣ�
     * chessboard[2][row+col]����row�е�col�еĸ��Խ�������һ���ʺ��ˡ�
     */
    private static boolean[][] chessboard = new boolean[3][SIZE*2];

    public static int resolve() {
        count = 0;
        resolve(0);
        return count;
    }

    private static void resolve(int row) {
        if (row >= SIZE) {
            count++;
        } else {
            for (int col=0; col<SIZE; col++) {
                int diagonal = row - col + SIZE;
                int counterDiagonal = row + col;
                if (!chessboard[0][col] && !chessboard[1][diagonal] && !chessboard[2][counterDiagonal]) {
                    chessboard[0][col] = chessboard[1][diagonal] = chessboard[2][counterDiagonal] = true;
                    resolve(row+1);
                    chessboard[0][col] = chessboard[1][diagonal] = chessboard[2][counterDiagonal] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        resolve();
        System.out.println(count);
    }
}
