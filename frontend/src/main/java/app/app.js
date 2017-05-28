var mainAppModule = angular.module('mainApp', ['ngRoute']);

mainAppModule.config(function($routeProvider) {
  $routeProvider
  .when('/login', {
    templateUrl: 'login/login.html',
    controller: 'LoginController'
  })
  .when('/overview', {
    templateUrl: 'overview/overview.html',
    controller: 'OverviewController'
  })
  .when('/bid', {
    templateUrl: 'bid/bid.html',
    controller: 'BidController'
  })
  .otherwise({redirectTo : '/'});
});

mainAppModule.controller('MainAppController', function($rootScope, $location) {
    $rootScope.myUrl = $location.absUrl();
    $rootScope.hideSignIn = false;
    $rootScope.user = null;

    $rootScope.showSignIn = function() {
        console.log('showSignIn() call.')
        $rootScope.hideSignIn = false;
        $rootScope.user = null;
    }

    $rootScope.loggedUser = function() {
        if ($rootScope.user != null) {
            if (typeof $rootScope.user.nickname == 'undefined' || $rootScope.user.nickname == null) {
                return $rootScope.user.firstName + ' ' + $rootScope.user.lastName;
            }
            return $rootScope.user.nickname;
        }
        return "No-Name user";
    }
});