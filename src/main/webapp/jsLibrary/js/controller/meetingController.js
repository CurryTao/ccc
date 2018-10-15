app.controller("meetingController", function ($scope, $controller, meetingService, addressService, uploadService) {

    $controller('baseController', {$scope: $scope});

    $scope.meeting = {poster: '', areasid: '', chargepersonTelFixed: ''}
    $scope.addressList = [];

    //分页模糊列表
    $scope.findPage = function (currentPage, pageSize, searchEntity) {
        meetingService.findPage(currentPage, pageSize, searchEntity).success(
            function (resp) {
                $scope.entityList = resp.rows;
                $scope.myPage.totalItems = resp.total;
            });
        addressService.findAreasAll().success(
            function (resp) {
                for (var i = 0; i < resp.length; i++) {
                    $scope.addressList[resp[i].areaid] = resp[i].area;
                }
            });
    };

    //初始化三级联动
    $scope.initAddress = function () {
        addressService.findProvincesAll().success(
            function (resp) {
                $scope.provinces = resp;
            });
        addressService.findCitieAll().success(
            function (resp) {
                $scope.cities = resp;
            });
        addressService.findAreasAll().success(
            function (resp) {
                $scope.areas = resp;
            });
    };

    //更换省份
    $scope.changeProvince = function () {
        console.info("changeProvince");
        addressService.findCities($scope.areasid1).success(
            function (resp) {
                $scope.cities = resp;
            });
    };
    //更换县市
    $scope.changeCity = function () {
        console.info("changeCity");
        addressService.findAreas($scope.areasid2).success(
            function (resp) {
                $scope.areas = resp;
            });
    };

    //上传图片
    $scope.upload = function () {
        uploadService.uploadFile().success(
            function (resp) {
                if (resp.status) {
                    $scope.meeting.poster = resp.data;
                } else {
                    alert(resp.msg);
                }
            });
    };

    //会议添加方法
    $scope.addMeeting = function () {
        console.info($scope.meeting.chargepersonTelFixed);
        meetingService.addMeeting($scope.meeting).success(function (resp) {
            if (resp.status) {
                alert('会议添加成功');
                window.location.href = "会议管理.html";
            } else {
                alert(resp.msg);
            }
        });
    };

    //初始化会议列表
    $scope.initMeetingList = function () {
        meetingService.findMeetingListAll().success(
            function (resp) {
                $scope.meetingList = resp.rows;
            });
    };

    //更换选中的会议更换列表,刷新会议配置
    $scope.searchMeetingEntity = {mid: ''};
    $scope.sellectMeetingId = '';
    $scope.changeMeeting = function () {
        $scope.searchMeetingEntity.mid = $scope.sellectMeetingId;
        meetingService.findMeetingNoteByMeetingId($scope.searchMeetingEntity).success(
            function (resp) {
                $scope.noteList = resp.rows;
            });
        meetingService.findMeetingSheduleByMeetingId($scope.searchMeetingEntity).success(
            function (resp) {
                $scope.sheduleList = resp.rows;
            });
    };

    //会议须知添加方法
    $scope.meetingNotes = {mid: '', trafficontes: '', meetingcontes: ''};
    $scope.addMeetingNotes = function () {
        $scope.meetingNotes.mid = $scope.sellectMeetingId;
        console.info($scope.meetingNotes);
        meetingService.addMeetingNotes($scope.meetingNotes).success(function (resp) {
            if (resp.status) {
                alert('会议须知添加成功');
                window.location.reload();
            } else {
                alert(resp.msg);
            }
        });
    };

    //会议日程添加方法
    $scope.meetingShedule = {mid: ''}
    $scope.addMeetingShedule = function () {
        $scope.meetingShedule.mid = $scope.sellectMeetingId;
        meetingService.addMeetingShedule($scope.meetingShedule).success(function (resp) {
            if (resp.status) {
                alert('会议日程添加成功');
                window.location.reload();
            } else {
                alert(resp.msg);
            }
        });
    };

    //会议宣传图上传
    $scope.uploadMeeingPoster = function () {
        uploadService.uploadMeeingPoster().success(function (resp) {
            if (resp.status) {
                console.info(resp.data);
                $scope.meeting.poster = resp.data;
            } else {
                alert(resp.msg);
            }
        });
    };

    //会议日程导入
    $scope.templateImport = function () {
        console.info("会议日程导入");
        if ($scope.sellectMeetingId == '') {
            alert("请选择会议");
        } else {
            uploadService.uploadMeeingShedule($scope.sellectMeetingId).success(function (resp) {
                if (resp.status) {
                    alert("导入成功");
                    window.location.reload();
                } else {
                    alert(resp.msg);
                }
            });
        }
    };

    //点击显示回显会议
    $scope.findOne = function (id) {

    }

    //批量删除会议
    $scope.del = function () {
        meetingService.del($scope.selectIds).success(function (resp) {
            if (resp.status) {
                alert("删除成功");
                $scope.reloadList();
            } else {
                alert("删除失败");
            }
        });
    }

});