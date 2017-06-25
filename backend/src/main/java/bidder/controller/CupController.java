package bidder.controller;

import bidder.model.web.request.UpdateCupRequest;
import bidder.model.web.response.CupResponse;
import bidder.service.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Created by gawa on 24/05/17.*/
@RestController
@RequestMapping(path = "/api/cup")
@CrossOrigin(origins = "*")
public class CupController {

    private final CupService cupService;

    @Autowired
    public CupController(CupService cupService) {
        this.cupService = cupService;
    }

    @GetMapping(path = "")
    public CupResponse getCups() {
        CupResponse response = new CupResponse(cupService.getAllCups());
        return response;
    }

    @GetMapping(path = "/active")
    public CupResponse activeCups() {
        CupResponse response = new CupResponse(cupService.getActiveCups());
        return response;
    }

    @PutMapping(path = "")
    public void save(@PathVariable String cupId, @Valid @RequestBody UpdateCupRequest updateCupRequest) {
        cupService.updateCup(cupId, updateCupRequest.getName());
    }

}
