package be.empira.gildedrose;

public class QualityCalculator {
    public Item item;

    public QualityCalculator(Item item) {
        this.item = item;
    }

    void updateQuality() {
        calculateQuality();

        calculateSellIn();

        manageExpiration();
    }

    private void manageExpiration() {
        if (isExpired()) {
            if (!isAgedBrie()) {
                if (!isBackstagePass()) {
                    decreaseQuality();
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void calculateSellIn() {
        if (!isSulfuras()) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void calculateQuality() {
        if (!isAgedBrie() && !isBackstagePass()) {
            decreaseQuality();
        } else {
            increaseQuality();
        }
    }

    private boolean isAgedBrie() {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass() {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras() {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            if (!isSulfuras()) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (isBackstagePass()) {
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
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
