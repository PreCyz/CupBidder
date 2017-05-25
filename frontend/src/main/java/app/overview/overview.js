mainAppModule.controller('overviewCtrl', function($rootScope, $scope, $http) {
    $http({
        method : "GET",
        url : "http://localhost:8080/api/cup"
    }).then(function mySuccess(response) {
        $scope.cups = response.data.cups;
    }, function myError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $rootScope.hideSignIn = true;
    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }

    $scope.showGame = false;
    $scope.showGames = function(index) {
        console.log('showGames() call. ' + index);
        $scope.showGame = true;
        $scope.games = $scope.cups[index].games;
    }

    $scope.hideGames = function() {
        console.log('hideGames() call.');
        $scope.showGame = false;
    }
});