var mainAppModule = angular.module('mainApp', ['ngRoute']);

mainAppModule.config(['$routeProvider', function($routeProvider) {
  $routeProvider
  .when('/login', {
    templateUrl: 'login/login.html',
    controller: 'loginCtrl'
  })
  .when('/overview', {
    templateUrl: 'overview/overview.html',
    controller: 'overviewCtrl'
  })
  .otherwise({redirectTo : '/'});
}]);

mainAppModule.controller('mainAppCtrl', function($rootScope, $location) {
    $rootScope.myUrl = $location.absUrl();
    $rootScope.hideSignIn = false;
    $rootScope.showSignIn = function() {
        console.log('showSignIn() call.')
        $rootScope.hideSignIn = false;
    }
});