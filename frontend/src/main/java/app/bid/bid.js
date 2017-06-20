const ACTIVE_CUPS_GET = {
   method : "GET",
      url : BACKEND_HOST + "/api/cup/active"
}

const GAMES_TO_BID_FOR_USER_GET = function(cupId, userId) {
    return {
        method : "GET",
           url : BACKEND_HOST + "/api/bid/gamesToBid/"+cupId+"/"+userId
    }
}

const ADD_SCORE_POST = function(scoreData) {
    return {
        method : "POST",
           url : BACKEND_HOST + "/api/score",
          data : scoreData
    }
}

const CHANGE_SCORE_PUT = function(scoreData) {
    return {
        method : "PUT",
           url : BACKEND_HOST + "/api/score",
          data : scoreData
    }
}

const ADD_BID_POST = function(bidData) {
    return {
        method : "POST",
           url : BACKEND_HOST + "api/bid",
          data : bidData
    }
}

const CHANGE_BID_PUT = function(bidData) {
    return {
        method : "PUT",
           url : BACKEND_HOST + "api/bid",
          data : bidData
    }
}

let isValidScore = function(score) {
    score.bidSet = true;
    score.wrongBidMsg = '';

    let homeScore = score.homeTeamScore;
    let awayScore = score.awayTeamScore;

    if (!isValid(homeScore)) {
        score.wrongBidMsg = "Home team score should contain only numbers.";
        score.bidSet = false;
        return false;
    }

    if (!isValid(awayScore)) {
        score.wrongBidMsg = "Away team score should contain only numbers.";
        score.bidSet = false;
        return false;
    }
    return true;
}

let isValid = function(score) {
    if (typeof score == 'undefined') {
        return false;
    }
    score = score.trim();
    return score != '' && isFinite(score);
}

let populateBids = function (games) {
    for (let i = 0; i < games.length; i++) {
        games[i].bidSet = false;
        if(games[i].homeTeamScore >= 0 && games[i].awayTeamScore >= 0) {
            games[i].bidSet = true;
        }
    }
    return games;
}

mainAppModule.controller('BidController', function($rootScope, $http, $scope, $location) {
    let chosenCupId = '';
    $rootScope.hideSignIn = true;
    $scope.showAddScore = true;
    $scope.showGamesToBid = false;
    $scope.halloMsg = $rootScope.halloMsg();
    $scope.isBidPath = $location.path() == '/bid';
    $scope.isAdmin = $rootScope.isAdmin();
    $scope.isBidder = $rootScope.isBidder();
    $scope.isGambler = $rootScope.isGambler();
    $scope.isWatcher = $rootScope.isWatcher();

    $http( ACTIVE_CUPS_GET )
    .then(function success(response) {
        $scope.cups = response.data.cups;
        $scope.showHint = $scope.cups.length > 0;
    }, function handleError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $scope.showGames = function(index) {
        chosenCupId = $scope.cups[index].id;
        $http( GAMES_TO_BID_FOR_USER_GET(chosenCupId, $rootScope.userId()) )
        .then(function success(response) {
            $scope.games = populateBids(response.data.games);
            $scope.showGamesToBid = true;
            $scope.showHint = false;
        }, function handleError(response) {
            $scope.requestErrorMsg = response.statusText;
        });
    }

    $scope.addScore = function(index) {
        console.log('addScore('+index+') call.');
        if (isValidScore($scope.games[index])) {

            let scoreData = {
                cupId : chosenCupId,
                userId : $rootScope.userId(),
                gameId : $scope.games[index].id,
                homeTeamScore : $scope.games[index].homeTeamScore.trim(),
                awayTeamScore : $scope.games[index].awayTeamScore.trim()
            };

            console.log("call score update");
            $http( ADD_SCORE_POST(scoreData) )
            .then(
                function success(scoreData, status, response) {
                    $scope.saveCompleted = true;
                    $scope.games[index].scoreId = response.data;
                },
                function handleError(scope, response) {
                    $scope.requestErrorMsg = response.statusText;
                }
            );
        }
    }

    $scope.changeScore = function(index) {
        console.log('changeScore('+index+') call.');
        if (isValidScore($scope.games[index])) {

            let scoreData = {
                cupId : chosenCupId,
                userId : $rootScope.userId(),
                scoreId : $scope.games[index].scoreId,
                homeTeamScore : $scope.games[index].homeTeamScore.trim(),
                awayTeamScore : $scope.games[index].awayTeamScore.trim()
            };

            console.log("call score update");
            $http( CHANGE_SCORE_PUT(scoreData) )
            .then(
                function success(scoreData, status) {
                    $scope.saveCompleted = true;
                },
                function handleError(scope, response) {
                    $scope.requestErrorMsg = response.statusText;
                }
            );
        }
    }

    $scope.addBid = function(index) {
            console.log('addBid('+index+') call.');
            if (isValidScore($scope.games[index])) {

                let bidData = {
                    cupId : chosenCupId,
                    userId : $rootScope.userId(),
                    gameId : $scope.games[index].id,
                    homeTeamScore : $scope.games[index].homeTeamScore.trim(),
                    awayTeamScore : $scope.games[index].awayTeamScore.trim()
                };

                console.log("call bid add");
                $http( ADD_BID_POST(bidData) )
                .then(
                    function success(scoreData, status, response) {
                        $scope.saveCompleted = true;
                        $scope.games[index].scoreId = response.data;
                    },
                    function handleError(scope, response) {
                        $scope.requestErrorMsg = response.statusText;
                    }
                );
            }
        }

        $scope.changeBid = function(index) {
            console.log('changeBid('+index+') call.');
            if (isValidScore($scope.games[index])) {

                let bidData = {
                    cupId : chosenCupId,
                    userId : $rootScope.userId(),
                    scoreId : $scope.games[index].scoreId,
                    homeTeamScore : $scope.games[index].homeTeamScore.trim(),
                    awayTeamScore : $scope.games[index].awayTeamScore.trim()
                };

                console.log("call bid update");
                $http( CHANGE_BID_PUT(bidData) )
                .then(
                    function success(bidData, status) {
                        $scope.saveCompleted = true;
                    },
                    function handleError(scope, response) {
                        $scope.requestErrorMsg = response.statusText;
                    }
                );
            }
        }

    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }
});