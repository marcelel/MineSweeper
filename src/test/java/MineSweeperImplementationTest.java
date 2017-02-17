import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by marcel on 17.02.17.
 */
public class MineSweeperImplementationTest {

    private MineSweeperImplementation m = new MineSweeperImplementation();

    @Test
    public void checkIfMineFieldIsProperlyFormatted() throws Exception {
        String s1 = "*.a\n.*aa";
        String s2 = "..*\n....";
        String s3 = ".**.\n*...\n";
        String s4 = "..*.";
        String s5 = ".***\n....\n****";
        String s6 = "*...\n..*.\n....";
        assertEquals(false, m.checkIfMineFieldIsProperlyFormatted(s1));
        assertEquals(false, m.checkIfMineFieldIsProperlyFormatted(s2));
        assertEquals(false, m.checkIfMineFieldIsProperlyFormatted(s3));
        assertEquals(true, m.checkIfMineFieldIsProperlyFormatted(s4));
        assertEquals(true, m.checkIfMineFieldIsProperlyFormatted(s5));
        assertEquals(true, m.checkIfMineFieldIsProperlyFormatted(s6));
    }

    @Test
    public void setMineField() throws Exception {
        String mineField = ".**\n..*";
        m.setMineField(mineField);
        String[] lines = mineField.split("\n");
        assertEquals(lines[0], m.getMineField()[0]);
        assertEquals(lines[1], m.getMineField()[1]);
    }

    @Test
    public void getHintField() throws Exception {
        String s1 = ".*..";
        String s2 = "*..*\n...*\n****";
        String s3 = "*...\n..*.\n....";
        m.setMineField(s1);
        assertEquals("1*10", m.getHintField());
        m.setMineField(s2);
        assertEquals("*12*\n345*\n****", m.getHintField());
        m.setMineField(s3);
        assertEquals("*211\n12*1\n0111", m.getHintField());
    }

}