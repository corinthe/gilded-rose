package be.empira.gildedrose;

public class QualityCalculator {

    public static int MAX_QUALITY = 50;

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
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
