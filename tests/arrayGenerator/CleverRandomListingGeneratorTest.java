package arrayGenerator;

/**
 * Tests CleverRandomListing.
 *
 * @author Hugh Osborne
 * @version September 2019
 */

class CleverRandomListingGeneratorTest extends ListingGeneratorTest {
    @Override
    protected ListingGenerator createArrayGenerator(int size) {
        return new CleverRandomListingGenerator(size);
    }
}