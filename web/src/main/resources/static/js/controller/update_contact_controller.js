"use strict";

app.controller("updateContactController", ["$scope", "$window", "$location", "contactService", function($scope, $window, $location, contactService) {
    $scope.contact = { id: $location.search().id, name: $location.search().name, phone: $location.search().phone };
    $scope.messages = {};

    $scope.openIndexPage = function() {
        $window.location.href = "http://localhost:8080/";
    };

    $scope.update = function() {
        contactService.update($scope.contact).then(
            function (response) {
                $scope.messages = response.messages;

                if (Object.keys($scope.messages).length == 0) {
                    $scope.openIndexPage();
                }
            },
            function (errorResponse) {
            }
        );
    };
}]);