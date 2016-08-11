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

WebFootballAPI.service('TeamService',function($http,$q){

    this.getTeams = function (id){
        var deferred = $q.defer();
        return $http.get("api/fixtures/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});