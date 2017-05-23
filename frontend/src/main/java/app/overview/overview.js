mainAppModule.controller('overviewCtrl', function($rootScope, $scope) {
    $rootScope.hideSignIn = true;
    $scope.logout = function() {
        console.log('logout() call.')
        $rootScope.showSignIn();
    }
});