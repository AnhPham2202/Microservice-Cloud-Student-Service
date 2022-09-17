package na.pham.student.FeignClients;

import na.pham.student.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        url = "${address.service.url}",
        path = "/api/address",
        value = "address-feign"
)
public interface AddressFeignClients {

    @GetMapping("{id}")
    AddressResponse getAddressById(@PathVariable Long id);
}
