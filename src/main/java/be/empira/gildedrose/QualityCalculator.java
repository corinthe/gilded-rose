package be.empira.gildedrose;

public class QualityCalculator {
    public Item item;

    public QualityCalculator(Item item) {
        this.item = item;
    }

    void updateQuality() {
        calculateQuality(item);

        calculateSellIn(item);

        manageExpiration(item);
    }

    private void manageExpiration(Item item) {
        if (isExpired(item)) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    decreaseQuality(item);
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

    private void calculateSellIn(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void calculateQuality(Item item) {
        if (!isAgedBrie(item) && !isBackstagePass(item)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            if (!isSulfuras(item)) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (isBackstagePass(item)) {
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

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
