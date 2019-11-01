package be.empira.gildedrose;

public class SulfurasQualityCalculator extends QualityCalculator {

    public SulfurasQualityCalculator(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        decreaseQualityBy(0);
    }
}
