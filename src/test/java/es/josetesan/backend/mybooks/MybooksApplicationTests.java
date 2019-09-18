package es.josetesan.backend.mybooks;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybooksApplicationTests {

    @BeforeClass
    public static void startCassandraEmbedded() throws Exception{
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder()
            .addContactPoints("").withPort(9142).build();
        Session session = cluster.connect();
    }
    @AfterClass
    public static void stopCassandraEmbedded() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }

    @Test
    void contextLoads() {
    }

}
