package be.empira.gildedrose;

public class QualityCalculator {
    public Item item;

    public QualityCalculator(Item item) {
        this.item = item;
    }

    void updateQuality() {
        calculateQuality();

        calculateSellIn();

        if (isExpired()) {
            manageExpiration();
        }
    }

    protected void manageExpiration() {
        decreaseQuality();
    }

    protected void calculateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    protected void calculateQuality() {
        decreaseQuality();
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
