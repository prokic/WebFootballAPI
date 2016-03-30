WebFootballAPI = angular.module('WebFootballAPI.routes', ['ngRoute']);

WebFootballAPI.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/html/home.html',
            controller : 'HomeController'
        })
        .when('/footballSeason',{
            templateUrl:'static/html/season/homeSeasons.html',
            controller: 'FootballController'
        })
        .when ('/footballSeason/:year', {
                templateUrl: 'static/html/season/league/homeLeagues.html',
                controller: 'FootballController'
        })
        .when ('/:id/fixtures',{
               templateUrl: 'static/html/season/league/fixtures/homeFixtures.html',
               controller : 'FootballController'
        })
        .when ('/season/:id/teams',{
            templateUrl: 'static/html/season/league/teams/homeTeams.html',
            controller : 'TeamController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);