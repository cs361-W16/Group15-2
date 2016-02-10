angular.module('AcesUp').directive('clickDrag', function($interval) {
    return {
        restrict: 'E',
        scope: {time: 0},
        link: function(scope, element, attrs) {
            var promise;

            scope.mouseDown = function() {
                promise = $interval(function() {
                    scope.Time = scope.Time + 1;
                }, 100);

                console.log("Mouse down");
            };

            scope.mouseUp = function() {
                $interval.cancel(promise);

                console.log("Mouse up");
            };
        }
    };
});
