var gamesApp = angular.module('gamesApp', [
   'ngRoute',
   'gamesAppControllers'
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

gamesAppControllers.controller('gamesDataCtr', function ($scope) {
  $scope.games = [
    {'name': 'Game 1',
      'id' : 'game_1'},
    {'name': 'Game 2',
     'id' : 'game_2'}
  ];

  $scope.users = [
      {'name': 'KamilJ',
       'points' : -2354},
      {'name': 'TomaszL',
       'points' : 100},
      {'name': 'MichalO',
       'points' : 20}
    ];
});