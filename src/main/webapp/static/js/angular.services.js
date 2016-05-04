WebFootballAPI = angular.module('WebFootballAPI.service', []);

WebFootballAPI.service('LeagueService',function($http,$q){

    //this.getLeaguee = function (id){
    //   return $http.get("api/season/" + id);
    //};
    var deferred = $q.defer();

    this.getLeaguee = function (id){
    return $http.get("api/season/" + id)
        .then(function (response) {
        // promise is fulfilled
        deferred.resolve(response.data);
        // promise is returned
        return deferred.promise;
          }, function (response) {
        // the following line rejects the promise
        deferred.reject(response);
        // promise is returned
        return deferred.promise;
    });
    };
});