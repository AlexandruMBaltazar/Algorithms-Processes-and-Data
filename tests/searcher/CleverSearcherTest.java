package searcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CleverSearcherTest extends SearcherTest {

    @Override
    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new CleverSearcher(array, index);
    }
}