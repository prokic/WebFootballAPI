WebFootballAPI = angular.module('WebFootballAPI.service', []);

WebFootballAPI.service('LeagueService',function($http,$q){

    this.getLeaguee = function (id){
        var deferred = $q.defer();
    return $http.get("api/season/" + id)
        .then(function (response) {
        deferred.resolve(response.data);
        return deferred.promise;
          }, function (response) {
        deferred.reject(response);
        return deferred.promise;
    });
    };
});

WebFootballAPI.service('TeamsService',function($http,$q){

    this.getTeams = function (id){
        var deferred = $q.defer();
        return $http.get("api/teams/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('TeamService',function($http,$q){

    this.getTeam = function (id){
        var deferred = $q.defer();
        return $http.get("api/team/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('LeagueTableService',function($http,$q,TableResolve){

    this.getLeagueTable = function (id){
        var deferred = $q.defer();
        var getTable = TableResolve.get() ? "api/leaguetable/group/" : "api/leaguetable/" ;
        return $http.get(getTable +id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('PlayersService',function ($http, $q) {

    this.getPlayers = function (id) {
        var deferred = $q.defer();
        return $http.get("api/players/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    }
});
