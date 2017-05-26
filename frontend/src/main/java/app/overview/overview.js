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
        console.log('showGames('+index+') call.');
        $scope.showGame = true;
        $scope.games = $scope.cups[index].games;
    }

    $scope.hideGames = function() {
        console.log('hideGames() call.');
        $scope.showGame = false;
    }

    $scope.edit = false;
    $scope.editCup = function(index) {
        $scope.edit = true;
        $scope.cupNames = [];
        for (var i = 0; i < $scope.cups.length; i++) {
            $scope.cupNames.push($scope.cups[i].name);
        }
    }

    $scope.saveCup = function(index) {
        $scope.edit = false;
        $scope.cups[index].name = $scope.cupNames[index];
        var cupId = $scope.cups[index].id;

        $http({
            method: 'POST',
            url: 'http://localhost:8080/api/cup/'+cupId+'/save',
            /*headers: {
                `'Content-Type': undefined
            },*/
            data: { id : cupId, name : $scope.cups[index].name }
            })
        .then(
            function(data, status) {
                $scope.saveCompleted = true;
            },
            function(data, status) {
                alert( "failure message: " + JSON.stringify({data: data}));
            }
        );
    }

    $scope.disappear = function() {
        $scope.saveCompleted = false;
    }

});
