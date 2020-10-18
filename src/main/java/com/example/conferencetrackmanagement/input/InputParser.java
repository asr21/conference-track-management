package com.example.conferencetrackmanagement.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.conferencetrackmanagement.model.Talk;

public class InputParser {
	
	public List<Talk> parse(String filePath) throws IOException {
		List<String> stringList = getParsedStringListFromFile(filePath);
		List<Talk> talkList = parseStringList(stringList);
		return talkList;
	}

	private List<String> getParsedStringListFromFile(String filePath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String readLine = bufferedReader.readLine();
		List<String> stringList = new ArrayList<>();
		while (readLine != null && readLine.trim().length() > 0) {
			stringList.add(readLine.trim());
			readLine = bufferedReader.readLine();
		}
		bufferedReader.close();
		return stringList;
	}

	private List<Talk> parseStringList(List<String> stringList) {
		List<Talk> talkList = new ArrayList<>();
		for(String string : stringList) {
			talkList.add(new Talk(string));
		}
		return talkList;
	}
	
	public static void main(String args[]) throws IOException {
		InputParser ip = new InputParser();
		List<Talk> talks = ip.parse("src/main/resources/input.txt");
		System.out.println(talks);
	}
}
