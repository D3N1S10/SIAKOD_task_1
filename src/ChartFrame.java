import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartFrame {
    private final ChartPanel chartPanel;

    public ChartFrame() {
        for (int i = 0; i < 10000; i++) {
            int[] warmupArray = Algorithm.generateRandomArray(100 + i);
            Algorithm.replaceSegments(warmupArray);
        }

        XYSeries series = new XYSeries("Время выполнения");

        int[] inputSizes = {1000000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000, 10000000};

        for (int size : inputSizes) {
            int[] inputArray = Algorithm.generateRandomArray(size);

            long startTime = System.nanoTime();
            Algorithm.replaceSegments(inputArray);
            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;
            series.add(size, executionTime);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Время выполнения vs Размер ввода",
                "Размер ввода",
                "Время выполнения (нс)",
                dataset
        );

        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}