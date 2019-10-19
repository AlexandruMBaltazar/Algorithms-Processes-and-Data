package arrayGenerator;

/**
 * Tests SimpleRandomListing.
 *
 * @author Hugh Osborne
 * @version September 2019
 */

class SimpleRandomListingGeneratorTest extends ListingGeneratorTest {
    @Override
    protected ListingGenerator createArrayGenerator(int size) {
        return new SimpleRandomListingGenerator(size);
    }
}