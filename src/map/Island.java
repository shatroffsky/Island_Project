package map;

public class Island {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        initializeCells();
    }

    private void initializeCells() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(x, y);
            }
        }
    }

    public Cell getCell(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return cells[y][x];
        }
        return null;
    }

    public Cell[][] getCells() {
        return cells;
    }

}
