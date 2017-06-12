var GAMES_ALL_GET = {
    method : "GET",
       url : "http://localhost:8080/api/game/all"
}

var GAMES_FOR_USER_GET = function(userId) {
    method : "GET",
       url : "http://localhost:8080/api/game/all/"+userId
}

var SCORES_ALL_GET = {
    method : "GET",
       url : "http://localhost:8080/api/game/all"
}

var SCORES_FOR_USER_GET = function(userId) {
    method : "GET",
       url : "http://localhost:8080/api/score/all/"+userId
}

var ADD_SCORE_POST = function(scoreData) {
    return {
        method : "POST",
           url : "http://localhost:8080/api/score/addScore",
          data : scoreData
    }
}

var CHANGE_SCORE_POST = function(scoreData) {
    return {
        method : "POST",
           url : "http://localhost:8080/api/score/changeScore",
          data : scoreData
    }
}

var isValidScore = function(score) {
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

var isValid = function(score) {
    if (typeof score == 'undefined') {
        return false;
    }
    score = score.trim();
    return score != '' && isFinite(score);
}

mainAppModule.controller('BidController', function($rootScope, $scope, $http, $location) {
    $rootScope.hideSignIn = true;
    $scope.showAddScore = true;
    $scope.halloMsg = $rootScope.halloMsg();
    $scope.isBidPath = $location.path() == '/bid';
    $scope.isAdmin = $rootScope.isAdmin();

    $http(GAMES_ALL_GET)
    .then(function success(response) {
        $scope.games = response.data.games;
        for (let i = 0; i < $scope.games.length; i++) {
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
        if (isValidScore($scope.games[index])) {

            let scoreData = {
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
        console.log('changeBid('+index+') call.');
        if (isValidScore($scope.games[index])) {

            let scoreData = {
                userId : $rootScope.userId(),
                scoreId : $scope.games[index].scoreId,
                homeTeamScore : $scope.games[index].homeTeamScore.trim(),
                awayTeamScore : $scope.games[index].awayTeamScore.trim()
            };

            console.log("call score update");
            $http( CHANGE_SCORE_POST(scoreData) )
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

    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }
});