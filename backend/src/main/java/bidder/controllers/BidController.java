package bidder.controllers;

import bidder.model.web.request.MatchDetailsRequest;
import bidder.model.web.response.BidResponse;
import bidder.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Created by Gawa on 16/06/17.*/
@RestController
@RequestMapping(path = "/api/bid")
@CrossOrigin(origins = "*")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping(path = "/{cupId}/{userId}")
    public BidResponse getBidsForUser(@PathVariable String cupId, @PathVariable String userId) {
        BidResponse response = new BidResponse(bidService.getBidsForUser(cupId, userId));
        return  response;
    }

    @PostMapping(path = "")
    public void addBid(@Valid @RequestBody MatchDetailsRequest matchDetailsRequest) {
        bidService.addBid(matchDetailsRequest.getCupId(), matchDetailsRequest.getUserId(),
                matchDetailsRequest.getGameId(), matchDetailsRequest.getHomeTeamScore(),
                matchDetailsRequest.getAwayTeamScore());

    }

    @PutMapping(path = "")
    public void changeBid(@Valid @RequestBody MatchDetailsRequest matchDetailsRequest) {
        bidService.changeBid(matchDetailsRequest.getUserId(), matchDetailsRequest.getBidId(),
                matchDetailsRequest.getHomeTeamScore(), matchDetailsRequest.getAwayTeamScore());
    }

}
