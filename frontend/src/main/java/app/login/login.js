mainAppModule.controller('LoginController', function($rootScope, $scope) {
    $rootScope.hideSignIn = true;

    $scope.email = 'sample@email.com';
    $scope.password = 'qqq';

    $scope.goToStartup = function() {
    console.log('goToStartup() call.')
        $rootScope.showSignIn();
    }

    $scope.login = function() {
        console.log("login() call.")
    }
});