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
    protected void manageExpiration() {
        item.quality = 0;
    }
}
