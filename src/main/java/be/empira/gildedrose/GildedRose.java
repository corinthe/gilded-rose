package be.empira.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {
    Item[] items;

    private List<QualityCalculator> calculators;

    public GildedRose(Item[] items) {
        this.items = items;
        calculators = Arrays.stream(items).map(QualityCalculatorFactory::create).collect(Collectors.toList());
    }

    public void updateQuality() {
        calculators.forEach(QualityCalculator::updateQuality);
    }


}
