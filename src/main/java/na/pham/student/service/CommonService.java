package na.pham.student.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import na.pham.student.FeignClients.FeignClients;
import na.pham.student.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Move some methods from Student Service to this class
 * Because of using Resillience4j which uses AOP (AOP does not allow call the method inside the class where the method was declared)
 */
@Service
public class CommonService {

    @Autowired
    private FeignClients feignClients;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
    protected AddressResponse getAddressById(Long addressId) {
        return feignClients.getAddressById(addressId);
    }

    protected AddressResponse fallbackGetAddressById(Long addressId, Throwable throwable) {
        // Throwable is an optional
        return new AddressResponse(addressId, "dummy", "dummy");
    }
}
