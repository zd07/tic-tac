import java.util.HashMap;
import java.util.Scanner;

class TicTac{
    HashMap<Integer,String> map = new HashMap<Integer,String>();
    int win[][]=new int[3][8];
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";
public  final String ANSI_BLACK = "\u001B[30m";
// public static final String ANSI_RED = "\u001B[31m";
public  final String ANSI_GREEN = "\u001B[32m";
public  final String ANSI_YELLOW = "\u001B[33m";
public  final String ANSI_BLUE = "\u001B[34m";
public  final String ANSI_PURPLE = "\u001B[35m";
public  final String ANSI_CYAN = "\u001B[36m";
public  final String ANSI_WHITE = "\u001B[37m";
public  final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
public  final String ANSI_RED_BACKGROUND = "\u001B[41m";
public  final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
public  final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
public final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
public final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
public  final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
public  final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    TicTac(){
        int win[][] ={{1,2,3},
                      {4,5,6},
                      {7,8,9},
                      {1,4,7},
                      {2,5,8},
                      {3,6,9},
                      {1,5,9},
                      {3,5,7}
                    };
            this.win=win;
        // char ch='1';
         for(int i=1;i<=9;i++)
         map.put(i," ");
    }
    void designTicTac(){
        System.out.print("\t\t\t");
        System.out.println("  " + map.get(1) +ANSI_GREEN + " |  " + ANSI_RESET + map.get(2) + ANSI_GREEN +  " | "+ ANSI_RESET + map.get(3));
        System.out.print("\t\t\t");
        System.out.println(  ANSI_GREEN + "----|----|----" + ANSI_RESET);
        System.out.print("\t\t\t");
        System.out.println("  " + map.get(4) +ANSI_GREEN + " |  " + ANSI_RESET + map.get(5) + ANSI_GREEN +  " | "+ ANSI_RESET + map.get(6));
        System.out.print("\t\t\t");
        System.out.println(  ANSI_GREEN + "----|----|----" + ANSI_RESET);
        System.out.print("\t\t\t");
        System.out.println("  " + map.get(7) +ANSI_GREEN + " |  " + ANSI_RESET + map.get(8) + ANSI_GREEN +  " | "+ ANSI_RESET + map.get(9));
    }
    boolean isFull(int val){
        if(map.get(val) == " "){
            return false;
        }
        return true;
    }
    void putValue(int val,String c){
        map.put(val,c);
        System.out.println(map.get(val));
    }
    boolean checkWin(){
       for(int i=0;i<win.length;i++){
        if(map.get(win[i][0]) != " " && map.get(win[i][0])==map.get(win[i][1]) && map.get(win[i][1])==map.get(win[i][2])){
            // map.put(win[i][0],ANSI_PURPLE_BACKGROUND + map.get(win[i][0])+ ANSI_RESET );
            // map.put(win[i][1],ANSI_PURPLE_BACKGROUND + map.get(win[i][1])+ ANSI_RESET );
            // map.put(win[i][2],ANSI_PURPLE_BACKGROUND + map.get(win[i][2])+ ANSI_RESET );

            return true;
        }
       }
        return false;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTac t1=new TicTac();
        System.out.println("Player-1:X\nPlayer-2:O");
        t1.designTicTac();
        int count=0;
        while(true){
            if(count%2==0){
                System.out.println(t1.ANSI_BLUE +"Player-X turn." + t1.ANSI_RESET);
                System.out.println("\rEnter Box number:" );
                int x=sc.nextInt();
                if(t1.isFull(x)){
                    System.out.println(  "This place is alreay occupieed" );
                    continue;
                }
                t1.putValue(x,"X");
                t1.designTicTac();
                if(t1.checkWin()){
                    System.out.println("Player-X:Won");
                    t1.designTicTac();
                    break;
                }
                count++;
            }
            else{
                System.out.println(t1.ANSI_YELLOW +"Player-O turn." + t1.ANSI_RESET);
                System.out.println("Enter Box number:");
                int x=sc.nextInt();
                if(t1.isFull(x)){
                    System.out.println(t1.ANSI_RED + "This place is alreay occupieed" + t1.ANSI_RESET);
                    continue;
                }
                t1.putValue(x,"O");
                t1.designTicTac();
                if(t1.checkWin()){
                    System.out.println("Player-O:Won");
                    break;
                }

                count++;
            }
            if(count==9){
                System.out.println("Match Draw");
                break;
            }

    }
    }
}