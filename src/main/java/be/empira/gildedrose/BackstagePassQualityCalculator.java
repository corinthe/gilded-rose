package be.empira.gildedrose;

public class BackstagePassQualityCalculator extends QualityCalculator {

    public BackstagePassQualityCalculator(Item item) {
        super(item);
    }

    @Override
    protected void manageExpiration() {
        item.quality = 0;
    }
}
