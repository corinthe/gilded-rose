package be.empira.gildedrose;

public class ConjuredQualityCalculator extends QualityCalculator {

    public ConjuredQualityCalculator(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseSellIn();
        if(isExpired()) {
            decreaseQualityBy(4);
        } else {
            decreaseQualityBy(2);
        }

    }
}
