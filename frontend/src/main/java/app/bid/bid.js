var GAMES_GET = {
    method : "GET",
       url : "http://localhost:8080/api/game/all"
}

var isValid = function(score) {
    if (typeof score == 'undefined') {
        return false;
    }
    score = score.trim();
    return score != '' && isFinite(score);
}

mainAppModule.controller('BidController', function($rootScope, $scope, $http) {
    $rootScope.hideSignIn = true;
    $scope.showAddScore = true;

    $http(GAMES_GET)
    .then(function success(response) {
        $scope.games = response.data.games;
        for(var i = 0; i < $scope.games.length; i++) {
            $scope.games[i].bidSet = false;
            if($scope.games[i].homeTeamScore >= 0 && $scope.games[i].awayTeamScore >= 0) {
                $scope.games[i].bidSet = true;
            }
        }
    }, function handleError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $scope.addScore = function(index) {
        console.log('addScore('+index+') call.');
        $scope.games[index].bidSet = true;
        $scope.games[index].wrongBidMsg = '';

        var homeScore = '';
        var awayScore = '';
        homeScore = $scope.games[index].homeTeamScore;
        awayScore = $scope.games[index].awayTeamScore;

        if (!isValid(homeScore)) {
            $scope.games[index].wrongBidMsg = "Home team score should contain only numbers.";
            $scope.games[index].bidSet = false;
        }

        if (!isValid(awayScore)) {
            $scope.games[index].wrongBidMsg = "Away team score should contain only numbers.";
            $scope.games[index].bidSet = false;
        }
        if ($scope.games[index].bidSet) {
            $scope.games[index].homeTeamScore = homeScore.trim();
            $scope.games[index].awayTeamScore = awayScore.trim();
            //do post to backend here
        }
    }

    $scope.changeScore = function(index) {
        console.log('changeBid('+index+') call.');
        $scope.games[index].bidSet = false;
    }

    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }
});