var GAMES_GET = {
    method : "GET",
       url : "http://localhost:8080/api/game/all"
}

mainAppModule.controller('BidController', function($rootScope, $scope, $http) {
    $rootScope.hideSignIn = true;

    $http(GAMES_GET)
    .then(function success(response) {
        $scope.games = response.data.games;
        for(var i = 0; i < $scope.games.length; i++) {
            $scope.games[i].changed = false;
        }
    }, function handleError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $scope.showAddScore = true;
    $scope.addScore = function(index) {
        console.log('addScore('+index+') call.');
        $scope.games[index].changed = true;
        //$scope.showAddScore = false;
    }
});