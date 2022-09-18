//package na.pham.student.LoadBalancer;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value = "address-service")
//public class AddressServiceLoadBalancer {
//
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//}

/**
 *  DON'T NEED LOAD BALANCER BECAUSE OF CALLING AMONG SERVICES THROUGH API GATEWAY (IT WILL PROVIDE LOAD BALANCER AUTOMATICALLY)
 */