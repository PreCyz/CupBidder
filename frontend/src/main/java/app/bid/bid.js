var GAMES_GET = {
    method : "GET",
       url : "http://localhost:8080/api/game/all"
}

mainAppModule.controller('BidController', function($rootScope, $scope, $http) {
    $rootScope.hideSignIn = true;

    $http(GAMES_GET)
    .then(function success(response) {
        $scope.games = response.data.games;
    }, function handleError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $scope.showAddScore = true;
    $scope.addScore = function(index) {
        console.log('addScore('+index+') call.');
        $scope.showAddScore = false;
    }
});