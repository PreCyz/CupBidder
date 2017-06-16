const GAMES_ALL_GET = {
    method : "GET",
       url : BACKEND_HOST + "/api/game/all"
}

const GAMES_FOR_USER_GET = function(userId) {
    return {
        method : "GET",
           url : BACKEND_HOST + "/api/game/all/"+userId
    }
}

const SCORES_ALL_GET = {
    method : "GET",
       url : BACKEND_HOST + "/api/score/all"
}

const SCORES_FOR_USER_GET = function(userId) {
    return {
        method : "GET",
           url : BACKEND_HOST + "/api/score/all/"+userId
    }
}

const ADD_SCORE_POST = function(scoreData) {
    return {
        method : "POST",
           url : BACKEND_HOST + "/api/score/addScore",
          data : scoreData
    }
}

const CHANGE_SCORE_POST = function(scoreData) {
    return {
        method : "POST",
           url : BACKEND_HOST + "/api/score/changeScore",
          data : scoreData
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
    $rootScope.hideSignIn = true;
    $scope.showAddScore = true;
    $scope.halloMsg = $rootScope.halloMsg();
    $scope.isBidPath = $location.path() == '/bid';
    $scope.isAdmin = $rootScope.isAdmin();
    $scope.isBidder = $rootScope.isBidder();
    $scope.isGambler = $rootScope.isGambler();
    $scope.isWatcher = $rootScope.isWatcher();

    $http(GAMES_FOR_USER_GET($rootScope.userId()))
    .then(function success(response) {
        $scope.games = populateBids(response.data.games);
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
        console.log('changeScore('+index+') call.');
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