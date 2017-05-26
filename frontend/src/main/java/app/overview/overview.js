var GET_CUPS = {
   method : "GET",
   url : "http://localhost:8080/api/cup"
}

function POST_CUP(updateCupData) {
    return {
       method: 'POST',
       url: 'http://localhost:8080/api/cup/'+updateCupData.id+'/save',
       /*headers: {
           `'Content-Type': undefined
       },*/
       data: updateCupData
    };
}

mainAppModule.controller('overviewCtrl', function($rootScope, $scope, $http) {
    $http(GET_CUPS).then(function success(response) {
        $scope.cups = response.data.cups;
    }, function handleError(scope, response) {
           scope.requestErrorMsg = response.statusText;
       }
    );

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

    $scope.cancelEditing = function() {
        $scope.edit = false;
        $scope.cupNames = [];
    }

    $scope.saveCup = function(index) {
        $scope.edit = false;
        $scope.cups[index].name = $scope.cupNames[index];
        var cupId = $scope.cups[index].id;
        var updateCupData = { id : cupId, name : $scope.cups[index].name }
        $http( POST_CUP(updateCupData) )
        .then(
            function success(updateCupData, status) {
                $scope.saveCompleted = true;
            },
            function handleError(scope, response) {
                scope.requestErrorMsg = response.statusText;
            }
        );
    }

    $scope.disappear = function() {
        $scope.saveCompleted = false;
    }

});
