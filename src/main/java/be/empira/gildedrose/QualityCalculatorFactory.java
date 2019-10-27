package be.empira.gildedrose;

public class QualityCalculatorFactory {

    public static QualityCalculator create(Item item) {
        return new QualityCalculator(item);
    }
}
