package be.empira.gildedrose;

import static java.lang.Math.max;
import static java.lang.Math.min;

class QualityCalculator {

    static int MAX_QUALITY = 50;

    Item item;

    QualityCalculator(Item item) {
        this.item = item;
    }

    void updateQuality() {
        decreaseSellIn();

        if(isExpired()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }

    void decreaseSellIn() {
        item.sellIn -= 1;
    }

    void decreaseQualityBy(int n) {
        item.quality = max(0, item.quality - n);
    }

    void increaseQualityBy(int n) {
        item.quality = min(MAX_QUALITY, item.quality + n);
    }

    boolean isExpired() {
        return item.sellIn < 0;
    }
}
