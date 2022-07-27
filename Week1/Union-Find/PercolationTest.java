import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {

    private Percolation percolation;
    private static final int GRID_SIZE = 5;

    @Test
    public void shouldOpenAGrid() {
        percolation = new Percolation(GRID_SIZE);

        assertFalse(percolation.isOpen(1, 1));
        percolation.open(1, 1);
        assertTrue(percolation.isOpen(1, 1));
    }

    @Test
    public void isNumberOfOpenSitesValid() {
        percolation = new Percolation(GRID_SIZE);

        int totalNumberOfGrid = GRID_SIZE * GRID_SIZE;
        for (int row = 1; row <= GRID_SIZE; row ++) {
            for (int column = 1; column <= GRID_SIZE; column ++) {
                percolation.open(row, column);
            }
        }
        assertEquals(totalNumberOfGrid, percolation.numberOfOpenSites());
    }

    @Test
    public void shouldPercolate() {
        percolation = new Percolation(GRID_SIZE);

        percolation.open(1, 1);
        assertFalse(percolation.percolates());
        percolation.open(2,1);
        percolation.open(3,1);
        percolation.open(4,1);
        percolation.open(5, 1);
        assertTrue(percolation.percolates());
    }

}