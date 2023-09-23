package com.bcp.transform1.teamdashboard;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

import static java.lang.Double.valueOf;

@SpringBootApplication
public class TeamDashboardApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(TeamDashboardApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(TeamDashboardApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws IOException {
        LOG.info("EXECUTING : command line runner");

        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        generateImage();
    }

    private void generateImage() throws IOException {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue( "IPhone 5s" , Double.valueOf( 20 ) );
        dataset.setValue( "SamSung Grand" , Double.valueOf( 20 ) );
        dataset.setValue( "MotoG" ,  Double.valueOf( 40 ) );
        dataset.setValue( "Nokia Lumia" , Double.valueOf( 10 ) );

        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);

        ChartUtils.saveChartAsPNG(new File("grafico.png"), chart, 500, 500);
    }

}