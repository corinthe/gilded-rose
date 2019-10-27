package be.empira.gildedrose;

import static java.lang.Math.min;

public class BackstagePassQualityCalculator extends QualityCalculator {

    public BackstagePassQualityCalculator(Item item) {
        super(item);
    }

    @Override
    protected void calculateQuality() {
        increaseQuality();
    }

    @Override
    void increaseQuality() {
        if (item.sellIn <= 5) {
            item.quality = min(MAX_QUALITY, item.quality + 3);
        } else if (item.sellIn <= 10) {
            item.quality = min(MAX_QUALITY, item.quality + 2);
        } else {
            item.quality += 1;
        }
    }

    @Override
    protected void manageExpiration() {
        item.quality = 0;
    }
}
