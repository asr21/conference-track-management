/**
 * 
 */
package com.example.conferencetrackmanagement.output;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.conferencetrackmanagement.model.Conference;
import com.example.conferencetrackmanagement.model.Session;
import com.example.conferencetrackmanagement.model.Talk;
import com.example.conferencetrackmanagement.model.TalkSession;
import com.example.conferencetrackmanagement.model.Track;

/**
 * @author abhijit
 *
 */
public class OutputPrinter {
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mma");
	
	public void print(Conference conference) {
		for(int i=0;i< conference.getTracks().size();i++) {
			System.out.println("Track "+ (i+1));
			Track track = conference.getTracks().get(i);
			printTrack(track);
			System.out.println();
		}	
		
	}

	public void printTrack(Track track) {
		List<Session> sessionList = track.getOrderedSessionList();
		for(Session session : sessionList) {
			if(session instanceof TalkSession) {
				printTalkSession((TalkSession) session);
			} else {
				printNonTalkSession(session);
			}
		}
		
	}

	private void printTalkSession(TalkSession session) {
		List<Talk> talks = session.getTalks();
		for(Talk talk : talks) {
			System.out.println(talk.getStartTime().format(format) + " " + talk.getTalkTitle() + " " + talk.getDurationInMinutes()+ "min");
		}
	}

	private void printNonTalkSession(Session session) {
		System.out.println(session.getStartTime().format(format) + " " + session.getSessionName());
	}
}
