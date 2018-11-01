package com.netcracker.openshift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OpenshiftApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(OpenshiftApplication.class, args);
/*
        //final String OAUTH_TOKEN = "jM7LaAuvh0TFQHpkYtB7qFV5TYxPLEUfHF3Yd-hvYjc";
        final String OAUTH_TOKEN = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJ1bm0tcWEiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlY3JldC5uYW1lIjoiYWRtaW4tYWNjb3VudC10b2tlbi04OTRxZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJhZG1pbi1hY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiMTFlY2U3NmMtZDA3Ny0xMWU4LWE5MTQtMDAxNjNlMTQ2NmU2Iiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OnVubS1xYTphZG1pbi1hY2NvdW50In0.pJXofMZXtYKb2E73HRGmAA6pxOlFZ-wBmPa5yGT2FXGKRWBLTeZ08USL9C9GvCkDhnRR08I7J5yMysyp4T4x7GXhF0F3IjNFOLmbEcB-58SUpmjPxE0wrzRwGD6sgz4ekeorClutGRwR-zw9f_d19HJIRawSgXVC46sl2SSkqLHENSwJ5cKKIHogSDBy-igio8PWy4MCIFoyt-Hq45v8LvV0cSyJKpURNx-JwdBWzWRyIcsKG7jBT_WUUKKHoXc-u93BS2svFfT3qkZAm1-LiMayMI4hZXGV0weNN7jCzx6yZdoY070v337x_dy4WPTs0zuOUS0zPBIjKLxz2gMHkg";
        final String OPENSHIFT_NAMESPACE = "unm-qa";
        //final String OPENSHIFT_URL = "https://sdnoshm05.netcracker.com:8443/api/v1/";
        final String OPENSHIFT_MASTER_URL = "https://sdnoshm05.netcracker.com:8443";

        OpenShiftConfig osConfig = new OpenShiftConfigBuilder()
                .withMasterUrl(OPENSHIFT_MASTER_URL)
                .withNamespace(OPENSHIFT_NAMESPACE)
                .withOauthToken(OAUTH_TOKEN)
                //.withOpenShiftUrl(OPENSHIFT_URL)
                .withTrustCerts(true)
                .build();
        List<Pod> pods = null;
        List<Service> services = null;
        List<Route> routes = null;
        List<DeploymentConfig> deplConfigs = null;

        try (OpenShiftClient osClient = new DefaultOpenShiftClient(osConfig)) {
            pods = osClient.pods().list().getItems();
            services = osClient.services().list().getItems();
            routes = osClient.routes().list().getItems();
            deplConfigs = osClient.deploymentConfigs().list().getItems();
            System.out.println();
        } catch (KubernetesClientException e) {
            //log.info("KubernetesClientException", e);
        }

        List<Pod> yangBasedStoragePod = pods.stream()
                .filter(s -> s.getMetadata().getName().equals("yang-based-storage"))
                .collect(Collectors.toList());

        List<Service> yangBasedStorageService = services.stream()
                //.filter(s -> s.getMetadata().getName().equals("yang-based-storage"))
                .filter(s -> s.getMetadata().getName().equals("api-gateway"))
                .collect(Collectors.toList());

        List<Route> yangBasedStorageRoute = routes.stream()
                .filter(s -> s.getMetadata().getName().equals("yang-based-storage"))
                .collect(Collectors.toList());

        List<DeploymentConfig> yangBasedStorageDeploymentConfig = deplConfigs.stream()
                .filter(s -> s.getMetadata().getName().equals("yang-based-storage"))
                .collect(Collectors.toList());

        //log.info("Printing Pods healthchecks:");
        if (pods != null) {
            for (Pod pod : pods) {
                List<Container> containers = pod.getSpec().getContainers();
                for (Container container : containers) {
                    if (container.getLivenessProbe() != null) {
                        String name = container.getName();
                        String livinessProbe = container.getLivenessProbe().getHttpGet().getPath();
                        String port = container.getLivenessProbe().getHttpGet().getPort().getIntVal().toString();
                        //String message = "Container name = " + name + " : Liveness probe = " + livinessProbe;
                        String message = "HEALTH ENDPOINT: https://"+ name + ":" + port + livinessProbe;
                        System.out.println(message);
                        //log.info(message);
                    }
                }
            }
        }*/
    }
}
