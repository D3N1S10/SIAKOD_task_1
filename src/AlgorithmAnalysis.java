import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AlgorithmAnalysis extends JFrame {
    public AlgorithmAnalysis(String title) {
        super(title);
        ChartFrame chartFrame = new ChartFrame();
        add(chartFrame.getChartPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlgorithmAnalysis algorithmAnalysis = new AlgorithmAnalysis("Анализ времени выполнения алгоритма");
            algorithmAnalysis.setSize(800, 600);
            algorithmAnalysis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            algorithmAnalysis.setVisible(true);
        });
    }
}