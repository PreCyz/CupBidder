const LOGIN_USER_POST = function(email, password) {
    return {
        method : "POST",
           url : BACKEND_HOST + "/api/user/login",
          data : { email : email, password : password}
    }
}

mainAppModule.controller('LoginController', function($rootScope, $scope, $http, $location) {
    $rootScope.hideSignIn = true;

    $scope.email = 'admin@cup.com';
    $scope.password = 'qqq';

    $scope.goToStartup = function() {
    console.log('goToStartup() call.')
        $rootScope.showSignIn();
    }

    $scope.login = function() {
        $scope.error = false;
        console.log("login() call.")
        $http(LOGIN_USER_POST($scope.email, $scope.password))
        .then(function success(response) {
            $rootScope.user = response.data;
            if (typeof $rootScope.user == 'undefined' || $rootScope.user == null || $rootScope.user == '') {
                $scope.error = true;
                $scope.requestErrorMsg = 'There is no user with email \'' + $scope.email + '\'.';
            } else {
                if ($rootScope.isAdmin()) {
                    $location.path('/overview');
                } else {
                    $location.path('/bid');
                }
            }
        }, function handleError(response) {
            $scope.error = true;
            $scope.requestErrorMsg = response.statusText;
        });
    }
});