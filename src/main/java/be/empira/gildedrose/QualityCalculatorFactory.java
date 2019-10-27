package be.empira.gildedrose;

public class QualityCalculatorFactory {

    public static QualityCalculator create(Item item) {
        switch (item.name) {
            case "Aged Brie": return new AgedBrieQualityCalculator(item);
            default: return new QualityCalculator(item);
        }
    }
}
