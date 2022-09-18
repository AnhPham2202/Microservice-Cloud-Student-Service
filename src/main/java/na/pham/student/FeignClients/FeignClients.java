package na.pham.student.FeignClients;

import na.pham.student.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *  EVERY SERVICE NEED TO CALL EACH OTHER THROUGH THE GATEWAY
 */
@FeignClient(value = "${service.name.others.gateway}")
public interface FeignClients {

    @GetMapping("/address-service/api/address/{id}")
    AddressResponse getAddressById(@PathVariable Long id);
}
