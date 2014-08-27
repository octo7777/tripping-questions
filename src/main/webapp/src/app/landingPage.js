var gamesApp = angular.module('gamesApp', [
   'ngRoute',
   'gamesAppControllers',
   'usersService'
]);

gamesApp.config(['$routeProvider',
           function($routeProvider) {
             $routeProvider.
               when('/', {
                 templateUrl: 'landingPage.html',
                 controller: 'gamesDataCtr'
               }).
               when('/game_1/', {
                 templateUrl: 'game_1.html',
                 //controller: ''
               }).
               otherwise({
                 redirectTo: 'error.html'
               });
           }]);


var gamesAppControllers = angular.module('gamesAppControllers', []);

gamesAppControllers.controller('gamesDataCtr', ['$scope', 'Users', function($scope, Users) {
  $scope.games = [
    {'name': 'Game 1',
      'id' : 'game_1'},
    {'name': 'Game 2',
     'id' : 'game_2'}
  ];

  $scope.users = Users.query()
//  $scope.users = [
//      {'name': 'KamilJ',
//       'points' : -2354},
//      {'name': 'TomaszL',
//       'points' : 100},
//      {'name': 'MichalO',
//       'points' : 20}
//    ];
}]);

var usersService = angular.module('usersService', ['ngResource']);

usersService.factory('Users', ['$resource',
  function($resource){
    return $resource('services/users', {}, {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);