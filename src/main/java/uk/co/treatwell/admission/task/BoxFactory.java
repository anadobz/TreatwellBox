package uk.co.treatwell.admission.task;

public class BoxFactory {
    public static final char VERTICAL_EDGE = (char) 0x2502;
    public static final char HORIZONTAL_EDGE = (char) 0x2500;
    public static final char TOP_LEFT_CORNER = (char) 0x250c;
    public static final char TOP_RIGHT_CORNER = (char) 0x2510;
    public static final char BOTTOM_LEFT_CORNER = (char) 0x2514;
    public static final char BOTTOM_RIGHT_CORNER = (char) 0x2518;
    public static final char EMPTY = ' ';

    public static void main(String[] args) {
        String[] box = createBox(4, 8);
        printBox(box);

    }

    /**
     * Prints out the box to the Console
     */
    public static void printBox(String[] box){
        for(String row: box){
            System.out.println(row);
        }
    }

    /**
     * Creates an array of String rows representing a box
     * @return array of Strings representing a collection of rows
     */
    public static String[] createBox(int height, int width) throws IllegalArgumentException{
        if(width<2 || height<2){
            throw new IllegalArgumentException(String.format("Cannot create a box with a width of %d and height of %d!", width, height));
        }

        String[] box = new String[height];

        // Create a top edge of the box
        box[0] = createRow(TOP_LEFT_CORNER, HORIZONTAL_EDGE, TOP_RIGHT_CORNER, width);

        // Create middle rows of the box
        for(int i=1; i < height-1; i++) {
            box[i]= createRow(VERTICAL_EDGE, EMPTY, VERTICAL_EDGE, width);
        }

        // Create a bottom edge of the box
        box[height-1]= createRow(BOTTOM_LEFT_CORNER,  HORIZONTAL_EDGE, BOTTOM_RIGHT_CORNER, width);

        return box;
    }

    /**
     * Creates a row of characters to represent 1 row of the box
     * @return  String representation of the row
     */
    protected static String createRow(char left, char middle, char right, int width) throws IllegalArgumentException{
        if(width < 2) {
            throw new IllegalArgumentException(String.format("Cannot create a row with a width of %d!", width));
        }

        StringBuilder row = new StringBuilder();

        row.append(left);

        for(int i=0; i<width-2; i++){
            row.append(middle);
        }

        row.append(right);

        return row.toString();

    }


}
