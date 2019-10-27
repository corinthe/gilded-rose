package be.empira.gildedrose;

public class AgedBrieQualityCalculator extends QualityCalculator {

    public AgedBrieQualityCalculator(Item item) {
        super(item);
    }

    @Override
    protected void calculateQuality() {
        increaseQuality();
    }

    @Override
    protected void manageExpiration() {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
