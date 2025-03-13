import java.awt.*;
import javax.swing.*;

public class Exercise10_20 extends JFrame {
  public Exercise10_20() {
    Container container = getContentPane();
    container.setLayout(new GridLayout(1, 3, 20, 5));

    BarChart chart1 = new BarChart();
    double[] data1 = {200, 140, 100, 60, 40};
    String[] dataName1 = {"CS", "Math", "Chem", "Biol", "Phys"};
    chart1.setData(dataName1, data1);
    container.add(chart1);

    BarChart chart2 = new BarChart();
    double[] data2 = {20000, 10000, 8000, 6000, 4000, 2000};
    String[] dataName2 = {"Software", "Hardware", "Phone", "Travel",
      "Copy", "Misc"};
    chart2.setData(dataName2, data2);
    container.add(chart2);

    BarChart chart3 = new BarChart();
    double[] data3 = {4000, 2500};
    String[] dataName3 = {"Female Students", "Male Students"};
    chart3.setData(dataName3, data3);
    container.add(chart3);
  }

  public static void main(String[] args) {
    Exercise10_20 frame = new Exercise10_20();
    frame.setTitle("Exercise 10.20 Three Bar Charts");
    frame.setSize(500, 200);
    frame.setVisible(true);
  }
}