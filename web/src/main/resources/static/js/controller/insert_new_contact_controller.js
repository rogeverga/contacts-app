"use strict";

app.controller("insertNewContactController", ["$scope", "$window", "contactService", function($scope, $window, contactService) {
    $scope.contact = {};
    $scope.messages = {};

    $scope.insert = function() {
        contactService.insert($scope.contact).then(
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

    $scope.openIndexPage = function() {
        $window.location.href = "http://localhost:8080/";
    };
}]);