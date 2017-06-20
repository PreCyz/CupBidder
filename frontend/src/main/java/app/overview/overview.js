const CUPS_GET = {
   method : "GET",
      url : BACKEND_HOST + "/api/cup"
}

const CHANGE_CUP_PUT = function(updateCupData) {
    return {
       method : 'PUT',
          url : BACKEND_HOST + '/api/cup',
       /*headers: {
           `'Content-Type': undefined
       },*/
         data : updateCupData
    };
}

mainAppModule.controller('OverviewController', function($rootScope, $scope, $http, $location) {
    $rootScope.hideSignIn = true;
    $scope.showAddScore = false;
    $scope.halloMsg = $rootScope.halloMsg();
    $scope.isOverviewPath = $location.path() == '/overview';
    $scope.isAdmin = $rootScope.isAdmin();

    $http(CUPS_GET)
    .then(function success(response) {
        $scope.cups = response.data.cups;
    }, function handleError(response) {
        $scope.requestErrorMsg = response.statusText;
    });

    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }

    $scope.showGame = false;
    $scope.showGames = function(index) {
        console.log('showGames('+index+') call.');
        $scope.showGame = true;
        $scope.games = $scope.cups[index].games;
        for (let i = 0; i < $scope.games.length; i++) {
            $scope.games[i].bidSet = true;
        }
    }

    $scope.hideGames = function() {
        console.log('hideGames() call.');
        $scope.showGame = false;
        $scope.showAddScore = false;
    }

    $scope.edit = false;
    $scope.editCup = function(index) {
        $scope.edit = true;
        $scope.cupNames = [];
        for (let i = 0; i < $scope.cups.length; i++) {
            $scope.cupNames.push($scope.cups[i].name);
        }
    }

    $scope.cancelEditing = function() {
        $scope.edit = false;
        $scope.cupNames = [];
    }

    $scope.changeCup = function(index) {
        $scope.edit = false;
        $scope.cups[index].name = $scope.cupNames[index];
        let chosenCupId = $scope.cups[index].id;
        let updateCupData = { cupId : chosenCupId, name : $scope.cups[index].name }
        $http( CHANGE_CUP_PUT(updateCupData) )
        .then(
            function success(updateCupData, status) {
                $scope.saveCompleted = true;
            },
            function handleError(scope, response) {
                $scope.requestErrorMsg = response.statusText;
            }
        );
    }

    $scope.disappear = function() {
        $scope.saveCompleted = false;
    }

});
