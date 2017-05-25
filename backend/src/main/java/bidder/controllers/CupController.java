package bidder.controllers;

import bidder.model.web.response.CupResponse;
import bidder.services.CupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** Created by gawa on 24/05/17.*/
@RestController
@RequestMapping(path = "/api/cup")
@CrossOrigin(origins = "*")
public class CupController {

    @Autowired
    private CupService cupService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public CupResponse getCups() {
        CupResponse response = new CupResponse(cupService.getCups());
        return response;
    }
}
