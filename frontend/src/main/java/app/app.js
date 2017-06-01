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

    $rootScope.halloMsg = function() {
        var userName = "No-Name user";
        if ($rootScope.user != null) {
            if (typeof $rootScope.user.nickname == 'undefined' || $rootScope.user.nickname == null) {
                userName = $rootScope.user.firstName + ' ' + $rootScope.user.lastName;
            } else {
                userName = $rootScope.user.nickname;
            }
        }
        return 'Hallo ' + userName;
    }

    $rootScope.isAdmin = function() {
        return $rootScope.user.type == 'Admin';
    }

    $rootScope.userId = function() {
            return $rootScope.user.id;
        }
});