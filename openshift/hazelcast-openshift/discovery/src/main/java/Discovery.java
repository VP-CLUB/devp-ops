import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.DiscoveryStrategyConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.util.StringUtil;

public class Discovery {
    public static void main(String[] args) {
        String type = System.getenv("HAZELCAST_TYPE");
        DiscoveryStrategyConfig strategyConfig = new DiscoveryStrategyConfig("com.noctarius.hazelcast.kubernetes.HazelcastKubernetesDiscoveryStrategy");
        strategyConfig.addProperty("service-name", "hazelcast-openshift");
        strategyConfig.addProperty("namespace", "default");
        if ("client".equals(type)) {
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.getProperties().put("hazelcast.discovery.enabled", true);
            clientConfig.getNetworkConfig().getDiscoveryConfig()
                    .getDiscoveryStrategyConfigs().add(strategyConfig);

            HazelcastClient.newHazelcastClient(clientConfig);
        } else {
            Config config = new Config();
            //设置环境变量为管理值
            String url = System.getenv("MANAGEMENT_ACTIVE");
            if (!StringUtil.isNullOrEmptyAfterTrim(url)) {
                config.getManagementCenterConfig().setEnabled(true);
                config.getManagementCenterConfig().setUrl(url);
            }
            config.getProperties().put("hazelcast.discovery.enabled", true);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getDiscoveryConfig()
                    .getDiscoveryStrategyConfigs().add(strategyConfig);

            Hazelcast.newHazelcastInstance(config);


        }
    }

}
