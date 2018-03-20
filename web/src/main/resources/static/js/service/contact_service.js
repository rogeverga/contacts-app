"use strict";

app.factory("contactService", ["$http", "$q", function($http, $q) {
    var REST_API_URL = "http://localhost:8080/rest/";

    return {
        delete: function (id) {
            return $http.delete(REST_API_URL + "contact/" + id).
                then(
                    function (response) {
                        return response.data;
                    },
                    function (errorResponse) {
                        return $q.reject(errorResponse);
                    }
                );
        },
        getAllContacts: function () {
            return $http.get(REST_API_URL + "getAllContacts").
                then(
                    function (response) {
                        return response.data.domains;
                    },
                    function (errorResponse) {
                        return $q.reject(errorResponse);
                    }
                );
        },
        insert: function (contact) {
            return $http.post(REST_API_URL + "contact", contact).
                then(
                    function (response) {
                        return response.data;
                    },
                    function (errorResponse) {
                        return $q.reject(errorResponse);
                    }
                );
        },
        update: function (contact) {
            return $http.put(REST_API_URL + "contact", contact).
            then(
                function (response) {
                    return response.data;
                },
                function (errorResponse) {
                    return $q.reject(errorResponse);
                }
            );
        }
    }
}]);