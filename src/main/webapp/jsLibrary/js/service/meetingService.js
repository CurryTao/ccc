app.service("meetingService", function ($http) {

    this.findMeetingListAll = function () {
        return $http.post("../meeting/findMeetingListAll");
    }
    this.findPage = function (currentPage, pageSize, meeting) {
        return $http.post("../meeting/getMeetingList?currentPage=" + currentPage + "&pageSize=" + pageSize, meeting);
    }
    this.findMeetingNoteByMeetingId = function (meetingNotes) {
        return $http.post("../meeting/getMeetingNoteList", meetingNotes);
    }
    this.findMeetingSheduleByMeetingId = function (meetingShedule) {
        return $http.post("../meeting/getMeetingSheduleList", meetingShedule);
    }
    this.addMeeting = function (meeting) {
        return $http.post("../meeting/addMeeting", meeting);
    }
    this.addMeetingNotes = function (meetingNotes) {
        return $http.post("../meeting/addMeetingNotes", meetingNotes);
    }
    this.addMeetingShedule = function (meetingShedule) {
        return $http.post("../meeting/addMeetingShedule", meetingShedule);
    }

})