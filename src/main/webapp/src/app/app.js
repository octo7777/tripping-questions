var gamesApp = angular.module('gamesApp', [
   'ngRoute',
   'gamesAppControllers',
   'game1Controller',
   'usersService',
   'ui.bootstrap'
]);

function DropdownCtrl($scope) {
  $scope.items = [
    'The first choice!',
    'And another choice for you.',
    'but wait! A third!'
  ];

  $scope.status = {
    isopen: false
  };

  $scope.toggled = function(open) {
    console.log('Dropdown is now: ', open);
  };

  $scope.toggleDropdown = function($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.status.isopen = !$scope.status.isopen;
  };
}

gamesApp.config(['$routeProvider',
           function($routeProvider) {
             $routeProvider.
               when('/', {
                 templateUrl: 'landingPage.html',
                 controller: 'landingPageCtr'
               }).
               when('/game_1/', {
                 templateUrl: 'game_1.html',
                 controller: 'game1Controller'
               }).
               when('/createUser/', {
                 templateUrl: 'createUser.html',
                 controller: 'createUserCtr'
               }).
               otherwise({
                 redirectTo: 'error.html'
               });
           }]);


var gamesAppControllers = angular.module('gamesAppControllers', []);

gamesAppControllers.controller('landingPageCtr', ['$scope', '$http', 'Users', function($scope, $http, Users) {
  $scope.currentUser = {isLogged : false, isAdmin : false};
  $scope.games = [
    {'name': 'Game 1',
      'id' : 'game_1'},
    {'name': 'Game 2',
     'id' : 'game_2'}
  ];
  $scope.users = Users.query()

  $scope.submitLoginUser = function() {
    var user = $scope.fields.user;
    var password = $scope.fields.password;
    $http.post('login', {'username': user, 'password': password}).
      success(function(data, status, headers, config) {
        $scope.currentUser.isLogged = true;
        $scope.currentUser.email = $scope.fields.user;
      }).
      error(function(data, status, headers, config) {

      });
  }


}]);

gamesAppControllers.controller('createUserCtr', ['$scope', '$http', function($scope, $http) {
    $scope.list = [];
    $scope.submitCreateUser = function() {
        var data=$scope.fields;
        $http.post('services/users', data);
    }
}]);



var game1Controller = angular.module('game1Controller', []);

game1Controller.controller('game1Controller', ['$scope', '$http', 'Questions', function($scope, $http, Questions) {
  $scope.users = Questions.query()
}]);



var usersService = angular.module('usersService', ['ngResource']);

usersService.factory('Users', ['$resource',
  function($resource){
    return $resource('services/users', {}, {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);

usersService.factory('Questions', ['$resource',
  function($resource){
    return $resource('services/questions/game_1', {}, {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);