package com.github.xuexi.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Progress {
	private int currentScore;
	private int scoreLimit;
	
	public Progress(int currentScore, int scoreLimit) {
		this.currentScore = currentScore;
		this.scoreLimit = scoreLimit;
	}
	
	public Progress(String progressText) {
		String[] strs = progressText.split("/");
		
		String reg = "^.*(\\d+)分$";
		Pattern pattern = Pattern.compile(reg);
		
		Matcher currentScoreMatcher = pattern.matcher(strs[0]);
		while(currentScoreMatcher.find()) {
			currentScore = Integer.valueOf(currentScoreMatcher.group(1));
		}
		Matcher scoreLimitMatcher = pattern.matcher(strs[1]);
		while(scoreLimitMatcher.find()) {
			scoreLimit = Integer.valueOf(scoreLimitMatcher.group(1));
		}
	}
	
	public int toDoNumber() {
		return scoreLimit - currentScore;
	}
	
	public boolean finished() {
		return currentScore == scoreLimit;
	}
	
	public boolean beginning() {
		return currentScore > 0;
	}
}
