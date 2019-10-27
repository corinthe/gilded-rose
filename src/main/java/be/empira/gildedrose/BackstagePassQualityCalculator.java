package be.empira.gildedrose;

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
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

        }
    }

    @Override
    protected void manageExpiration() {
        item.quality = 0;
    }
}
