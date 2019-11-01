package be.empira.gildedrose;

public class AgedBrieQualityCalculator extends QualityCalculator {

    public AgedBrieQualityCalculator(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseSellIn();

        if (isExpired()) {
            increaseQualityBy(2);
        } else {
            increaseQualityBy(1);
        }
    }
}
