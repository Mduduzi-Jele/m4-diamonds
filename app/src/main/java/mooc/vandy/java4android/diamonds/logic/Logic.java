package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();


    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here

        int numberOfRows = size * 2 - 1;
        int midpoint = Math.round(numberOfRows / 2) + 1;
        int numberOfColumns = size * 2;
        int seperator = 0;
        int topCounter = (numberOfRows / 2) + 1;
        int bottomCounter = numberOfRows - topCounter;

        printTopAndBottomFrame(numberOfColumns);
        mOut.println("");
        for( int i = 1; i <= topCounter; i++){

            mOut.print("|");

            for(int j = numberOfColumns / 2 - i; j > 0; j--){
                mOut.print(" ");
            }

            if( i== midpoint){
                mOut.print("<");
            } else {
                mOut.print("/");
            }

            if( i%2 == 0){
                for(int k = seperator; k > 0; k--){
                    mOut.print("-");
                }
            } else {
                for( int k = seperator; k > 0; k--){
                    mOut.print("=");
                }
            }

            if( i == midpoint){
                mOut.print(">");
            } else {
                mOut.print("\\");
            }

            for(int j = numberOfColumns / 2 - i; j > 0; j--){
                mOut.print(" ");
            }

            mOut.print("|\n");

            (seperator) += 2;
        }
        //----------------------------------------

        for( int m = bottomCounter; m>=1; m--){
            seperator -= 2;

            mOut.print("|");

            for( int n = bottomCounter + 1; n > m; n--){
                mOut.print(" ");
            }

            mOut.print("\\");

            if( m % 2 == 0){
                for(int p = seperator - 2; p > 0; p--){
                    mOut.print("-");
                }
            } else {
                for(int p = seperator - 2; p > 0; p--){
                    mOut.print("=");
                }
            }

            mOut.print("/");

            for( int n = bottomCounter + 1; n > m; n--){
                mOut.print(" ");
            }

            mOut.print("|\n");
        }
        printTopAndBottomFrame(numberOfColumns);

    }

    // TODO -- add any helper methods here
    public void printTopAndBottomFrame(int numberOfColumns){
        mOut.print("+");
        for( int i = 0; i < numberOfColumns; i++){
            mOut.print("-");
        }
        mOut.print("+");
    }

    public void topSpacing(int numberOfColumns){

    }
    
}
