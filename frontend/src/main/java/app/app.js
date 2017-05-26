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
    $rootScope.showSignIn = function() {
        console.log('showSignIn() call.')
        $rootScope.hideSignIn = false;
    }
});