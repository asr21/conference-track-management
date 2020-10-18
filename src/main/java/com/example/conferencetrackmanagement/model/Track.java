/**
 * 
 */
package com.example.conferencetrackmanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.conferencetrackmanagement.config.TrackConfig;

/**
 * @author abhijit
 *
 */
public class Track {

	List<TalkSession> talkSessions;

	List<NonTalkSession> nonTalkSessions;

	long freeTime;
	public Track() {
		talkSessions = TrackConfig.getTalkSessionList();
		nonTalkSessions = TrackConfig.getNonTalkSessionList();
		freeTime = TrackConfig.TOTAL_TALK_SESSION_TIME_IN_MINUTES;
	}
	
	public boolean addTalk(Talk talk) {
		TalkSession talkSession = findTalkSessionWithEnoughFreeTime(talk.durationInMinutes);
		if(talkSession==null) {
			return false;
		}
		talkSession.addTalk(talk);
		freeTime=freeTime - talk.durationInMinutes;
		return true;
	}
	
	private TalkSession findTalkSessionWithEnoughFreeTime(int time) {
		TalkSession talkSession = null;
		for(TalkSession session : talkSessions) {
			if(session.timeLeft >=time) {
				return session;
				
			}
		}
		return talkSession;
	}
	
	public void removeTalk(Talk talk) {
		//for(TalkSession talkSession : talkSessions) {
		//	if(talkSession.)
		//}
	}
	
	public List<Talk> getTalks() {
		List<Talk> talk = new ArrayList<>();
		for(TalkSession ts: talkSessions) {
			talk.addAll(ts.getTalks());
		}
		return talk;
	}
	
	public long getFreeTime() {
		return freeTime;
	}
	
	public List<Session> getOrderedSessionList() {
		List<Session> session = new ArrayList<>();
		session.addAll(nonTalkSessions);
		session.addAll(talkSessions);
		Collections.sort(session);
		return session;
	}
}

