package be.empira.gildedrose;

public class BackstagePassQualityCalculator extends QualityCalculator {

    public BackstagePassQualityCalculator(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseSellIn();

        if (isExpired()) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            increaseQualityBy(3);
        } else if (item.sellIn < 10) {
            increaseQualityBy(2);
        } else {
            increaseQualityBy(1);
        }
    }


}
