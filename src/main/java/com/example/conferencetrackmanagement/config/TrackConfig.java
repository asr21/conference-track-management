package com.example.conferencetrackmanagement.config;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.example.conferencetrackmanagement.model.NonTalkSession;
import com.example.conferencetrackmanagement.model.TalkSession;

public class TrackConfig {
	
	public static final long TOTAL_TALK_SESSION_TIME_IN_MINUTES=360;
	public static final long LIGHTNING_MINUTES=5;
	
	public static List<TalkSession> getTalkSessionList() {
		List<TalkSession> sessionList = new ArrayList<>();
		TalkSession session1 = new TalkSession("Morning Session",LocalTime.of(9, 0), LocalTime.of(12, 0));
		TalkSession session3 = new TalkSession("Afternoon Session",LocalTime.of(13, 0), LocalTime.of(16, 0));
		sessionList.add(session1);
		sessionList.add(session3);
		return sessionList;
	}
	 
	public static List<NonTalkSession> getNonTalkSessionList() {
		List<NonTalkSession> sessionList = new ArrayList<>();
		NonTalkSession session2 = new NonTalkSession("Lunch Session",LocalTime.of(12, 0), LocalTime.of(13, 0));
		NonTalkSession session4 = new NonTalkSession("Networking Event",LocalTime.of(16, 0), LocalTime.of(17, 0));
		sessionList.add(session2);
		sessionList.add(session4);
		return sessionList;
	}
}
