app.service('uploadService', function ($http) {
    this.uploadMeeingPoster = function () {
        var formdata = new FormData();
        formdata.append('uploadMeeingPoster', uploadMeeingPoster.files[0]);
        return $http({
            method: 'post',
            url: '../file/uploadMeeingPoster',
            data: formdata,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        });
    }
    this.uploadMeeingShedule = function (mid) {
        var formdata = new FormData();
        formdata.append('meeingSheduleList', meetingSheduleListFile.files[0]);
        return $http({
            method: 'post',
            url: '../file/uploadMeeingShedule?mid=' + mid,
            data: formdata,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        });
    }
});