package uk.co.treatwell.admission.task;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class BoxFactoryTest extends TestCase {
    @Test
    public void testCreateRow() {

        String expectedOutput = "*-----*";
        String output = BoxFactory.createRow('*', '-', '*', 7);

        assertEquals(expectedOutput, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateRowInvalidWidth() {
        BoxFactory.createRow('*', '-', '*', 0);
    }

    @Test
    public void testCreateBox(){
        String expectedBox[] = new String[3];
        expectedBox[0]= ""+BoxFactory.TOP_LEFT_CORNER + BoxFactory.HORIZONTAL_EDGE + BoxFactory.HORIZONTAL_EDGE + BoxFactory.TOP_RIGHT_CORNER;
        expectedBox[1]=""+BoxFactory.VERTICAL_EDGE + BoxFactory.EMPTY +  BoxFactory.EMPTY + BoxFactory.VERTICAL_EDGE;
        expectedBox[2]=""+BoxFactory.BOTTOM_LEFT_CORNER + BoxFactory.HORIZONTAL_EDGE + BoxFactory.HORIZONTAL_EDGE + BoxFactory.BOTTOM_RIGHT_CORNER;

        String[] output= BoxFactory.createBox(4,4);
        assertEquals(expectedBox[0], output[0]);
        assertEquals(expectedBox[1], output[1]);
        assertEquals(expectedBox[1], output[2]);
        assertEquals(expectedBox[2], output[3]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidHeightBox(){
        BoxFactory.createBox(1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidWidthBox(){
        BoxFactory.createBox(3, 1);
    }
}
