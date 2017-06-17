package bidder.controllers;

import bidder.model.web.request.UpdateCupRequest;
import bidder.model.web.response.CupResponse;
import bidder.model.web.response.GameResponse;
import bidder.services.CupService;
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
        CupResponse response = new CupResponse(cupService.getCups());
        return response;
    }

    @PostMapping(path = "/{cupId}/save")
    public void save(@PathVariable String cupId, @Valid @RequestBody UpdateCupRequest updateCupRequest) {
        cupService.updateCup(cupId, updateCupRequest.getName());
    }

    @GetMapping(path = "/gamesToBid/{cupId}/{userId}")
    public GameResponse getGamesToBid(@PathVariable(name = "cupId") String cupId,
                                      @PathVariable(name = "userId") String userId) {
        GameResponse response = new GameResponse(cupService.getGamesToBid(cupId, userId));
        return response;
    }
}
