package be.empira.gildedrose;

import java.util.Arrays;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).map(QualityCalculator::new).forEach(QualityCalculator::updateQuality);
    }


}
