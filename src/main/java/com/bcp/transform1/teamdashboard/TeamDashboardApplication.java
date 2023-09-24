package com.bcp.transform1.teamdashboard;

import com.bcp.transform1.teamdashboard.restapi.anonymous.service.GitHubAnonymousService;
import com.bcp.transform1.teamdashboard.restapi.anonymous.vo.GitHubUserVO;
import com.bcp.transform1.teamdashboard.restapi.bearer.service.GitHubBearerService;
import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActivityVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.IOException;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class TeamDashboardApplication implements CommandLineRunner {
    @Autowired
    private GitHubAnonymousService gitHubAnonymousService;

    @Autowired
    private GitHubBearerService gitHubBearerService;

    @Value("${github.user}")
    private String user;

    @Value("${github.anonymous-repo}")
    private String anonymousRepo;

    @Value("${github.bearer-repo}")
    private String bearerRepo;

    private static final Logger LOG = LoggerFactory
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

        //generateImage();

        GitHubUserVO gitHubUserVO = gitHubAnonymousService.getUser(user);
        LOG.info("REST API Anonymous Service : " +
                "login=[{}] " +
                "name=[{}] " +
                "type=[{}]",
                gitHubUserVO.getLogin(),
                gitHubUserVO.getName(),
                gitHubUserVO.getType()
        );

        List<GitHubActivityVO> gitHubActivityVOList = gitHubBearerService.getRepoActivities(user, bearerRepo) ;
        LOG.info("REST API Bearer Service    : " +
                "[0].activityType=[{}] " +
                "[0].timeStamp=[{}] " +
                "[0].gitHubActorVO.login=[{}] " +
                "[0].gitHubActorVO.type=[{}] " +
                "[0].gitHubActorVO.url=[{}]",
                gitHubActivityVOList.get(0).getActivityType(),
                gitHubActivityVOList.get(0).getTimestamp(),
                gitHubActivityVOList.get(0).getGitHubActorVO().getLogin(),
                gitHubActivityVOList.get(0).getGitHubActorVO().getType(),
                gitHubActivityVOList.get(0).getGitHubActorVO().getUrl()
        );

    }

    /*
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
    */


    /*
    private void invokeBearerToken(){
        List<GitHubActivity> gitHubActivityList = gitHubBearerClient.getRepoActivities(user, bearerRepo);
        LOG.info(gitHubActivityList.toString());
    }*/
}