package com.netcracker.openshift;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OpenshiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenshiftApplication.class, args);
        //        IClient client = new ClientBuilder("https://console.starter-ca-central-1.openshift.com").usingToken("asfdsfd8a70a3qrfafdsadsf786324").build();
               /* .withUserName("openshiftdev")
                .withPassword("wouldntUlik3T0kn0w")
                .build();*/
//        client.getAuthorizationContext().setToken("asfdsfd8a70a3qrfafdsadsf786324");
//        List<IResource> list = client.list(ResourceKind.CONFIG_MAP, "nc-project");
        //"https://sdnoshm05.netcracker.com:8443/
//        OpenShiftConfig osConfig = new OpenShiftConfigBuilder()
//       OpenShiftClient osClient = new DefaultOpenShiftClient(osConfig);
        
        OpenShiftClient osClient = new DefaultOpenShiftClient();
        NonNamespaceOperation<Project, ProjectList, DoneableProject, Resource<Project, DoneableProject>> projects = osClient.projects();

        //config.
        List<Pod> items = osClient.pods().list().getItems();
        List<ConfigMap> items1 = osClient.configMaps().list().getItems();
        Pod pod = osClient.pods().list().getItems().get(2);
        Container container = pod.getSpec().getContainers().get(0);
        DeploymentConfig deploymentConfig = osClient.deploymentConfigs().list().getItems().get(0);
        DeploymentConfigSpec spec = deploymentConfig.getSpec();
        Probe livenessProbe = container.getLivenessProbe();
        PodList pods = osClient.pods().list();
        for (Pod pod_ : pods.getItems()) {
            String name = pod_.getMetadata().getName();
            String ip = pod_.getStatus().getPodIP();
        }


//        Config config = new ConfigBuilder().withMasterUrl("https://mymaster.com").build();
//        OpenShiftClient client = new DefaultKubernetesClient(config);*/
        //System.out.println("test");
    }
}
