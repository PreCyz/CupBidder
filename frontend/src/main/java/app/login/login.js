mainAppModule.controller('loginCtrl', function($rootScope, $scope) {
    $rootScope.hideSignIn = true;

    $scope.email = 'enter email';
    $scope.password = '***';

    $scope.goToStartup = function() {
    console.log('goToStartup() call.')
        $rootScope.showSignIn();
    }

    $scope.login = function() {
        console.log("login() call.")
    }
});