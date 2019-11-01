package be.empira.gildedrose;

public class QualityCalculatorFactory {

    public static QualityCalculator create(Item item) {
        if (item.name.toLowerCase().contains("Aged Brie".toLowerCase())) {
            return new AgedBrieQualityCalculator(item);
        } else if (item.name.toLowerCase().contains("Backstage pass".toLowerCase())) {
            return new BackstagePassQualityCalculator(item);
        } else if (item.name.toLowerCase().contains("Sulfuras".toLowerCase())) {
            return new SulfurasQualityCalculator(item);
        } else {
            return new QualityCalculator(item);
        }
    }
}
