package bidder.controllers;

import bidder.model.web.response.BidResponse;
import bidder.model.web.response.GamesToBidResponse;
import bidder.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/all/{cupId}/{userId}")
    public BidResponse getBidsForUser(@PathVariable String cupId, @PathVariable String userId) {
        BidResponse response = new BidResponse(bidService.getBidsForUser(cupId, userId));
        return  response;
    }

    @GetMapping(path = "/gamesToBid/{cupId}/{userId}")
    public GamesToBidResponse getGamesToBid(@PathVariable(name = "cupId") String cupId,
                                            @PathVariable(name = "userId") String userId) {
        GamesToBidResponse response = new GamesToBidResponse(bidService.getGamesToBid(cupId, userId));
        return response;
    }

}
