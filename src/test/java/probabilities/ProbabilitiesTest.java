package probabilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.scratchgame.definition.Probabilities;
import com.scratchgame.definition.StandardSymbolsGrid;

//Basic testing nothin really special here
public class ProbabilitiesTest {
	private Probabilities probabilities;

    @Before
    public void setUp() {
        probabilities = Probabilities.createProbabilities();
    }

    @Test
    public void testStandardSymbolsGridSize() {
        List<StandardSymbolsGrid> standardSymbolsGrid = probabilities.getStandardSymbolsGrid();
        assertNotNull(standardSymbolsGrid);
        assertEquals(9, standardSymbolsGrid.size());
    }


    @Test
    public void testProbabilitiesNotNull() {
        assertNotNull(probabilities);
        assertNotNull(probabilities.getStandardSymbolsGrid());
        assertNotNull(probabilities.getBonusSymbolProbability());
    }

}
