package be.empira.gildedrose;

public class QualityCalculatorFactory {

    public static QualityCalculator create(Item item) {
        switch (item.name) {
            case "Aged Brie": return new AgedBrieQualityCalculator(item);
            case "Backstage passes to a TAFKAL80ETC concert": return new BackstagePassQualityCalculator(item);
            default: return new QualityCalculator(item);
        }
    }
}
